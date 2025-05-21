package fr.samlegamer.addonslib.windows;

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
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

public class Windows
{
	public static final String modid = "mcwwindows";

	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded)
	{
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.6F, 1.2F);
		final AbstractBlock.Settings PARAPET = AbstractBlock.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.2F, 1.0F);
		final AbstractBlock.Settings BLINDS = AbstractBlock.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.3F, 1.0F);
		final AbstractBlock.Settings SHUTTER = AbstractBlock.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.5F, 2.0F);
		final AbstractBlock.Settings ROD = AbstractBlock.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.3F, 0.7F);

		var modList = FabricLoader.getInstance();
		final boolean isModMcwLoaded = modList.isModLoaded(modid);
		final boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

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
							RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
							break;
						case "Blinds":
							blockRef = Registration.getBlocksField(relectedLocation, BLINDS);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
							break;
						case "Shutter":
							blockRef = Registration.getBlocksField(relectedLocation, SHUTTER);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
							break;
						case "CurtainRod":
							blockRef = Registration.getBlocksField(relectedLocation, ROD);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
							break;
						default:
							blockRef = Registration.getBlocksField(relectedLocation, WOOD);
							RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
							break;
					}
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(WOOD), tab, false, isModBaseLoaded);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2,
		plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window,
		curtain_rod;

		for (String i : WOOD)
		{
	    	window = Finder.findBlock(MODID, i+"_window");
	    	window2 = Finder.findBlock(MODID, i+"_window2");
	    	four_window = Finder.findBlock(MODID, i+"_four_window");
	    	strippedlog_window = Finder.findBlock(MODID, "stripped_"+i+"_log_window");
	    	strippedlog_window2 = Finder.findBlock(MODID, "stripped_"+i+"_log_window2");
	    	strippedlog_four_window = Finder.findBlock(MODID, "stripped_"+i+"_log_four_window");
	    	plank_window = Finder.findBlock(MODID, i+"_plank_window");
	    	plank_window2 = Finder.findBlock(MODID, i+"_plank_window2");
	    	plank_four_window = Finder.findBlock(MODID, i+"_plank_four_window");
	    	log_parapet = Finder.findBlock(MODID, i+"_log_parapet");
	    	plank_parapet = Finder.findBlock(MODID, i+"_plank_parapet");
	    	blinds = Finder.findBlock(MODID, i+"_blinds");
	    	shutter = Finder.findBlock(MODID, i+"_shutter");
	    	louvered_shutter = Finder.findBlock(MODID, i+"_louvered_shutter");
	    	pane_window = Finder.findBlock(MODID, i+"_pane_window");
	    	strippedpane_window = Finder.findBlock(MODID, "stripped_"+i+"_pane_window");
	    	plank_pane_window = Finder.findBlock(MODID, i+"_plank_pane_window");
	    	curtain_rod = Finder.findBlock(MODID, i+"_curtain_rod");

        	FuelRegistry.INSTANCE.add(window, 300);
        	FuelRegistry.INSTANCE.add(window2, 300);
        	FuelRegistry.INSTANCE.add(four_window, 300);
        	FuelRegistry.INSTANCE.add(strippedlog_window, 300);
        	FuelRegistry.INSTANCE.add(strippedlog_window2, 300);
        	FuelRegistry.INSTANCE.add(strippedlog_four_window, 300);
        	FuelRegistry.INSTANCE.add(plank_window, 300);
        	FuelRegistry.INSTANCE.add(plank_window2, 300);
        	FuelRegistry.INSTANCE.add(plank_four_window, 300);
        	FuelRegistry.INSTANCE.add(log_parapet, 300);
        	FuelRegistry.INSTANCE.add(plank_parapet, 300);
        	FuelRegistry.INSTANCE.add(blinds, 300);
        	FuelRegistry.INSTANCE.add(shutter, 300);
        	FuelRegistry.INSTANCE.add(louvered_shutter, 300);
        	FuelRegistry.INSTANCE.add(pane_window, 300);
        	FuelRegistry.INSTANCE.add(strippedpane_window, 300);
        	FuelRegistry.INSTANCE.add(plank_pane_window, 300);
        	FuelRegistry.INSTANCE.add(curtain_rod, 300);
		}
	}
}