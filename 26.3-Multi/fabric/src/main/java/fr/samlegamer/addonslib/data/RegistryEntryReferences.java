package fr.samlegamer.addonslib.data;


import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.McwBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RegistryEntryReferences
{
    public static void registryEntryWood(String MODID, String name, Block block)
    {
        final Identifier ID = Identifier.fromNamespaceAndPath(MODID, name);
        Registry.register(BuiltInRegistries.BLOCK, ID, block);
        final ResourceKey<Block> registryKey = ResourceKey.create(Registries.BLOCK, ID);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryKey.identifier()));
        McwBlockItem mcwBlockItem = Registration.createBlockItemWood(name, block, properties);
        Registry.register(BuiltInRegistries.ITEM, ID, mcwBlockItem);
    }

    public static void registryEntryStone(String MODID, String name, Block block)
    {
        final Identifier ID = Identifier.fromNamespaceAndPath(MODID, name);
        Registry.register(BuiltInRegistries.BLOCK, ID, block);
        final ResourceKey<Block> registryKey = ResourceKey.create(Registries.BLOCK, ID);
        Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryKey.identifier()));
        McwBlockItem mcwBlockItem = Registration.createBlockItemStone(name, block, properties);
        Registry.register(BuiltInRegistries.ITEM, ID, mcwBlockItem);
    }
}