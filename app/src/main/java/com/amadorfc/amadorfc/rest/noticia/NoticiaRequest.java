package com.amadorfc.amadorfc.rest.noticia;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


/**
 * Classe encapsula dados para chamada da operacao .
 *
 * @author TIVIT
 * @since 06/04/2016
 */
@JsonObject
public class NoticiaRequest {

    @JsonField(name = "categoria")
    private int categoria;

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
