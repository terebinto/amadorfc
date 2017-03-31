package com.amadorfc.amadorfc.rest.proximosJogos;

import com.bluelinelabs.logansquare.annotation.JsonObject;


/**
 * Classe encapsula dados para chamada da operacao
 * @author TIVIT
 * @since  06/04/2016
 */
@JsonObject
public class ProximosJogosRequest {

    private int seasson;

    public int getSeasson() {
        return seasson;
    }

    public void setSeasson(int seasson) {
        this.seasson = seasson;
    }
}
