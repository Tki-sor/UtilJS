package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.mixinImpl.PatchedDataComponentMapImpl;
import com.tkisor.utiljs.wrapper.ItemStackWrapper;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemStack.class)
public class MixinItemStack {
    @Shadow
    @Final
    PatchedDataComponentMap components;

    @Unique
    public ItemStackWrapper wrap() {
        return new ItemStackWrapper((ItemStack)(Object)this);
    }

    @Unique
    public <T> T delete(DataComponentType<? extends T> component) {
        PatchedDataComponentMapImpl componentMap = (PatchedDataComponentMapImpl) (Object) this.components;
        return componentMap.delete(component);
    }
}
