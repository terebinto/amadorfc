package com.amadorfc.amadorfc.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.controller.BannerController;
import com.amadorfc.amadorfc.controller.UsuarioController;
import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.usuario.Usuario;
import com.amadorfc.amadorfc.task.listener.AtivaCadastroListener;
import com.amadorfc.amadorfc.task.listener.BannerListener;

import java.util.List;


/**
 * Task utilizada para validar tasks
 * @since  30/09/2015
 * @author alexandre
 */
public class BannerTask extends AsyncTask<String, Void, List<Banner>> {

    private AmadorfcApplication application;
    private Activity activity;
    private ProgressDialog progressDialog;
    private BannerListener listener;
    private String errMessage;

    public BannerTask(
            final AmadorfcApplication application, final Activity activity, final BannerListener listener) {
        this.application = application;
        this.activity = activity;
        this.listener = listener;
        this.application.registra(this);

    }

    @Override
    protected List<Banner>  doInBackground(String... params) {
        try {
            List<Banner>  retorno = BannerController.loadBanners(application);
            return retorno;
        } catch (RestException e) {
            errMessage = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute( List<Banner>  b) {
        super.onPostExecute(b);
        if (!isCancelled()) {
            progressDialog.dismiss();
            application.desregistra(this);
            listener.loadBanners(b);
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
        progressDialog = ProgressDialog.show(activity, "Aguarde", "Carregando banners ", true, false);
    }
}
