package com.talshar.livingmetal.block;

import com.talshar.livingmetal.LivingMetal;
import com.talshar.livingmetal.item.ModCreativeModeTab;
import com.talshar.livingmetal.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
    DeferredRegister.create(ForgeRegistries.BLOCKS, LivingMetal.MOD_ID);

    public static final RegistryObject<Block> VIRIDIUM_BLOCK = registerBlock("viridium_block",
    () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1.75f,6).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VIRIDIUM_ORE = registerBlock("viridium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.75f,6).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DUST = registerBlock("dust",
            () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND).strength(0.25f,1).sound(SoundType.SAND)));
    //TODO: Add breakage when falling on to them

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeModeTab.LIVINGMETAL_TAB)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
