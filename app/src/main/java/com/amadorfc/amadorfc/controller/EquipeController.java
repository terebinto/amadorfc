package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.equipe.Equipe;
import com.amadorfc.amadorfc.rest.equipe.EquipeRequest;
import com.amadorfc.amadorfc.rest.equipe.EquipeResponse;
import com.amadorfc.amadorfc.rest.service.banner.BannerService;
import com.amadorfc.amadorfc.rest.service.equipe.EquipeService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 *
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class EquipeController {

    public static Equipe carregarEquipePorId(final Context context) {
        try {
            Log.i("Carregando equipe", "INICIO");
            EquipeRequest request = new EquipeRequest();
            request.setTid(2);

            EquipeResponse response = new EquipeService().execute(request);
            return response.getEquipe();
        } finally {
            Log.i("Equipe carregada...", "FIM");
        }
    }
}
