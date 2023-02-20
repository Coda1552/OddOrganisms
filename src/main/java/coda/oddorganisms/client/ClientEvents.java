package coda.oddorganisms.client;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.models.DoedicurusChestplateModel;
import coda.oddorganisms.client.models.render.ApthoroblattinaRenderModel;
import coda.oddorganisms.client.models.render.DawnHorseRenderModel;
import coda.oddorganisms.client.models.render.DoedicurusRenderModel;
import coda.oddorganisms.client.models.render.EolactoriaRenderModel;
import coda.oddorganisms.client.renders.ApthoroblattinaRenderer;
import coda.oddorganisms.client.renders.DawnHorseRenderer;
import coda.oddorganisms.client.renders.DoedicurusRenderer;
import coda.oddorganisms.client.renders.EolactoriaRenderer;
import coda.oddorganisms.client.renders.armor.ArmorItemRenderer;
import coda.oddorganisms.client.renders.render.ApthoroblattinaRenderRenderer;
import coda.oddorganisms.client.renders.render.DawnHorseRenderRenderer;
import coda.oddorganisms.client.renders.render.DoedicurusRenderRenderer;
import coda.oddorganisms.client.renders.render.EolactoriaRenderRenderer;
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
        e.registerEntityRenderer(OOEntities.APTHOROBLATTINA_RENDER.get(), ApthoroblattinaRenderRenderer::new);
        // Animals
        e.registerEntityRenderer(OOEntities.DAWN_HORSE.get(), DawnHorseRenderer::new);
        e.registerEntityRenderer(OOEntities.DOEDICURUS.get(), DoedicurusRenderer::new);
        e.registerEntityRenderer(OOEntities.EOLACTORIA.get(), EolactoriaRenderer::new);
        e.registerEntityRenderer(OOEntities.APTHOROBLATTINA.get(), ApthoroblattinaRenderer::new);

        // Renders
        e.registerEntityRenderer(OOEntities.DAWN_HORSE_RENDER.get(), DawnHorseRenderRenderer::new);
        e.registerEntityRenderer(OOEntities.DOEDICURUS_RENDER.get(), DoedicurusRenderRenderer::new);
        e.registerEntityRenderer(OOEntities.EOLACTORIA_RENDER.get(), EolactoriaRenderRenderer::new);
        e.registerEntityRenderer(OOEntities.APTHOROBLATTINA_RENDER.get(), ApthoroblattinaRenderRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(DawnHorseRenderModel.LAYER_LOCATION, DawnHorseRenderModel::createBodyLayer);
        e.registerLayerDefinition(DoedicurusRenderModel.LAYER_LOCATION, DoedicurusRenderModel::createBodyLayer);
        e.registerLayerDefinition(EolactoriaRenderModel.LAYER_LOCATION, EolactoriaRenderModel::createBodyLayer);
        e.registerLayerDefinition(ApthoroblattinaRenderModel.LAYER_LOCATION, ApthoroblattinaRenderModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerArmorRenders(EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(DoedicurusChestplateItem.class, () -> new ArmorItemRenderer<>(new DoedicurusChestplateModel()));
    }
}
