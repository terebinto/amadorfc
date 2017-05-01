package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.rest.noticia.NoticiaRequest;
import com.amadorfc.amadorfc.rest.noticia.NoticiaResponse;
import com.amadorfc.amadorfc.rest.service.banner.BannerService;
import com.amadorfc.amadorfc.rest.service.noticia.NoticiaService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class NoticiaController {

    public static List<Noticia> loadNoticias(final Context context) {
        try {
            Log.i("Carregando getNoticias", "INICIO");
            NoticiaRequest request = new NoticiaRequest();

            NoticiaResponse response = new NoticiaService().execute(request);
            return response.getNoticias();
        } finally {
            Log.i("getNoticias carregados", "FIM");
        }
    }
}
