package fr.samlegamer.addonslib.fences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Fences
{
	private static final List<RegistryObject<Block>> FENCE_BLOCKS = new ArrayList<>();

	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{
				RegistryObject<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;
				
				try {
				    if (ModList.get().isLoaded("mcwfences"))
				    {
				        picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item, tab);
				        stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab);
				        horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item, tab);
			            wired_fence = createBlock(i + "_wired_fence", () -> Registration.getBlocksField("com.mcwfences.kikoz.objects.WiredFence", WOOD, new FenceBlock(WOOD)), block, item, tab);
				        highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
				        pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
				    } else {
				        picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item, tab);
				        stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab);
				        horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item, tab);
				        wired_fence = createBlock(i + "_wired_fence", () -> new FenceBlock(WOOD), block, item, tab);
				        highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
				        pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
				    }
					FENCE_BLOCKS.add(picket_fence);
			        FENCE_BLOCKS.add(stockade_fence);
			        FENCE_BLOCKS.add(horse_fence);
			        FENCE_BLOCKS.add(wired_fence);
			        FENCE_BLOCKS.add(highley_gate);
			        FENCE_BLOCKS.add(pyramid_gate);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties HEDGES = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);

			for(String i : leaves)
			{
				RegistryObject<Block> hedge;
				
				if (ModList.get().isLoaded("mcwfences"))
	        	{
	                hedge = createBlock(i + "_hedge", () -> Registration.getBlocksField("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES, new FenceBlock(HEDGES)), block, item, tab);

	            } else {
	                hedge = createBlock(i + "_hedge", () -> new FenceBlock(HEDGES), block, item, tab);
	            }
				
				FENCE_BLOCKS.add(hedge);
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.CUT_SANDSTONE);

			for(String i : rock)
			{
				RegistryObject<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
		       
				if (ModList.get().isLoaded("mcwfences")) {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab);
	                grass_topped_wall = createBlock(i + "_grass_topped_wall", () -> Registration.getBlocksField("com.mcwfences.kikoz.objects.FenceHitbox", STONE, new FenceBlock(STONE)), block, item, tab);

	            } else {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab);
					grass_topped_wall = createBlockStone(i+"_grass_topped_wall", () -> new FenceBlock(STONE), block, item, tab);
	            }
				
				FENCE_BLOCKS.add(modern_wall);
		        FENCE_BLOCKS.add(railing_wall);
		        FENCE_BLOCKS.add(railing_gate);
		        FENCE_BLOCKS.add(pillar_wall);
		        FENCE_BLOCKS.add(grass_topped_wall);
			}
	}
	
	
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{
				RegistryObject<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;
				
				try {
				    if (ModList.get().isLoaded("mcwfences"))
				    {
				        picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				        stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				        horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
			            wired_fence = createBlock(i + "_wired_fence", () -> Registration.getBlocksField("com.mcwfences.kikoz.objects.WiredFence", WOOD, new FenceBlock(WOOD)), block, item, tab, modLoaded);
				        highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
				        pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
				    } else {
				        picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				        stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				        horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				        wired_fence = createBlock(i + "_wired_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				        highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
				        pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
				    }
					FENCE_BLOCKS.add(picket_fence);
			        FENCE_BLOCKS.add(stockade_fence);
			        FENCE_BLOCKS.add(horse_fence);
			        FENCE_BLOCKS.add(wired_fence);
			        FENCE_BLOCKS.add(highley_gate);
			        FENCE_BLOCKS.add(pyramid_gate);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Properties HEDGES = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);

			for(String i : leaves)
			{
				RegistryObject<Block> hedge;
				
				if (ModList.get().isLoaded("mcwfences"))
	        	{
	                hedge = createBlock(i + "_hedge", () -> Registration.getBlocksField("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES, new FenceBlock(HEDGES)), block, item, tab, modLoaded);

	            } else {
	                hedge = createBlock(i + "_hedge", () -> new FenceBlock(HEDGES), block, item, tab, modLoaded);
	            }
				
				FENCE_BLOCKS.add(hedge);
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.CUT_SANDSTONE);

			for(String i : rock)
			{
				RegistryObject<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
		       
				if (ModList.get().isLoaded("mcwfences")) {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab, modLoaded);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
	                grass_topped_wall = createBlock(i + "_grass_topped_wall", () -> Registration.getBlocksField("com.mcwfences.kikoz.objects.FenceHitbox", STONE, new FenceBlock(STONE)), block, item, tab, modLoaded);

	            } else {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab, modLoaded);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					grass_topped_wall = createBlockStone(i+"_grass_topped_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
	            }
				
				FENCE_BLOCKS.add(modern_wall);
		        FENCE_BLOCKS.add(railing_wall);
		        FENCE_BLOCKS.add(railing_gate);
		        FENCE_BLOCKS.add(pillar_wall);
		        FENCE_BLOCKS.add(grass_topped_wall);
			}
	}
	
	public static List<RegistryObject<Block>> getFenceBlocks() {
		return FENCE_BLOCKS;
	}
	
	/**
	 * Use this to set Render Fences
	 */
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : FENCE_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	/*Add Logo Item for Used*/
	@Deprecated
	public static Block getTabIcon()
	{
		return FENCE_BLOCKS.get(0).get();
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwfences"))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
        return block;
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwfences") && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
        return block;
    }

	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwfences"))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
        return block;
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwfences") && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
        return block;
    }
}
