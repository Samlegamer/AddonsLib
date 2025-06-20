package fr.samlegamer.addonslib.roofs;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Roofs
{
	public static final String modid = "mcwroofs";
		
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationRockModLoaded(rock, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE));
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(blockId.reflectedLocation().contains("StairBlock")) {
					CreateBlockReferences.createBlock(id, registryName -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlock(id, registryName ->
								Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.OAK_PLANKS.defaultBlockState()), block, item);
					} else {
						CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
					}
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("StairBlock")) {
					CreateBlockReferences.createBlockStone(id, registryName ->
							new StairBlock(Blocks.COBBLESTONE.defaultBlockState(), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlockStone(id, registryName ->
								Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName)), Blocks.COBBLESTONE.defaultBlockState()), block, item);
					} else {
						CreateBlockReferences.createBlockStone(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
					}
				}
				else {
					CreateBlockReferences.createBlockStone(id, registryName -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
	}
}