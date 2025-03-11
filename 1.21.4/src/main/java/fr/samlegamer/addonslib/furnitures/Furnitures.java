package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);

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
				    	cherry_wardrobe = createBlock(mod, i+"_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_wardrobe")))), block, item, tab, modLoaded);
						cherry_modern_wardrobe = createBlock(mod, i+"_modern_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_wardrobe")))), block, item, tab, modLoaded);
						cherry_double_wardrobe = createBlock(mod, i+"_double_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_wardrobe")))), block, item, tab, modLoaded);
						cherry_bookshelf = createBlock(mod, i+"_bookshelf", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bookshelf")))), block, item, tab, modLoaded);
						cherry_bookshelf_cupboard = createBlock(mod, i+"_bookshelf_cupboard", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bookshelf_cupboard")))), block, item, tab, modLoaded);
						cherry_drawer = createBlock(mod, i+"_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_drawer")))), block, item, tab, modLoaded);
						cherry_double_drawer = createBlock(mod, i+"_double_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_drawer")))), block, item, tab, modLoaded);
						cherry_bookshelf_drawer = createBlock(mod, i+"_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bookshelf_drawer")))), block, item, tab, modLoaded);
						cherry_lower_bookshelf_drawer = createBlock(mod, i+"_lower_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_bookshelf_drawer")))), block, item, tab, modLoaded);
						cherry_large_drawer = createBlock(mod, i+"_large_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_large_drawer")))), block, item, tab, modLoaded);
						cherry_lower_triple_drawer = createBlock(mod, i+"_lower_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_triple_drawer")))), block, item, tab, modLoaded);
						cherry_triple_drawer = createBlock(mod, i+"_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_triple_drawer")))), block, item, tab, modLoaded);
						cherry_desk = createBlock(mod, i+"_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_desk")))), block, item, tab, modLoaded);
						cherry_covered_desk = createBlock(mod, i+"_covered_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_covered_desk")))), block, item, tab, modLoaded);
						cherry_modern_desk = createBlock(mod, i+"_modern_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_desk")))), block, item, tab, modLoaded);
						cherry_table = createBlock(mod, i+"_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_table")))), block, item, tab, modLoaded);
						cherry_end_table = createBlock(mod, i+"_end_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_end_table")))), block, item, tab, modLoaded);
						cherry_coffee_table = createBlock(mod, i+"_coffee_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_coffee_table")))), block, item, tab, modLoaded);
						cherry_glass_table = createBlock(mod, i+"_glass_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_glass_table")))), block, item, tab, modLoaded);
						cherry_chair = createBlock(mod, i+"_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_chair")))), block, item, tab, modLoaded);
						cherry_modern_chair = createBlock(mod, i+"_modern_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_chair")))), block, item, tab, modLoaded);
						cherry_striped_chair = createBlock(mod, i+"_striped_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_striped_chair")))), block, item, tab, modLoaded);
						cherry_stool_chair = createBlock(mod, i+"_stool_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stool_chair")))), block, item, tab, modLoaded);
						cherry_counter = createBlock(mod, i+"_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_counter")))), block, item, tab, modLoaded);
						cherry_drawer_counter = createBlock(mod, i+"_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_drawer_counter"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_double_drawer_counter = createBlock(mod, i+"_double_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_drawer_counter"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_cupboard_counter = createBlock(mod, i+"_cupboard_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_cupboard_counter")))), block, item, tab, modLoaded);

						stripped_cherry_wardrobe = createBlock(mod, "stripped_"+i+"_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_wardrobe")))), block, item, tab, modLoaded);
						stripped_cherry_modern_wardrobe = createBlock(mod, "stripped_"+i+"_modern_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurnitureHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_modern_wardrobe")))), block, item, tab, modLoaded);
						stripped_cherry_double_wardrobe = createBlock(mod, "stripped_"+i+"_double_wardrobe", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TallFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_wardrobe")))), block, item, tab, modLoaded);
						stripped_cherry_bookshelf = createBlock(mod, "stripped_"+i+"_bookshelf", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_bookshelf")))), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_cupboard = createBlock(mod, "stripped_"+i+"_bookshelf_cupboard", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_bookshelf_cupboard")))), block, item, tab, modLoaded);
						stripped_cherry_drawer = createBlock(mod, "stripped_"+i+"_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_double_drawer = createBlock(mod, "stripped_"+i+"_double_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_drawer = createBlock(mod, "stripped_"+i+"_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_bookshelf_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_lower_bookshelf_drawer = createBlock(mod, "stripped_"+i+"_lower_bookshelf_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_lower_bookshelf_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_large_drawer = createBlock(mod, "stripped_"+i+"_large_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_large_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_lower_triple_drawer = createBlock(mod, "stripped_"+i+"_lower_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_lower_triple_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_triple_drawer = createBlock(mod, "stripped_"+i+"_triple_drawer", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.WideFurniture", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_triple_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_desk = createBlock(mod, "stripped_"+i+"_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_desk")))), block, item, tab, modLoaded);
						stripped_cherry_covered_desk = createBlock(mod, "stripped_"+i+"_covered_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_covered_desk")))), block, item, tab, modLoaded);
						stripped_cherry_modern_desk = createBlock(mod, "stripped_"+i+"_modern_desk", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Desk", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_modern_desk")))), block, item, tab, modLoaded);
						stripped_cherry_table = createBlock(mod, "stripped_"+i+"_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_table")))), block, item, tab, modLoaded);
						stripped_cherry_end_table = createBlock(mod, "stripped_"+i+"_end_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_end_table")))), block, item, tab, modLoaded);
						stripped_cherry_coffee_table = createBlock(mod, "stripped_"+i+"_coffee_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Table", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_coffee_table")))), block, item, tab, modLoaded);
						stripped_cherry_glass_table = createBlock(mod, "stripped_"+i+"_glass_table", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.TableHitbox", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_glass_table")))), block, item, tab, modLoaded);
						stripped_cherry_chair = createBlock(mod, "stripped_"+i+"_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ClassicChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_chair")))), block, item, tab, modLoaded);
						stripped_cherry_modern_chair = createBlock(mod, "stripped_"+i+"_modern_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.ModernChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_modern_chair")))), block, item, tab, modLoaded);
						stripped_cherry_striped_chair = createBlock(mod, "stripped_"+i+"_striped_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.chairs.StripedChair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_striped_chair")))), block, item, tab, modLoaded);
						stripped_cherry_stool_chair = createBlock(mod, "stripped_"+i+"_stool_chair", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.Chair", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_stool_chair")))), block, item, tab, modLoaded);
						stripped_cherry_counter = createBlock(mod, "stripped_"+i+"_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.Counter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_counter")))), block, item, tab, modLoaded);
						stripped_cherry_drawer_counter = createBlock(mod, "stripped_"+i+"_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_drawer_counter"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_double_drawer_counter = createBlock(mod, "stripped_"+i+"_double_drawer_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.StorageCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_drawer_counter"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_cupboard_counter = createBlock(mod, "stripped_"+i+"_cupboard_counter", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_cupboard_counter")))), block, item, tab, modLoaded);
						cherry_kitchen_cabinet = createBlock(mod, i+"_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_kitchen_cabinet")))), block, item, tab, modLoaded);
						cherry_double_kitchen_cabinet = createBlock(mod, i+"_double_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_kitchen_cabinet"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_glass_kitchen_cabinet = createBlock(mod, i+"_glass_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_glass_kitchen_cabinet"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_kitchen_cabinet = createBlock(mod, "stripped_"+i+"_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_kitchen_cabinet")))), block, item, tab, modLoaded);
						stripped_cherry_double_kitchen_cabinet = createBlock(mod, "stripped_"+i+"_double_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_kitchen_cabinet"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						stripped_cherry_glass_kitchen_cabinet = createBlock(mod, "stripped_"+i+"_glass_kitchen_cabinet", () -> Registration.getBlocksField("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_glass_kitchen_cabinet"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
				    }
				    else
				    {
						cherry_wardrobe = createBlock(mod, i+"_wardrobe", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_wardrobe")))), block, item, tab, modLoaded);
						cherry_modern_wardrobe = createBlock(mod, i+"_modern_wardrobe", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_wardrobe")))), block, item, tab, modLoaded);
						cherry_double_wardrobe = createBlock(mod, i+"_double_wardrobe", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_wardrobe")))), block, item, tab, modLoaded);
						cherry_bookshelf = createBlock(mod, i+"_bookshelf", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bookshelf")))), block, item, tab, modLoaded);
						cherry_bookshelf_cupboard = createBlock(mod, i+"_bookshelf_cupboard", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bookshelf_cupboard")))), block, item, tab, modLoaded);
						cherry_drawer = createBlock(mod, i+"_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_drawer")))), block, item, tab, modLoaded);
						cherry_double_drawer = createBlock(mod, i+"_double_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_drawer")))), block, item, tab, modLoaded);
						cherry_bookshelf_drawer = createBlock(mod, i+"_bookshelf_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bookshelf_drawer")))), block, item, tab, modLoaded);
						cherry_lower_bookshelf_drawer = createBlock(mod, i+"_lower_bookshelf_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_bookshelf_drawer")))), block, item, tab, modLoaded);
						cherry_large_drawer = createBlock(mod, i+"_large_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_large_drawer")))), block, item, tab, modLoaded);
						cherry_lower_triple_drawer = createBlock(mod, i+"_lower_triple_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_triple_drawer")))), block, item, tab, modLoaded);
						cherry_triple_drawer = createBlock(mod, i+"_triple_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_triple_drawer")))), block, item, tab, modLoaded);
						cherry_desk = createBlock(mod, i+"_desk", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_desk")))), block, item, tab, modLoaded);
						cherry_covered_desk = createBlock(mod, i+"_covered_desk", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_covered_desk")))), block, item, tab, modLoaded);
						cherry_modern_desk = createBlock(mod, i+"_modern_desk", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_desk")))), block, item, tab, modLoaded);
						cherry_table = createBlock(mod, i+"_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_table")))), block, item, tab, modLoaded);
						cherry_end_table = createBlock(mod, i+"_end_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_end_table")))), block, item, tab, modLoaded);
						cherry_coffee_table = createBlock(mod, i+"_coffee_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_coffee_table")))), block, item, tab, modLoaded);
						cherry_glass_table = createBlock(mod, i+"_glass_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_glass_table")))), block, item, tab, modLoaded);
						cherry_chair = createBlock(mod, i+"_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_chair")))), block, item, tab, modLoaded);
						cherry_modern_chair = createBlock(mod, i+"_modern_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_chair")))), block, item, tab, modLoaded);
						cherry_striped_chair = createBlock(mod, i+"_striped_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_striped_chair")))), block, item, tab, modLoaded);
						cherry_stool_chair = createBlock(mod, i+"_stool_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stool_chair")))), block, item, tab, modLoaded);
						cherry_counter = createBlock(mod, i+"_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_counter")))), block, item, tab, modLoaded);
						cherry_drawer_counter = createBlock(mod, i+"_drawer_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_drawer_counter")))), block, item, tab, modLoaded);
						cherry_double_drawer_counter = createBlock(mod, i+"_double_drawer_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_drawer_counter")))), block, item, tab, modLoaded);
						cherry_cupboard_counter = createBlock(mod, i+"_cupboard_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_cupboard_counter")))), block, item, tab, modLoaded);

						stripped_cherry_wardrobe = createBlock(mod, "stripped_"+i+"_wardrobe", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_wardrobe")))), block, item, tab, modLoaded);
						stripped_cherry_modern_wardrobe = createBlock(mod, "stripped_"+i+"_modern_wardrobe", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_modern_wardrobe")))), block, item, tab, modLoaded);
						stripped_cherry_double_wardrobe = createBlock(mod, "stripped_"+i+"_double_wardrobe", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_wardrobe")))), block, item, tab, modLoaded);
						stripped_cherry_bookshelf = createBlock(mod, "stripped_"+i+"_bookshelf", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_bookshelf")))), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_cupboard = createBlock(mod, "stripped_"+i+"_bookshelf_cupboard", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_bookshelf_cupboard")))), block, item, tab, modLoaded);
						stripped_cherry_drawer = createBlock(mod, "stripped_"+i+"_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_double_drawer = createBlock(mod, "stripped_"+i+"_double_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_bookshelf_drawer = createBlock(mod, "stripped_"+i+"_bookshelf_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_bookshelf_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_lower_bookshelf_drawer = createBlock(mod, "stripped_"+i+"_lower_bookshelf_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_lower_bookshelf_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_large_drawer = createBlock(mod, "stripped_"+i+"_large_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_large_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_lower_triple_drawer = createBlock(mod, "stripped_"+i+"_lower_triple_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_lower_triple_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_triple_drawer = createBlock(mod, "stripped_"+i+"_triple_drawer", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_triple_drawer")))), block, item, tab, modLoaded);
						stripped_cherry_desk = createBlock(mod, "stripped_"+i+"_desk", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_desk")))), block, item, tab, modLoaded);
						stripped_cherry_covered_desk = createBlock(mod, "stripped_"+i+"_covered_desk", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_covered_desk")))), block, item, tab, modLoaded);
						stripped_cherry_modern_desk = createBlock(mod, "stripped_"+i+"_modern_desk", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_modern_desk")))), block, item, tab, modLoaded);
						stripped_cherry_table = createBlock(mod, "stripped_"+i+"_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_table")))), block, item, tab, modLoaded);
						stripped_cherry_end_table = createBlock(mod, "stripped_"+i+"_end_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_end_table")))), block, item, tab, modLoaded);
						stripped_cherry_coffee_table = createBlock(mod, "stripped_"+i+"_coffee_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_coffee_table")))), block, item, tab, modLoaded);
						stripped_cherry_glass_table = createBlock(mod, "stripped_"+i+"_glass_table", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_glass_table")))), block, item, tab, modLoaded);
						stripped_cherry_chair = createBlock(mod, "stripped_"+i+"_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_chair")))), block, item, tab, modLoaded);
						stripped_cherry_modern_chair = createBlock(mod, "stripped_"+i+"_modern_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_modern_chair")))), block, item, tab, modLoaded);
						stripped_cherry_striped_chair = createBlock(mod, "stripped_"+i+"_striped_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_striped_chair")))), block, item, tab, modLoaded);
						stripped_cherry_stool_chair = createBlock(mod, "stripped_"+i+"_stool_chair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_stool_chair")))), block, item, tab, modLoaded);
						stripped_cherry_counter = createBlock(mod, "stripped_"+i+"_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_counter")))), block, item, tab, modLoaded);
						stripped_cherry_drawer_counter = createBlock(mod, "stripped_"+i+"_drawer_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_drawer_counter")))), block, item, tab, modLoaded);
						stripped_cherry_double_drawer_counter = createBlock(mod, "stripped_"+i+"_double_drawer_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_drawer_counter")))), block, item, tab, modLoaded);
						stripped_cherry_cupboard_counter = createBlock(mod, "stripped_"+i+"_cupboard_counter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_cupboard_counter")))), block, item, tab, modLoaded);
						cherry_kitchen_cabinet = createBlock(mod, i+"_kitchen_cabinet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_kitchen_cabinet")))), block, item, tab, modLoaded);
						cherry_double_kitchen_cabinet = createBlock(mod, i+"_double_kitchen_cabinet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_double_kitchen_cabinet")))), block, item, tab, modLoaded);
						cherry_glass_kitchen_cabinet = createBlock(mod, i+"_glass_kitchen_cabinet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_glass_kitchen_cabinet")))), block, item, tab, modLoaded);
						stripped_cherry_kitchen_cabinet = createBlock(mod, "stripped_"+i+"_kitchen_cabinet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_kitchen_cabinet")))), block, item, tab, modLoaded);
						stripped_cherry_double_kitchen_cabinet = createBlock(mod, "stripped_"+i+"_double_kitchen_cabinet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_double_kitchen_cabinet")))), block, item, tab, modLoaded);
						stripped_cherry_glass_kitchen_cabinet = createBlock(mod, "stripped_"+i+"_glass_kitchen_cabinet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_glass_kitchen_cabinet")))), block, item, tab, modLoaded);
					}
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	protected static RegistryObject<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
		}
		else
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
		}
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