package itcr.reciclemos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import itcr.reciclemos.gameutilities.Progress;

public class RecycleActivity extends GameActivity {

    ListView trashList;
    Utilities toolBox = Utilities.getSingleton();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_recycle);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        TabHost trashHost = (TabHost)findViewById(R.id.tabHost);
        TabHost.TabSpec trashSpec;
        CustomListAdapter trashAdapter;
        trashHost.setup();
        //Tab 1 - Blue
        trashSpec = trashHost.newTabSpec("Blue");
        trashSpec.setContent(R.id.blue_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_blue, null));
        trashList = (ListView)findViewById(R.id.blue_ListView);
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_BLUE_ALL_DESC, toolBox.INTEGER_BLUE_ALL_DRAWABLE);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 2 - Green
        trashSpec = trashHost.newTabSpec("Green");
        trashSpec.setContent(R.id.green_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_green, null));
        trashList = (ListView)findViewById(R.id.green_ListView);
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_GREEN_ALL_DESC, toolBox.INTEGER_GREEN_ALL_DRAWABLE);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 3 - Yellow
        trashSpec = trashHost.newTabSpec("Yellow");
        trashSpec.setContent(R.id.yellow_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_yellow, null));
        trashList = (ListView)findViewById(R.id.yellow_ListView);
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_YELLOW_ALL_DESC, toolBox.INTEGER_YELLOW_ALL_DRAWABLE);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 4 - Gray
        trashSpec = trashHost.newTabSpec("Gray");
        trashSpec.setContent(R.id.gray_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_gray, null));
        trashList = (ListView)findViewById(R.id.gray_ListView);
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_GRAY_ALL_DESC, toolBox.INTEGER_GRAY_ALL_DRAWABLE);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 5 - Red
        trashSpec = trashHost.newTabSpec("Red");
        trashSpec.setContent(R.id.red_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_red, null));
        trashList = (ListView)findViewById(R.id.red_ListView);
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_RED_ALL_DESC, toolBox.INTEGER_RED_ALL_DRAWABLE);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 6 - Purple
        trashSpec = trashHost.newTabSpec("Purple");
        trashSpec.setContent(R.id.purple_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_purple, null));
        trashList = (ListView)findViewById(R.id.purple_ListView);
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_PURPLE_ALL_DESC, toolBox.INTEGER_PURPLE_ALL_DRAWABLE);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 6 - Black
        trashSpec = trashHost.newTabSpec("Black");
        trashSpec.setContent(R.id.black_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_black, null));
        trashList = (ListView)findViewById(R.id.black_ListView);
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_BLACK_ALL_DESC, toolBox.INTEGER_BLACK_ALL_DRAWABLE);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);

        for (int i = 0; i < trashHost.getTabWidget().getChildCount(); i++){
            trashHost.getTabWidget().getChildAt(i).getLayoutParams().height = toolBox.INT_D_ALL_TAB;
        }
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
        resultIntent.putExtra(toolBox.STR_ENABLE_ALL_LEVEL, toolBox.STR_CODE_HOUSE_LEVEL);  //Si no paso el nivel mandar STR_FAIL_ALL_LEVEL
        Progress.setInformationCompleted(getSharedPreferences(Progress.PREFERENCES_VALUE, Context.MODE_PRIVATE));
        setResult(RESULT_OK, resultIntent);
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    @Override
    public void setCompleted() {
        Progress.setInformationCompleted(getSharedPreferences(Progress.PREFERENCES_VALUE, Context.MODE_PRIVATE));
    }
}
