package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.MinecraftServerWrapper;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
    @Unique
    public MinecraftServerWrapper wrap() {
        return new MinecraftServerWrapper((MinecraftServer) (Object) this);
    }
}
