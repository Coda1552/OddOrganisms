package coda.oddorganisms.client.renders;

import coda.oddorganisms.client.models.ApthoroblattinaModel;
import coda.oddorganisms.common.entities.Apthoroblattina;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ApthoroblattinaRenderer extends GeoEntityRenderer<Apthoroblattina> {

    public ApthoroblattinaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ApthoroblattinaModel());
    }
}
