package aidanc.game;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by aidan on 11/3/2017.
 */

public class GameThread extends Thread {

    private final static String TAG = "GameThread";

    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private GameEngine gameEngine;

    private Canvas canvas;

    private boolean running;

    public GameThread(SurfaceHolder sHolder, GameView gView) {
        super();

        surfaceHolder = sHolder;
        gameView = gView;
    }

    public void initialize(GameEngine gEngine) {
        gameEngine = gEngine;
    }

    public void setRunning(boolean isRunning) { running = isRunning;}

    @Override
    public void run() {

        Log.d(TAG, "run: Started");

        while(running) {

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder) {
                    gameEngine.update();
                    gameView.draw(canvas);
                }

            } catch(Exception e) {
                Log.e(TAG, "run: Exception drawing to canvas. " + e.getMessage());
            } finally {

                if(canvas != null) {

                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch(Exception e) {
                        Log.e(TAG, "run: Exception unlocking canvas. " + e.getMessage());
                    }
                }
            }
        }
    }
}
