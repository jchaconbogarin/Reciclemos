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

    //-- GUI Elements ---------------------
    private ImageView blueTrashCanImg;
    private ImageView greenTrashCanImg;
    private ImageView yellowTrashCanImg;
    private ImageView grayTrashCanImg;
    private ImageView blackTrashCanImg;

    ElementController controller;
    RelativeLayout relativeLayout;
    Utilities toolBox = Utilities.getSingleton();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Hide Title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//Set Full Screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_house);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        //-- Link the GUI Elements ------------
        blueTrashCanImg = (ImageView) findViewById(R.id.blue_trashCan_img);
        greenTrashCanImg = (ImageView) findViewById(R.id.green_trashCan_img);
        yellowTrashCanImg = (ImageView) findViewById(R.id.yellow_trashCan_img);
        grayTrashCanImg = (ImageView) findViewById(R.id.gray_trashCan_img);
        blackTrashCanImg = (ImageView) findViewById(R.id.black_trashCan_img);

        //-- Set the Aspect Ratio -------------
        relativeLayout = (RelativeLayout) findViewById(R.id.house_layout);
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        Point currentScreenSize = new Point();
        currentDisplay.getSize(currentScreenSize);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        //-- Set location and size for blueTrashCanImg
        Point adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_HOUSE_BLUE_TRASHCAN, currentScreenSize);
        Point adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_HOUSE_BLUE_TRASHCAN.x + toolBox.POINT_D_ALL_TRASHCAN.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_HOUSE_BLUE_TRASHCAN.y + toolBox.POINT_D_ALL_TRASHCAN.y));
        Point adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_ALL_TRASHCAN, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        blueTrashCanImg.setLayoutParams(params);

        //-- Set location and size for greenTrashCanImg
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_HOUSE_GREEN_TRASHCAN, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_HOUSE_GREEN_TRASHCAN.x + toolBox.POINT_D_ALL_TRASHCAN.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_HOUSE_GREEN_TRASHCAN.y + toolBox.POINT_D_ALL_TRASHCAN.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_ALL_TRASHCAN, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        greenTrashCanImg.setLayoutParams(params);

        //-- Set location and size for yellowTrashCanImg
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_HOUSE_YELLOW_TRASHCAN, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_HOUSE_YELLOW_TRASHCAN.x + toolBox.POINT_D_ALL_TRASHCAN.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_HOUSE_YELLOW_TRASHCAN.y + toolBox.POINT_D_ALL_TRASHCAN.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_ALL_TRASHCAN, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        yellowTrashCanImg.setLayoutParams(params);

        //-- Set location and size for grayTrashCanImg
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_HOUSE_GRAY_TRASHCAN, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_HOUSE_GRAY_TRASHCAN.x + toolBox.POINT_D_ALL_TRASHCAN.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_HOUSE_GRAY_TRASHCAN.y + toolBox.POINT_D_ALL_TRASHCAN.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_ALL_TRASHCAN, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        grayTrashCanImg.setLayoutParams(params);

        //-- Set location and size for blackTrashCanImg
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_HOUSE_BLACK_TRASHCAN, currentScreenSize);
        adjustedSizeRT = new Point(toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_HOUSE_BLACK_TRASHCAN.x + toolBox.POINT_D_ALL_TRASHCAN.x), toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_HOUSE_BLACK_TRASHCAN.y + toolBox.POINT_D_ALL_TRASHCAN.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_ALL_TRASHCAN, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        blackTrashCanImg.setLayoutParams(params);



        ImageView iv = new ImageView(this);

        iv.setImageResource(R.drawable.trash_gray_2);


        adjustedSizeLB = toolBox.adjustAspect(toolBox.POINT_C_MAIN_RECYCLE, currentScreenSize);
        adjustedSizeRT = new Point(
                toolBox.POINT_BACKGROUND.x - (toolBox.POINT_C_MAIN_RECYCLE.x + toolBox.POINT_D_MAIN_RECYCLE.x),
                toolBox.POINT_BACKGROUND.y - (toolBox.POINT_C_MAIN_RECYCLE.y + toolBox.POINT_D_MAIN_RECYCLE.y));
        adjustedSizeWH = toolBox.adjustAspect(toolBox.POINT_D_MAIN_RECYCLE, currentScreenSize);
        adjustedSizeRT = toolBox.adjustAspect(adjustedSizeRT, currentScreenSize);
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;
        iv.setLayoutParams(params);
        relativeLayout.addView(iv);
    }
}
