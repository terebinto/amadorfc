package com.amadorfc.amadorfc.rest.service.artilharia;


import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaRequest;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;
import com.amadorfc.amadorfc.rest.usuario.AtivarRequest;

/**
 * Classe responsavel por encapsular dados da chamada da operacao
 *
 * @author ALEXANDRE
 * @since 14/2/2017.
 */
public class ArtilhariaService extends RestAbstractService<ArtilhariaRequest, ArtilhariaResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.LISTAR_ARTILHEIROS;
    }

    @Override
    public Class<ArtilhariaResponse> getResponseClass() {
        return ArtilhariaResponse.class;
    }
}
