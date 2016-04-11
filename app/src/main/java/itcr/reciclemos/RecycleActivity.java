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
    String[] blueItemName = {
        "Papel_1",
        "Papel_2",
        "Papel_3",
        "Papel_4",
        "Papel_5"
    };
    Integer[] blueImageId = {
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1
    };

    String[] greenItemName = {
        "Vidrio_1",
        "Vidrio_2",
        "Vidrio_3",
        "Vidrio_4",
        "Vidrio_5"
    };
    Integer[] greenImageId = {
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1
    };

    String[] yellowItemName = {
        "Metal_1",
        "Plastico_2",
        "Tretrabrik_3",
        "Vidrio_4",
        "Vidrio_5"
    };
    Integer[] yellowImageId = {
        R.drawable.trash_yellow_1,
        R.drawable.trash_yellow_2,
        R.drawable.trash_yellow_3,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1
    };

    String[] grayItemName = {
        "Cascara de banano",
        "Organico_2",
        "Organico_3",
        "Organico_4",
        "Organico_5"
    };
    Integer[] grayImageId = {
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1
    };

    String[] redItemName = {
        "Peligroso_1",
        "Peligroso_2",
        "Peligroso_3",
        "Peligroso_4",
        "Peligroso_5"
    };
    Integer[] redImageId = {
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1
    };

    String[] purpleItemName = {
        "Celular",
        "Impresora",
        "Teclado",
        "Mouse",
        "Monitor"
    };
    Integer[] purpleImageId = {
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1,
        R.drawable.trash_blue_2,
        R.drawable.trash_blue_1
    };

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
        //Tab 1
        trashSpec = trashHost.newTabSpec("Blue");
        trashSpec.setContent(R.id.blue_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_blue, null));
        trashList = (ListView)findViewById(R.id.blue_ListView);
        trashAdapter = new CustomListAdapter(this, blueItemName, blueImageId);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 2
        trashSpec = trashHost.newTabSpec("Green");
        trashSpec.setContent(R.id.green_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_green, null));
        trashList = (ListView)findViewById(R.id.green_ListView);
        trashAdapter = new CustomListAdapter(this, greenItemName, greenImageId);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 3
        trashSpec = trashHost.newTabSpec("Yellow");
        trashSpec.setContent(R.id.yellow_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_yellow, null));
        trashList = (ListView)findViewById(R.id.yellow_ListView);
        trashAdapter = new CustomListAdapter(this, yellowItemName, yellowImageId);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 4
        trashSpec = trashHost.newTabSpec("Gray");
        trashSpec.setContent(R.id.gray_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_gray, null));
        trashList = (ListView)findViewById(R.id.gray_ListView);
        trashAdapter = new CustomListAdapter(this, grayItemName, grayImageId);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 5
        trashSpec = trashHost.newTabSpec("Red");
        trashSpec.setContent(R.id.red_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_red, null));
        trashList = (ListView)findViewById(R.id.red_ListView);
        trashAdapter = new CustomListAdapter(this, redItemName, redImageId);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);
        //Tab 6
        trashSpec = trashHost.newTabSpec("Purple");
        trashSpec.setContent(R.id.purple_Layout);
        trashSpec.setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.btn_recycle_menu_purple, null));
        trashList = (ListView)findViewById(R.id.purple_ListView);
        trashAdapter = new CustomListAdapter(this, purpleItemName, purpleImageId);
        trashList.setAdapter(trashAdapter);
        trashHost.addTab(trashSpec);

        trashHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });

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
