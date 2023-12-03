package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.BorealopeltaModel;
import coda.oddorganisms.common.entities.Borealopelta;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BorealopeltaRenderer extends GeoEntityRenderer<Borealopelta> {

    public BorealopeltaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BorealopeltaModel());
    }
}
