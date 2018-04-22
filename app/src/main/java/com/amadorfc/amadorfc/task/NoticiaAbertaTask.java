package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.NoticiaController;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.task.listener.NoticiaAbertaListener;
import com.amadorfc.amadorfc.task.listener.NoticiasListener;

import java.util.List;

public class NoticiaAbertaTask extends AsyncTask<String, Void, Noticia> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private NoticiaAbertaListener listener;
    private String errMessage;
    private Noticia noticia;

    public NoticiaAbertaTask(final AmadorfcApplication application, final Activity activity, final NoticiaAbertaListener listener, final Noticia noticia) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);
        this.noticia = noticia;

    }

    @Override
    protected Noticia doInBackground(String... params) {
        try {

            return new Noticia();
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Noticia b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarNoticia(b);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        progressDialog.dismiss();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando Noticia", true, false);
    }


    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
}
