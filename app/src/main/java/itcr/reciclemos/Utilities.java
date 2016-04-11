package itcr.reciclemos;

import android.content.Context;
import android.graphics.Point;
import android.widget.Toast;

/**
 * Created by gesab on 4/11/2016.
 */
public class Utilities {
    public final Point POINT_BACKGROUND = new Point(1067, 711);
    public final Point POINT_D_MAIN_RECYCLE = new Point(123, 81);
    public final Point POINT_C_MAIN_RECYCLE = new Point(50, 20);
    public final Point POINT_D_MAIN_HOUSE = new Point(294, 214);
    public final Point POINT_C_MAIN_HOUSE = new Point(199, 80);
    public final Point POINT_D_MAIN_LAKE = new Point(276, 47);
    public final Point POINT_C_MAIN_LAKE = new Point(501, 72);
    public final Point POINT_D_MAIN_FOREST = new Point(232, 214);
    public final Point POINT_C_MAIN_FOREST = new Point(785, 72);
    public final Point POINT_D_MAIN_ABOUT = new Point(149, 74);
    public final Point POINT_C_MAIN_ABOUT = new Point(650, 530);

    public Point adjustAspect(Point originalDimension, Point currentScreenSize){
        double xScale;
        double yScale;
        if(POINT_BACKGROUND.x < currentScreenSize.x){
            xScale = (double)currentScreenSize.x / POINT_BACKGROUND.x;
        }
        else{
            xScale = (double)POINT_BACKGROUND.x / currentScreenSize.x;
        }
        if(POINT_BACKGROUND.y < currentScreenSize.y){
            yScale = (double)currentScreenSize.y / POINT_BACKGROUND.y;
        }
        else{
            yScale = (double)POINT_BACKGROUND.y / currentScreenSize.y;
        }
        int intNewX = (int) (xScale * originalDimension.x);
        int intNewY = (int) (yScale * originalDimension.y);
        return new Point(intNewX, intNewY);
    }
}
