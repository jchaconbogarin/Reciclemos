package itcr.reciclemos.gameengine;

/**
 * Created by Boga on 11.04.2016.
 */

import android.app.Activity;
import android.graphics.Point;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import itcr.reciclemos.Utilities;

/**
 * Created by Boga on 11.04.2016.
 */
public class ElementController {

    List<Thrash> allThrash;
    List<ThrashCan> thrashCans;
    private Utilities toolBox = Utilities.getSingleton();

    public ElementController() {
        allThrash = new ArrayList<>();
        thrashCans = new ArrayList<>();
    }

    /*
    *
    *   Funciones de Soporte para Elementos
    *
    * */

    public List getAllTrash() {
        return allThrash;
    }

    public void createThrash(ImageView imageView, ThrashType thrashType) {
        allThrash.add(new Thrash(imageView, thrashType, this));
    }

    public void removeThrash(Thrash thrash) {
        allThrash.remove(thrash);
    }

    public void createThrashCan(ImageView imageView, ThrashType thrashType) {
        thrashCans.add(new ThrashCan(imageView, thrashType, this));
    }

    /*
    *
    *   Funciones de Soporte de Juego
    *
    * */

    public boolean checkCollision(Element element) {
        boolean result = false;
        for (ThrashCan thrashCan : this.thrashCans) {
            if (thrashCan.checkCollision(element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public List<ImageView> createAllThrash(Activity activity, int maxThrash, ThrashType[] types) {
        List<ImageView> ivList = new ArrayList<>();
        Random r = new Random();
        int trashQuantity = r.nextInt(maxThrash) + 1;
        //Point trashLocations[] = new Point[];     //Conserva las coordenadas donde se genero para no repetir

        int trashNumber;
        Point coords;
        for (ThrashType thrashType : types) {
            for (int i = 0; i < trashQuantity; i++) {
                ImageView iv = new ImageView(activity);
                iv.setImageResource(toolBox.getRandomImage(thrashType));
                coords = new Point(r.nextInt(toolBox.POINT_BACKGROUND.x - toolBox.POINT_D_ALL_THRASH.x)+1, r.nextInt(toolBox.POINT_BACKGROUND.y - toolBox.POINT_C_ALL_PLAYABLE_TOP - toolBox.POINT_C_ALL_PLAYABLE_BOTTOM) + toolBox.POINT_C_ALL_PLAYABLE_BOTTOM);
                iv.setLayoutParams(toolBox.positionImage(coords, toolBox.POINT_D_ALL_THRASH));
                ivList.add(iv);
                this.createThrash(iv, thrashType);
            }
            trashQuantity = r.nextInt(maxThrash) + 1;
        }
        return ivList;
    }

}

