package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Doedicurus;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DoedicurusModel extends AnimatedGeoModel<Doedicurus> {

    @Override
    public ResourceLocation getModelResource(Doedicurus object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "geo/doedicurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Doedicurus object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/doedicurus.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Doedicurus animatable) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "animations/doedicurus.animation.json");
    }
}
