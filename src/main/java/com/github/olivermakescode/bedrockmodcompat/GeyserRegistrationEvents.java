package com.github.olivermakescode.bedrockmodcompat;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class GeyserRegistrationEvents {
    public static MinecraftServer server;

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            GeyserRegistrationEvents.server = server;
        });
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            GeyserRegistrationEvents.server = null;
        });
    }
}
