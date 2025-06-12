package com.tkisor.utiljs.kubejs;

import com.google.gson.Gson;
import dev.latvian.mods.kubejs.typings.Info;

public class UtilJS {
    public static Assert asserts = new Assert();
    public static Async async = new Async();
    public static Control control = new Control();
    public static Os os = new Os();
    public static Scope scope = new Scope();
    public static Debug debug = new Debug();

    @Info("Creates a deep copy of the given object.")
    public static <T> T deepCopy(T object) {
        if (object == null) return null;
        Gson gson = new Gson();
        String json = gson.toJson(object);
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) object.getClass();
        return gson.fromJson(json, clazz);
    }

    @Info("Creates a deep copy of the given object.")
    public static <T> T deepCopy(T object, Class<T> clazz) {
        if (object == null) {
            return null;
        }
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return gson.fromJson(json, clazz);
    }

}
