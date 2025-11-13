package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Doors
{
	public static final String modid = "mcwdoors";
	
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of().noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
		final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_DOOR);
		setRegistrationWoodModLoaded(set, block, item, JAPAN, DOOR_WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties japan_door, BlockBehaviour.Properties wood_door)
	{
		final BlockBehaviour.Properties JAPAN = japan_door;
		final BlockBehaviour.Properties DOOR_WOOD = wood_door;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		BlockSetType blockSetType;

		if(DOOR_WOOD.equals(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_DOOR)))
		{
			blockSetType = BlockSetType.CHERRY;
		}
		else
		{
			blockSetType = BlockSetType.OAK;
		}

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					CreateBlockReferences.createBlock(id, registryName -> new DoorBlock(blockSetType, DOOR_WOOD), block, item);
				} else if(isModLoaded) {
					CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), JAPAN, blockSetType), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new DoorBlock(blockSetType, DOOR_WOOD), block, item);
				}
			}
		}
	}
}