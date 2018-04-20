package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface JogosRealizadosListener {

    void carregarJogosRealizados(final List<JogosRealizados> jogosRealizados);
}
