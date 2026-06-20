package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.Registration;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Function;

public class CreateBlockReferences
{
    public static void createBlock(String name, Function<Identifier, ? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix();
        ITEMS_REGISTRY.register(name, registryName  -> Registration.createBlockItemWood(name, block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName))));
    }

    public static void createBlockStone(String name, Function<Identifier, ? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix();
        ITEMS_REGISTRY.register(name, registryName -> Registration.createBlockItemStone(name, block.get(), properties.setId(ResourceKey.create(Registries.ITEM, registryName))));
    }

}