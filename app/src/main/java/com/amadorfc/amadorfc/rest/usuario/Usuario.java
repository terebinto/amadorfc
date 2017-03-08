package com.amadorfc.amadorfc.rest.usuario;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by alexandre on 01/03/17.
 *
 */
@JsonObject
public class Usuario {

    @JsonField(name = "id")
    public int id;

    @JsonField  (name = "nomeUsuario")
    public String nomeUsuario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public String toString() {
        return nomeUsuario ;
    }
}
