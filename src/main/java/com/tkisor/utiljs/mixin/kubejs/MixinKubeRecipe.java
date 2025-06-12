package com.tkisor.utiljs.mixin.kubejs;

import com.tkisor.utiljs.wrapper.kubejs.KubeRecipeWrapper;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(KubeRecipe.class)
public class MixinKubeRecipe {
    @Unique
    public KubeRecipeWrapper wrap() {
        return new KubeRecipeWrapper((KubeRecipe)(Object)this);
    }
}
