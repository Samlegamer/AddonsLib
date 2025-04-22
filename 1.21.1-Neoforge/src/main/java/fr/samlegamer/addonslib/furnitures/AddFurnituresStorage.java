package fr.samlegamer.addonslib.furnitures;

import java.util.List;

import fr.samlegamer.addonslib.Finder;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

/*
 * Is used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class AddFurnituresStorage
{
	public static void addCompatibleBlocksToFurnitureStorage(BlockEntityTypeAddBlocksEvent event, String MODID, List<String> MAT)
	{
		if (ModList.get().isLoaded(Furnitures.modid))
		{
			for (String i : MAT)
			{
				event.modify(Finder.findTileEntity(Furnitures.modid, "furniture_storage"),
						Finder.findBlock(MODID, i + "_wardrobe"),
						Finder.findBlock(MODID, i + "_modern_wardrobe"),
						Finder.findBlock(MODID, i + "_double_wardrobe"),
						Finder.findBlock(MODID, i + "_bookshelf"),
						Finder.findBlock(MODID, i + "_bookshelf_cupboard"),
						Finder.findBlock(MODID, i + "_drawer"),
						Finder.findBlock(MODID, i + "_double_drawer"),
						Finder.findBlock(MODID, i + "_bookshelf_drawer"),
						Finder.findBlock(MODID, i + "_lower_bookshelf_drawer"),
						Finder.findBlock(MODID, i + "_large_drawer"),
						Finder.findBlock(MODID, i + "_lower_triple_drawer"),
						Finder.findBlock(MODID, i + "_triple_drawer"),
						Finder.findBlock(MODID, i + "_drawer_counter"),
						Finder.findBlock(MODID, i + "_double_drawer_counter"),
						Finder.findBlock(MODID, i + "_cupboard_counter"),
						Finder.findBlock(MODID, "stripped_" + i + "_wardrobe"),
						Finder.findBlock(MODID, "stripped_" + i + "_modern_wardrobe"),
						Finder.findBlock(MODID, "stripped_" + i + "_double_wardrobe"),
						Finder.findBlock(MODID, "stripped_" + i + "_bookshelf"),
						Finder.findBlock(MODID, "stripped_" + i + "_bookshelf_cupboard"),
						Finder.findBlock(MODID, "stripped_" + i + "_drawer"),
						Finder.findBlock(MODID, "stripped_" + i + "_double_drawer"),
						Finder.findBlock(MODID, "stripped_" + i + "_bookshelf_drawer"),
						Finder.findBlock(MODID, "stripped_" + i + "_lower_bookshelf_drawer"),
						Finder.findBlock(MODID, "stripped_" + i + "_large_drawer"),
						Finder.findBlock(MODID, "stripped_" + i + "_lower_triple_drawer"),
						Finder.findBlock(MODID, "stripped_" + i + "_triple_drawer"),
						Finder.findBlock(MODID, "stripped_" + i + "_counter"),
						Finder.findBlock(MODID, "stripped_" + i + "_drawer_counter"),
						Finder.findBlock(MODID, "stripped_" + i + "_double_drawer_counter"),
						Finder.findBlock(MODID, "stripped_" + i + "_cupboard_counter"),
						Finder.findBlock(MODID, i + "_kitchen_cabinet"),
						Finder.findBlock(MODID, i + "_double_kitchen_cabinet"),
						Finder.findBlock(MODID, i + "_glass_kitchen_cabinet"),
						Finder.findBlock(MODID, "stripped_" + i + "_kitchen_cabinet"),
						Finder.findBlock(MODID, "stripped_" + i + "_double_kitchen_cabinet"),
						Finder.findBlock(MODID, "stripped_" + i + "_glass_kitchen_cabinet"));
			}
		}
	}
}