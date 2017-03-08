package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.UsuarioController;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.usuario.Usuario;
import com.amadorfc.amadorfc.task.listener.AtivaCadastroListener;

import java.util.List;


/**
 * Task utilizada para validar pre cadastro do usuario
 * @since  30/09/2015
 * @author TIVIT
 */
public class AtivaCadastroTask extends AsyncTask<String, Void, List<Usuario>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private AtivaCadastroListener listener;
    private String errMessage;

    public AtivaCadastroTask(
            final AmadorfcApplication application, final Activity activity, final AtivaCadastroListener listener) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);

    }

    @Override
    protected  List<Usuario>  doInBackground(String... params) {
        try {
            List<Usuario>  ativaCadastro = UsuarioController.ativaCadastro(application);
            return ativaCadastro;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute( List<Usuario>  b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.ativaCadastroResposta(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Ativando cadastro", true, false);
    }
}
