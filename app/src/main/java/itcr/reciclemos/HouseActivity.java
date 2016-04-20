package itcr.reciclemos;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import java.util.Random;

import itcr.reciclemos.gameengine.ElementController;
import itcr.reciclemos.gameengine.ThrashType;

public class HouseActivity extends AppCompatActivity {

    //-- GUI Elements ---------------------
    private ImageView blueTrashCanImg;
    private ImageView greenTrashCanImg;
    private ImageView yellowTrashCanImg;
    private ImageView grayTrashCanImg;
    private ImageView blackTrashCanImg;

    ElementController controller;
    RelativeLayout relativeLayout;
    Utilities toolBox = Utilities.getSingleton();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_house);

        relativeLayout = (RelativeLayout) findViewById(R.id.house_layout);
        controller = new ElementController();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        //-- Link the GUI Elements ------------
        blueTrashCanImg = (ImageView) findViewById(R.id.blue_trashCan_img);
        greenTrashCanImg = (ImageView) findViewById(R.id.green_trashCan_img);
        yellowTrashCanImg = (ImageView) findViewById(R.id.yellow_trashCan_img);
        grayTrashCanImg = (ImageView) findViewById(R.id.gray_trashCan_img);
        blackTrashCanImg = (ImageView) findViewById(R.id.black_trashCan_img);

        controller.createThrashCan(blueTrashCanImg, ThrashType.BLUE);
        controller.createThrashCan(greenTrashCanImg, ThrashType.GREEN);
        controller.createThrashCan(yellowTrashCanImg, ThrashType.YELLOW);
        controller.createThrashCan(grayTrashCanImg, ThrashType.GRAY);
        controller.createThrashCan(blackTrashCanImg, ThrashType.BLACK);

        blueTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_HOUSE_BLUE_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        greenTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_HOUSE_GREEN_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        yellowTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_HOUSE_YELLOW_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        grayTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_HOUSE_GRAY_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        blackTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_HOUSE_BLACK_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));


        ImageView iv;

        //------------- Pasar a utilities luego ---------------------
        int MAX_TRASH_HOUSE = 3;

        Random r = new Random();
        int trashQuantity = r.nextInt(MAX_TRASH_HOUSE) + 1;
        //Point trashLocations[] = new Point[];     //Conserva las coordenadas donde se genero para no repetir


        int trashNumber;
        Point coords;
        for (ThrashType trashTypes : ThrashType.values()) {
            if(trashTypes != ThrashType.RED && trashTypes != ThrashType.PURPLE){
                for(int i = 0; i < trashQuantity; i++){
                    iv = new ImageView(this);
                    if(trashTypes == ThrashType.BLUE) {
                        trashNumber = r.nextInt(toolBox.INTEGER_BLUE_ALL_DRAWABLE.length);
                        iv.setImageResource(toolBox.INTEGER_BLUE_ALL_DRAWABLE[trashNumber]);
                    }
                    else if(trashTypes == ThrashType.GREEN) {
                        trashNumber = r.nextInt(toolBox.INTEGER_GREEN_ALL_DRAWABLE.length);
                        iv.setImageResource(toolBox.INTEGER_GREEN_ALL_DRAWABLE[trashNumber]);
                    }
                    else if(trashTypes == ThrashType.YELLOW) {
                        trashNumber = r.nextInt(toolBox.INTEGER_YELLOW_ALL_DRAWABLE.length);
                        iv.setImageResource(toolBox.INTEGER_YELLOW_ALL_DRAWABLE[trashNumber]);
                    }
                    else if(trashTypes == ThrashType.GRAY) {
                        trashNumber = r.nextInt(toolBox.INTEGER_GRAY_ALL_DRAWABLE.length);
                        iv.setImageResource(toolBox.INTEGER_GRAY_ALL_DRAWABLE[trashNumber]);
                    }
                    else if(trashTypes == ThrashType.BLACK) {
                        trashNumber = r.nextInt(toolBox.INTEGER_BLACK_ALL_DRAWABLE.length);
                        iv.setImageResource(toolBox.INTEGER_BLACK_ALL_DRAWABLE[trashNumber]);
                    }

                    coords = new Point(r.nextInt(toolBox.POINT_BACKGROUND.x)-toolBox.POINT_D_ALL_THRASH.x+1, r.nextInt(toolBox.POINT_BACKGROUND.y-toolBox.POINT_C_ALL_PLAYABLE_TOP-toolBox.POINT_C_ALL_PLAYABLE_BOTTOM)+toolBox.POINT_C_ALL_PLAYABLE_BOTTOM);

                    iv.setLayoutParams(toolBox.positionImage(coords, toolBox.POINT_D_ALL_THRASH));
                    relativeLayout.addView(iv);
                    controller.createThrash(iv, trashTypes);
                }
                trashQuantity = r.nextInt(MAX_TRASH_HOUSE) + 1;
            }
        }

        //Toast.makeText(getApplicationContext(), "Cantidad en el controller: " + controller.getAllTrash().size(), Toast.LENGTH_SHORT).show();
    }
}
