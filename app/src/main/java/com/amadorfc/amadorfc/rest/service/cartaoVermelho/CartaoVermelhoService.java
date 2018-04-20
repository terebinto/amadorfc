package com.amadorfc.amadorfc.rest.service.cartaoVermelho;


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
public class CartaoVermelhoService extends RestAbstractService<CartaoRequest, CartaoResponse> {

    @Override
    public RestURL getURL() {
        return RestURL.CARREGAR_CARTAO_VERMELHO;
    }

    @Override
    public Class<CartaoResponse> getResponseClass() {
        return CartaoResponse.class;
    }
}
