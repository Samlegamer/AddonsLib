package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.Registration;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class CreateBlockReferences
{
    public static void createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS_REGISTRY.key(name));
        ITEMS_REGISTRY.register(name, () -> Registration.createBlockItemWood(name, block.get(), properties));
    }

    public static void createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS_REGISTRY.key(name));
        ITEMS_REGISTRY.register(name, () -> Registration.createBlockItemStone(name, block.get(), properties));
    }

}