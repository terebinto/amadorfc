package com.amadorfc.amadorfc.rest.service.equipe;


import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.equipe.EquipeRequest;
import com.amadorfc.amadorfc.rest.equipe.EquipeResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada da operacao equipe
 *
 * @author ALEXANDRE
 * @since 14/2/2017.
 */
public class EquipeService extends RestAbstractService<EquipeRequest, EquipeResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.CARREGAR_EQUIPE_TID;
    }

    @Override
    public Class<EquipeResponse> getResponseClass() {
        return EquipeResponse.class;
    }
}
