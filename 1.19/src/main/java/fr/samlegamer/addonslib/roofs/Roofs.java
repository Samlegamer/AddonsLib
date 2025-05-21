package fr.samlegamer.addonslib.roofs;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Roofs
{
	public static final String modid = "mcwroofs";
		
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE));
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(blockId.reflectedLocation().contains("StairsBlock")) {
					CreateBlockReferences.createBlock(id, () -> new StairBlock(Blocks.OAK_PLANKS::defaultBlockState, WOOD), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				}
				else if(isModMcwLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlock(id, () ->
								Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
					} else {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
					}
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				final RegistryObject<Block> blockObj;
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("StairsBlock")) {
					blockObj = CreateBlockReferences.createBlockStone(id, () ->
							new StairBlock(Blocks.COBBLESTONE::defaultBlockState, STONE), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				}
				else if(isModMcwLoaded) {
					final Block blockRef;
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						blockObj = CreateBlockReferences.createBlockStone(id, () ->
								Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.COBBLESTONE.defaultBlockState())
								, block, item, tab, true, isModBaseLoaded);
					} else {
						blockObj = CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE)
								, block, item, tab, true, isModBaseLoaded);
					}
				}
				else {
					blockObj = CreateBlockReferences.createBlockStone(id, () -> new Block(STONE), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
}