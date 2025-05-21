package fr.samlegamer.addonslib.fences;

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
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.item.ItemGroup;

public class Fences
{
	public static final String modid = "mcwfences";

	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(String MODID, List<String> leaves, ItemGroup tab)
	{
		setRegistrationHedgesModLoaded(MODID, leaves, tab, "minecraft", AbstractBlock.Settings.copy(Blocks.OAK_LEAVES));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(String MODID, List<String> rock, ItemGroup tab)
	{
		setRegistrationRockModLoaded(MODID, rock, tab, "minecraft", AbstractBlock.Settings.copy(Blocks.COBBLESTONE));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings WOOD = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);
		boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(WOOD), tab, isModMcwLoaded, isModBaseLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(WOOD), tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), WOOD);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(WOOD), tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(String MODID, List<String> leaves, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings HEDGES = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);
		boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), HEDGES);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(HEDGES), tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> rock, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings STONE = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);
		boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(STONE), tab, isModMcwLoaded, isModBaseLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(STONE), tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), STONE);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(STONE), tab, false, isModBaseLoaded);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;
		
		for (String i : WOOD)
		{
			picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
			stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
			horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
			wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
			highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
			pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
			curved_gate = Finder.findBlock(MODID, i + "_curved_gate");
			
			FuelRegistry.INSTANCE.add(picket_fence, 300);
			FuelRegistry.INSTANCE.add(stockade_fence, 300);
			FuelRegistry.INSTANCE.add(horse_fence, 300);
			FuelRegistry.INSTANCE.add(wired_fence, 300);
			FuelRegistry.INSTANCE.add(highley_gate, 300);
			FuelRegistry.INSTANCE.add(pyramid_gate, 300);
			FuelRegistry.INSTANCE.add(curved_gate, 300);
        }
	}

	@Deprecated(forRemoval = true)
	public static void fuelHedge(String MODID, List<String> WOOD)
	{
		Block hedge;
		
		for (String i : WOOD)
		{
			hedge = Finder.findBlock(MODID, i + "_hedge");
			
			FuelRegistry.INSTANCE.add(hedge, 300);
        }
	}
}