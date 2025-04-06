package fr.samlegamer.addonslib.roofs;

import java.util.List;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
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
import net.minecraftforge.registries.RegistryObject;

public class Roofs
{
	private static final BlockBehaviour.Properties wood = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
	private static final BlockBehaviour.Properties stone = BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE);
	public static final String modid = "mcwroofs";
		
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationRockModLoaded(rock, block, item, stone);
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
		    RegistryObject<Block> cherry_roof,
			cherry_attic_roof,
			cherry_top_roof,
			cherry_lower_roof,
			cherry_steep_roof,
			cherry_upper_lower_roof,
			cherry_upper_steep_roof,
			cherry_planks_roof,
			cherry_planks_attic_roof,
			cherry_planks_top_roof,
			cherry_planks_lower_roof,
			cherry_planks_steep_roof,
			cherry_planks_upper_lower_roof,
			cherry_planks_upper_steep_roof;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	cherry_roof = createBlock(i+"_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
			            cherry_attic_roof = createBlock(i + "_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD), block, item);
			            cherry_top_roof = createBlock(i + "_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD), block, item);
					    cherry_lower_roof = createBlock(i+"_lower_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_steep_roof = createBlock(i+"_steep_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
			            cherry_upper_lower_roof = createBlock(i + "_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
			            cherry_upper_steep_roof = createBlock(i + "_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
					    
			            cherry_planks_roof = createBlock(i+"_planks_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
			            cherry_planks_attic_roof = createBlock(i + "_planks_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD), block, item);
			            cherry_planks_top_roof = createBlock(i + "_planks_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD), block, item);
					    cherry_planks_lower_roof = createBlock(i+"_planks_lower_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_planks_steep_roof = createBlock(i+"_planks_steep_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
			            cherry_planks_upper_lower_roof = createBlock(i + "_planks_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
			            cherry_planks_upper_steep_roof = createBlock(i + "_planks_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item);
				    }
				    else
				    {
				    	cherry_roof = createBlock(i+"_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_attic_roof = createBlock(i+"_attic_roof", () -> new Block(WOOD), block, item);
					    cherry_top_roof = createBlock(i+"_top_roof", () -> new Block(WOOD), block, item);
					    cherry_lower_roof = createBlock(i+"_lower_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_steep_roof = createBlock(i+"_steep_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_upper_lower_roof = createBlock(i+"_upper_lower_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_upper_steep_roof = createBlock(i+"_upper_steep_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);

					    cherry_planks_roof = createBlock(i+"_planks_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_planks_attic_roof = createBlock(i+"_planks_attic_roof", () -> new Block(WOOD), block, item);
					    cherry_planks_top_roof = createBlock(i+"_planks_top_roof", () -> new Block(WOOD), block, item);
					    cherry_planks_lower_roof = createBlock(i+"_planks_lower_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_planks_steep_roof = createBlock(i+"_planks_steep_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item);
					    cherry_planks_upper_lower_roof = createBlock(i+"_planks_upper_lower_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item);
					    cherry_planks_upper_steep_roof = createBlock(i+"_planks_upper_steep_roof", () -> new StairBlock(()->Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties STONE = prop;
			RegistryObject<Block> ROOF,
			ATTIC_ROOF,
			TOP_ROOF,
			LOWER_ROOF,
			STEEP_ROOF,
			UPPER_LOWER_ROOF,
			UPPER_STEEP_ROOF;

			for(String i : rock)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	ROOF = createBlockStone(i+"_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
			            ATTIC_ROOF = createBlockStone(i + "_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", STONE), block, item);
			            TOP_ROOF = createBlockStone(i + "_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", STONE), block, item);
			            LOWER_ROOF = createBlockStone(i+"_lower_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
			            STEEP_ROOF = createBlockStone(i+"_steep_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
			            UPPER_LOWER_ROOF = createBlockStone(i + "_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", STONE, Blocks.CUT_SANDSTONE.defaultBlockState()), block, item);
			            UPPER_STEEP_ROOF = createBlockStone(i + "_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", STONE, Blocks.CUT_SANDSTONE.defaultBlockState()), block, item);
				    }
				    else
				    {
				    	ROOF = createBlockStone(i+"_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
				    	ATTIC_ROOF = createBlockStone(i+"_attic_roof", () -> new Block(STONE), block, item);
					    TOP_ROOF = createBlockStone(i+"_top_roof", () -> new Block(STONE), block, item);
					    LOWER_ROOF = createBlockStone(i+"_lower_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
					    STEEP_ROOF = createBlockStone(i+"_steep_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
					    UPPER_LOWER_ROOF = createBlockStone(i+"_upper_lower_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
					    UPPER_STEEP_ROOF = createBlockStone(i+"_upper_steep_roof", () -> new StairBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        return block;
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		addToTabModLoaded(event, MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded)
	{
		Block cherry_roof,
		cherry_attic_roof,
		cherry_top_roof,
		cherry_lower_roof,
		cherry_steep_roof,
		cherry_upper_lower_roof,
		cherry_upper_steep_roof,
		cherry_planks_roof,
		cherry_planks_attic_roof,
		cherry_planks_top_roof,
		cherry_planks_lower_roof,
		cherry_planks_steep_roof,
		cherry_planks_upper_lower_roof,
		cherry_planks_upper_steep_roof;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
			for (String i : WOOD)
			{
				cherry_roof = Finder.findBlock(MODID, i + "_roof");
				cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
				cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
				cherry_lower_roof = Finder.findBlock(MODID, i + "_lower_roof");
				cherry_steep_roof = Finder.findBlock(MODID, i + "_steep_roof");
				cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
				cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");

				event.accept(cherry_roof);
				event.accept(cherry_attic_roof);
				event.accept(cherry_top_roof);
				event.accept(cherry_lower_roof);
				event.accept(cherry_steep_roof);
				event.accept(cherry_upper_lower_roof);
				event.accept(cherry_upper_steep_roof);

				cherry_planks_roof = Finder.findBlock(MODID, i + "_planks_roof");
				cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
				cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
				cherry_planks_lower_roof = Finder.findBlock(MODID, i + "_planks_lower_roof");
				cherry_planks_steep_roof = Finder.findBlock(MODID, i + "_planks_steep_roof");
				cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
				cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");

				event.accept(cherry_planks_roof);
				event.accept(cherry_planks_attic_roof);
				event.accept(cherry_planks_top_roof);
				event.accept(cherry_planks_lower_roof);
				event.accept(cherry_planks_steep_roof);
				event.accept(cherry_planks_upper_lower_roof);
				event.accept(cherry_planks_upper_steep_roof);
			}
		}
	}
	
	public static void addToTabStone(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab)
	{
		addToTabStoneModLoaded(event, MODID, STONE, tab, "minecraft");
	}
	
	public static void addToTabStoneModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab, String modLoaded)
	{
		Block ROOF,
		ATTIC_ROOF,
		TOP_ROOF,
		LOWER_ROOF,
		STEEP_ROOF,
		UPPER_LOWER_ROOF,
		UPPER_STEEP_ROOF;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
   	 	{
			for (String i : STONE)
			{
				ROOF = Finder.findBlock(MODID, i + "_roof");
				ATTIC_ROOF = Finder.findBlock(MODID, i + "_attic_roof");
				TOP_ROOF = Finder.findBlock(MODID, i + "_top_roof");
				LOWER_ROOF = Finder.findBlock(MODID, i + "_lower_roof");
				STEEP_ROOF = Finder.findBlock(MODID, i + "_steep_roof");
				UPPER_LOWER_ROOF = Finder.findBlock(MODID, i + "_upper_lower_roof");
				UPPER_STEEP_ROOF = Finder.findBlock(MODID, i + "_upper_steep_roof");
	
	        	event.accept(ROOF);
	        	event.accept(ATTIC_ROOF);
	        	event.accept(TOP_ROOF);
	        	event.accept(LOWER_ROOF);
	        	event.accept(STEEP_ROOF);
	        	event.accept(UPPER_LOWER_ROOF);
	        	event.accept(UPPER_STEEP_ROOF);
	        }
   	 	}
	}
}