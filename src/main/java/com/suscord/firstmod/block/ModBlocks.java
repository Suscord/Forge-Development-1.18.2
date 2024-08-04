package com.suscord.firstmod.block;

import com.suscord.firstmod.FirstMod;
import com.suscord.firstmod.item.ModCreativeModeTab;
import com.suscord.firstmod.item.ModItems;
import com.suscord.firstmod.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
    DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> AMETHYUM_BLOCK = registerBlock("amethyum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(10f, 7f).requiresCorrectToolForDrops()
                    .sound(ModSounds.AMETHYUM_BLOCK_SOUNDS)),
            ModCreativeModeTab.AMETHYUM_TAB);

    public static final RegistryObject<Block> ROUGH_AMETHYUM_BLOCK = registerBlock("rough_amethyum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(8f, 7f).requiresCorrectToolForDrops()
                    .sound(ModSounds.ROUGH_AMETHYUM_BLOCK_SOUNDS)),
            ModCreativeModeTab.AMETHYUM_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return  toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}