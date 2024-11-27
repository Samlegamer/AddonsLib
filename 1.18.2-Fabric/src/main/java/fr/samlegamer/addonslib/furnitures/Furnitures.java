package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	
	private static Block registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
    	}
    	else {
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
    	
    	return b;
	}
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Settings WOOD = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);

			for(String i : set)
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
				
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	cherry_wardrobe = registryEntry(MODID, i+"_wardrobe", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD), tab, modLoaded);
						cherry_modern_wardrobe = registryEntry(MODID, i+"_modern_wardrobe", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD), tab, modLoaded);
						cherry_double_wardrobe = registryEntry(MODID, i+"_double_wardrobe", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD), tab, modLoaded);
						cherry_bookshelf = registryEntry(MODID, i+"_bookshelf", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD), tab, modLoaded);
						cherry_bookshelf_cupboard = registryEntry(MODID, i+"_bookshelf_cupboard", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD), tab, modLoaded);
						cherry_drawer = registryEntry(MODID, i+"_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						cherry_double_drawer = registryEntry(MODID, i+"_double_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						cherry_bookshelf_drawer = registryEntry(MODID, i+"_bookshelf_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						cherry_lower_bookshelf_drawer = registryEntry(MODID, i+"_lower_bookshelf_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						cherry_large_drawer = registryEntry(MODID, i+"_large_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						cherry_lower_triple_drawer = registryEntry(MODID, i+"_lower_triple_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						cherry_triple_drawer = registryEntry(MODID, i+"_triple_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						cherry_desk = registryEntry(MODID, i+"_desk", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD), tab, modLoaded);
						cherry_covered_desk = registryEntry(MODID, i+"_covered_desk", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD), tab, modLoaded);
						cherry_modern_desk = registryEntry(MODID, i+"_modern_desk", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD), tab, modLoaded);
						cherry_table = registryEntry(MODID, i+"_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD), tab, modLoaded);
						cherry_end_table = registryEntry(MODID, i+"_end_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD), tab, modLoaded);
						cherry_coffee_table = registryEntry(MODID, i+"_coffee_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Table", WOOD), tab, modLoaded);
						cherry_glass_table = registryEntry(MODID, i+"_glass_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD), tab, modLoaded);
						cherry_chair = registryEntry(MODID, i+"_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD), tab, modLoaded);
						cherry_modern_chair = registryEntry(MODID, i+"_modern_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.ModernChair", WOOD), tab, modLoaded);
						cherry_striped_chair = registryEntry(MODID, i+"_striped_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD), tab, modLoaded);
						cherry_stool_chair = registryEntry(MODID, i+"_stool_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Chair", WOOD), tab, modLoaded);
						cherry_counter = registryEntry(MODID, i+"_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.Counter", WOOD), tab, modLoaded);
						cherry_drawer_counter = registryEntry(MODID, i+"_drawer_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD), tab, modLoaded);
						cherry_double_drawer_counter = registryEntry(MODID, i+"_double_drawer_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD), tab, modLoaded);
						cherry_cupboard_counter = registryEntry(MODID, i+"_cupboard_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.CupboardCounter", WOOD), tab, modLoaded);
						
						stripped_cherry_wardrobe = registryEntry(MODID, "stripped_"+i+"_wardrobe", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD), tab, modLoaded);
						stripped_cherry_modern_wardrobe = registryEntry(MODID, "stripped_"+i+"_modern_wardrobe", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD), tab, modLoaded);
						stripped_cherry_double_wardrobe = registryEntry(MODID, "stripped_"+i+"_double_wardrobe", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD), tab, modLoaded);
						stripped_cherry_bookshelf = registryEntry(MODID, "stripped_"+i+"_bookshelf", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurniture", WOOD), tab, modLoaded);
						stripped_cherry_bookshelf_cupboard = registryEntry(MODID, "stripped_"+i+"_bookshelf_cupboard", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TallFurnitureHinge", WOOD), tab, modLoaded);
						stripped_cherry_drawer = registryEntry(MODID, "stripped_"+i+"_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						stripped_cherry_double_drawer = registryEntry(MODID, "stripped_"+i+"_double_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						stripped_cherry_bookshelf_drawer = registryEntry(MODID, "stripped_"+i+"_bookshelf_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						stripped_cherry_lower_bookshelf_drawer = registryEntry(MODID, "stripped_"+i+"_lower_bookshelf_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						stripped_cherry_large_drawer = registryEntry(MODID, "stripped_"+i+"_large_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						stripped_cherry_lower_triple_drawer = registryEntry(MODID, "stripped_"+i+"_lower_triple_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						stripped_cherry_triple_drawer = registryEntry(MODID, "stripped_"+i+"_triple_drawer", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.WideFurniture", WOOD), tab, modLoaded);
						stripped_cherry_desk = registryEntry(MODID, "stripped_"+i+"_desk", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD), tab, modLoaded);
						stripped_cherry_covered_desk = registryEntry(MODID, "stripped_"+i+"_covered_desk", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD), tab, modLoaded);
						stripped_cherry_modern_desk = registryEntry(MODID, "stripped_"+i+"_modern_desk", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Desk", WOOD), tab, modLoaded);
						stripped_cherry_table = registryEntry(MODID, "stripped_"+i+"_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD), tab, modLoaded);
						stripped_cherry_end_table = registryEntry(MODID, "stripped_"+i+"_end_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD), tab, modLoaded);
						stripped_cherry_coffee_table = registryEntry(MODID, "stripped_"+i+"_coffee_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Table", WOOD), tab, modLoaded);
						stripped_cherry_glass_table = registryEntry(MODID, "stripped_"+i+"_glass_table", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.TableHitbox", WOOD), tab, modLoaded);
						stripped_cherry_chair = registryEntry(MODID, "stripped_"+i+"_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD), tab, modLoaded);
						stripped_cherry_modern_chair = registryEntry(MODID, "stripped_"+i+"_modern_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.ModernChair", WOOD), tab, modLoaded);
						stripped_cherry_striped_chair = registryEntry(MODID, "stripped_"+i+"_striped_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.chairs.StripedChair", WOOD), tab, modLoaded);
						stripped_cherry_stool_chair = registryEntry(MODID, "stripped_"+i+"_stool_chair", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.Chair", WOOD), tab, modLoaded);
						stripped_cherry_counter = registryEntry(MODID, "stripped_"+i+"_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.Counter", WOOD), tab, modLoaded);
						stripped_cherry_drawer_counter = registryEntry(MODID, "stripped_"+i+"_drawer_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD), tab, modLoaded);
						stripped_cherry_double_drawer_counter = registryEntry(MODID, "stripped_"+i+"_double_drawer_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.StorageCounter", WOOD), tab, modLoaded);
						stripped_cherry_cupboard_counter = registryEntry(MODID, "stripped_"+i+"_cupboard_counter", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.counters.CupboardCounter", WOOD), tab, modLoaded);
						cherry_kitchen_cabinet = registryEntry(MODID, i+"_kitchen_cabinet", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.CabinetHinge", WOOD), tab, modLoaded);
						cherry_double_kitchen_cabinet = registryEntry(MODID, i+"_double_kitchen_cabinet", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD), tab, modLoaded);
						cherry_glass_kitchen_cabinet = registryEntry(MODID, i+"_glass_kitchen_cabinet", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD), tab, modLoaded);
						stripped_cherry_kitchen_cabinet = registryEntry(MODID, "stripped_"+i+"_kitchen_cabinet", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.CabinetHinge", WOOD), tab, modLoaded);
						stripped_cherry_double_kitchen_cabinet = registryEntry(MODID, "stripped_"+i+"_double_kitchen_cabinet", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD), tab, modLoaded);
						stripped_cherry_glass_kitchen_cabinet = registryEntry(MODID, "stripped_"+i+"_glass_kitchen_cabinet", Registration.getBlocksField("net.kikoz.mcwfurnitures.objects.cabinets.Cabinet", WOOD), tab, modLoaded);
				    }
				    else
				    {
						cherry_wardrobe = registryEntry(MODID, i+"_wardrobe", new Block(WOOD), tab, modLoaded);
						cherry_modern_wardrobe = registryEntry(MODID, i+"_modern_wardrobe", new Block(WOOD), tab, modLoaded);
						cherry_double_wardrobe = registryEntry(MODID, i+"_double_wardrobe", new Block(WOOD), tab, modLoaded);
						cherry_bookshelf = registryEntry(MODID, i+"_bookshelf", new Block(WOOD), tab, modLoaded);
						cherry_bookshelf_cupboard = registryEntry(MODID, i+"_bookshelf_cupboard", new Block(WOOD), tab, modLoaded);
						cherry_drawer = registryEntry(MODID, i+"_drawer", new Block(WOOD), tab, modLoaded);
						cherry_double_drawer = registryEntry(MODID, i+"_double_drawer", new Block(WOOD), tab, modLoaded);
						cherry_bookshelf_drawer = registryEntry(MODID, i+"_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						cherry_lower_bookshelf_drawer = registryEntry(MODID, i+"_lower_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						cherry_large_drawer = registryEntry(MODID, i+"_large_drawer", new Block(WOOD), tab, modLoaded);
						cherry_lower_triple_drawer = registryEntry(MODID, i+"_lower_triple_drawer", new Block(WOOD), tab, modLoaded);
						cherry_triple_drawer = registryEntry(MODID, i+"_triple_drawer", new Block(WOOD), tab, modLoaded);
						cherry_desk = registryEntry(MODID, i+"_desk", new Block(WOOD), tab, modLoaded);
						cherry_covered_desk = registryEntry(MODID, i+"_covered_desk", new Block(WOOD), tab, modLoaded);
						cherry_modern_desk = registryEntry(MODID, i+"_modern_desk", new Block(WOOD), tab, modLoaded);
						cherry_table = registryEntry(MODID, i+"_table", new Block(WOOD), tab, modLoaded);
						cherry_end_table = registryEntry(MODID, i+"_end_table", new Block(WOOD), tab, modLoaded);
						cherry_coffee_table = registryEntry(MODID, i+"_coffee_table", new Block(WOOD), tab, modLoaded);
						cherry_glass_table = registryEntry(MODID, i+"_glass_table", new Block(WOOD), tab, modLoaded);
						cherry_chair = registryEntry(MODID, i+"_chair", new Block(WOOD), tab, modLoaded);
						cherry_modern_chair = registryEntry(MODID, i+"_modern_chair", new Block(WOOD), tab, modLoaded);
						cherry_striped_chair = registryEntry(MODID, i+"_striped_chair", new Block(WOOD), tab, modLoaded);
						cherry_stool_chair = registryEntry(MODID, i+"_stool_chair", new Block(WOOD), tab, modLoaded);
						cherry_counter = registryEntry(MODID, i+"_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						cherry_drawer_counter = registryEntry(MODID, i+"_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						cherry_double_drawer_counter = registryEntry(MODID, i+"_double_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						cherry_cupboard_counter = registryEntry(MODID, i+"_cupboard_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						
						stripped_cherry_wardrobe = registryEntry(MODID, "stripped_"+i+"_wardrobe", new Block(WOOD), tab, modLoaded);
						stripped_cherry_modern_wardrobe = registryEntry(MODID, "stripped_"+i+"_modern_wardrobe", new Block(WOOD), tab, modLoaded);
						stripped_cherry_double_wardrobe = registryEntry(MODID, "stripped_"+i+"_double_wardrobe", new Block(WOOD), tab, modLoaded);
						stripped_cherry_bookshelf = registryEntry(MODID, "stripped_"+i+"_bookshelf", new Block(WOOD), tab, modLoaded);
						stripped_cherry_bookshelf_cupboard = registryEntry(MODID, "stripped_"+i+"_bookshelf_cupboard", new Block(WOOD), tab, modLoaded);
						stripped_cherry_drawer = registryEntry(MODID, "stripped_"+i+"_drawer", new Block(WOOD), tab, modLoaded);
						stripped_cherry_double_drawer = registryEntry(MODID, "stripped_"+i+"_double_drawer", new Block(WOOD), tab, modLoaded);
						stripped_cherry_bookshelf_drawer = registryEntry(MODID, "stripped_"+i+"_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						stripped_cherry_lower_bookshelf_drawer = registryEntry(MODID, "stripped_"+i+"_lower_bookshelf_drawer", new Block(WOOD), tab, modLoaded);
						stripped_cherry_large_drawer = registryEntry(MODID, "stripped_"+i+"_large_drawer", new Block(WOOD), tab, modLoaded);
						stripped_cherry_lower_triple_drawer = registryEntry(MODID, "stripped_"+i+"_lower_triple_drawer", new Block(WOOD), tab, modLoaded);
						stripped_cherry_triple_drawer = registryEntry(MODID, "stripped_"+i+"_triple_drawer", new Block(WOOD), tab, modLoaded);
						stripped_cherry_desk = registryEntry(MODID, "stripped_"+i+"_desk", new Block(WOOD), tab, modLoaded);
						stripped_cherry_covered_desk = registryEntry(MODID, "stripped_"+i+"_covered_desk", new Block(WOOD), tab, modLoaded);
						stripped_cherry_modern_desk = registryEntry(MODID, "stripped_"+i+"_modern_desk", new Block(WOOD), tab, modLoaded);
						stripped_cherry_table = registryEntry(MODID, "stripped_"+i+"_table", new Block(WOOD), tab, modLoaded);
						stripped_cherry_end_table = registryEntry(MODID, "stripped_"+i+"_end_table", new Block(WOOD), tab, modLoaded);
						stripped_cherry_coffee_table = registryEntry(MODID, "stripped_"+i+"_coffee_table", new Block(WOOD), tab, modLoaded);
						stripped_cherry_glass_table = registryEntry(MODID, "stripped_"+i+"_glass_table", new Block(WOOD), tab, modLoaded);
						stripped_cherry_chair = registryEntry(MODID, "stripped_"+i+"_chair", new Block(WOOD), tab, modLoaded);
						stripped_cherry_modern_chair = registryEntry(MODID, "stripped_"+i+"_modern_chair", new Block(WOOD), tab, modLoaded);
						stripped_cherry_striped_chair = registryEntry(MODID, "stripped_"+i+"_striped_chair", new Block(WOOD), tab, modLoaded);
						stripped_cherry_stool_chair = registryEntry(MODID, "stripped_"+i+"_stool_chair", new Block(WOOD), tab, modLoaded);
						stripped_cherry_counter = registryEntry(MODID, "stripped_"+i+"_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						stripped_cherry_drawer_counter = registryEntry(MODID, "stripped_"+i+"_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						stripped_cherry_double_drawer_counter = registryEntry(MODID, "stripped_"+i+"_double_drawer_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						stripped_cherry_cupboard_counter = registryEntry(MODID, "stripped_"+i+"_cupboard_counter", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						cherry_kitchen_cabinet = registryEntry(MODID, i+"_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						cherry_double_kitchen_cabinet = registryEntry(MODID, i+"_double_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						cherry_glass_kitchen_cabinet = registryEntry(MODID, i+"_glass_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						stripped_cherry_kitchen_cabinet = registryEntry(MODID, "stripped_"+i+"_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						stripped_cherry_double_kitchen_cabinet = registryEntry(MODID, "stripped_"+i+"_double_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
						stripped_cherry_glass_kitchen_cabinet = registryEntry(MODID, "stripped_"+i+"_glass_kitchen_cabinet", new StairsBlock(Blocks.OAK_LOG.getDefaultState(), WOOD), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}
	
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
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

			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, 
			cherry_wardrobe,
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
			stripped_cherry_glass_kitchen_cabinet);
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