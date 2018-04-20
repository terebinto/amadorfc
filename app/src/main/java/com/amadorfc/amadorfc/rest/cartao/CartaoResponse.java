package com.amadorfc.amadorfc.rest.cartao;

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
public class CartaoResponse {

    @JsonField(name = "cartoes")
    public List<Cartao> cartoes;

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
}
