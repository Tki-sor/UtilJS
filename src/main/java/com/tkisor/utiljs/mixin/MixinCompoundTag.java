package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.CompoundTagWrapper;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(CompoundTag.class)
public class MixinCompoundTag {
    @Unique
    public CompoundTagWrapper wrap() {
        return new CompoundTagWrapper((CompoundTag)(Object)this);
    }
}
