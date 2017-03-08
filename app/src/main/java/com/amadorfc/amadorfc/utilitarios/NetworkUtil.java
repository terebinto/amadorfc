package com.amadorfc.amadorfc.utilitarios;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by root on 4/13/16.
 */
public class NetworkUtil {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if (networkInfo != null
                && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }

}
