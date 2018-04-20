package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.ArtilhariaController;
import com.amadorfc.amadorfc.controller.CartaoAmareloController;
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.cartao.Cartao;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.task.listener.ArtilhariaListener;
import com.amadorfc.amadorfc.task.listener.CartaoAmareloListener;

import java.util.List;

public class CartaoAmareloTask extends AsyncTask<String, Void, List<Cartao>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private CartaoAmareloListener listener;
    private String errMessage;
    private int  campeonato;

    public CartaoAmareloTask(final AmadorfcApplication application, final Activity activity, final CartaoAmareloListener listener,final int campeonato) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);
        this.campeonato=campeonato;

    }

    @Override
    protected List<Cartao> doInBackground(String... params) {
        try {

            List<Cartao> retornar = CartaoAmareloController.loadCartaoAmarelos(application,getCampeonato());
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Cartao> b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregaCartoesAmarelos(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando Cartoões Amarelos", true, false);
    }

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }
}
