package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Borealopelta;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BorealopeltaModel extends AnimatedGeoModel<Borealopelta> {

    @Override
    public ResourceLocation getModelResource(Borealopelta object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "geo/borealopelta.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Borealopelta object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/borealopelta.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Borealopelta animatable) {
        return null;//new ResourceLocation(OddOrganisms.MOD_ID, "animations/borealopelta.animation.json");
    }
}
