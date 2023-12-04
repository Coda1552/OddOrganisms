package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.LeptictidiumModel;
import coda.oddorganisms.common.entities.DawnHorse;
import coda.oddorganisms.common.entities.Leptictidium;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LeptictidiumRenderer extends GeoEntityRenderer<Leptictidium> {

    public LeptictidiumRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LeptictidiumModel());
    }

    @Override
    public void render(Leptictidium entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
