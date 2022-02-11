package com.talshar.livingmetal.item.custom;

import com.google.common.collect.ImmutableMap;
import com.talshar.livingmetal.block.ModBlocks;
import com.talshar.livingmetal.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Map;

public class DustbringerItem extends Item {
    private static final Map<Block, Item> DUSTBRINGER_ITEM_CRAFT =
            new ImmutableMap.Builder<Block, Item>()
                    .put(ModBlocks.VERIDIUM_BLOCK.get(), ModItems.VERIDIUM_NUGGET.get())
                    .put(Blocks.SAND, Blocks.SAND.asItem())
                    .build();

    public DustbringerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide && !pPlayer.isSteppingCarefully()) {
            if (pUsedHand == InteractionHand.OFF_HAND) {
                ItemStack mainHandItem = pPlayer.getMainHandItem();
                if (isDamageable(mainHandItem)) {
                    int currentDamage = getDamage(mainHandItem);
                    pPlayer.sendMessage(new TextComponent("Current damage: " + currentDamage),
                            Util.NIL_UUID);
                    pPlayer.sendMessage(new TextComponent("Max Damage: " + pPlayer.getMainHandItem().getMaxDamage()),
                            Util.NIL_UUID);
                    pPlayer.sendMessage(new TextComponent("Item in main hand is: " + pPlayer.getMainHandItem()),
                            Util.NIL_UUID);
                    var nearBreakage = pPlayer.getMainHandItem().getMaxDamage() - 3;
                    pPlayer.getMainHandItem().setDamageValue(nearBreakage);
//                    mainHandItem.setDamageValue(nearBreakage);
//                    pPlayer.playSound(SoundEvents.GLASS_BREAK,10,5);
                }
            }
        }
        if (!pLevel.isClientSide && pPlayer.isSteppingCarefully()) {

        }
        pPlayer.swing(InteractionHand.OFF_HAND);
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
        }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if(canDustbringer(blockClicked)) {
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(DUSTBRINGER_ITEM_CRAFT.get(blockClicked), 1));

                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                    p.broadcastBreakEvent(pContext.getHand());
                });
            } else {
                pContext.getPlayer().sendMessage(new TextComponent("Cannot disintegrate this block!"),
                        Util.NIL_UUID);
            }
        }
        return InteractionResult.SUCCESS;

    }

    private boolean canDustbringer(Block block) {
        return DUSTBRINGER_ITEM_CRAFT.containsKey(block);
    }

}
