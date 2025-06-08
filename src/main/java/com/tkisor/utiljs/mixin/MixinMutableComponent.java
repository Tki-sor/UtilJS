package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.MutableComponentWrapper;
import net.minecraft.network.chat.MutableComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MutableComponent.class)
public class MixinMutableComponent {
    @Unique
    public MutableComponentWrapper wrap() {
        return new MutableComponentWrapper((MutableComponent) (Object) this);
    }
}
