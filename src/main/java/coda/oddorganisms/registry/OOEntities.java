package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OOEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OddOrganisms.MOD_ID);

    // Animals
    public static final RegistryObject<EntityType<DawnHorse>> DAWN_HORSE = ENTITIES.register("dawn_horse", () -> EntityType.Builder.of(DawnHorse::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("dawn_horse"));
    public static final RegistryObject<EntityType<Doedicurus>> DOEDICURUS = ENTITIES.register("doedicurus", () -> EntityType.Builder.of(Doedicurus::new, MobCategory.CREATURE).sized(1.75F, 1.75F).build("doedicurus"));
    public static final RegistryObject<EntityType<Eolactoria>> EOLACTORIA = ENTITIES.register("eolactoria", () -> EntityType.Builder.of(Eolactoria::new, MobCategory.WATER_CREATURE).sized(0.5F, 0.35F).build("eolactoria"));
    public static final RegistryObject<EntityType<Apthoroblattina>> APTHOROBLATTINA = ENTITIES.register("apthoroblattina", () -> EntityType.Builder.of(Apthoroblattina::new, MobCategory.CREATURE).sized(0.95F, 0.35F).build("apthoroblattina"));
    public static final RegistryObject<EntityType<Leptictidium>> LEPTICTIDIUM = ENTITIES.register("leptictidium", () -> EntityType.Builder.of(Leptictidium::new, MobCategory.CREATURE).sized(0.5F, 0.4F).build("leptictidium"));
    public static final RegistryObject<EntityType<Borealopelta>> BOREALOPELTA = ENTITIES.register("borealopelta", () -> EntityType.Builder.of(Borealopelta::new, MobCategory.CREATURE).sized(1.8F, 1.7F).build("borealopelta"));

}
