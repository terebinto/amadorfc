package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.noticia.Noticia;

import java.util.List;

/**
 * Created by lucas on 03/05/17.
 */

public interface NoticiasListener {

    void carregarNoticias(final List<Noticia> noticias);
}
