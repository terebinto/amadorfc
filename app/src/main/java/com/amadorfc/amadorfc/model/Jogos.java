package com.amadorfc.amadorfc.model;

/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class Jogos {

    private String visitante;
    private String mandante;
    private String estadio;

    public Jogos(String mandante, String visitante, String estadio) {
        super();
        this.setMandante(mandante);
        this.setVisitante(visitante);
        this.setEstadio(estadio);
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }
}
