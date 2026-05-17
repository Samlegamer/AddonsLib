package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
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
}