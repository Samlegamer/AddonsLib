package fr.samlegamer.addonslib.windows;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class Windows
{
	public static final String modid = "mcwwindows";

	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(String MODID, List<String> set)
	{
		setRegistrationWoodModLoaded(MODID, set, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop)
	{
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
							blockRef = Registration.getBlocksField(relectedLocation, PARAPET.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						case "Blinds":
							blockRef = Registration.getBlocksField(relectedLocation, BLINDS.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						case "Shutter":
							blockRef = Registration.getBlocksField(relectedLocation, SHUTTER.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						case "CurtainRod":
							blockRef = Registration.getBlocksField(relectedLocation, ROD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
						default:
							blockRef = Registration.getBlocksField(relectedLocation, WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id))));
							RegistryEntryReferences.registryEntry(MODID, id, blockRef);
							break;
					}
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
				}
			}
		}
	}
	
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
		{
			Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2,
					plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window,
					curtain_rod;

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

			FuelRegistryEvents.BUILD.register((builder, context) -> {
				builder.add(window, 300);
				builder.add(window2, 300);
				builder.add(four_window, 300);
				builder.add(strippedlog_window, 300);
				builder.add(strippedlog_window2, 300);
				builder.add(strippedlog_four_window, 300);
				builder.add(plank_window, 300);
				builder.add(plank_window2, 300);
				builder.add(plank_four_window, 300);
				builder.add(log_parapet, 300);
				builder.add(plank_parapet, 300);
				builder.add(blinds, 300);
				builder.add(shutter, 300);
				builder.add(louvered_shutter, 300);
				builder.add(pane_window, 300);
				builder.add(strippedpane_window, 300);
				builder.add(plank_pane_window, 300);
				builder.add(curtain_rod, 300);
			});
		}
	}

	public static void addToTabWood(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab, String modLoaded)
	{
		var modList = FabricLoader.getInstance();
		if(modList.isModLoaded(modid) && modList.isModLoaded(modLoaded))
		{
			for (String i : WOOD)
			{
		    	final Block window = Finder.findBlock(MODID, i+"_window");
		    	final Block window2 = Finder.findBlock(MODID, i+"_window2");
		    	final Block four_window = Finder.findBlock(MODID, i+"_four_window");
		    	final Block strippedlog_window = Finder.findBlock(MODID, "stripped_"+i+"_log_window");
		    	final Block strippedlog_window2 = Finder.findBlock(MODID, "stripped_"+i+"_log_window2");
		    	final Block strippedlog_four_window = Finder.findBlock(MODID, "stripped_"+i+"_log_four_window");
		    	final Block plank_window = Finder.findBlock(MODID, i+"_plank_window");
		    	final Block plank_window2 = Finder.findBlock(MODID, i+"_plank_window2");
		    	final Block plank_four_window = Finder.findBlock(MODID, i+"_plank_four_window");
		    	final Block log_parapet = Finder.findBlock(MODID, i+"_log_parapet");
		    	final Block plank_parapet = Finder.findBlock(MODID, i+"_plank_parapet");
		    	final Block blinds = Finder.findBlock(MODID, i+"_blinds");
		    	final Block shutter = Finder.findBlock(MODID, i+"_shutter");
		    	final Block louvered_shutter = Finder.findBlock(MODID, i+"_louvered_shutter");
		    	final Block pane_window = Finder.findBlock(MODID, i+"_pane_window");
		    	final Block strippedpane_window = Finder.findBlock(MODID, "stripped_"+i+"_pane_window");
		    	final Block plank_pane_window = Finder.findBlock(MODID, i+"_plank_pane_window");
		    	final Block curtain_rod = Finder.findBlock(MODID, i+"_curtain_rod");
		    	
				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(window);
					content.add(window2);
					content.add(four_window);
					content.add(strippedlog_window);
					content.add(strippedlog_window2);
					content.add(strippedlog_four_window);
					content.add(plank_window);
					content.add(plank_window2);
					content.add(plank_four_window);
					content.add(log_parapet);
					content.add(plank_parapet);
					content.add(blinds);
					content.add(shutter);
					content.add(louvered_shutter);
					content.add(pane_window);
					content.add(strippedpane_window);
					content.add(plank_pane_window);
					content.add(curtain_rod);
				});
			}
		}
	}
}