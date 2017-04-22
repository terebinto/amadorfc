package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacao;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacaoRequest;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacaoResponse;
import com.amadorfc.amadorfc.rest.service.banner.BannerService;
import com.amadorfc.amadorfc.rest.service.equipeClassificacao.EquipeClassificacaoService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class EquipeClassificacaoController {

    public static List<EquipeClassificacao> loadClassificacao(final Context context) {
        try {
            Log.i("Carregando clas", "INICIO");
            EquipeClassificacaoRequest request = new EquipeClassificacaoRequest();
            request.seasson = 8;

            EquipeClassificacaoResponse response = new EquipeClassificacaoService().execute(request);

            return response.getEquipeClassificacao();
        } finally {
            Log.i("CLASSIFIACAO carregados", "FIM");
        }
    }
}
