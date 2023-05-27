package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OOConfiguredFeatures {
    public static List<String> configuredFeatureList = new ArrayList<>();
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, OddOrganisms.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> TERRACOTTA_FOSSIL = registerConfiguredFeature("terracotta_fossil", () -> new ConfiguredFeature<>(
            Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.TERRACOTTA), OOBlocks.TERRACOTTA_FOSSIL.get().defaultBlockState())),
            5, 0.25f)));

    public static RegistryObject<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name, Supplier<ConfiguredFeature<?, ?>> feature) {
        configuredFeatureList.add(name);
        return CONFIGURED_FEATURES.register(name, feature);
    }
}
