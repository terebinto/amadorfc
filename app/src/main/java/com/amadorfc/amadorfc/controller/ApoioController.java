package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.apoio.Apoio;
import com.amadorfc.amadorfc.rest.apoio.ApoioRequest;
import com.amadorfc.amadorfc.rest.apoio.ApoioResponse;
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaRequest;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaResponse;
import com.amadorfc.amadorfc.rest.service.apoio.ApoioService;
import com.amadorfc.amadorfc.rest.service.artilharia.ArtilhariaService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 *
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class ApoioController {

    public static List<Apoio> loadApoio(final Context contextm, final int campeonato) {
        try {
            Log.i("Carregando Apoio", "INICIO");
            ApoioRequest request = new ApoioRequest();

            //setar campeonato
            request.campeonato = campeonato;

            ApoioResponse response = new ApoioService().execute(request);
            return response.getApoio();
        } finally {
            Log.i("getApoio carregados", "FIM");
        }
    }
}
