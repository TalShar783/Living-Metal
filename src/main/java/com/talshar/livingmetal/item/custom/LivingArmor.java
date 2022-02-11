package com.talshar.livingmetal.item.custom;

import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class LivingArmor extends ArmorItem {

    public LivingArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        if (isBroken(stack)) {
            return false;
        } else {
        return super.canEquip(stack, armorType, entity);}
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        if (isBroken(stack)) {
            var player = (Player) entity;
            if (!player.getInventory().add(stack)) {
                player.drop(stack.copy(),false);
                stack.shrink(1);
                } else {
                player.getInventory().add(stack);
            }
            return 0;

        } else {
            return super.damageItem(stack, amount, entity, onBroken);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (isBroken(pPlayer.getItemInHand(pHand))) {
            return InteractionResultHolder.fail(pPlayer.getItemInHand(pHand));
        } else {
        return super.use(pLevel, pPlayer, pHand);}
    }

    public static boolean isBroken(ItemStack stack) {
        return stack.getMaxDamage() > 2 &&  stack.getDamageValue() >= stack.getMaxDamage() - 2;
    }
}


