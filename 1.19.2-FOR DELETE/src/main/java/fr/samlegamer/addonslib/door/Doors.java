package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Doors
{
	public static final String modid = "mcwdoors";
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
		final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
		final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);


		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), JAPAN), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
}