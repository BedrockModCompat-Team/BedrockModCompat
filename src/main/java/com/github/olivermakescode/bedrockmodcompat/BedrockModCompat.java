package com.github.olivermakescode.bedrockmodcompat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BedrockModCompat implements ModInitializer {
	public Item testItem = new SwordItem(ToolMaterials.DIAMOND,100,20,new FabricItemSettings());
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("test","testitem"), testItem);
		GeyserRegistrationEvents.register();
	}
}
