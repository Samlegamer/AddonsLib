package fr.samlegamer.addonslib;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(MODID, nameBlock));
	}
	
	public static Item findItem(String MODID, String nameItem)
	{
		return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, nameItem));
	}
	
	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return BuiltInRegistries.BLOCK_ENTITY_TYPE.get(ResourceLocation.fromNamespaceAndPath(MODID, nameTileEntity));
	}
}