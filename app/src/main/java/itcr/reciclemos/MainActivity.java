package itcr.reciclemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //-- GUI Elements ---------------------
    private ImageButton forestBtn;
    private ImageButton houseBtn;
    private ImageButton lakeBtn;
    private ImageButton aboutBtn;
    private ImageButton recycleBtn;
    //-------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        setContentView(R.layout.activity_main);

        //-- Link the GUI Elements ------------
        forestBtn = (ImageButton) findViewById(R.id.forest_btn);
        houseBtn = (ImageButton) findViewById(R.id.house_btn);
        lakeBtn = (ImageButton) findViewById(R.id.lake_btn);
        aboutBtn = (ImageButton) findViewById(R.id.about_btn);
        recycleBtn = (ImageButton) findViewById(R.id.recycle_btn);
        //-------------------------------------
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
