package itcr.reciclemos.gameengine;

/**
 * Created by Boga on 11.04.2016.
 */

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boga on 11.04.2016.
 */
public class ElementController {

    List<Thrash> allThrash;
    List<ThrashCan> thrashCans;

    public ElementController() {
        allThrash = new ArrayList<>();
        thrashCans = new ArrayList<>();
    }

    /*
    *
    *   Funciones de Soporte para Elementos
    *
    * */

    public void createThrash(ImageView imageView, ThrashType thrashType) {
        allThrash.add(new Thrash(imageView, thrashType, this));
    }

    public void createThrashCan(ImageView imageView, ThrashType thrashType) {
        thrashCans.add(new ThrashCan(imageView, thrashType, this));
    }

    /*
    *
    *   Funciones de Soporte de Juego
    *
    * */

    public void checkCollision(Element element) {

        for (ThrashCan thrashCan : this.thrashCans) {
            thrashCan.checkCollision(element);
        }

    }

}

