package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FURNITURES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (isModMcwLoaded) {
					if (blockId.reflectedLocation().contains("StorageCounter") || blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet")) {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
					} else {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item);
					}
				} else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		addToTabModLoaded(event, MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded)
	{

		Block cherry_wardrobe,
		cherry_modern_wardrobe,
		cherry_double_wardrobe,
		cherry_bookshelf,
		cherry_bookshelf_cupboard,
		cherry_drawer,
		cherry_double_drawer,
		cherry_bookshelf_drawer,
		cherry_lower_bookshelf_drawer,
		cherry_large_drawer,
		cherry_lower_triple_drawer,
		cherry_triple_drawer,
		cherry_desk,
		cherry_covered_desk,
		cherry_modern_desk,
		cherry_table,
		cherry_end_table,
		cherry_coffee_table,
		cherry_glass_table,
		cherry_chair,
		cherry_modern_chair,
		cherry_striped_chair,
		cherry_stool_chair,
		cherry_counter,
		cherry_drawer_counter,
		cherry_double_drawer_counter,
		cherry_cupboard_counter,
		stripped_cherry_wardrobe,
		stripped_cherry_modern_wardrobe,
		stripped_cherry_double_wardrobe,
		stripped_cherry_bookshelf,
		stripped_cherry_bookshelf_cupboard,
		stripped_cherry_drawer,
		stripped_cherry_double_drawer,
		stripped_cherry_bookshelf_drawer,
		stripped_cherry_lower_bookshelf_drawer,
		stripped_cherry_large_drawer,
		stripped_cherry_lower_triple_drawer,
		stripped_cherry_triple_drawer,
		stripped_cherry_desk,
		stripped_cherry_covered_desk,
		stripped_cherry_modern_desk,
		stripped_cherry_table,
		stripped_cherry_end_table,
		stripped_cherry_coffee_table,
		stripped_cherry_glass_table,
		stripped_cherry_chair,
		stripped_cherry_modern_chair,
		stripped_cherry_striped_chair,
		stripped_cherry_stool_chair,
		stripped_cherry_counter,
		stripped_cherry_drawer_counter,
		stripped_cherry_double_drawer_counter,
		stripped_cherry_cupboard_counter,
		cherry_kitchen_cabinet,
		cherry_double_kitchen_cabinet,
		cherry_glass_kitchen_cabinet,
		stripped_cherry_kitchen_cabinet,
		stripped_cherry_double_kitchen_cabinet,
		stripped_cherry_glass_kitchen_cabinet;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
   	 	{
			for (String i : WOOD)
			{
				cherry_wardrobe = Finder.findBlock(MODID, i+"_wardrobe");
				cherry_modern_wardrobe = Finder.findBlock(MODID, i+"_modern_wardrobe");
				cherry_double_wardrobe = Finder.findBlock(MODID, i+"_double_wardrobe");
				cherry_bookshelf = Finder.findBlock(MODID, i+"_bookshelf");
				cherry_bookshelf_cupboard = Finder.findBlock(MODID, i+"_bookshelf_cupboard");
				cherry_drawer = Finder.findBlock(MODID, i+"_drawer");
				cherry_double_drawer = Finder.findBlock(MODID, i+"_double_drawer");
				cherry_bookshelf_drawer = Finder.findBlock(MODID, i+"_bookshelf_drawer");
				cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, i+"_lower_bookshelf_drawer");
				cherry_large_drawer = Finder.findBlock(MODID, i+"_large_drawer");
				cherry_lower_triple_drawer = Finder.findBlock(MODID, i+"_lower_triple_drawer");
				cherry_triple_drawer = Finder.findBlock(MODID, i+"_triple_drawer");
				cherry_desk = Finder.findBlock(MODID, i+"_desk");
				cherry_covered_desk = Finder.findBlock(MODID, i+"_covered_desk");
				cherry_modern_desk = Finder.findBlock(MODID, i+"_modern_desk");
				cherry_table = Finder.findBlock(MODID, i+"_table");
				cherry_end_table = Finder.findBlock(MODID, i+"_end_table");
				cherry_coffee_table = Finder.findBlock(MODID, i+"_coffee_table");
				cherry_glass_table = Finder.findBlock(MODID, i+"_glass_table");
				cherry_chair = Finder.findBlock(MODID, i+"_chair");
				cherry_modern_chair = Finder.findBlock(MODID, i+"_modern_chair");
				cherry_striped_chair = Finder.findBlock(MODID, i+"_striped_chair");
				cherry_stool_chair = Finder.findBlock(MODID, i+"_stool_chair");
				cherry_counter = Finder.findBlock(MODID, i+"_counter");
				cherry_drawer_counter = Finder.findBlock(MODID, i+"_drawer_counter");
				cherry_double_drawer_counter = Finder.findBlock(MODID, i+"_double_drawer_counter");
				cherry_cupboard_counter = Finder.findBlock(MODID, i+"_cupboard_counter");
				cherry_kitchen_cabinet = Finder.findBlock(MODID, i+"_kitchen_cabinet");
				cherry_double_kitchen_cabinet = Finder.findBlock(MODID, i+"_double_kitchen_cabinet");
				cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, i+"_glass_kitchen_cabinet");
	
	        	event.accept(cherry_wardrobe);
	        	event.accept(cherry_modern_wardrobe);
	        	event.accept(cherry_double_wardrobe);
	        	event.accept(cherry_bookshelf);
	        	event.accept(cherry_bookshelf_cupboard);
	        	event.accept(cherry_drawer);
	        	event.accept(cherry_double_drawer);
	        	event.accept(cherry_bookshelf_drawer);
	        	event.accept(cherry_lower_bookshelf_drawer);
	        	event.accept(cherry_large_drawer);
	        	event.accept(cherry_lower_triple_drawer);
	        	event.accept(cherry_triple_drawer);
	        	event.accept(cherry_desk);
	        	event.accept(cherry_covered_desk);
	        	event.accept(cherry_modern_desk);
	        	event.accept(cherry_table);
	        	event.accept(cherry_end_table);
	        	event.accept(cherry_coffee_table);
	        	event.accept(cherry_glass_table);
	        	event.accept(cherry_chair);
	        	event.accept(cherry_modern_chair);
	        	event.accept(cherry_striped_chair);
	        	event.accept(cherry_stool_chair);
	        	event.accept(cherry_counter);
	        	event.accept(cherry_drawer_counter);
	        	event.accept(cherry_double_drawer_counter);
	        	event.accept(cherry_cupboard_counter);
	        	event.accept(cherry_kitchen_cabinet);
	        	event.accept(cherry_double_kitchen_cabinet);
	        	event.accept(cherry_glass_kitchen_cabinet);
	        	
	        	stripped_cherry_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_wardrobe");
				stripped_cherry_modern_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_modern_wardrobe");
				stripped_cherry_double_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_double_wardrobe");
				stripped_cherry_bookshelf = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf");
				stripped_cherry_bookshelf_cupboard = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_cupboard");
				stripped_cherry_drawer = Finder.findBlock(MODID, "stripped_"+i+"_drawer");
				stripped_cherry_double_drawer = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer");
				stripped_cherry_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_drawer");
				stripped_cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_bookshelf_drawer");
				stripped_cherry_large_drawer = Finder.findBlock(MODID, "stripped_"+i+"_large_drawer");
				stripped_cherry_lower_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_triple_drawer");
				stripped_cherry_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_triple_drawer");
				stripped_cherry_desk = Finder.findBlock(MODID, "stripped_"+i+"_desk");
				stripped_cherry_covered_desk = Finder.findBlock(MODID, "stripped_"+i+"_covered_desk");
				stripped_cherry_modern_desk = Finder.findBlock(MODID, "stripped_"+i+"_modern_desk");
				stripped_cherry_table = Finder.findBlock(MODID, "stripped_"+i+"_table");
				stripped_cherry_end_table = Finder.findBlock(MODID, "stripped_"+i+"_end_table");
				stripped_cherry_coffee_table = Finder.findBlock(MODID, "stripped_"+i+"_coffee_table");
				stripped_cherry_glass_table = Finder.findBlock(MODID, "stripped_"+i+"_glass_table");
				stripped_cherry_chair = Finder.findBlock(MODID, "stripped_"+i+"_chair");
				stripped_cherry_modern_chair = Finder.findBlock(MODID, "stripped_"+i+"_modern_chair");
				stripped_cherry_striped_chair = Finder.findBlock(MODID, "stripped_"+i+"_striped_chair");
				stripped_cherry_stool_chair = Finder.findBlock(MODID, "stripped_"+i+"_stool_chair");
				stripped_cherry_counter = Finder.findBlock(MODID, "stripped_"+i+"_counter");
				stripped_cherry_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_drawer_counter");
				stripped_cherry_double_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer_counter");
				stripped_cherry_cupboard_counter = Finder.findBlock(MODID, "stripped_"+i+"_cupboard_counter");
				stripped_cherry_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_kitchen_cabinet");
				stripped_cherry_double_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_double_kitchen_cabinet");
				stripped_cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_glass_kitchen_cabinet");
	        	
				event.accept(stripped_cherry_wardrobe);
	        	event.accept(stripped_cherry_modern_wardrobe);
	        	event.accept(stripped_cherry_double_wardrobe);
	        	event.accept(stripped_cherry_bookshelf);
	        	event.accept(stripped_cherry_bookshelf_cupboard);
	        	event.accept(stripped_cherry_drawer);
	        	event.accept(stripped_cherry_double_drawer);
	        	event.accept(stripped_cherry_bookshelf_drawer);
	        	event.accept(stripped_cherry_lower_bookshelf_drawer);
	        	event.accept(stripped_cherry_large_drawer);
	        	event.accept(stripped_cherry_lower_triple_drawer);
	        	event.accept(stripped_cherry_triple_drawer);
	        	event.accept(stripped_cherry_desk);
	        	event.accept(stripped_cherry_covered_desk);
	        	event.accept(stripped_cherry_modern_desk);
	        	event.accept(stripped_cherry_table);
	        	event.accept(stripped_cherry_end_table);
	        	event.accept(stripped_cherry_coffee_table);
	        	event.accept(stripped_cherry_glass_table);
	        	event.accept(stripped_cherry_chair);
	        	event.accept(stripped_cherry_modern_chair);
	        	event.accept(stripped_cherry_striped_chair);
	        	event.accept(stripped_cherry_stool_chair);
	        	event.accept(stripped_cherry_counter);
	        	event.accept(stripped_cherry_drawer_counter);
	        	event.accept(stripped_cherry_double_drawer_counter);
	        	event.accept(stripped_cherry_cupboard_counter);
	        	event.accept(stripped_cherry_kitchen_cabinet);
	        	event.accept(stripped_cherry_double_kitchen_cabinet);
	        	event.accept(stripped_cherry_glass_kitchen_cabinet);
	        }
   	 	}
	}
}