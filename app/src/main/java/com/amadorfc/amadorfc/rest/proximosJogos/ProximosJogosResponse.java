package com.amadorfc.amadorfc.rest.proximosJogos;

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
public class ProximosJogosResponse {

    @JsonField(name = "proximosJogos")
    public List<ProximosJogos> proximosJogos;

    public List<ProximosJogos> getProximosJogos() {
        return proximosJogos;
    }

    public void setProximosJogos(List<ProximosJogos> proximosJogos) {
        this.proximosJogos = proximosJogos;
    }
}
