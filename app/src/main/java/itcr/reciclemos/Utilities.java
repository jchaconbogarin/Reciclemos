package itcr.reciclemos;

import android.content.Context;
import android.graphics.Point;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import itcr.reciclemos.gameengine.ThrashType;

/**
 * Created by gesab on 4/11/2016.
 */
public class Utilities {

    private static Utilities singleton;
    private Point screenSize;

    private Utilities() { }

    public static Utilities getSingleton() {
        if (singleton == null) {
            singleton = new Utilities();
        }
        return singleton;
    }

    public void init(Point screenSize) {
        this.screenSize = screenSize;
    }

    public final int INT_PICK_DATA_ACTIVITY = 1;
    public final String STR_ENABLE_ALL_LEVEL = "ENABLE_LEVEL";
    public final String STR_CODE_ALL_LEVEL = "-1";
    public final String STR_CODE_NONE_LEVEL = "0";
    public final String STR_CODE_HOUSE_LEVEL = "1";
    public final String STR_CODE_LAKE_LEVEL = "2";
    public final String STR_CODE_FOREST_LEVEL = "3";

    public final int INT_DELAY_FOREST_ANIMATION = 5000;
    public final int INT_MILLISECONDS_HOUSE_TIMER = 20000;
    public final int INT_MILLISECONDS_LAKE_TIMER = 20000;
    public final int INT_MILLISECONDS_FOREST_TIMER = 20000;

    public final Point POINT_BACKGROUND = new Point(1067, 711);
    public final int POINT_C_ALL_PLAYABLE_TOP = 150;
    public final int POINT_C_ALL_PLAYABLE_BOTTOM = 166;
    public final Point POINT_D_MAIN_RECYCLE = new Point(123, 81);
    public final Point POINT_C_MAIN_RECYCLE = new Point(50, 20);    //Left-Bottom
    public final Point POINT_D_MAIN_HOUSE = new Point(294, 214);
    public final Point POINT_C_MAIN_HOUSE = new Point(199, 80);
    public final Point POINT_D_MAIN_LAKE = new Point(276, 82);
    public final Point POINT_C_MAIN_LAKE = new Point(501, 60);
    public final Point POINT_D_MAIN_FOREST = new Point(232, 214);
    public final Point POINT_C_MAIN_FOREST = new Point(785, 72);
    public final Point POINT_D_MAIN_ABOUT = new Point(149, 74);
    public final Point POINT_C_MAIN_ABOUT = new Point(650, 530);
    public final Point POINT_D_ALL_TRASHCAN = new Point(149,96);
    public final Point POINT_C_HOUSE_BLUE_TRASHCAN = new Point(55,0);
    public final Point POINT_C_HOUSE_GREEN_TRASHCAN = new Point(257,0);
    public final Point POINT_C_HOUSE_YELLOW_TRASHCAN = new Point(459,0);
    public final Point POINT_C_HOUSE_GRAY_TRASHCAN = new Point(661,0);
    public final Point POINT_C_HOUSE_BLACK_TRASHCAN = new Point(863,0);
    public final Point POINT_C_LAKE_BLUE_TRASHCAN = new Point(24,0);
    public final Point POINT_C_LAKE_GREEN_TRASHCAN = new Point(198,0);
    public final Point POINT_C_LAKE_YELLOW_TRASHCAN = new Point(372,0);
    public final Point POINT_C_LAKE_GRAY_TRASHCAN = new Point(546,0);
    public final Point POINT_C_LAKE_RED_TRASHCAN = new Point(720,0);
    public final Point POINT_C_LAKE_BLACK_TRASHCAN = new Point(894,0);
    public final Point POINT_C_FOREST_BLUE_TRASHCAN = new Point(3,0);
    public final Point POINT_C_FOREST_GREEN_TRASHCAN = new Point(155,0);
    public final Point POINT_C_FOREST_YELLOW_TRASHCAN = new Point(307,0);
    public final Point POINT_C_FOREST_GRAY_TRASHCAN = new Point(459,0);
    public final Point POINT_C_FOREST_RED_TRASHCAN = new Point(611,0);
    public final Point POINT_C_FOREST_PURPLE_TRASHCAN = new Point(763,0);
    public final Point POINT_C_FOREST_BLACK_TRASHCAN = new Point(915,0);

