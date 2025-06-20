package fr.samlegamer.addonslib.furnitures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

/*
 * Is used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class AddFurnituresStorage
{
	private static final List<String> PATTERNS = Arrays.asList(
			"%material%_wardrobe",
			"stripped_%material%_wardrobe",
			"%material%_modern_wardrobe",
			"stripped_%material%_modern_wardrobe",
			"%material%_double_wardrobe",
			"stripped_%material%_double_wardrobe",
			"%material%_bookshelf",
			"stripped_%material%_bookshelf",
			"%material%_bookshelf_cupboard",
			"stripped_%material%_bookshelf_cupboard",
			"%material%_drawer",
			"stripped_%material%_drawer",
			"%material%_double_drawer",
			"stripped_%material%_double_drawer",
			"%material%_bookshelf_drawer",
			"stripped_%material%_bookshelf_drawer",
			"%material%_lower_bookshelf_drawer",
			"stripped_%material%_lower_bookshelf_drawer",
			"%material%_large_drawer",
			"stripped_%material%_large_drawer",
			"%material%_lower_triple_drawer",
			"stripped_%material%_lower_triple_drawer",
			"%material%_triple_drawer",
			"stripped_%material%_triple_drawer",
			"%material%_drawer_counter",
			"stripped_%material%_drawer_counter",
			"%material%_double_drawer_counter",
			"stripped_%material%_double_drawer_counter",
			"%material%_cupboard_counter",
			"stripped_%material%_cupboard_counter",
			"%material%_kitchen_cabinet",
			"stripped_%material%_kitchen_cabinet",
			"%material%_double_kitchen_cabinet",
			"stripped_%material%_double_kitchen_cabinet",
			"%material%_glass_kitchen_cabinet",
			"stripped_%material%_glass_kitchen_cabinet"
	);

	public static void addCompatibleBlocksToFurnitureStorage(BlockEntityTypeAddBlocksEvent event, String MODID, List<String> MAT)
	{
		if (ModList.get().isLoaded(Furnitures.modid))
		{
			List<Block> blocks = new ArrayList<>();

			try {
				final Class<?> clss = Class.forName("com.mcwfurnitures.kikoz.objects.FurnitureObject");

				for (String i : MAT)
				{
					for (String j : PATTERNS)
					{
						if (clss.isInstance(Finder.findBlock(MODID, McwBlocksIdBase.replacement(j, i))))
						{
							blocks.add(Finder.findBlock(MODID, j.replace("%material%", i)));
						}
					}
				}
			} catch (ClassNotFoundException e) {
				AddonsLib.LOGGER.error(e);
			}

			event.modify(Finder.findTileEntity(Furnitures.modid, "furniture_storage"), blocks.toArray(new Block[0]));
		}
	}
}