package com.tkisor.utiljs.kubejs;

import com.iafenvoy.server.i18n.ServerI18n;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.DyeColor;
import net.neoforged.fml.ModList;
import one.util.streamex.DoubleStreamEx;
import one.util.streamex.IntStreamEx;
import one.util.streamex.LongStreamEx;
import one.util.streamex.StreamEx;

public class UtilJSPlugin implements KubeJSPlugin {

    @Override
    public void registerEvents(EventGroupRegistry registry) {
    }

    @Override
    public void afterInit() {
    }

    @Override
    public void registerBindings(BindingRegistry bindings) {
        bindings.add("UtilJS", UtilJS.class);
        // bindings.add("Thread", Thread.class);
        // bindings.add("Executors", Executors.class);

        bindings.add("Integer", Integer.class);
        bindings.add("Boolean", Boolean.class);
        bindings.add("Double", Double.class);
        bindings.add("Float", Float.class);
        bindings.add("Long", Long.class);
        bindings.add("Short", Short.class);
        bindings.add("Byte", Byte.class);
        bindings.add("String", String.class);

        bindings.add("Stream", StreamEx.class);
        bindings.add("IntStream", IntStreamEx.class);
        bindings.add("LongStream", LongStreamEx.class);
        bindings.add("DoubleStream", DoubleStreamEx.class);

        bindings.add("IntArrayList", IntArrayList.class);
        bindings.add("LongArrayList", LongArrayList.class);
        bindings.add("DoubleArrayList", DoubleArrayList.class);
        bindings.add("FloatArrayList", FloatArrayList.class);
        bindings.add("ObjectArrayList", ObjectArrayList.class);

        bindings.add("DyeColor", DyeColor.class);
        
        if (ModList.get().isLoaded("server_i18n_api")) {
            bindings.add("ServerI18n", ServerI18n.class);
        }
    }
}
