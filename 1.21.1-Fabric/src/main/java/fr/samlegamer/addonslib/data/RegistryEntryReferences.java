package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.bridges.Bridges;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegistryEntryReferences
{
    public static void registryEntry(String MODID, String name, Block b)
    {
        Registry.register(Registries.BLOCK, Identifier.of(MODID, name), b);
        if(name.contains("log_bridge_middle") || name.startsWith("rope_") || name.endsWith("_bridge"))
        {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings(), Bridges.desc));
        }
        else if(name.contains("railing") && !name.contains("wall")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings(), "mcwstairs.railing.desc"));
        }
        else if(name.contains("balcony")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings(), "mcwstairs.balcony.desc"));

        }
        else if(name.contains("platform")) {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings(), "mcwstairs.platform.desc"));

        }
        else {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, new Item.Settings()));
        }
    }

}