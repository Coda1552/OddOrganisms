package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import com.peeko32213.unusualprehistory.UnusualPrehistory;
import com.peeko32213.unusualprehistory.core.registry.UPConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OOPlacedFeatures {
    public static List<String> placedFeatureList = new ArrayList<>();

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, OddOrganisms.MOD_ID);

   //public static final Holder<PlacedFeature> TERRACOTTA_FOSSIL = registerPlacedFeature("terracotta_fossil", OOConfiguredFeatures.TERRACOTTA_FOSSIL, commonOrePlacement(100,
   //        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(128))));



    public static final RegistryObject<PlacedFeature> TERRACOTTA_FOSSIL = registerPlacedFeature("terracotta_fossil", () -> new PlacedFeature( OOConfiguredFeatures.TERRACOTTA_FOSSIL.getHolder().orElseThrow(),
            commonOrePlacement(90,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(384)))));

   //public static <FC extends FeatureConfiguration> Holder<PlacedFeature> registerPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
   //    ResourceLocation resourceLocation = new ResourceLocation(UnusualPrehistory.MODID, id);
   //    if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(resourceLocation))
   //        throw new IllegalStateException("Placed Feature ID: \"" + resourceLocation + "\" already exists in the Placed Features registry!");

   //    PlacedFeature placedFeature = new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers));

   //    return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, resourceLocation, placedFeature);
   //}

    private static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier2) {
        return List.of(modifier, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(count), modifier);
    }
    private static RegistryObject<PlacedFeature> registerPlacedFeature(String name, Supplier<PlacedFeature> feature) {
        placedFeatureList.add(name);
        return PLACED_FEATURES.register(name, feature);
    }
}