    public final Point POINT_D_ALL_THRASH = new Point(80,80);

    public final int INT_D_ALL_TAB = 200;

    public final String[] STRING_BLUE_ALL_DESC = {
            "Papel periódico",
            "Papel",
            "Papel",
            "Caja cartón",
            "Caja cartón",
            "Caja cartón",
            "Caja cartón",
            "Bolsa de papel",
            "Caja cartón",
            "Caja cartón"
    };
    public final Integer[] INTEGER_BLUE_ALL_DRAWABLE = {
            R.drawable.trash_blue_1,
            R.drawable.trash_blue_2,
            R.drawable.trash_blue_3,
            R.drawable.trash_blue_4,
            R.drawable.trash_blue_5,
            R.drawable.trash_blue_6,
            R.drawable.trash_blue_7,
            R.drawable.trash_blue_8,
            R.drawable.trash_blue_9,
            R.drawable.trash_blue_10
    };

    public final String[] STRING_GREEN_ALL_DESC = {
            "Botella de vidrio",
            "Botella de vidrio",
            "Botella de vidrio",
            "Vaso de vidrio",
            "Copa de vidrio",
            "Botella de vidrio",
            "Botella de vidrio",
            "Botella de vidrio",
            "Botella de vidrio",
            "Botella de vidrio"
    };
    public final Integer[] INTEGER_GREEN_ALL_DRAWABLE = {
            R.drawable.trash_green_1,
            R.drawable.trash_green_2,
            R.drawable.trash_green_3,
            R.drawable.trash_green_4,
            R.drawable.trash_green_5,
            R.drawable.trash_green_6,
            R.drawable.trash_green_7,
            R.drawable.trash_green_8,
            R.drawable.trash_green_9,
            R.drawable.trash_green_10
    };

    public final String[] STRING_YELLOW_ALL_DESC = {
            "Latas de atún",
            "Lata de refresco",
            "Lata de refresco",
            "Recipiente metálico",
            "Lata de refresco",
            "Empaque Tetra Pack",
            "Empaque Tetra Pack",
            "Empaque Tetra Pack",
            "Empaque Tetra Pack",
            "Empaque Tetra Pack",
            "Botella plástica"
    };
    public final Integer[] INTEGER_YELLOW_ALL_DRAWABLE = {
            R.drawable.trash_yellow_1,
            R.drawable.trash_yellow_2,
            R.drawable.trash_yellow_3,
            R.drawable.trash_yellow_4,
            R.drawable.trash_yellow_5,
            R.drawable.trash_yellow_6,
            R.drawable.trash_yellow_7,
            R.drawable.trash_yellow_8,
            R.drawable.trash_yellow_9,
            R.drawable.trash_yellow_10,
            R.drawable.trash_yellow_11
    };

    public final String[] STRING_GRAY_ALL_DESC = {
            "Restos de naranja",
            "Restos de pescado",
            "Restos de pollo",
            "Restos de manzana",
            "Restos de banano",
            "Restos de huevo"
    };
    public final Integer[] INTEGER_GRAY_ALL_DRAWABLE = {
            R.drawable.trash_gray_1,
            R.drawable.trash_gray_2,
            R.drawable.trash_gray_3,
            R.drawable.trash_gray_4,
            R.drawable.trash_gray_5,
            R.drawable.trash_gray_6
    };

    public final String[] STRING_RED_ALL_DESC = {
            "Desechos hospitalarios",
            "Desechos químicos",
            "Desechos tóxicos",
            "Desechos farmacéuticos",
            "Jeringas (sin aguja)",
            "Desechos farmacéuticos",
            "Bombillos",
            "Baterías",
            "Baterías recargables",
            "Desechos industriales"
    };
    public final Integer[] INTEGER_RED_ALL_DRAWABLE = {
            R.drawable.trash_red_1,
            R.drawable.trash_red_2,
            R.drawable.trash_red_3,
            R.drawable.trash_red_4,
            R.drawable.trash_red_5,
            R.drawable.trash_red_6,
            R.drawable.trash_red_7,
            R.drawable.trash_red_8,
            R.drawable.trash_red_9,
            R.drawable.trash_red_10
    };

