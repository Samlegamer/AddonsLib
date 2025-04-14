package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
					if (ModList.get().isLoaded(modid)) {
						cherry_wardrobe = createBlock(i + "_wardrobe",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_modern_wardrobe = createBlock(i + "_modern_wardrobe",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_double_wardrobe = createBlock(i + "_double_wardrobe",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_bookshelf = createBlock(i + "_bookshelf",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_bookshelf_cupboard = createBlock(i + "_bookshelf_cupboard",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_drawer = createBlock(i + "_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_double_drawer = createBlock(i + "_double_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_bookshelf_drawer = createBlock(i + "_bookshelf_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_lower_bookshelf_drawer = createBlock(i + "_lower_bookshelf_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_large_drawer = createBlock(i + "_large_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_lower_triple_drawer = createBlock(i + "_lower_triple_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_triple_drawer = createBlock(i + "_triple_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_desk = createBlock(i + "_desk",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_covered_desk = createBlock(i + "_covered_desk",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_modern_desk = createBlock(i + "_modern_desk",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_table = createBlock(i + "_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_end_table = createBlock(i + "_end_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_coffee_table = createBlock(i + "_coffee_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_glass_table = createBlock(i + "_glass_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_chair = createBlock(i + "_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_modern_chair = createBlock(i + "_modern_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_striped_chair = createBlock(i + "_striped_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_stool_chair = createBlock(i + "_stool_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_counter = createBlock(i + "_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_drawer_counter = createBlock(i + "_drawer_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
						cherry_double_drawer_counter = createBlock(i + "_double_drawer_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
						cherry_cupboard_counter = createBlock(i + "_cupboard_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);

						stripped_cherry_wardrobe = createBlock("stripped_" + i + "_wardrobe",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_modern_wardrobe = createBlock("stripped_" + i + "_modern_wardrobe",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_double_wardrobe = createBlock("stripped_" + i + "_double_wardrobe",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_bookshelf = createBlock("stripped_" + i + "_bookshelf",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_bookshelf_cupboard = createBlock("stripped_" + i + "_bookshelf_cupboard",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_drawer = createBlock("stripped_" + i + "_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_double_drawer = createBlock("stripped_" + i + "_double_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_bookshelf_drawer = createBlock("stripped_" + i + "_bookshelf_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_" + i + "_lower_bookshelf_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_large_drawer = createBlock("stripped_" + i + "_large_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_lower_triple_drawer = createBlock("stripped_" + i + "_lower_triple_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_triple_drawer = createBlock("stripped_" + i + "_triple_drawer",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_desk = createBlock("stripped_" + i + "_desk",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_covered_desk = createBlock("stripped_" + i + "_covered_desk",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_modern_desk = createBlock("stripped_" + i + "_modern_desk",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_table = createBlock("stripped_" + i + "_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_end_table = createBlock("stripped_" + i + "_end_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_coffee_table = createBlock("stripped_" + i + "_coffee_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_glass_table = createBlock("stripped_" + i + "_glass_table",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_chair = createBlock("stripped_" + i + "_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_modern_chair = createBlock("stripped_" + i + "_modern_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_striped_chair = createBlock("stripped_" + i + "_striped_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_stool_chair = createBlock("stripped_" + i + "_stool_chair",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_counter = createBlock("stripped_" + i + "_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_drawer_counter = createBlock("stripped_" + i + "_drawer_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
						stripped_cherry_double_drawer_counter = createBlock("stripped_" + i + "_double_drawer_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
						stripped_cherry_cupboard_counter = createBlock("stripped_" + i + "_cupboard_counter",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_kitchen_cabinet = createBlock(i + "_kitchen_cabinet",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_double_kitchen_cabinet = createBlock(i + "_double_kitchen_cabinet",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
						cherry_glass_kitchen_cabinet = createBlock(i + "_glass_kitchen_cabinet",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
						stripped_cherry_kitchen_cabinet = createBlock("stripped_" + i + "_kitchen_cabinet",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_double_kitchen_cabinet = createBlock("stripped_" + i + "_double_kitchen_cabinet",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
						stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_" + i + "_glass_kitchen_cabinet",
								registryName -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()),
								block, item);
					}
					else
					{
						cherry_wardrobe = createBlock(i + "_wardrobe",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_modern_wardrobe = createBlock(i + "_modern_wardrobe",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_double_wardrobe = createBlock(i + "_double_wardrobe",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_bookshelf = createBlock(i + "_bookshelf",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_bookshelf_cupboard = createBlock(i + "_bookshelf_cupboard",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_drawer = createBlock(i + "_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_double_drawer = createBlock(i + "_double_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_bookshelf_drawer = createBlock(i + "_bookshelf_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_lower_bookshelf_drawer = createBlock(i + "_lower_bookshelf_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_large_drawer = createBlock(i + "_large_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_lower_triple_drawer = createBlock(i + "_lower_triple_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_triple_drawer = createBlock(i + "_triple_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_desk = createBlock(i + "_desk",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_covered_desk = createBlock(i + "_covered_desk",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_modern_desk = createBlock(i + "_modern_desk",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_table = createBlock(i + "_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_end_table = createBlock(i + "_end_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_coffee_table = createBlock(i + "_coffee_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_glass_table = createBlock(i + "_glass_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_chair = createBlock(i + "_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_modern_chair = createBlock(i + "_modern_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_striped_chair = createBlock(i + "_striped_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_stool_chair = createBlock(i + "_stool_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_counter = createBlock(i + "_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_drawer_counter = createBlock(i + "_drawer_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_double_drawer_counter = createBlock(i + "_double_drawer_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_cupboard_counter = createBlock(i + "_cupboard_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);

						stripped_cherry_wardrobe = createBlock("stripped_" + i + "_wardrobe",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_modern_wardrobe = createBlock("stripped_" + i + "_modern_wardrobe",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_double_wardrobe = createBlock("stripped_" + i + "_double_wardrobe",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_bookshelf = createBlock("stripped_" + i + "_bookshelf",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_bookshelf_cupboard = createBlock("stripped_" + i + "_bookshelf_cupboard",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_drawer = createBlock("stripped_" + i + "_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_double_drawer = createBlock("stripped_" + i + "_double_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_bookshelf_drawer = createBlock("stripped_" + i + "_bookshelf_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_" + i + "_lower_bookshelf_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_large_drawer = createBlock("stripped_" + i + "_large_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_lower_triple_drawer = createBlock("stripped_" + i + "_lower_triple_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_triple_drawer = createBlock("stripped_" + i + "_triple_drawer",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_desk = createBlock("stripped_" + i + "_desk",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_covered_desk = createBlock("stripped_" + i + "_covered_desk",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_modern_desk = createBlock("stripped_" + i + "_modern_desk",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_table = createBlock("stripped_" + i + "_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_end_table = createBlock("stripped_" + i + "_end_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_coffee_table = createBlock("stripped_" + i + "_coffee_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_glass_table = createBlock("stripped_" + i + "_glass_table",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_chair = createBlock("stripped_" + i + "_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_modern_chair = createBlock("stripped_" + i + "_modern_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_striped_chair = createBlock("stripped_" + i + "_striped_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_stool_chair = createBlock("stripped_" + i + "_stool_chair",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_counter = createBlock("stripped_" + i + "_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_drawer_counter = createBlock("stripped_" + i + "_drawer_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_double_drawer_counter = createBlock("stripped_" + i + "_double_drawer_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_cupboard_counter = createBlock("stripped_" + i + "_cupboard_counter",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_kitchen_cabinet = createBlock(i + "_kitchen_cabinet",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_double_kitchen_cabinet = createBlock(i + "_double_kitchen_cabinet",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						cherry_glass_kitchen_cabinet = createBlock(i + "_glass_kitchen_cabinet",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_kitchen_cabinet = createBlock("stripped_" + i + "_kitchen_cabinet",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_double_kitchen_cabinet = createBlock("stripped_" + i + "_double_kitchen_cabinet",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_" + i + "_glass_kitchen_cabinet",
								registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
					}
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}

	protected static DeferredBlock<Block> createBlock(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
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