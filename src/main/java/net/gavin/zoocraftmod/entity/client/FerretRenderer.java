package net.gavin.zoocraftmod.entity.client;

import com.google.common.collect.Maps;
import net.gavin.zoocraftmod.ZoocraftMod;
import net.gavin.zoocraftmod.entity.custom.FerretEntity;
import net.gavin.zoocraftmod.entity.custom.FerretVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class FerretRenderer extends MobEntityRenderer<FerretEntity, FerretModel<FerretEntity>> {
    private static final Map<FerretVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(FerretVariant.class), map -> {
                map.put(FerretVariant.DEFAULT,
                        Identifier.of(ZoocraftMod.MOD_ID, "textures/entity/ferret/ferret.png"));
                map.put(FerretVariant.CHAMPAGNE,
                        Identifier.of(ZoocraftMod.MOD_ID, "textures/entity/ferret/ferret_champagne.png"));
            });

    public FerretRenderer(EntityRendererFactory.Context context) {
        super(context, new FerretModel<>(context.getPart(ModEntityModelLayers.FERRET)), 0.15f);
    }

    @Override
    public Identifier getTexture(FerretEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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
