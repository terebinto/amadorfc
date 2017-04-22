package com.amadorfc.amadorfc.model;

/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class Classificacao {

    private String classificacao;
    private String equipe;
    private String pontosGanhos;
    private String jogos;
    private String vitorias;
    private String empates;
    private String derrotas;
    private String golsPro;
    private String golsContra;
    private String saldoGols;

    public Classificacao(String classificacao, String equipe, String pontosGanhos, String jogos, String vitorias, String empates, String derrotas, String golsPro, String golsContra, String saldoGols) {
        super();
        this.setClassificacao(classificacao);
        this.setEquipe(equipe);
        this.setPontosGanhos(pontosGanhos);
        this.setJogos(jogos);
        this.setVitorias(vitorias);
        this.setEmpates(empates);
        this.setDerrotas(derrotas);
        this.setGolsPro(golsPro);
        this.setGolsContra(golsContra);
        this.setSaldoGols(saldoGols);
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(String derrotas) {
        this.derrotas = derrotas;
    }

    public String getEmpates() {
        return empates;
    }

    public void setEmpates(String empates) {
        this.empates = empates;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(String golsContra) {
        this.golsContra = golsContra;
    }

    public String getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(String golsPro) {
        this.golsPro = golsPro;
    }

    public String getJogos() {
        return jogos;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public String getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(String pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public String getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(String saldoGols) {
        this.saldoGols = saldoGols;
    }

    public String getVitorias() {
        return vitorias;
    }

    public void setVitorias(String vitorias) {
        this.vitorias = vitorias;
    }
}
