package com.suscord.firstmod.item;

import com.suscord.firstmod.FirstMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> AMETHYUM = ITEMS.register("amethyum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));

    public static final RegistryObject<Item> ROUGH_AMETHYUM = ITEMS.register("rough_amethyum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));



    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
