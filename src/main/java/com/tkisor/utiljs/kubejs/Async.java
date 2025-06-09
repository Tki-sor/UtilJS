package com.tkisor.utiljs.kubejs;

import net.minecraft.Util;

import java.util.concurrent.ExecutorService;

public class Async {
    public ExecutorService ioPool() {
        return Util.ioPool();
    }
}
