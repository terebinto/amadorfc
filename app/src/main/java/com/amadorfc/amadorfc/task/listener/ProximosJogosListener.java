package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface ProximosJogosListener {

    void carregarProximosJogos(final List<ProximosJogos> proximosJogos);
}
