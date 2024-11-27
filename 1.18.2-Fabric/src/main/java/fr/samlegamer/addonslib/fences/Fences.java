package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Fences
{
	private static AbstractBlock.Settings wood = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
	private static AbstractBlock.Settings leaves = AbstractBlock.Settings.copy(Blocks.OAK_LEAVES);
	private static AbstractBlock.Settings stone = AbstractBlock.Settings.copy(Blocks.COBBLESTONE);
	
	public static final String modid = "mcwfences";
	
	
	private static Block registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
    	}
    	else {
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
    	
    	return b;
	}
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(String MODID, List<String> leaves, ItemGroup tab)
	{
		setRegistrationHedgesModLoaded(MODID, leaves, tab, "minecraft", Fences.leaves);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(String MODID, List<String> rock, ItemGroup tab)
	{
		setRegistrationRockModLoaded(MODID, rock, tab, "minecraft", stone);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings WOOD = prop;

			for(String i : set)
			{				
				Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				        picket_fence = registryEntry(MODID, i + "_picket_fence", new FenceBlock(WOOD), tab, modLoaded);
				        stockade_fence = registryEntry(MODID, i + "_stockade_fence", new FenceBlock(WOOD), tab, modLoaded);
				        horse_fence = registryEntry(MODID, i + "_horse_fence", new FenceBlock(WOOD), tab, modLoaded);
			            wired_fence = registryEntry(MODID, i + "_wired_fence", Registration.getBlocksFieldFenceBlock("net.kikoz.mcwfences.objects.WiredFence", WOOD), tab, modLoaded);
				        highley_gate = registryEntry(MODID, i + "_highley_gate", new FenceGateBlock(WOOD), tab, modLoaded);
				        pyramid_gate = registryEntry(MODID, i + "_pyramid_gate", new FenceGateBlock(WOOD), tab, modLoaded);
				    } else {
				        picket_fence = registryEntry(MODID, i + "_picket_fence", new FenceBlock(WOOD), tab, modLoaded);
				        stockade_fence = registryEntry(MODID, i + "_stockade_fence", new FenceBlock(WOOD), tab, modLoaded);
				        horse_fence = registryEntry(MODID, i + "_horse_fence", new FenceBlock(WOOD), tab, modLoaded);
				        wired_fence = registryEntry(MODID, i + "_wired_fence", new FenceBlock(WOOD), tab, modLoaded);
				        highley_gate = registryEntry(MODID, i + "_highley_gate", new FenceGateBlock(WOOD), tab, modLoaded);
				        pyramid_gate = registryEntry(MODID, i + "_pyramid_gate", new FenceGateBlock(WOOD), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
			        picket_fence = registryEntry(MODID, i + "_picket_fence", new FenceBlock(WOOD), tab, modLoaded);
			        stockade_fence = registryEntry(MODID, i + "_stockade_fence", new FenceBlock(WOOD), tab, modLoaded);
			        horse_fence = registryEntry(MODID, i + "_horse_fence", new FenceBlock(WOOD), tab, modLoaded);
		            wired_fence = registryEntry(MODID, i + "_wired_fence", new FenceBlock(WOOD), tab, modLoaded);
			        highley_gate = registryEntry(MODID, i + "_highley_gate", new FenceGateBlock(WOOD), tab, modLoaded);
			        pyramid_gate = registryEntry(MODID, i + "_pyramid_gate", new FenceGateBlock(WOOD), tab, modLoaded);
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(String MODID, List<String> leaves, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings HEDGES = prop;

			for(String i : leaves)
			{
				Block hedge;
				try {
					if (AddonsLib.isLoaded(modid))
		        	{
		                hedge = registryEntry(MODID, i + "_hedge", Registration.getBlocksFieldFenceBlock("net.kikoz.mcwfences.objects.FenceHitbox", HEDGES), tab, modLoaded);

		            } else {
		                hedge = registryEntry(MODID, i + "_hedge", new FenceBlock(HEDGES), tab, modLoaded);
		            }
				} catch (Exception e) {
				    e.printStackTrace();
	                hedge = registryEntry(MODID, i + "_hedge", new FenceBlock(HEDGES), tab, modLoaded);
				}
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> rock, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings STONE = prop;

			for(String i : rock)
			{
				Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
				try {
					if (AddonsLib.isLoaded(modid)) {
						modern_wall = registryEntry(MODID, "modern_"+i+"_wall", new FenceBlock(STONE), tab, modLoaded);
						railing_wall = registryEntry(MODID, "railing_"+i+"_wall", new FenceBlock(STONE), tab, modLoaded);
						railing_gate = registryEntry(MODID, i+"_railing_gate", new FenceGateBlock(STONE), tab, modLoaded);
						pillar_wall = registryEntry(MODID, i+"_pillar_wall", new FenceBlock(STONE), tab, modLoaded);
		                grass_topped_wall = registryEntry(MODID, i + "_grass_topped_wall", Registration.getBlocksFieldFenceBlock("net.kikoz.mcwfences.objects.FenceHitbox", STONE), tab, modLoaded);

		            } else {
						modern_wall = registryEntry(MODID, "modern_"+i+"_wall", new FenceBlock(STONE), tab, modLoaded);
						railing_wall = registryEntry(MODID, "railing_"+i+"_wall", new FenceBlock(STONE), tab, modLoaded);
						railing_gate = registryEntry(MODID, i+"_railing_gate", new FenceGateBlock(STONE), tab, modLoaded);
						pillar_wall = registryEntry(MODID, i+"_pillar_wall", new FenceBlock(STONE), tab, modLoaded);
						grass_topped_wall = registryEntry(MODID, i+"_grass_topped_wall", new FenceBlock(STONE), tab, modLoaded);
		            }
				} catch (Exception e) {
				    e.printStackTrace();
					modern_wall = registryEntry(MODID, "modern_"+i+"_wall", new FenceBlock(STONE), tab, modLoaded);
					railing_wall = registryEntry(MODID, "railing_"+i+"_wall", new FenceBlock(STONE), tab, modLoaded);
					railing_gate = registryEntry(MODID, i+"_railing_gate", new FenceGateBlock(STONE), tab, modLoaded);
					pillar_wall = registryEntry(MODID, i+"_pillar_wall", new FenceBlock(STONE), tab, modLoaded);
	                grass_topped_wall = registryEntry(MODID, i + "_grass_topped_wall", new FenceBlock(STONE), tab, modLoaded);
				}
			}
	}
	
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		for (String i : WOOD)
		{
			Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;
			picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
			stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
			horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
			wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
			highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
			pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
			
			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet
        	, picket_fence
        	, stockade_fence
        	, horse_fence
        	, wired_fence
        	, highley_gate
        	, pyramid_gate);
        }
	}

	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}

	public static void clientHedge(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		for (String i : WOOD)
		{
			Block hedge;
			
			hedge = Finder.findBlock(MODID, i + "_hedge");
			
			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet,hedge);
        }
	}
	
	public static void clientHedge(String MODID, List<String> WOOD)
	{
		clientHedge(MODID, WOOD, RenderLayer.getCutout());
	}
	
	public static void clientStone(String MODID, List<String> STONE, RenderLayer renderSet)
	{
		for (String i : STONE)
		{
			Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
			
			modern_wall = Finder.findBlock(MODID, "modern_"+i+"_wall");
			railing_wall = Finder.findBlock(MODID, "railing_"+i+"_wall");
			railing_gate = Finder.findBlock(MODID, i+"_railing_gate");
			pillar_wall = Finder.findBlock(MODID, i+"_pillar_wall");
			grass_topped_wall = Finder.findBlock(MODID, i + "_grass_topped_wall");
			
			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet
        	, modern_wall
        	, railing_wall
        	, railing_gate
        	, pillar_wall
        	, grass_topped_wall);
        }
	}
	
	public static void clientStone(String MODID, List<String> STONE)
	{
		clientStone(MODID, STONE, RenderLayer.getCutout());
	}

	public static void fuelWood(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
		{
			Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate;
			
			picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
			stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
			horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
			wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
			highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
			pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
			
			FuelRegistry.INSTANCE.add(picket_fence, 300);
			FuelRegistry.INSTANCE.add(stockade_fence, 300);
			FuelRegistry.INSTANCE.add(horse_fence, 300);
			FuelRegistry.INSTANCE.add(wired_fence, 300);
			FuelRegistry.INSTANCE.add(highley_gate, 300);
			FuelRegistry.INSTANCE.add(pyramid_gate, 300);
        }
	}

	public static void fuelHedge(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
		{
			Block hedge;
			
			hedge = Finder.findBlock(MODID, i + "_hedge");
			
			FuelRegistry.INSTANCE.add(hedge, 300);
        }
	}
}