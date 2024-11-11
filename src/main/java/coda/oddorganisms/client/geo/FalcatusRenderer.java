package coda.oddorganisms.client.geo;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Falcatus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FalcatusRenderer extends GeoEntityRenderer<Falcatus> {

    public FalcatusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OODefaultedEntityGeoModel<>(new ResourceLocation(OddOrganisms.MOD_ID, "falcatus")));
    }

    @Override
    public void render(Falcatus entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (!entity.isInWater() && entity.isAddedToWorld()) {
            poseStack.translate(0.1F, 0.1F, -0.1F);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
