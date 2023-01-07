package coda.oddorganisms.client;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.client.models.DoedicurusChestplateModel;
import coda.oddorganisms.client.models.render.DawnHorseRenderModel;
import coda.oddorganisms.client.models.render.DoedicurusRenderModel;
import coda.oddorganisms.client.models.render.EolactoriaRenderModel;
import coda.oddorganisms.client.renders.DawnHorseRenderer;
import coda.oddorganisms.client.renders.DoedicurusRenderer;
import coda.oddorganisms.client.renders.EolactoriaRenderer;
import coda.oddorganisms.client.renders.render.EolactoriaRenderRenderer;
import coda.oddorganisms.client.renders.armor.ArmorItemRenderer;
import coda.oddorganisms.client.renders.render.DawnHorseRenderRenderer;
import coda.oddorganisms.client.renders.render.DoedicurusRenderRenderer;
import coda.oddorganisms.common.items.DoedicurusChestplateItem;
import coda.oddorganisms.registry.OOBlocks;
import coda.oddorganisms.registry.OOEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
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
        // Animals
        EntityRenderers.register(OOEntities.DAWN_HORSE.get(), DawnHorseRenderer::new);
        EntityRenderers.register(OOEntities.DOEDICURUS.get(), DoedicurusRenderer::new);
        EntityRenderers.register(OOEntities.EOLACTORIA.get(), EolactoriaRenderer::new);

        // Renders
        EntityRenderers.register(OOEntities.DAWN_HORSE_RENDER.get(), DawnHorseRenderRenderer::new);
        EntityRenderers.register(OOEntities.DOEDICURUS_RENDER.get(), DoedicurusRenderRenderer::new);
        EntityRenderers.register(OOEntities.EOLACTORIA_RENDER.get(), EolactoriaRenderRenderer::new);

        ItemBlockRenderTypes.setRenderLayer(OOBlocks.EOLACTORIA_EGGS.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(DawnHorseRenderModel.LAYER_LOCATION, DawnHorseRenderModel::createBodyLayer);
        e.registerLayerDefinition(DoedicurusRenderModel.LAYER_LOCATION, DoedicurusRenderModel::createBodyLayer);
        e.registerLayerDefinition(EolactoriaRenderModel.LAYER_LOCATION, EolactoriaRenderModel::createBodyLayer);
    }


    @SubscribeEvent
    public static void registerArmorRenders(EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(DoedicurusChestplateItem.class, () -> new ArmorItemRenderer<>(new DoedicurusChestplateModel()));
    }
}
