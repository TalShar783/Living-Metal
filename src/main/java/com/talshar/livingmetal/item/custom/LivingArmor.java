package com.talshar.livingmetal.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
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

    //TODO: Make it so enchantments won't work on broken armor.

    /***
     * Overrides all Attributes (Armor, toughness, etc) if the armor is broken.
     * Otherwise, uses defaults.
     */
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (isBroken(stack)) {
            return ImmutableMultimap.of();
        } else {
        return super.getAttributeModifiers(slot, stack);}
    }

    /***
     *
     * Each armor tick, any broken armor will be moved into the player's regular inventory, but only if there is room.
     */

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {

        super.onArmorTick(stack, world, player);
    }

    /***
     * If the armor is broken, you won't be able to move it manually into the armor slot.
     * This does NOT override its on-use behavior, or being put on you through other means (like a Dispenser).
     */

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return !isBroken(stack) && super.canEquip(stack, armorType, entity);
    }

    /***
     * Prevents the player from equipping broken armor by holding it in-hand and clicking.
     */

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        var stack = pPlayer.getItemInHand(pHand);
        return (isBroken(stack) ? InteractionResultHolder.fail(stack) : super.use(pLevel, pPlayer, pHand));
    }

    /***
     * Any broken armor will be moved into the player's regular inventory, but only if there is room.
     * If the armor is already broken when it would take damage, the damage is reduced to zero.
     */

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        if (entity instanceof Player player) {
            if (isBroken(stack) && player.getInventory().add(stack)) {
                player.getInventory().add(stack);
            }
        }
        return (isBroken(stack)) ? 0 : super.damageItem(stack, amount, entity, onBroken);
    }

    /***
     * The armor will be considered broken if it has two or fewer durability remaining.
     */
    public static boolean isBroken(ItemStack stack) {
        return stack.getMaxDamage() > 2 &&  stack.getDamageValue() >= stack.getMaxDamage() - 2;
    }
}


