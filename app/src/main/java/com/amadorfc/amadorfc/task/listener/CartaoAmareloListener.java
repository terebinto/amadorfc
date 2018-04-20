package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.cartao.Cartao;

import java.util.List;

/**
 * Created by lucas on 03/05/17.
 */

public interface CartaoAmareloListener {

    void carregaCartoesAmarelos(final List<Cartao> cartoes);
}
