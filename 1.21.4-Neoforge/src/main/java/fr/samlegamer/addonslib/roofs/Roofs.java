package fr.samlegamer.addonslib.roofs;

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
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Roofs
{
	private static BlockBehaviour.Properties wood = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
	private static BlockBehaviour.Properties stone = BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE);
	public static final String modid = "mcwroofs";
		
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationRockModLoaded(rock, mod, block, item, tab, "minecraft", stone);
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
		    DeferredBlock<Block> cherry_roof,
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
						cherry_roof = createBlock(mod, i+"_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_roof")))), block, item, tab, modLoaded);
						cherry_attic_roof = createBlock(mod, i + "_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_attic_roof")))), block, item, tab, modLoaded);
						cherry_top_roof = createBlock(mod, i + "_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_top_roof")))), block, item, tab, modLoaded);
						cherry_lower_roof = createBlock(mod, i+"_lower_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_roof")))), block, item, tab, modLoaded);
						cherry_steep_roof = createBlock(mod, i+"_steep_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_steep_roof")))), block, item, tab, modLoaded);
						cherry_upper_lower_roof = createBlock(mod, i + "_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_lower_roof"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_upper_steep_roof = createBlock(mod, i + "_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_steep_roof"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);

						cherry_planks_roof = createBlock(mod, i+"_planks_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_roof")))), block, item, tab, modLoaded);
						cherry_planks_attic_roof = createBlock(mod, i + "_planks_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_attic_roof")))), block, item, tab, modLoaded);
						cherry_planks_top_roof = createBlock(mod, i + "_planks_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_top_roof")))), block, item, tab, modLoaded);
						cherry_planks_lower_roof = createBlock(mod, i+"_planks_lower_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_lower_roof")))), block, item, tab, modLoaded);
						cherry_planks_steep_roof = createBlock(mod, i+"_planks_steep_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_steep_roof")))), block, item, tab, modLoaded);
						cherry_planks_upper_lower_roof = createBlock(mod, i + "_planks_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_upper_lower_roof"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
						cherry_planks_upper_steep_roof = createBlock(mod, i + "_planks_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_upper_steep_roof"))), Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
					}
					else
					{
						cherry_roof = createBlock(mod, i+"_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_roof")))), block, item, tab, modLoaded);
						cherry_attic_roof = createBlock(mod, i + "_attic_roof", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_attic_roof")))), block, item, tab, modLoaded);
						cherry_top_roof = createBlock(mod, i + "_top_roof", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_top_roof")))), block, item, tab, modLoaded);
						cherry_lower_roof = createBlock(mod, i+"_lower_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_roof")))), block, item, tab, modLoaded);
						cherry_steep_roof = createBlock(mod, i+"_steep_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_steep_roof")))), block, item, tab, modLoaded);
						cherry_upper_lower_roof = createBlock(mod, i + "_upper_lower_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_lower_roof")))), block, item, tab, modLoaded);
						cherry_upper_steep_roof = createBlock(mod, i + "_upper_steep_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_steep_roof")))), block, item, tab, modLoaded);

						cherry_planks_roof = createBlock(mod, i+"_planks_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_roof")))), block, item, tab, modLoaded);
						cherry_planks_attic_roof = createBlock(mod, i + "_planks_attic_roof", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_attic_roof")))), block, item, tab, modLoaded);
						cherry_planks_top_roof = createBlock(mod, i + "_planks_top_roof", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_top_roof")))), block, item, tab, modLoaded);
						cherry_planks_lower_roof = createBlock(mod, i+"_planks_lower_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_lower_roof")))), block, item, tab, modLoaded);
						cherry_planks_steep_roof = createBlock(mod, i+"_planks_steep_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_steep_roof")))), block, item, tab, modLoaded);
						cherry_planks_upper_lower_roof = createBlock(mod, i + "_planks_upper_lower_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_upper_lower_roof")))), block, item, tab, modLoaded);
						cherry_planks_upper_steep_roof = createBlock(mod, i + "_planks_upper_steep_roof", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_upper_steep_roof")))), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    // Gérer toute autre exception non prévue
				    e.printStackTrace();
				}
			}
			wood = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties STONE = prop;
			DeferredBlock<Block> ROOF,
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
						ROOF = createBlockStone(mod, i+"_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_roof")))), block, item, tab, modLoaded);
						ATTIC_ROOF = createBlockStone(mod, i + "_attic_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofGlass", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_attic_roof")))), block, item, tab, modLoaded);
						TOP_ROOF = createBlockStone(mod, i + "_top_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.RoofTopNew", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_top_roof")))), block, item, tab, modLoaded);
						LOWER_ROOF = createBlockStone(mod, i+"_lower_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_roof")))), block, item, tab, modLoaded);
						STEEP_ROOF = createBlockStone(mod, i+"_steep_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_steep_roof")))), block, item, tab, modLoaded);
						UPPER_LOWER_ROOF = createBlockStone(mod, i + "_upper_lower_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Lower", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_lower_roof"))), Blocks.CUT_SANDSTONE.defaultBlockState()), block, item, tab, modLoaded);
						UPPER_STEEP_ROOF = createBlockStone(mod, i + "_upper_steep_roof", () -> Registration.getBlocksField("com.mcwroofs.kikoz.objects.roofs.Steep", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_steep_roof"))), Blocks.CUT_SANDSTONE.defaultBlockState()), block, item, tab, modLoaded);
					}
					else
					{
						ROOF = createBlockStone(mod, i+"_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_roof")))), block, item, tab, modLoaded);
						ATTIC_ROOF = createBlockStone(mod, i + "_attic_roof", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_attic_roof")))), block, item, tab, modLoaded);
						TOP_ROOF = createBlockStone(mod, i + "_top_roof", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_top_roof")))), block, item, tab, modLoaded);
						LOWER_ROOF = createBlockStone(mod, i+"_lower_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_lower_roof")))), block, item, tab, modLoaded);
						STEEP_ROOF = createBlockStone(mod, i+"_steep_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_steep_roof")))), block, item, tab, modLoaded);
						UPPER_LOWER_ROOF = createBlockStone(mod, i + "_upper_lower_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_lower_roof")))), block, item, tab, modLoaded);
						UPPER_STEEP_ROOF = createBlockStone(mod, i + "_upper_steep_roof", () -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_upper_steep_roof")))), block, item, tab, modLoaded);
				    }
				} catch (Exception e)
				{
				    e.printStackTrace();
				}
			}
			stone = BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE);
	}

	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlockStone(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlockStone(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
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
	
	protected static DeferredBlock<Block> createBlockStone(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
		}
		else
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
		}
        return block;
    }
		
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
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

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : WOOD)
			{
				cherry_roof = Finder.findBlock(MODID, i+"_roof");
				cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
				cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
				cherry_lower_roof = Finder.findBlock(MODID, i+"_lower_roof");
				cherry_steep_roof = Finder.findBlock(MODID, i+"_steep_roof");
				cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
				cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");
				
	        	event.accept(cherry_roof);
	        	event.accept(cherry_attic_roof);
	        	event.accept(cherry_top_roof);
	        	event.accept(cherry_lower_roof);
	        	event.accept(cherry_steep_roof);
	        	event.accept(cherry_upper_lower_roof);
	        	event.accept(cherry_upper_steep_roof);
	        	
	        	cherry_planks_roof = Finder.findBlock(MODID, i+"_planks_roof");
				cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
				cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
				cherry_planks_lower_roof = Finder.findBlock(MODID, i+"_planks_lower_roof");
				cherry_planks_steep_roof = Finder.findBlock(MODID, i+"_planks_steep_roof");
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
		Block ROOF,
		ATTIC_ROOF,
		TOP_ROOF,
		LOWER_ROOF,
		STEEP_ROOF,
		UPPER_LOWER_ROOF,
		UPPER_STEEP_ROOF;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
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