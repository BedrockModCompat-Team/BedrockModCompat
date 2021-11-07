package com.github.olivermakescode.bedrockmodcompat.mixin;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import org.geysermc.connector.registry.populator.BlockRegistryPopulator;
import org.geysermc.connector.registry.populator.ItemRegistryPopulator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(BlockRegistryPopulator.class)
public class BlockRegistryPopulatorMixin {

    @Inject(at = @At("HEAD"), method = "populate", remap = false)
    private static void populate(CallbackInfo ci) {
        for (int i = 0; i < Registry.BLOCK.stream().count(); i++) {
            if (!Registry.BLOCK.getId(Registry.BLOCK.get(i)).getNamespace().equals("minecraft")) {
                ItemRegistryPopulator.externalBlockItemRegisters.add(i);
                ItemRegistryPopulator.externalBlockItemNamespace.add(Registry.BLOCK.getId(Registry.BLOCK.get(i)).getNamespace());
                ItemRegistryPopulator.externalBlockItemPath.add(Registry.BLOCK.getId(Registry.BLOCK.get(i)).getPath());
                BlockRegistryPopulator.javaRuntimeIds.add(Block.getRawIdFromState(Registry.BLOCK.get(i).getDefaultState()));
                System.out.println(Registry.BLOCK.getId(Registry.BLOCK.get(i)).getPath());
            }
        }
    }
}
