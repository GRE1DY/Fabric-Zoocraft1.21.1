package net.gavin.zoocraftmod.entity.client;

import net.gavin.zoocraftmod.ZoocraftMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModelLayers {
    public static final EntityModelLayer FERRET =
            new EntityModelLayer(Identifier.of(ZoocraftMod.MOD_ID, "ferret"), "main");
}
