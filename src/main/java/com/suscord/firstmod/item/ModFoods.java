package com.suscord.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BLACK_MANGO_MELON_SLICE;

    public ModFoods() {}

    static {
        BLACK_MANGO_MELON_SLICE = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 2), 1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 100, 2), 0.3F).build();
    }

}

