package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.WoodType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Fences
{
	public static final String modid = "mcwfences";

	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(String MODID, List<String> set)
	{
		setRegistrationWoodModLoaded(MODID, set, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(String MODID, List<String> leaves)
	{
		setRegistrationHedgesModLoaded(MODID, leaves, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(String MODID, List<String> rock)
	{
		setRegistrationRockModLoaded(MODID, rock, AbstractBlock.Settings.copy(Blocks.COBBLESTONE));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings WOOD = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(WoodType.OAK, WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				}
			}
		}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(String MODID, List<String> leaves, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings HEDGES = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), HEDGES.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(HEDGES.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> rock, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings STONE = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(WoodType.OAK, STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				}
			}
		}
	}
}