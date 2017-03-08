package com.amadorfc.amadorfc.rest.campeonato;

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
public class CampeonatoResponse {

    @JsonField(name = "campeonatos")
    public List<Campeonato> campeonatos;

    public List<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(List<Campeonato> campeonatos) {
        this.campeonatos = campeonatos;
    }
}
