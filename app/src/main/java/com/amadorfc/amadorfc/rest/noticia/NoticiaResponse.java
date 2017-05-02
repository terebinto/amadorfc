package com.amadorfc.amadorfc.rest.noticia;

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
public class NoticiaResponse {

    @JsonField(name = "noticias")
    public List<Noticia> noticias;

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
