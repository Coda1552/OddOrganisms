package coda.oddorganisms.common.items;

import coda.oddorganisms.common.entities.Apthoroblattina;
import coda.oddorganisms.registry.OOEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class OothecaItem extends Item {

    public OothecaItem(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResult useOn(UseOnContext p_43223_) {
        Level level = p_43223_.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemstack = p_43223_.getItemInHand();
            BlockPos blockpos = p_43223_.getClickedPos();
            Direction direction = p_43223_.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }

            Apthoroblattina roach = OOEntities.APTHOROBLATTINA.get().create(level);
            itemstack.shrink(1);

            roach.setAge(-24000);
            roach.moveTo(blockpos1, 0.0F, 0.0F);

            level.addFreshEntity(roach);

            roach.playSound(SoundEvents.TURTLE_EGG_CRACK, 1.0F, 1.0F);

            return InteractionResult.CONSUME;
        }
    }
}
