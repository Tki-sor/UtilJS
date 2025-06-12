package com.tkisor.utiljs.mixin.kubejs;

import com.tkisor.utiljs.wrapper.kubejs.ShapelessKubeJSRecipeWrapper;
import dev.latvian.mods.kubejs.recipe.special.ShapelessKubeJSRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ShapelessKubeJSRecipe.class)
public class MixinShapelessKubeJSRecipe {
    @Unique
    public ShapelessKubeJSRecipeWrapper wrap() {
        return new ShapelessKubeJSRecipeWrapper((ShapelessKubeJSRecipe)(Object)this);
    }
}
