package com.amadorfc.amadorfc.rest.service.fichaPartida;


import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartida;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaRequest;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaResponse;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosRequest;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizadosResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada
 *
 * @author ALEXANDRE
 * @since 14/2/2017.
 */
public class FichaPartidaService extends RestAbstractService<FichaPartidaRequest, FichaPartidaResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.VER_JOGO;
    }

    @Override
    public Class<FichaPartidaResponse> getResponseClass() {
        return FichaPartidaResponse.class;
    }
}
