package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaRequest;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaResponse;
import com.amadorfc.amadorfc.rest.cartao.Cartao;
import com.amadorfc.amadorfc.rest.cartao.CartaoRequest;
import com.amadorfc.amadorfc.rest.cartao.CartaoResponse;
import com.amadorfc.amadorfc.rest.service.artilharia.ArtilhariaService;
import com.amadorfc.amadorfc.rest.service.cartaoAmarelo.CartaoAmareloService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 *
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class CartaoAmareloController {

    public static List<Cartao> loadCartaoAmarelos(final Context context, int campeonato) {
        try {
            Log.i("Carregando getCart", "INICIO");
            CartaoRequest request = new CartaoRequest();

            request.setCampeonato(campeonato);

            CartaoResponse response = new CartaoAmareloService().execute(request);
            return response.getCartoes();
        } finally {
            Log.i("getCartoes carregados", "FIM");
        }
    }
}
