package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.service.verJogo.VerJogoService;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartida;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaRequest;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaResponse;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 *
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class VerJogoController {

    public static FichaPartida loadVerJogo(final Context context, final int idJogo) {
        try {
            Log.i("Carregando getVerJogo", "INICIO");
            FichaPartidaRequest request = new FichaPartidaRequest();
            request.setIdJogo(idJogo);

            FichaPartidaResponse response = new VerJogoService().execute(request);
            return response.getFichaPartida();
        } finally {
            Log.i("getNoticias carregados", "FIM");
        }
    }
}
