package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.ArtilhariaController;
import com.amadorfc.amadorfc.controller.NoticiaController;
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.task.listener.ArtilhariaListener;
import com.amadorfc.amadorfc.task.listener.NoticiasListener;

import java.util.ArrayList;
import java.util.List;

public class ArtilhariaTask extends AsyncTask<String, Void, List<Artilharia>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private ArtilhariaListener listener;
    private String errMessage;

    public ArtilhariaTask(final AmadorfcApplication application, final Activity activity, final ArtilhariaListener listener) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);

    }

    @Override
    protected List<Artilharia> doInBackground(String... params) {
        try {

            List<Artilharia> retornar = ArtilhariaController.loadArtilharia(application);
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Artilharia> b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarArtilharia(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando Artilharia", true, false);
    }
}
