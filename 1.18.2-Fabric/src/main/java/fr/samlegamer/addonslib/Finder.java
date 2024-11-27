package fr.samlegamer.addonslib;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return Registry.BLOCK.get(new Identifier(MODID, nameBlock));
	}
	
	public static Item findItem(String MODID, String nameItem)
	{
		return Registry.ITEM.get(new Identifier(MODID, nameItem));
	}
	
	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return Registry.BLOCK_ENTITY_TYPE.get(new Identifier(MODID, nameTileEntity));
	}
}