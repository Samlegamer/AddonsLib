package fr.samlegamer.addonslib.fences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.mcwfences.kikoz.objects.FenceHitbox;
import com.mcwfences.kikoz.objects.FuelItemBlock;
import com.mcwfences.kikoz.objects.WiredFence;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.WallBlock;
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

	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{
				RegistryObject<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;

		        if(ModList.get().isLoaded("mcwfences"))
		        {
					picket_fence = createBlock(i+"_picket_fence", () -> new FenceBlock(WOOD), block, item, tab);
					stockade_fence = createBlock(i+"_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab);
					horse_fence = createBlock(i+"_horse_fence", () -> new FenceBlock(WOOD), block, item, tab);
					wired_fence = createBlock(i+"_wired_fence", () -> new WiredFence(WOOD), block, item, tab);
					highley_gate = createBlock(i+"_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
					pyramid_gate = createBlock(i+"_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
		        }
		        else
		        {
					picket_fence = createBlock(i+"_picket_fence", () -> new FenceBlock(WOOD), block, item, tab);
					stockade_fence = createBlock(i+"_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab);
					horse_fence = createBlock(i+"_horse_fence", () -> new FenceBlock(WOOD), block, item, tab);
					wired_fence = createBlock(i+"_wired_fence", () -> new FenceBlock(WOOD), block, item, tab);
					highley_gate = createBlock(i+"_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
					pyramid_gate = createBlock(i+"_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab);
		        }
				FENCE_BLOCKS.add(picket_fence);
		        FENCE_BLOCKS.add(stockade_fence);
		        FENCE_BLOCKS.add(horse_fence);
		        FENCE_BLOCKS.add(wired_fence);
		        FENCE_BLOCKS.add(highley_gate);
		        FENCE_BLOCKS.add(pyramid_gate);
			}
	}
	
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties HEDGES = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);

			for(String i : leaves)
			{
				RegistryObject<Block> hedge;
				
		        if(ModList.get().isLoaded("mcwfences"))
		        {
		        	hedge = createBlock(i+"_hedge", () -> new FenceHitbox(HEDGES), block, item, tab);
		        }
		        else
		        {
		        	hedge = createBlock(i+"_hedge", () -> new WallBlock(HEDGES), block, item, tab);
		        }
				FENCE_BLOCKS.add(hedge);
			}
	}
	
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.CUT_SANDSTONE);

			for(String i : rock)
			{
				RegistryObject<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
		       
				if(ModList.get().isLoaded("mcwfences"))
		        {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab);
					grass_topped_wall = createBlockStone(i+"_grass_topped_wall", () -> new FenceHitbox(STONE), block, item, tab);

		        }
		        else
		        {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab);
					grass_topped_wall = createBlockStone(i+"_grass_topped_wall", () -> new WallBlock(STONE), block, item, tab);

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
	
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : FENCE_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	public static Block getTabIcon()
	{
		return FENCE_BLOCKS.get(0).get();
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwfences"))
        {
            ITEMS_REGISTRY.register(name, () -> new FuelItemBlock(block.get(), new Item.Properties().tab(tab)));
        }
        return block;
    }

	public static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwfences"))
        {
        	ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        }
        return block;
    }
}
