package itcr.reciclemos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import itcr.reciclemos.gameengine.ElementController;

/**
 * Created by Boga on 21.04.2016.
 */
public abstract class GameActivity extends AppCompatActivity {

    protected AlertDialog.Builder alertDialogBuilder;
    protected TextView scoreTextView;
    protected ProgressBar gameProgressBar;
    protected Handler progressHandler;
    protected Runnable progressRunnable;
    protected String activityName;
    protected ElementController controller;
    protected RelativeLayout relativeLayout;
    protected float minScore;
    protected Utilities toolBox = Utilities.getSingleton();

    protected int timer;
    protected int icon;

    public abstract void setCompleted();

    protected void createDialogAndTimer() {
        alertDialogBuilder = new AlertDialog.Builder(this);
        scoreTextView = (TextView) findViewById(R.id.score_textView);
        gameProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressHandler = new Handler();

        final int progressRate = gameProgressBar.getMax() / (timer / 1000);
        progressHandler.postDelayed(progressRunnable, 1000);
        progressRunnable = new Runnable() {
            @Override
            public void run() {
                scoreTextView.setText("Puntaje total: " + controller.getScore());
                if(controller.getAllTrash().size() == 0){
                    if(controller.getScore() < minScore) {
                        showMessage(false, icon, toolBox.STRING_MSG_DIALOG_MISSES + minScore + ". Inténtelo nuevamente.\nPuntaje total: " + controller.getScore());
                    } else {
                        showMessage(false, icon, toolBox.STRING_MSG_DIALOG_FLAWLESS + controller.getScore());
                    }
                }
                else {
                    gameProgressBar.setProgress(gameProgressBar.getProgress() - progressRate);
                    if (gameProgressBar.getProgress() >= progressRate) {
                        progressHandler.postDelayed(this, 1000);
                    } else {
                        showMessage(false, icon, toolBox.STRING_MSG_DIALOG_NOTIME + controller.getScore());
                    }
                }
            }
        };
    }

    protected void showMessage(boolean needPause, int icon, String message) {
        progressHandler.removeCallbacks(progressRunnable);
        if (needPause) {
            alertDialogBuilder.setNeutralButton(toolBox.STRING_MSG_DIALOG_BACK, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    progressHandler.postDelayed(progressRunnable, 1000);
                }
            });
        }
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(icon);
        alertDialogBuilder.setTitle(toolBox.STRING_PREFIX_ACTIVITY_TITLE + activityName);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton(toolBox.STRING_MSG_DIALOG_RESTART, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent restart = getIntent();
                startActivity(restart);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
        alertDialogBuilder.setNegativeButton(toolBox.STRING_MSG_DIALOG_MAINMENU, new DialogInterface.OnClickListener() {
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

    public float getMinScore() {
        return this.minScore;
    }

}
