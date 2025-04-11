package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.WoodType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class Fences
{
	private static final AbstractBlock.Settings wood = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
	private static final AbstractBlock.Settings leave = AbstractBlock.Settings.copy(Blocks.OAK_LEAVES);
	private static final AbstractBlock.Settings stone = AbstractBlock.Settings.copy(Blocks.COBBLESTONE);
	
	public static final String modid = "mcwfences";
	
	
	private static void registryEntry(String MODID, String name, Block b)
	{
    	Registry.register(Registries.BLOCK, new Identifier(MODID, name), b);
		Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
	}
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(String MODID, List<String> set)
	{
		setRegistrationWoodModLoaded(MODID, set, wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(String MODID, List<String> leaves)
	{
		setRegistrationHedgesModLoaded(MODID, leaves, leave);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(String MODID, List<String> rock)
	{
		setRegistrationRockModLoaded(MODID, rock, stone);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings WOOD = prop;

			for(String i : set)
			{				
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	final Block picket_fence = new FenceBlock(WOOD);
				    	final Block stockade_fence = new FenceBlock(WOOD);
				    	final Block horse_fence = new FenceBlock(WOOD);
				    	final Block wired_fence = Registration.getBlocksField("net.kikoz.mcwfences.objects.WiredFence", WOOD);
				    	final Block highley_gate = new FenceGateBlock(WoodType.OAK, WOOD);
				    	final Block pyramid_gate = new FenceGateBlock(WoodType.OAK, WOOD);
						final Block curved_gate = Registration.getBlocksField("net.kikoz.mcwfences.objects.DoubleGate", WOOD);
				    	
				        registryEntry(MODID, i + "_picket_fence", picket_fence);
				        registryEntry(MODID, i + "_stockade_fence", stockade_fence);
				        registryEntry(MODID, i + "_horse_fence", horse_fence);
			            registryEntry(MODID, i + "_wired_fence", wired_fence);
				        registryEntry(MODID, i + "_highley_gate", highley_gate);
				        registryEntry(MODID, i + "_pyramid_gate", pyramid_gate);
						registryEntry(MODID, i + "_curved_gate", curved_gate);
				    }
				    else
				    {
				        registryEntry(MODID, i + "_picket_fence", new FenceBlock(WOOD));
				        registryEntry(MODID, i + "_stockade_fence", new FenceBlock(WOOD));
				        registryEntry(MODID, i + "_horse_fence", new FenceBlock(WOOD));
				        registryEntry(MODID, i + "_wired_fence", new FenceBlock(WOOD));
				        registryEntry(MODID, i + "_highley_gate", new FenceGateBlock(WoodType.OAK, WOOD));
				        registryEntry(MODID, i + "_pyramid_gate", new FenceGateBlock(WoodType.OAK, WOOD));
						registryEntry(MODID, i + "_curved_gate", new FenceGateBlock(WoodType.OAK, prop));
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(String MODID, List<String> leaves, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings HEDGES = prop;
			
			for(String i : leaves)
			{
				try {
					if (AddonsLib.isLoaded(modid))
		        	{
						final Block hedge = Registration.getBlocksField("net.kikoz.mcwfences.objects.FenceHitbox", HEDGES);
		                registryEntry(MODID, i + "_hedge", hedge);
	
		            }
					else
		            {
		                registryEntry(MODID, i + "_hedge", new FenceBlock(HEDGES));
		            }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> rock, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings STONE = prop;

			for(String i : rock)
			{
				try {
					if (AddonsLib.isLoaded(modid))
					{
						final Block modern_wall = new FenceBlock(STONE);
						final Block railing_wall = new FenceBlock(STONE);
						final Block railing_gate = new FenceGateBlock(WoodType.OAK, STONE);
						final Block pillar_wall = new FenceBlock(STONE);
						final Block grass_topped_wall = Registration.getBlocksField("net.kikoz.mcwfences.objects.FenceHitbox", STONE);
						
						registryEntry(MODID, "modern_"+i+"_wall", modern_wall);
						registryEntry(MODID, "railing_"+i+"_wall", railing_wall);
						registryEntry(MODID, i+"_railing_gate", railing_gate);
						registryEntry(MODID, i+"_pillar_wall", pillar_wall);
		                registryEntry(MODID, i + "_grass_topped_wall", grass_topped_wall);
	
		            }
					else
		            {
						registryEntry(MODID, "modern_"+i+"_wall", new FenceBlock(STONE));
						registryEntry(MODID, "railing_"+i+"_wall", new FenceBlock(STONE));
						registryEntry(MODID, i+"_railing_gate", new FenceGateBlock(WoodType.OAK, STONE));
						registryEntry(MODID, i+"_pillar_wall", new FenceBlock(STONE));
						registryEntry(MODID, i+"_grass_topped_wall", new FenceBlock(STONE));
		            }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}

	public static void fuelWood(String MODID, List<String> WOOD)
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
			
			FuelRegistry.INSTANCE.add(picket_fence, 300);
			FuelRegistry.INSTANCE.add(stockade_fence, 300);
			FuelRegistry.INSTANCE.add(horse_fence, 300);
			FuelRegistry.INSTANCE.add(wired_fence, 300);
			FuelRegistry.INSTANCE.add(highley_gate, 300);
			FuelRegistry.INSTANCE.add(pyramid_gate, 300);
			FuelRegistry.INSTANCE.add(curved_gate, 300);
        }
	}

	public static void fuelHedge(String MODID, List<String> WOOD)
	{
		Block hedge;
		
		for (String i : WOOD)
		{
			hedge = Finder.findBlock(MODID, i + "_hedge");
			
			FuelRegistry.INSTANCE.add(hedge, 300);
        }
	}

	public static void addToTabWood(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab) {
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab, String modLoaded) {
		if (AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded)) {
			for (String i : WOOD) {
				final Block picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
				final Block stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
				final Block horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
				final Block wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
				final Block highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
				final Block pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
				final Block curved_gate = Finder.findBlock(MODID, i + "_curved_gate");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(picket_fence);
					content.add(stockade_fence);
					content.add(horse_fence);
					content.add(wired_fence);
					content.add(highley_gate);
					content.add(pyramid_gate);
					content.add(curved_gate);
				});
			}
		}
	}

	public static void addToTabLeave(String MODID, List<String> LEAVE, RegistryKey<ItemGroup> tab)
	{
		addToTabLeaveModLoaded(MODID, LEAVE, tab, "minecraft");
	}

	public static void addToTabLeaveModLoaded(String MODID, List<String> LEAVE, RegistryKey<ItemGroup> tab, String modLoaded)
	{
		if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
		{
			for (String i : LEAVE) {
				final Block hedge = Finder.findBlock(MODID, i + "_hedge");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(hedge);
				});
			}
		}
	}

	public static void addToTabStone(String MODID, List<String> ROCK, RegistryKey<ItemGroup> tab)
	{
		addToTabStoneModLoaded(MODID, ROCK, tab, "minecraft");
	}

	public static void addToTabStoneModLoaded(String MODID, List<String> ROCK, RegistryKey<ItemGroup> tab, String modLoaded)
	{
		if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
		{
			for (String i : ROCK)
			{
				final Block modern_wall = Finder.findBlock(MODID, "modern_"+i+"_wall");
				final Block railing_wall = Finder.findBlock(MODID, "railing_"+i+"_wall");
				final Block railing_gate = Finder.findBlock(MODID, i+"_railing_gate");
				final Block pillar_wall = Finder.findBlock(MODID, i+"_pillar_wall");
				final Block grass_topped_wall = Finder.findBlock(MODID, i + "_grass_topped_wall");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(modern_wall);
					content.add(railing_wall);
					content.add(railing_gate);
					content.add(pillar_wall);
					content.add(grass_topped_wall);
				});
			}
		}
	}
}