package com.github.olivermakescode.bedrockmodcompat;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class GeyserRegistrationEvents {
    public static HashMap<String,String> itemTextures = new HashMap<>();

    public static void register() {
        RegistryEntryAddedCallback.event(Registry.ITEM).register((rawId, id, obj) -> {
            if (id.getNamespace().equals("minecraft")) return;
            registerGeyserItem(id,obj);

        });
        RegistryEntryAddedCallback.event(Registry.BLOCK).register((rawId, id, obj) -> {
            if (id.getNamespace().equals("minecraft")) return;
            registerGeyserBlock(id,obj);
        });
    }

    public static void registerGeyserItem(Identifier id, Item item) {
        String name = id.getNamespace();

    }

    public static void registerGeyserBlock(Identifier id, Block block) {
        String identifier = id.toString();

    }
}
