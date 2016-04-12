package itcr.reciclemos;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import itcr.reciclemos.gameengine.ElementController;

public class HouseActivity extends AppCompatActivity {

    ElementController controller;
    RelativeLayout relativeLayout;
    Utilities toolBox = new Utilities();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen

        ImageView imgView1 = new ImageView(this);
        imgView1.setImageResource(R.drawable.trash_green_8);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imgView1.setLayoutParams(params);

        relativeLayout = (RelativeLayout) findViewById(R.id.house_layout);
        relativeLayout.addView(imgView1);

        /*LayoutParams layoutParamsBG = new LayoutParams();

        relativeLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_house));

        setContentView(relativeLayout);

        //-- Set the Aspect Ratio -------------
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        Point currentScreenSize = new Point();
        currentDisplay.getSize(currentScreenSize);

        ImageView imgView1 = new ImageView(this);
        ImageView imgView2 = new ImageView(this);

        imgView1.setImageResource(R.drawable.trash_gray_4);
        imgView2.setImageResource(R.drawable.trash_blue_3);

        LayoutParams layoutParams_1 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //Point adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_D_ALL_THRASH, currentScreenSize);
        //Point adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (234 + toolBox.POINT_D_ALL_THRASH.x), toolBox.POINT_BACKGROUND.y - (267 + toolBox.POINT_D_ALL_THRASH.y));
        //Point adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_ALL_THRASH, currentScreenSize);
        layoutParams_1.setMargins(200, 200, 260, 260);
        layoutParams_1.width = 60;
        layoutParams_1.height = 60;
        imgView1.setLayoutParams(layoutParams_1);*/

        relativeLayout.addView(imgView1);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }
}
