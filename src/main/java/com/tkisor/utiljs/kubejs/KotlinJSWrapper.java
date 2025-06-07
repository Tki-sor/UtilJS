package com.tkisor.utiljs.kubejs;

import com.tkisor.utiljs.Result;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public class KotlinJSWrapper {
    public void runBlocking(Runnable action) {
        KotlinJS.runBlocking(action);
    }

    public void globalScope(Runnable action) {
        KotlinJS.globalScope(action);
    }

    public CompletableFuture<Void> coroutineScope(Runnable action) {
        return KotlinJS.coroutineScope(action);
    }

    public <T> CompletableFuture<T> coroutineScopeWithResult(Callable<T> action) {
        return KotlinJS.coroutineScopeWithResult(action);
    }

    public <T> Result<T> runCatching(Supplier<T> action) {
        try {
            return Result.success(action.get());
        } catch (Throwable e) {
            return Result.failure(e);
        }
    }

    public  <T, R> R with(T receiver, Function<T, R> block) {
        return block.apply(receiver);
    }
}
