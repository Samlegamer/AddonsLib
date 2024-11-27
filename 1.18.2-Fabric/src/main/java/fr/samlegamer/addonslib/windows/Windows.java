package fr.samlegamer.addonslib.windows;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Windows
{
	private static final String modid = "mcwwindows";
	
	private static Block registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
    	}
    	else {
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
    	
    	return b;
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
			Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2, plank_four_window, 
			log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window, curtain_rod;
			  
			for(String i : set)
			{
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	window = registryEntry(MODID, i+"_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), tab, modLoaded);
				    	window2 = registryEntry(MODID, i+"_window2", Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), tab, modLoaded);
				    	four_window = registryEntry(MODID, i+"_four_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), tab, modLoaded);
				    	strippedlog_window = registryEntry(MODID, "stripped_"+i+"_log_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), tab, modLoaded);
				    	strippedlog_window2 = registryEntry(MODID, "stripped_"+i+"_log_window2", Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), tab, modLoaded);
				    	strippedlog_four_window = registryEntry(MODID, "stripped_"+i+"_log_four_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), tab, modLoaded);
				    	plank_window = registryEntry(MODID, i+"_plank_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), tab, modLoaded);
				    	plank_window2 = registryEntry(MODID, i+"_plank_window2", Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), tab, modLoaded);
				    	plank_four_window = registryEntry(MODID, i+"_plank_four_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), tab, modLoaded);
				    	log_parapet = registryEntry(MODID, i+"_log_parapet", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), tab, modLoaded);
				    	plank_parapet = registryEntry(MODID, i+"_plank_parapet", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), tab, modLoaded);
				    	blinds = registryEntry(MODID, i+"_blinds", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Blinds", BLINDS), tab, modLoaded);
				    	shutter = registryEntry(MODID, i+"_shutter", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), tab, modLoaded);
				    	louvered_shutter = registryEntry(MODID, i+"_louvered_shutter", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), tab, modLoaded);
				    	pane_window = registryEntry(MODID, i+"_pane_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), tab, modLoaded);
				    	strippedpane_window = registryEntry(MODID, "stripped_"+i+"_pane_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), tab, modLoaded);
				    	plank_pane_window = registryEntry(MODID, i+"_plank_pane_window", Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), tab, modLoaded);
				    	curtain_rod = registryEntry(MODID, i+"_curtain_rod", Registration.getBlocksField("com.mcwwindows.kikoz.objects.CurtainRod", ROD), tab, modLoaded);
				    }
				    else
				    {
				    	window = registryEntry(MODID, i+"_window", new Block(WOOD), tab, modLoaded);
				    	window2 = registryEntry(MODID, i+"_window2", new Block(WOOD), tab, modLoaded);
				    	four_window = registryEntry(MODID, i+"_four_window", new Block(WOOD), tab, modLoaded);
				    	strippedlog_window = registryEntry(MODID, "stripped_"+i+"_log_window", new Block(WOOD), tab, modLoaded);
				    	strippedlog_window2 = registryEntry(MODID, "stripped_"+i+"_log_window2", new Block(WOOD), tab, modLoaded);
				    	strippedlog_four_window = registryEntry(MODID, "stripped_"+i+"_log_four_window", new Block(WOOD), tab, modLoaded);
				    	plank_window = registryEntry(MODID, i+"_plank_window", new Block(WOOD), tab, modLoaded);
				    	plank_window2 = registryEntry(MODID, i+"_plank_window2", new Block(WOOD), tab, modLoaded);
				    	plank_four_window = registryEntry(MODID, i+"_plank_four_window", new Block(WOOD), tab, modLoaded);
				    	log_parapet = registryEntry(MODID, i+"_log_parapet", new Block(WOOD), tab, modLoaded);
				    	plank_parapet = registryEntry(MODID, i+"_plank_parapet", new Block(WOOD), tab, modLoaded);
				    	blinds = registryEntry(MODID, i+"_blinds", new Block(WOOD), tab, modLoaded);
				    	shutter = registryEntry(MODID, i+"_shutter", new Block(WOOD), tab, modLoaded);
				    	louvered_shutter = registryEntry(MODID, i+"_louvered_shutter", new Block(WOOD), tab, modLoaded);
				    	pane_window = registryEntry(MODID, i+"_pane_window", new Block(WOOD), tab, modLoaded);
				    	strippedpane_window = registryEntry(MODID, "stripped_"+i+"_pane_window", new Block(WOOD), tab, modLoaded);
				    	plank_pane_window = registryEntry(MODID, i+"_plank_pane_window", new Block(WOOD), tab, modLoaded);
				    	curtain_rod = registryEntry(MODID, i+"_curtain_rod", new Block(WOOD), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}

	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
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

	    	BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, 
	    	plank_window2, plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window, curtain_rod);
        }
	}
	
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
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
}