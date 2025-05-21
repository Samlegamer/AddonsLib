package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Fences
{
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationHedgesModLoaded(leaves, block, item, BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationRockModLoaded(rock, block, item, BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE));
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
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(WOOD), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlock(id, () -> new FenceGateBlock(WOOD, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(WOOD), block, item);
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
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), HEDGES), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(HEDGES), block, item);
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
					CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(STONE), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlockStone(id, () -> new FenceGateBlock(STONE, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item);
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(STONE), block, item);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		addToTabModLoaded(event, MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded)
	{
		Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
   	 	{
			for (String i : WOOD)
			{
				picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
				stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
				horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
				wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
				highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
				pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
				curved_gate = Finder.findBlock(MODID, i + "_curved_gate");
				
	        	event.accept(picket_fence);
	        	event.accept(stockade_fence);
	        	event.accept(horse_fence);
	        	event.accept(wired_fence);
	        	event.accept(highley_gate);
	        	event.accept(pyramid_gate);
				event.accept(curved_gate);
	        }
   	 	}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabHedge(BuildCreativeModeTabContentsEvent event, String MODID, List<String> LEAVES, CreativeModeTab tab)
	{
		addToTabHedgeModLoaded(event, MODID, LEAVES, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabHedgeModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> LEAVES, CreativeModeTab tab, String modLoaded)
	{
		Block hedge;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
   	 	{
			for (String i : LEAVES)
			{
				hedge = Finder.findBlock(MODID, i + "_hedge");
				
	        	event.accept(hedge);
	        }
   	 	}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStone(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab)
	{
		addToTabStoneModLoaded(event, MODID, STONE, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStoneModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab, String modLoaded)
	{
		Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
   	 	{
			for (String i : STONE)
			{
				modern_wall = Finder.findBlock(MODID, "modern_"+i+"_wall");
				railing_wall = Finder.findBlock(MODID, "railing_"+i+"_wall");
				railing_gate = Finder.findBlock(MODID, i+"_railing_gate");
				pillar_wall = Finder.findBlock(MODID, i+"_pillar_wall");
				grass_topped_wall = Finder.findBlock(MODID, i + "_grass_topped_wall");
				
	        	event.accept(modern_wall);
	        	event.accept(railing_wall);
	        	event.accept(railing_gate);
	        	event.accept(pillar_wall);
	        	event.accept(grass_topped_wall);
	        }
   	 	}
	}
}