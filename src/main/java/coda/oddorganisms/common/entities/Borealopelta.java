package coda.oddorganisms.common.entities;

import coda.oddorganisms.common.entities.util.OOAnimations;
import coda.oddorganisms.registry.OOEntities;
import coda.oddorganisms.registry.OOItems;
import com.peeko32213.unusualprehistory.common.entity.msc.util.dino.EntityBaseDinosaurAnimal;
import com.peeko32213.unusualprehistory.core.registry.UPSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class Borealopelta extends EntityBaseDinosaurAnimal implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Borealopelta(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.0F));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.of(ItemTags.LEAVES), false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 45.0).add(Attributes.ARMOR, 20.0).add(Attributes.MOVEMENT_SPEED, 0.12).add(Attributes.ATTACK_DAMAGE, 10.0).add(Attributes.KNOCKBACK_RESISTANCE, 25.0);
    }

    @Override
    protected int getKillHealAmount() {
        return 0;
    }

    @Override
    protected boolean canGetHungry() {
        return false;
    }

    @Override
    protected boolean hasTargets() {
        return false;
    }

    @Override
    protected boolean hasAvoidEntity() {
        return false;
    }

    @Override
    protected boolean hasCustomNavigation() {
        return false;
    }

    @Override
    protected boolean hasMakeStuckInBlock() {
        return false;
    }

    @Override
    protected boolean customMakeStuckInBlockCheck(BlockState blockState) {
        return false;
    }

    @Override
    protected TagKey<EntityType<?>> getTargetTag() {
        return null;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return OOEntities.LEPTICTIDIUM.get().create(level);
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return UPSounds.ANTARCTO_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return UPSounds.ANTARCTO_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return UPSounds.ANTARCTO_IDLE.get();
    }

    @Override
    protected SoundEvent getAttackSound() {
        return null;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 2, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        boolean walking = !(event.getLimbSwingAmount() > -0.01F && event.getLimbSwingAmount() < 0.01F);
        if (isFromBook()) {
            return PlayState.STOP;
        }
        else if (walking) {
            event.getController().setAnimation(OOAnimations.WALK);
        }
        else {
            event.getController().setAnimation(OOAnimations.IDLE);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return new ItemStack(OOItems.BOREALOPELTA_SPAWN_EGG.get());
    }
}
