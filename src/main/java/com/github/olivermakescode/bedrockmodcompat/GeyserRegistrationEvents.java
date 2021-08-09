package com.github.olivermakescode.bedrockmodcompat;

import io.github.theepicblock.polymc.api.PolyMap;
import io.github.theepicblock.polymc.api.PolyMcEntrypoint;
import io.github.theepicblock.polymc.api.PolyRegistry;
import io.github.theepicblock.polymc.impl.generator.Generator;
import io.github.theepicblock.polymc.impl.generator.GuiGenerator;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;

import java.util.List;

public class GeyserRegistrationEvents {
    public static MinecraftServer server;
    public static PolyMap BedrockPolyMap;

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            GeyserRegistrationEvents.server = server;
        });
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            GeyserRegistrationEvents.server = null;
        });

        PolyRegistry registry = new PolyRegistry();

        Generator.addDefaultGlobalItemPolys(registry);

        List<PolyMcEntrypoint> entrypoints = FabricLoader.getInstance().getEntrypoints("polymc", PolyMcEntrypoint.class);
        for (PolyMcEntrypoint entrypointEntry : entrypoints) {
            entrypointEntry.registerPolys(registry);
        }

        GuiGenerator.generateMissing(registry);

        BedrockPolyMap = registry.build();
    }
}
