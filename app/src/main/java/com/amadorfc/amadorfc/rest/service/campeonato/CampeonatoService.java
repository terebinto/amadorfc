package com.amadorfc.amadorfc.rest.service.campeonato;


import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.campeonato.CampeonatoRequest;
import com.amadorfc.amadorfc.rest.campeonato.CampeonatoResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada da operacao campeonato
 * @author ALEXANDRE
 * @since  14/2/2017.
 */
public class CampeonatoService extends RestAbstractService<CampeonatoRequest, CampeonatoResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.LISTAR_CAMPEONATOS;
    }

    @Override
    public Class<CampeonatoResponse> getResponseClass() {
        return CampeonatoResponse.class;
    }
}
