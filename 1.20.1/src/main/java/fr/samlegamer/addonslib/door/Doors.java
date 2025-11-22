package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Doors
{
	public static final String modid = "mcwdoors";
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of().noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
		final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);
		setRegistrationWoodModLoaded(set, block, item, JAPAN, DOOR_WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties japan_door, BlockBehaviour.Properties wood_door)
	{
		final BlockBehaviour.Properties JAPAN = japan_door;
		final BlockBehaviour.Properties DOOR_WOOD = wood_door;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD, BlockSetType.OAK), block, item);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), JAPAN, BlockSetType.OAK), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD, BlockSetType.OAK), block, item);
				}
			}
		}
	}
}