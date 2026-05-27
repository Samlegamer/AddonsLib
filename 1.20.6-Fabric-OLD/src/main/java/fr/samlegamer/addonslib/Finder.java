package fr.samlegamer.addonslib;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Objects;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return Registries.BLOCK.get(new Identifier(MODID, nameBlock));
	}

	public static Block findBlock(String MODIDNameBlock)
	{
		return Registries.BLOCK.get(new Identifier(MODIDNameBlock));
	}

	public static String makeIdHedge(String MODID, String nameBlock)
	{
		return MODID + ":" + nameBlock+"_hedge";
	}

	public static Item findItem(String MODID, String nameItem)
	{
		return Registries.ITEM.get(new Identifier(MODID, nameItem));
	}

	public static Item findItem(String MODIDNameItem)
	{
		return Registries.ITEM.get(new Identifier(MODIDNameItem));
	}

	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return Registries.BLOCK_ENTITY_TYPE.get(new Identifier(MODID, nameTileEntity));
	}

	public static String getIdOfBlock(Block block)
	{
		return Registries.BLOCK.getId(block).getPath();
	}

	public static String getIdOfItem(Item item)
	{
		return Registries.ITEM.getId(item).getPath();
	}

	public static String getModidOfItem(Item item)
	{
		return Objects.requireNonNull(Registries.ITEM.getId(item)).getNamespace();
	}

	public static Identifier getRLOfItem(Item item)
	{
		return Objects.requireNonNull(Registries.ITEM.getId(item));
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