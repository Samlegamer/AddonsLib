package fr.samlegamer.addonslib;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		if(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(MODID, nameBlock)).isPresent())
		{
			return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(MODID, nameBlock)).get().value();
		}
		return Blocks.OAK_PLANKS;
	}
	
	public static Item findItem(String MODID, String nameItem)
	{
		if(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, nameItem)).isPresent())
		{
			return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, nameItem)).get().value();
		}
		return Items.GOLD_INGOT;
	}
	
	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		if(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(ResourceLocation.fromNamespaceAndPath(MODID, nameTileEntity)).isPresent())
		{
			return BuiltInRegistries.BLOCK_ENTITY_TYPE.get(ResourceLocation.fromNamespaceAndPath(MODID, nameTileEntity)).get().value();
		}
		return BlockEntityType.BEEHIVE;
	}
}