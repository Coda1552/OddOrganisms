package coda.oddorganisms.registry;

import coda.oddorganisms.OddOrganisms;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OOSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, OddOrganisms.MOD_ID);

    public static final RegistryObject<SoundEvent> DOEDICURUS_AMBIENT = register("doedicurus.ambient");
    public static final RegistryObject<SoundEvent> DOEDICURUS_HURT = register("doedicurus.hurt");
    public static final RegistryObject<SoundEvent> DOEDICURUS_DEATH = register("doedicurus.death");

    public static final RegistryObject<SoundEvent> LEPTICTIDIUM_AMBIENT = register("leptictidium.ambient");
    public static final RegistryObject<SoundEvent> LEPTICTIDIUM_HURT = register("leptictidium.hurt");
    public static final RegistryObject<SoundEvent> LEPTICTIDIUM_DEATH = register("leptictidium.death");
    public static final RegistryObject<SoundEvent> LEPTICTIDIUM_SCARED = register("leptictidium.scared");

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(OddOrganisms.MOD_ID, name)));
    }
}
