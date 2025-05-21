package fr.samlegamer.addonslib.furnitures;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;

/*
 * First used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class AddFurnituresStorage
{
	
	private static void addCompatibleBlocks(Set<Block> blocks) {
		try {
		    Class<?> furnitureClass = Class.forName("net.kikoz.mcwfurnitures.MacawsFurniture");

		    Field blockEntityField = furnitureClass.getField("FURNITURE_BLOCK_ENTITY");

		    BlockEntityType<?> furnitureBlockEntity = (BlockEntityType<?>) blockEntityField.get(null);

		    if (furnitureBlockEntity == null) {
		    } else {
		        for (Block b : blocks) {
		        	furnitureBlockEntity.addSupportedBlock(b); 
		        }
		    }
		} catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
			AddonsLib.LOGGER.error(e);
		}

    }
	
	public static void addCompatibleBlocksToFurnitureStorage(String MODID, List<String> MAT)
	{
		List<String> PATTERNS = List.of(
		"%material%_wardrobe",
				"%material%_modern_wardrobe",
				"%material%_double_wardrobe",
				"%material%_bookshelf",
				"%material%_bookshelf_cupboard",
				"%material%_drawer",
				"%material%_double_drawer",
				"%material%_bookshelf_drawer",
				"%material%_lower_bookshelf_drawer",
				"%material%_large_drawer",
				"%material%_lower_triple_drawer",
				"%material%_triple_drawer",
				"%material%_drawer_counter",
				"%material%_double_drawer_counter",
				"%material%_cupboard_counter",
				"stripped_%material%_wardrobe",
				"stripped_%material%_modern_wardrobe",
				"stripped_%material%_double_wardrobe",
				"stripped_%material%_bookshelf",
				"stripped_%material%_bookshelf_cupboard",
				"stripped_%material%_drawer",
				"stripped_%material%_double_drawer",
				"stripped_%material%_bookshelf_drawer",
				"stripped_%material%_lower_bookshelf_drawer",
				"stripped_%material%_large_drawer",
				"stripped_%material%_lower_triple_drawer",
				"stripped_%material%_triple_drawer",
				"stripped_%material%_counter",
				"stripped_%material%_drawer_counter",
				"stripped_%material%_double_drawer_counter",
				"stripped_%material%_cupboard_counter",
				"%material%_kitchen_cabinet",
				"%material%_double_kitchen_cabinet",
				"%material%_glass_kitchen_cabinet",
				"stripped_%material%_kitchen_cabinet",
				"stripped_%material%_double_kitchen_cabinet",
				"stripped_%material%_glass_kitchen_cabinet",
				"%material%_counter",
				"stripped_%material%_counter");

		Set<Block> BLOCKS = new HashSet<>();

		if (FabricLoader.getInstance().isModLoaded(Furnitures.modid)) {
			try {
				final Class<?> clss = Class.forName("net.kikoz.mcwfurnitures.objects.FurnitureObject");

				for (String i : MAT) {
					for (String j : PATTERNS) {
						if (clss.isInstance(Finder.findBlock(MODID, McwBlocksIdBase.replacement(j, i)))) {
							BLOCKS.add(Finder.findBlock(MODID, j.replace("%material%", i)));
						}
					}
				}
			} catch (ClassNotFoundException e) {
				AddonsLib.LOGGER.error(e);
			}
		}
		addCompatibleBlocks(BLOCKS);
	}
}