package aidanc.game;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by aidan on 11/9/2017.
 */

public abstract class Sprite extends View {

    private final static String TAG = "Sprite";

    private float x, y;

    public Sprite(Context context) {
        super(context);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    public void setX(float xCoord) {
        x = xCoord;
    }

    public void setY(float yCoord) {
        y = yCoord;
    }

    public abstract void update();

    public abstract float getSpriteWidth();

    public abstract float getSpriteHeight();
}
