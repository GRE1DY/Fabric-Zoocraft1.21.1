package net.gavin.zoocraftmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gavin.zoocraftmod.ZoocraftMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block FOSSIL_ORE = registerBlock("fossil_ore",
            new Block(AbstractBlock.Settings
                    .create()
                    .strength(3.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block COPPER_FENCE = registerBlock( "copper_fence",
            new WallBlock(AbstractBlock.Settings
                    .create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.COPPER)
                    .nonOpaque()));
    public static final Block COPPER_FENCE_GATE = registerBlock("copper_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings
                    .create()
                    .strength(2)
                    .requiresTool()
                    .sounds(BlockSoundGroup.COPPER)
                    .nonOpaque()));

    private static Block registerBlock (String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ZoocraftMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ZoocraftMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ZoocraftMod.LOGGER.info("Registering Mod Blocks for " + ZoocraftMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.FOSSIL_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(COPPER_FENCE);
            entries.add(COPPER_FENCE_GATE);
        });
    }
}
