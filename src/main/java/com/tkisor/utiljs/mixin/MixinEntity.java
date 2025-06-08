package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.EntityWrapper;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Entity.class)
public class MixinEntity {
    @Unique
    public EntityWrapper wrap() {
        return new EntityWrapper((Entity)(Object)this);
    }
}
