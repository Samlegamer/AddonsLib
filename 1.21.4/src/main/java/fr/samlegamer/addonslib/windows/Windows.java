package fr.samlegamer.addonslib.windows;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Windows
{
	private static final String modid = "mcwwindows";

	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.of().sound(SoundType.WOOD));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop.strength(0.6F, 1.2F);
			final BlockBehaviour.Properties PARAPET = prop.strength(0.2F, 1.0F);
			final BlockBehaviour.Properties BLINDS = prop.strength(0.3F, 1.0F);
			final BlockBehaviour.Properties SHUTTER = prop.strength(0.5F, 2.0F);
			final BlockBehaviour.Properties ROD = prop.strength(0.3F, 0.7F);
			RegistryObject<Block> window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2, plank_four_window, 
			log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window, curtain_rod;
			  
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	window = createBlock(i+"_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD.setId(block.key(i+"_window"))), block, item);
				    	window2 = createBlock(i+"_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(block.key(i+"_window2"))), block, item);
				    	four_window = createBlock(i+"_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(block.key(i+"_four_window"))), block, item);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD.setId(block.key("stripped_"+i+"_log_window"))), block, item);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(block.key("stripped_"+i+"_log_window2"))), block, item);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(block.key("stripped_"+i+"_log_four_window"))), block, item);
				    	plank_window = createBlock(i+"_plank_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD.setId(block.key(i+"_plank_window"))), block, item);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(block.key(i+"_plank_window2"))), block, item);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(block.key(i+"_plank_four_window"))), block, item);
				    	log_parapet = createBlock(i+"_log_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET.setId(block.key(i+"_log_parapet"))), block, item);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET.setId(block.key(i+"_plank_parapet"))), block, item);
				    	blinds = createBlock(i+"_blinds", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Blinds", BLINDS.setId(block.key(i+"_blinds"))), block, item);
				    	shutter = createBlock(i+"_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER.setId(block.key(i+"_shutter"))), block, item);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER.setId(block.key(i+"_louvered_shutter"))), block, item);
				    	pane_window = createBlock(i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD.setId(block.key(i+"_pane_window"))), block, item);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD.setId(block.key("stripped_"+i+"_pane_window"))), block, item);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD.setId(block.key(i+"_plank_pane_window"))), block, item);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.CurtainRod", ROD.setId(block.key(i+"_curtain_rod"))), block, item);
				    }
				    else
				    {
				    	window = createBlock(i+"_window", () -> new Block(WOOD.setId(block.key(i+"_window"))), block, item);
				    	window2 = createBlock(i+"_window2", () -> new Block(WOOD.setId(block.key(i+"_window2"))), block, item);
				    	four_window = createBlock(i+"_four_window", () -> new Block(WOOD.setId(block.key(i+"_four_window"))), block, item);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> new Block(WOOD.setId(block.key("stripped_"+i+"_log_window"))), block, item);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> new Block(WOOD.setId(block.key("stripped_"+i+"_log_window2"))), block, item);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> new Block(WOOD.setId(block.key("stripped_"+i+"_log_four_window"))), block, item);
				    	plank_window = createBlock(i+"_plank_window", () -> new Block(WOOD.setId(block.key(i+"_plank_window"))), block, item);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> new Block(WOOD.setId(block.key(i+"_plank_window2"))), block, item);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> new Block(WOOD.setId(block.key(i+"_plank_four_window"))), block, item);
				    	log_parapet = createBlock(i+"_log_parapet", () -> new Block(WOOD.setId(block.key(i+"_log_parapet"))), block, item);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> new Block(WOOD.setId(block.key(i+"_plank_parapet"))), block, item);
				    	blinds = createBlock(i+"_blinds", () -> new Block(WOOD.setId(block.key(i+"_blinds"))), block, item);
				    	shutter = createBlock(i+"_shutter", () -> new Block(WOOD.setId(block.key(i+"_shutter"))), block, item);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> new Block(WOOD.setId(block.key(i+"_louvered_shutter"))), block, item);
				    	pane_window = createBlock(i+"_pane_window", () -> new Block(WOOD.setId(block.key(i+"_pane_window"))), block, item);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> new Block(WOOD.setId(block.key("stripped_"+i+"_pane_window"))), block, item);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> new Block(WOOD.setId(block.key(i+"_plank_pane_window"))), block, item);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> new Block(WOOD.setId(block.key(i+"_curtain_rod"))), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}

	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS_REGISTRY.key(name))));
        return block;
    }
	
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2,
		plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window,
		curtain_rod;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
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
		    	
		    	event.accept(window);
		    	event.accept(window2);
		    	event.accept(four_window);
		    	event.accept(strippedlog_window);
		    	event.accept(strippedlog_window2);
		    	event.accept(strippedlog_four_window);
		    	event.accept(plank_window);
		    	event.accept(plank_window2);
		    	event.accept(plank_four_window);
		    	event.accept(log_parapet);
		    	event.accept(plank_parapet);
		    	event.accept(blinds);
		    	event.accept(shutter);
		    	event.accept(louvered_shutter);
		    	event.accept(pane_window);
		    	event.accept(strippedpane_window);
		    	event.accept(plank_pane_window);
		    	event.accept(curtain_rod);
			}
		}
	}
}