package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class  Fences
{
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationHedgesModLoaded(leaves, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationRockModLoaded(rock, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(WOOD.setId(block.key(id))), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlock(id, () -> new FenceGateBlock(WoodType.OAK, WOOD.setId(block.key(id))), block, item);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(block.key(id))), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(WOOD.setId(block.key(id))), block, item);
				}
			}
		}
	}

	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties HEDGES = prop;
		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), HEDGES.setId(block.key(id))), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(HEDGES.setId(block.key(id))), block, item);
				}
			}
		}
	}

	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;
		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(STONE.setId(block.key(id))), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlockStone(id, () -> new FenceGateBlock(WoodType.OAK, STONE.setId(block.key(id))), block, item);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(block.key(id))), block, item);
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(STONE.setId(block.key(id))), block, item);
				}
			}
		}
	}
}