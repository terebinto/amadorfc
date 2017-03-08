package com.amadorfc.amadorfc.controller;

import android.content.Context;
import android.util.Log;

import com.amadorfc.amadorfc.rest.service.usuario.AtivarService;
import com.amadorfc.amadorfc.rest.usuario.AtivarRequest;
import com.amadorfc.amadorfc.rest.usuario.AtivarResponse;
import com.amadorfc.amadorfc.rest.usuario.Usuario;

import java.util.List;


/**
 * Controlador responsavel pelas operacoes sobre o Cliente
 * @author TIVIT
 * @since 4/6/16.
 */
public class UsuarioController {

    public static List<Usuario> ativaCadastro(final Context context) {
        try {
            Log.i("AtivaCadastro", "INICIO");
            AtivarRequest request = new AtivarRequest();

            AtivarResponse response = new AtivarService().execute(request);
            return response.getUsuarios();
        } finally {
            Log.i("AtivaCadastro", "FIM");
        }
    }
}
