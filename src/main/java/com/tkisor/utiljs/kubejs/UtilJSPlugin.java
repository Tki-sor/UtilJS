package com.tkisor.utiljs.kubejs;

import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;

public class UtilJSPlugin implements KubeJSPlugin {

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        // 可以根据需要注册事件
    }

    @Override
    public void afterInit() {
        // 初始化完成后调用
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
    }
}
