package fr.samlegamer.addonslib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * Search Item/Block/TileEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, nameBlock));
	}
	
	public static Item findItem(String MODID, String nameItem)
	{
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID, nameItem));
	}
	
	public static TileEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return ForgeRegistries.TILE_ENTITIES.getValue(new ResourceLocation(MODID, nameTileEntity));
	}
}