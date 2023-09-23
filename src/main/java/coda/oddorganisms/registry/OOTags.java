package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class OOTags {
    public static final TagKey<EntityType<?>> DOEDICURUS_EMBRYO_ATTACH_TO = registerEntityTag("doedicurus_embryo_attach_to");
    public static final TagKey<EntityType<?>> LEPTICTIDIUM_EMBRYO_ATTACH_TO = registerEntityTag("leptictidium_embryo_attach_to");
    public static final TagKey<EntityType<?>> DAWN_HORSE_EMBRYO_ATTACH_TO = registerEntityTag("dawn_horse_embryo_attach_to");

    private static TagKey<EntityType<?>> registerEntityTag(String name) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(OddOrganisms.MOD_ID, name));
    }
}
