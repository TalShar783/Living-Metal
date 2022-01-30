package com.talshar.livingmetal.uniqueBehavior;

import com.talshar.livingmetal.item.custom.*;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;


import java.util.UUID;


public class LMItemBreaking {

        @SubscribeEvent(priority = EventPriority.HIGH)
        public void onBreakingBlock(PlayerEvent.BreakSpeed event) {
            var player = event.getPlayer();
            if (player.getAbilities().instabuild)
                return;

            var stack = player.getMainHandItem();
            if (stack.isEmpty())
                return;

            var item = stack.getItem();
            if (stack.isDamageableItem()
                    && isLMTool(item)) {
                if (isBroken(stack)) {
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent(priority = EventPriority.HIGH)
        public void onBreakBlock(BlockEvent.BreakEvent event) {
            var player = event.getPlayer();
            if (player.getAbilities().instabuild)
                return;

            var stack = player.getMainHandItem();
            if (stack.isEmpty())
                return;

            var item = stack.getItem();
            if (stack.isDamageableItem()
                    && isLMTool(item)) {
                if (isBroken(stack)) {
                    event.setCanceled(true);
                }
            }
        }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onUseHoe(UseHoeEvent event) {

        var player = event.getPlayer();
        if (player.getAbilities().instabuild)
            return;

        var stack = event.getContext().getItemInHand();
        if (stack.isEmpty())
            return;

        var item = stack.getItem();
        if (stack.isDamageableItem()
                && isLMTool(item)
                && isBroken(stack)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onAttackEntity(AttackEntityEvent event) {

        var player = event.getPlayer();
        if (player.getAbilities().instabuild)
            return;

        var stack = player.getMainHandItem();
        if (stack.isEmpty())
            return;

        var item = stack.getItem();
        if (stack.isDamageableItem()
                && isLMTool(item)
                && isBroken(stack)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {

        var player = event.getPlayer();
        if (player.getAbilities().instabuild)
            return;

        var stack = event.getItemStack();
        if (stack.isEmpty())
            return;

        var item = stack.getItem();
        if (stack.isDamageableItem()
                && isLMTool(item)
                && isBroken(stack)) {
            event.setCanceled(true);
        }
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        var player = event.getPlayer();
        if (player.getAbilities().instabuild)
            return;

        var stack = event.getItemStack();
        if (stack.isEmpty())
            return;

        var item = stack.getItem();
        if (stack.isDamageableItem()
                && isLMTool(item)
                && isBroken(stack)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {

        var player = event.getPlayer();
        if (player.getAbilities().instabuild)
            return;

        var stack = event.getItemStack();
        if (stack.isEmpty())
            return;

        var item = stack.getItem();
        if (stack.isDamageableItem()
                && isLMTool(item)
                && isBroken(stack)) {
            event.setCanceled(true);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.LOW)
    public void onItemTooltip(ItemTooltipEvent event) {
            var tooltip = event.getToolTip().listIterator();
            var stack = event.getItemStack();

            if (stack.isDamageableItem()) {
                var item = stack.getItem();
                if (isLMTool(item)) {
                    if (isBroken(stack)) {
                        tooltip.next();
                        tooltip.add(new TranslatableComponent("Broken").withStyle(ChatFormatting.RED));
                    }
                }
            }
    }



    public static boolean isLMTool(Item item) {
        return item instanceof LMAxeItem
                || item instanceof LMDiggerItem
                || item instanceof LMPickaxeItem
                || item instanceof LMShearsItem
                || item instanceof LMShovelItem
                || item instanceof LMSwordItem
                || item instanceof LMHoeItem;
    }

    public static boolean isBroken(ItemStack stack) {
        return stack.getMaxDamage() > 2 &&  stack.getDamageValue() >= stack.getMaxDamage() - 2;
    }
}











