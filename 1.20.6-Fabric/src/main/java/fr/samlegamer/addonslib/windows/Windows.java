package fr.samlegamer.addonslib.windows;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class Windows {
	public static final String modid = "mcwwindows";

	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(String MODID, List<String> set) {
		setRegistrationWoodModLoaded(MODID, set, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD));
	}

	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings WOOD = prop.strength(0.6F, 1.2F);
		final AbstractBlock.Settings PARAPET = prop.strength(0.2F, 1.0F);
		final AbstractBlock.Settings BLINDS = prop.strength(0.3F, 1.0F);
		final AbstractBlock.Settings SHUTTER = prop.strength(0.5F, 2.0F);
		final AbstractBlock.Settings ROD = prop.strength(0.3F, 0.7F);

		var modList = FabricLoader.getInstance();
		final boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.WINDOWS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);
				String relectedLocation = blockId.reflectedLocation();

				if(isModMcwLoaded) {
					final Block blockRef;
					switch (relectedLocation)
					{
						case "Parapet":
							blockRef = Registration.getBlocksField(relectedLocation, PARAPET);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						case "Blinds":
							blockRef = Registration.getBlocksField(relectedLocation, BLINDS);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						case "Shutter":
							blockRef = Registration.getBlocksField(relectedLocation, SHUTTER);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						case "CurtainRod":
							blockRef = Registration.getBlocksField(relectedLocation, ROD);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						default:
							blockRef = Registration.getBlocksField(relectedLocation, WOOD);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
					}
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(WOOD));
				}
			}
		}
	}
}