package com.suscord.firstmod.item;

import com.suscord.firstmod.FirstMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    //Tools
    public static final RegistryObject<Item> AMETHYUM_FINDER = ITEMS.register("amethyum_resonator",
            () -> new AmethyumResonator(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB).durability(9)));

    //Items
    public static final RegistryObject<Item> AMETHYUM = ITEMS.register("amethyum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> ROUGH_AMETHYUM = ITEMS.register("rough_amethyum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> COMPRESSED_AMETHYST = ITEMS.register("compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> DOUBLE_COMPRESSED_AMETHYST = ITEMS.register("double_compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> TRIPLE_COMPRESSED_AMETHYST = ITEMS.register("triple_compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> QUADRUPLE_COMPRESSED_AMETHYST = ITEMS.register("quadruple_compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> QUINTUPLE_COMPRESSED_AMETHYST = ITEMS.register("quintuple_compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> SEXTUPLE_COMPRESSED_AMETHYST = ITEMS.register("sextuple_compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> SEPTUPLE_COMPRESSED_AMETHYST = ITEMS.register("septuple_compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));
    public static final RegistryObject<Item> OCTUPLE_COMPRESSED_AMETHYST = ITEMS.register("octuple_compressed_amethyst",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB)));

    //Food
    public static final RegistryObject<Item> BLACK_MANGO_MELON_SLICE = ITEMS.register("black_mango_melon_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.AMETHYUM_TAB).food(ModFoods.BLACK_MANGO_MELON_SLICE)));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
