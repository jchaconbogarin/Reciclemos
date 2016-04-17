package itcr.reciclemos;

import android.content.Context;
import android.graphics.Point;
import android.widget.Toast;

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

    public final int INT_DELAY_FOREST_ANIMATION = 15000;

    public final Point POINT_BACKGROUND = new Point(1067, 711);
    public final Point POINT_D_MAIN_RECYCLE = new Point(123, 81);
    public final Point POINT_C_MAIN_RECYCLE = new Point(50, 20);    //Right-Bottom
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

    public final Point POINT_D_ALL_THRASH = new Point(60,60);

    public final int INT_D_ALL_TAB = 100;

    public final String[] STRING_BLUE_ALL_DESC = {
            "Bolsa de papel",
            "Caja de cartón",
            "Caja de cartón",
            "Papel"
    };
    public final Integer[] INTEGER_BLUE_ALL_DRAWABLE = {
            R.drawable.trash_blue_1,
            R.drawable.trash_blue_2,
            R.drawable.trash_blue_3,
            R.drawable.trash_blue_4,
    };

    public final String[] STRING_GREEN_ALL_DESC = {
            "Copa de cristal",
            "Pichel de vidrio",
            "Tasa de vidrio",
            "Florero de cristal",
            "Pichel de vidrio",
            "Pichel de vidrio",
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
            R.drawable.trash_green_8
    };

    public final String[] STRING_YELLOW_ALL_DESC = {
            "Latas de atún",
            "Lata de refresco",
            "Botella plástica"
    };
    public final Integer[] INTEGER_YELLOWALL_DRAWABLE = {
            R.drawable.trash_yellow_1,
            R.drawable.trash_yellow_2,
            R.drawable.trash_yellow_3
    };

    public final String[] STRING_GRAY_ALL_DESC = {
            "Restos de pescado",
            "Restos de manzana",
            "Restos de manzana",
            "Restos de pollo",
            "Cáscaras de huevo",
            "Cáscaras de banano"
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
            "Peligroso_1",
            "Peligroso_2",
            "Peligroso_3",
            "Peligroso_4",
            "Peligroso_5"
    };
    public final Integer[] INTEGER_RED_ALL_DRAWABLE = {
            R.drawable.trash_blue_1,
            R.drawable.trash_blue_2,
            R.drawable.trash_blue_1,
            R.drawable.trash_blue_2,
            R.drawable.trash_blue_1
    };

    public final String[] STRING_PURPLE_ALL_DESC = {
            "Celular",
            "Impresora",
            "Teclado",
            "Mouse",
            "Monitor"
    };
    public final Integer[] INTEGER_PURPLE_ALL_DRAWABLE = {
            R.drawable.trash_blue_1,
            R.drawable.trash_blue_2,
            R.drawable.trash_blue_1,
            R.drawable.trash_blue_2,
            R.drawable.trash_blue_1
    };

    public final String[] STRING_BLACK_ALL_DESC = {
            "Bolsas con basura"
    };

    public final Integer[] INTEGER_BLACK_ALL_DRAWABLE = {
            R.drawable.trash_black_1
    };

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
}