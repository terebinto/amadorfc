package com.amadorfc.amadorfc.rest.equipe;

import com.bluelinelabs.logansquare.annotation.JsonObject;


/**
 * Classe encapsula dados para chamada da operacao
 * @author TIVIT
 * @since  06/04/2016
 */
@JsonObject
public class EquipeRequest {

    public int tid;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
