package com.tkisor.utiljs.mixin.kubejs;

import com.tkisor.utiljs.wrapper.kubejs.BlockContainerJSWrapper;
import dev.latvian.mods.kubejs.level.BlockContainerJS;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = BlockContainerJS.class, remap = false)
public class MixinBlockContainerJS {
    @Unique
    public BlockContainerJSWrapper wrap() {
        return new BlockContainerJSWrapper((BlockContainerJS)(Object)this);
    }

    @Unique
    public Block toMCBlock() {
        BlockContainerJS blockContainerJS = (BlockContainerJS) (Object) this;
        return blockContainerJS.getBlockState().getBlock();
    }
}
