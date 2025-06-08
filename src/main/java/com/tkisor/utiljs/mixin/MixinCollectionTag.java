package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.wrapper.CollectionTagWrapper;
import net.minecraft.nbt.CollectionTag;
import net.minecraft.nbt.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(CollectionTag.class)
public class MixinCollectionTag<T extends Tag> {
    @SuppressWarnings("unchecked")
    @Unique
    public CollectionTagWrapper<T> wrap() {
        return new CollectionTagWrapper<>((CollectionTag<T>)(Object)this);
    }
}
