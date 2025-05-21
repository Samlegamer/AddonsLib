package fr.samlegamer.addonslib.windows;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Windows
{
	public static final String modid = "mcwwindows";
	
	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.of().sound(SoundType.WOOD));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop.strength(0.6F, 1.2F);
		final BlockBehaviour.Properties PARAPET = prop.strength(0.2F, 1.0F);
		final BlockBehaviour.Properties BLINDS = prop.strength(0.3F, 1.0F);
		final BlockBehaviour.Properties SHUTTER = prop.strength(0.5F, 2.0F);
		final BlockBehaviour.Properties ROD = prop.strength(0.3F, 0.7F);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.WINDOWS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);
				String relectedLocation = blockId.reflectedLocation();

				if(isModLoaded) {
					switch (relectedLocation)
					{
						case "Parapet":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, PARAPET),
									block, item);
							break;
						case "Blinds":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, BLINDS),
									block, item);
							break;
						case "Shutter":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, SHUTTER),
									block, item);
							break;
						case "CurtainRod":
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, ROD),
									block, item);
							break;
						default:
							CreateBlockReferences.createBlock(id, registryName ->
											Registration.getBlocksField(relectedLocation, WOOD),
									block, item);
							break;
					}
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new Block(WOOD), block, item);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
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