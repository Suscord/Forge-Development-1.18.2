package com.suscord.firstmod.item.custom;

import com.suscord.firstmod.FirstMod;
import com.suscord.firstmod.block.ModBlocks;
import com.suscord.firstmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class AmethyumResonator extends Item {
    public AmethyumResonator (Properties pProperties) {
        super(pProperties);
    }

    @Override
    //Returns target Block
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {   //execute code on Client 코드를 클라이언트에서 실행하기
            BlockPos clickedPosition = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            Boolean blockFound = false;

            for (int i = 0; i <= clickedPosition.getY() + 64; i++) {    //Increase i to 0 from Y Coordinate of Position Clicked + 64 i를 0부터 클릭한 위치의 Y좌표 + 64까지 증가시키기
                Block blockUnderneath = pContext.getLevel().getBlockState(clickedPosition.below(i)).getBlock();     //Get Block from below i block from Position Clicked 클릭한 위치의 i블록만큼 밑에 있는 블록을 가져오기

                if(isAmethyum(blockUnderneath)) {
                    player.playSound(ModSounds.AMETHYUM_BLOCK_SOUNDS.getBreakSound(), 1f,.1f);
                    writeAmethyumCoord(clickedPosition.below(i), player, blockUnderneath);
                    blockFound = true;
                    break;
                }
            }

            if (!blockFound) {      //if Amethyum block is not Found 아메지움 블록을 찾지 못하였다면
                player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT,1f,.5f);
                player.sendMessage(new TranslatableComponent("item.firstmod.amethyum_resonator.not_found"),
                        player.getUUID());      //send Translatable Message to Player 번역 가능한 메시지를 플레이어에게 보내기
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void writeAmethyumCoord (BlockPos blockPosition, Player player, Block blockUnderneath) {
        player.sendMessage(new TextComponent
                        ("!!! " + blockUnderneath.asItem().getRegistryName().toString() + " -> (" + blockPosition.getX() + ", " + blockPosition.getY() + ", " + blockPosition.getZ() + ")"),
                player.getUUID());
    }

    private boolean isAmethyum(Block block) {
        return
                block == ModBlocks.ROUGH_AMETHYUM_BLOCK.get() ||
                block == ModBlocks.AMETHYUM_BLOCK.get();
    }

}
