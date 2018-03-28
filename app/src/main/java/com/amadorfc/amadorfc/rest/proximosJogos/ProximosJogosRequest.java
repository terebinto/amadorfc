package com.amadorfc.amadorfc.rest.proximosJogos;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


/**
 * Classe encapsula dados para chamada da operacao
 * @author TIVIT
 * @since  06/04/2016
 */
@JsonObject
public class ProximosJogosRequest {

    @JsonField(name = "campeonato")
    private int campeonato;

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }
}
