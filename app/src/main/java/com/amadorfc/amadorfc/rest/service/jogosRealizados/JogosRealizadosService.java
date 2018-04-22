package com.amadorfc.amadorfc.rest.service.jogosRealizados;


import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosRequest;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosResponse;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogosRequest;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogosResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada
 *
 * @author ALEXANDRE
 * @since 14/2/2017.
 */
public class JogosRealizadosService extends RestAbstractService<JogosRealizadosRequest, JogosRealizadosResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.CARREGAR_JOGOS_REALIZADOS;
    }

    @Override
    public Class<JogosRealizadosResponse> getResponseClass() {
        return JogosRealizadosResponse.class;
    }
}
