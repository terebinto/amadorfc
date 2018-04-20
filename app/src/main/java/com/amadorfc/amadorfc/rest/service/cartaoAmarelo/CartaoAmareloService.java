package com.amadorfc.amadorfc.rest.service.cartaoAmarelo;


import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaRequest;
import com.amadorfc.amadorfc.rest.artilharia.ArtilhariaResponse;
import com.amadorfc.amadorfc.rest.cartao.Cartao;
import com.amadorfc.amadorfc.rest.cartao.CartaoRequest;
import com.amadorfc.amadorfc.rest.cartao.CartaoResponse;
import com.amadorfc.amadorfc.rest.service.RestAbstractService;
import com.amadorfc.amadorfc.rest.service.RestURL;

/**
 * Classe responsavel por encapsular dados da chamada da operacao
 *
 * @author ALEXANDRE
 * @since 14/2/2017.
 */
public class CartaoAmareloService extends RestAbstractService<CartaoRequest, CartaoResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.LISTAR_ARTILHEIROS;
    }

    @Override
    public Class<CartaoResponse> getResponseClass() {
        return CartaoResponse.class;
    }
}
