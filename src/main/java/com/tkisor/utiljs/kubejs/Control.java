package com.tkisor.utiljs.kubejs;

import com.tkisor.utiljs.Result;

import java.util.function.Supplier;

public class Control {
    public <T> Result<T> runCatching(Supplier<T> action) {
        try {
            return Result.success(action.get());
        } catch (Throwable e) {
            return Result.failure(e);
        }
    }

    public <T> Result<T> successResult(T value) {
        return Result.success(value);
    }

    public <T> Result<T> failureResult(Throwable error) {
        return Result.failure(error);
    }

}
