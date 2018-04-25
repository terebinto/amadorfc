package com.amadorfc.amadorfc.rest.cartao;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


/**
 * Classe encapsula dados para chamada da operacao .
 *
 * @author TIVIT
 * @since 06/04/2016
 */
@JsonObject
public class CartaoRequest {

    @JsonField(name = "campeonato")
    public int campeonato;

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }
}
