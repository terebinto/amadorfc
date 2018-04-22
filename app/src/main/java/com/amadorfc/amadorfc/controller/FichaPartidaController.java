package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartida;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaRequest;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaResponse;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosRequest;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosResponse;
import com.amadorfc.amadorfc.rest.service.fichaPartida.FichaPartidaService;
import com.amadorfc.amadorfc.rest.service.jogosRealizados.JogosRealizadosService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 *
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class FichaPartidaController {

    public static FichaPartida loadFichaPartida(final Context context, int idJogo) {
        try {
            Log.i("Carregando fica", "INICIO");
            FichaPartidaRequest request = new FichaPartidaRequest();
            request.setIdJogo(idJogo);
            FichaPartidaResponse response = new FichaPartidaService().execute(request);

            return response.getFichaPartida();
        } finally {
            Log.i("ficha carregados", "FIM");
        }
    }
}
