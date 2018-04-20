package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaRequest;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaResponse;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.rest.noticia.NoticiaRequest;
import com.amadorfc.amadorfc.rest.noticia.NoticiaResponse;
import com.amadorfc.amadorfc.rest.service.artilharia.ArtilhariaService;
import com.amadorfc.amadorfc.rest.service.noticia.NoticiaService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 *
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class ArtilhariaController {

    public static List<Artilharia> loadArtilharia(final Context contextm, final int campeonato) {
        try {
            Log.i("Carregando getArt", "INICIO");
            ArtilhariaRequest request = new ArtilhariaRequest();

            //setar campeonato
            request.campeonato = campeonato;

            ArtilhariaResponse response = new ArtilhariaService().execute(request);
            return response.getArtilheiros();
        } finally {
            Log.i("getNoticias carregados", "FIM");
        }
    }
}
