package com.amadorfc.amadorfc.rest.usuario;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe encapsula dados para chamada da operacao Cadastro.
 *
 * @author TIVIT
 * @since 06/04/2016
 */
@JsonObject
public class AtivarResponse {

    @JsonField(name = "usuarios")
    public List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
