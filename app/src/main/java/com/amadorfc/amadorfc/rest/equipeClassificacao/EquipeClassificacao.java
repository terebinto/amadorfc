package com.amadorfc.amadorfc.rest.equipeClassificacao;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by alexandre on 01/03/17.
 */
@JsonObject
public class EquipeClassificacao {

    @JsonField(name = "tid")
    public int tid;

    @JsonField(name = "nomeEquipe")
    public String nomeEquipe;

    @JsonField(name = "escudo")
    public String escudo;

    @JsonField(name = "posicao")
    public String posicao;

    @JsonField(name = "played")
    public String played;

    @JsonField(name = "win")
    public String win;

    @JsonField(name = "draw")
    public String draw;

    @JsonField(name = "lost")
    public String lost;

    @JsonField(name = "goals")
    public String goals;

    @JsonField(name = "points")
    public String points;

    @JsonField(name = "goal_score")
    public String goal_score;

    @JsonField(name = "goals_conc")
    public String goals_conc;

    @JsonField(name = "gd")
    public String gd;

    @JsonField(name = "g_id")
    public String g_id;

    @JsonField(name = "g_name")
    public String g_name;

    @JsonField(name = "ext_fields")
    public String ext_fields;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getGoal_score() {
        return goal_score;
    }

    public void setGoal_score(String goal_score) {
        this.goal_score = goal_score;
    }

    public String getGoals_conc() {
        return goals_conc;
    }

    public void setGoals_conc(String goals_conc) {
        this.goals_conc = goals_conc;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
    }

    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getExt_fields() {
        return ext_fields;
    }

    public void setExt_fields(String ext_fields) {
        this.ext_fields = ext_fields;
    }
}
