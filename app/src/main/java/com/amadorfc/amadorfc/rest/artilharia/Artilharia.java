package com.amadorfc.amadorfc.rest.artilharia;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by alexandre on 01/03/17.
 */
@JsonObject
public class Artilharia {

    @JsonField(name = "idJogador")
    public int idJogador;

    @JsonField(name = "idTime")
    public int idTime;

    @JsonField(name = "nomeJogador")
    public String nomeJogador;

    @JsonField(name = "nomeEquipe")
    public String nomeEquipe;

    @JsonField(name = "alias")
    public String alias;

    @JsonField(name = "gols")
    public String gols;

    @JsonField(name = "imagem")
    public String imagem;


    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGols() {
        return gols;
    }

    public void setGols(String gols) {
        this.gols = gols;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
