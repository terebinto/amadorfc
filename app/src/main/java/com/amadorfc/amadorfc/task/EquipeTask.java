package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.BannerController;
import com.amadorfc.amadorfc.controller.EquipeController;
import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.equipe.Equipe;
import com.amadorfc.amadorfc.task.listener.BannerListener;
import com.amadorfc.amadorfc.task.listener.EquipeListener;

import java.util.List;


/**
 * Task utilizada para validar tasks
 * @since  30/09/2015
 * @author alexandre
 */
public class EquipeTask extends AsyncTask<String, Void, Equipe> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private EquipeListener listener;
    private String errMessage;

    public EquipeTask(
            final AmadorfcApplication application, final Activity activity, final EquipeListener listener) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);

    }

    @Override
    protected Equipe doInBackground(String... params) {
        try {
            Equipe eq = EquipeController.carregarEquipePorId(application);
            return eq;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Equipe b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.carregarEquipePorId(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando equipes ", true, false);
    }
}
