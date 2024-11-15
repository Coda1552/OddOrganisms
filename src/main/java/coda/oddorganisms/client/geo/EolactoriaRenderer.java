package coda.oddorganisms.client.geo;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Eolactoria;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EolactoriaRenderer extends GeoEntityRenderer<Eolactoria> {

    public EolactoriaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OODefaultedEntityGeoModel<>(new ResourceLocation(OddOrganisms.MOD_ID, "eolactoria")));
    }

    @Override
    public void render(Eolactoria entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (!entity.isInWater() && entity.isAddedToWorld()) {
            poseStack.translate(0.1F, 0.1F, -0.1F);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public RenderType getRenderType(Eolactoria animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}
