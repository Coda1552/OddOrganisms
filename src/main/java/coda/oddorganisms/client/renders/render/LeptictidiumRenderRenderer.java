package coda.oddorganisms.client.renders.render;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.models.render.LeptictidiumRenderModel;
import com.peeko32213.unusualprehistory.common.entity.render.BaseEntityRender;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LeptictidiumRenderRenderer extends MobRenderer<BaseEntityRender, LeptictidiumRenderModel<BaseEntityRender>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/leptictidium.png");

    public LeptictidiumRenderRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new LeptictidiumRenderModel<>(renderManagerIn.bakeLayer(LeptictidiumRenderModel.LAYER_LOCATION)), 0.1F);
    }

    public ResourceLocation getTextureLocation(BaseEntityRender entity) {
        return TEXTURE;
    }
}
