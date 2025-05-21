package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.bridges.Bridges;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.world.item.BlockItem;
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
        Item.Properties properties = new Item.Properties();
        if(isModMcwLoaded && isModBaseLoaded)
        {
            properties.tab(tab);
            if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
                ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), properties, Bridges.desc));
            }
            else if(name.endsWith("planks_path"))
            {
                ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), properties, 50));
            }
            else if(name.contains("railing")) {
                ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.railing.desc"));
            }
            else if(name.contains("balcony")) {
                ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.balcony.desc"));
            }
            else if(name.contains("platform")) {
                ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.platform.desc"));
            }
            else {
                ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), properties));
            }
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), properties));
        }
    }

    public static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY,
    CreativeModeTab tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties();
        if(isModMcwLoaded && isModBaseLoaded)
        {
            properties.tab(tab);
            if(name.contains("railing")) {
                ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), properties, "mcwstairs.railing.desc"));
            }
            else if(name.contains("balcony")) {
                ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), properties, "mcwstairs.balcony.desc"));
            }
            else if(name.contains("platform")) {
                ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), properties, "mcwstairs.platform.desc"));
            }
            else {
                ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), properties));
            }
        }
        else {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), properties));
        }
        return block;
    }
}