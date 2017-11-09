package aidanc.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by aidan on 11/3/2017.
 */

public class GameActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GameView(this));
    }

    public void quitActivity() {
        Intent i = new Intent(GameActivity.this, MainActivity.class);
        startActivity(i);
    }
}
