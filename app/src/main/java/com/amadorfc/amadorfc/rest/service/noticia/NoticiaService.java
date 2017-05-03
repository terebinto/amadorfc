package com.amadorfc.amadorfc.rest.service.noticia;


import com.amadorfc.amadorfc.rest.banner.BannerRequest;
import com.amadorfc.amadorfc.rest.banner.BannerResponse;
import com.amadorfc.amadorfc.rest.noticia.NoticiaRequest;
import com.amadorfc.amadorfc.rest.noticia.NoticiaResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada da operacao banner
 * @author ALEXANDRE
 * @since  14/2/2017.
 */
public class NoticiaService extends RestAbstractService<NoticiaRequest, NoticiaResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.LISTAR_NOTICIAS;
    }

    @Override
    public Class<NoticiaResponse> getResponseClass() {
        return NoticiaResponse.class;
    }
}
