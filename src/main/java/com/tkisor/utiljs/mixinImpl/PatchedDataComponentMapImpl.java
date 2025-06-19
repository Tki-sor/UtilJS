package com.tkisor.utiljs.mixinImpl;

import net.minecraft.core.component.DataComponentType;

public interface PatchedDataComponentMapImpl {
    <T> T delete(DataComponentType<? extends T> component);
}
