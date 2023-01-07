package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Eolactoria;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EolactoriaModel extends AnimatedGeoModel<Eolactoria> {

    @Override
    public ResourceLocation getModelLocation(Eolactoria object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "geo/eolactoria.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Eolactoria object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "textures/entity/eolactoria.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Eolactoria animatable) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "animations/eolactoria.animation.json");
    }
}
