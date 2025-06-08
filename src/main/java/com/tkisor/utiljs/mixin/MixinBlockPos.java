package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.BlockPosWrapper;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BlockPos.class)
public class MixinBlockPos {
    @Unique
    public BlockPosWrapper wrap() {
        return new BlockPosWrapper((BlockPos)(Object)this);
    }
}
