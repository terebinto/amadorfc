package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosRequest;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosResponse;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogosRequest;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogosResponse;
import com.amadorfc.amadorfc.rest.service.jogosRealizados.JogosRealizadosService;
import com.amadorfc.amadorfc.rest.service.proximosJogos.ProximosJogosService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class JogosRealizadosController {

    public static List<JogosRealizados> loadJogosRealizados(final Context context, int campeonato) {
        try {
            Log.i("Carregando jogos real", "INICIO");
            JogosRealizadosRequest request = new JogosRealizadosRequest();
            //setar o campeonato
            request.setCampeonato(campeonato);
            JogosRealizadosResponse response = new JogosRealizadosService().execute(request);

            return response.getUltimosJogos();
        } finally {
            Log.i("prox jogos carregados", "FIM");
        }
    }
}
