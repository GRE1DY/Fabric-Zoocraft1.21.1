package net.gavin.zoocraftmod.entity;

import net.gavin.zoocraftmod.ZoocraftMod;
import net.gavin.zoocraftmod.entity.custom.FerretEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FerretEntity> FERRET = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ZoocraftMod.MOD_ID, "ferret"),
            EntityType.Builder.create(FerretEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f,0.5f).build());


    public static void registerModEntities() {
        ZoocraftMod.LOGGER.info("Registering Mod Entities for " + ZoocraftMod.MOD_ID);
    }
}
