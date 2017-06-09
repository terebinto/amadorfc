package com.amadorfc.amadorfc.rest.artilharia;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Classe encapsula dados para chamada da operacao Cadastro.
 *
 * @author TIVIT
 * @since 06/04/2016
 */
@JsonObject
public class ArtilhariaResponse {

    @JsonField(name = "artilheiros")
    public List<Artilharia> artilheiros;

    public List<Artilharia> getArtilheiros() {
        return artilheiros;
    }

    public void setArtilheiros(List<Artilharia> artilheiros) {
        this.artilheiros = artilheiros;
    }
}
