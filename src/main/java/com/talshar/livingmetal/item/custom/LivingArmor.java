package com.talshar.livingmetal.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.UUID;
import java.util.function.Consumer;

public class LivingArmor extends ArmorItem {
    public LivingArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    //TODO: Make it so enchantments won't work on broken armor.

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (isBroken(stack)) {
            return ImmutableMultimap.of();
        } else {
        return super.getAttributeModifiers(slot, stack);}
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return (isBroken(stack)) ? 0 : super.damageItem(stack, amount, entity, onBroken);
    }

    public static boolean isBroken(ItemStack stack) {
        return stack.getMaxDamage() > 2 &&  stack.getDamageValue() >= stack.getMaxDamage() - 2;
    }
}


