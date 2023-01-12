package coda.oddorganisms.common.items;

import coda.oddorganisms.common.entities.Apthoroblattina;
import com.mojang.math.Vector3f;
import net.minecraft.Util;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class PheromonalSprayItem extends Item {

    public PheromonalSprayItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int duration) {
        Vec3 lookAngle = entity.getViewVector(1.0F);
        List<LivingEntity> list = level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), entity, entity.getBoundingBox().inflate(2.0F));
        List<Apthoroblattina> roachList = level.getNearbyEntities(Apthoroblattina.class, TargetingConditions.forCombat(), entity, entity.getBoundingBox().inflate(10.0F));

        for (LivingEntity potentialTarget : list) {
            if (lookAngle.closerThan(potentialTarget.position(), 4.0D)) {
                for (Apthoroblattina roach : roachList) {
                    roach.setTarget(potentialTarget);
                    System.out.println("target set");
                }
            }
        }

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()) {
            createParticles(player, hand);
        }

        return super.use(level, player, hand);
    }

    private void createParticles(Player player, InteractionHand hand) {
        Vec3[] COLORS2 = Util.make(new Vec3[16], (p_154319_) -> {
            for(int i = 0; i <= 15; ++i) {
                float f = (float)i / 10.0F;
                float f1 = f * 0.3F + (f > 0.0F ? 0.55F : 0.4F);
                float f2 = Mth.clamp(f * 0.7F - 0.5F, 0.75F, 1.0F);
                float f3 = Mth.clamp(f * 0.6F - 0.05F, 0.1F, 0.75F);
                p_154319_[i] = new Vec3(f1, f2, f3);
            }

        });

        for (int i = 0; i < 3; i++) {
            Vec3 pos = new Vec3(hand == InteractionHand.OFF_HAND ? 0.3 : -0.3, 0.95, 0.2).yRot(-player.yBodyRot * ((float) Math.PI / 180f)).add(player.getX(), player.getY(), player.getZ());
            player.level.addAlwaysVisibleParticle(new DustParticleOptions(new Vector3f(COLORS2[i]), 1.0F), pos.x(), pos.y(),  pos.z(), 0, -0.05, 0);
        }
    }

    @Override
    public int getUseDuration(ItemStack p_41454_) {
        return 20;
    }
}
