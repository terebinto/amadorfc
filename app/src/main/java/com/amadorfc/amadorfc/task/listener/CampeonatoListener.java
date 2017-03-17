package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.usuario.Usuario;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface CampeonatoListener {

    void carregarCampeonatos(final List<Campeonato> campeonatos);
}
