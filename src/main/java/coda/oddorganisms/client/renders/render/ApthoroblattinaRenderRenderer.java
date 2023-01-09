package coda.oddorganisms.client.renders.render;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.models.render.ApthoroblattinaRenderModel;
import coda.oddorganisms.client.models.render.DawnHorseRenderModel;
import com.peeko32213.unusualprehistory.common.entity.render.BaseEntityRender;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ApthoroblattinaRenderRenderer extends MobRenderer<BaseEntityRender, ApthoroblattinaRenderModel<BaseEntityRender>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/apthoroblattina.png");

    public ApthoroblattinaRenderRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ApthoroblattinaRenderModel<>(renderManagerIn.bakeLayer(ApthoroblattinaRenderModel.LAYER_LOCATION)), 0.3F);
    }

    public ResourceLocation getTextureLocation(BaseEntityRender entity) {
        return TEXTURE;
    }
}
