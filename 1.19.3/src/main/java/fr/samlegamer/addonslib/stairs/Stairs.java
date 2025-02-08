package fr.samlegamer.addonslib.stairs;

import java.util.List;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryObject;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD);
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).requiresCorrectToolForDrops();
		setRegistrationRockModLoaded(set, block, item, tab, "minecraft", STONE);
	}
	
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		 final BlockBehaviour.Properties STONE = prop;
			RegistryObject<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = createBlockStone(i+"_terrace_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", STONE), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlockStone(i+"_skyline_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", STONE), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlockStone(i+"_compact_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", STONE), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlockStone(i+"_bulk_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", STONE), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlockStone(i+"_loft_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", STONE), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlockStone(i+"_railing", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", STONE), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlockStone(i+"_balcony", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", STONE), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlockStone(i+"_platform", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", STONE), block, item, tab, modLoaded);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = createBlock(i+"_terrace_stairs", () -> new Block(STONE), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlock(i+"_skyline_stairs", () -> new Block(STONE), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlock(i+"_compact_stairs", () -> new Block(STONE), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlock(i+"_bulk_stairs", () -> new Block(STONE), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlock(i+"_loft_stairs", () -> new Block(STONE), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlock(i+"_railing", () -> new Block(STONE), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlock(i+"_balcony", () -> new Block(STONE), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlock(i+"_platform", () -> new Block(STONE), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
			RegistryObject<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = createBlock(i+"_terrace_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", WOOD), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlock(i+"_skyline_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", WOOD), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlock(i+"_compact_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", WOOD), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlock(i+"_bulk_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", WOOD), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlock(i+"_loft_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", WOOD), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlock(i+"_railing", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", WOOD), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlock(i+"_balcony", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", WOOD), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlock(i+"_platform", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", WOOD), block, item, tab, modLoaded);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = createBlock(i+"_terrace_stairs", () -> new Block(WOOD), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlock(i+"_skyline_stairs", () -> new Block(WOOD), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlock(i+"_compact_stairs", () -> new Block(WOOD), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlock(i+"_bulk_stairs", () -> new Block(WOOD), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlock(i+"_loft_stairs", () -> new Block(WOOD), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlock(i+"_railing", () -> new Block(WOOD), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlock(i+"_balcony", () -> new Block(WOOD), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlock(i+"_platform", () -> new Block(WOOD), block, item, tab, modLoaded);
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
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties(), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties(), "mcwstairs.balcony.desc"));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties(), "mcwstairs.platform.desc"));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlockStone(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
		RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties(), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties(), "mcwstairs.balcony.desc"));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties(), "mcwstairs.platform.desc"));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	//Start of new registration system
	
	public static void registryWood(final NewRegistryEvent event, List<String> WOODS, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD);
		Block ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

		for(String i : WOODS)
		{
			try {
			    if (ModList.get().isLoaded(modid))
			    {
					ACACIA_TERRACE_STAIRS = createBlockWoodOpti(i+"_terrace_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", WOOD), tab);
					ACACIA_SKYLINE_STAIRS = createBlockWoodOpti(i+"_skyline_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", WOOD), tab);
					ACACIA_COMPACT_STAIRS = createBlockWoodOpti(i+"_compact_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", WOOD), tab);
					ACACIA_BULK_STAIRS = createBlockWoodOpti(i+"_bulk_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", WOOD), tab);
					ACACIA_LOFT_STAIRS = createBlockWoodOpti(i+"_loft_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", WOOD), tab);
					ACACIA_RAILING = createBlockWoodOpti(i+"_railing", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", WOOD), tab);
					ACACIA_BALCONY = createBlockWoodOpti(i+"_balcony", Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", WOOD), tab);
					ACACIA_PLATFORM = createBlockWoodOpti(i+"_platform", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", WOOD), tab);
			    }
			    else
			    {
					ACACIA_TERRACE_STAIRS = createBlockWoodOpti(i+"_terrace_stairs", new Block(WOOD), tab);
					ACACIA_SKYLINE_STAIRS = createBlockWoodOpti(i+"_skyline_stairs", new Block(WOOD), tab);
					ACACIA_COMPACT_STAIRS = createBlockWoodOpti(i+"_compact_stairs", new Block(WOOD), tab);
					ACACIA_BULK_STAIRS = createBlockWoodOpti(i+"_bulk_stairs", new Block(WOOD), tab);
					ACACIA_LOFT_STAIRS = createBlockWoodOpti(i+"_loft_stairs", new Block(WOOD), tab);
					ACACIA_RAILING = createBlockWoodOpti(i+"_railing", new Block(WOOD), tab);
					ACACIA_BALCONY = createBlockWoodOpti(i+"_balcony", new Block(WOOD), tab);
					ACACIA_PLATFORM = createBlockWoodOpti(i+"_platform", new Block(WOOD), tab);
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	}
	
	public static void registryStone(final NewRegistryEvent event, List<String> STONES, CreativeModeTab tab)
	{
	 	final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).requiresCorrectToolForDrops();
		Block ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

		for(String i : STONES)
		{
			try {
			    if (ModList.get().isLoaded(modid))
			    {
					ACACIA_TERRACE_STAIRS = createBlockStoneOpti(i+"_terrace_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", STONE), tab);
					ACACIA_SKYLINE_STAIRS = createBlockStoneOpti(i+"_skyline_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", STONE), tab);
					ACACIA_COMPACT_STAIRS = createBlockStoneOpti(i+"_compact_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", STONE), tab);
					ACACIA_BULK_STAIRS = createBlockStoneOpti(i+"_bulk_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", STONE), tab);
					ACACIA_LOFT_STAIRS = createBlockStoneOpti(i+"_loft_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", STONE), tab);
					ACACIA_RAILING = createBlockStoneOpti(i+"_railing", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", STONE), tab);
					ACACIA_BALCONY = createBlockStoneOpti(i+"_balcony", Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", STONE), tab);
					ACACIA_PLATFORM = createBlockStoneOpti(i+"_platform", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", STONE), tab);
			    }
			    else
			    {
					ACACIA_TERRACE_STAIRS = createBlockStoneOpti(i+"_terrace_stairs", new Block(STONE), tab);
					ACACIA_SKYLINE_STAIRS = createBlockStoneOpti(i+"_skyline_stairs", new Block(STONE), tab);
					ACACIA_COMPACT_STAIRS = createBlockStoneOpti(i+"_compact_stairs", new Block(STONE), tab);
					ACACIA_BULK_STAIRS = createBlockStoneOpti(i+"_bulk_stairs", new Block(STONE), tab);
					ACACIA_LOFT_STAIRS = createBlockStoneOpti(i+"_loft_stairs", new Block(STONE), tab);
					ACACIA_RAILING = createBlockStoneOpti(i+"_railing", new Block(STONE), tab);
					ACACIA_BALCONY = createBlockStoneOpti(i+"_balcony", new Block(STONE), tab);
					ACACIA_PLATFORM = createBlockStoneOpti(i+"_platform", new Block(STONE), tab);
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
	        if(name.contains("railing")) {
	        	itemBlock = new BlockItemFuelInfo(block, new Item.Properties(), "mcwstairs.railing.desc");
	        }
	        else if(name.contains("balcony")) {
	        	itemBlock = new BlockItemFuelInfo(block, new Item.Properties(), "mcwstairs.balcony.desc");
	        }
	        else if(name.contains("platform")) {
	        	itemBlock = new BlockItemFuelInfo(block, new Item.Properties(), "mcwstairs.platform.desc");
	        }
	        else {
	        	itemBlock = new BlockItemFuel(block, new Item.Properties());
	        }
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

	protected static Block createBlockStoneOpti(String name, Block block, CreativeModeTab tab)
    {
		BlockItem itemBlock;
		if(ModList.get().isLoaded(modid))
		{
	        if(name.contains("railing")) {
	        	itemBlock = new BlockItemInfo(block, new Item.Properties(), "mcwstairs.railing.desc");
	        }
	        else if(name.contains("balcony")) {
	        	itemBlock = new BlockItemInfo(block, new Item.Properties(), "mcwstairs.balcony.desc");
	        }
	        else if(name.contains("platform")) {
	        	itemBlock = new BlockItemInfo(block, new Item.Properties(), "mcwstairs.platform.desc");
	        }
	        else {
	        	itemBlock = new BlockItem(block, new Item.Properties());
	        }
		}
		else
		{
			itemBlock = new BlockItem(block, new Item.Properties());
		}
        //block.setRegistryName(name);
        //itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(name, block);
        ForgeRegistries.ITEMS.register(name, itemBlock);
        return block;
    }
	
	public static void addToTab(CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : WOOD)
			{
				_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
				_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
				_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
				_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
				_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
				_railing = Finder.findBlock(MODID, i+"_railing");
				_balcony = Finder.findBlock(MODID, i+"_balcony");
				_platform = Finder.findBlock(MODID, i+"_platform");
				
				event.accept(_terrace_stairs);
				event.accept(_skyline_stairs);
				event.accept(_compact_stairs);
				event.accept(_bulk_stairs);
				event.accept(_loft_stairs);
				event.accept(_railing);
				event.accept(_balcony);
				event.accept(_platform);
			}
   	 	}
	}
}