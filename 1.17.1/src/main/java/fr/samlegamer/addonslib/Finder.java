package fr.samlegamer.addonslib;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

/*
 * Search Item/Block/TileEntityType with ResourceLocation
 */
public class Finder
{
	public static Block findBlock(String MODID, String nameBlock)
	{
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, nameBlock));
	}

    public static Block findBlock(String MODIDNameBlock)
    {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODIDNameBlock));
    }

    public static String makeIdHedge(String MODID, String nameBlock)
    {
        return MODID + ":" + nameBlock+"_hedge";
    }
	
	public static Item findItem(String MODID, String nameItem)
	{
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID, nameItem));
	}

    public static Item findItem(String MODIDNameItem)
    {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODIDNameItem));
    }
	
	public static BlockEntityType<?> findTileEntity(String MODID, String nameTileEntity)
	{
		return ForgeRegistries.BLOCK_ENTITIES.getValue(new ResourceLocation(MODID, nameTileEntity));
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
}