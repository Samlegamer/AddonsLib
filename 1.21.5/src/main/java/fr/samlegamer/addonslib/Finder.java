package fr.samlegamer.addonslib;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(MODID, nameBlock));
	}

	public static Block findBlock(String MODIDNameBlock)
	{
		return ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(MODIDNameBlock));
	}

	public static String makeIdHedge(String MODID, String nameBlock)
	{
		return MODID + ":" + nameBlock+"_hedge";
	}

	public static Item findItem(String MODID, String nameItem)
	{
		return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(MODID, nameItem));
	}

	public static Item findItem(String MODIDNameItem)
	{
		return ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(MODIDNameItem));
	}

	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(ResourceLocation.fromNamespaceAndPath(MODID, nameTileEntity));
	}

	public static String getIdOfBlock(Block block)
	{
		return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
	}

	public static String getIdOfItem(Item item)
	{
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
	}

	public static String getModidOfItem(Item item)
	{
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getNamespace();
	}

	public static ResourceLocation getRLOfItem(Item item)
	{
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
	}

	public static Block[] listToArray(List<Block> finalBlocks)
	{
		Block[] blockArray = new Block[finalBlocks.size()];

		for(int i = 0; i < finalBlocks.size(); i++)
		{
			blockArray[i] = finalBlocks.get(i);
		}
		return blockArray;
	}
}