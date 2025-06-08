package com.tkisor.utiljs.kubejs;

import com.google.gson.Gson;

public class UtilJS {
    public static Assert asserts = new Assert();
    public static Async async = new Async();
    public static Control control = new Control();
    public static Scope scope = new Scope();
    public static Debug debug = new Debug();

    public static <T> T deepCopy(T object) {
        if (object == null) return null;
        Gson gson = new Gson();
        String json = gson.toJson(object);
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) object.getClass();
        return gson.fromJson(json, clazz);
    }

    public static <T> T deepCopy(T object, Class<T> clazz) {
        if (object == null) {
            return null;
        }
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return gson.fromJson(json, clazz);
    }

}
