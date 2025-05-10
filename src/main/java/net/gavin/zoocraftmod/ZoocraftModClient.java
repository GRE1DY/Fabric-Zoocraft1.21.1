package net.gavin.zoocraftmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gavin.zoocraftmod.entity.ModEntities;
import net.gavin.zoocraftmod.entity.client.FerretModel;
import net.gavin.zoocraftmod.entity.client.FerretRenderer;
import net.gavin.zoocraftmod.entity.client.ModEntityModelLayers;

public class ZoocraftModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {



        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.FERRET, FerretModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FERRET, FerretRenderer::new);
    }
}
