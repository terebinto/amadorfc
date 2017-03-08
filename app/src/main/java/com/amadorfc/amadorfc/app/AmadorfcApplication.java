package com.amadorfc.amadorfc.app;
import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsavel pela aplicacao
 * @author TIVIT
 * @since 4/6/16.
 */
public class AmadorfcApplication extends Application {

    private static AmadorfcApplication instance;

    private SharedPreferences preferences;
    private List<AsyncTask<?,?,?>> tasks = new ArrayList<AsyncTask<?, ?, ?>>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        preferences = getSharedPreferences("configs", Activity.MODE_PRIVATE);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //Cancela tarefas
        for(AsyncTask task : tasks) {
            task.cancel(true);
        }
    }

    public static AmadorfcApplication getInstance() {
        return instance;
    }

    public void registra(AsyncTask<?,?,?> task) {
        Log.i("Registra", "Reginstrando AsyncTask: " + task);
        tasks.add(task);
    }

    public void desregistra(AsyncTask<?,?,?> task) {
        Log.i("Desregistra", "Desreginstrando AsyncTask: " + task);
        tasks.remove(task);
    }

    public void putStringSharedValue(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getStringSharedValue(String key) {
        return preferences.getString(key, null);
    }

}
