package coda.oddorganisms.client.models;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Eolactoria;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class EolactoriaModel extends DefaultedEntityGeoModel<Eolactoria> {

    public EolactoriaModel() {
        super(new ResourceLocation(OddOrganisms.MOD_ID, "eolactoria"));
    }
}
