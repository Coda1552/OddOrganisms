package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.ApthoroblattinaModel;
import coda.oddorganisms.common.entities.Apthoroblattina;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ApthoroblattinaRenderer extends GeoEntityRenderer<Apthoroblattina> {

    public ApthoroblattinaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ApthoroblattinaModel());
    }

    @Override
    public void render(Apthoroblattina entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
