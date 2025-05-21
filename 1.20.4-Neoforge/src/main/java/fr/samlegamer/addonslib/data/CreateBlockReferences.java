package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.bridges.Bridges;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateBlockReferences
{
    public static void createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties();
        if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), properties, Bridges.desc));
        }
        else if(name.endsWith("planks_path"))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), properties, 50));
        }
        else if(name.contains("railing")) {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties(), "mcwstairs.railing.desc"));
        }
        else if(name.contains("balcony")) {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties(), "mcwstairs.balcony.desc"));
        }
        else if(name.contains("platform")) {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties(), "mcwstairs.platform.desc"));
        }
        else {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), properties));
        }
    }

    public static DeferredBlock<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties();
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
        return block;
    }
}