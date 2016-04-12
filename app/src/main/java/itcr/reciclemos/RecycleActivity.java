package itcr.reciclemos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

public class RecycleActivity extends AppCompatActivity {

    ListView trashList;
    Utilities toolBox = new Utilities();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        setContentView(R.layout.activity_recycle);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
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
        trashAdapter = new CustomListAdapter(this, toolBox.STRING_YELLOW_ALL_DESC, toolBox.INTEGER_YELLOWALL_DRAWABLE);
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

        /*
        trashHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });
        */

        /*
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
        */
    }
}
