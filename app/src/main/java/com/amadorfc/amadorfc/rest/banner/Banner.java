package com.amadorfc.amadorfc.rest.banner;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by alexandre on 01/03/17.
 */
@JsonObject
public class Banner {

    @JsonField(name = "idBanner")
    public int id;

    @JsonField(name = "nomeBanner")
    public String nomeBanner;

    @JsonField(name = "descricao")
    public String descricao;

    @JsonField(name = "imagem")
    public String imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeBanner() {
        return nomeBanner;
    }

    public void setNomeBanner(String nomeBanner) {
        this.nomeBanner = nomeBanner;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return nomeBanner;
    }
}
