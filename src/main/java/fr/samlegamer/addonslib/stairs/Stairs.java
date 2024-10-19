package fr.samlegamer.addonslib.stairs;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);
			RegistryObject<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = createBlock(i+"_terrace_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", WOOD), block, item, tab);
						ACACIA_SKYLINE_STAIRS = createBlock(i+"_skyline_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", WOOD), block, item, tab);
						ACACIA_COMPACT_STAIRS = createBlock(i+"_compact_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", WOOD), block, item, tab);
						ACACIA_BULK_STAIRS = createBlock(i+"_bulk_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", WOOD), block, item, tab);
						ACACIA_LOFT_STAIRS = createBlock(i+"_loft_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", WOOD), block, item, tab);
						ACACIA_RAILING = createBlock(i+"_railing", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", WOOD), block, item, tab);
						ACACIA_BALCONY = createBlock(i+"_balcony", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", WOOD), block, item, tab);
						ACACIA_PLATFORM = createBlock(i+"_platform", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", WOOD), block, item, tab);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = createBlock(i+"_terrace_stairs", () -> new Block(WOOD), block, item, tab);
						ACACIA_SKYLINE_STAIRS = createBlock(i+"_skyline_stairs", () -> new Block(WOOD), block, item, tab);
						ACACIA_COMPACT_STAIRS = createBlock(i+"_compact_stairs", () -> new Block(WOOD), block, item, tab);
						ACACIA_BULK_STAIRS = createBlock(i+"_bulk_stairs", () -> new Block(WOOD), block, item, tab);
						ACACIA_LOFT_STAIRS = createBlock(i+"_loft_stairs", () -> new Block(WOOD), block, item, tab);
						ACACIA_RAILING = createBlock(i+"_railing", () -> new Block(WOOD), block, item, tab);
						ACACIA_BALCONY = createBlock(i+"_balcony", () -> new Block(WOOD), block, item, tab);
						ACACIA_PLATFORM = createBlock(i+"_platform", () -> new Block(WOOD), block, item, tab);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}

	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		 	final AbstractBlock.Properties STONE = AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops();
			RegistryObject<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = createBlockStone(i+"_terrace_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", STONE), block, item, tab);
						ACACIA_SKYLINE_STAIRS = createBlockStone(i+"_skyline_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", STONE), block, item, tab);
						ACACIA_COMPACT_STAIRS = createBlockStone(i+"_compact_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", STONE), block, item, tab);
						ACACIA_BULK_STAIRS = createBlockStone(i+"_bulk_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", STONE), block, item, tab);
						ACACIA_LOFT_STAIRS = createBlockStone(i+"_loft_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", STONE), block, item, tab);
						ACACIA_RAILING = createBlockStone(i+"_railing", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", STONE), block, item, tab);
						ACACIA_BALCONY = createBlockStone(i+"_balcony", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", STONE), block, item, tab);
						ACACIA_PLATFORM = createBlockStone(i+"_platform", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", STONE), block, item, tab);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = createBlock(i+"_terrace_stairs", () -> new Block(STONE), block, item, tab);
						ACACIA_SKYLINE_STAIRS = createBlock(i+"_skyline_stairs", () -> new Block(STONE), block, item, tab);
						ACACIA_COMPACT_STAIRS = createBlock(i+"_compact_stairs", () -> new Block(STONE), block, item, tab);
						ACACIA_BULK_STAIRS = createBlock(i+"_bulk_stairs", () -> new Block(STONE), block, item, tab);
						ACACIA_LOFT_STAIRS = createBlock(i+"_loft_stairs", () -> new Block(STONE), block, item, tab);
						ACACIA_RAILING = createBlock(i+"_railing", () -> new Block(STONE), block, item, tab);
						ACACIA_BALCONY = createBlock(i+"_balcony", () -> new Block(STONE), block, item, tab);
						ACACIA_PLATFORM = createBlock(i+"_platform", () -> new Block(STONE), block, item, tab);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		 final AbstractBlock.Properties STONE = prop;
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
	
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
			final AbstractBlock.Properties WOOD = prop;
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
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

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

        	RenderTypeLookup.setRenderLayer(_terrace_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_skyline_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_compact_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_bulk_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_loft_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_railing, renderSet);
        	RenderTypeLookup.setRenderLayer(_balcony, renderSet);
        	RenderTypeLookup.setRenderLayer(_platform, renderSet);
        }
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}
	
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
	{
		Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

		for (String i : STONE)
		{
			_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
			_railing = Finder.findBlock(MODID, i+"_railing");
			_balcony = Finder.findBlock(MODID, i+"_balcony");
			_platform = Finder.findBlock(MODID, i+"_platform");

        	RenderTypeLookup.setRenderLayer(_terrace_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_skyline_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_compact_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_bulk_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_loft_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_railing, renderSet);
        	RenderTypeLookup.setRenderLayer(_balcony, renderSet);
        	RenderTypeLookup.setRenderLayer(_platform, renderSet);
        }
	}

	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}
		
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwstairs.kikoz.util.wooden.RailingItemWooden(block.get(), new Item.Properties().tab(tab)));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwstairs.kikoz.util.wooden.BalconyItemWooden(block.get(), new Item.Properties().tab(tab)));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwstairs.kikoz.util.wooden.PlatformItemWooden(block.get(), new Item.Properties().tab(tab)));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        return createBlockStone(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
		RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwstairs.kikoz.util.stone.RailingItemStone(block.get(), new Item.Properties().tab(tab)));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwstairs.kikoz.util.stone.BalconyItemStone(block.get(), new Item.Properties().tab(tab)));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwstairs.kikoz.util.stone.PlatformItemStone(block.get(), new Item.Properties().tab(tab)));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	//Start of new registration system
	
	public static void registryWood(final RegistryEvent.Register<Block> event, List<String> WOODS, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);
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
	
	public static void registryStone(final RegistryEvent.Register<Block> event, List<String> STONES, ItemGroup tab)
	{
	 	final AbstractBlock.Properties STONE = AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops();
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

	protected static Block createBlockWoodOpti(String name, Block block, ItemGroup tab)
    {
		BlockItem itemBlock;
		if(ModList.get().isLoaded(modid))
		{
	        if(name.contains("railing")) {
	        	itemBlock = new com.mcwstairs.kikoz.util.wooden.RailingItemWooden(block, new Item.Properties().tab(tab));
	        }
	        else if(name.contains("balcony")) {
	        	itemBlock = new com.mcwstairs.kikoz.util.wooden.BalconyItemWooden(block, new Item.Properties().tab(tab));
	        }
	        else if(name.contains("platform")) {
	        	itemBlock = new com.mcwstairs.kikoz.util.wooden.PlatformItemWooden(block, new Item.Properties().tab(tab));
	        }
	        else {
	        	itemBlock = new BlockItemFuel(block, new Item.Properties().tab(tab));
	        }
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
	        if(name.contains("railing")) {
	        	itemBlock = new com.mcwstairs.kikoz.util.stone.RailingItemStone(block, new Item.Properties().tab(tab));
	        }
	        else if(name.contains("balcony")) {
	        	itemBlock = new com.mcwstairs.kikoz.util.stone.BalconyItemStone(block, new Item.Properties().tab(tab));
	        }
	        else if(name.contains("platform")) {
	        	itemBlock = new com.mcwstairs.kikoz.util.stone.PlatformItemStone(block, new Item.Properties().tab(tab));
	        }
	        else {
	        	itemBlock = new BlockItem(block, new Item.Properties().tab(tab));
	        }
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
}