package com.amadorfc.amadorfc.rest.service.equipeClassificacao;


import com.amadorfc.amadorfc.rest.equipe.EquipeRequest;
import com.amadorfc.amadorfc.rest.equipe.EquipeResponse;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacaoRequest;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacaoResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada da operacao equipe
 *
 * @author ALEXANDRE
 * @since 14/2/2017.
 */
public class EquipeClassificacaoService extends RestAbstractService<EquipeClassificacaoRequest, EquipeClassificacaoResponse> {

    @Override
    public RestURL getURL() {

        return RestURL.CARREGAR_CLASSIFICACAO;
    }



    @Override
    public Class<EquipeClassificacaoResponse> getResponseClass() {
        return EquipeClassificacaoResponse.class;
    }
}
