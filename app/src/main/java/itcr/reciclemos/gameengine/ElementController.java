package itcr.reciclemos.gameengine;

/**
 * Created by Boga on 11.04.2016.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import itcr.reciclemos.GameActivity;
import itcr.reciclemos.Utilities;
import itcr.reciclemos.gameutilities.Progress;

/**
 * Created by Boga on 11.04.2016.
 */
public class ElementController {

    GameActivity activity;
    List<Thrash> allThrash;
    List<ThrashCan> thrashCans;
    float score = 0;
    private Utilities toolBox = Utilities.getSingleton();

    public ElementController(GameActivity activity) {
        this.activity = activity;
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
        if (allThrash.isEmpty()) {
            activity.setCompleted();
            Toast.makeText(activity, "Your score is: " + score, Toast.LENGTH_LONG).show();
        }
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
            if (thrashCan.checkCollision(element) == CollisionType.CORRECT_THRASH_CAN) {
                score += 10;
                result = true;
                break;
            } else if (thrashCan.checkCollision(element) == CollisionType.WRONG_THRASH_CAN) {
                score -= 5;
                break;
            }
        }
        return result;
    }

    public List<ImageView> createAllThrash(int maxThrash, ThrashType[] types) {
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

                Toast.makeText(activity.getApplicationContext(), "X=" + coords.x + "    /   Y=" + coords.y, Toast.LENGTH_SHORT).show();

                iv.setLayoutParams(toolBox.positionImage(coords, toolBox.POINT_D_ALL_THRASH));
                ivList.add(iv);
                this.createThrash(iv, thrashType);
            }
            trashQuantity = r.nextInt(maxThrash) + 1;
        }
        return ivList;
    }

}

