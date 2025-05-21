package fr.samlegamer.addonslib.windows;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Windows
{
	public static final String modid = "mcwwindows";

	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		BlockBehaviour.Properties wood = BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD);
		setRegistrationWoodModLoaded(set, block, item, wood);
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

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.WINDOWS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);
				String relectedLocation = blockId.reflectedLocation();

				if(isModMcwLoaded) {
					switch (relectedLocation)
					{
						case "Parapet":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, PARAPET),
									block, item);
							break;
						case "Blinds":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, BLINDS),
									block, item);
							break;
						case "Shutter":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, SHUTTER),
									block, item);
							break;
						case "CurtainRod":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, ROD),
									block, item);
							break;
						default:
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, WOOD),
									block, item);
							break;
					}
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		addToTabModLoaded(event, MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabModLoaded(CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded)
	{
		Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2,
		plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window,
		curtain_rod;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
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