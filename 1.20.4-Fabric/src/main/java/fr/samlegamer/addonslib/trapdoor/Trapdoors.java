package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.minecraft.block.*;

public class Trapdoors {
	public static final String modid = "mcwtrpdoors";

	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(String MODID, List<String> set) {
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR);
		setRegistrationWoodModLoaded(MODID, set, WOOD);
	}

	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings WOOD = prop;

		for(String i : set)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				RegistryEntryReferences.registryEntry(MODID, id, new TrapdoorBlock(BlockSetType.OAK, WOOD));
			}
		}
	}
}