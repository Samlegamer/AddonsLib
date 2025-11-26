package fr.samlegamer.addonslib.path;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Paths
{
	public static final String modid = "mcwpaths";
	
	/**
	 * Init all Wood Variants of Macaw's Paths
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Paths with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.PATHS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
}