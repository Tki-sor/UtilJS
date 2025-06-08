package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.BlockWrapper;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Block.class)
public class MixinBlock {
    @Unique
    public BlockWrapper wrap() {
        return new BlockWrapper((Block)(Object)this);
    }
}
