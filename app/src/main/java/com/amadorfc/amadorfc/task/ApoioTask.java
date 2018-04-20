package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.ApoioController;
import com.amadorfc.amadorfc.controller.ArtilhariaController;
import com.amadorfc.amadorfc.rest.apoio.Apoio;
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.task.listener.ApoioListener;
import com.amadorfc.amadorfc.task.listener.ArtilhariaListener;

import java.util.List;

public class ApoioTask extends AsyncTask<String, Void, List<Apoio>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private ApoioListener listener;
    private String errMessage;
    private int campeonato;

    public ApoioTask(final AmadorfcApplication application, final Activity activity, final ApoioListener listener, final int campeonato) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);
        this.campeonato = campeonato;
    }

    @Override
    protected List<Apoio> doInBackground(String... params) {
        try {

            List<Apoio> retornar = ApoioController.loadApoio(application, getCampeonato());
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Apoio> b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarApoio(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando Apoio", true, false);
    }

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }
}
