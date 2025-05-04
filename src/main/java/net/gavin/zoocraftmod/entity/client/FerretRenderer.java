package net.gavin.zoocraftmod.entity.client;

import net.gavin.zoocraftmod.ZoocraftMod;
import net.gavin.zoocraftmod.entity.custom.FerretEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FerretRenderer extends MobEntityRenderer<FerretEntity, FerretModel<FerretEntity>> {
    public FerretRenderer(EntityRendererFactory.Context context) {
        super(context, new FerretModel<>(context.getPart(FerretModel.FERRET)), 0.15f);
    }

    @Override
    public Identifier getTexture(FerretEntity entity) {
        return Identifier.of(ZoocraftMod.MOD_ID,"textures/entity/ferret/ferret.png");
    }

    @Override
    public void render(FerretEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f, 0.5f);
        } else {
            matrixStack.scale(2f,2f,2f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
