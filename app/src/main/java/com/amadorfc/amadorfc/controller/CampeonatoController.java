package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.campeonato.CampeonatoRequest;
import com.amadorfc.amadorfc.rest.campeonato.CampeonatoResponse;
import com.amadorfc.amadorfc.rest.service.banner.BannerService;
import com.amadorfc.amadorfc.rest.service.campeonato.CampeonatoService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class CampeonatoController {

    public static List<Campeonato> loadCampeonatos(final Context context) {
        try {
            Log.i("Carregando campeonatos", "INICIO");
            CampeonatoRequest request = new CampeonatoRequest();

            CampeonatoResponse response = new CampeonatoService().execute(request);
            return response.getCampeonatos();
        } finally {
            Log.i("Campeonatos carregados", "FIM");
        }
    }
}
