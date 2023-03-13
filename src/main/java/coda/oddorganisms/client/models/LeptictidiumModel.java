package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Leptictidium;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LeptictidiumModel extends AnimatedGeoModel<Leptictidium> {

    @Override
    public ResourceLocation getModelResource(Leptictidium object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "geo/leptictidium.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Leptictidium object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/leptictidium.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Leptictidium animatable) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "animations/leptictidium.animation.json");
    }
}
