package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen2 extends Activity{

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen2.this, SplashScreen3.class);
                SplashScreen2.this.startActivity(mainIntent);
                SplashScreen2.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


}
