package com.talshar.livingmetal.item.custom;

import com.google.common.collect.ImmutableMap;
import com.talshar.livingmetal.block.ModBlocks;
import com.talshar.livingmetal.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
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
                    .put(ModBlocks.VIRIDIUM_BLOCK.get(), ModItems.VIRIDIUM_NUGGET.get())
                    .put(Blocks.SAND, Blocks.SAND.asItem())
                    .build();

    public DustbringerItem(Properties pProperties) {
        super(pProperties);
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
