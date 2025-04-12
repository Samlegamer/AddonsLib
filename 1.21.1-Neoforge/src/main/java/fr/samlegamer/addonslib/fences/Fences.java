package fr.samlegamer.addonslib.fences;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Fences
{
	private static final BlockBehaviour.Properties wood = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
	private static final BlockBehaviour.Properties leave = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES);
	private static final BlockBehaviour.Properties stone = BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE);
	
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationWoodModLoaded(set, block, item, wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationHedgesModLoaded(leaves, block, item, leave);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		setRegistrationRockModLoaded(rock, block, item, stone);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;

			DeferredBlock<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

			for(String i : set)
			{				
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				        picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item);
				        stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item);
				        horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item);
			            wired_fence = createBlock(i + "_wired_fence", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.WiredFence", WOOD), block, item);
				        highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
				        pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
						curved_gate = createBlock(i + "_curved_gate", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.DoubleGate", WOOD), block, item);
				    } else {
				        picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item);
				        stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item);
				        horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item);
				        wired_fence = createBlock(i + "_wired_fence", () -> new FenceBlock(WOOD), block, item);
				        highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
				        pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
						curved_gate = createBlock(i + "_curved_gate", () -> new FenceBlock(WOOD), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties HEDGES = prop;

			DeferredBlock<Block> hedge;

			for(String i : leaves)
			{
				if (ModList.get().isLoaded(modid))
	        	{
	                hedge = createBlock(i + "_hedge", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES), block, item);

	            } else {
	                hedge = createBlock(i + "_hedge", () -> new FenceBlock(HEDGES), block, item);
	            }
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties STONE = prop;

			DeferredBlock<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

			for(String i : rock)
			{
				if (ModList.get().isLoaded(modid)) {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item);
	                grass_topped_wall = createBlock(i + "_grass_topped_wall", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", STONE), block, item);

	            } else {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item);
					grass_topped_wall = createBlockStone(i+"_grass_topped_wall", () -> new FenceBlock(STONE), block, item);
	            }
			}
	}
	
	protected static DeferredBlock<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        return block;
    }
	
	protected static DeferredBlock<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
		
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : WOOD)
			{
				picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
				stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
				horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
				wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
				highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
				pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
				
	        	event.accept(picket_fence);
	        	event.accept(stockade_fence);
	        	event.accept(horse_fence);
	        	event.accept(wired_fence);
	        	event.accept(highley_gate);
	        	event.accept(pyramid_gate);
	        }
   	 	}
	}
	
	public static void addToTabHedge(BuildCreativeModeTabContentsEvent event, String MODID, List<String> LEAVES, CreativeModeTab tab)
	{
		Block hedge;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : LEAVES)
			{
				hedge = Finder.findBlock(MODID, i + "_hedge");
				
	        	event.accept(hedge);
	        }
   	 	}
	}
	
	public static void addToTabStone(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab)
	{
		Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
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