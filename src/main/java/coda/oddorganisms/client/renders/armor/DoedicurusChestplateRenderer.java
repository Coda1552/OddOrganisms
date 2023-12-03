package coda.oddorganisms.client.renders.armor;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.items.DoedicurusChestplateItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DoedicurusChestplateRenderer extends GeoArmorRenderer<DoedicurusChestplateItem> {

    public DoedicurusChestplateRenderer() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(OddOrganisms.MOD_ID, "armor/doedicurus_chestplate")));
    }
}