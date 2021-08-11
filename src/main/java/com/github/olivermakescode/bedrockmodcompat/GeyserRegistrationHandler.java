package com.github.olivermakescode.bedrockmodcompat;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class GeyserRegistrationHandler {
    public static MinecraftServer server;

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            GeyserRegistrationHandler.server = server;
        });
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            GeyserRegistrationHandler.server = null;
        });
    }
}
