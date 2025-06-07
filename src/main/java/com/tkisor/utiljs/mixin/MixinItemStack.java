package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.ScopeOps;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemStack.class)
public class MixinItemStack implements ScopeOps<ItemStack> {
}
