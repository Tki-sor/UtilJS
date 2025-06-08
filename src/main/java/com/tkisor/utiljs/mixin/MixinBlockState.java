package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.BlockStateWrapper;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BlockState.class)
public class MixinBlockState {
    @Unique
    public BlockStateWrapper wrap() {
        return new BlockStateWrapper((BlockState)(Object)this);
    }
}
