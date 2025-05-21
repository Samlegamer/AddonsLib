package fr.samlegamer.addonslib.path;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Paths
{
	public static final String modid = "mcwpaths";
	
	/**
	 * Init all Wood Variants of Macaw's Paths
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Paths with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.PATHS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item);
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
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : WOOD)
			{					
				Block planks_path;
		    	
				planks_path = Finder.findBlock(MODID, i+"_planks_path");
				
				event.accept(planks_path);
	        }
   	 	}
	}
}