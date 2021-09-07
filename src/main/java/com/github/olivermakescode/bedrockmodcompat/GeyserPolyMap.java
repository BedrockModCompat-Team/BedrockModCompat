package com.github.olivermakescode.bedrockmodcompat;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

/*
public class GeyserPolyMap implements PolyMap {
    public HashMap<ScreenHandlerType<?>, GuiPoly> guiPolys;

    public GeyserPolyMap() {
        guiPolys = new HashMap<>();
        for (ScreenHandlerType<?> gui : Registry.SCREEN_HANDLER)
            if (!Util.isVanilla(Registry.SCREEN_HANDLER.getId(gui)))
                guiPolys.put(gui, new NaiveStackListingChestPoly());

    }

    @Override
    public ItemStack getClientItem(ItemStack serverItem, @Nullable ServerPlayerEntity player) {
        return serverItem;
    }

    @Override
    public BlockState getClientBlock(BlockState serverBlock) {
        return serverBlock;
    }

    @Override
    public GuiPoly getGuiPoly(ScreenHandlerType<?> serverGuiType) {
        return guiPolys.get(serverGuiType);
    }

    @Override
    public BlockPoly getBlockPoly(Block block) {
        return null;
    }

    @Override
    public ImmutableMap<Item, ItemPoly> getItemPolys() {
        return null;
    }

    @Override
    public ImmutableMap<Block, BlockPoly> getBlockPolys() {
        return null;
    }

    @Override
    public ItemStack reverseClientItem(ItemStack clientItem) {
        return clientItem;
    }

    @Override
    public boolean isVanillaLikeMap() {
        return false;
    }

}
 */
