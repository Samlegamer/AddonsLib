package fr.samlegamer.addonslib;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, nameBlock));
	}
}
