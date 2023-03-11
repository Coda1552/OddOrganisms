package coda.oddorganisms.common.blocks;

import coda.oddorganisms.common.entities.Eolactoria;
import coda.oddorganisms.registry.OOEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EolactoriaEggsBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.5, 16.0);

    public EolactoriaEggsBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return mayPlaceOn(reader, pos.below());
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean notify) {
        level.scheduleTick(pos, this, hatchTime(level.getRandom()));
    }

    private static int hatchTime(RandomSource random) {
        return random.nextInt(3600, 12000);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor access, BlockPos pos, BlockPos neighborPos) {
        return !this.canSurvive(state, access, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, access, pos, neighborPos);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!this.canSurvive(state, level, pos)) {
            this.hatch(level, pos);
        } else {
            this.onHatch(level, pos, random);
        }

    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity.getType().equals(EntityType.FALLING_BLOCK)) {
            this.hatch(level, pos);
        }

    }

    private static boolean mayPlaceOn(LevelReader reader, BlockPos pos) {
        FluidState fluidState = reader.getFluidState(pos);
        FluidState topFluidState = reader.getFluidState(pos.above());
        return fluidState.getType() == Fluids.WATER && topFluidState.getType() == Fluids.EMPTY;
    }

    private void onHatch(ServerLevel level, BlockPos pos, RandomSource random) {
        this.hatch(level, pos);
        level.playSound(null, pos, SoundEvents.TURTLE_EGG_HATCH, SoundSource.BLOCKS, 1.0F, 1.0F);
        this.createTadpole(level, pos, random);
    }

    private void hatch(Level level, BlockPos blockPos) {
        level.destroyBlock(blockPos, false);
    }

    private void createTadpole(ServerLevel level, BlockPos pos, RandomSource random) {
        int i = random.nextInt(1, 2);

        for(int index = 1; index <= i; ++index) {
            Eolactoria tadpole = OOEntities.EOLACTORIA.get().create(level);
            if (tadpole != null) {
                double x = (double)pos.getX() + this.getSpawnOffset(random);
                double z = (double)pos.getZ() + this.getSpawnOffset(random);
                int yaw = random.nextInt(1, 361);
                tadpole.moveTo(x, (double)pos.getY() - 0.5, z, (float)yaw, 0.0F);
                tadpole.setPersistenceRequired();
                level.addFreshEntity(tadpole);
            }
        }

    }

    private double getSpawnOffset(RandomSource random) {
        return Mth.clamp(random.nextDouble(), 0.2D, 0.8D);
    }
}
