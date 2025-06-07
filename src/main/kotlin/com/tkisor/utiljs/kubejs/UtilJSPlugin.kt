package com.tkisor.utiljs.kubejs

import dev.latvian.mods.kubejs.event.EventGroupRegistry
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin
import dev.latvian.mods.kubejs.script.BindingRegistry
import java.util.concurrent.Executors

class UtilJSPlugin : KubeJSPlugin {
    override fun registerEvents(registry: EventGroupRegistry?) {
    }

    override fun afterInit() {
    }

    override fun registerBindings(bindings: BindingRegistry) {
        bindings.add("UtilJS", UtilJS::class.java)
//        bindings.add("Thread", Thread::class.java)
//        bindings.add("Executors", Executors::class.java)

        bindings.add("Integer", Integer::class.java)
        bindings.add("Boolean", java.lang.Boolean::class.java)
        bindings.add("Double", java.lang.Double::class.java)
        bindings.add("Float", java.lang.Float::class.java)
        bindings.add("Long", java.lang.Long::class.java)
        bindings.add("Short", java.lang.Short::class.java)
        bindings.add("Byte", java.lang.Byte::class.java)

    }
}
