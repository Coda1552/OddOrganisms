package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.entities.Apthoroblattina;
import coda.oddorganisms.common.entities.DawnHorse;
import coda.oddorganisms.common.entities.Doedicurus;
import coda.oddorganisms.common.entities.Eolactoria;
import com.peeko32213.unusualprehistory.common.entity.render.BaseEntityRender;
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

    // Renders
    public static final RegistryObject<EntityType<BaseEntityRender>> DAWN_HORSE_RENDER = ENTITIES.register("dawn_horse_render", () -> EntityType.Builder.of(BaseEntityRender::new, MobCategory.MISC).sized(0.7F, 0.7F).build("dawn_horse_render"));
    public static final RegistryObject<EntityType<BaseEntityRender>> DOEDICURUS_RENDER = ENTITIES.register("doedicurus_render", () -> EntityType.Builder.of(BaseEntityRender::new, MobCategory.MISC).sized(0.7F, 0.7F).build("doedicurus_render"));
    public static final RegistryObject<EntityType<BaseEntityRender>> EOLACTORIA_RENDER = ENTITIES.register("eolactoria_render", () -> EntityType.Builder.of(BaseEntityRender::new, MobCategory.MISC).sized(0.7F, 0.7F).build("eolactoria_render"));
    public static final RegistryObject<EntityType<BaseEntityRender>> APTHOROBLATTINA_RENDER = ENTITIES.register("apthoroblattina_render", () -> EntityType.Builder.of(BaseEntityRender::new, MobCategory.MISC).sized(0.7F, 0.7F).build("apthoroblattina_render"));
}
