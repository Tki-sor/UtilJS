package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.LevelWrapper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Level.class)
public class MixinLevel {
    @Unique
    public LevelWrapper wrap() {
        return new LevelWrapper((Level) (Object) this);
    }
}
