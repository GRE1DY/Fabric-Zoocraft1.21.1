package net.gavin.zoocraftmod;

import net.fabricmc.api.ModInitializer;

import net.gavin.zoocraftmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoocraftMod implements ModInitializer {
	public static final String MOD_ID = "zoocraftmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}