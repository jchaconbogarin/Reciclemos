package itcr.reciclemos;

import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.List;
import android.os.Handler;
import itcr.reciclemos.gameengine.ElementController;
import itcr.reciclemos.gameengine.ThrashType;
import itcr.reciclemos.gameutilities.Progress;

public class HouseActivity extends GameActivity {

    //-- GUI Elements ---------------------
    private ImageView blueTrashCanImg;
    private ImageView greenTrashCanImg;
    private ImageView yellowTrashCanImg;
    private ImageView grayTrashCanImg;
    private ImageView blackTrashCanImg;
    AlertDialog.Builder alertDialogBuilder;
    ProgressBar gameProgressBar;
    private Handler progressHandler;
    private Runnable progressRunnable;

    ElementController controller;
    RelativeLayout relativeLayout;
    Utilities toolBox = Utilities.getSingleton();
    private final int MAX_THRASH = 3;
    ThrashType[] THRASH_TYPES = {ThrashType.BLUE, ThrashType.GREEN, ThrashType.YELLOW, ThrashType.GRAY, ThrashType.BLACK};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_house);

        relativeLayout = (RelativeLayout) findViewById(R.id.house_layout);
        controller = new ElementController(this);

        alertDialogBuilder = new AlertDialog.Builder(this);
        gameProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressHandler = new Handler();

        final int progressRate = gameProgressBar.getMax() / (toolBox.INT_MILLISECONDS_HOUSE_TIMER / 1000);
        progressHandler.postDelayed(progressRunnable, 1000);
        progressRunnable = new Runnable() {
            @Override
            public void run() {
                //UPDATE
                //Si ya termino la partida entonces setCompleted();

                gameProgressBar.setProgress(gameProgressBar.getProgress() - progressRate);
                if (gameProgressBar.getProgress() >= progressRate) {
                    progressHandler.postDelayed(this, 1000);
                } else {
                    //Se acabo el tiempo
                    showMessage(false, R.drawable.btn_main_house, "El tiempo se agotó y no se clasificó toda la basura \n Puntaje total: " + "GET_FROM_CONTROLLER");
                }
            }
        };

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage(true, R.drawable.btn_main_house, "Seleccione una opción:");
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

        List<ImageView> ivs = controller.createAllThrash(MAX_THRASH, THRASH_TYPES);
        for (ImageView iv : ivs) {
            relativeLayout.addView(iv);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        progressHandler.removeCallbacks(progressRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        progressHandler.postDelayed(progressRunnable, 1000);
    }

    public void showMessage(boolean needPause, int icon, String message) {
        progressHandler.removeCallbacks(progressRunnable);
        if (needPause) {
            alertDialogBuilder.setNeutralButton("Volver", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    progressHandler.postDelayed(progressRunnable, 1000);
                }
            });
        }
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(icon);
        alertDialogBuilder.setTitle("Reciclemos - Casa");
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent restartHouse = getIntent();
                startActivity(restartHouse);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
        alertDialogBuilder.setNegativeButton("Menu principal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                goBack();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void onBackPressed() {
        showMessage(true, R.drawable.btn_main_house, "Seleccione una opción:");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                showMessage(true, R.drawable.btn_main_house, "Seleccione una opción:");
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void goBack() {
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    @Override
    public void setCompleted() {
        Progress.setHouseCompleted(getSharedPreferences(Progress.PREFERENCES_VALUE, Context.MODE_PRIVATE));
    }
}
