package fr.samlegamer.addonslib;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;

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
	
	public static Item findItem(String MODID, String nameItem)
	{
		return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(MODID, nameItem));
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
}