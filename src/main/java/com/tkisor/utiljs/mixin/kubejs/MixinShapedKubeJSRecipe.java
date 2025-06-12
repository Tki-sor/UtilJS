package com.tkisor.utiljs.mixin.kubejs;

import com.tkisor.utiljs.wrapper.kubejs.ShapedKubeJSRecipeWrapper;
import dev.latvian.mods.kubejs.recipe.special.ShapedKubeJSRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ShapedKubeJSRecipe.class)
public class MixinShapedKubeJSRecipe {
    @Unique
    public ShapedKubeJSRecipeWrapper wrap() {
        return new ShapedKubeJSRecipeWrapper((ShapedKubeJSRecipe)(Object)this);
    }
}
