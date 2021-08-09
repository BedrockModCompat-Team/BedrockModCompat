package com.github.olivermakescode.bedrockmodcompat.mixin;

import io.github.theepicblock.polymc.api.PolyMap;
import io.github.theepicblock.polymc.impl.misc.logging.SimpleLogger;
import io.github.theepicblock.polymc.impl.resource.ResourcePackGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;

@Mixin(ResourcePackGenerator.class)
public class GeyserResourcePackGenerator {
    @Inject(at=@At("RETURN"), method="generate(Lio/github/theepicblock/polymc/api/PolyMap;Ljava/lang/String;Lio/github/theepicblock/polymc/impl/misc/logging/SimpleLogger;)V", remap=false)
    private static void generateBedrock(PolyMap map, String directory, SimpleLogger logger, CallbackInfo ci) {
        Path resourcePath = Path.of(directory).toAbsolutePath();
        Path geyserResourcePath = Path.of("config/Geyser-Fabric/packs").toAbsolutePath();


    }
}
