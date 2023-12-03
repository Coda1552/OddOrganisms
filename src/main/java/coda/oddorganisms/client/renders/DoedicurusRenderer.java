package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.DoedicurusModel;
import coda.oddorganisms.common.entities.Doedicurus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DoedicurusRenderer extends GeoEntityRenderer<Doedicurus> {

    public DoedicurusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DoedicurusModel());
    }

/*    @Override
    public void render(GeoModel model, Doedicurus animatable, float partialTicks, RenderType type, PoseStack matrixStackIn, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (animatable.isBaby()) {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        }

        super.render(model, animatable, partialTicks, type, matrixStackIn, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }*/
}
