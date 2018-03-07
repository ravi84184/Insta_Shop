package ravi.com.instashop;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private Runnable mRunnable;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView tx = (TextView)findViewById(R.id.textview);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/style.otf");
        tx.setTypeface(custom_font);
        mHandler.postDelayed(mRunnable = new Runnable() {
            @Override
            public void run() {
                callActivity();
            }
        }, SPLASH_TIME_OUT);
    }
    private void callActivity() {

            startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
            finish();

    }
}
