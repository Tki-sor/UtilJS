package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.ScopeOps;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Block.class)
public class MixinBlock implements ScopeOps<Block> {
}
