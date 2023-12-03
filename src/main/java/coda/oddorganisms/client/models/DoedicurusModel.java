package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Doedicurus;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DoedicurusModel extends DefaultedEntityGeoModel<Doedicurus> {

    public DoedicurusModel() {
        super(new ResourceLocation(OddOrganisms.MOD_ID, "doedicurus"));
    }
}
