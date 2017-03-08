package com.amadorfc.amadorfc.rest.service;

import android.util.Log;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.usuario.AtivarResponse;
import com.amadorfc.amadorfc.utilitarios.NetworkUtil;
import com.amadorfc.amadorfc.utilitarios.http.HttpHelper;
import com.amadorfc.amadorfc.utilitarios.json.JsonHelper;

import java.util.List;


/**
 * Classe utilizada para invocar servicos rest.
 * @author TIVIT
 * @since 24/03/2016
 */
public abstract class RestAbstractService<Request, Response>  extends HttpHelper {

    /**
     * Recupera URL que devera ser invocada
     * */
    public abstract RestURL getURL();

    /**
     * Recupera objeto de resposta
     * */
    public abstract Class<Response> getResponseClass();

    /**
     * Metodo deve ser declarado na classe filha para invocar servico
     * */
    public Response execute(Request request) throws RestException {

        try {
            Log.i("Request", request.toString());

            // Se a conexao nao esta online nao faz requisicao
            if (!NetworkUtil.isNetworkAvailable(AmadorfcApplication.getInstance())) {
                throw new RestException("Internet indísponivel, sua mensagem será enviada assim que a rede normalizar.");
            }

            String json = JsonHelper.toJson(request);
            String responseString = post(getURL().getUrl(), JSON, json);

            Response response = JsonHelper.fromJson(responseString, getResponseClass());

            Log.i("Request", response.toString());

            if (response == null) {
                throw new RestException("Serviço indísponivel, por favor, tente novamente dentro de alguns instantes.");
            }

            return response;

        } catch (RestException re) {
            throw re;
        } catch (Exception e) {
            throw new RestException("Serviço indísponivel, por favor, tente novamente dentro de alguns instantes.");
        }

    }

}
