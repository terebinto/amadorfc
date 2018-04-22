package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.FichaPartidaController;
import com.amadorfc.amadorfc.controller.JogosRealizadosController;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartida;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.task.listener.FichaPartidaListener;
import com.amadorfc.amadorfc.task.listener.JogosRealizadosListener;

import java.util.List;


/**
 * Task utilizada para validar pre cadastro do usuario
 *
 * @author TIVIT
 * @since 30/09/2015
 */
public class FichaPartidaTask extends AsyncTask<String, Void, FichaPartida> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private FichaPartidaListener listener;
    private String errMessage;
    private int  idJogo;

    public FichaPartidaTask(final AmadorfcApplication application, final Activity activity, final FichaPartidaListener listener, final int idJogo) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);
        this.idJogo = idJogo;

    }

    @Override
    protected FichaPartida doInBackground(String... params) {
        try {

            Log.i("Jogo selecionado", String.valueOf(getIdJogo()));

            FichaPartida retornar = FichaPartidaController.loadFichaPartida(application,getIdJogo());
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(FichaPartida b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarFichaPartida(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Ficha da Partida...", true, false);
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }
}
