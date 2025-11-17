package fr.samlegamer.addonslib.bridges;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Bridges
{
	public static final String modid = "mcwbridges";
	public static final String desc = "mcwbridges.bridges.desc";
	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.WOOD));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationRockModLoaded(set, block, item, BlockBehaviour.Properties.of().strength(3.0F, 5.0F).sound(SoundType.STONE));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		ModList modList = ModList.get();
		boolean isModMcwLoaded = modList.isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item);
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new Block(STONE), block, item);
				}
			}
		}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		ModList modList = ModList.get();
		boolean isModMcwLoaded = modList.isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item);
				}
			}
		}
	}
}