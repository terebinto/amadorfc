package com.amadorfc.amadorfc.rest.service;

import android.util.Log;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.comum.RestException;
import com.amadorfc.amadorfc.rest.usuario.AtivarResponse;
import com.amadorfc.amadorfc.utilitarios.NetworkUtil;
import com.amadorfc.amadorfc.utilitarios.http.HttpHelper;
import com.amadorfc.amadorfc.utilitarios.json.JsonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Classe utilizada para invocar servicos rest.
 *
 * @author TIVIT
 * @since 24/03/2016
 */
public abstract class RestAbstractService<Request, Response> extends HttpHelper {

    /**
     * Recupera URL que devera ser invocada
     */
    public abstract RestURL getURL();

    /**
     * Recupera objeto de resposta
     */
    public abstract Class<Response> getResponseClass();

    /**
     * Metodo deve ser declarado na classe filha para invocar servico
     */
    public Response execute(Request request) throws RestException {

        try {
            Log.i("Request", request.toString());

            // Se a conexao nao esta online nao faz requisicao
            if (!NetworkUtil.isNetworkAvailable(AmadorfcApplication.getInstance())) {
                throw new RestException("Internet indísponivel, sua mensagem será enviada assim que a rede normalizar.");
            }

            String json = JsonHelper.toJson(request);
            JSONObject jo = new JSONObject(json); //

            Map<String, Object> map = new HashMap();
            Iterator keys = jo.keys();
            String parametros="";

            if (keys !=null){
                parametros = parametros.concat("?");
            }

            while (keys.hasNext()) {
                String key = (String) keys.next();
                parametros = parametros.concat(key).concat("=");
                parametros = parametros.concat(jo.get(key).toString()).concat("&");
                map.put(key, fromJson(jo.get(key)));
            }

            String responseString = get(getURL().getUrl().concat(parametros));

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

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap();
        Iterator keys = object.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            map.put(key, fromJson(object.get(key)));
        }
        return map;
    }

    public static List toList(JSONArray array) throws JSONException {
        List list = new ArrayList();
        for (int i = 0; i < array.length(); i++) {
            list.add(fromJson(array.get(i)));
        }
        return list;
    }

    private static Object fromJson(Object json) throws JSONException {
        if (json == JSONObject.NULL) {
            return null;
        } else if (json instanceof JSONObject) {
            return toMap((JSONObject) json);
        } else if (json instanceof JSONArray) {
            return toList((JSONArray) json);
        } else {
            return json;
        }
    }

}
