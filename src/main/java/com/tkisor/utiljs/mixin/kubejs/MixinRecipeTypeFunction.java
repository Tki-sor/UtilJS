package com.tkisor.utiljs.mixin.kubejs;

import com.tkisor.utiljs.wrapper.kubejs.RecipeTypeFunctionWrapper;
import dev.latvian.mods.kubejs.recipe.RecipeTypeFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(RecipeTypeFunction.class)
public class MixinRecipeTypeFunction {
    @Unique
    public RecipeTypeFunctionWrapper wrap() {
        return new RecipeTypeFunctionWrapper((RecipeTypeFunction)(Object)this);
    }
}
