package com.amadorfc.amadorfc.rest.apoio;

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
public class ApoioResponse {

    @JsonField(name = "apoio")
    public List<Apoio> apoio;

    public List<Apoio> getApoio() {
        return apoio;
    }

    public void setApoio(List<Apoio> apoio) {
        this.apoio = apoio;
    }
}
