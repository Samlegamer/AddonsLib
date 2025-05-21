package fr.samlegamer.addonslib.roofs;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;

public class Roofs
{
	public static final String modid = "mcwroofs";

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(String MODID, List<String> rock, ItemGroup tab)
	{
		setRegistrationRockModLoaded(MODID, rock, tab, "minecraft", AbstractBlock.Settings.copy(Blocks.COBBLESTONE));
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings WOOD = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);
		boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block blockRef;
					if (blockId.reflectedLocation().contains("RoofGlass") || blockId.reflectedLocation().contains("RoofTopNew")) {
						blockRef = Registration.getBlocksField(blockId.reflectedLocation(), WOOD);
					} else {
						blockRef = Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.getDefaultState());
					}
					RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(WOOD), tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> rock, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings STONE = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);
		boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block blockRef;
					if (blockId.reflectedLocation().contains("RoofGlass") || blockId.reflectedLocation().contains("RoofTopNew")) {
						blockRef = Registration.getBlocksField(blockId.reflectedLocation(), STONE);
					} else {
						blockRef = Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.OAK_PLANKS.getDefaultState());
					}
					RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(STONE), tab, false, isModBaseLoaded);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD)
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

        	cherry_planks_roof = Finder.findBlock(MODID, i+"_planks_roof");
			cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
			cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
			cherry_planks_lower_roof = Finder.findBlock(MODID, i+"_planks_lower_roof");
			cherry_planks_steep_roof = Finder.findBlock(MODID, i+"_planks_steep_roof");
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
}