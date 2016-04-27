package itcr.reciclemos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import itcr.reciclemos.gameengine.ElementController;

/**
 * Created by Boga on 21.04.2016.
 */
public abstract class GameActivity extends AppCompatActivity {

    protected AlertDialog.Builder alertDialogBuilder;
    protected ProgressBar gameProgressBar;
    protected Handler progressHandler;
    protected Runnable progressRunnable;
    protected String activityName;
    protected ElementController controller;
    protected RelativeLayout relativeLayout;
    protected Utilities toolBox = Utilities.getSingleton();

    protected int timer;
    protected int icon;

    public abstract void setCompleted();

    protected void createDialogAndTimer() {
        alertDialogBuilder = new AlertDialog.Builder(this);
        gameProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressHandler = new Handler();

        final int progressRate = gameProgressBar.getMax() / (timer / 1000);
        progressHandler.postDelayed(progressRunnable, 1000);
        progressRunnable = new Runnable() {
            @Override
            public void run() {
                if(controller.getAllTrash().size() == 0){
                    if(controller.getMisplacedThrash()) {
                        showMessage(false, icon, "Se ha clasificado toda la basura, pero no correctamente. Inténtelo nuevamente.\nPuntaje total: " + controller.getScore());
                    } else {
                        showMessage(false, icon, "¡Felicidades! Se ha clasificado toda la basura.\nPuntaje total: " + controller.getScore());
                    }
                }
                else {
                    gameProgressBar.setProgress(gameProgressBar.getProgress() - progressRate);
                    if (gameProgressBar.getProgress() >= progressRate) {
                        progressHandler.postDelayed(this, 1000);
                    } else {
                        showMessage(false, icon, "El tiempo se agotó y no se clasificó toda la basura.\nPuntaje total: " + controller.getScore());
                    }
                }
            }
        };
    }

    protected void showMessage(boolean needPause, int icon, String message) {
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
        alertDialogBuilder.setTitle("Reciclemos - " + activityName);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent restart = getIntent();
                startActivity(restart);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
        alertDialogBuilder.setNegativeButton("Menú principal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                goBack();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void goBack() {
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}
