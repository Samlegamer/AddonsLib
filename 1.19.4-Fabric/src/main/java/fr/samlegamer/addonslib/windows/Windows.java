package fr.samlegamer.addonslib.windows;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
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

public class Windows
{
	private static final String modid = "mcwwindows";
	
	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registries.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
    	}
    	else {
            Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
	}

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
			  
			for(String i : set)
			{
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	final Block window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.ConnectedWindow", WOOD);
				    	final Block window2 = Registration.getBlocksField("net.kikoz.mcwwindows.objects.WindowBarred", WOOD);
				    	final Block four_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.WindowBarred", WOOD);
				    	final Block strippedlog_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.ConnectedWindow", WOOD);
				    	final Block strippedlog_window2 = Registration.getBlocksField("net.kikoz.mcwwindows.objects.WindowBarred", WOOD);
				    	final Block strippedlog_four_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.WindowBarred", WOOD);
				    	final Block plank_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.ConnectedWindow", WOOD);
				    	final Block plank_window2 = Registration.getBlocksField("net.kikoz.mcwwindows.objects.WindowBarred", WOOD);
				    	final Block plank_four_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.WindowBarred", WOOD);
				    	final Block log_parapet = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Parapet", PARAPET);
				    	final Block plank_parapet = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Parapet", PARAPET);
				    	final Block blinds = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Blinds", BLINDS);
				    	final Block shutter = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Shutter", SHUTTER);
				    	final Block louvered_shutter = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Shutter", SHUTTER);
				    	final Block pane_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Window", WOOD);
				    	final Block strippedpane_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Window", WOOD);
				    	final Block plank_pane_window = Registration.getBlocksField("net.kikoz.mcwwindows.objects.Window", WOOD);
				    	final Block curtain_rod = Registration.getBlocksField("net.kikoz.mcwwindows.objects.CurtainRod", ROD);
				    	
				    	registryEntry(MODID, i+"_window", window, tab, modLoaded);
				    	registryEntry(MODID, i+"_window2", window2, tab, modLoaded);
				    	registryEntry(MODID, i+"_four_window", four_window, tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_log_window", strippedlog_window, tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_log_window2", strippedlog_window2, tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_log_four_window", strippedlog_four_window, tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_window", plank_window, tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_window2", plank_window2, tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_four_window", plank_four_window, tab, modLoaded);
				    	registryEntry(MODID, i+"_log_parapet", log_parapet, tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_parapet", plank_parapet, tab, modLoaded);
				    	registryEntry(MODID, i+"_blinds", blinds, tab, modLoaded);
				    	registryEntry(MODID, i+"_shutter", shutter, tab, modLoaded);
				    	registryEntry(MODID, i+"_louvered_shutter", louvered_shutter, tab, modLoaded);
				    	registryEntry(MODID, i+"_pane_window", pane_window, tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_pane_window", strippedpane_window, tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_pane_window", plank_pane_window, tab, modLoaded);
				    	registryEntry(MODID, i+"_curtain_rod", curtain_rod, tab, modLoaded);
				    }
				    else
				    {
				    	registryEntry(MODID, i+"_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_window2", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_four_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_log_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_log_window2", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_log_four_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_window2", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_four_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_log_parapet", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_parapet", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_blinds", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_shutter", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_louvered_shutter", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_pane_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, "stripped_"+i+"_pane_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_plank_pane_window", new Block(WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_curtain_rod", new Block(WOOD), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
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
	
	public static void addToTabWood(String MODID, List<String> WOOD, ItemGroup tab)
	{
		if(AddonsLib.isLoaded(modid))
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