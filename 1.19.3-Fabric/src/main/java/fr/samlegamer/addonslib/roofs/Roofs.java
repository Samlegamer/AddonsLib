package fr.samlegamer.addonslib.roofs;

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

public class Roofs {
	private static AbstractBlock.Settings wood = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
	private static AbstractBlock.Settings stone = AbstractBlock.Settings.copy(Blocks.COBBLESTONE);
	public static final String modid = "mcwroofs";

	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded) {
		Registry.register(Registries.BLOCK, new Identifier(MODID, name), b);
		if (AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded)) {
			Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
		} else {
			Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
		}
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab) {
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft", wood);
	}

	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(String MODID, List<String> rock, ItemGroup tab) {
		setRegistrationRockModLoaded(MODID, rock, tab, "minecraft", stone);
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings WOOD = prop;

		for (String i : set) {
			try {
				if (AddonsLib.isLoaded(modid)) {
					final Block cherry_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.BaseRoof", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_attic_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.RoofGlass", WOOD);
					final Block cherry_top_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.RoofTopNew", WOOD);
					final Block cherry_lower_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.BaseRoof", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_steep_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.SteepRoof", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_upper_lower_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_upper_steep_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.getDefaultState());

					final Block cherry_planks_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.BaseRoof", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_planks_attic_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.RoofGlass", WOOD);
					final Block cherry_planks_top_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.RoofTopNew", WOOD);
					final Block cherry_planks_lower_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.BaseRoof", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_planks_steep_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.SteepRoof", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_planks_upper_lower_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.Lower", WOOD, Blocks.OAK_PLANKS.getDefaultState());
					final Block cherry_planks_upper_steep_roof = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.Steep", WOOD, Blocks.OAK_PLANKS.getDefaultState());

					registryEntry(MODID, i + "_roof", cherry_roof, tab, modLoaded);
					registryEntry(MODID, i + "_attic_roof", cherry_attic_roof, tab, modLoaded);
					registryEntry(MODID, i + "_top_roof", cherry_top_roof, tab, modLoaded);
					registryEntry(MODID, i + "_lower_roof", cherry_lower_roof, tab, modLoaded);
					registryEntry(MODID, i + "_steep_roof", cherry_steep_roof, tab, modLoaded);
					registryEntry(MODID, i + "_upper_lower_roof", cherry_upper_lower_roof, tab, modLoaded);
					registryEntry(MODID, i + "_upper_steep_roof", cherry_upper_steep_roof, tab, modLoaded);

					registryEntry(MODID, i + "_planks_roof", cherry_planks_roof, tab, modLoaded);
					registryEntry(MODID, i + "_planks_attic_roof", cherry_planks_attic_roof, tab, modLoaded);
					registryEntry(MODID, i + "_planks_top_roof", cherry_planks_top_roof, tab, modLoaded);
					registryEntry(MODID, i + "_planks_lower_roof", cherry_planks_lower_roof, tab, modLoaded);
					registryEntry(MODID, i + "_planks_steep_roof", cherry_planks_steep_roof, tab, modLoaded);
					registryEntry(MODID, i + "_planks_upper_lower_roof", cherry_planks_upper_lower_roof, tab, modLoaded);
					registryEntry(MODID, i + "_planks_upper_steep_roof", cherry_planks_upper_steep_roof, tab, modLoaded);
				} else {
					registryEntry(MODID, i + "_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_attic_roof", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_top_roof", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_lower_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_steep_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_upper_lower_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_upper_steep_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);

					registryEntry(MODID, i + "_planks_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_planks_attic_roof", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_planks_top_roof", new Block(WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_planks_lower_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_planks_steep_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_planks_upper_lower_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
					registryEntry(MODID, i + "_planks_upper_steep_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), WOOD), tab, modLoaded);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> rock, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings STONE = prop;

		for (String i : rock) {
			try {
				if (AddonsLib.isLoaded(modid)) {
					final Block ROOF = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.BaseRoof", STONE, Blocks.COBBLESTONE.getDefaultState());
					final Block ATTIC_ROOF = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.RoofGlass", STONE);
					final Block TOP_ROOF = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.RoofTopNew", STONE);
					final Block LOWER_ROOF = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.BaseRoof", STONE, Blocks.COBBLESTONE.getDefaultState());
					final Block STEEP_ROOF = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.SteepRoof", STONE, Blocks.COBBLESTONE.getDefaultState());
					final Block UPPER_LOWER_ROOF = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.Lower", STONE, Blocks.COBBLESTONE.getDefaultState());
					final Block UPPER_STEEP_ROOF = Registration.getBlocksField("net.kikoz.mcwroofs.objects.roofs.Steep", STONE, Blocks.COBBLESTONE.getDefaultState());

					registryEntry(MODID, i + "_roof", ROOF, tab, modLoaded);
					registryEntry(MODID, i + "_attic_roof", ATTIC_ROOF, tab, modLoaded);
					registryEntry(MODID, i + "_top_roof", TOP_ROOF, tab, modLoaded);
					registryEntry(MODID, i + "_lower_roof", LOWER_ROOF, tab, modLoaded);
					registryEntry(MODID, i + "_steep_roof", STEEP_ROOF, tab, modLoaded);
					registryEntry(MODID, i + "_upper_lower_roof", UPPER_LOWER_ROOF, tab, modLoaded);
					registryEntry(MODID, i + "_upper_steep_roof", UPPER_STEEP_ROOF, tab, modLoaded);
				} else {
					registryEntry(MODID, i + "_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), STONE), tab, modLoaded);
					registryEntry(MODID, i + "_attic_roof", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_top_roof", new Block(STONE), tab, modLoaded);
					registryEntry(MODID, i + "_lower_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), STONE), tab, modLoaded);
					registryEntry(MODID, i + "_steep_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), STONE), tab, modLoaded);
					registryEntry(MODID, i + "_upper_lower_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), STONE), tab, modLoaded);
					registryEntry(MODID, i + "_upper_steep_roof", new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), STONE), tab, modLoaded);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void fuelWood(String MODID, List<String> WOOD) {
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

		for (String i : WOOD) {
			cherry_roof = Finder.findBlock(MODID, i + "_roof");
			cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
			cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
			cherry_lower_roof = Finder.findBlock(MODID, i + "_lower_roof");
			cherry_steep_roof = Finder.findBlock(MODID, i + "_steep_roof");
			cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
			cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");

			cherry_planks_roof = Finder.findBlock(MODID, i + "_planks_roof");
			cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
			cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
			cherry_planks_lower_roof = Finder.findBlock(MODID, i + "_planks_lower_roof");
			cherry_planks_steep_roof = Finder.findBlock(MODID, i + "_planks_steep_roof");
			cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
			cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");

			FuelRegistry.INSTANCE.add(cherry_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_attic_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_top_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_lower_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_steep_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_upper_lower_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_upper_steep_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_planks_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_planks_attic_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_planks_top_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_planks_lower_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_planks_steep_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_planks_upper_lower_roof, 300);
			FuelRegistry.INSTANCE.add(cherry_planks_upper_steep_roof, 300);
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
				final Block cherry_roof = Finder.findBlock(MODID, i+"_roof");
				final Block cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
				final Block cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
				final Block cherry_lower_roof = Finder.findBlock(MODID, i+"_lower_roof");
				final Block cherry_steep_roof = Finder.findBlock(MODID, i+"_steep_roof");
				final Block cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
				final Block cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");
	
				final Block cherry_planks_roof = Finder.findBlock(MODID, i+"_planks_roof");
	        	final Block cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
	        	final Block cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
	        	final Block cherry_planks_lower_roof = Finder.findBlock(MODID, i+"_planks_lower_roof");
	        	final Block cherry_planks_steep_roof = Finder.findBlock(MODID, i+"_planks_steep_roof");
	        	final Block cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
	        	final Block cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");
	
				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(cherry_roof);
					content.add(cherry_attic_roof);
					content.add(cherry_top_roof);
					content.add(cherry_lower_roof);
					content.add(cherry_steep_roof);
					content.add(cherry_upper_lower_roof);
					content.add(cherry_upper_steep_roof);
					content.add(cherry_planks_roof);
					content.add(cherry_planks_attic_roof);
					content.add(cherry_planks_top_roof);
					content.add(cherry_planks_lower_roof);
					content.add(cherry_planks_steep_roof);
					content.add(cherry_planks_upper_lower_roof);
					content.add(cherry_planks_upper_steep_roof);
				});
			}
		}
	}
	public static void addToTabStone(String MODID, List<String> ROCK, ItemGroup tab)
	{
		addToTabStoneModLoaded(MODID, ROCK, tab, "minecraft");
	}

	public static void addToTabStoneModLoaded(String MODID, List<String> ROCK, ItemGroup tab, String modLoaded)
	{
		if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
		{
			for (String i : ROCK)
			{
				final Block ROOF = Finder.findBlock(MODID, i + "_roof");
				final Block ATTIC_ROOF = Finder.findBlock(MODID, i + "_attic_roof");
				final Block TOP_ROOF = Finder.findBlock(MODID, i + "_top_roof");
				final Block LOWER_ROOF = Finder.findBlock(MODID, i + "_lower_roof");
				final Block STEEP_ROOF = Finder.findBlock(MODID, i + "_steep_roof");
				final Block UPPER_LOWER_ROOF = Finder.findBlock(MODID, i + "_upper_lower_roof");
				final Block UPPER_STEEP_ROOF = Finder.findBlock(MODID, i + "_upper_steep_roof");
				
				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(ROOF);
					content.add(ATTIC_ROOF);
					content.add(TOP_ROOF);
					content.add(LOWER_ROOF);
					content.add(STEEP_ROOF);
					content.add(UPPER_LOWER_ROOF);
					content.add(UPPER_STEEP_ROOF);
				});
			}
		}
	}
}