package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.McwBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

public class RegistryEntryReferences
{
    public static void registryEntryWood(String MODID, String name, Block block, CreativeModeTab tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
    {
        Registry.register(Registry.BLOCK, new ResourceLocation(MODID, name), block);
        McwBlockItem mcwBlockItem = Registration.createBlockItemWood(name, block, tab, isModMcwLoaded, isModBaseLoaded);
        Registry.register(Registry.ITEM, new ResourceLocation(MODID, name), mcwBlockItem);
    }

    public static void registryEntryStone(String MODID, String name, Block block, CreativeModeTab tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
    {
        Registry.register(Registry.BLOCK, new ResourceLocation(MODID, name), block);
        McwBlockItem mcwBlockItem = Registration.createBlockItemStone(name, block, tab, isModMcwLoaded, isModBaseLoaded);
        Registry.register(Registry.ITEM, new ResourceLocation(MODID, name), mcwBlockItem);
    }
}