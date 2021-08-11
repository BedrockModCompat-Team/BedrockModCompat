package com.github.olivermakescode.bedrockmodcompat;

import io.github.theepicblock.polymc.api.PolyMap;
import io.github.theepicblock.polymc.api.misc.PolyMapProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.geysermc.connector.GeyserConnector;

public class GeyserRegistrationHandler {
    public static MinecraftServer server;
    public static PolyMap GEYSERMAP = new GeyserPolyMap();

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            GeyserRegistrationHandler.server = server;
        });
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            GeyserRegistrationHandler.server = null;
        });

        PolyMapProvider.EVENT.register(player -> GeyserConnector.getInstance().getPlayerByUuid(player.getUuid()) != null ? GEYSERMAP : null);
    }
}
