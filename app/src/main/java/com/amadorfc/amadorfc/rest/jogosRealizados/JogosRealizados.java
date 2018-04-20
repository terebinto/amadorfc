package com.amadorfc.amadorfc.rest.jogosRealizados;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by alexandre on 01/03/17.
 */
@JsonObject
public class JogosRealizados {


    /*{"ultimosJogos":[{"idPartida":"1393","dataPartida":"24/03/2018","horarioPartida":"16:00h","idTime1":"20",
    "localPartida":"Finalizado","nomeTime1":"Ouro Verde",
    "escudoEquipe1":"http://www.amigosdabolaonline.com.br/site/media/bearleague/bl1422101523342.png","score1":"6","idTime2":"13",
    "nomeTime2":"Piriri ","escudoEquipe2":"http://www.amigosdabolaonline.com.br/site/media/bearleague/bl151753119675.jpeg","score2":"3"},*/


    @JsonField(name = "idPartida")
    public int idPartida;

    @JsonField(name = "dataPartida")
    public String dataPartida;

    @JsonField(name = "horarioPartida")
    public String horarioPartida;

    @JsonField(name = "idTime1")
    public int idTime1;

    @JsonField(name = "nomeTime1")
    public String nomeTime1;

    @JsonField(name = "escudoEquipe1")
    public String escudoEquipe1;

    @JsonField(name = "idTime2")
    public int idTime2;

    @JsonField(name = "nomeTime2")
    public String nomeTime2;

    @JsonField(name = "escudoEquipe2")
    public String escudoEquipe2;

    @JsonField(name = "localPartida")
    public String localPartida;

    @JsonField(name = "score1")
    public String score1;

    @JsonField(name = "score2")
    public String score2;

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHorarioPartida() {
        return horarioPartida;
    }

    public void setHorarioPartida(String horarioPartida) {
        this.horarioPartida = horarioPartida;
    }

    public int getIdTime1() {
        return idTime1;
    }

    public void setIdTime1(int idTime1) {
        this.idTime1 = idTime1;
    }

    public String getNomeTime1() {
        return nomeTime1;
    }

    public void setNomeTime1(String nomeTime1) {
        this.nomeTime1 = nomeTime1;
    }

    public String getEscudoEquipe1() {
        return escudoEquipe1;
    }

    public void setEscudoEquipe1(String escudoEquipe1) {
        this.escudoEquipe1 = escudoEquipe1;
    }

    public int getIdTime2() {
        return idTime2;
    }

    public void setIdTime2(int idTime2) {
        this.idTime2 = idTime2;
    }

    public String getNomeTime2() {
        return nomeTime2;
    }

    public void setNomeTime2(String nomeTime2) {
        this.nomeTime2 = nomeTime2;
    }

    public String getEscudoEquipe2() {
        return escudoEquipe2;
    }

    public void setEscudoEquipe2(String escudoEquipe2) {
        this.escudoEquipe2 = escudoEquipe2;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }
}
