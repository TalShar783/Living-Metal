package com.talshar.livingmetal.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {
    public static final ForgeTier VERIDIUM = new ForgeTier(1, 200, 4f,
            0f, 10, Tags.Blocks.NEEDS_GOLD_TOOL,
            () -> Ingredient.of(ModItems.VERIDIUM_INGOT.get()));
}
