package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.EolactoriaModel;
import coda.oddorganisms.common.entities.Eolactoria;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EolactoriaRenderer extends GeoEntityRenderer<Eolactoria> {

    public EolactoriaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EolactoriaModel());
    }

    @Override
    public void render(Eolactoria entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (!animatable.isInWater() && animatable.isAddedToWorld()) {
            poseStack.translate(0.1F, 0.1F, -0.1F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
