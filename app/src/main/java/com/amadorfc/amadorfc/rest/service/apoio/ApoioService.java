package com.amadorfc.amadorfc.rest.service.apoio;


import com.amadorfc.amadorfc.rest.apoio.ApoioRequest;
import com.amadorfc.amadorfc.rest.apoio.ApoioResponse;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaRequest;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada da operacao
 *
 * @author ALEXANDRE
 * @since 14/2/2017.
 */
public class ApoioService extends RestAbstractService<ApoioRequest, ApoioResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.LISTAR_ARTILHEIROS;
    }

    @Override
    public Class<ApoioResponse> getResponseClass() {
        return ApoioResponse.class;
    }
}
