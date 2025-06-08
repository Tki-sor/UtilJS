package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.ItemStackWrapper;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemStack.class)
public class MixinItemStack {
    @Unique
    public ItemStackWrapper wrap() {
        return new ItemStackWrapper((ItemStack)(Object)this);
    }
}
