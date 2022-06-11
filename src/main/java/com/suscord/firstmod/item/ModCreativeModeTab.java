package com.suscord.firstmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab AMETHYUM_TAB = new CreativeModeTab("amethyumtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AMETHYUM.get());
        }
    };
}
