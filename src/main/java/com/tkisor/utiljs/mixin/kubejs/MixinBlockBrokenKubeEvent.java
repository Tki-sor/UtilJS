package com.tkisor.utiljs.mixin.kubejs;

import dev.latvian.mods.kubejs.block.BlockBrokenKubeEvent;
import dev.latvian.mods.rhino.util.RemapForJS;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BlockBrokenKubeEvent.class)
public class MixinBlockBrokenKubeEvent {
    @RemapForJS("warp")
    @Unique
    public Block getMCBlock() {
        BlockBrokenKubeEvent blockBrokenKubeEvent = (BlockBrokenKubeEvent) (Object) this;
        return blockBrokenKubeEvent.getBlock().getBlockState().getBlock();
    }
}
