package com.amadorfc.amadorfc.rest.artilharia;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


/**
 * Classe encapsula dados para chamada da operacao .
 *
 * @author TIVIT
 * @since 06/04/2016
 */
@JsonObject
public class ArtilhariaRequest {

    @JsonField
    public int campeonato;

}