    public final String[] STRING_PURPLE_ALL_DESC = {
            "Teléfono",
            "Teléfono móvil",
            "Tableta",
            "Computadores",
            "Consolas de juegos",
            "Accesorios de juegos",
            "Memorias portátiles",
            "Cámaras fotográficos y de video"
    };
    public final Integer[] INTEGER_PURPLE_ALL_DRAWABLE = {
            R.drawable.trash_purple_1,
            R.drawable.trash_purple_2,
            R.drawable.trash_purple_3,
            R.drawable.trash_purple_4,
            R.drawable.trash_purple_5,
            R.drawable.trash_purple_6,
            R.drawable.trash_purple_7,
            R.drawable.trash_purple_8
    };

    public final String[] STRING_BLACK_ALL_DESC = {
            "Bolsas con basura",
            "Pañal",
            "Pasta de dientes",
            "Pajillas",
            "Corchos",
            "Trapos",
            "Servilletas sucias",
            "Papel de fotografía",
            "Cerámica",
            "Papel higiénico"
    };

    public final Integer[] INTEGER_BLACK_ALL_DRAWABLE = {
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1,
            R.drawable.trash_black_1
    };

    public final int SCORE_INCREASE = R.drawable.score_increase;
    public final int SCORE_DECREASE = R.drawable.score_decrease;

    public Point adjustAspect(Point originalDimension){
        double xScale;
        double yScale;
        if(POINT_BACKGROUND.x < screenSize.x){
            xScale = (double)screenSize.x / POINT_BACKGROUND.x;
        }
        else{
            xScale = (double)POINT_BACKGROUND.x / screenSize.x;
        }
        if(POINT_BACKGROUND.y < screenSize.y){
            yScale = (double)screenSize.y / POINT_BACKGROUND.y;
        }
        else{
            yScale = (double)POINT_BACKGROUND.y / screenSize.y;
        }
        int intNewX = (int) (xScale * originalDimension.x);
        int intNewY = (int) (yScale * originalDimension.y);
        return new Point(intNewX, intNewY);
    }

    public RelativeLayout.LayoutParams positionImage(Point coordinates, Point dimensions) {
        // -- Element Params Initialization --
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        //-- Set location and size for blueTrashCanImg
        Point adjustedSizeLB = adjustAspect(coordinates);
        Point adjustedSizeRT = new Point(POINT_BACKGROUND.x - (coordinates.x + dimensions.x), POINT_BACKGROUND.y - (coordinates.y + dimensions.y));
        Point adjustedSizeWH = adjustAspect(dimensions);
        adjustedSizeRT = adjustAspect(adjustedSizeRT);
        params.setMargins(adjustedSizeLB.x, adjustedSizeRT.y, adjustedSizeRT.x, adjustedSizeLB.y);
        params.width = adjustedSizeWH.x;
        params.height = adjustedSizeWH.y;

        return params;
    }

    public int getRandomImage(ThrashType type) {
        Random r = new Random();
        int result = 0;
        switch (type) {
            case BLACK:
                result = INTEGER_BLACK_ALL_DRAWABLE[r.nextInt(INTEGER_BLACK_ALL_DRAWABLE.length)];
                break;
            case BLUE:
                result = INTEGER_BLUE_ALL_DRAWABLE[r.nextInt(INTEGER_BLUE_ALL_DRAWABLE.length)];
                break;
            case YELLOW:
                result = INTEGER_YELLOW_ALL_DRAWABLE[r.nextInt(INTEGER_YELLOW_ALL_DRAWABLE.length)];
                break;
            case GREEN:
                result = INTEGER_GREEN_ALL_DRAWABLE[r.nextInt(INTEGER_GREEN_ALL_DRAWABLE.length)];
                break;
            case PURPLE:
                result = INTEGER_PURPLE_ALL_DRAWABLE[r.nextInt(INTEGER_PURPLE_ALL_DRAWABLE.length)];
                break;
            case RED:
                result = INTEGER_RED_ALL_DRAWABLE[r.nextInt(INTEGER_RED_ALL_DRAWABLE.length)];
                break;
            case GRAY:
                result = INTEGER_GRAY_ALL_DRAWABLE[r.nextInt(INTEGER_GRAY_ALL_DRAWABLE.length)];
                break;
        }
        return result;
    }
}