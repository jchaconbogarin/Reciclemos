package itcr.reciclemos.gameengine;

import android.graphics.Rect;
import android.widget.ImageView;

/**
 * Created by Boga on 11.04.2016.
 */
public class ThrashCan extends Element {

    public ThrashCan(ImageView image_view, ThrashType thrashType, ElementController controller) {
        super(image_view, ElementType.THRASH_CAN, thrashType, controller);
    }

    @Override
    public boolean checkCollision(Element element) {
        if (Rect.intersects(this.updateCollisionRectangle(), element.updateCollisionRectangle())) {
            if (this.thrashType == element.thrashType) {
                element.removeImage();
            }
        }
        return true;
    }

}

