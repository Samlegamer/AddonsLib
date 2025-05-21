package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.bridges.Bridges;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class RegistryEntryReferences
{
    public static void registryEntry(String MODID, String name, Block b)
    {
        final Identifier ID = Identifier.of(MODID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, ID);
        Registry.register(Registries.BLOCK, ID, b);
        if(name.contains("log_bridge_middle") || name.startsWith("rope_") || name.endsWith("_bridge"))
        {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue())), Bridges.desc));
        }
        else if(name.contains("railing")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue())), "mcwstairs.railing.desc"));
        }
        else if(name.contains("balcony")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue())), "mcwstairs.balcony.desc"));

        }
        else if(name.contains("platform")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue())), "mcwstairs.platform.desc"));

        }
        else {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue()))));
        }
    }

}