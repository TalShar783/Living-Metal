package com.talshar.livingmetal.item;

import com.talshar.livingmetal.LivingMetal;
import com.talshar.livingmetal.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LivingMetal.MOD_ID);

    public static final RegistryObject<Item> VIRIDIUM_INGOT = ITEMS.register("viridium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_NUGGET = ITEMS.register("viridium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> RAW_VIRIDIUM = ITEMS.register("raw_viridium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_CHESTPLATE = ITEMS.register("viridium_chestplate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_HELMET = ITEMS.register("viridium_helmet",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_LEGGINGS = ITEMS.register("viridium_leggings",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_BOOTS = ITEMS.register("viridium_boots",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_HOE = ITEMS.register("viridium_hoe",
            () -> new LMHoeItem(ModTiers.VIRIDIUM, 0,-2f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_PICKAXE = ITEMS.register("viridium_pickaxe",
            () -> new LMPickaxeItem(ModTiers.VIRIDIUM, 2,-2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_SHOVEL = ITEMS.register("viridium_shovel",
            () -> new LMShovelItem(ModTiers.VIRIDIUM, 2.5f,-3f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_SWORD = ITEMS.register("viridium_sword",
            () -> new LMSwordItem(ModTiers.VIRIDIUM, 4, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> VIRIDIUM_AXE = ITEMS.register("viridium_axe",
            () -> new LMAxeItem(ModTiers.VIRIDIUM, 8,-3.1f,
                    new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));

    public static final RegistryObject<Item> DUSTBRINGER = ITEMS.register("dustbringer",
            () -> new DustbringerItem(new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB).durability(1000)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
