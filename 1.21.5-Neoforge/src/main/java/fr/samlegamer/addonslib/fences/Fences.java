package fr.samlegamer.addonslib.fences;

import java.util.List;
import java.util.Optional;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Fences
{
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationHedgesModLoaded(leaves, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationRockModLoaded(rock, block, item, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlock(id, registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlock(id, registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
				} else if(isModLoaded) {
					CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties HEDGES = prop;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), HEDGES.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new FenceBlock(HEDGES.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlockStone(id, registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlockStone(id, registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
				} else if(isModLoaded) {
					CreateBlockReferences.createBlockStone(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					CreateBlockReferences.createBlockStone(id, registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
	}
}