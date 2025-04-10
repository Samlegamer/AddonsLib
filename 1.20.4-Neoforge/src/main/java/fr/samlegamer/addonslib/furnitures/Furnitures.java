package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;

			DeferredBlock<Block> cherry_wardrobe,
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
			
			for(String i : set)
			{				
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	cherry_wardrobe = createBlock(i+"_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item);
						cherry_modern_wardrobe = createBlock(i+"_modern_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item);
						cherry_double_wardrobe = createBlock(i+"_double_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD), block, item);
						cherry_bookshelf = createBlock(i+"_bookshelf", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD), block, item);
						cherry_bookshelf_cupboard = createBlock(i+"_bookshelf_cupboard", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD), block, item);
						cherry_drawer = createBlock(i+"_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						cherry_double_drawer = createBlock(i+"_double_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						cherry_bookshelf_drawer = createBlock(i+"_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item);
						cherry_lower_bookshelf_drawer = createBlock(i+"_lower_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item);
						cherry_large_drawer = createBlock(i+"_large_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						cherry_lower_triple_drawer = createBlock(i+"_lower_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						cherry_triple_drawer = createBlock(i+"_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						cherry_desk = createBlock(i+"_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item);
						cherry_covered_desk = createBlock(i+"_covered_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item);
						cherry_modern_desk = createBlock(i+"_modern_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item);
						cherry_table = createBlock(i+"_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item);
						cherry_end_table = createBlock(i+"_end_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item);
						cherry_coffee_table = createBlock(i+"_coffee_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD), block, item);
						cherry_glass_table = createBlock(i+"_glass_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item);
						cherry_chair = createBlock(i+"_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD), block, item);
						cherry_modern_chair = createBlock(i+"_modern_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD), block, item);
						cherry_striped_chair = createBlock(i+"_striped_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD), block, item);
						cherry_stool_chair = createBlock(i+"_stool_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD), block, item);
						cherry_counter = createBlock(i+"_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD), block, item);
						cherry_drawer_counter = createBlock(i+"_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
						cherry_double_drawer_counter = createBlock(i+"_double_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
						cherry_cupboard_counter = createBlock(i+"_cupboard_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD), block, item);
						
						stripped_cherry_wardrobe = createBlock("stripped_"+i+"_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item);
						stripped_cherry_modern_wardrobe = createBlock("stripped_"+i+"_modern_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item);
						stripped_cherry_double_wardrobe = createBlock("stripped_"+i+"_double_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD), block, item);
						stripped_cherry_bookshelf = createBlock("stripped_"+i+"_bookshelf", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD), block, item);
						stripped_cherry_bookshelf_cupboard = createBlock("stripped_"+i+"_bookshelf_cupboard", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD), block, item);
						stripped_cherry_drawer = createBlock("stripped_"+i+"_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						stripped_cherry_double_drawer = createBlock("stripped_"+i+"_double_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						stripped_cherry_bookshelf_drawer = createBlock("stripped_"+i+"_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item);
						stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_"+i+"_lower_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item);
						stripped_cherry_large_drawer = createBlock("stripped_"+i+"_large_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						stripped_cherry_lower_triple_drawer = createBlock("stripped_"+i+"_lower_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						stripped_cherry_triple_drawer = createBlock("stripped_"+i+"_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item);
						stripped_cherry_desk = createBlock("stripped_"+i+"_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item);
						stripped_cherry_covered_desk = createBlock("stripped_"+i+"_covered_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item);
						stripped_cherry_modern_desk = createBlock("stripped_"+i+"_modern_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item);
						stripped_cherry_table = createBlock("stripped_"+i+"_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item);
						stripped_cherry_end_table = createBlock("stripped_"+i+"_end_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item);
						stripped_cherry_coffee_table = createBlock("stripped_"+i+"_coffee_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD), block, item);
						stripped_cherry_glass_table = createBlock("stripped_"+i+"_glass_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item);
						stripped_cherry_chair = createBlock("stripped_"+i+"_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD), block, item);
						stripped_cherry_modern_chair = createBlock("stripped_"+i+"_modern_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD), block, item);
						stripped_cherry_striped_chair = createBlock("stripped_"+i+"_striped_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD), block, item);
						stripped_cherry_stool_chair = createBlock("stripped_"+i+"_stool_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD), block, item);
						stripped_cherry_counter = createBlock("stripped_"+i+"_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD), block, item);
						stripped_cherry_drawer_counter = createBlock("stripped_"+i+"_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
						stripped_cherry_double_drawer_counter = createBlock("stripped_"+i+"_double_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
						stripped_cherry_cupboard_counter = createBlock("stripped_"+i+"_cupboard_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD), block, item);
						cherry_kitchen_cabinet = createBlock(i+"_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD), block, item);
						cherry_double_kitchen_cabinet = createBlock(i+"_double_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
						cherry_glass_kitchen_cabinet = createBlock(i+"_glass_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
						stripped_cherry_kitchen_cabinet = createBlock("stripped_"+i+"_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD), block, item);
						stripped_cherry_double_kitchen_cabinet = createBlock("stripped_"+i+"_double_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
						stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_"+i+"_glass_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
				    }
				    else
				    {
						cherry_wardrobe = createBlock(i+"_wardrobe", () -> new Block(WOOD), block, item);
						cherry_modern_wardrobe = createBlock(i+"_modern_wardrobe", () -> new Block(WOOD), block, item);
						cherry_double_wardrobe = createBlock(i+"_double_wardrobe", () -> new Block(WOOD), block, item);
						cherry_bookshelf = createBlock(i+"_bookshelf", () -> new Block(WOOD), block, item);
						cherry_bookshelf_cupboard = createBlock(i+"_bookshelf_cupboard", () -> new Block(WOOD), block, item);
						cherry_drawer = createBlock(i+"_drawer", () -> new Block(WOOD), block, item);
						cherry_double_drawer = createBlock(i+"_double_drawer", () -> new Block(WOOD), block, item);
						cherry_bookshelf_drawer = createBlock(i+"_bookshelf_drawer", () -> new Block(WOOD), block, item);
						cherry_lower_bookshelf_drawer = createBlock(i+"_lower_bookshelf_drawer", () -> new Block(WOOD), block, item);
						cherry_large_drawer = createBlock(i+"_large_drawer", () -> new Block(WOOD), block, item);
						cherry_lower_triple_drawer = createBlock(i+"_lower_triple_drawer", () -> new Block(WOOD), block, item);
						cherry_triple_drawer = createBlock(i+"_triple_drawer", () -> new Block(WOOD), block, item);
						cherry_desk = createBlock(i+"_desk", () -> new Block(WOOD), block, item);
						cherry_covered_desk = createBlock(i+"_covered_desk", () -> new Block(WOOD), block, item);
						cherry_modern_desk = createBlock(i+"_modern_desk", () -> new Block(WOOD), block, item);
						cherry_table = createBlock(i+"_table", () -> new Block(WOOD), block, item);
						cherry_end_table = createBlock(i+"_end_table", () -> new Block(WOOD), block, item);
						cherry_coffee_table = createBlock(i+"_coffee_table", () -> new Block(WOOD), block, item);
						cherry_glass_table = createBlock(i+"_glass_table", () -> new Block(WOOD), block, item);
						cherry_chair = createBlock(i+"_chair", () -> new Block(WOOD), block, item);
						cherry_modern_chair = createBlock(i+"_modern_chair", () -> new Block(WOOD), block, item);
						cherry_striped_chair = createBlock(i+"_striped_chair", () -> new Block(WOOD), block, item);
						cherry_stool_chair = createBlock(i+"_stool_chair", () -> new Block(WOOD), block, item);
						cherry_counter = createBlock(i+"_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						cherry_drawer_counter = createBlock(i+"_drawer_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						cherry_double_drawer_counter = createBlock(i+"_double_drawer_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						cherry_cupboard_counter = createBlock(i+"_cupboard_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						
						stripped_cherry_wardrobe = createBlock("stripped_"+i+"_wardrobe", () -> new Block(WOOD), block, item);
						stripped_cherry_modern_wardrobe = createBlock("stripped_"+i+"_modern_wardrobe", () -> new Block(WOOD), block, item);
						stripped_cherry_double_wardrobe = createBlock("stripped_"+i+"_double_wardrobe", () -> new Block(WOOD), block, item);
						stripped_cherry_bookshelf = createBlock("stripped_"+i+"_bookshelf", () -> new Block(WOOD), block, item);
						stripped_cherry_bookshelf_cupboard = createBlock("stripped_"+i+"_bookshelf_cupboard", () -> new Block(WOOD), block, item);
						stripped_cherry_drawer = createBlock("stripped_"+i+"_drawer", () -> new Block(WOOD), block, item);
						stripped_cherry_double_drawer = createBlock("stripped_"+i+"_double_drawer", () -> new Block(WOOD), block, item);
						stripped_cherry_bookshelf_drawer = createBlock("stripped_"+i+"_bookshelf_drawer", () -> new Block(WOOD), block, item);
						stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_"+i+"_lower_bookshelf_drawer", () -> new Block(WOOD), block, item);
						stripped_cherry_large_drawer = createBlock("stripped_"+i+"_large_drawer", () -> new Block(WOOD), block, item);
						stripped_cherry_lower_triple_drawer = createBlock("stripped_"+i+"_lower_triple_drawer", () -> new Block(WOOD), block, item);
						stripped_cherry_triple_drawer = createBlock("stripped_"+i+"_triple_drawer", () -> new Block(WOOD), block, item);
						stripped_cherry_desk = createBlock("stripped_"+i+"_desk", () -> new Block(WOOD), block, item);
						stripped_cherry_covered_desk = createBlock("stripped_"+i+"_covered_desk", () -> new Block(WOOD), block, item);
						stripped_cherry_modern_desk = createBlock("stripped_"+i+"_modern_desk", () -> new Block(WOOD), block, item);
						stripped_cherry_table = createBlock("stripped_"+i+"_table", () -> new Block(WOOD), block, item);
						stripped_cherry_end_table = createBlock("stripped_"+i+"_end_table", () -> new Block(WOOD), block, item);
						stripped_cherry_coffee_table = createBlock("stripped_"+i+"_coffee_table", () -> new Block(WOOD), block, item);
						stripped_cherry_glass_table = createBlock("stripped_"+i+"_glass_table", () -> new Block(WOOD), block, item);
						stripped_cherry_chair = createBlock("stripped_"+i+"_chair", () -> new Block(WOOD), block, item);
						stripped_cherry_modern_chair = createBlock("stripped_"+i+"_modern_chair", () -> new Block(WOOD), block, item);
						stripped_cherry_striped_chair = createBlock("stripped_"+i+"_striped_chair", () -> new Block(WOOD), block, item);
						stripped_cherry_stool_chair = createBlock("stripped_"+i+"_stool_chair", () -> new Block(WOOD), block, item);
						stripped_cherry_counter = createBlock("stripped_"+i+"_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						stripped_cherry_drawer_counter = createBlock("stripped_"+i+"_drawer_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						stripped_cherry_double_drawer_counter = createBlock("stripped_"+i+"_double_drawer_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						stripped_cherry_cupboard_counter = createBlock("stripped_"+i+"_cupboard_counter", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						cherry_kitchen_cabinet = createBlock(i+"_kitchen_cabinet", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						cherry_double_kitchen_cabinet = createBlock(i+"_double_kitchen_cabinet", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						cherry_glass_kitchen_cabinet = createBlock(i+"_glass_kitchen_cabinet", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						stripped_cherry_kitchen_cabinet = createBlock("stripped_"+i+"_kitchen_cabinet", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						stripped_cherry_double_kitchen_cabinet = createBlock("stripped_"+i+"_double_kitchen_cabinet", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
						stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_"+i+"_glass_kitchen_cabinet", () -> new StairBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	protected static DeferredBlock<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        return block;
    }
		
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
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
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
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