package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Apthoroblattina;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ApthoroblattinaModel extends DefaultedEntityGeoModel<Apthoroblattina> {

    public ApthoroblattinaModel() {
        super(new ResourceLocation(OddOrganisms.MOD_ID, "apthoroblattina"));
    }

    @Override
    public ResourceLocation getTextureResource(Apthoroblattina object) {
        return object.isBaby() ? new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/apthoroblattina_baby.png") : new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/apthoroblattina.png");
    }
}

