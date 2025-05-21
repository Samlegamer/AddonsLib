package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Fences
{
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties wood = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties leave = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES);
		setRegistrationHedgesModLoaded(leaves, block, item, tab, "minecraft", leave);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties stone = BlockBehaviour.Properties.copy(Blocks.COBBLESTONE);
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", stone);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(WOOD), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlock(id, () -> new FenceGateBlock(WOOD), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties HEDGES = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), HEDGES), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new FenceBlock(HEDGES), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(STONE), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlockStone(id, () -> new FenceGateBlock(STONE), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new FenceBlock(STONE), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> set, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new FenceBlock(WOOD), tab, isModLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new FenceGateBlock(WOOD), tab, isModLoaded);
				} else if(isModLoaded) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab, true);
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new FenceBlock(WOOD), tab, false);
				}
			}
		}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void registryHedges(final RegistryEvent.Register<Block> event, String Modid, List<String> leaves, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties HEDGES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), HEDGES), tab, true);
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new FenceBlock(HEDGES), tab, false);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void registryStone(final RegistryEvent.Register<Block> event, String Modid, List<String> rock, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.copy(Blocks.COBBLESTONE);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, new FenceBlock(STONE), tab, isModLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, new FenceGateBlock(STONE), tab, isModLoaded);
				} else if(isModLoaded) {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab, true);
				}
				else {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, new FenceBlock(STONE), tab, false);
				}
			}
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;
		
		for (String i : WOOD)
		{
			picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
			stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
			horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
			wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
			highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
			pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
			curved_gate = Finder.findBlock(MODID, i + "_curved_gate");
			
        	ItemBlockRenderTypes.setRenderLayer(picket_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(stockade_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(horse_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(wired_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(highley_gate, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(pyramid_gate, renderSet);
			ItemBlockRenderTypes.setRenderLayer(curved_gate, renderSet);
        }
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	@Deprecated
	public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block hedge;
		
		for (String i : WOOD)
		{
			hedge = Finder.findBlock(MODID, i + "_hedge");
			
        	ItemBlockRenderTypes.setRenderLayer(hedge, renderSet);
        }
	}

	@Deprecated
	public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientHedge(event, MODID, WOOD, RenderType.cutout());
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
	{
		Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
		
		for (String i : STONE)
		{
			modern_wall = Finder.findBlock(MODID, "modern_"+i+"_wall");
			railing_wall = Finder.findBlock(MODID, "railing_"+i+"_wall");
			railing_gate = Finder.findBlock(MODID, i+"_railing_gate");
			pillar_wall = Finder.findBlock(MODID, i+"_pillar_wall");
			grass_topped_wall = Finder.findBlock(MODID, i + "_grass_topped_wall");
			
        	ItemBlockRenderTypes.setRenderLayer(modern_wall, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(railing_wall, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(railing_gate, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(pillar_wall, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(grass_topped_wall, renderSet);
        }
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}
}