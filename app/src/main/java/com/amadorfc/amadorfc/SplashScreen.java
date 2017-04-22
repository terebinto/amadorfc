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

public class SplashScreen extends Activity  implements ClassificacaoListener {

    String now_playing, earned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ClassificacaoTask mTask = new ClassificacaoTask((AmadorfcApplication) this.getApplicationContext(), SplashScreen.this, SplashScreen.this);
        mTask.execute();


        /**
         * Showing splashscreen while making network calls to download necessary
         * data before launching the app Will use AsyncTask to make http call
         */
        new PrefetchData().execute();

    }

    @Override
    public void loadClassificacao(List<EquipeClassificacao> classificacao) {

        /*for (Banner ban : banners){

            now_playing = ban.getDescricao();
            earned = ban.getNomeBanner();
        }*/

        Log.e("JSON", "> " + now_playing + earned);

    }

    /**
     * Async Task to make http call
     */
    private class PrefetchData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // before making http calls

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            String json = null;

            if (json != null) {
                try {
                    JSONObject jObj = new JSONObject(json)
                            .getJSONObject("game_stat");
                    now_playing = jObj.getString("now_playing");
                    earned = jObj.getString("earned");

                    Log.e("JSON", "> " + now_playing + earned);

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // After completing http call
            // will close this activity and lauch main activity
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            i.putExtra("now_playing", now_playing);
            i.putExtra("earned", earned);
            startActivity(i);

            // close this activity
            finish();
        }

    }

}
