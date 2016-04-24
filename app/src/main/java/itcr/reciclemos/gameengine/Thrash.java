package itcr.reciclemos.gameengine;

import android.media.Image;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                isMoving = true;
                break;

            case MotionEvent.ACTION_MOVE:
                if (isMoving) {
                    x = event.getRawX() - imageView.getWidth() / 2;
                    y = event.getRawY() - imageView.getHeight() * 3 / 2;
                    imageView.setX(x);
                    imageView.setY(y);
                }
                break;

            case MotionEvent.ACTION_UP:
                isMoving = false;
                CollisionType collisionCheck = this.controller.checkCollision(this);
                switch (collisionCheck) {
                    case CORRECT_THRASH_CAN:
                        animate(R.drawable.score_increase);
                        controller.removeThrash(this);
                        break;
                    case WRONG_THRASH_CAN:
                        animate(R.drawable.score_decrease);
                        controller.removeThrash(this);
                        break;
                    default:
                        imageView.setX(this.originalX);
                        imageView.setY(this.originalY);
                        break;
                }
                break;
        }
        return true;
    }

    public void animate(int resource) {
        imageView.setImageResource(resource);
        Animation animation = getAnimation();
        imageView.startAnimation(animation);
    }

    private Animation getAnimation() {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(500);
        fadeOut.setDuration(1000);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setX(-1000);
                imageView.setY(-1000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        return fadeOut;
    }

    @Override
    public CollisionType checkCollision(Element element) {
        return CollisionType.NO_COLLISION;
    }

}
