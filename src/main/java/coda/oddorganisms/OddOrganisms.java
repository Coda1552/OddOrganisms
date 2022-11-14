package coda.oddorganisms;

import coda.oddorganisms.common.entities.DawnHorse;
import coda.oddorganisms.registry.OOEntities;
import coda.oddorganisms.registry.OOItems;
import com.peeko32213.unusualprehistory.common.entity.render.BaseEntityRender;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OddOrganisms.MOD_ID)
public class OddOrganisms {
    public static final String MOD_ID = "oddorganisms";

    public OddOrganisms() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        OOEntities.ENTITIES.register(bus);
        OOItems.ITEMS.register(bus);

        bus.addListener(this::registerAttributes);
    }

    private void registerAttributes(EntityAttributeCreationEvent e) {
        e.put(OOEntities.DAWN_HORSE.get(), DawnHorse.createAttributes().build());
        e.put(OOEntities.DAWN_HORSE_RENDER.get(), BaseEntityRender.createAttributes().build());
    }
}
