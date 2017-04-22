package com.amadorfc.amadorfc.rest.equipeClassificacao;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Classe encapsula dados para chamada da operacao .
 *
 * @author ALEXANDRE TEREBINTO
 * @since 06/04/2016
 */
@JsonObject
public class EquipeClassificacaoResponse {

    @JsonField(name = "equipeClassificacao")
    public List<EquipeClassificacao> equipeClassificacao;

    public List<EquipeClassificacao> getEquipeClassificacao() {
        return equipeClassificacao;
    }

    public void setEquipeClassificacao(List<EquipeClassificacao> equipeClassificacao) {
        this.equipeClassificacao = equipeClassificacao;
    }
}
