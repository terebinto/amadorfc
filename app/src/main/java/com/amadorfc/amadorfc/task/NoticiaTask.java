package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.NoticiaController;
import com.amadorfc.amadorfc.controller.ProximosJogosController;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.amadorfc.amadorfc.task.listener.NoticiasListener;
import com.amadorfc.amadorfc.task.listener.ProximosJogosListener;

import java.util.List;

public class NoticiaTask extends AsyncTask<String, Void, List<Noticia>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private NoticiasListener listener;
    private String errMessage;

    public NoticiaTask(final AmadorfcApplication application, final Activity activity, final NoticiasListener listener) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);

    }

    @Override
    protected List<Noticia> doInBackground(String... params) {
        try {

            List<Noticia> retornar = NoticiaController.loadNoticias(application);
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Noticia> b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarNoticias(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando Noticias", true, false);
    }
}
