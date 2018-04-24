package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen3 extends Activity{

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen3.this, MainActivity.class);
                SplashScreen3.this.startActivity(mainIntent);
                SplashScreen3.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


}
