package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.MinecraftWrapper;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Unique
    public MinecraftWrapper wrap() {
        return new MinecraftWrapper((Minecraft) (Object) this);
    }
}
