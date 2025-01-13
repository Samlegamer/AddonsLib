package fr.samlegamer.addonslib.furnitures;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.samlegamer.addonslib.Finder;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/*
 * Is used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class AddFurnituresStorage
{
	private static void addCompatibleBlocks(Block... blocks)
	{
        Set<Block> currentBlocks = new HashSet<>(Finder.findTileEntity("mcwfurnitures", "furniture_storage").validBlocks);
        Collections.addAll(currentBlocks, blocks);
        Finder.findTileEntity("mcwfurnitures", "furniture_storage").validBlocks = Set.copyOf(currentBlocks);
    }
	
	public static void addCompatibleBlocksToFurnitureStorage(FMLCommonSetupEvent e, String MODID, List<String> MAT)
	{
		for(String i : MAT)
		{
	        addCompatibleBlocks(Finder.findBlock(MODID, i+"_wardrobe"),
	        		Finder.findBlock(MODID, i+"_modern_wardrobe"),
	        		Finder.findBlock(MODID, i+"_double_wardrobe"),
	        		Finder.findBlock(MODID, i+"_bookshelf"),
	        		Finder.findBlock(MODID, i+"_bookshelf_cupboard"),
					Finder.findBlock(MODID, i+"_drawer"),
					Finder.findBlock(MODID, i+"_double_drawer"),
					Finder.findBlock(MODID, i+"_bookshelf_drawer"),
					Finder.findBlock(MODID, i+"_lower_bookshelf_drawer"),
					Finder.findBlock(MODID, i+"_large_drawer"),
					Finder.findBlock(MODID, i+"_lower_triple_drawer"),
					Finder.findBlock(MODID, i+"_triple_drawer"),
					Finder.findBlock(MODID, i+"_drawer_counter"),
					Finder.findBlock(MODID, i+"_double_drawer_counter"),
					Finder.findBlock(MODID, i+"_cupboard_counter"),
					Finder.findBlock(MODID, "stripped_"+i+"_wardrobe"),
					Finder.findBlock(MODID, "stripped_"+i+"_modern_wardrobe"),
					Finder.findBlock(MODID, "stripped_"+i+"_double_wardrobe"),
					Finder.findBlock(MODID, "stripped_"+i+"_bookshelf"),
					Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_cupboard"),
					Finder.findBlock(MODID, "stripped_"+i+"_drawer"),
					Finder.findBlock(MODID, "stripped_"+i+"_double_drawer"),
					Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_drawer"),
					Finder.findBlock(MODID, "stripped_"+i+"_lower_bookshelf_drawer"),
					Finder.findBlock(MODID, "stripped_"+i+"_large_drawer"),
					Finder.findBlock(MODID, "stripped_"+i+"_lower_triple_drawer"),
					Finder.findBlock(MODID, "stripped_"+i+"_triple_drawer"),
					Finder.findBlock(MODID, "stripped_"+i+"_counter"),
					Finder.findBlock(MODID, "stripped_"+i+"_drawer_counter"),
					Finder.findBlock(MODID, "stripped_"+i+"_double_drawer_counter"),
					Finder.findBlock(MODID, "stripped_"+i+"_cupboard_counter"),
					Finder.findBlock(MODID, i+"_kitchen_cabinet"),
					Finder.findBlock(MODID, i+"_double_kitchen_cabinet"),
					Finder.findBlock(MODID, i+"_glass_kitchen_cabinet"),
					Finder.findBlock(MODID, "stripped_"+i+"_kitchen_cabinet"),
					Finder.findBlock(MODID, "stripped_"+i+"_double_kitchen_cabinet"),
					Finder.findBlock(MODID, "stripped_"+i+"_glass_kitchen_cabinet"));
		}
	}
}