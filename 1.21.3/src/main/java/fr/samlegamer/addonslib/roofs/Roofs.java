package fr.samlegamer.addonslib.roofs;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
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
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Roofs
{
	private static final BlockBehaviour.Properties wood = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
	private static final BlockBehaviour.Properties stone = BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE);
	public static final String modid = "mcwroofs";
		
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationRockModLoaded(rock, block, item, stone);
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(blockId.reflectedLocation().contains("StairsBlock")) {
					CreateBlockReferences.createBlock(id, () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD.setId(block.key(id))), block, item);
				}
				else if(isModMcwLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlock(id, () ->
								Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(block.key(id)), Blocks.OAK_PLANKS.defaultBlockState()), block, item);
					} else {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(block.key(id))), block, item);
					}
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD.setId(block.key(id))), block, item);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;
		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("StairsBlock")) {
					CreateBlockReferences.createBlockStone(id, () ->
							new StairBlock(Blocks.COBBLESTONE.defaultBlockState(), STONE.setId(block.key(id))), block, item);
				}
				else if(isModMcwLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(block.key(id)), Blocks.COBBLESTONE.defaultBlockState()), block, item);
					} else {
						CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(block.key(id))), block, item);
					}
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new Block(STONE.setId(block.key(id))), block, item);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block cherry_roof,
		cherry_attic_roof,
		cherry_top_roof,
		cherry_lower_roof,
		cherry_steep_roof,
		cherry_upper_lower_roof,
		cherry_upper_steep_roof,
		cherry_planks_roof,
		cherry_planks_attic_roof,
		cherry_planks_top_roof,
		cherry_planks_lower_roof,
		cherry_planks_steep_roof,
		cherry_planks_upper_lower_roof,
		cherry_planks_upper_steep_roof;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
		{
			for (String i : WOOD)
			{
				cherry_roof = Finder.findBlock(MODID, i + "_roof");
				cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
				cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
				cherry_lower_roof = Finder.findBlock(MODID, i + "_lower_roof");
				cherry_steep_roof = Finder.findBlock(MODID, i + "_steep_roof");
				cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
				cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");

				event.accept(cherry_roof);
				event.accept(cherry_attic_roof);
				event.accept(cherry_top_roof);
				event.accept(cherry_lower_roof);
				event.accept(cherry_steep_roof);
				event.accept(cherry_upper_lower_roof);
				event.accept(cherry_upper_steep_roof);

				cherry_planks_roof = Finder.findBlock(MODID, i + "_planks_roof");
				cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
				cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
				cherry_planks_lower_roof = Finder.findBlock(MODID, i + "_planks_lower_roof");
				cherry_planks_steep_roof = Finder.findBlock(MODID, i + "_planks_steep_roof");
				cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
				cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");

				event.accept(cherry_planks_roof);
				event.accept(cherry_planks_attic_roof);
				event.accept(cherry_planks_top_roof);
				event.accept(cherry_planks_lower_roof);
				event.accept(cherry_planks_steep_roof);
				event.accept(cherry_planks_upper_lower_roof);
				event.accept(cherry_planks_upper_steep_roof);
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStone(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab)
	{
		Block ROOF,
		ATTIC_ROOF,
		TOP_ROOF,
		LOWER_ROOF,
		STEEP_ROOF,
		UPPER_LOWER_ROOF,
		UPPER_STEEP_ROOF;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : STONE)
			{
				ROOF = Finder.findBlock(MODID, i + "_roof");
				ATTIC_ROOF = Finder.findBlock(MODID, i + "_attic_roof");
				TOP_ROOF = Finder.findBlock(MODID, i + "_top_roof");
				LOWER_ROOF = Finder.findBlock(MODID, i + "_lower_roof");
				STEEP_ROOF = Finder.findBlock(MODID, i + "_steep_roof");
				UPPER_LOWER_ROOF = Finder.findBlock(MODID, i + "_upper_lower_roof");
				UPPER_STEEP_ROOF = Finder.findBlock(MODID, i + "_upper_steep_roof");
	
	        	event.accept(ROOF);
	        	event.accept(ATTIC_ROOF);
	        	event.accept(TOP_ROOF);
	        	event.accept(LOWER_ROOF);
	        	event.accept(STEEP_ROOF);
	        	event.accept(UPPER_LOWER_ROOF);
	        	event.accept(UPPER_STEEP_ROOF);
	        }
   	 	}
	}
}