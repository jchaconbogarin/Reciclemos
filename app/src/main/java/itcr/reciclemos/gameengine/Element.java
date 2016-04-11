package itcr.reciclemos.gameengine;

import android.graphics.Rect;
import android.widget.ImageView;

/**
 * Created by Boga on 11.04.2016.
 */
enum ElementType {
    THRASH_CAN, THRASH
}
enum ThrashType {BLUE, GREEN, YELLOW, GRAY, PURPLE, BLACK}

public abstract class Element {

    protected ImageView imageView;
    protected Rect collisionRectangle;
    protected ElementType elementType;
    protected ThrashType thrashType;
    protected ElementController controller;
    protected float x;
    protected float y;
    protected float originalX;
    protected float originalY;

    public Element(ImageView imageView, ElementType elementType, ThrashType thrashType, ElementController controller) {
        this.imageView = imageView;
        this.elementType = elementType;
        this.thrashType = thrashType;
        this.x = 0.0f;
        this.y = 0.0f;
        this.controller = controller;
        this.collisionRectangle = new Rect();
    }

    public ImageView getImageview() {
        return imageView;
    }

    public void setController(ElementController controller) {
        this.controller = controller;
    }

    public Rect updateCollisionRectangle() {
        imageView.getHitRect(this.collisionRectangle);
        return this.collisionRectangle;
    }

    public void removeImage() {
        imageView.setBackground(null);
    }

    public abstract boolean checkCollision(Element element);

}



