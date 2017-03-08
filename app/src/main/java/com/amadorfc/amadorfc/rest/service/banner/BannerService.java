package com.amadorfc.amadorfc.rest.service.banner;


import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;
import com.amadorfc.amadorfc.rest.usuario.AtivarRequest;
import com.amadorfc.amadorfc.rest.usuario.AtivarResponse;

/**
 * Classe responsavel por encapsular dados da chamada da operacao banner
 * @author ALEXANDRE
 * @since  14/2/2017.
 */
public class BannerService extends RestAbstractService<BannerRequest, BannerResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.LISTAR_BANNERS;
    }

    @Override
    public Class<BannerResponse> getResponseClass() {
        return BannerResponse.class;
    }
}
