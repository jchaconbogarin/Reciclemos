package itcr.reciclemos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import itcr.reciclemos.gameengine.ElementController;
import itcr.reciclemos.gameengine.ThrashType;

public class ForestActivity extends GameActivity {

    //-- GUI Elements ---------------------
    private ImageView blueTrashCanImg;
    private ImageView greenTrashCanImg;
    private ImageView yellowTrashCanImg;
    private ImageView grayTrashCanImg;
    private ImageView redTrashCanImg;
    private ImageView purpleTrashCanImg;
    private ImageView blackTrashCanImg;
    AlertDialog.Builder alertDialogBuilder;

    ElementController controller;
    RelativeLayout relativeLayout;
    Utilities toolBox = Utilities.getSingleton();
    private final int MAX_THRASH = 3;
    ThrashType[] THRASH_TYPES = { ThrashType.BLUE, ThrashType.GREEN, ThrashType.YELLOW, ThrashType.GRAY, ThrashType.RED, ThrashType.PURPLE, ThrashType.BLACK };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_forest);

        relativeLayout = (RelativeLayout) findViewById(R.id.forest_layout);
        controller = new ElementController(this);

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
        redTrashCanImg = (ImageView) findViewById(R.id.red_trashCan_img);
        purpleTrashCanImg = (ImageView) findViewById(R.id.purple_trashCan_img);
        blackTrashCanImg = (ImageView) findViewById(R.id.black_trashCan_img);

        controller.createThrashCan(blueTrashCanImg, ThrashType.BLUE);
        controller.createThrashCan(greenTrashCanImg, ThrashType.GREEN);
        controller.createThrashCan(yellowTrashCanImg, ThrashType.YELLOW);
        controller.createThrashCan(grayTrashCanImg, ThrashType.GRAY);
        controller.createThrashCan(redTrashCanImg, ThrashType.RED);
        controller.createThrashCan(purpleTrashCanImg, ThrashType.PURPLE);
        controller.createThrashCan(blackTrashCanImg, ThrashType.BLACK);

        blueTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_BLUE_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        greenTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_GREEN_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        yellowTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_YELLOW_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        grayTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_GRAY_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        redTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_RED_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        purpleTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_PURPLE_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));
        blackTrashCanImg.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_FOREST_BLACK_TRASHCAN, toolBox.POINT_D_ALL_TRASHCAN));

        List<ImageView> ivs = controller.createAllThrash(MAX_THRASH, THRASH_TYPES);

        for (ImageView iv : ivs) {
            relativeLayout.addView(iv);
        }
    }

    public void showMessage(){
        alertDialogBuilder.setTitle("Reciclemos - Bosque");
        alertDialogBuilder.setMessage("Mensaje");
        alertDialogBuilder.setIcon(R.drawable.btn_main_house);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(ForestActivity.this, "OK button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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
        resultIntent.putExtra(toolBox.STR_ENABLE_ALL_LEVEL, toolBox.STR_CODE_NONE_LEVEL);
        setResult(RESULT_OK, resultIntent);
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    @Override
    public void setCompleted() {}
}
