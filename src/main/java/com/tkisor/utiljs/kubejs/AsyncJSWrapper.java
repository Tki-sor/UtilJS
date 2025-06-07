package com.tkisor.utiljs.kubejs;

import com.tkisor.utiljs.kubejs.AsyncJS;

import java.util.concurrent.CompletableFuture;

public class AsyncJSWrapper {
    public CompletableFuture<Void> parallel(Runnable[] tasks) {
        return AsyncJS.parallel(tasks);
    }

    public CompletableFuture<Void> timeout(long timeout, Runnable task) {
        return AsyncJS.timeout(timeout, task);
    }

    public CompletableFuture<Void> retry(int max, Runnable task) {
        return AsyncJS.retry(max, task);
    }

}
