package com.talshar.livingmetal.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab LIVINGMETAL_TAB = new CreativeModeTab("livingMetalTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.VERIDIUM_AXE.get());
        }
    };
}
