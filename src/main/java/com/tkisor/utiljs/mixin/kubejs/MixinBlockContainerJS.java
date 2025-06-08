package com.tkisor.utiljs.mixin.kubejs;

import com.tkisor.utiljs.wrapper.kubejs.BlockContainerJSWrapper;
import dev.latvian.mods.kubejs.level.BlockContainerJS;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = BlockContainerJS.class, remap = false)
public class MixinBlockContainerJS {
    @Unique
    public BlockContainerJSWrapper wrap() {
        return new BlockContainerJSWrapper((BlockContainerJS)(Object)this);
    }
}
