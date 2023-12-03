package coda.oddorganisms.client;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.renders.*;
import coda.oddorganisms.registry.OOEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OddOrganisms.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(OOEntities.DAWN_HORSE.get(), DawnHorseRenderer::new);
        e.registerEntityRenderer(OOEntities.DOEDICURUS.get(), DoedicurusRenderer::new);
        e.registerEntityRenderer(OOEntities.EOLACTORIA.get(), EolactoriaRenderer::new);
        e.registerEntityRenderer(OOEntities.APTHOROBLATTINA.get(), ApthoroblattinaRenderer::new);
        e.registerEntityRenderer(OOEntities.LEPTICTIDIUM.get(), LeptictidiumRenderer::new);
        e.registerEntityRenderer(OOEntities.BOREALOPELTA.get(), BorealopeltaRenderer::new);
    }
}
