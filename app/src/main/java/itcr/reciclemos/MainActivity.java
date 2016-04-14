package itcr.reciclemos;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //-- GUI Elements ---------------------
    private ImageButton recycleBtn;
    private ImageButton houseBtn;
    private ImageButton lakeBtn;
    private ImageButton forestBtn;
    private ImageButton aboutBtn;

    Utilities toolBox = new Utilities();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        setContentView(R.layout.activity_main);

        //-- Link the GUI Elements ------------
        recycleBtn = (ImageButton) findViewById(R.id.recycle_btn);
        houseBtn = (ImageButton) findViewById(R.id.house_btn);
        lakeBtn = (ImageButton) findViewById(R.id.lake_btn);
        forestBtn = (ImageButton) findViewById(R.id.forest_btn);
        aboutBtn = (ImageButton) findViewById(R.id.about_btn);

        //-- Set the Aspect Ratio -------------
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        Point currentScreenSize = new Point();
        currentDisplay.getSize(currentScreenSize);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        //-- Set location and size for recycleBtn
        Point adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_MAIN_RECYCLE, currentScreenSize);
        Point adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_MAIN_RECYCLE.x + toolBox.POINT_D_MAIN_RECYCLE.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_MAIN_RECYCLE.y + toolBox.POINT_D_MAIN_RECYCLE.y));
        Point adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_MAIN_RECYCLE, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        recycleBtn.setLayoutParams(params);

        //-- Set location and size for houseBtn
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_MAIN_HOUSE, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_MAIN_HOUSE.x + toolBox.POINT_D_MAIN_HOUSE.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_MAIN_HOUSE.y + toolBox.POINT_D_MAIN_HOUSE.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_MAIN_HOUSE, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        houseBtn.setLayoutParams(params);

        //-- Set location and size for lakeBtn
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_MAIN_LAKE, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_MAIN_LAKE.x + toolBox.POINT_D_MAIN_LAKE.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_MAIN_LAKE.y + toolBox.POINT_D_MAIN_LAKE.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_MAIN_LAKE, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        lakeBtn.setLayoutParams(params);

        //-- Set location and size for forestBtn
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_MAIN_FOREST, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_MAIN_FOREST.x + toolBox.POINT_D_MAIN_FOREST.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_MAIN_FOREST.y + toolBox.POINT_D_MAIN_FOREST.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_MAIN_FOREST, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        forestBtn.setLayoutParams(params);

        //-- Set location and size for aboutBtn
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_MAIN_ABOUT, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_MAIN_ABOUT.x + toolBox.POINT_D_MAIN_ABOUT.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_MAIN_ABOUT.y + toolBox.POINT_D_MAIN_ABOUT.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_MAIN_ABOUT, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        aboutBtn.setLayoutParams(params);


        final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        //animation.setRepeatCount(2);
        animation.setDuration(300); // duration - half a second
        //animation.setStartTime(10000);
        animation.setStartOffset(10);
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
        //final Button btn = (Button) findViewById(R.id.your_btn);
        forestBtn.startAnimation(animation);

        /*btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                view.clearAnimation();
            }
        });*/

        //animation1 AnimationListener
        /*
        animation.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationEnd(Animation arg0) {
                // start animation2 when animation1 ends (continue)
                //animation.
                forestBtn.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub

            }

        });
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        startActivity(startHouse);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void showLake(View view){
        Intent startLake = new Intent(this, LakeActivity.class);
        startActivity(startLake);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void showRecycle(View view){
        Intent startRecycle = new Intent(this, RecycleActivity.class);
        startActivity(startRecycle);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
