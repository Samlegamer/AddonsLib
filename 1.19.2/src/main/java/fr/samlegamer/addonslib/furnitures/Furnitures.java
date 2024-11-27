package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryObject;

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);

			RegistryObject<Block> cherry_wardrobe,
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
				    	cherry_wardrobe = createBlock(i+"_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item, tab, modLoaded);
						cherry_modern_wardrobe = createBlock(i+"_modern_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item, tab, modLoaded);
						cherry_double_wardrobe = createBlock(i+"_double_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD), block, item, tab, modLoaded);
						cherry_bookshelf = createBlock(i+"_bookshelf", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD), block, item, tab, modLoaded);
						cherry_bookshelf_cupboard = createBlock(i+"_bookshelf_cupboard", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD), block, item, tab, modLoaded);
						cherry_drawer = createBlock(i+"_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						cherry_double_drawer = createBlock(i+"_double_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						cherry_bookshelf_drawer = createBlock(i+"_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item, tab, modLoaded);
						cherry_lower_bookshelf_drawer = createBlock(i+"_lower_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item, tab, modLoaded);
						cherry_large_drawer = createBlock(i+"_large_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						cherry_lower_triple_drawer = createBlock(i+"_lower_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						cherry_triple_drawer = createBlock(i+"_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						cherry_desk = createBlock(i+"_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item, tab, modLoaded);
						cherry_covered_desk = createBlock(i+"_covered_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item, tab, modLoaded);
						cherry_modern_desk = createBlock(i+"_modern_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item, tab, modLoaded);
						cherry_table = createBlock(i+"_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item, tab, modLoaded);
						cherry_end_table = createBlock(i+"_end_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item, tab, modLoaded);
						cherry_coffee_table = createBlock(i+"_coffee_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD), block, item, tab, modLoaded);
						cherry_glass_table = createBlock(i+"_glass_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item, tab, modLoaded);
						cherry_chair = createBlock(i+"_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD), block, item, tab, modLoaded);
						cherry_modern_chair = createBlock(i+"_modern_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD), block, item, tab, modLoaded);
						cherry_striped_chair = createBlock(i+"_striped_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD), block, item, tab, modLoaded);
						cherry_stool_chair = createBlock(i+"_stool_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD), block, item, tab, modLoaded);
						cherry_counter = createBlock(i+"_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD), block, item, tab, modLoaded);
						cherry_drawer_counter = createBlock(i+"_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_double_drawer_counter = createBlock(i+"_double_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_cupboard_counter = createBlock(i+"_cupboard_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD), block, item, tab, modLoaded);
						
						stripped_cherry_wardrobe = createBlock("stripped_"+i+"_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item, tab, modLoaded);
						stripped_cherry_modern_wardrobe = createBlock("stripped_"+i+"_modern_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), block, item, tab, modLoaded);
						stripped_cherry_double_wardrobe = createBlock("stripped_"+i+"_double_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD), block, item, tab, modLoaded);
						stripped_cherry_bookshelf = createBlock("stripped_"+i+"_bookshelf", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_cupboard = createBlock("stripped_"+i+"_bookshelf_cupboard", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD), block, item, tab, modLoaded);
						stripped_cherry_drawer = createBlock("stripped_"+i+"_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						stripped_cherry_double_drawer = createBlock("stripped_"+i+"_double_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_drawer = createBlock("stripped_"+i+"_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item, tab, modLoaded);
						stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_"+i+"_lower_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), block, item, tab, modLoaded);
						stripped_cherry_large_drawer = createBlock("stripped_"+i+"_large_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						stripped_cherry_lower_triple_drawer = createBlock("stripped_"+i+"_lower_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						stripped_cherry_triple_drawer = createBlock("stripped_"+i+"_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), block, item, tab, modLoaded);
						stripped_cherry_desk = createBlock("stripped_"+i+"_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item, tab, modLoaded);
						stripped_cherry_covered_desk = createBlock("stripped_"+i+"_covered_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item, tab, modLoaded);
						stripped_cherry_modern_desk = createBlock("stripped_"+i+"_modern_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), block, item, tab, modLoaded);
						stripped_cherry_table = createBlock("stripped_"+i+"_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item, tab, modLoaded);
						stripped_cherry_end_table = createBlock("stripped_"+i+"_end_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item, tab, modLoaded);
						stripped_cherry_coffee_table = createBlock("stripped_"+i+"_coffee_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD), block, item, tab, modLoaded);
						stripped_cherry_glass_table = createBlock("stripped_"+i+"_glass_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), block, item, tab, modLoaded);
						stripped_cherry_chair = createBlock("stripped_"+i+"_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD), block, item, tab, modLoaded);
						stripped_cherry_modern_chair = createBlock("stripped_"+i+"_modern_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD), block, item, tab, modLoaded);
						stripped_cherry_striped_chair = createBlock("stripped_"+i+"_striped_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD), block, item, tab, modLoaded);
						stripped_cherry_stool_chair = createBlock("stripped_"+i+"_stool_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD), block, item, tab, modLoaded);
						stripped_cherry_counter = createBlock("stripped_"+i+"_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD), block, item, tab, modLoaded);
						stripped_cherry_drawer_counter = createBlock("stripped_"+i+"_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_double_drawer_counter = createBlock("stripped_"+i+"_double_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_cupboard_counter = createBlock("stripped_"+i+"_cupboard_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD), block, item, tab, modLoaded);
						cherry_kitchen_cabinet = createBlock(i+"_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD), block, item, tab, modLoaded);
						cherry_double_kitchen_cabinet = createBlock(i+"_double_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_glass_kitchen_cabinet = createBlock(i+"_glass_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_kitchen_cabinet = createBlock("stripped_"+i+"_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD), block, item, tab, modLoaded);
						stripped_cherry_double_kitchen_cabinet = createBlock("stripped_"+i+"_double_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_"+i+"_glass_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
				    }
				    else
				    {
						cherry_wardrobe = createBlock(i+"_wardrobe", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_modern_wardrobe = createBlock(i+"_modern_wardrobe", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_double_wardrobe = createBlock(i+"_double_wardrobe", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_bookshelf = createBlock(i+"_bookshelf", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_bookshelf_cupboard = createBlock(i+"_bookshelf_cupboard", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_drawer = createBlock(i+"_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_double_drawer = createBlock(i+"_double_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_bookshelf_drawer = createBlock(i+"_bookshelf_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_lower_bookshelf_drawer = createBlock(i+"_lower_bookshelf_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_large_drawer = createBlock(i+"_large_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_lower_triple_drawer = createBlock(i+"_lower_triple_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_triple_drawer = createBlock(i+"_triple_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_desk = createBlock(i+"_desk", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_covered_desk = createBlock(i+"_covered_desk", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_modern_desk = createBlock(i+"_modern_desk", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_table = createBlock(i+"_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_end_table = createBlock(i+"_end_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_coffee_table = createBlock(i+"_coffee_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_glass_table = createBlock(i+"_glass_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_chair = createBlock(i+"_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_modern_chair = createBlock(i+"_modern_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_striped_chair = createBlock(i+"_striped_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_stool_chair = createBlock(i+"_stool_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						cherry_counter = createBlock(i+"_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						cherry_drawer_counter = createBlock(i+"_drawer_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						cherry_double_drawer_counter = createBlock(i+"_double_drawer_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						cherry_cupboard_counter = createBlock(i+"_cupboard_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						
						stripped_cherry_wardrobe = createBlock("stripped_"+i+"_wardrobe", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_modern_wardrobe = createBlock("stripped_"+i+"_modern_wardrobe", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_double_wardrobe = createBlock("stripped_"+i+"_double_wardrobe", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_bookshelf = createBlock("stripped_"+i+"_bookshelf", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_cupboard = createBlock("stripped_"+i+"_bookshelf_cupboard", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_drawer = createBlock("stripped_"+i+"_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_double_drawer = createBlock("stripped_"+i+"_double_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_drawer = createBlock("stripped_"+i+"_bookshelf_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_"+i+"_lower_bookshelf_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_large_drawer = createBlock("stripped_"+i+"_large_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_lower_triple_drawer = createBlock("stripped_"+i+"_lower_triple_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_triple_drawer = createBlock("stripped_"+i+"_triple_drawer", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_desk = createBlock("stripped_"+i+"_desk", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_covered_desk = createBlock("stripped_"+i+"_covered_desk", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_modern_desk = createBlock("stripped_"+i+"_modern_desk", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_table = createBlock("stripped_"+i+"_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_end_table = createBlock("stripped_"+i+"_end_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_coffee_table = createBlock("stripped_"+i+"_coffee_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_glass_table = createBlock("stripped_"+i+"_glass_table", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_chair = createBlock("stripped_"+i+"_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_modern_chair = createBlock("stripped_"+i+"_modern_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_striped_chair = createBlock("stripped_"+i+"_striped_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_stool_chair = createBlock("stripped_"+i+"_stool_chair", () -> new Block(WOOD), block, item, tab, modLoaded);
						stripped_cherry_counter = createBlock("stripped_"+i+"_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						stripped_cherry_drawer_counter = createBlock("stripped_"+i+"_drawer_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						stripped_cherry_double_drawer_counter = createBlock("stripped_"+i+"_double_drawer_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						stripped_cherry_cupboard_counter = createBlock("stripped_"+i+"_cupboard_counter", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						cherry_kitchen_cabinet = createBlock(i+"_kitchen_cabinet", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						cherry_double_kitchen_cabinet = createBlock(i+"_double_kitchen_cabinet", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						cherry_glass_kitchen_cabinet = createBlock(i+"_glass_kitchen_cabinet", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						stripped_cherry_kitchen_cabinet = createBlock("stripped_"+i+"_kitchen_cabinet", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						stripped_cherry_double_kitchen_cabinet = createBlock("stripped_"+i+"_double_kitchen_cabinet", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
						stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_"+i+"_glass_kitchen_cabinet", () -> new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
		}
		else
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	public static void registryWood(final NewRegistryEvent event, List<String> set, CreativeModeTab tab)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);

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
			
			for(String i : set)
			{				
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	cherry_wardrobe = createBlockWoodOpti(i+"_wardrobe", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), tab);
						cherry_modern_wardrobe = createBlockWoodOpti(i+"_modern_wardrobe", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), tab);
						cherry_double_wardrobe = createBlockWoodOpti(i+"_double_wardrobe", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD), tab);
						cherry_bookshelf = createBlockWoodOpti(i+"_bookshelf", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD), tab);
						cherry_bookshelf_cupboard = createBlockWoodOpti(i+"_bookshelf_cupboard", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD), tab);
						cherry_drawer = createBlockWoodOpti(i+"_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						cherry_double_drawer = createBlockWoodOpti(i+"_double_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						cherry_bookshelf_drawer = createBlockWoodOpti(i+"_bookshelf_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), tab);
						cherry_lower_bookshelf_drawer = createBlockWoodOpti(i+"_lower_bookshelf_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), tab);
						cherry_large_drawer = createBlockWoodOpti(i+"_large_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						cherry_lower_triple_drawer = createBlockWoodOpti(i+"_lower_triple_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						cherry_triple_drawer = createBlockWoodOpti(i+"_triple_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						cherry_desk = createBlockWoodOpti(i+"_desk", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), tab);
						cherry_covered_desk = createBlockWoodOpti(i+"_covered_desk", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), tab);
						cherry_modern_desk = createBlockWoodOpti(i+"_modern_desk", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), tab);
						cherry_table = createBlockWoodOpti(i+"_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), tab);
						cherry_end_table = createBlockWoodOpti(i+"_end_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), tab);
						cherry_coffee_table = createBlockWoodOpti(i+"_coffee_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD), tab);
						cherry_glass_table = createBlockWoodOpti(i+"_glass_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), tab);
						cherry_chair = createBlockWoodOpti(i+"_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD), tab);
						cherry_modern_chair = createBlockWoodOpti(i+"_modern_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD), tab);
						cherry_striped_chair = createBlockWoodOpti(i+"_striped_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD), tab);
						cherry_stool_chair = createBlockWoodOpti(i+"_stool_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD), tab);
						cherry_counter = createBlockWoodOpti(i+"_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						cherry_drawer_counter = createBlockWoodOpti(i+"_drawer_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						cherry_double_drawer_counter = createBlockWoodOpti(i+"_double_drawer_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						cherry_cupboard_counter = createBlockWoodOpti(i+"_cupboard_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						
						stripped_cherry_wardrobe = createBlockWoodOpti("stripped_"+i+"_wardrobe", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), tab);
						stripped_cherry_modern_wardrobe = createBlockWoodOpti("stripped_"+i+"_modern_wardrobe", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD), tab);
						stripped_cherry_double_wardrobe = createBlockWoodOpti("stripped_"+i+"_double_wardrobe", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD), tab);
						stripped_cherry_bookshelf = createBlockWoodOpti("stripped_"+i+"_bookshelf", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD), tab);
						stripped_cherry_bookshelf_cupboard = createBlockWoodOpti("stripped_"+i+"_bookshelf_cupboard", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD), tab);
						stripped_cherry_drawer = createBlockWoodOpti("stripped_"+i+"_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						stripped_cherry_double_drawer = createBlockWoodOpti("stripped_"+i+"_double_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						stripped_cherry_bookshelf_drawer = createBlockWoodOpti("stripped_"+i+"_bookshelf_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), tab);
						stripped_cherry_lower_bookshelf_drawer = createBlockWoodOpti("stripped_"+i+"_lower_bookshelf_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD), tab);
						stripped_cherry_large_drawer = createBlockWoodOpti("stripped_"+i+"_large_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						stripped_cherry_lower_triple_drawer = createBlockWoodOpti("stripped_"+i+"_lower_triple_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						stripped_cherry_triple_drawer = createBlockWoodOpti("stripped_"+i+"_triple_drawer", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD), tab);
						stripped_cherry_desk = createBlockWoodOpti("stripped_"+i+"_desk", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), tab);
						stripped_cherry_covered_desk = createBlockWoodOpti("stripped_"+i+"_covered_desk", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), tab);
						stripped_cherry_modern_desk = createBlockWoodOpti("stripped_"+i+"_modern_desk", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD), tab);
						stripped_cherry_table = createBlockWoodOpti("stripped_"+i+"_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), tab);
						stripped_cherry_end_table = createBlockWoodOpti("stripped_"+i+"_end_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), tab);
						stripped_cherry_coffee_table = createBlockWoodOpti("stripped_"+i+"_coffee_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD), tab);
						stripped_cherry_glass_table = createBlockWoodOpti("stripped_"+i+"_glass_table", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD), tab);
						stripped_cherry_chair = createBlockWoodOpti("stripped_"+i+"_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD), tab);
						stripped_cherry_modern_chair = createBlockWoodOpti("stripped_"+i+"_modern_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD), tab);
						stripped_cherry_striped_chair = createBlockWoodOpti("stripped_"+i+"_striped_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD), tab);
						stripped_cherry_stool_chair = createBlockWoodOpti("stripped_"+i+"_stool_chair", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD), tab);
						stripped_cherry_counter = createBlockWoodOpti("stripped_"+i+"_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						stripped_cherry_drawer_counter = createBlockWoodOpti("stripped_"+i+"_drawer_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						stripped_cherry_double_drawer_counter = createBlockWoodOpti("stripped_"+i+"_double_drawer_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						stripped_cherry_cupboard_counter = createBlockWoodOpti("stripped_"+i+"_cupboard_counter", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						cherry_kitchen_cabinet = createBlockWoodOpti(i+"_kitchen_cabinet", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						cherry_double_kitchen_cabinet = createBlockWoodOpti(i+"_double_kitchen_cabinet", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						cherry_glass_kitchen_cabinet = createBlockWoodOpti(i+"_glass_kitchen_cabinet", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						stripped_cherry_kitchen_cabinet = createBlockWoodOpti("stripped_"+i+"_kitchen_cabinet", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						stripped_cherry_double_kitchen_cabinet = createBlockWoodOpti("stripped_"+i+"_double_kitchen_cabinet", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
						stripped_cherry_glass_kitchen_cabinet = createBlockWoodOpti("stripped_"+i+"_glass_kitchen_cabinet", Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
				    }
				    else
				    {
						cherry_wardrobe = createBlockWoodOpti(i+"_wardrobe", new Block(WOOD), tab);
						cherry_modern_wardrobe = createBlockWoodOpti(i+"_modern_wardrobe", new Block(WOOD), tab);
						cherry_double_wardrobe = createBlockWoodOpti(i+"_double_wardrobe", new Block(WOOD), tab);
						cherry_bookshelf = createBlockWoodOpti(i+"_bookshelf", new Block(WOOD), tab);
						cherry_bookshelf_cupboard = createBlockWoodOpti(i+"_bookshelf_cupboard", new Block(WOOD), tab);
						cherry_drawer = createBlockWoodOpti(i+"_drawer", new Block(WOOD), tab);
						cherry_double_drawer = createBlockWoodOpti(i+"_double_drawer", new Block(WOOD), tab);
						cherry_bookshelf_drawer = createBlockWoodOpti(i+"_bookshelf_drawer", new Block(WOOD), tab);
						cherry_lower_bookshelf_drawer = createBlockWoodOpti(i+"_lower_bookshelf_drawer", new Block(WOOD), tab);
						cherry_large_drawer = createBlockWoodOpti(i+"_large_drawer", new Block(WOOD), tab);
						cherry_lower_triple_drawer = createBlockWoodOpti(i+"_lower_triple_drawer", new Block(WOOD), tab);
						cherry_triple_drawer = createBlockWoodOpti(i+"_triple_drawer", new Block(WOOD), tab);
						cherry_desk = createBlockWoodOpti(i+"_desk", new Block(WOOD), tab);
						cherry_covered_desk = createBlockWoodOpti(i+"_covered_desk", new Block(WOOD), tab);
						cherry_modern_desk = createBlockWoodOpti(i+"_modern_desk", new Block(WOOD), tab);
						cherry_table = createBlockWoodOpti(i+"_table", new Block(WOOD), tab);
						cherry_end_table = createBlockWoodOpti(i+"_end_table", new Block(WOOD), tab);
						cherry_coffee_table = createBlockWoodOpti(i+"_coffee_table", new Block(WOOD), tab);
						cherry_glass_table = createBlockWoodOpti(i+"_glass_table", new Block(WOOD), tab);
						cherry_chair = createBlockWoodOpti(i+"_chair", new Block(WOOD), tab);
						cherry_modern_chair = createBlockWoodOpti(i+"_modern_chair", new Block(WOOD), tab);
						cherry_striped_chair = createBlockWoodOpti(i+"_striped_chair", new Block(WOOD), tab);
						cherry_stool_chair = createBlockWoodOpti(i+"_stool_chair", new Block(WOOD), tab);
						cherry_counter = createBlockWoodOpti(i+"_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						cherry_drawer_counter = createBlockWoodOpti(i+"_drawer_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						cherry_double_drawer_counter = createBlockWoodOpti(i+"_double_drawer_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						cherry_cupboard_counter = createBlockWoodOpti(i+"_cupboard_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						
						stripped_cherry_wardrobe = createBlockWoodOpti("stripped_"+i+"_wardrobe", new Block(WOOD), tab);
						stripped_cherry_modern_wardrobe = createBlockWoodOpti("stripped_"+i+"_modern_wardrobe", new Block(WOOD), tab);
						stripped_cherry_double_wardrobe = createBlockWoodOpti("stripped_"+i+"_double_wardrobe", new Block(WOOD), tab);
						stripped_cherry_bookshelf = createBlockWoodOpti("stripped_"+i+"_bookshelf", new Block(WOOD), tab);
						stripped_cherry_bookshelf_cupboard = createBlockWoodOpti("stripped_"+i+"_bookshelf_cupboard", new Block(WOOD), tab);
						stripped_cherry_drawer = createBlockWoodOpti("stripped_"+i+"_drawer", new Block(WOOD), tab);
						stripped_cherry_double_drawer = createBlockWoodOpti("stripped_"+i+"_double_drawer", new Block(WOOD), tab);
						stripped_cherry_bookshelf_drawer = createBlockWoodOpti("stripped_"+i+"_bookshelf_drawer", new Block(WOOD), tab);
						stripped_cherry_lower_bookshelf_drawer = createBlockWoodOpti("stripped_"+i+"_lower_bookshelf_drawer", new Block(WOOD), tab);
						stripped_cherry_large_drawer = createBlockWoodOpti("stripped_"+i+"_large_drawer", new Block(WOOD), tab);
						stripped_cherry_lower_triple_drawer = createBlockWoodOpti("stripped_"+i+"_lower_triple_drawer", new Block(WOOD), tab);
						stripped_cherry_triple_drawer = createBlockWoodOpti("stripped_"+i+"_triple_drawer", new Block(WOOD), tab);
						stripped_cherry_desk = createBlockWoodOpti("stripped_"+i+"_desk", new Block(WOOD), tab);
						stripped_cherry_covered_desk = createBlockWoodOpti("stripped_"+i+"_covered_desk", new Block(WOOD), tab);
						stripped_cherry_modern_desk = createBlockWoodOpti("stripped_"+i+"_modern_desk", new Block(WOOD), tab);
						stripped_cherry_table = createBlockWoodOpti("stripped_"+i+"_table", new Block(WOOD), tab);
						stripped_cherry_end_table = createBlockWoodOpti("stripped_"+i+"_end_table", new Block(WOOD), tab);
						stripped_cherry_coffee_table = createBlockWoodOpti("stripped_"+i+"_coffee_table", new Block(WOOD), tab);
						stripped_cherry_glass_table = createBlockWoodOpti("stripped_"+i+"_glass_table", new Block(WOOD), tab);
						stripped_cherry_chair = createBlockWoodOpti("stripped_"+i+"_chair", new Block(WOOD), tab);
						stripped_cherry_modern_chair = createBlockWoodOpti("stripped_"+i+"_modern_chair", new Block(WOOD), tab);
						stripped_cherry_striped_chair = createBlockWoodOpti("stripped_"+i+"_striped_chair", new Block(WOOD), tab);
						stripped_cherry_stool_chair = createBlockWoodOpti("stripped_"+i+"_stool_chair", new Block(WOOD), tab);
						stripped_cherry_counter = createBlockWoodOpti("stripped_"+i+"_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						stripped_cherry_drawer_counter = createBlockWoodOpti("stripped_"+i+"_drawer_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						stripped_cherry_double_drawer_counter = createBlockWoodOpti("stripped_"+i+"_double_drawer_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						stripped_cherry_cupboard_counter = createBlockWoodOpti("stripped_"+i+"_cupboard_counter", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						cherry_kitchen_cabinet = createBlockWoodOpti(i+"_kitchen_cabinet", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						cherry_double_kitchen_cabinet = createBlockWoodOpti(i+"_double_kitchen_cabinet", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						cherry_glass_kitchen_cabinet = createBlockWoodOpti(i+"_glass_kitchen_cabinet", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						stripped_cherry_kitchen_cabinet = createBlockWoodOpti("stripped_"+i+"_kitchen_cabinet", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						stripped_cherry_double_kitchen_cabinet = createBlockWoodOpti("stripped_"+i+"_double_kitchen_cabinet", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
						stripped_cherry_glass_kitchen_cabinet = createBlockWoodOpti("stripped_"+i+"_glass_kitchen_cabinet", new StairBlock(()->Blocks.OAK_LOG.defaultBlockState(), WOOD), tab);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	protected static Block createBlockWoodOpti(String name, Block block, CreativeModeTab tab)
    {
		BlockItem itemBlock;        
        if(ModList.get().isLoaded(modid))
		{
        	itemBlock = new BlockItemFuel(block, new Item.Properties().tab(tab));
		}
		else
		{
			itemBlock = new BlockItemFuel(block, new Item.Properties());
		}
        //block.setRegistryName(name);
        //itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(name, block);
        ForgeRegistries.ITEMS.register(name, itemBlock);
        return block;
    }
}