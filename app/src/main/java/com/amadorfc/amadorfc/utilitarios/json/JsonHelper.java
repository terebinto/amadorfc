package com.amadorfc.amadorfc.utilitarios.json;

import android.support.annotation.NonNull;

import java.io.IOException;

import static com.bluelinelabs.logansquare.LoganSquare.parse;
import static com.bluelinelabs.logansquare.LoganSquare.serialize;

/**
 * @author TIVIT
 * @since 4/6/16.
 */
public class JsonHelper {

    public static <T> String toJson(@NonNull T jsonObject) throws IOException {
        return serialize(jsonObject);
    }

    public static <T> T fromJson(@NonNull String jsonString, Class<T> jsonObjectClass) throws IOException {
        return parse(jsonString, jsonObjectClass);
    }
}
