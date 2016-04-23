package itcr.reciclemos.gameengine;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import itcr.reciclemos.R;

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
        this.updateCollisionRectangle();
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
                isMoving = false;
                if (this.controller.checkCollision(this)) {
                    imageView.setImageResource(R.drawable.mas_puntaje);
                    //imageView.setX(-1000);
                    //imageView.setY(-1000);
                    controller.removeThrash(this);
                } else {
                    imageView.setX(this.originalX);
                    imageView.setY(this.originalY);
                }
                break;
        }
        return true;
    }

    @Override
    public CollisionType checkCollision(Element element){
        return CollisionType.NO_COLLISION;
    }

}
