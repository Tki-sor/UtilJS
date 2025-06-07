package com.tkisor.utiljs.kubejs;

import com.google.gson.Gson;
import com.tkisor.utiljs.Result;
import net.minecraft.Util;

import java.util.concurrent.ExecutorService;

public class UtilJS {
    public static KotlinJSWrapper kotlin = new KotlinJSWrapper();
    public static AsyncJSWrapper async = new AsyncJSWrapper();

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

    public static ExecutorService ioPool() {
        return Util.ioPool();
    }

    public static <T> Result<T> successResult(T value) {
        return Result.success(value);
    }

    public static <T> Result<T> failureResult(Throwable error) {
        return Result.failure(error);
    }
}
