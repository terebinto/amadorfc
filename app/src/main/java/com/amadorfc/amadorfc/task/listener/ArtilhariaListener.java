package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.noticia.Noticia;

import java.util.List;

/**
 * Created by lucas on 03/05/17.
 */

public interface ArtilhariaListener {

    void carregarArtilharia(final List<Artilharia> artilheiros);
}
