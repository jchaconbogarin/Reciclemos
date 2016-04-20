package itcr.reciclemos.gameengine;

import android.graphics.Rect;
import android.provider.Settings;
import android.widget.ImageView;

/**
 * Created by Boga on 11.04.2016.
 */
public class ThrashCan extends Element {

    public ThrashCan(ImageView imageView, ThrashType thrashType, ElementController controller) {
        super(imageView, ElementType.THRASH_CAN, thrashType, controller);
        this.updateCollisionRectangle();
    }

    @Override
    public boolean checkCollision(Element element) {
        if (Rect.intersects(this.updateCollisionRectangle(), element.updateCollisionRectangle())) {
            if (this.thrashType == element.thrashType) {
                element.imageView.setImageResource(0);
            }
        }
        return true;
    }

}

