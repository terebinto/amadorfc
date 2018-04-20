package com.amadorfc.amadorfc.rest.fichaPartida;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by alexandre on 01/03/17.
 */
@JsonObject
public class FichaPartida {

    @JsonField(name = "idJogo")
    public int idJogo;

    @JsonField(name = "dataPartida")
    public String dataPartida;

    @JsonField(name = "local")
    public String local;

    @JsonField(name = "placar1")
    public String placar1;

    @JsonField(name = "placar2")
    public String placar2;

    @JsonField(name = "escudoEquipe1")
    public String escudoEquipe1;

    @JsonField(name = "escudoEquipe2")
    public String escudoEquipe2;

    @JsonField(name = "nomeEquipe1")
    public String nomeEquipe1;

    @JsonField(name = "nomeEquipe2")
    public String nomeEquipe2;

    @JsonField(name = "iconeAmarelo")
    public String iconeAmarelo;

    @JsonField(name = "labelAmarelo")
    public String labelAmarelo;

    @JsonField(name = "iconeVermelho")
    public String iconeVermelho;

    @JsonField(name = "labelVermelho")
    public String labelVermelho;

    @JsonField(name = "iconeGols")
    public String iconeGols;

    @JsonField(name = "infoAmarelo")
    public List<EventoPartida> infoAmarelo;

    @JsonField(name = "infoVermelho")
    public List<EventoPartida> infoVermelho;

    @JsonField(name = "infoGol")
    public List<EventoPartida> infoGol;

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPlacar1() {
        return placar1;
    }

    public void setPlacar1(String placar1) {
        this.placar1 = placar1;
    }

    public String getPlacar2() {
        return placar2;
    }

    public void setPlacar2(String placar2) {
        this.placar2 = placar2;
    }

    public String getEscudoEquipe1() {
        return escudoEquipe1;
    }

    public void setEscudoEquipe1(String escudoEquipe1) {
        this.escudoEquipe1 = escudoEquipe1;
    }

    public String getEscudoEquipe2() {
        return escudoEquipe2;
    }

    public void setEscudoEquipe2(String escudoEquipe2) {
        this.escudoEquipe2 = escudoEquipe2;
    }

    public String getNomeEquipe1() {
        return nomeEquipe1;
    }

    public void setNomeEquipe1(String nomeEquipe1) {
        this.nomeEquipe1 = nomeEquipe1;
    }

    public String getNomeEquipe2() {
        return nomeEquipe2;
    }

    public void setNomeEquipe2(String nomeEquipe2) {
        this.nomeEquipe2 = nomeEquipe2;
    }

    public String getIconeAmarelo() {
        return iconeAmarelo;
    }

    public void setIconeAmarelo(String iconeAmarelo) {
        this.iconeAmarelo = iconeAmarelo;
    }

    public String getLabelAmarelo() {
        return labelAmarelo;
    }

    public void setLabelAmarelo(String labelAmarelo) {
        this.labelAmarelo = labelAmarelo;
    }

    public String getIconeVermelho() {
        return iconeVermelho;
    }

    public void setIconeVermelho(String iconeVermelho) {
        this.iconeVermelho = iconeVermelho;
    }

    public String getLabelVermelho() {
        return labelVermelho;
    }

    public void setLabelVermelho(String labelVermelho) {
        this.labelVermelho = labelVermelho;
    }

    public String getIconeGols() {
        return iconeGols;
    }

    public void setIconeGols(String iconeGols) {
        this.iconeGols = iconeGols;
    }

    public List<EventoPartida> getInfoAmarelo() {
        return infoAmarelo;
    }

    public void setInfoAmarelo(List<EventoPartida> infoAmarelo) {
        this.infoAmarelo = infoAmarelo;
    }

    public List<EventoPartida> getInfoVermelho() {
        return infoVermelho;
    }

    public void setInfoVermelho(List<EventoPartida> infoVermelho) {
        this.infoVermelho = infoVermelho;
    }

    public List<EventoPartida> getInfoGol() {
        return infoGol;
    }

    public void setInfoGol(List<EventoPartida> infoGol) {
        this.infoGol = infoGol;
    }
}
