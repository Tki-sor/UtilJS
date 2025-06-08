package com.tkisor.utiljs.wrapper;

import net.minecraft.server.MinecraftServer;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MinecraftServerWrapper extends Wrapper<MinecraftServer> {
    public MinecraftServerWrapper(MinecraftServer value) {
        super(value);
    }
}
