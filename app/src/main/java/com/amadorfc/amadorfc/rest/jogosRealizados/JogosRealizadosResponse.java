package com.amadorfc.amadorfc.rest.jogosRealizados;

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
public class JogosRealizadosResponse {

    @JsonField(name = "ultimosJogos")
    public List<JogosRealizados> ultimosJogos;

    public List<JogosRealizados> getUltimosJogos() {
        return ultimosJogos;
    }

    public void setUltimosJogos(List<JogosRealizados> ultimosJogos) {
        this.ultimosJogos = ultimosJogos;
    }
}
