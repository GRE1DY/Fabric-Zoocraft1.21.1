package net.gavin.zoocraftmod.util;

import net.gavin.zoocraftmod.ZoocraftMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTage(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ZoocraftMod.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTage(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ZoocraftMod.MOD_ID, name));
        }
    }

}
