package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacao;
import com.amadorfc.amadorfc.task.AtivaCadastroTask;
import com.amadorfc.amadorfc.task.BannerTask;
import com.amadorfc.amadorfc.task.ClassificacaoTask;
import com.amadorfc.amadorfc.task.listener.BannerListener;
import com.amadorfc.amadorfc.task.listener.ClassificacaoListener;
import com.fasterxml.jackson.core.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SplashScreen extends Activity{

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, SplashScreen2.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


}
