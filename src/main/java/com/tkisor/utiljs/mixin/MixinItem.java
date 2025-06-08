package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.ItemWrapper;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Item.class)
public class MixinItem {
    @Unique
    public ItemWrapper wrap() {
        return new ItemWrapper((Item)(Object)this);
    }
}
