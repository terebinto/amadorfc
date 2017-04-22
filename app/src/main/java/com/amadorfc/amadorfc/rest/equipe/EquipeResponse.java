package com.amadorfc.amadorfc.rest.equipe;

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
public class EquipeResponse {

    @JsonField(name = "equipe")
    public Equipe equipe;

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipes(Equipe equipe) {
        this.equipe = equipe;
    }
}
