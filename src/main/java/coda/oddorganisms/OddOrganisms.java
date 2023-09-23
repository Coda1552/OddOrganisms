package coda.oddorganisms;

import coda.oddorganisms.common.entities.*;
import coda.oddorganisms.registry.OOBlocks;
import coda.oddorganisms.registry.OOEntities;
import coda.oddorganisms.registry.OOItems;
import coda.oddorganisms.registry.OOSounds;
import com.peeko32213.unusualprehistory.common.config.UnusualPrehistoryConfig;
import com.peeko32213.unusualprehistory.core.registry.UPTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OddOrganisms.MOD_ID)
public class OddOrganisms {
    public static final String MOD_ID = "oddorganisms";

    // todo - add incubator recipes, redo embryo items
    public OddOrganisms() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        OOEntities.ENTITIES.register(bus);
        OOItems.ITEMS.register(bus);
        OOBlocks.BLOCKS.register(bus);
        OOSounds.SOUNDS.register(bus);

        forgeBus.addListener(this::addEntityGoals);
        forgeBus.addListener(this::livingDamage);
        forgeBus.addListener(this::playerAttack);

        bus.addListener(this::registerAttributes);
        bus.addListener(this::registerSpawnPlacements);
    }

    private void registerSpawnPlacements(final SpawnPlacementRegisterEvent event) {
        event.register(OOEntities.LEPTICTIDIUM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this::canLandAnimalSpawn, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(OOEntities.DOEDICURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this::canLandAnimalSpawn, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(OOEntities.DAWN_HORSE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this::canLandAnimalSpawn, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(OOEntities.EOLACTORIA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this::canFishAnimalSpawn, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(OOEntities.APTHOROBLATTINA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this::canLandAnimalSpawn, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(OOEntities.BOREALOPELTA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this::canLandAnimalSpawn, SpawnPlacementRegisterEvent.Operation.AND);
    }

    private boolean canLandAnimalSpawn(EntityType<? extends Animal> p_186238_, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
        return level.getBlockState(pos.below()).is(UPTags.DINO_NATURAL_SPAWNABLE) && UnusualPrehistoryConfig.DINO_NATURAL_SPAWNING.get();
    }

    private boolean canFishAnimalSpawn(EntityType<? extends AbstractFish> p_186238_, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
        return level.getFluidState(pos.below()).is(FluidTags.WATER) && level.getBlockState(pos.above()).is(Blocks.WATER) && UnusualPrehistoryConfig.DINO_NATURAL_SPAWNING.get();
    }

    private void livingDamage(LivingDamageEvent e) {
        if (e.getEntity() instanceof Player player && player.getItemBySlot(EquipmentSlot.CHEST).is(OOItems.DOEDICURUS_CHESTPLATE.get()) && player.isShiftKeyDown() && isValidSource(e.getSource())) {
            ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);

            chestplate.hurtAndBreak((int) e.getAmount(), player, p -> p.broadcastBreakEvent(EquipmentSlot.CHEST));

            e.setCanceled(true);
        }
        else if (e.getSource().getEntity() instanceof Doedicurus doedicurus && e.getEntity() instanceof Player player && player.isBlocking()) {
            if (player.getItemBySlot(EquipmentSlot.CHEST).is(OOItems.DOEDICURUS_CHESTPLATE.get()) && player.isShiftKeyDown()) return;

            ItemEntity item = EntityType.ITEM.create(doedicurus.level);

            item.moveTo(doedicurus.position());
            item.setItem(new ItemStack(OOItems.DOEDICURUS_SCUTE.get(), doedicurus.getRandom().nextInt(2)));

            doedicurus.level.addFreshEntity(item);
        }
    }

    private boolean isValidSource(DamageSource source) {
        return !source.isFire() && !source.isMagic() && !source.isFall();
    }

    private void playerAttack(AttackEntityEvent e) {
        Player player = e.getEntity();
        if (player.getItemBySlot(EquipmentSlot.CHEST).is(OOItems.DOEDICURUS_CHESTPLATE.get()) && player.isShiftKeyDown()) {
            player.playSound(SoundEvents.SHIELD_BLOCK, 1.0F, 1.0F);
            e.setCanceled(true);
        }
    }

    private void registerAttributes(EntityAttributeCreationEvent e) {
        e.put(OOEntities.DAWN_HORSE.get(), DawnHorse.createAttributes().build());
        e.put(OOEntities.DOEDICURUS.get(), Doedicurus.createAttributes().build());
        e.put(OOEntities.EOLACTORIA.get(), Eolactoria.createAttributes().build());
        e.put(OOEntities.APTHOROBLATTINA.get(), Apthoroblattina.createAttributes().build());
        e.put(OOEntities.LEPTICTIDIUM.get(), Leptictidium.createAttributes().build());
        e.put(OOEntities.BOREALOPELTA.get(), Borealopelta.createAttributes().build());
    }

    private void addEntityGoals(EntityJoinLevelEvent e) {
        if (e.getEntity() instanceof Wolf wolf) {
            wolf.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(wolf, DawnHorse.class, true));
        }
    }
}
