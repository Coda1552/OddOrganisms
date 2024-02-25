package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import com.peeko32213.unusualprehistory.common.block.BlockDinosaurWaterEggs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OOBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OddOrganisms.MOD_ID);

    public static final RegistryObject<Block> EOLACTORIA_EGGS = BLOCKS.register("eolactoria_eggs", () -> new BlockDinosaurWaterEggs(BlockBehaviour.Properties.of().instabreak().noOcclusion().noCollission(), OOEntities.EOLACTORIA, false));
    public static final RegistryObject<Block> FALCATUS_EGGS = BLOCKS.register("falcatus_eggs", () -> new BlockDinosaurWaterEggs(BlockBehaviour.Properties.of().instabreak().noOcclusion().noCollission(), OOEntities.FALCATUS, false));
    public static final RegistryObject<Block> SLOVENICUS_EGGS = BLOCKS.register("slovenicus_eggs", () -> new BlockDinosaurWaterEggs(BlockBehaviour.Properties.of().instabreak().noOcclusion().noCollission(), OOEntities.SLOVENICUS, false));
}
