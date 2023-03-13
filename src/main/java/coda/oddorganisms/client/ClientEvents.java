package coda.oddorganisms.client;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.models.DoedicurusChestplateModel;
import coda.oddorganisms.client.models.render.*;
import coda.oddorganisms.client.renders.*;
import coda.oddorganisms.client.renders.armor.ArmorItemRenderer;
import coda.oddorganisms.client.renders.render.*;
import coda.oddorganisms.common.items.DoedicurusChestplateItem;
import coda.oddorganisms.registry.OOEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = OddOrganisms.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e) {
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers e) {
        // Animals
        e.registerEntityRenderer(OOEntities.DAWN_HORSE.get(), DawnHorseRenderer::new);
        e.registerEntityRenderer(OOEntities.DOEDICURUS.get(), DoedicurusRenderer::new);
        e.registerEntityRenderer(OOEntities.EOLACTORIA.get(), EolactoriaRenderer::new);
        e.registerEntityRenderer(OOEntities.APTHOROBLATTINA.get(), ApthoroblattinaRenderer::new);
        e.registerEntityRenderer(OOEntities.LEPTICTIDIUM.get(), LeptictidiumRenderer::new);

        // Renders
        e.registerEntityRenderer(OOEntities.DAWN_HORSE_RENDER.get(), DawnHorseRenderRenderer::new);
        e.registerEntityRenderer(OOEntities.DOEDICURUS_RENDER.get(), DoedicurusRenderRenderer::new);
        e.registerEntityRenderer(OOEntities.EOLACTORIA_RENDER.get(), EolactoriaRenderRenderer::new);
        e.registerEntityRenderer(OOEntities.APTHOROBLATTINA_RENDER.get(), ApthoroblattinaRenderRenderer::new);
        e.registerEntityRenderer(OOEntities.LEPTICTIDIUM_RENDER.get(), LeptictidiumRenderRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(DawnHorseRenderModel.LAYER_LOCATION, DawnHorseRenderModel::createBodyLayer);
        e.registerLayerDefinition(DoedicurusRenderModel.LAYER_LOCATION, DoedicurusRenderModel::createBodyLayer);
        e.registerLayerDefinition(EolactoriaRenderModel.LAYER_LOCATION, EolactoriaRenderModel::createBodyLayer);
        e.registerLayerDefinition(ApthoroblattinaRenderModel.LAYER_LOCATION, ApthoroblattinaRenderModel::createBodyLayer);
        e.registerLayerDefinition(LeptictidiumRenderModel.LAYER_LOCATION, LeptictidiumRenderModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerArmorRenders(EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(DoedicurusChestplateItem.class, () -> new ArmorItemRenderer<>(new DoedicurusChestplateModel()));
    }
}
