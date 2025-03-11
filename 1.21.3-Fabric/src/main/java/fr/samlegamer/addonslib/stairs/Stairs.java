package fr.samlegamer.addonslib.stairs;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
		final Identifier ID = Identifier.of(MODID, name);
		final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, ID);

		Registry.register(Registries.BLOCK, Identifier.of(MODID, name), b);

		if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
    		if(name.contains("railing")) {
                Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue())), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
                Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue())), "mcwstairs.balcony.desc"));

	        }
	        else if(name.contains("platform")) {
                Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItemInfo(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue())), "mcwstairs.platform.desc"));

	        }
	        else {
                Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue()))));
	        }
    	}
    	else {
            Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue()))));
        }
	}

	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.create().strength(2.0F, 2.3F).sounds(BlockSoundGroup.WOOD);
		setRegistrationWoodModLoaded(MODID,set, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(String MODID, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Settings STONE = AbstractBlock.Settings.create().strength(2.0F, 2.3F).sounds(BlockSoundGroup.STONE).requiresTool();
		setRegistrationRockModLoaded(MODID, set, tab, "minecraft", STONE);
	}
	
	public static void setRegistrationRockModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		 final AbstractBlock.Settings STONE = prop;

			for(String i : set)
			{
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
						final Block ACACIA_TERRACE_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.TerraceStairs",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_terrace_stairs")))
						);
						final Block ACACIA_SKYLINE_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.SkylineStairs",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_skyline_stairs")))
						);
						final Block ACACIA_COMPACT_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.CompactStairs",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_compact_stairs")))
						);
						final Block ACACIA_BULK_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.BulkStairs",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_bulk_stairs")))
						);
						final Block ACACIA_LOFT_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.LoftStairs",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_loft_stairs")))
						);
						final Block ACACIA_RAILING = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.StairRailing",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_railing")))
						);
						final Block ACACIA_BALCONY = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.BalconyRailing",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_balcony")))
						);
						final Block ACACIA_PLATFORM = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.StairPlatform",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_platform")))
						);

						registryEntry(MODID, i+"_terrace_stairs", ACACIA_TERRACE_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_skyline_stairs", ACACIA_SKYLINE_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_compact_stairs", ACACIA_COMPACT_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_bulk_stairs", ACACIA_BULK_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_loft_stairs", ACACIA_LOFT_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_railing", ACACIA_RAILING, tab, modLoaded);
						registryEntry(MODID, i+"_balcony", ACACIA_BALCONY, tab, modLoaded);
						registryEntry(MODID, i+"_platform", ACACIA_PLATFORM, tab, modLoaded);
				    }
				    else
				    {
						registryEntry(MODID, i + "_terrace_stairs", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_terrace_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_skyline_stairs", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_skyline_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_compact_stairs", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_compact_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_bulk_stairs", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_bulk_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_loft_stairs", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_loft_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_railing", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_railing")))), tab, modLoaded);
						registryEntry(MODID, i + "_balcony", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_balcony")))), tab, modLoaded);
						registryEntry(MODID, i + "_platform", new Block(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_platform")))), tab, modLoaded);
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
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
						final Block ACACIA_TERRACE_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.TerraceStairs",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_terrace_stairs")))
						);
						final Block ACACIA_SKYLINE_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.SkylineStairs",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_skyline_stairs")))
						);
						final Block ACACIA_COMPACT_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.CompactStairs",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_compact_stairs")))
						);
						final Block ACACIA_BULK_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.BulkStairs",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_bulk_stairs")))
						);
						final Block ACACIA_LOFT_STAIRS = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.stair_types.LoftStairs",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_loft_stairs")))
						);
						final Block ACACIA_RAILING = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.StairRailing",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_railing")))
						);
						final Block ACACIA_BALCONY = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.BalconyRailing",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_balcony")))
						);
						final Block ACACIA_PLATFORM = Registration.getBlocksField(
								"com.mcwstairs.kikoz.objects.StairPlatform",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_platform")))
						);
				    	
						registryEntry(MODID, i+"_terrace_stairs", ACACIA_TERRACE_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_skyline_stairs", ACACIA_SKYLINE_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_compact_stairs", ACACIA_COMPACT_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_bulk_stairs", ACACIA_BULK_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_loft_stairs", ACACIA_LOFT_STAIRS, tab, modLoaded);
						registryEntry(MODID, i+"_railing", ACACIA_RAILING, tab, modLoaded);
						registryEntry(MODID, i+"_balcony", ACACIA_BALCONY, tab, modLoaded);
						registryEntry(MODID, i+"_platform", ACACIA_PLATFORM, tab, modLoaded);
				    }
				    else
				    {
						registryEntry(MODID, i + "_terrace_stairs", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_terrace_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_skyline_stairs", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_skyline_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_compact_stairs", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_compact_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_bulk_stairs", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_bulk_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_loft_stairs", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_loft_stairs")))), tab, modLoaded);
						registryEntry(MODID, i + "_railing", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_railing")))), tab, modLoaded);
						registryEntry(MODID, i + "_balcony", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_balcony")))), tab, modLoaded);
						registryEntry(MODID, i + "_platform", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_platform")))), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
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

			FuelRegistryEvents.BUILD.register((builder, context) -> {
				builder.add(_terrace_stairs, 300);
				builder.add(_skyline_stairs, 300);
				builder.add(_compact_stairs, 300);
				builder.add(_bulk_stairs, 300);
				builder.add(_loft_stairs, 300);
				builder.add(_railing, 300);
				builder.add(_balcony, 300);
				builder.add(_platform, 300);
			});
        }
	}

	public static void addToTabWood(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab, String modLoaded)
	{
		if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
		{
			for (String i : WOOD)
			{
				final Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;
				_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
				_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
				_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
				_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
				_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
				_railing = Finder.findBlock(MODID, i+"_railing");
				_balcony = Finder.findBlock(MODID, i+"_balcony");
				_platform = Finder.findBlock(MODID, i+"_platform");
				
				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(_terrace_stairs);
					content.add(_skyline_stairs);
					content.add(_compact_stairs);
					content.add(_bulk_stairs);
					content.add(_loft_stairs);
					content.add(_railing);
					content.add(_balcony);
					content.add(_platform);
				});
			}
		}
	}
}