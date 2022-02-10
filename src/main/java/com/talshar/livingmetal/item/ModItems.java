package com.talshar.livingmetal.item;

import com.talshar.livingmetal.LivingMetal;
import com.talshar.livingmetal.item.custom.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LivingMetal.MOD_ID);

    public static final RegistryObject<Item> VERIDIUM_INGOT = ITEMS.register("veridium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_NUGGET = ITEMS.register("veridium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> RAW_VERIDIUM = ITEMS.register("raw_veridium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_HOE = ITEMS.register("veridium_hoe",
            () -> new LMHoeItem(ModTiers.VERIDIUM, 0,-2f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_PICKAXE = ITEMS.register("veridium_pickaxe",
            () -> new LMPickaxeItem(ModTiers.VERIDIUM, 2,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_SHOVEL = ITEMS.register("veridium_shovel",
            () -> new LMShovelItem(ModTiers.VERIDIUM, 2.5f,-3f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_SWORD = ITEMS.register("veridium_sword",
            () -> new LMSwordItem(ModTiers.VERIDIUM, 4, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_AXE = ITEMS.register("veridium_axe",
            () -> new LMAxeItem(ModTiers.VERIDIUM, 8,-3.1f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_CHESTPLATE = ITEMS.register("veridium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.VERIDIUM, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_HELMET = ITEMS.register("veridium_helmet",
            () -> new ArmorItem(ModArmorMaterials.VERIDIUM, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_LEGGINGS = ITEMS.register("veridium_leggings",
            () -> new ArmorItem(ModArmorMaterials.VERIDIUM, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VERIDIUM_BOOTS = ITEMS.register("veridium_boots",
            () -> new ArmorItem(ModArmorMaterials.VERIDIUM, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> DUSTBRINGER = ITEMS.register("dustbringer",
            () -> new DustbringerItem(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB).durability(1000)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
