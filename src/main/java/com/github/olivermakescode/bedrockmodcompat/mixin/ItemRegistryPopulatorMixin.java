package com.github.olivermakescode.bedrockmodcompat.mixin;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import org.geysermc.connector.registry.populator.ItemRegistryPopulator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRegistryPopulator.class)
public class ItemRegistryPopulatorMixin {

    @Inject(at = @At("HEAD"), method = "populate", remap = false)
    private static void populate(CallbackInfo ci) {
        for (int i = 0; i < Registry.ITEM.stream().count(); i++) {
            if (!Registry.ITEM.getId(Registry.ITEM.get(i)).getNamespace().equals("minecraft")) {
                ItemRegistryPopulator.externalItemRegisters.add(i);
                ItemRegistryPopulator.externalItemNamespace.add(Registry.ITEM.getId(Registry.ITEM.get(i)).getNamespace());
                ItemRegistryPopulator.externalItemPath.add(Registry.ITEM.getId(Registry.ITEM.get(i)).getPath());
                System.out.println(Registry.ITEM.getId(Registry.ITEM.get(i)).getPath());
            }
        }
    }
}
