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
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class  Fences
{
	private static final BlockBehaviour.Properties wood = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
	private static final BlockBehaviour.Properties leave = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES);
	private static final BlockBehaviour.Properties stone = BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE);
	
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationHedgesModLoaded(leaves, block, item, leave);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationRockModLoaded(rock, block, item, stone);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;

			RegistryObject<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

			for(String i : set)
			{				
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				        picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD.setId(block.key(i+"_picket_fence"))), block, item);
				        stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD.setId(block.key(i+"_stockade_fence"))), block, item);
				        horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD.setId(block.key(i+"_horse_fence"))), block, item);
			            wired_fence = createBlock(i + "_wired_fence", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.WiredFence", WOOD.setId(block.key(i+"_wired_fence"))), block, item);
				        highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WoodType.OAK, WOOD.setId(block.key(i+"_highley_gate")), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
				        pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WoodType.OAK, WOOD.setId(block.key(i+"_pyramid_gate")), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
						curved_gate = createBlock(i + "_curved_gate", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.DoubleGate", WOOD.setId(block.key(i + "_curved_gate"))), block, item);
					} else {
						picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD.setId(block.key(i+"_picket_fence"))), block, item);
						stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD.setId(block.key(i+"_stockade_fence"))), block, item);
						horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD.setId(block.key(i+"_horse_fence"))), block, item);
						wired_fence = createBlock(i + "_wired_fence", () -> new FenceBlock(WOOD.setId(block.key(i+"_wired_fence"))), block, item);
						highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WoodType.OAK, WOOD.setId(block.key(i+"_highley_gate")), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
						pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WoodType.OAK, WOOD.setId(block.key(i+"_pyramid_gate")), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
						curved_gate = createBlock(i + "_curved_gate", () -> new FenceBlock(WOOD.setId(block.key(i + "_curved_gate"))), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}

	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties HEDGES = prop;

			RegistryObject<Block> hedge;

			for(String i : leaves)
			{
				if (ModList.get().isLoaded(modid))
	        	{
	                hedge = createBlock(i + "_hedge", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES.setId(block.key(i+"_hedge"))), block, item);

	            } else {
	                hedge = createBlock(i + "_hedge", () -> new FenceBlock(HEDGES.setId(block.key(i+"_hedge"))), block, item);
	            }
			}
	}

	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties STONE = prop;

			RegistryObject<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

			for(String i : rock)
			{
				if (ModList.get().isLoaded(modid)) {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE.setId(block.key("modern_"+i+"_wall"))), block, item);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE.setId(block.key("railing_"+i+"_wall"))), block, item);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(WoodType.OAK, STONE.setId(block.key(i+"_railing_gate")), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE.setId(block.key(i+"_pillar_wall"))), block, item);
	                grass_topped_wall = createBlockStone(i + "_grass_topped_wall", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", STONE.setId(block.key(i + "_grass_topped_wall"))), block, item);

	            } else {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE.setId(block.key("modern_"+i+"_wall"))), block, item);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE.setId(block.key("railing_"+i+"_wall"))), block, item);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(WoodType.OAK, STONE.setId(block.key(i+"_railing_gate")), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN), block, item);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE.setId(block.key(i+"_pillar_wall"))), block, item);
					grass_topped_wall = createBlockStone(i + "_grass_topped_wall", () -> new FenceBlock(STONE.setId(block.key(i + "_grass_topped_wall"))), block, item);
	            }
			}
	}

	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS_REGISTRY.key(name))));
        return block;
    }

	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS_REGISTRY.key(name))));
        return block;
    }

	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

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