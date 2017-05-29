package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.CampeonatoController;
import com.amadorfc.amadorfc.controller.UsuarioController;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.usuario.Usuario;
import com.amadorfc.amadorfc.task.listener.AtivaCadastroListener;
import com.amadorfc.amadorfc.task.listener.CampeonatoListener;

import java.util.List;


/**
 * Task utilizada para validar pre cadastro do usuario
 *
 * @author TIVIT
 * @since 30/09/2015
 */
public class CampeonatoTask extends AsyncTask<String, Void, List<Campeonato>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private CampeonatoListener listener;
    private String errMessage;

    public CampeonatoTask(
            final AmadorfcApplication application, final Activity activity, final CampeonatoListener listener) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);

    }

    @Override
    protected List<Campeonato> doInBackground(String... params) {
        try {
            List<Campeonato> retornar = CampeonatoController.loadCampeonatos(application);
            return retornar;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Campeonato> b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarCampeonatos(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando campeonato", true, false);
    }
}
