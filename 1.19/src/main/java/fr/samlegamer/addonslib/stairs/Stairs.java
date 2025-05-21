package fr.samlegamer.addonslib.stairs;

import java.util.List;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD);
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).requiresCorrectToolForDrops();
		setRegistrationRockModLoaded(set, block, item, tab, "minecraft", STONE);
	}
	
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new Block(STONE), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
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