package fr.samlegamer.addonslib.data;

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
        Registry.register(Registries.BLOCK, ID, b);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, ID);
        Item.Settings settings = new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue()));
        if(name.contains("log_bridge_middle") || name.startsWith("rope_"))
        {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, settings, "mcwbridges.bridges.desc"));
        }
        else if(name.contains("railing") && !name.contains("wall") && !name.contains("gate")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, settings, "mcwstairs.railing.desc"));
        }
        else if(name.contains("balcony")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, settings, "mcwstairs.balcony.desc"));

        }
        else if(name.contains("platform")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, settings, "mcwstairs.platform.desc"));

        }
        else {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, settings));
        }
    }

}