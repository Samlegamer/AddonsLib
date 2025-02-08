package fr.samlegamer.addonslib;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return Registries.BLOCK.get(new Identifier(MODID, nameBlock));
	}
	
	public static Item findItem(String MODID, String nameItem)
	{
		return Registries.ITEM.get(new Identifier(MODID, nameItem));
	}
	
	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return Registries.BLOCK_ENTITY_TYPE.get(new Identifier(MODID, nameTileEntity));
	}
}