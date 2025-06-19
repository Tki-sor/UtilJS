package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.mixinImpl.PatchedDataComponentMapImpl;
import it.unimi.dsi.fastutil.objects.Reference2ObjectMap;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.PatchedDataComponentMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Optional;

@Mixin(PatchedDataComponentMap.class)
public abstract class MixinPatchedDataComponentMap implements PatchedDataComponentMapImpl {
    @Shadow
    @Final
    private DataComponentMap prototype;

    @Shadow
    private Reference2ObjectMap<DataComponentType<?>, Optional<?>> patch;


    @Override
    public <T> T delete(DataComponentType<? extends T> component) {
        this.ensureMapOwnership();
        T value = this.prototype.get(component);
        this.patch.remove(component);
        return value;
    }

    @Shadow
    protected abstract void ensureMapOwnership();
}
