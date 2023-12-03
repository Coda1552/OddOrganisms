package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.LeptictidiumModel;
import coda.oddorganisms.common.entities.Leptictidium;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LeptictidiumRenderer extends GeoEntityRenderer<Leptictidium> {

    public LeptictidiumRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LeptictidiumModel());
    }
}
