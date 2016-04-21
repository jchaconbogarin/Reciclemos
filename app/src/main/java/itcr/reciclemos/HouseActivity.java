package itcr.reciclemos;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import java.util.List;
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
    private final int MAX_THRASH = 3;
    ThrashType[] THRASH_TYPES = { ThrashType.BLUE, ThrashType.GREEN, ThrashType.YELLOW, ThrashType.GRAY, ThrashType.BLACK };

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
                goBack();
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

        List<ImageView> ivs = controller.createAllThrash(this, MAX_THRASH, THRASH_TYPES);

        for (ImageView iv : ivs) {
            relativeLayout.addView(iv);
        }

        GameTicker gameTicker = new GameTicker(toolBox.INT_MILLISECONDS_HOUSE_TIMER, 1000, 1000) {
            ProgressBar gameProgressBar = (ProgressBar) findViewById(R.id.progressBar);
            int progressInit = 100;
            int progressRate = progressInit / (toolBox.INT_MILLISECONDS_HOUSE_TIMER/1000);

            @Override
            public void onTick(long timeLeft) {
                progressInit -= progressRate;
                gameProgressBar.setProgress(progressInit);
            }

            @Override
            public void onFinished() {
                onTick(0);
                //CHECK GAME STATUS AND SHOW MESSAGE
            }
        };
        gameTicker.start();
    }

    public void onBackPressed(){
        goBack();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                goBack();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void goBack(){
        Intent resultIntent = new Intent();
        //Si no gano enviar STR_CODE_ALL_LEVEL
        resultIntent.putExtra(toolBox.STR_ENABLE_ALL_LEVEL, toolBox.STR_CODE_LAKE_LEVEL);
        setResult(RESULT_OK, resultIntent);
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
