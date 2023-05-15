package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.items.DoedicurusChestplateItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DoedicurusChestplateModel extends AnimatedGeoModel<DoedicurusChestplateItem> {

    @Override
    public ResourceLocation getModelResource(DoedicurusChestplateItem object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "geo/doedicurus_chestplate.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DoedicurusChestplateItem object) {
        return new ResourceLocation(OddOrganisms.MOD_ID, "textures/armor/doedicurus_chestplate.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DoedicurusChestplateItem object) {
        return null;
    }
}
