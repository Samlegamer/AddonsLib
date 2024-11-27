package fr.samlegamer.addonslib.stairs;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	private static Block registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
    		if(name.contains("railing")) {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), "mcwstairs.balcony.desc"));

	        }
	        else if(name.contains("platform")) {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), "mcwstairs.platform.desc"));

	        }
	        else {
                Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
	        }
    	}
    	else {
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
    	
    	return b;
	}

	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 2.3F).sounds(BlockSoundGroup.WOOD);
		setRegistrationWoodModLoaded(MODID,set, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(String MODID, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Settings STONE = AbstractBlock.Settings.of(Material.STONE).strength(2.0F, 2.3F).sounds(BlockSoundGroup.STONE).requiresTool();
		setRegistrationRockModLoaded(MODID, set, tab, "minecraft", STONE);
	}
	
	public static void setRegistrationRockModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		 final AbstractBlock.Settings STONE = prop;

			for(String i : set)
			{
				Block ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = registryEntry(MODID, i+"_terrace_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", STONE), tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = registryEntry(MODID, i+"_skyline_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", STONE), tab, modLoaded);
						ACACIA_COMPACT_STAIRS = registryEntry(MODID, i+"_compact_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", STONE), tab, modLoaded);
						ACACIA_BULK_STAIRS = registryEntry(MODID, i+"_bulk_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", STONE), tab, modLoaded);
						ACACIA_LOFT_STAIRS = registryEntry(MODID, i+"_loft_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", STONE), tab, modLoaded);
						ACACIA_RAILING = registryEntry(MODID, i+"_railing", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", STONE), tab, modLoaded);
						ACACIA_BALCONY = registryEntry(MODID, i+"_balcony", Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", STONE), tab, modLoaded);
						ACACIA_PLATFORM = registryEntry(MODID, i+"_platform", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", STONE), tab, modLoaded);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = registryEntry(MODID, i+"_terrace_stairs", new Block(STONE), tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = registryEntry(MODID, i+"_skyline_stairs", new Block(STONE), tab, modLoaded);
						ACACIA_COMPACT_STAIRS = registryEntry(MODID, i+"_compact_stairs", new Block(STONE), tab, modLoaded);
						ACACIA_BULK_STAIRS = registryEntry(MODID, i+"_bulk_stairs", new Block(STONE), tab, modLoaded);
						ACACIA_LOFT_STAIRS = registryEntry(MODID, i+"_loft_stairs", new Block(STONE), tab, modLoaded);
						ACACIA_RAILING = registryEntry(MODID, i+"_railing", new Block(STONE), tab, modLoaded);
						ACACIA_BALCONY = registryEntry(MODID, i+"_balcony", new Block(STONE), tab, modLoaded);
						ACACIA_PLATFORM = registryEntry(MODID, i+"_platform", new Block(STONE), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings WOOD = prop;

			for(String i : set)
			{
				Block ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = registryEntry(MODID, i+"_terrace_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", WOOD), tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = registryEntry(MODID, i+"_skyline_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", WOOD), tab, modLoaded);
						ACACIA_COMPACT_STAIRS = registryEntry(MODID, i+"_compact_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", WOOD), tab, modLoaded);
						ACACIA_BULK_STAIRS = registryEntry(MODID, i+"_bulk_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", WOOD), tab, modLoaded);
						ACACIA_LOFT_STAIRS = registryEntry(MODID, i+"_loft_stairs", Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", WOOD), tab, modLoaded);
						ACACIA_RAILING = registryEntry(MODID, i+"_railing", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", WOOD), tab, modLoaded);
						ACACIA_BALCONY = registryEntry(MODID, i+"_balcony", Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", WOOD), tab, modLoaded);
						ACACIA_PLATFORM = registryEntry(MODID, i+"_platform", Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", WOOD), tab, modLoaded);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = registryEntry(MODID, i+"_terrace_stairs", new Block(WOOD), tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = registryEntry(MODID, i+"_skyline_stairs", new Block(WOOD), tab, modLoaded);
						ACACIA_COMPACT_STAIRS = registryEntry(MODID, i+"_compact_stairs", new Block(WOOD), tab, modLoaded);
						ACACIA_BULK_STAIRS = registryEntry(MODID, i+"_bulk_stairs", new Block(WOOD), tab, modLoaded);
						ACACIA_LOFT_STAIRS = registryEntry(MODID, i+"_loft_stairs", new Block(WOOD), tab, modLoaded);
						ACACIA_RAILING = registryEntry(MODID, i+"_railing", new Block(WOOD), tab, modLoaded);
						ACACIA_BALCONY = registryEntry(MODID, i+"_balcony", new Block(WOOD), tab, modLoaded);
						ACACIA_PLATFORM = registryEntry(MODID, i+"_platform", new Block(WOOD), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		for (String i : WOOD)
		{		
			Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;
			_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
			_railing = Finder.findBlock(MODID, i+"_railing");
			_balcony = Finder.findBlock(MODID, i+"_balcony");
			_platform = Finder.findBlock(MODID, i+"_platform");

			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform);
        }
	}
	
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}
	
	public static void clientStone(String MODID, List<String> STONE, RenderLayer renderSet)
	{
		for (String i : STONE)
		{
			Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;
			_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
			_railing = Finder.findBlock(MODID, i+"_railing");
			_balcony = Finder.findBlock(MODID, i+"_balcony");
			_platform = Finder.findBlock(MODID, i+"_platform");

			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform);
        }
	}

	public static void clientStone(String MODID, List<String> STONE)
	{
		clientStone(MODID, STONE, RenderLayer.getCutout());
	}
	
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
		{		
			Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;
			_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
			_railing = Finder.findBlock(MODID, i+"_railing");
			_balcony = Finder.findBlock(MODID, i+"_balcony");
			_platform = Finder.findBlock(MODID, i+"_platform");

			FuelRegistry.INSTANCE.add(_terrace_stairs, 300);
			FuelRegistry.INSTANCE.add(_skyline_stairs, 300);
			FuelRegistry.INSTANCE.add(_compact_stairs, 300);
			FuelRegistry.INSTANCE.add(_bulk_stairs, 300);
			FuelRegistry.INSTANCE.add(_loft_stairs, 300);
			FuelRegistry.INSTANCE.add(_railing, 300);
			FuelRegistry.INSTANCE.add(_balcony, 300);
			FuelRegistry.INSTANCE.add(_platform, 300);
        }
	}
}