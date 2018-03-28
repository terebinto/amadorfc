package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.CampeonatoController;
import com.amadorfc.amadorfc.controller.ProximosJogosController;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.amadorfc.amadorfc.task.listener.CampeonatoListener;
import com.amadorfc.amadorfc.task.listener.ProximosJogosListener;

import java.io.InputStream;
import java.net.URL;
import java.util.List;


/**
 * Task utilizada para validar pre cadastro do usuario
 *
 * @author TIVIT
 * @since 30/09/2015
 */
public class ProximosJogosTask extends AsyncTask<String, Void, List<ProximosJogos>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private ProximosJogosListener listener;
    private String errMessage;
    private int  campeonato;

    public ProximosJogosTask(final AmadorfcApplication application, final Activity activity, final ProximosJogosListener listener, final int campeonato) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);
        this.campeonato = campeonato;

    }

    @Override
    protected List<ProximosJogos> doInBackground(String... params) {
        try {

            List<ProximosJogos> retornar = ProximosJogosController.loadProximosJogos(application, getCampeonato());
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<ProximosJogos> b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarProximosJogos(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando Jogos...", true, false);
    }

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }
}
