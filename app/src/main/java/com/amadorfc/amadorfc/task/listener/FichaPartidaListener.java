package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartida;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface FichaPartidaListener {

    void carregarFichaPartida(final FichaPartida partida);
}
