package com.tkisor.utiljs.wrapper;

import net.minecraft.nbt.CollectionTag;
import net.minecraft.nbt.Tag;

public class CollectionTagWrapper<T extends Tag> extends Wrapper<CollectionTag<T>> {
    public CollectionTagWrapper(CollectionTag<T> value) {
        super(value);
    }
}
