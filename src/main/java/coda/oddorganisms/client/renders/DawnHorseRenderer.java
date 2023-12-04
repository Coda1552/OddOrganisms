package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.DawnHorseModel;
import coda.oddorganisms.common.entities.DawnHorse;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DawnHorseRenderer extends GeoEntityRenderer<DawnHorse> {

    public DawnHorseRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DawnHorseModel());
    }

    @Override
    public void render(DawnHorse entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
