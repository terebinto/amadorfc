package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.JogosRealizadosController;
import com.amadorfc.amadorfc.controller.ProximosJogosController;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.amadorfc.amadorfc.task.listener.JogosRealizadosListener;
import com.amadorfc.amadorfc.task.listener.ProximosJogosListener;

import java.util.List;


/**
 * Task utilizada para validar pre cadastro do usuario
 *
 * @author TIVIT
 * @since 30/09/2015
 */
public class JogosRealizadosTask extends AsyncTask<String, Void, List<JogosRealizados>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private JogosRealizadosListener listener;
    private String errMessage;
    private int  campeonato;

    public JogosRealizadosTask(final AmadorfcApplication application, final Activity activity, final JogosRealizadosListener listener,final int campeonato) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);
        this.campeonato = campeonato;

    }

    @Override
    protected List<JogosRealizados> doInBackground(String... params) {
        try {

            List<JogosRealizados> retornar = JogosRealizadosController.loadJogosRealizados(application,getCampeonato());
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<JogosRealizados> b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarJogosRealizados(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Jogos Realizados...", true, false);
    }

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }
}
