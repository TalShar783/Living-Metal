package com.talshar.livingmetal.item;

import com.talshar.livingmetal.LivingMetal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LivingMetal.MOD_ID);

    public static final RegistryObject<Item> VIRIDIUM_INGOT = ITEMS.register("viridium_ingot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_CHESTPLATE = ITEMS.register("viridium_chestplate",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_HELMET = ITEMS.register("viridium_helmet",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_HOE = ITEMS.register("viridium_hoe",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_LEGGINGS = ITEMS.register("viridium_leggings",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_BOOTS = ITEMS.register("viridium_boots",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_PICKAXE = ITEMS.register("viridium_pickaxe",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_SHOVEL = ITEMS.register("viridium_shovel",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_SWORD = ITEMS.register("viridium_sword",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_AXE = ITEMS.register("viridium_axe",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> VIRIDIUM_NUGGET = ITEMS.register("viridium_nugget",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
