package com.suscord.firstmod.item.custom;

import com.suscord.firstmod.sound.ModSounds;
import com.suscord.firstmod.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class AmethyumResonatorItem extends Item {
    public AmethyumResonatorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    //Returns target Block
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {   //execute code on Client
            BlockPos clickedPosition = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean blockFound = false;

            for (int i = 0; i <= clickedPosition.getY() + 64; i++) {    //Increase i to 0 from Y Coordinate of Position Clicked + 64
                Block blockUnderneath = pContext.getLevel().getBlockState(clickedPosition.below(i)).getBlock();     //Get Block from below i block from Position Clicked

                if(isAmethyum(blockUnderneath)) {
                    player.playSound(ModSounds.AMETHYUM_BLOCK_SOUNDS.getBreakSound(), 1f,.1f);
                    writeAmethyumCoord(clickedPosition.below(i), player, blockUnderneath);
                    blockFound = true;
                    break;
                }
            }

            if (!blockFound) {      //if Amethyum block is not Found
                player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT,1f,.5f);
                player.sendMessage(new TranslatableComponent("item.firstmod.amethyum_resonator.not_found"),
                        player.getUUID());      //send Translatable Message to Player
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void writeAmethyumCoord (BlockPos blockPosition, Player player, Block blockUnderneath) {
        player.sendMessage(new TextComponent
                        ("!!! " + blockUnderneath.asItem().getRegistryName().toString() + " -> " + blockPosition.getY()),
                player.getUUID());
    }

    private boolean isAmethyum(Block block) {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(ModTags.Blocks.AMETHYUM);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.firstmod.amethyum_resonator.tooltip.advanced"));
        }
        else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.firstmod.amethyum_resonator.tooltip"));
        }
    }

}
