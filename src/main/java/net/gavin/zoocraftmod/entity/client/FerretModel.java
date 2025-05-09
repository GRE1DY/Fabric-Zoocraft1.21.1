package net.gavin.zoocraftmod.entity.client;

import net.gavin.zoocraftmod.entity.client.animation.FerretAnimations;
import net.gavin.zoocraftmod.entity.custom.FerretEntity;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class FerretModel<T extends FerretEntity> extends SinglePartEntityModel<T> {
    private final ModelPart ferret;
    private final ModelPart head;


    public FerretModel(ModelPart root) {
        this.ferret = root.getChild("ferret");
        this.head = this.ferret.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ferret = modelPartData.addChild("ferret", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = ferret.addChild("head", ModelPartBuilder.create().uv(8, 0).mirrored().cuboid(-0.25F, -0.25F, -1.75F, 2.0F, 1.5F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 2).cuboid(0.25F, 0.5F, -2.5F, 1.0F, 0.75F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(-0.75F, -4.0F, -2.95F));

        ModelPartData right_ear_r1 = head.addChild("right_ear_r1", ModelPartBuilder.create().uv(11, 4).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        ModelPartData left_ear_r1 = head.addChild("left_ear_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.25F, new Dilation(0.0F)), ModelTransform.of(1.5F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));

        ModelPartData neck = ferret.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.5803F, -2.6053F));

        ModelPartData neck_r1 = neck.addChild("neck_r1", ModelPartBuilder.create().uv(0, 7).cuboid(-0.8F, -0.75F, -1.875F, 1.6F, 1.5F, 2.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5303F, 0.5303F, -0.7854F, 0.0F, 0.0F));

        ModelPartData upper_body = ferret.addChild("upper_body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.85F, -1.75F, 2.0F, 1.7F, 3.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.15F, -0.55F));

        ModelPartData lower_body = ferret.addChild("lower_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.8848F, 1.8166F));

        ModelPartData lower_body_r1 = lower_body.addChild("lower_body_r1", ModelPartBuilder.create().uv(8, 7).cuboid(-1.0F, -0.85F, -1.875F, 2.0F, 1.7F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.3348F, 0.8084F, -0.3927F, 0.0F, 0.0F));

        ModelPartData tail = ferret.addChild("tail", ModelPartBuilder.create().uv(7, 11).cuboid(-0.25F, -0.475F, -1.0F, 0.75F, 0.7F, 3.4F, new Dilation(0.0F)), ModelTransform.pivot(-0.15F, -1.775F, 3.25F));

        ModelPartData left_front_leg = ferret.addChild("left_front_leg", ModelPartBuilder.create().uv(3, 12).cuboid(-0.375F, -0.55F, -0.375F, 0.75F, 3.1F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.675F, -2.55F, -1.875F));

        ModelPartData left_back_leg = ferret.addChild("left_back_leg", ModelPartBuilder.create().uv(6, 11).mirrored().cuboid(-0.375F, -0.425F, -0.375F, 0.75F, 1.85F, 0.75F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.675F, -1.425F, 2.125F));

        ModelPartData right_back_leg = ferret.addChild("right_back_leg", ModelPartBuilder.create().uv(12, 11).cuboid(-0.375F, -0.425F, -0.375F, 0.75F, 1.85F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(-0.725F, -1.425F, 2.125F));

        ModelPartData right_front_leg = ferret.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 12).mirrored().cuboid(-0.375F, -0.55F, -0.375F, 0.75F, 3.1F, 0.75F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-0.675F, -2.55F, -1.875F));
        return TexturedModelData.of(modelData, 16, 16);
    }
    @Override
    public void setAngles(FerretEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(FerretAnimations.ANIM_FERRET_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, FerretAnimations.ANIM_FERRET_IDLE, ageInTicks, 1f);

        this.updateAnimation(entity.sittingTransitionAnimationState, FerretAnimations.ANIM_FERRET_SIT, ageInTicks, 1.0f);
        this.updateAnimation(entity.sittingAnimationState, FerretAnimations.ANIM_FERRET_SITTING, ageInTicks, 1.0f);
        this.updateAnimation(entity.standTransitionAnimationState, FerretAnimations.ANIM_FERRET_STAND, ageInTicks, 1.0f);

    }

    private void setHeadAngles (float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        ferret.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return ferret;
    }
}
