package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.banner.Banner;
import com.amadorfc.amadorfc.rest.equipe.Equipe;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface EquipeListener {

    void carregarEquipePorId(final Equipe equipe);
}
