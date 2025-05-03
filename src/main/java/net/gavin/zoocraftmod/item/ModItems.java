package net.gavin.zoocraftmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gavin.zoocraftmod.ZoocraftMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FOSSIL = registerItem("fossil", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ZoocraftMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ZoocraftMod.LOGGER.info("Registering Mod Items for " + ZoocraftMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FOSSIL);
        });
    }
}
