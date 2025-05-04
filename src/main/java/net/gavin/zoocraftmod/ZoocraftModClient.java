package net.gavin.zoocraftmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gavin.zoocraftmod.block.ModBlocks;
import net.gavin.zoocraftmod.entity.ModEntities;
import net.gavin.zoocraftmod.entity.client.FerretModel;
import net.gavin.zoocraftmod.entity.client.FerretRenderer;
import net.minecraft.client.render.RenderLayer;

public class ZoocraftModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {



        EntityModelLayerRegistry.registerModelLayer(FerretModel.FERRET, FerretModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FERRET, FerretRenderer::new);
    }
}
