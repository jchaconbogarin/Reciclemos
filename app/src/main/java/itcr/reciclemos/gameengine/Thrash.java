package itcr.reciclemos.gameengine;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 * Created by Boga on 11.04.2016.
 */
public class Thrash extends Element implements View.OnTouchListener {

    boolean isMoving = false;

    public Thrash(final ImageView imageView, ThrashType thrashType, ElementController controller) {
        super(imageView, ElementType.THRASH, thrashType, controller);
        imageView.setOnTouchListener(this);
        ViewTreeObserver vto = imageView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                originalX = imageView.getX();
                originalY = imageView.getY();
            }
        });
    }

    public boolean onTouch(View view, MotionEvent event) {

        switch(event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                isMoving = true;
                break;

            case MotionEvent.ACTION_MOVE:
                if(isMoving) {
                    x = event.getRawX() - imageView.getWidth()/2;
                    y = event.getRawY() - imageView.getHeight()*3/2;
                    imageView.setX(x);
                    imageView.setY(y);
                }
                break;

            case MotionEvent.ACTION_UP:
                this.controller.checkCollision(this);
                isMoving = false;
                imageView.setX(this.originalX);
                imageView.setY(this.originalY);
                break;
        }
        return true;
    }

    @Override
    public boolean checkCollision(Element element){
        return true;
    }

}
