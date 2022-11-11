package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import com.peeko32213.unusualprehistory.UnusualPrehistory;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OOItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OddOrganisms.MOD_ID);

    public static final RegistryObject<Item> DAWN_HORSE_SPAWN_EGG = ITEMS.register("dawn_horse_spawn_egg", () -> new ForgeSpawnEggItem(OOEntities.DAWN_HORSE, 0xb89268, 0xffe5b1, new Item.Properties().tab(UnusualPrehistory.DINO_TAB)));
    public static final RegistryObject<Item> DAWN_HORSE_FLASK = ITEMS.register("dawn_horse_flask", () -> new Item(new Item.Properties().tab(UnusualPrehistory.DINO_TAB)));
}
