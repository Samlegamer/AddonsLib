package fr.samlegamer.addonslib;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import java.util.Objects;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return BuiltInRegistries.BLOCK.get(new ResourceLocation(MODID, nameBlock));
	}

	public static Block findBlock(String MODIDNameBlock)
	{
		return BuiltInRegistries.BLOCK.get(new ResourceLocation(MODIDNameBlock));
	}

	public static String makeIdHedge(String MODID, String nameBlock)
	{
		return MODID + ":" + nameBlock+"_hedge";
	}

	public static Item findItem(String MODID, String nameItem)
	{
		return BuiltInRegistries.ITEM.get(new ResourceLocation(MODID, nameItem));
	}

	public static Item findItem(String MODIDNameItem)
	{
		return BuiltInRegistries.ITEM.get(new ResourceLocation(MODIDNameItem));
	}

	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return BuiltInRegistries.BLOCK_ENTITY_TYPE.get(new ResourceLocation(MODID, nameTileEntity));
	}

	public static String getIdOfBlock(Block block)
	{
		return Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block)).getPath();
	}

	public static String getIdOfItem(Item item)
	{
		return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)).getPath();
	}

	public static String getModidOfItem(Item item)
	{
		return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)).getNamespace();
	}

	public static ResourceLocation getRLOfItem(Item item)
	{
		return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
	}
}