package com.amadorfc.amadorfc.utilitarios.http;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author TIVIT
 * @since  28/01/2016.
 */
public class HttpHelper {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType URL_ENCODED = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    public String post(String url, MediaType mediaType, String content) throws IOException {

        Log.i("Post URL", url);
        RequestBody body = RequestBody.create(mediaType, content);

        Log.i("Payload", content);
        Request.Builder builder = new Request.Builder();

        Request request = builder.url(url).post(body).build();

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS); // connect timeout
        client.setReadTimeout(10, TimeUnit.MINUTES);    // socket timeout
        Response response = client.newCall(request).execute();
        String responceString = response.body().string();
        Log.i("Response ", responceString);
        return responceString;
    }

    public String get(String url) throws IOException {
        Log.i("Get URL", url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(15, TimeUnit.SECONDS); // connect timeout
        client.setReadTimeout(10, TimeUnit.MINUTES);    // socket timeout
        Response response = client.newCall(request).execute();
        String responceString = response.body().string();
        Log.i("Response ", responceString);
        return responceString;
    }

}

