package coda.oddorganisms.client.renders.render;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.models.render.DawnHorseRenderModel;
import com.peeko32213.unusualprehistory.common.entity.render.BaseEntityRender;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DawnHorseRenderRenderer extends MobRenderer<BaseEntityRender, DawnHorseRenderModel<BaseEntityRender>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/dawn_horse.png");

    public DawnHorseRenderRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new DawnHorseRenderModel<>(renderManagerIn.bakeLayer(DawnHorseRenderModel.LAYER_LOCATION)), 0.3F);
    }

    public ResourceLocation getTextureLocation(BaseEntityRender entity) {
        return TEXTURE;
    }
}
