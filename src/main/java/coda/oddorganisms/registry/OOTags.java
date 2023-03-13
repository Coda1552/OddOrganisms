package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class OOTags {

    public static final TagKey<EntityType<?>> EMBRYO_COMPATIBLE = createEntity("embryo_compatible");
    public static final TagKey<Item> EMBRYO = createItem("embryo");

    private static TagKey<EntityType<?>> createEntity(String name) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(OddOrganisms.MOD_ID, name));
    }

    private static TagKey<Item> createItem(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(OddOrganisms.MOD_ID, name));
    }
}
