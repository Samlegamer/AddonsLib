package fr.samlegamer.addonslib;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import java.util.List;
import java.util.Objects;

/*
 * Search Item/Block/BlockEntityType with Identifier
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return Registry.BLOCK.get(new ResourceLocation(MODID, nameBlock));
	}

	public static Block findBlock(String MODIDNameBlock)
	{
		return Registry.BLOCK.get(new ResourceLocation(MODIDNameBlock));
	}

	public static Item findItem(String MODID, String nameItem)
	{
		return Registry.ITEM.get(new ResourceLocation(MODID, nameItem));
	}

	public static Item findItem(String MODIDNameItem)
	{
		return Registry.ITEM.get(new ResourceLocation(MODIDNameItem));
	}

	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return Registry.BLOCK_ENTITY_TYPE.get(new ResourceLocation(MODID, nameTileEntity));
	}

	public static String getIdOfBlock(Block block)
	{
		return Objects.requireNonNull(Registry.BLOCK.getKey(block)).getPath();
	}

	public static String getIdOfItem(Item item)
	{
		return Objects.requireNonNull(Registry.ITEM.getKey(item)).getPath();
	}

	public static String getModidOfItem(Item item)
	{
		return Objects.requireNonNull(Registry.ITEM.getKey(item)).getNamespace();
	}

	public static ResourceLocation getRLOfItem(Item item)
	{
		return Objects.requireNonNull(Registry.ITEM.getKey(item));
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