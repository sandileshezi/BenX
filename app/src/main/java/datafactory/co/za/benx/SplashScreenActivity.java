package datafactory.co.za.benx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import datafactory.co.za.benx.R;

/**
 * Created by sandile.shezi on 2017/08/25.
 */
public class SplashScreenActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(SPLASH_DISPLAY_LENGTH);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}