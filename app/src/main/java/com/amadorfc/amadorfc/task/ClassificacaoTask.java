package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.BannerController;
import com.amadorfc.amadorfc.controller.EquipeClassificacaoController;
import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacao;
import com.amadorfc.amadorfc.task.listener.BannerListener;
import com.amadorfc.amadorfc.task.listener.ClassificacaoListener;

import java.util.List;


/**
 * Task utilizada para validar tasks
 * @since  30/09/2015
 * @author alexandre
 */
public class ClassificacaoTask extends AsyncTask<String, Void, List<EquipeClassificacao>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private ClassificacaoListener listener;
    private String errMessage;
    private int campeonato;

    public ClassificacaoTask(
            final AmadorfcApplication application, final Activity activity, final ClassificacaoListener listener, final int campeonato) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);
        this.campeonato = campeonato;

    }

    @Override
    protected List<EquipeClassificacao>  doInBackground(String... params) {
        try {
            List<EquipeClassificacao>  retorno = EquipeClassificacaoController.loadClassificacao(application,getCampeonato());
            return retorno;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute( List<EquipeClassificacao>  b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.loadClassificacao(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando classificação ", true, false);
    }

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }
}
