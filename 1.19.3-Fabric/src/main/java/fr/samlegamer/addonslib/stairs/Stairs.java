package fr.samlegamer.addonslib.stairs;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class Stairs {
	public static final String modid = "mcwstairs";

	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded) {
		Registry.register(Registries.BLOCK, new Identifier(MODID, name), b);
		if (AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded)) {
			if (name.contains("railing")) {
				Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings(), "mcwstairs.railing.desc"));
			} else if (name.contains("balcony")) {
				Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings(), "mcwstairs.balcony.desc"));

			} else if (name.contains("platform")) {
				Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings(), "mcwstairs.platform.desc"));

			} else {
				Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
			}
		} else {
			Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
		}
	}

	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab) {
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 2.3F).sounds(BlockSoundGroup.WOOD);
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(String MODID, List<String> set, ItemGroup tab) {
		final AbstractBlock.Settings STONE = AbstractBlock.Settings.of(Material.STONE).strength(2.0F, 2.3F).sounds(BlockSoundGroup.STONE).requiresTool();
		setRegistrationRockModLoaded(MODID, set, tab, "minecraft", STONE);
	}

	public static void setRegistrationRockModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings STONE = prop;

		for (String i : set) {
			try {
				if (AddonsLib.isLoaded(modid)) {
					final Block ACACIA_TERRACE_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", STONE);
					final Block ACACIA_SKYLINE_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", STONE);
					final Block ACACIA_COMPACT_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", STONE);
					final Block ACACIA_BULK_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", STONE);
					final Block ACACIA_LOFT_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", STONE);
					final Block ACACIA_RAILING = Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", STONE);
					final Block ACACIA_BALCONY = Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", STONE);
					final Block ACACIA_PLATFORM = Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", STONE);

					registryEntry(MODID, i + "_terrace_stairs", ACACIA_TERRACE_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_skyline_stairs", ACACIA_SKYLINE_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_compact_stairs", ACACIA_COMPACT_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_bulk_stairs", ACACIA_BULK_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_loft_stairs", ACACIA_LOFT_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_railing", ACACIA_RAILING, tab, modLoaded);
					registryEntry(MODID, i + "_balcony", ACACIA_BALCONY, tab, modLoaded);
					registryEntry(MODID, i + "_platform", ACACIA_PLATFORM, tab, modLoaded);
				} else {
					registryEntry(MODID, i + "_terrace_stairs", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_skyline_stairs", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_compact_stairs", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_bulk_stairs", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_loft_stairs", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_railing", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_balcony", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_platform", new Block(STONE), tab, modLoaded);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings WOOD = prop;

		for (String i : set) {
			try {
				if (AddonsLib.isLoaded(modid)) {
					final Block ACACIA_TERRACE_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", WOOD);
					final Block ACACIA_SKYLINE_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", WOOD);
					final Block ACACIA_COMPACT_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", WOOD);
					final Block ACACIA_BULK_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", WOOD);
					final Block ACACIA_LOFT_STAIRS = Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", WOOD);
					final Block ACACIA_RAILING = Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", WOOD);
					final Block ACACIA_BALCONY = Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", WOOD);
					final Block ACACIA_PLATFORM = Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", WOOD);

					registryEntry(MODID, i + "_terrace_stairs", ACACIA_TERRACE_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_skyline_stairs", ACACIA_SKYLINE_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_compact_stairs", ACACIA_COMPACT_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_bulk_stairs", ACACIA_BULK_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_loft_stairs", ACACIA_LOFT_STAIRS, tab, modLoaded);
					registryEntry(MODID, i + "_railing", ACACIA_RAILING, tab, modLoaded);
					registryEntry(MODID, i + "_balcony", ACACIA_BALCONY, tab, modLoaded);
					registryEntry(MODID, i + "_platform", ACACIA_PLATFORM, tab, modLoaded);
				} else {
					registryEntry(MODID, i + "_terrace_stairs", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_skyline_stairs", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_compact_stairs", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_bulk_stairs", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_loft_stairs", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_railing", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_balcony", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_platform", new Block(WOOD), tab, modLoaded);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void fuelWood(String MODID, List<String> WOOD) {
		for (String i : WOOD) {
			Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;
			_terrace_stairs = Finder.findBlock(MODID, i + "_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i + "_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i + "_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i + "_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i + "_loft_stairs");
			_railing = Finder.findBlock(MODID, i + "_railing");
			_balcony = Finder.findBlock(MODID, i + "_balcony");
			_platform = Finder.findBlock(MODID, i + "_platform");

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