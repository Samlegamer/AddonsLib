package fr.samlegamer.addonslib;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import java.util.List;
import java.util.Objects;

/*
 * Search Item/Block/BlockEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		if(BuiltInRegistries.BLOCK.get(Identifier.fromNamespaceAndPath(MODID, nameBlock)).isPresent())
		{
			return BuiltInRegistries.BLOCK.get(Identifier.fromNamespaceAndPath(MODID, nameBlock)).get().value();
		}
		return Blocks.AIR;
	}

	public static Block findBlock(String MODIDNameBlock)
	{
		if(BuiltInRegistries.BLOCK.get(Identifier.parse(MODIDNameBlock)).isPresent())
		{
			return BuiltInRegistries.BLOCK.get(Identifier.parse(MODIDNameBlock)).get().value();
		}
		return Blocks.AIR;
	}

	public static String makeIdHedge(String MODID, String nameBlock)
	{
		return MODID + ":" + nameBlock+"_hedge";
	}

	public static Item findItem(String MODID, String nameItem)
	{
		if(BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(MODID, nameItem)).isPresent())
		{
			return BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(MODID, nameItem)).get().value();
		}
		return Items.AIR;
	}

	public static Item findItem(String MODIDNameItem)
	{
		if(BuiltInRegistries.ITEM.get(Identifier.parse(MODIDNameItem)).isPresent())
		{
			return BuiltInRegistries.ITEM.get(Identifier.parse(MODIDNameItem)).get().value();
		}
		return Items.AIR;
	}

	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		if(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(Identifier.fromNamespaceAndPath(MODID, nameTileEntity)).isPresent())
		{
			return BuiltInRegistries.BLOCK_ENTITY_TYPE.get(Identifier.fromNamespaceAndPath(MODID, nameTileEntity)).get().value();
		}
		return BlockEntityType.BEEHIVE;
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

	public static Identifier getRLOfItem(Item item)
	{
		return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
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