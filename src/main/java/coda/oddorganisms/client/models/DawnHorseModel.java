package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.DawnHorse;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DawnHorseModel extends DefaultedEntityGeoModel<DawnHorse> {

    public DawnHorseModel() {
        super(new ResourceLocation(OddOrganisms.MOD_ID, "dawn_horse"));
    }
}
