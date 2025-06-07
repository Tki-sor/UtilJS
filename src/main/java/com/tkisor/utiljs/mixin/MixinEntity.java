package com.tkisor.utiljs.mixin;

import com.tkisor.utiljs.ScopeOps;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.attachment.AttachmentHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Mixin(Entity.class)
public class MixinEntity implements ScopeOps<Entity> {

}
