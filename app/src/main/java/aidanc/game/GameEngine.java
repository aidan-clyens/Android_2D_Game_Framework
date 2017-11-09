package aidanc.game;

import android.util.Log;

/**
 * Created by aidan on 11/9/2017.
 */

public class GameEngine {

    private final static String TAG = "GameEngine";

    private GameThread gameThread;
    private boolean paused;

    public GameEngine(GameThread gThread) {
        gameThread = gThread;
    }

    public void update() {

    }

    public void start() {
        Log.d(TAG, "start: GameEngine started");

        paused = false;

        gameThread.initialize(this);
        gameThread.setRunning(true);
        gameThread.start();
    }

    public void stop() {
        Log.d(TAG, "stop: GameEngine stopped");

        boolean retry = true;

        while(retry) {

            try {
                if(gameThread != null) {
                    gameThread.setRunning(false);
                    gameThread.join();
                }

                Log.d(TAG, "stop: Stopping GameThread successful.");

            } catch(InterruptedException e) {
                Log.e(TAG, "stop: Error stopping GameThread: " + e.getMessage());
            }

            retry = false;
        }
    }

    public void pause() {
        Log.d(TAG, "pause: GameEngine paused");
        paused = true;
    }

    public void resume() {
        Log.d(TAG, "resume: GameEngine resumed");
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }
}
