package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.common.items.DoedicurusChestplateItem;
import coda.oddorganisms.common.items.OothecaItem;
import com.peeko32213.unusualprehistory.common.item.AnimalAttacherItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OOItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OddOrganisms.MOD_ID);
    public static final CreativeModeTab GROUP = new CreativeModeTab(OddOrganisms.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DOEDICURUS_SCUTE.get());
        }
    };

    public static final RegistryObject<Item> DOEDICURUS_CHESTPLATE = ITEMS.register("doedicurus_chestplate", DoedicurusChestplateItem::new);
    public static final RegistryObject<Item> DOEDICURUS_SCUTE = ITEMS.register("doedicurus_scute", () -> new Item(new Item.Properties().tab(GROUP)));
    //public static final RegistryObject<Item> PHEROMONAL_SPRAY = ITEMS.register("pheromonal_spray", () -> new PheromonalSprayItem(new Item.Properties().tab(GROUP).stacksTo(1).durability(24)));

    public static final RegistryObject<Item> DAWN_HORSE_FLASK = ITEMS.register("dawn_horse_flask", () -> new Item(new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> DOEDICURUS_FLASK = ITEMS.register("doedicurus_flask", () -> new Item(new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> EOLACTORIA_FLASK = ITEMS.register("eolactoria_flask", () -> new Item(new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> APTHOROBLATTINA_FLASK = ITEMS.register("apthoroblattina_flask", () -> new Item(new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> LEPTICTIDIUM_FLASK = ITEMS.register("leptictidium_flask", () -> new Item(new Item.Properties().tab(GROUP)));
    //public static final RegistryObject<Item> BOREALOPELTA_FLASK = ITEMS.register("borealopelta_flask", () -> new Item(new Item.Properties().tab(GROUP)));

    public static final RegistryObject<Item> DAWN_HORSE_EMBRYO = ITEMS.register("dawn_horse_embryo", () -> new AnimalAttacherItem(new Item.Properties().tab(GROUP).stacksTo(16), OOTags.DAWN_HORSE_EMBRYO_ATTACH_TO, OOEntities.DAWN_HORSE, 1000));
    public static final RegistryObject<Item> DOEDICURUS_EMBRYO = ITEMS.register("doedicurus_embryo", () -> new AnimalAttacherItem(new Item.Properties().tab(GROUP).stacksTo(16), OOTags.DOEDICURUS_EMBRYO_ATTACH_TO, OOEntities.DOEDICURUS, 1000));
    public static final RegistryObject<Item> LEPTICTIDIUM_EMBRYO = ITEMS.register("leptictidium_embryo", () -> new AnimalAttacherItem(new Item.Properties().tab(GROUP).stacksTo(16), OOTags.LEPTICTIDIUM_EMBRYO_ATTACH_TO, OOEntities.LEPTICTIDIUM, 1000));
    public static final RegistryObject<Item> EOLACTORIA_EGGS = ITEMS.register("eolactoria_eggs", () -> new PlaceOnWaterBlockItem(OOBlocks.EOLACTORIA_EGGS.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> APTHOROBLATTINA_OOTHECA = ITEMS.register("apthoroblattina_ootheca", () -> new OothecaItem(new Item.Properties().tab(GROUP)));

    public static final RegistryObject<Item> DAWN_HORSE_SPAWN_EGG = ITEMS.register("dawn_horse_spawn_egg", () -> new ForgeSpawnEggItem(OOEntities.DAWN_HORSE, 0xb89268, 0xffe5b1, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> DOEDICURUS_SPAWN_EGG = ITEMS.register("doedicurus_spawn_egg", () -> new ForgeSpawnEggItem(OOEntities.DOEDICURUS, 0x694628, 0x926f40, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> EOLACTORIA_SPAWN_EGG = ITEMS.register("eolactoria_spawn_egg", () -> new ForgeSpawnEggItem(OOEntities.EOLACTORIA, 0x8e5c3c, 0xeda655, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> APTHOROBLATTINA_SPAWN_EGG = ITEMS.register("apthoroblattina_spawn_egg", () -> new ForgeSpawnEggItem(OOEntities.APTHOROBLATTINA, 0x201e24, 0x453638, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> LEPTICTIDIUM_SPAWN_EGG = ITEMS.register("leptictidium_spawn_egg", () -> new ForgeSpawnEggItem(OOEntities.LEPTICTIDIUM, 0xc09251, 0xe28554, new Item.Properties().tab(GROUP)));
    //public static final RegistryObject<Item> BOREALOPELTA_SPAWN_EGG = ITEMS.register("borealopelta_spawn_egg", () -> new ForgeSpawnEggItem(OOEntities.BOREALOPELTA, 0x583f30, 0x73c8c4, new Item.Properties().tab(GROUP)));

    public static final RegistryObject<Item> EOLACTORIA_BUCKET = ITEMS.register("eolactoria_bucket", () -> new MobBucketItem(OOEntities.EOLACTORIA, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(GROUP)));
}
