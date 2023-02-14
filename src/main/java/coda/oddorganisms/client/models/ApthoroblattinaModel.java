package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Apthoroblattina;
import coda.oddorganisms.common.entities.DawnHorse;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ApthoroblattinaModel extends AnimatedGeoModel<Apthoroblattina> {

    @Override
    public ResourceLocation getModelResource(Apthoroblattina object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "geo/apthoroblattina.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Apthoroblattina object) {
        return object.isBaby() ? new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/apthoroblattina_baby.png") : new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/apthoroblattina.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Apthoroblattina animatable) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "animations/apthoroblattina.animation.json");
    }
}
