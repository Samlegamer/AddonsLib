package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Function;

public class CreateBlockReferences
{
    public static void createBlock(String name, Function<ResourceLocation, ? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix();
        if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwbridges.bridges.desc"));
        }
        else if(name.endsWith("planks_path"))
        {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), 50));
        }
        else if(name.contains("railing")) {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.railing.desc"));
        }
        else if(name.contains("balcony")) {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.balcony.desc"));
        }
        else if(name.contains("platform")) {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.platform.desc"));
        }
        else {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName))));
        }
    }

    public static void createBlockStone(String name, Function<ResourceLocation, ? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix();
        if(name.contains("railing") && !name.contains("wall") && !name.contains("gate")) {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemInfo(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.railing.desc"));
        }
        else if(name.contains("balcony")) {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemInfo(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.balcony.desc"));
        }
        else if(name.contains("platform")) {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItemInfo(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.platform.desc"));
        }
        else {
            ITEMS_REGISTRY.register(name, registryName -> new BlockItem(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName))));
        }
    }
}