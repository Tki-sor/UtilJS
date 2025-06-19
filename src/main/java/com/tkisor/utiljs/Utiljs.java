package com.tkisor.utiljs;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Utiljs.ID)
public class Utiljs {
    public static final String ID = "utiljs";
    public static final Logger LOGGER = LogManager.getLogger(ID);

    public Utiljs(IEventBus modEventBus, ModContainer modContainer) {
    }
}
