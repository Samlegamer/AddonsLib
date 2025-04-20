package fr.samlegamer.addonslib.fences;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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

		//DeferredBlock<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					createBlock(id, registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					createBlock(id, registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
				} else if(isModLoaded) {
					createBlock(id, registryName -> Registration.getBlocksFieldForFences(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					createBlock(id, registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}

//			if (ModList.get().isLoaded(modid))
//			{
//				try {
//					for(String i : set)
//					{
//					{
//
//						picket_fence = createBlock(i + "_picket_fence", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						stockade_fence = createBlock(i + "_stockade_fence", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						horse_fence = createBlock(i + "_horse_fence", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						wired_fence = createBlock(i + "_wired_fence", registryName -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.WiredFence", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						highley_gate = createBlock(i + "_highley_gate", registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
//						pyramid_gate = createBlock(i + "_pyramid_gate", registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
//						curved_gate = createBlock(i + "_curved_gate", registryName -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.DoubleGate", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					}
//					else
//					{
//						picket_fence = createBlock(i + "_picket_fence", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						stockade_fence = createBlock(i + "_stockade_fence", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						horse_fence = createBlock(i + "_horse_fence", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						wired_fence = createBlock(i + "_wired_fence", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						highley_gate = createBlock(i + "_highley_gate", registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
//						pyramid_gate = createBlock(i + "_pyramid_gate", registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
//						curved_gate = createBlock(i + "_curved_gate", registryName -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					}
//					}
//				} catch (Exception e) {
//					AddonsLib.LOGGER.error(e);
//				}
//			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties HEDGES = prop;

		//DeferredBlock<Block> hedge;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlock(id, registryName -> Registration.getBlocksFieldForFences(blockId.reflectedLocation(), HEDGES.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					createBlock(id, registryName -> new FenceBlock(HEDGES.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
//		for(String i : leaves)
//			{
//				if (ModList.get().isLoaded(modid))
//	        	{
//					hedge = createBlock(i + "_hedge", registryName -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//
//				} else {
//					hedge = createBlock(i + "_hedge", registryName -> new FenceBlock(HEDGES.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//	            }
//			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		//DeferredBlock<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					createBlockStone(id, registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					createBlockStone(id, registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
				} else if(isModLoaded) {
					createBlockStone(id, registryName -> Registration.getBlocksFieldForFences(blockId.reflectedLocation(), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					createBlockStone(id, registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
//			for(String i : rock)
//			{
//				if (ModList.get().isLoaded(modid)) {
//					modern_wall = createBlockStone("modern_" + i + "_wall",
//							registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					railing_wall = createBlockStone("railing_" + i + "_wall",
//							registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					railing_gate = createBlockStone(i + "_railing_gate",
//							registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
//					pillar_wall = createBlockStone(i + "_pillar_wall",
//							registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					grass_topped_wall = createBlockStone(i + "_grass_topped_wall",
//							registryName -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//				} else {
//					modern_wall = createBlockStone("modern_" + i + "_wall",
//							registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					railing_wall = createBlockStone("railing_" + i + "_wall",
//							registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					railing_gate = createBlockStone(i + "_railing_gate",
//							registryName -> new FenceGateBlock(Optional.of(WoodType.OAK), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName)), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item);
//					pillar_wall = createBlockStone(i + "_pillar_wall",
//							registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					grass_topped_wall = createBlockStone(i + "_grass_topped_wall",
//							registryName -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//				}			}
	}
	
	protected static void createBlock(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
	}
	
	protected static void createBlockStone(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		ITEMS_REGISTRY.register(name, registryName -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
	}

	@Deprecated(forRemoval = true)
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

	@Deprecated(forRemoval = true)
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

	@Deprecated(forRemoval = true)
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