package aidanc.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by aidan on 11/3/2017.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private final static String TAG = "GameView";

    public final static int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final static int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;

    private GameThread gameThread;
    private GameEngine gameEngine;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);

        gameThread = new GameThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated");

        gameEngine = new GameEngine(gameThread);
        gameEngine.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");

        gameEngine.stop();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if(canvas != null) {
            canvas.drawColor(Color.WHITE);
        }
    }

    public boolean onSpriteClick(Sprite sprite, float x, float y) {

        boolean inBoundaries = false;

        float xCoord = sprite.getX();
        float yCoord = sprite.getY();
        float width = sprite.getSpriteWidth();
        float height = sprite.getSpriteHeight();

        if(x >= xCoord && x <= (xCoord + width)) {

            if(y >= yCoord && y <= (yCoord + height)) {
                inBoundaries = true;
            }
        }

        return inBoundaries;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }
}
