package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.campeonato.CampeonatoRequest;
import com.amadorfc.amadorfc.rest.campeonato.CampeonatoResponse;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogosRequest;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogosResponse;
import com.amadorfc.amadorfc.rest.service.campeonato.CampeonatoService;
import com.amadorfc.amadorfc.rest.service.proximosJogos.ProximosJogosService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class ProximosJogosController {

    public static List<ProximosJogos> loadProximosJogos(final Context context) {
        try {
            Log.i("Carregando prox jogos", "INICIO");
            ProximosJogosRequest request = new ProximosJogosRequest();

            ProximosJogosResponse response = new ProximosJogosService().execute(request);
            return response.getProximosJogos();
        } finally {
            Log.i("prox jogos carregados", "FIM");
        }
    }
}
