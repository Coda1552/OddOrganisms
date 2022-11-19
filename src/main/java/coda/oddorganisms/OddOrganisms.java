package coda.oddorganisms;

import coda.oddorganisms.common.entities.DawnHorse;
import coda.oddorganisms.common.entities.Doedicurus;
import coda.oddorganisms.data.EmbryoData;
import coda.oddorganisms.data.EmbryoProvider;
import coda.oddorganisms.registry.OOBlocks;
import coda.oddorganisms.registry.OOEntities;
import coda.oddorganisms.registry.OOItems;
import coda.oddorganisms.registry.OOPlacedFeatures;
import com.peeko32213.unusualprehistory.common.entity.render.BaseEntityRender;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OddOrganisms.MOD_ID)
public class OddOrganisms {
    public static final String MOD_ID = "oddorganisms";

    public OddOrganisms() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        OOEntities.ENTITIES.register(bus);
        OOItems.ITEMS.register(bus);
        OOBlocks.BLOCKS.register(bus);

        forgeBus.addListener(this::entityInteract);
        forgeBus.addListener(this::entityTick);
        forgeBus.addGenericListener(Entity.class, this::attachCapabilitiesAnimal);
        forgeBus.addListener(this::addEntityGoals);
        forgeBus.addListener(this::addOres);

        bus.addListener(this::registerAttributes);
        bus.addListener(this::registerCapabilities);
    }

    private void addOres(BiomeLoadingEvent event) {
        Biome.BiomeCategory category = event.getCategory();
        BiomeGenerationSettingsBuilder builder = event.getGeneration();

        if (category == Biome.BiomeCategory.NETHER || category == Biome.BiomeCategory.THEEND || category == Biome.BiomeCategory.NONE) return;

        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OOPlacedFeatures.TERRACOTTA_FOSSIL);
    }

    private void registerAttributes(EntityAttributeCreationEvent e) {
        e.put(OOEntities.DAWN_HORSE.get(), DawnHorse.createAttributes().build());
        e.put(OOEntities.DAWN_HORSE_RENDER.get(), BaseEntityRender.createAttributes().build());

        e.put(OOEntities.DOEDICURUS.get(), Doedicurus.createAttributes().build());
        e.put(OOEntities.DOEDICURUS_RENDER.get(), BaseEntityRender.createAttributes().build());
    }

    private void entityInteract(PlayerInteractEvent.EntityInteract e) {
        Player player = e.getPlayer();
        ItemStack stack = player.getItemInHand(player.getUsedItemHand());
        int timer = 90;

        // Dawn Horse
        if (e.getTarget() instanceof Horse horse) {
            CompoundTag tag = horse.getPersistentData();

            if (!horse.isBaby() && stack.is(OOItems.DAWN_HORSE_EMBRYO.get()) & !horse.getPersistentData().getBoolean("HasEmbryo")) {

                tag.putBoolean("HasEmbryo", true);
                tag.putString("EmbryoType", "dawn_horse");

                stack.shrink(1);

                horse.getCapability(EmbryoProvider.EMBRYO).ifPresent(embryoProvider -> {
                    embryoProvider.setTimer(timer); // 5 minute timer
                });
            }
        }

        // Doedicurus
        if (e.getTarget() instanceof Cow cow) {
            CompoundTag tag = cow.getPersistentData();

            if (!cow.isBaby() && stack.is(OOItems.DOEDICURUS_EMBRYO.get()) & !cow.getPersistentData().getBoolean("HasEmbryo")) {

                tag.putBoolean("HasEmbryo", true);
                tag.putString("EmbryoType", "doedicurus");

                stack.shrink(1);

                cow.getCapability(EmbryoProvider.EMBRYO).ifPresent(embryoProvider -> {
                    embryoProvider.setTimer(timer); // 5 minute timer
                });
            }
        }
    }

    private void addEntityGoals(EntityJoinWorldEvent e) {
        if (e.getEntity() instanceof Wolf wolf) {
            wolf.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(wolf, DawnHorse.class, true));
        }
        if (e.getEntity() instanceof AbstractHorse horse && horse.getPersistentData().get("HasEmbryo") == null) {
            horse.getPersistentData().putBoolean("HasEmbryo", false);
        }
        if (e.getEntity() instanceof Cow cow && cow.getPersistentData().get("HasEmbryo") == null) {
            cow.getPersistentData().putBoolean("HasEmbryo", false);
        }
    }

    private void entityTick(LivingEvent.LivingUpdateEvent e) {
        LivingEntity entity = e.getEntityLiving();
        var cap = entity.getCapability(EmbryoProvider.EMBRYO);

        CompoundTag tag = entity.getPersistentData();

        if (cap.isPresent() && tag.getBoolean("HasEmbryo")) {

            cap.ifPresent(embryoData -> {
                int i = embryoData.getTimer();

                if (i > 0) {
                    embryoData.setTimer(i - 1);
                }

                else if (i == 0) {
                    Level level = entity.level;

                    tag.putBoolean("HasEmbryo", false);

                    String name = tag.getString("EmbryoType");

                    switch (name) {
                        case "dawn_horse" :
                            DawnHorse dawnHorse = OOEntities.DAWN_HORSE.get().create(level);

                            dawnHorse.moveTo(entity.position());
                            dawnHorse.setAge(-24000);

                            embryoData.setTimer(300 * 20);
                            level.addFreshEntity(dawnHorse);
                            break;
                        case "doedicurus" :
                            Doedicurus doedicurus = OOEntities.DOEDICURUS.get().create(level);

                            doedicurus.moveTo(entity.position());
                            doedicurus.setAge(-24000);

                            embryoData.setTimer(300 * 20);
                            level.addFreshEntity(doedicurus);
                            break;
                    }

                    if (level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
                        level.addFreshEntity(new ExperienceOrb(level, entity.getX(), entity.getY(), entity.getZ(), level.getRandom().nextInt(7) + 1));
                    }
                }
            });
        }
    }


    private void attachCapabilitiesAnimal(AttachCapabilitiesEvent<Entity> e) {
        if (e.getObject() instanceof AbstractHorse horse && !horse.isBaby()) {
            if (!e.getObject().getCapability(EmbryoProvider.EMBRYO).isPresent()) {
                e.addCapability(new ResourceLocation(OddOrganisms.MOD_ID, "embryo"), new EmbryoProvider());
            }
        }
        if (e.getObject() instanceof Cow cow && !cow.isBaby()) {
            if (!e.getObject().getCapability(EmbryoProvider.EMBRYO).isPresent()) {
                e.addCapability(new ResourceLocation(OddOrganisms.MOD_ID, "embryo"), new EmbryoProvider());
            }
        }
    }

    private void registerCapabilities(RegisterCapabilitiesEvent e) {
        e.register(EmbryoData.class);
    }

}
