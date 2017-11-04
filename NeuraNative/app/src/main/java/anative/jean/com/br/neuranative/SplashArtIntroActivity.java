package anative.jean.com.br.neuranative;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anative.jean.com.br.neuranative.R;

public class SplashArtIntroActivity extends AppCompatActivity {

    private static int SPLAH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_art_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(getBaseContext(), ChoseActivity.class);
                startActivity(it);
                finish();
            }
        }, SPLAH_TIME_OUT);
    }
}
