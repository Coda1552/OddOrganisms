package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.DawnHorseModel;
import coda.oddorganisms.common.entities.DawnHorse;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DawnHorseRenderer extends GeoEntityRenderer<DawnHorse> {

    public DawnHorseRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DawnHorseModel());
    }

    @Override
    public RenderType getRenderType(DawnHorse animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(textureLocation);
    }

    @Override
    public void render(GeoModel model, DawnHorse animatable, float partialTicks, RenderType type, PoseStack matrixStackIn, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (animatable.isBaby()) {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        }

        super.render(model, animatable, partialTicks, type, matrixStackIn, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
