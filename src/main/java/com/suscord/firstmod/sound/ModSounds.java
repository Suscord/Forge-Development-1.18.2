package com.suscord.firstmod.sound;

import com.suscord.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FirstMod.MOD_ID);

    //Items

    //Blocks
    public static final RegistryObject<SoundEvent> AMETHYUM_BLOCK_BREAK = registerSoundEvent("amethyum_block_break");
    public static final RegistryObject<SoundEvent> AMETHYUM_BLOCK_STEP = registerSoundEvent("amethyum_block_step");
    public static final RegistryObject<SoundEvent> AMETHYUM_BLOCK_PLACE = registerSoundEvent("amethyum_block_place");
    public static final RegistryObject<SoundEvent> AMETHYUM_BLOCK_HIT = registerSoundEvent("amethyum_block_hit");
    public static final RegistryObject<SoundEvent> AMETHYUM_BLOCK_FALL = registerSoundEvent("amethyum_block_fall");
    public static final RegistryObject<SoundEvent> ROUGH_AMETHYUM_BLOCK_BREAK = registerSoundEvent("rough_amethyum_block_break");
    public static final RegistryObject<SoundEvent> ROUGH_AMETHYUM_BLOCK_STEP = registerSoundEvent("rough_amethyum_block_step");
    public static final RegistryObject<SoundEvent> ROUGH_AMETHYUM_BLOCK_PLACE = registerSoundEvent("rough_amethyum_block_place");
    public static final RegistryObject<SoundEvent> ROUGH_AMETHYUM_BLOCK_HIT = registerSoundEvent("rough_amethyum_block_hit");
    public static final RegistryObject<SoundEvent> ROUGH_AMETHYUM_BLOCK_FALL = registerSoundEvent("rough_amethyum_block_fall");



    public static final ForgeSoundType AMETHYUM_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
        ModSounds.AMETHYUM_BLOCK_BREAK, ModSounds.AMETHYUM_BLOCK_STEP, ModSounds.AMETHYUM_BLOCK_PLACE,
    ModSounds.AMETHYUM_BLOCK_HIT, ModSounds.AMETHYUM_BLOCK_FALL);

    public static final ForgeSoundType ROUGH_AMETHYUM_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.ROUGH_AMETHYUM_BLOCK_BREAK, ModSounds.ROUGH_AMETHYUM_BLOCK_STEP, ModSounds.ROUGH_AMETHYUM_BLOCK_PLACE,
            ModSounds.ROUGH_AMETHYUM_BLOCK_HIT, ModSounds.ROUGH_AMETHYUM_BLOCK_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(FirstMod.MOD_ID, name)) );
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
}
