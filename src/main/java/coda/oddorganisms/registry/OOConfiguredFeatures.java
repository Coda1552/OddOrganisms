package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import com.peeko32213.unusualprehistory.UnusualPrehistory;
import com.peeko32213.unusualprehistory.core.registry.UPBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OOConfiguredFeatures {
    public static List<String> configuredFeatureList = new ArrayList<>();
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, OddOrganisms.MOD_ID);

    //public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TERRACOTTA_FOSSIL = registerConfiguredFeature("terracotta_fossil", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new BlockMatchTest(Blocks.TERRACOTTA), OOBlocks.TERRACOTTA_FOSSIL.get().defaultBlockState())), 9));


    public static final RegistryObject<ConfiguredFeature<?, ?>> TERRACOTTA_FOSSIL = registerConfiguredFeature("terracotta_fossil", () -> new ConfiguredFeature<>(
            Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.TERRACOTTA), OOBlocks.TERRACOTTA_FOSSIL.get().defaultBlockState())),
            5, 0.25f)));

    //public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String id, F feature, FC featureConfiguration) {
    //    ResourceLocation resourceLocation = new ResourceLocation(OddOrganisms.MOD_ID, id);
//
    //    if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(resourceLocation))
    //        throw new IllegalStateException("Placed Feature ID: \"" + resourceLocation + "\" already exists in the Placed Features registry!");
//
    //    return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation.toString(), new ConfiguredFeature<>(feature, featureConfiguration));
    //}


    public static RegistryObject<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name, Supplier<ConfiguredFeature<?, ?>> feature) {
        configuredFeatureList.add(name);
        return CONFIGURED_FEATURES.register(name, feature);
    }
}
