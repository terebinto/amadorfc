package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.apoio.Apoio;
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;

import java.util.List;

/**
 * Created by lucas on 03/05/17.
 */

public interface ApoioListener {

    void carregarApoio(final List<Apoio> apoios);
}
