package fr.samlegamer.addonslib.mappings;

import java.lang.reflect.Field;
import java.util.List;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;

/*
 * First used in McwFurnituresBOP 1.21.1
 * Fix Placing Furnitures Crash
 */
public class AddFurnituresStorage
{
	
	private static void addCompatibleBlocks(Block... blocks) {
		try {
		    Class<?> furnitureClass = Class.forName("net.kikoz.mcwfurnitures.MacawsFurniture");

		    Field blockEntityField = furnitureClass.getField("FURNITURE_BLOCK_ENTITY"); // Pas besoin de setAccessible

		    BlockEntityType<?> furnitureBlockEntity = (BlockEntityType<?>) blockEntityField.get(null);

		    if (furnitureBlockEntity == null) {
		    } else {
		        for (Block b : blocks) {
		        	furnitureBlockEntity.addSupportedBlock(b); 
		        }
		    }
		} catch (ClassNotFoundException e) {
		} catch (NoSuchFieldException e) {
		} catch (IllegalAccessException e) {
		}

	}
	
	public static void addCompatibleBlocksToFurnitureStorage(String MODID, List<String> MAT)
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