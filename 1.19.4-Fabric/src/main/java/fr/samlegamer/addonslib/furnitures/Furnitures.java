package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	
	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registries.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
    	}
    	else {
            Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
	}
	
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWood(MODID, set, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Settings WOOD = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{				
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	final Block cherry_wardrobe = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD);
				    	final Block cherry_modern_wardrobe = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD);
				    	final Block cherry_double_wardrobe = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD);
				    	final Block cherry_bookshelf = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD);
				    	final Block cherry_bookshelf_cupboard = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD);
				    	final Block cherry_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
				    	final Block cherry_double_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
				    	final Block cherry_bookshelf_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
				    	final Block cherry_lower_bookshelf_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
				    	final Block cherry_large_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
				    	final Block cherry_lower_triple_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
				    	final Block cherry_triple_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
				    	final Block cherry_desk = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD);
				    	final Block cherry_covered_desk = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD);
				    	final Block cherry_modern_desk = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD);
				    	final Block cherry_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD);
				    	final Block cherry_end_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD);
				    	final Block cherry_coffee_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Table", WOOD);
				    	final Block cherry_glass_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD);
				    	final Block cherry_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD);
				    	final Block cherry_modern_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.ModernChair", WOOD);
				    	final Block cherry_striped_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD);
				    	final Block cherry_stool_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Chair", WOOD);
				    	final Block cherry_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.Counter", WOOD);
				    	final Block cherry_drawer_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD);
				    	final Block cherry_double_drawer_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD);
				    	final Block cherry_cupboard_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.CupboardCounter", WOOD);
				    	
				    	final Block stripped_cherry_wardrobe = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD);
				    	final Block stripped_cherry_modern_wardrobe = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD);
				    	final Block stripped_cherry_double_wardrobe = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD);
				    	final Block stripped_cherry_bookshelf = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD);
				    	final Block stripped_cherry_bookshelf_cupboard = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD);
				    	final Block stripped_cherry_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
						final Block stripped_cherry_double_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
						final Block stripped_cherry_bookshelf_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
						final Block stripped_cherry_lower_bookshelf_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
						final Block stripped_cherry_large_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
						final Block stripped_cherry_lower_triple_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
						final Block stripped_cherry_triple_drawer = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD);
						final Block stripped_cherry_desk = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD);
						final Block stripped_cherry_covered_desk = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD);
						final Block stripped_cherry_modern_desk = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD);
						final Block stripped_cherry_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD);
						final Block stripped_cherry_end_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD);
						final Block stripped_cherry_coffee_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Table", WOOD);
						final Block stripped_cherry_glass_table = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD);
						final Block stripped_cherry_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD);
						final Block stripped_cherry_modern_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.ModernChair", WOOD);
						final Block stripped_cherry_striped_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD);
						final Block stripped_cherry_stool_chair = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Chair", WOOD);
						final Block stripped_cherry_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.Counter", WOOD);
						final Block stripped_cherry_drawer_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD);
						final Block stripped_cherry_double_drawer_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD);
						final Block stripped_cherry_cupboard_counter = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.CupboardCounter", WOOD);
						final Block cherry_kitchen_cabinet = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.CabinetHinge", WOOD);
						final Block cherry_double_kitchen_cabinet = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD);
						final Block cherry_glass_kitchen_cabinet = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD);
						final Block stripped_cherry_kitchen_cabinet = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.CabinetHinge", WOOD);
						final Block stripped_cherry_double_kitchen_cabinet = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD);
						final Block stripped_cherry_glass_kitchen_cabinet = Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD);

				    	registryEntry(MODID, i+"_wardrobe", cherry_wardrobe, tab, modLoaded);
						registryEntry(MODID, i+"_modern_wardrobe", cherry_modern_wardrobe, tab, modLoaded);
						registryEntry(MODID, i+"_double_wardrobe", cherry_double_wardrobe, tab, modLoaded);
						registryEntry(MODID, i+"_bookshelf", cherry_bookshelf, tab, modLoaded);
						registryEntry(MODID, i+"_bookshelf_cupboard", cherry_bookshelf_cupboard, tab, modLoaded);
						registryEntry(MODID, i+"_drawer", cherry_drawer, tab, modLoaded);
						registryEntry(MODID, i+"_double_drawer", cherry_double_drawer, tab, modLoaded);
						registryEntry(MODID, i+"_bookshelf_drawer", cherry_bookshelf_drawer, tab, modLoaded);
						registryEntry(MODID, i+"_lower_bookshelf_drawer", cherry_lower_bookshelf_drawer, tab, modLoaded);
						registryEntry(MODID, i+"_large_drawer", cherry_large_drawer, tab, modLoaded);
						registryEntry(MODID, i+"_lower_triple_drawer", cherry_lower_triple_drawer, tab, modLoaded);
						registryEntry(MODID, i+"_triple_drawer", cherry_triple_drawer, tab, modLoaded);
						registryEntry(MODID, i+"_desk", cherry_desk, tab, modLoaded);
						registryEntry(MODID, i+"_covered_desk", cherry_covered_desk, tab, modLoaded);
						registryEntry(MODID, i+"_modern_desk", cherry_modern_desk, tab, modLoaded);
						registryEntry(MODID, i+"_table", cherry_table, tab, modLoaded);
						registryEntry(MODID, i+"_end_table", cherry_end_table, tab, modLoaded);
						registryEntry(MODID, i+"_coffee_table", cherry_coffee_table, tab, modLoaded);
						registryEntry(MODID, i+"_glass_table", cherry_glass_table, tab, modLoaded);
						registryEntry(MODID, i+"_chair", cherry_chair, tab, modLoaded);
						registryEntry(MODID, i+"_modern_chair", cherry_modern_chair, tab, modLoaded);
						registryEntry(MODID, i+"_striped_chair", cherry_striped_chair, tab, modLoaded);
						registryEntry(MODID, i+"_stool_chair", cherry_stool_chair, tab, modLoaded);
						registryEntry(MODID, i+"_counter", cherry_counter, tab, modLoaded);
						registryEntry(MODID, i+"_drawer_counter", cherry_drawer_counter, tab, modLoaded);
						registryEntry(MODID, i+"_double_drawer_counter", cherry_double_drawer_counter, tab, modLoaded);
						registryEntry(MODID, i+"_cupboard_counter", cherry_cupboard_counter, tab, modLoaded);
						
						registryEntry(MODID, "stripped_"+i+"_wardrobe", stripped_cherry_wardrobe, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_modern_wardrobe", stripped_cherry_modern_wardrobe, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_wardrobe", stripped_cherry_double_wardrobe, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_bookshelf", stripped_cherry_bookshelf, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_bookshelf_cupboard", stripped_cherry_bookshelf_cupboard, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_drawer", stripped_cherry_drawer, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_drawer", stripped_cherry_double_drawer, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_bookshelf_drawer", stripped_cherry_bookshelf_drawer, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_lower_bookshelf_drawer", stripped_cherry_lower_bookshelf_drawer, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_large_drawer", stripped_cherry_large_drawer, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_lower_triple_drawer", stripped_cherry_lower_triple_drawer, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_triple_drawer", stripped_cherry_triple_drawer, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_desk", stripped_cherry_desk, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_covered_desk", stripped_cherry_covered_desk, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_modern_desk", stripped_cherry_modern_desk, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_table", stripped_cherry_table, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_end_table", stripped_cherry_end_table, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_coffee_table", stripped_cherry_coffee_table, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_glass_table", stripped_cherry_glass_table, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_chair", stripped_cherry_chair, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_modern_chair", stripped_cherry_modern_chair, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_striped_chair", stripped_cherry_striped_chair, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_stool_chair", stripped_cherry_stool_chair, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_counter", stripped_cherry_counter, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_drawer_counter", stripped_cherry_drawer_counter, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_drawer_counter", stripped_cherry_double_drawer_counter, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_cupboard_counter", stripped_cherry_cupboard_counter, tab, modLoaded);
						registryEntry(MODID, i+"_kitchen_cabinet", cherry_kitchen_cabinet, tab, modLoaded);
						registryEntry(MODID, i+"_double_kitchen_cabinet", cherry_double_kitchen_cabinet, tab, modLoaded);
						registryEntry(MODID, i+"_glass_kitchen_cabinet", cherry_glass_kitchen_cabinet, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_kitchen_cabinet", stripped_cherry_kitchen_cabinet, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_kitchen_cabinet", stripped_cherry_double_kitchen_cabinet, tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_glass_kitchen_cabinet", stripped_cherry_glass_kitchen_cabinet, tab, modLoaded);
				    }
				    else
				    {
						registryEntry(MODID, i+"_wardrobe", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_modern_wardrobe", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_double_wardrobe", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_bookshelf", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_bookshelf_cupboard", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_double_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_lower_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_large_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_lower_triple_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_triple_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_desk", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_covered_desk", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_modern_desk", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_end_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_coffee_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_glass_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_modern_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_striped_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_stool_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_double_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_cupboard_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						
						registryEntry(MODID, "stripped_"+i+"_wardrobe", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_modern_wardrobe", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_wardrobe", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_bookshelf", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_bookshelf_cupboard", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_lower_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_large_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_lower_triple_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_triple_drawer", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_desk", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_covered_desk", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_modern_desk", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_end_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_coffee_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_glass_table", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_modern_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_striped_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_stool_chair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_cupboard_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_double_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_glass_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_double_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						registryEntry(MODID, "stripped_"+i+"_glass_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}

	public static void addToTabWood(String MODID, List<String> WOOD, ItemGroup tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, ItemGroup tab, String modLoaded)
	{
		if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
		{
			for (String i : WOOD)
			{
				final Block cherry_wardrobe = Finder.findBlock(MODID, i+"_wardrobe");
				final Block cherry_modern_wardrobe = Finder.findBlock(MODID, i+"_modern_wardrobe");
				final Block cherry_double_wardrobe = Finder.findBlock(MODID, i+"_double_wardrobe");
				final Block cherry_bookshelf = Finder.findBlock(MODID, i+"_bookshelf");
				final Block cherry_bookshelf_cupboard = Finder.findBlock(MODID, i+"_bookshelf_cupboard");
				final Block cherry_drawer = Finder.findBlock(MODID, i+"_drawer");
				final Block cherry_double_drawer = Finder.findBlock(MODID, i+"_double_drawer");
				final Block cherry_bookshelf_drawer = Finder.findBlock(MODID, i+"_bookshelf_drawer");
				final Block cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, i+"_lower_bookshelf_drawer");
				final Block cherry_large_drawer = Finder.findBlock(MODID, i+"_large_drawer");
				final Block cherry_lower_triple_drawer = Finder.findBlock(MODID, i+"_lower_triple_drawer");
				final Block cherry_triple_drawer = Finder.findBlock(MODID, i+"_triple_drawer");
				final Block cherry_desk = Finder.findBlock(MODID, i+"_desk");
				final Block cherry_covered_desk = Finder.findBlock(MODID, i+"_covered_desk");
				final Block cherry_modern_desk = Finder.findBlock(MODID, i+"_modern_desk");
				final Block cherry_table = Finder.findBlock(MODID, i+"_table");
				final Block cherry_end_table = Finder.findBlock(MODID, i+"_end_table");
				final Block cherry_coffee_table = Finder.findBlock(MODID, i+"_coffee_table");
				final Block cherry_glass_table = Finder.findBlock(MODID, i+"_glass_table");
				final Block cherry_chair = Finder.findBlock(MODID, i+"_chair");
				final Block cherry_modern_chair = Finder.findBlock(MODID, i+"_modern_chair");
				final Block cherry_striped_chair = Finder.findBlock(MODID, i+"_striped_chair");
				final Block cherry_stool_chair = Finder.findBlock(MODID, i+"_stool_chair");
				final Block cherry_counter = Finder.findBlock(MODID, i+"_counter");
				final Block cherry_drawer_counter = Finder.findBlock(MODID, i+"_drawer_counter");
				final Block cherry_double_drawer_counter = Finder.findBlock(MODID, i+"_double_drawer_counter");
				final Block cherry_cupboard_counter = Finder.findBlock(MODID, i+"_cupboard_counter");
				final Block cherry_kitchen_cabinet = Finder.findBlock(MODID, i+"_kitchen_cabinet");
				final Block cherry_double_kitchen_cabinet = Finder.findBlock(MODID, i+"_double_kitchen_cabinet");
				final Block cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, i+"_glass_kitchen_cabinet");
	
				final Block stripped_cherry_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_wardrobe");
	        	final Block stripped_cherry_modern_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_modern_wardrobe");
				final Block stripped_cherry_double_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_double_wardrobe");
				final Block stripped_cherry_bookshelf = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf");
				final Block stripped_cherry_bookshelf_cupboard = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_cupboard");
				final Block stripped_cherry_drawer = Finder.findBlock(MODID, "stripped_"+i+"_drawer");
				final Block stripped_cherry_double_drawer = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer");
				final Block stripped_cherry_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_drawer");
				final Block stripped_cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_bookshelf_drawer");
				final Block stripped_cherry_large_drawer = Finder.findBlock(MODID, "stripped_"+i+"_large_drawer");
				final Block stripped_cherry_lower_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_triple_drawer");
				final Block stripped_cherry_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_triple_drawer");
				final Block stripped_cherry_desk = Finder.findBlock(MODID, "stripped_"+i+"_desk");
				final Block stripped_cherry_covered_desk = Finder.findBlock(MODID, "stripped_"+i+"_covered_desk");
				final Block stripped_cherry_modern_desk = Finder.findBlock(MODID, "stripped_"+i+"_modern_desk");
				final Block stripped_cherry_table = Finder.findBlock(MODID, "stripped_"+i+"_table");
				final Block stripped_cherry_end_table = Finder.findBlock(MODID, "stripped_"+i+"_end_table");
				final Block stripped_cherry_coffee_table = Finder.findBlock(MODID, "stripped_"+i+"_coffee_table");
				final Block stripped_cherry_glass_table = Finder.findBlock(MODID, "stripped_"+i+"_glass_table");
				final Block stripped_cherry_chair = Finder.findBlock(MODID, "stripped_"+i+"_chair");
				final Block stripped_cherry_modern_chair = Finder.findBlock(MODID, "stripped_"+i+"_modern_chair");
				final Block stripped_cherry_striped_chair = Finder.findBlock(MODID, "stripped_"+i+"_striped_chair");
				final Block stripped_cherry_stool_chair = Finder.findBlock(MODID, "stripped_"+i+"_stool_chair");
				final Block stripped_cherry_counter = Finder.findBlock(MODID, "stripped_"+i+"_counter");
				final Block stripped_cherry_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_drawer_counter");
				final Block stripped_cherry_double_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer_counter");
				final Block stripped_cherry_cupboard_counter = Finder.findBlock(MODID, "stripped_"+i+"_cupboard_counter");
				final Block stripped_cherry_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_kitchen_cabinet");
				final Block stripped_cherry_double_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_double_kitchen_cabinet");
				final Block stripped_cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_glass_kitchen_cabinet");
	
				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(cherry_wardrobe);
					content.add(cherry_modern_wardrobe);
					content.add(cherry_double_wardrobe);
					content.add(cherry_bookshelf);
					content.add(cherry_bookshelf_cupboard);
					content.add(cherry_drawer);
					content.add(cherry_double_drawer);
					content.add(cherry_bookshelf_drawer);
					content.add(cherry_lower_bookshelf_drawer);
					content.add(cherry_large_drawer);
					content.add(cherry_lower_triple_drawer);
					content.add(cherry_triple_drawer);
					content.add(cherry_desk);
					content.add(cherry_covered_desk);
					content.add(cherry_modern_desk);
					content.add(cherry_table);
					content.add(cherry_end_table);
					content.add(cherry_coffee_table);
					content.add(cherry_glass_table);
					content.add(cherry_chair);
					content.add(cherry_modern_chair);
					content.add(cherry_striped_chair);
					content.add(cherry_stool_chair);
					content.add(cherry_counter);
					content.add(cherry_drawer_counter);
					content.add(cherry_double_drawer_counter);
					content.add(cherry_cupboard_counter);
					content.add(stripped_cherry_wardrobe);
					content.add(stripped_cherry_modern_wardrobe);
					content.add(stripped_cherry_double_wardrobe);
					content.add(stripped_cherry_bookshelf);
					content.add(stripped_cherry_bookshelf_cupboard);
					content.add(stripped_cherry_drawer);
					content.add(stripped_cherry_double_drawer);
					content.add(stripped_cherry_bookshelf_drawer);
					content.add(stripped_cherry_lower_bookshelf_drawer);
					content.add(stripped_cherry_large_drawer);
					content.add(stripped_cherry_lower_triple_drawer);
					content.add(stripped_cherry_triple_drawer);
					content.add(stripped_cherry_desk);
					content.add(stripped_cherry_covered_desk);
					content.add(stripped_cherry_modern_desk);
					content.add(stripped_cherry_table);
					content.add(stripped_cherry_end_table);
					content.add(stripped_cherry_coffee_table);
					content.add(stripped_cherry_glass_table);
					content.add(stripped_cherry_chair);
					content.add(stripped_cherry_modern_chair);
					content.add(stripped_cherry_striped_chair);
					content.add(stripped_cherry_stool_chair);
					content.add(stripped_cherry_counter);
					content.add(stripped_cherry_drawer_counter);
					content.add(stripped_cherry_double_drawer_counter);
					content.add(stripped_cherry_cupboard_counter);
					content.add(cherry_kitchen_cabinet);
					content.add(cherry_double_kitchen_cabinet);
					content.add(cherry_glass_kitchen_cabinet);
					content.add(stripped_cherry_kitchen_cabinet);
					content.add(stripped_cherry_double_kitchen_cabinet);
					content.add(stripped_cherry_glass_kitchen_cabinet);
				});
			}
		}
	}
	
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
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

			FuelRegistry.INSTANCE.add(cherry_wardrobe, 300);
			FuelRegistry.INSTANCE.add(cherry_modern_wardrobe, 300);
			FuelRegistry.INSTANCE.add(cherry_double_wardrobe, 300);
			FuelRegistry.INSTANCE.add(cherry_bookshelf, 300);
			FuelRegistry.INSTANCE.add(cherry_bookshelf_cupboard, 300);
			FuelRegistry.INSTANCE.add(cherry_drawer, 300);
			FuelRegistry.INSTANCE.add(cherry_double_drawer, 300);
			FuelRegistry.INSTANCE.add(cherry_bookshelf_drawer, 300);
			FuelRegistry.INSTANCE.add(cherry_lower_bookshelf_drawer, 300);
			FuelRegistry.INSTANCE.add(cherry_large_drawer, 300);
			FuelRegistry.INSTANCE.add(cherry_lower_triple_drawer, 300);
			FuelRegistry.INSTANCE.add(cherry_triple_drawer, 300);
			FuelRegistry.INSTANCE.add(cherry_desk, 300);
			FuelRegistry.INSTANCE.add(cherry_covered_desk, 300);
			FuelRegistry.INSTANCE.add(cherry_modern_desk, 300);
			FuelRegistry.INSTANCE.add(cherry_table, 300);
			FuelRegistry.INSTANCE.add(cherry_end_table, 300);
			FuelRegistry.INSTANCE.add(cherry_coffee_table, 300);
			FuelRegistry.INSTANCE.add(cherry_glass_table, 300);
			FuelRegistry.INSTANCE.add(cherry_chair, 300);
			FuelRegistry.INSTANCE.add(cherry_modern_chair, 300);
			FuelRegistry.INSTANCE.add(cherry_striped_chair, 300);
			FuelRegistry.INSTANCE.add(cherry_stool_chair, 300);
			FuelRegistry.INSTANCE.add(cherry_counter, 300);
			FuelRegistry.INSTANCE.add(cherry_drawer_counter, 300);
			FuelRegistry.INSTANCE.add(cherry_double_drawer_counter, 300);
			FuelRegistry.INSTANCE.add(cherry_cupboard_counter, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_wardrobe, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_modern_wardrobe, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_double_wardrobe, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_bookshelf, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_bookshelf_cupboard, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_drawer, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_double_drawer, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_bookshelf_drawer, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_lower_bookshelf_drawer, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_large_drawer, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_lower_triple_drawer, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_triple_drawer, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_desk, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_covered_desk, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_modern_desk, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_table, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_end_table, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_coffee_table, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_glass_table, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_chair, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_modern_chair, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_striped_chair, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_stool_chair, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_counter, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_drawer_counter, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_double_drawer_counter, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_cupboard_counter, 300);
			FuelRegistry.INSTANCE.add(cherry_kitchen_cabinet, 300);
			FuelRegistry.INSTANCE.add(cherry_double_kitchen_cabinet, 300);
			FuelRegistry.INSTANCE.add(cherry_glass_kitchen_cabinet, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_kitchen_cabinet, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_double_kitchen_cabinet, 300);
			FuelRegistry.INSTANCE.add(stripped_cherry_glass_kitchen_cabinet, 300);
        }
	}
}