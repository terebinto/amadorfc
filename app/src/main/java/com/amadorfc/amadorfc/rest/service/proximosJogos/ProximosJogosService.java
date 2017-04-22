package com.amadorfc.amadorfc.rest.service.proximosJogos;


import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacaoRequest;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacaoResponse;
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
public class ProximosJogosService extends RestAbstractService<ProximosJogosRequest, ProximosJogosResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.CARREGAR_PROXIMOS_JOGOS;
    }

    @Override
    public Class<ProximosJogosResponse> getResponseClass() {
        return ProximosJogosResponse.class;
    }
}
