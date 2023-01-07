package coda.oddorganisms.common.entities;

import coda.oddorganisms.registry.OOItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Eolactoria extends AbstractFish implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public Eolactoria(EntityType<? extends AbstractFish> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0F).add(Attributes.MOVEMENT_SPEED, 0.25F);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return SoundEvents.COD_HURT;
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return new ItemStack(OOItems.EOLACTORIA_SPAWN_EGG.get());
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 2, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", true));
            event.getController().setAnimationSpeed(2.0D);
        }
        else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
            event.getController().setAnimationSpeed(1.0D);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return null;
    }
}
