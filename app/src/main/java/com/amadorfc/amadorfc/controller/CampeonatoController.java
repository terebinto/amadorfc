package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.service.banner.BannerService;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes controlers
 * @author Alexnadre Terebinto
 * @since 14/02/17.
 */
public class CampeonatoController {

    public static List<Banner> loadBanners(final Context context) {
        try {
            Log.i("Carregando banners", "INICIO");
            BannerRequest request = new BannerRequest();

            BannerResponse response = new BannerService().execute(request);
            return response.getBanners();
        } finally {
            Log.i("Banners carregados", "FIM");
        }
    }
}
