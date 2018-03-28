package com.amadorfc.amadorfc.rest.campeonato;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by alexandre on 01/03/17.
 */
@JsonObject
public class Campeonato {

    @JsonField(name = "idLiga")
    public int idLiga;

    @JsonField(name = "nomeLiga")
    public String nomeLiga;

    @JsonField(name = "descricao")
    public String descricao;

    @JsonField(name = "imagem")
    public String imagem;

    @JsonField(name = "idCategoriaNoticia")
    public String idCategoriaNoticia;


    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public String getNomeLiga() {
        return nomeLiga;
    }

    public void setNomeLiga(String nomeLiga) {
        this.nomeLiga = nomeLiga;
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

    public String getIdCategoriaNoticia() {
        return idCategoriaNoticia;
    }

    public void setIdCategoriaNoticia(String idCategoriaNoticia) {
        this.idCategoriaNoticia = idCategoriaNoticia;
    }
}
