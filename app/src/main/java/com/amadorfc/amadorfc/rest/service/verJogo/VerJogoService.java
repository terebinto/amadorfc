package com.amadorfc.amadorfc.rest.service.verJogo;


import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaRequest;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartidaResponse;

/**
 * Classe responsavel por encapsular dados da chamada da operacao banner
 * @author ALEXANDRE
 * @since  14/2/2017.
 */
public class VerJogoService extends RestAbstractService<FichaPartidaRequest, FichaPartidaResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.VER_JOGO;
    }

    @Override
    public Class<FichaPartidaResponse> getResponseClass() {
        return FichaPartidaResponse.class;
    }
}
