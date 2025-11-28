package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

public class Doors
{
	public static final String modid = "mcwdoors";
	
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded)
	{
		final AbstractBlock.Settings JAPAN = AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1.5F, 1.0F).sounds(BlockSoundGroup.WOOD);
		final AbstractBlock.Settings DOOR_WOOD = AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR);

		var modList = FabricLoader.getInstance();
		final boolean isModMcwLoaded = modList.isModLoaded(modid);
		final boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new DoorBlock(DOOR_WOOD), tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), JAPAN);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new DoorBlock(DOOR_WOOD), tab, false, isModBaseLoaded);
				}
			}
		}
	}
}