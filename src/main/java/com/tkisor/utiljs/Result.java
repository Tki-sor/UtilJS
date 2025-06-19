package com.tkisor.utiljs;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public Result<T> onSuccess(Consumer<? super T> action) {
        if (isSuccess()) {
            action.accept(value);
        }
        return this;
    }

    public Result<T> onFailure(Consumer<Throwable> action) {
        if (isFailure()) {
            action.accept(error);
        }
        return this;
    }

    public <U> Result<U> map(Function<? super T, ? extends U> mapper) {
        if (isSuccess()) {
            try {
                return success(mapper.apply(value));
            } catch (Throwable e) {
                return failure(e);
            }
        } else {
            return failure(error);
        }
    }

    public <U> Result<U> flatMap(Function<? super T, Result<U>> mapper) {
        if (isSuccess()) {
            try {
                return mapper.apply(value);
            } catch (Throwable e) {
                return failure(e);
            }
        } else {
            return failure(error);
        }
    }

    public Result<T> filter(Predicate<? super T> predicate) {
        if (isFailure()) return this;
        try {
            if (predicate.test(value)) {
                return this;
            } else {
                return failure(new IllegalStateException("Value does not satisfy the filter condition"));
            }
        } catch (Throwable e) {
            return failure(e);
        }
    }
}
