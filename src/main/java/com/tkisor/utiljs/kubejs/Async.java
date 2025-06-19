package com.tkisor.utiljs.kubejs;

import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Async {
    private static final ExecutorService VIRTUAL_THREAD_POOL =
            Executors.newVirtualThreadPerTaskExecutor();

    @Info("Returns an ExecutorService optimized for IO-bound tasks.")
    public ExecutorService ioPool() {
        return Util.ioPool();
    }

    @Info("Executor using virtual threads, creating a new virtual thread per task.")
    public ExecutorService virtualThreadPool() {
        return Async.VIRTUAL_THREAD_POOL;
    }
}
