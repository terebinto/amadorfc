package com.amadorfc.amadorfc.task.listener;

import com.amadorfc.amadorfc.rest.usuario.Usuario;

import java.util.List;

/**
 * Created by alexandre on 03/03/17.
 */

public interface AtivaCadastroListener {

    void ativaCadastroResposta(final List<Usuario> usuarios);
}
