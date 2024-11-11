package coda.oddorganisms.client.geo;

import coda.oddorganisms.common.entities.util.IFish;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class OODefaultedEntityGeoModel<T extends GeoAnimatable> extends DefaultedEntityGeoModel<T> {

    public OODefaultedEntityGeoModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
    }

    @Override
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
        CoreGeoBone root = getAnimationProcessor().getBone("root");

        if (animatable instanceof LivingEntity living && living instanceof IFish && root != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            if (living.isAddedToWorld()) {
                if (!living.isInWater()) {
                    root.setRotZ(1.5708F);
                } else {
                    root.setRotZ(0.0F);
                }
            }
        }
    }


    @Override
    public RenderType getRenderType(T animatable, ResourceLocation texture) {
        return RenderType.entityCutout(texture);
    }
}
