package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.blocks.EolactoriaEggsBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OOBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OddOrganisms.MOD_ID);

    public static final RegistryObject<Block> TERRACOTTA_FOSSIL = BLOCKS.register("terracotta_fossil", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> EOLACTORIA_EGGS = BLOCKS.register("eolactoria_eggs", () -> new EolactoriaEggsBlock(BlockBehaviour.Properties.of(Material.BUILDABLE_GLASS).instabreak().noOcclusion().noCollission()));
}
