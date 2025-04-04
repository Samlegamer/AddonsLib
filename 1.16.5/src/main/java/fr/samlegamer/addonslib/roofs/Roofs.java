package fr.samlegamer.addonslib.roofs;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Roofs
{
	private static AbstractBlock.Properties wood = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
	private static AbstractBlock.Properties stone = AbstractBlock.Properties.copy(Blocks.COBBLESTONE);
	
	public static final String modid = "mcwroofs";
	
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", stone);
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
			final AbstractBlock.Properties WOOD = prop;
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
				    	cherry_roof = createBlock(i+"_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
			            cherry_attic_roof = createBlock(i + "_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD), block, item, tab, modLoaded);
			            cherry_top_roof = createBlock(i + "_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD), block, item, tab, modLoaded);
					    cherry_lower_roof = createBlock(i+"_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_steep_roof = createBlock(i+"_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
			            cherry_upper_lower_roof = createBlock(i + "_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
			            cherry_upper_steep_roof = createBlock(i + "_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
					    
			            cherry_planks_roof = createBlock(i+"_planks_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
			            cherry_planks_attic_roof = createBlock(i + "_planks_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD), block, item, tab, modLoaded);
			            cherry_planks_top_roof = createBlock(i + "_planks_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD), block, item, tab, modLoaded);
					    cherry_planks_lower_roof = createBlock(i+"_planks_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_planks_steep_roof = createBlock(i+"_planks_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
			            cherry_planks_upper_lower_roof = createBlock(i + "_planks_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
			            cherry_planks_upper_steep_roof = createBlock(i + "_planks_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
				    }
				    else
				    {
				    	cherry_roof = createBlock(i+"_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_attic_roof = createBlock(i+"_attic_roof", () -> new Block(WOOD), block, item, tab, modLoaded);
					    cherry_top_roof = createBlock(i+"_top_roof", () -> new Block(WOOD), block, item, tab, modLoaded);
					    cherry_lower_roof = createBlock(i+"_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_steep_roof = createBlock(i+"_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_upper_lower_roof = createBlock(i+"_upper_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_upper_steep_roof = createBlock(i+"_upper_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);

					    cherry_planks_roof = createBlock(i+"_planks_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_planks_attic_roof = createBlock(i+"_planks_attic_roof", () -> new Block(WOOD), block, item, tab, modLoaded);
					    cherry_planks_top_roof = createBlock(i+"_planks_top_roof", () -> new Block(WOOD), block, item, tab, modLoaded);
					    cherry_planks_lower_roof = createBlock(i+"_planks_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_planks_steep_roof = createBlock(i+"_planks_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab, modLoaded);
					    cherry_planks_upper_lower_roof = createBlock(i+"_planks_upper_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item, tab, modLoaded);
					    cherry_planks_upper_steep_roof = createBlock(i+"_planks_upper_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
			final AbstractBlock.Properties STONE = prop;
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
				    	ROOF = createBlock(i+"_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
			            ATTIC_ROOF = createBlock(i + "_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", STONE), block, item, tab, modLoaded);
			            TOP_ROOF = createBlock(i + "_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", STONE), block, item, tab, modLoaded);
			            LOWER_ROOF = createBlock(i+"_lower_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
			            STEEP_ROOF = createBlock(i+"_steep_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
			            UPPER_LOWER_ROOF = createBlock(i + "_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", STONE, Blocks.CUT_SANDSTONE.defaultBlockState()), block, item, tab, modLoaded);
			            UPPER_STEEP_ROOF = createBlock(i + "_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", STONE, Blocks.CUT_SANDSTONE.defaultBlockState()), block, item, tab, modLoaded);
				    }
				    else
				    {
				    	ROOF = createBlock(i+"_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
				    	ATTIC_ROOF = createBlock(i+"_attic_roof", () -> new Block(STONE), block, item, tab, modLoaded);
					    TOP_ROOF = createBlock(i+"_top_roof", () -> new Block(STONE), block, item, tab, modLoaded);
					    LOWER_ROOF = createBlock(i+"_lower_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
					    STEEP_ROOF = createBlock(i+"_steep_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
					    UPPER_LOWER_ROOF = createBlock(i+"_upper_lower_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
					    UPPER_STEEP_ROOF = createBlock(i+"_upper_steep_roof", () -> new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), block, item, tab, modLoaded);
				    }
				} catch (Exception e)
				{
				    e.printStackTrace();
				}
			}
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        return createBlockStone(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
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
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
		}
		else
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	protected static Block createBlockWoodOpti(String name, Block block, ItemGroup tab)
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
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }

	protected static Block createBlockStoneOpti(String name, Block block, ItemGroup tab)
    {
		BlockItem itemBlock;
        if(ModList.get().isLoaded(modid))
        {
        	itemBlock = new BlockItem(block, new Item.Properties().tab(tab));
        }
		else
		{
			itemBlock = new BlockItem(block, new Item.Properties());
		}
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }
	
	public static void registryWood(final RegistryEvent.Register<Block> event, List<String> set, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = wood;
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

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	cherry_roof = createBlockWoodOpti(i+"_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
			            cherry_attic_roof = createBlockWoodOpti(i + "_attic_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD), tab);
			            cherry_top_roof = createBlockWoodOpti(i + "_top_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD), tab);
					    cherry_lower_roof = createBlockWoodOpti(i+"_lower_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_steep_roof = createBlockWoodOpti(i+"_steep_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
			            cherry_upper_lower_roof = createBlockWoodOpti(i + "_upper_lower_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
			            cherry_upper_steep_roof = createBlockWoodOpti(i + "_upper_steep_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
					    
			            cherry_planks_roof = createBlockWoodOpti(i+"_planks_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
			            cherry_planks_attic_roof = createBlockWoodOpti(i + "_planks_attic_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD), tab);
			            cherry_planks_top_roof = createBlockWoodOpti(i + "_planks_top_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD), tab);
					    cherry_planks_lower_roof = createBlockWoodOpti(i+"_planks_lower_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_planks_steep_roof = createBlockWoodOpti(i+"_planks_steep_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
			            cherry_planks_upper_lower_roof = createBlockWoodOpti(i + "_planks_upper_lower_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
			            cherry_planks_upper_steep_roof = createBlockWoodOpti(i + "_planks_upper_steep_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
				    }
				    else
				    {
				    	cherry_roof = createBlockWoodOpti(i+"_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_attic_roof = createBlockWoodOpti(i+"_attic_roof", new Block(WOOD), tab);
					    cherry_top_roof = createBlockWoodOpti(i+"_top_roof", new Block(WOOD), tab);
					    cherry_lower_roof = createBlockWoodOpti(i+"_lower_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_steep_roof = createBlockWoodOpti(i+"_steep_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_upper_lower_roof = createBlockWoodOpti(i+"_upper_lower_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_upper_steep_roof = createBlockWoodOpti(i+"_upper_steep_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);

					    cherry_planks_roof = createBlockWoodOpti(i+"_planks_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_planks_attic_roof = createBlockWoodOpti(i+"_planks_attic_roof", new Block(WOOD), tab);
					    cherry_planks_top_roof = createBlockWoodOpti(i+"_planks_top_roof", new Block(WOOD), tab);
					    cherry_planks_lower_roof = createBlockWoodOpti(i+"_planks_lower_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_planks_steep_roof = createBlockWoodOpti(i+"_planks_steep_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), tab);
					    cherry_planks_upper_lower_roof = createBlockWoodOpti(i+"_planks_upper_lower_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), tab);
					    cherry_planks_upper_steep_roof = createBlockWoodOpti(i+"_planks_upper_steep_roof", new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), tab);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
			wood = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
	}
	
	public static void registryStone(final RegistryEvent.Register<Block> event, List<String> rock, ItemGroup tab)
	{
			final AbstractBlock.Properties STONE = stone;
			Block ROOF,
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
				    	ROOF = createBlockStoneOpti(i+"_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
			            ATTIC_ROOF = createBlockStoneOpti(i + "_attic_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", STONE), tab);
			            TOP_ROOF = createBlockStoneOpti(i + "_top_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", STONE), tab);
			            LOWER_ROOF = createBlockStoneOpti(i+"_lower_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
			            STEEP_ROOF = createBlockStoneOpti(i+"_steep_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
			            UPPER_LOWER_ROOF = createBlockStoneOpti(i + "_upper_lower_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", STONE, Blocks.CUT_SANDSTONE.defaultBlockState()), tab);
			            UPPER_STEEP_ROOF = createBlockStoneOpti(i + "_upper_steep_roof", Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", STONE, Blocks.CUT_SANDSTONE.defaultBlockState()), tab);
				    }
				    else
				    {
				    	ROOF = createBlockStoneOpti(i+"_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
				    	ATTIC_ROOF = createBlockStoneOpti(i+"_attic_roof", new Block(STONE), tab);
					    TOP_ROOF = createBlockStoneOpti(i+"_top_roof", new Block(STONE), tab);
					    LOWER_ROOF = createBlockStoneOpti(i+"_lower_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
					    STEEP_ROOF = createBlockStoneOpti(i+"_steep_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
					    UPPER_LOWER_ROOF = createBlockStoneOpti(i+"_upper_lower_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
					    UPPER_STEEP_ROOF = createBlockStoneOpti(i+"_upper_steep_roof", new StairsBlock(()->Blocks.CUT_SANDSTONE.defaultBlockState(), STONE), tab);
				    }
				} catch (Exception e)
				{
				    e.printStackTrace();
				}
			}
			stone = AbstractBlock.Properties.copy(Blocks.CUT_SANDSTONE);
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
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

		for (String i : WOOD)
		{
			cherry_roof = Finder.findBlock(MODID, i+"_roof");
			cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
			cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
			cherry_lower_roof = Finder.findBlock(MODID, i+"_lower_roof");
			cherry_steep_roof = Finder.findBlock(MODID, i+"_steep_roof");
			cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
			cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");
			
        	RenderTypeLookup.setRenderLayer(cherry_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_attic_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_top_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_steep_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_upper_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_upper_steep_roof, renderSet);
        	
        	cherry_planks_roof = Finder.findBlock(MODID, i+"_planks_roof");
			cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
			cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
			cherry_planks_lower_roof = Finder.findBlock(MODID, i+"_planks_lower_roof");
			cherry_planks_steep_roof = Finder.findBlock(MODID, i+"_planks_steep_roof");
			cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
			cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");
			
        	RenderTypeLookup.setRenderLayer(cherry_planks_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_attic_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_top_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_steep_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_upper_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_upper_steep_roof, renderSet);
        }
	}
	
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}
	
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
	{
		Block ROOF,
		ATTIC_ROOF,
		TOP_ROOF,
		LOWER_ROOF,
		STEEP_ROOF,
		UPPER_LOWER_ROOF,
		UPPER_STEEP_ROOF;

		for (String i : STONE)
		{
			ROOF = Finder.findBlock(MODID, i + "_roof");
			ATTIC_ROOF = Finder.findBlock(MODID, i + "_attic_roof");
			TOP_ROOF = Finder.findBlock(MODID, i + "_top_roof");
			LOWER_ROOF = Finder.findBlock(MODID, i + "_lower_roof");
			STEEP_ROOF = Finder.findBlock(MODID, i + "_steep_roof");
			UPPER_LOWER_ROOF = Finder.findBlock(MODID, i + "_upper_lower_roof");
			UPPER_STEEP_ROOF = Finder.findBlock(MODID, i + "_upper_steep_roof");

        	RenderTypeLookup.setRenderLayer(ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(ATTIC_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(TOP_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(LOWER_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(STEEP_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(UPPER_LOWER_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(UPPER_STEEP_ROOF, renderSet);
        }
	}
}