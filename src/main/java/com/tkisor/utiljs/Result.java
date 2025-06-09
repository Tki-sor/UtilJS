package com.tkisor.utiljs;

import java.util.function.Function;

public class Result<T> {
    private final T value;
    private final Throwable error;

    protected Result(T value, Throwable error) {
        this.value = value;
        this.error = error;
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, null);
    }

    public static <T> Result<T> failure(Throwable error) {
        return new Result<>(null, error);
    }

    public boolean isSuccess() {
        return error == null;
    }

    public boolean isFailure() {
        return error != null;
    }

    public T getValue() {
        return isFailure() ? null : value;
    }

    public Throwable getError() {
        return error;
    }

    public <R> R fold(Function<? super T, ? extends R> onSuccess, Function<? super Throwable, ? extends R> onFailure) {
        if (isSuccess()) {
            return onSuccess.apply(value);
        } else {
            return onFailure.apply(error);
        }
    }
}
