package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Leptictidium;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class LeptictidiumModel extends DefaultedEntityGeoModel<Leptictidium> {

    public LeptictidiumModel() {
        super(new ResourceLocation(OddOrganisms.MOD_ID, "leptictidium"));
    }
}
