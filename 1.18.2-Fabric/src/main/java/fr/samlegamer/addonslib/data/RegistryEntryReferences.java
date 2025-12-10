package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryEntryReferences
{
    public static void registryEntry(String MODID, String name, Block b, ItemGroup tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
    {
        Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
        if(isModMcwLoaded && isModBaseLoaded)
        {
            if(name.contains("log_bridge_middle") || name.startsWith("rope_") || name.endsWith("_bridge"))
            {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), "mcwbridges.bridges.desc"));
            }
            else if(name.contains("railing") && !name.contains("wall")) {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), "mcwstairs.railing.desc"));
            }
            else if(name.contains("balcony")) {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), "mcwstairs.balcony.desc"));

            }
            else if(name.contains("platform")) {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), "mcwstairs.platform.desc"));

            }
            else {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
            }
        }
        else {
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
    }

}