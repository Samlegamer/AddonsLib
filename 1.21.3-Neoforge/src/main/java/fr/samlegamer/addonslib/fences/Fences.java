package fr.samlegamer.addonslib.fences;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
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
	private static BlockBehaviour.Properties wood = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
	private static BlockBehaviour.Properties leaves = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES);
	private static BlockBehaviour.Properties stone = BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE);
	
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationHedgesModLoaded(leaves, mod, block, item, tab, "minecraft", Fences.leaves);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationRockModLoaded(rock, mod, block, item, tab, "minecraft", stone);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;

			DeferredBlock<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;

			for(String i : set)
			{				
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						picket_fence = createBlock(mod, i + "_picket_fence", () -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_picket_fence")))), block, item, tab, modLoaded);
						stockade_fence = createBlock(mod, i + "_stockade_fence", () -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stockade_fence")))), block, item, tab, modLoaded);
						horse_fence = createBlock(mod, i + "_horse_fence", () -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_horse_fence")))), block, item, tab, modLoaded);
						wired_fence = createBlock(mod, i + "_wired_fence", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.WiredFence", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_wired_fence")))), block, item, tab, modLoaded);
						highley_gate = createBlock(mod, i + "_highley_gate", () -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_highley_gate"))), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item, tab, modLoaded);
						pyramid_gate = createBlock(mod, i + "_pyramid_gate", () -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_pyramid_gate"))), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item, tab, modLoaded);
					} else {
						picket_fence = createBlock(mod, i + "_picket_fence", () -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_picket_fence")))), block, item, tab, modLoaded);
						stockade_fence = createBlock(mod, i + "_stockade_fence", () -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stockade_fence")))), block, item, tab, modLoaded);
						horse_fence = createBlock(mod, i + "_horse_fence", () -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_horse_fence")))), block, item, tab, modLoaded);
						wired_fence = createBlock(mod, i + "_wired_fence", () -> new FenceBlock(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_wired_fence")))), block, item, tab, modLoaded);
						highley_gate = createBlock(mod, i + "_highley_gate", () -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_highley_gate"))), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item, tab, modLoaded);
						pyramid_gate = createBlock(mod, i + "_pyramid_gate", () -> new FenceGateBlock(Optional.of(WoodType.OAK), WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_pyramid_gate"))), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties HEDGES = prop;

			DeferredBlock<Block> hedge;

			for(String i : leaves)
			{
				if (ModList.get().isLoaded(modid))
	        	{
					hedge = createBlock(mod, i + "_hedge", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_hedge")))), block, item, tab, modLoaded);

				} else {
					hedge = createBlock(mod, i + "_hedge", () -> new FenceBlock(HEDGES.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_hedge")))), block, item, tab, modLoaded);
	            }
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties STONE = prop;

			DeferredBlock<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

			for(String i : rock)
			{
				if (ModList.get().isLoaded(modid)) {
					modern_wall = createBlockStone(mod, "modern_"+i+"_wall", () -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "modern_"+i+"_wall")))), block, item, tab, modLoaded);
					railing_wall = createBlockStone(mod, "railing_"+i+"_wall", () -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "railing_"+i+"_wall")))), block, item, tab, modLoaded);
					railing_gate = createBlockStone(mod, i+"_railing_gate", () -> new FenceGateBlock(Optional.of(WoodType.OAK), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_railing_gate"))), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item, tab, modLoaded);
					pillar_wall = createBlockStone(mod, i+"_pillar_wall", () -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_pillar_wall")))), block, item, tab, modLoaded);
					grass_topped_wall = createBlockStone(mod, i + "_grass_topped_wall", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i + "_grass_topped_wall")))), block, item, tab, modLoaded);

				} else {
					modern_wall = createBlockStone(mod, "modern_"+i+"_wall", () -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "modern_"+i+"_wall")))), block, item, tab, modLoaded);
					railing_wall = createBlockStone(mod, "railing_"+i+"_wall", () -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "railing_"+i+"_wall")))), block, item, tab, modLoaded);
					railing_gate = createBlockStone(mod, i+"_railing_gate", () -> new FenceGateBlock(Optional.of(WoodType.OAK), STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_railing_gate"))), Optional.of(SoundEvents.FENCE_GATE_CLOSE), Optional.of(SoundEvents.FENCE_GATE_OPEN)), block, item, tab, modLoaded);
					pillar_wall = createBlockStone(mod, i+"_pillar_wall", () -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_pillar_wall")))), block, item, tab, modLoaded);
					grass_topped_wall = createBlockStone(mod, i + "_grass_topped_wall", () -> new FenceBlock(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i + "_grass_topped_wall")))), block, item, tab, modLoaded);
	            }
			}
	}
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
        return block;
    }

	protected static DeferredBlock<Block> createBlockStone(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlockStone(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlockStone(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
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