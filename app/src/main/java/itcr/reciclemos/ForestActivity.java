package itcr.reciclemos;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import itcr.reciclemos.gameengine.ElementController;

public class ForestActivity extends AppCompatActivity {

    //-- GUI Elements ---------------------
    private ImageView blueTrashCanImg;
    private ImageView greenTrashCanImg;
    private ImageView yellowTrashCanImg;
    private ImageView grayTrashCanImg;
    private ImageView redTrashCanImg;
    private ImageView purpleTrashCanImg;
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
        setContentView(R.layout.activity_forest);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

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
        redTrashCanImg = (ImageView) findViewById(R.id.red_trashCan_img);
        purpleTrashCanImg = (ImageView) findViewById(R.id.purple_trashCan_img);
        blackTrashCanImg = (ImageView) findViewById(R.id.black_trashCan_img);

        blueTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_BLUE_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        greenTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_GREEN_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        yellowTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_YELLOW_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        grayTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_GRAY_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        redTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_RED_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        purpleTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_PURPLE_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        blackTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_BLACK_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));

    }
}
