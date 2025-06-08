package com.tkisor.utiljs.kubejs;

import net.minecraft.Util;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Async {
    public ExecutorService ioPool() {
        return Util.ioPool();
    }
}
