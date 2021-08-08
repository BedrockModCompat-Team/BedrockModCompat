package com.github.olivermakescode.bedrockmodcompat;

import net.fabricmc.api.ModInitializer;

public class BedrockModCompat implements ModInitializer {
	@Override
	public void onInitialize() {
		GeyserRegistrationEvents.register();
	}
}
