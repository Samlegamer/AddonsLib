package fr.samlegamer.addonslib.windows;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Windows
{
	private static final List<RegistryObject<Block>> WINDOW_BLOCKS = new ArrayList<>();
	private static final String modid = "mcwwindows";
	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.6F, 1.2F);
			final AbstractBlock.Properties PARAPET = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.2F, 1.0F);
			final AbstractBlock.Properties BLINDS = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 1.0F);
			final AbstractBlock.Properties SHUTTER = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.5F, 2.0F);
			final AbstractBlock.Properties ROD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 0.7F);
			RegistryObject<Block> window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2, plank_four_window, 
			log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window, curtain_rod;
			  
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	window = createBlock(i+"_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab);
				    	window2 = createBlock(i+"_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab);
				    	four_window = createBlock(i+"_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab);
				    	plank_window = createBlock(i+"_plank_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab);
				    	log_parapet = createBlock(i+"_log_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), block, item, tab);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), block, item, tab);
				    	blinds = createBlock(i+"_blinds", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Blinds", BLINDS), block, item, tab);
				    	shutter = createBlock(i+"_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), block, item, tab);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), block, item, tab);
				    	pane_window = createBlock(i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.CurtainRod", ROD), block, item, tab);
				    }
				    else
				    {
				    	window = createBlock(i+"_window", () -> new Block(WOOD), block, item, tab);
				    	window2 = createBlock(i+"_window2", () -> new Block(WOOD), block, item, tab);
				    	four_window = createBlock(i+"_four_window", () -> new Block(WOOD), block, item, tab);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> new Block(WOOD), block, item, tab);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> new Block(WOOD), block, item, tab);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> new Block(WOOD), block, item, tab);
				    	plank_window = createBlock(i+"_plank_window", () -> new Block(WOOD), block, item, tab);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> new Block(WOOD), block, item, tab);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> new Block(WOOD), block, item, tab);
				    	log_parapet = createBlock(i+"_log_parapet", () -> new Block(WOOD), block, item, tab);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> new Block(WOOD), block, item, tab);
				    	blinds = createBlock(i+"_blinds", () -> new Block(WOOD), block, item, tab);
				    	shutter = createBlock(i+"_shutter", () -> new Block(WOOD), block, item, tab);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> new Block(WOOD), block, item, tab);
				    	pane_window = createBlock(i+"_pane_window", () -> new Block(WOOD), block, item, tab);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> new Block(WOOD), block, item, tab);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> new Block(WOOD), block, item, tab);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> new Block(WOOD), block, item, tab);
				    }
				    WINDOW_BLOCKS.add(window);
				    WINDOW_BLOCKS.add(window2);
				    WINDOW_BLOCKS.add(four_window);
				    WINDOW_BLOCKS.add(strippedlog_window);
				    WINDOW_BLOCKS.add(strippedlog_window2);
				    WINDOW_BLOCKS.add(strippedlog_four_window);
				    WINDOW_BLOCKS.add(plank_window);
				    WINDOW_BLOCKS.add(plank_window2);
				    WINDOW_BLOCKS.add(plank_four_window);
				    WINDOW_BLOCKS.add(log_parapet);
				    WINDOW_BLOCKS.add(plank_parapet);
				    WINDOW_BLOCKS.add(blinds);
				    WINDOW_BLOCKS.add(shutter);
				    WINDOW_BLOCKS.add(louvered_shutter);
				    WINDOW_BLOCKS.add(pane_window);
				    WINDOW_BLOCKS.add(strippedpane_window);
				    WINDOW_BLOCKS.add(plank_pane_window);
				    WINDOW_BLOCKS.add(curtain_rod);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.6F, 1.2F);
			final AbstractBlock.Properties PARAPET = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.2F, 1.0F);
			final AbstractBlock.Properties BLINDS = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 1.0F);
			final AbstractBlock.Properties SHUTTER = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.5F, 2.0F);
			final AbstractBlock.Properties ROD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 0.7F);
			RegistryObject<Block> window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2, plank_four_window, 
			log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window, curtain_rod;
			  
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	window = createBlock(i+"_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab, modLoaded);
				    	window2 = createBlock(i+"_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	four_window = createBlock(i+"_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab, modLoaded);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	plank_window = createBlock(i+"_plank_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab, modLoaded);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	log_parapet = createBlock(i+"_log_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), block, item, tab, modLoaded);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), block, item, tab, modLoaded);
				    	blinds = createBlock(i+"_blinds", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Blinds", BLINDS), block, item, tab, modLoaded);
				    	shutter = createBlock(i+"_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), block, item, tab, modLoaded);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), block, item, tab, modLoaded);
				    	pane_window = createBlock(i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab, modLoaded);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab, modLoaded);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab, modLoaded);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.CurtainRod", ROD), block, item, tab, modLoaded);
				    }
				    else
				    {
				    	window = createBlock(i+"_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	window2 = createBlock(i+"_window2", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	four_window = createBlock(i+"_four_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_window = createBlock(i+"_plank_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	log_parapet = createBlock(i+"_log_parapet", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	blinds = createBlock(i+"_blinds", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	shutter = createBlock(i+"_shutter", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	pane_window = createBlock(i+"_pane_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> new Block(WOOD), block, item, tab, modLoaded);
				    }
				    WINDOW_BLOCKS.add(window);
				    WINDOW_BLOCKS.add(window2);
				    WINDOW_BLOCKS.add(four_window);
				    WINDOW_BLOCKS.add(strippedlog_window);
				    WINDOW_BLOCKS.add(strippedlog_window2);
				    WINDOW_BLOCKS.add(strippedlog_four_window);
				    WINDOW_BLOCKS.add(plank_window);
				    WINDOW_BLOCKS.add(plank_window2);
				    WINDOW_BLOCKS.add(plank_four_window);
				    WINDOW_BLOCKS.add(log_parapet);
				    WINDOW_BLOCKS.add(plank_parapet);
				    WINDOW_BLOCKS.add(blinds);
				    WINDOW_BLOCKS.add(shutter);
				    WINDOW_BLOCKS.add(louvered_shutter);
				    WINDOW_BLOCKS.add(pane_window);
				    WINDOW_BLOCKS.add(strippedpane_window);
				    WINDOW_BLOCKS.add(plank_pane_window);
				    WINDOW_BLOCKS.add(curtain_rod);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}

	/**
	 * Don't work
	 */
	@Deprecated
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : WINDOW_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
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

        	RenderTypeLookup.setRenderLayer(window, renderSet);
        	RenderTypeLookup.setRenderLayer(window2, renderSet);
        	RenderTypeLookup.setRenderLayer(four_window, renderSet);
        	RenderTypeLookup.setRenderLayer(strippedlog_window, renderSet);
        	RenderTypeLookup.setRenderLayer(strippedlog_window2, renderSet);
        	RenderTypeLookup.setRenderLayer(strippedlog_four_window, renderSet);
        	RenderTypeLookup.setRenderLayer(plank_window, renderSet);
        	RenderTypeLookup.setRenderLayer(plank_window2, renderSet);
        	RenderTypeLookup.setRenderLayer(plank_four_window, renderSet);
        	RenderTypeLookup.setRenderLayer(log_parapet, renderSet);
        	RenderTypeLookup.setRenderLayer(plank_parapet, renderSet);
        	RenderTypeLookup.setRenderLayer(blinds, renderSet);
        	RenderTypeLookup.setRenderLayer(shutter, renderSet);
        	RenderTypeLookup.setRenderLayer(louvered_shutter, renderSet);
        	RenderTypeLookup.setRenderLayer(pane_window, renderSet);
        	RenderTypeLookup.setRenderLayer(strippedpane_window, renderSet);
        	RenderTypeLookup.setRenderLayer(plank_pane_window, renderSet);
        	RenderTypeLookup.setRenderLayer(curtain_rod, renderSet);
        }
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        }
        return block;
    }
}