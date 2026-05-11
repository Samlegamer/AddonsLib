package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.McwBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CreateBlockReferences
{
    public static void createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY,
                                   CreativeModeTab tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        ITEMS_REGISTRY.register(name, () -> Registration.createBlockItemWood(name, block.get(), tab, isModMcwLoaded, isModBaseLoaded));
    }

    public static void createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY,
                                        CreativeModeTab tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        ITEMS_REGISTRY.register(name, () -> Registration.createBlockItemStone(name, block.get(), tab, isModMcwLoaded, isModBaseLoaded));
    }

    public static void createBlockWoodOpti(String Modid, String name, Block block, CreativeModeTab tab, boolean isModLoaded)
    {
        McwBlockItem itemBlock = Registration.createBlockItemWood(name, block, tab, isModLoaded, true);

        block.setRegistryName(Modid, name);
        itemBlock.setRegistryName(Modid, name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
    }

    public static void createBlockStoneOpti(String Modid, String name, Block block, CreativeModeTab tab, boolean isModLoaded)
    {
        McwBlockItem itemBlock = Registration.createBlockItemStone(name, block, tab, isModLoaded, true);

        block.setRegistryName(Modid, name);
        itemBlock.setRegistryName(Modid, name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
    }
}