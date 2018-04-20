package com.amadorfc.amadorfc.rest.cartao;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by alexandre on 01/03/17.
 */
@JsonObject
public class Cartao {

    @JsonField(name = "idJogador")
    public int idJogador;

    @JsonField(name = "idTime")
    public int idTime;

    @JsonField(name = "nomeJogador")
    public String nomeJogador;

    @JsonField(name = "nomeEquipe")
    public String nomeEquipe;

    @JsonField(name = "total")
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
