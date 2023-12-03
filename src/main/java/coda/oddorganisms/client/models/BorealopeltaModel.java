package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Borealopelta;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BorealopeltaModel extends DefaultedEntityGeoModel<Borealopelta> {

    public BorealopeltaModel() {
        super(new ResourceLocation(OddOrganisms.MOD_ID, "borealopelta"));
    }
}
