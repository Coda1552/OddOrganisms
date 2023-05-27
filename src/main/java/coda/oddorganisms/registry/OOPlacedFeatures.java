package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OOPlacedFeatures {
    public static List<String> placedFeatureList = new ArrayList<>();

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, OddOrganisms.MOD_ID);

    public static final RegistryObject<PlacedFeature> TERRACOTTA_FOSSIL = registerPlacedFeature("terracotta_fossil", () -> new PlacedFeature( OOConfiguredFeatures.TERRACOTTA_FOSSIL.getHolder().orElseThrow(),
            commonOrePlacement(90,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(384)))));

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