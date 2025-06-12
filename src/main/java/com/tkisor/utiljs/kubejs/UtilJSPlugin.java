package com.tkisor.utiljs.kubejs;

import com.iafenvoy.server.i18n.ServerI18n;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import net.minecraft.world.item.DyeColor;
import net.neoforged.fml.ModList;

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

        bindings.add("DyeColor", DyeColor.class);
        
        if (ModList.get().isLoaded("server_i18n_api")) {
            bindings.add("ServerI18n", ServerI18n.class);
        }
    }
}
