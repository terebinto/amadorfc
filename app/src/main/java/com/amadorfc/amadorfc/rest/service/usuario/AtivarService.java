package com.amadorfc.amadorfc.rest.service.usuario;


import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;
import com.amadorfc.amadorfc.rest.usuario.AtivarRequest;
import com.amadorfc.amadorfc.rest.usuario.AtivarResponse;

/**
 * Classe responsavel por encapsular dados da chamada da operacao ATIVAR
 * @author TIVIT
 * @since  4/6/16.
 */
public class AtivarService extends RestAbstractService<AtivarRequest, AtivarResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.LISTAR_USUARIOS;
    }

    @Override
    public Class<AtivarResponse> getResponseClass() {
        return AtivarResponse.class;
    }
}
