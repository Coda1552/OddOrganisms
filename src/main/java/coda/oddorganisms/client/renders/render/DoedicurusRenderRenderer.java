package coda.oddorganisms.client.renders.render;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.models.render.DoedicurusRenderModel;
import com.peeko32213.unusualprehistory.common.entity.render.BaseEntityRender;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DoedicurusRenderRenderer extends MobRenderer<BaseEntityRender, DoedicurusRenderModel<BaseEntityRender>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/doedicurus.png");

    public DoedicurusRenderRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new DoedicurusRenderModel<>(renderManagerIn.bakeLayer(DoedicurusRenderModel.LAYER_LOCATION)), 0.3F);
    }

    public ResourceLocation getTextureLocation(BaseEntityRender entity) {
        return TEXTURE;
    }
}
