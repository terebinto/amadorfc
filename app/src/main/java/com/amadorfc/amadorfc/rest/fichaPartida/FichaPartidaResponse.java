package com.amadorfc.amadorfc.rest.fichaPartida;

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
public class FichaPartidaResponse {

    @JsonField(name = "fichaPartida")
    public FichaPartida fichaPartida;

    public FichaPartida getFichaPartida() {
        return fichaPartida;
    }

    public void setFichaPartida(FichaPartida fichaPartida) {
        this.fichaPartida = fichaPartida;
    }
}
