package itcr.reciclemos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import itcr.reciclemos.gameutilities.Progress;

public class MainActivity extends AppCompatActivity {

    //-- GUI Elements ---------------------
    private ImageButton recycleBtn;
    private ImageButton houseBtn;
    private ImageButton lakeBtn;
    private ImageButton forestBtn;
    private ImageButton aboutBtn;

    private Handler animationHandler;
    private Runnable animationRunnable;

    private SharedPreferences progressData;

    Utilities toolBox = Utilities.getSingleton();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

        //-- Initialize the Singleton with screen data --
        Point currentScreenSize = new Point();
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        currentDisplay.getSize(currentScreenSize);
        toolBox.init(currentScreenSize);


        //-- Link the GUI Elements --
        recycleBtn = (ImageButton) findViewById(R.id.recycle_btn);
        houseBtn = (ImageButton) findViewById(R.id.house_btn);
        lakeBtn = (ImageButton) findViewById(R.id.lake_btn);
        forestBtn = (ImageButton) findViewById(R.id.forest_btn);
        aboutBtn = (ImageButton) findViewById(R.id.about_btn);

        recycleBtn.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_MAIN_RECYCLE, toolBox.POINT_D_MAIN_RECYCLE));
        houseBtn.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_MAIN_HOUSE, toolBox.POINT_D_MAIN_HOUSE));
        lakeBtn.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_MAIN_LAKE, toolBox.POINT_D_MAIN_LAKE));
        forestBtn.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_MAIN_FOREST, toolBox.POINT_D_MAIN_FOREST));
        aboutBtn.setLayoutParams(toolBox.positionImage(toolBox.POINT_C_MAIN_ABOUT, toolBox.POINT_D_MAIN_ABOUT));

        houseBtn.setEnabled(false);
        lakeBtn.setEnabled(false);
        forestBtn.setEnabled(false);
        houseBtn.setAlpha(0.3f);
        lakeBtn.setAlpha(0.3f);
        forestBtn.setAlpha(0.3f);

        animationHandler = new Handler();

        progressData = getSharedPreferences(Progress.preferencesValue, Context.MODE_PRIVATE);

        boolean hasSeenInformation = progressData.getBoolean(Progress.information, false);
        boolean hasCompletedHouse = progressData.getBoolean(Progress.house, false);
        boolean hasCompletedLake = progressData.getBoolean(Progress.lake, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        animationHandler.removeCallbacks(animationRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        final Animation interactiveAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
        animationRunnable = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                if(i == 5) { i = 0; }
                if(i == 0){
                    animationHandler.postDelayed(this, toolBox.INT_DELAY_FOREST_ANIMATION);
                    recycleBtn.startAnimation(interactiveAnimation);
                }
                else if(i == 1){
                    animationHandler.postDelayed(this, toolBox.INT_DELAY_FOREST_ANIMATION);
                    aboutBtn.startAnimation(interactiveAnimation);
                }
                else if(i == 2){
                    if(forestBtn.isEnabled()){
                        animationHandler.postDelayed(this, toolBox.INT_DELAY_FOREST_ANIMATION);
                        forestBtn.startAnimation(interactiveAnimation);
                    }
                    else{
                        animationHandler.postDelayed(this, 0);
                    }
                }
                else if(i == 3){
                    if(houseBtn.isEnabled()){
                        animationHandler.postDelayed(this, toolBox.INT_DELAY_FOREST_ANIMATION);
                        houseBtn.startAnimation(interactiveAnimation);
                    }
                    else{
                        animationHandler.postDelayed(this, 0);
                    }
                }
                else if(i == 4){
                    if(lakeBtn.isEnabled()) {
                        animationHandler.postDelayed(this, toolBox.INT_DELAY_FOREST_ANIMATION);
                        lakeBtn.startAnimation(interactiveAnimation);
                    }
                    else{
                        animationHandler.postDelayed(this, 0);
                    }
                }
                ++i;
            }
        };
        animationHandler.postDelayed(animationRunnable, toolBox.INT_DELAY_FOREST_ANIMATION);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == toolBox.INT_PICK_DATA_ACTIVITY){
            if (resultCode == RESULT_OK){
                String strLevelState = data.getStringExtra(toolBox.STR_ENABLE_ALL_LEVEL);
                //Toast.makeText(getApplicationContext(), "Cantidad en el controller: " + strLevelState, Toast.LENGTH_SHORT).show();
                if (strLevelState.equals(toolBox.STR_CODE_HOUSE_LEVEL)){
                    houseBtn.setEnabled(true);
                    houseBtn.setAlpha(1f);
                }
                else if (strLevelState.equals(toolBox.STR_CODE_LAKE_LEVEL)){
                    lakeBtn.setEnabled(true);
                    lakeBtn.setAlpha(1f);
                }
                else if (strLevelState.equals(toolBox.STR_CODE_FOREST_LEVEL)){
                    forestBtn.setEnabled(true);
                    forestBtn.setAlpha(1f);
                }
            }
        }
    }

    public void showAbout(View view){
        Intent startAbout = new Intent(this, AboutActivity.class);
        startActivity(startAbout);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void showForest(View view){
        Intent startForest = new Intent(this, ForestActivity.class);
        startActivity(startForest);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void showHouse(View view){
        Intent startHouse = new Intent(this, HouseActivity.class);
        startActivityForResult(startHouse, toolBox.INT_PICK_DATA_ACTIVITY);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void showLake(View view){
        Intent startLake = new Intent(this, LakeActivity.class);
        startActivityForResult(startLake, toolBox.INT_PICK_DATA_ACTIVITY);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void showRecycle(View view){
        Intent startRecycle = new Intent(this, RecycleActivity.class);
        startActivityForResult(startRecycle, toolBox.INT_PICK_DATA_ACTIVITY);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
