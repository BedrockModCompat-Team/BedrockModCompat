package com.github.olivermakescode.bedrockmodcompat.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import org.geysermc.connector.network.translators.inventory.SlotType;
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
                ItemRegistryPopulator.externalItemStackSizes.add(Registry.ITEM.get(i).getMaxCount());

                if (Registry.ITEM.get(i) instanceof ArmorItem) {
                    ItemRegistryPopulator.externalItemArmorCheck.add(true);
                    ItemRegistryPopulator.externalItemDefense.add(((ArmorItem) Registry.ITEM.get(i)).getProtection());

                    if (((ArmorItem) Registry.ITEM.get(i)).getSlotType() == EquipmentSlot.HEAD) {
                        ItemRegistryPopulator.externalItemEquipSlot.add(0);
                    } else if (((ArmorItem) Registry.ITEM.get(i)).getSlotType() == EquipmentSlot.CHEST) {
                        ItemRegistryPopulator.externalItemEquipSlot.add(1);
                    } else if (((ArmorItem) Registry.ITEM.get(i)).getSlotType() == EquipmentSlot.LEGS) {
                        ItemRegistryPopulator.externalItemEquipSlot.add(2);
                    } else if (((ArmorItem) Registry.ITEM.get(i)).getSlotType() == EquipmentSlot.FEET) {
                        ItemRegistryPopulator.externalItemEquipSlot.add(3);
                    } else {
                        ItemRegistryPopulator.externalItemEquipSlot.add(0);
                    }
                } else {
                    ItemRegistryPopulator.externalItemArmorCheck.add(false);
                    ItemRegistryPopulator.externalItemDefense.add(0);
                    ItemRegistryPopulator.externalItemEquipSlot.add(-1);
                }

                System.out.println(Registry.ITEM.getId(Registry.ITEM.get(i)).getPath());
            }
        }
    }
}
