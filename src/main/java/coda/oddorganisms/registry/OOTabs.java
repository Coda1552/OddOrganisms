package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class OOTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OddOrganisms.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OO_TAB = TABS.register("oo_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + OddOrganisms.MOD_ID))
                    .icon(OOItems.DOEDICURUS_SCUTE.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> {
                        for (var item : OOItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                    })
                    .build()
    );
}
