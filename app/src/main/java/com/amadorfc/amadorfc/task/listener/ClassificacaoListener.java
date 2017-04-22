package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacao;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface ClassificacaoListener {

    void loadClassificacao(final List<EquipeClassificacao> equipeClassificacao);
}
