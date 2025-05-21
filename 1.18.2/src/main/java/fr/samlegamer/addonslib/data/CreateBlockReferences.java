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
import net.minecraftforge.registries.ForgeRegistries;
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

    public static void createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY,
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
    }

    public static void createBlockWoodOpti(String Modid, String name, Block block, CreativeModeTab tab, boolean isModLoaded)
    {
        BlockItem itemBlock;
        Item.Properties properties = new Item.Properties();
        if(isModLoaded)
        {
            properties.tab(tab);
            if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
                itemBlock = new BlockItemFuelInfo(block, properties, Bridges.desc);
            }
            else if(name.endsWith("planks_path"))
            {
                itemBlock = new BlockItemFuel(block, properties, 50);
            }
            else if(name.contains("railing")) {
                itemBlock = new BlockItemFuelInfo(block, new Item.Properties().tab(tab), "mcwstairs.railing.desc");
            }
            else if(name.contains("balcony")) {
                itemBlock = new BlockItemFuelInfo(block, new Item.Properties().tab(tab), "mcwstairs.balcony.desc");
            }
            else if(name.contains("platform")) {
                itemBlock = new BlockItemFuelInfo(block, new Item.Properties().tab(tab), "mcwstairs.platform.desc");
            }
            else {
                itemBlock = new BlockItemFuel(block, properties);
            }
        }
        else
        {
            itemBlock = new BlockItemFuel(block, properties);
        }
        block.setRegistryName(Modid, name);
        itemBlock.setRegistryName(Modid, name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
    }

    public static void createBlockStoneOpti(String Modid, String name, Block block, CreativeModeTab tab, boolean isModLoaded)
    {
        BlockItem itemBlock;
        Item.Properties properties = new Item.Properties();
        if(isModLoaded)
        {
            properties.tab(tab);
            if(name.contains("railing")) {
                itemBlock = new BlockItemInfo(block, new Item.Properties().tab(tab), "mcwstairs.railing.desc");
            }
            else if(name.contains("balcony")) {
                itemBlock = new BlockItemInfo(block, new Item.Properties().tab(tab), "mcwstairs.balcony.desc");
            }
            else if(name.contains("platform")) {
                itemBlock = new BlockItemInfo(block, new Item.Properties().tab(tab), "mcwstairs.platform.desc");
            }
            else
            {
                itemBlock = new BlockItem(block, properties);
            }
        }
        else
        {
            itemBlock = new BlockItem(block, properties);
        }
        block.setRegistryName(Modid, name);
        itemBlock.setRegistryName(Modid, name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
    }
}