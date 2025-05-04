package net.gavin.zoocraftmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gavin.zoocraftmod.block.ModBlocks;
import net.gavin.zoocraftmod.entity.ModEntities;
import net.gavin.zoocraftmod.entity.custom.FerretEntity;
import net.gavin.zoocraftmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoocraftMod implements ModInitializer {
	public static final String MOD_ID = "zoocraftmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		//Register Ferret entity and create attributes
		FabricDefaultAttributeRegistry.register(ModEntities.FERRET, FerretEntity.createAttributes());
	}
}