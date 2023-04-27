package coda.oddorganisms.common.items;

import coda.oddorganisms.OddOrganisms;
import coda.oddorganisms.registry.OOItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class DoedicurusChestplateItem extends GeoArmorItem implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final OOArmorMaterial MAT = new OOArmorMaterial(OddOrganisms.MOD_ID + ":doedicurus_plate", 25, new int[]{2, 5, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, () -> Ingredient.of(Items.SCUTE)); //todo

    public DoedicurusChestplateItem() {
        super(MAT, EquipmentSlot.CHEST, new Item.Properties().tab(OOItems.GROUP).stacksTo(1).durability(224));
    }

    @Override
    public void registerControllers(AnimationData data) {
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

}
