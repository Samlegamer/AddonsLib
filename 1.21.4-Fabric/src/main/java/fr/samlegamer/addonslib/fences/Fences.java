package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
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
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Fences
{
	private static AbstractBlock.Settings wood = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
	private static AbstractBlock.Settings leaves = AbstractBlock.Settings.copy(Blocks.OAK_LEAVES);
	private static AbstractBlock.Settings stone = AbstractBlock.Settings.copy(Blocks.COBBLESTONE);
	
	public static final String modid = "mcwfences";

	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
		final Identifier ID = Identifier.of(MODID, name);
		final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, ID);

		Registry.register(Registries.BLOCK, Identifier.of(MODID, name), b);

    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
    		Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue()))));
    	}
    	else {
    		Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue()))));
        }
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
				try {
					if (AddonsLib.isLoaded(modid))
					{
						final Block picket_fence = new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_picket_fence"))));
						final Block stockade_fence = new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_stockade_fence"))));
						final Block horse_fence = new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_horse_fence"))));
						final Block wired_fence = Registration.getBlocksField(
								"net.kikoz.mcwfences.objects.WiredFence",
								WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_wired_fence")))
						);
						final Block highley_gate = new FenceGateBlock(WoodType.OAK, WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_highley_gate"))));
						final Block pyramid_gate = new FenceGateBlock(WoodType.OAK, WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_pyramid_gate"))));

						registryEntry(MODID, i + "_picket_fence", picket_fence, tab, modLoaded);
						registryEntry(MODID, i + "_stockade_fence", stockade_fence, tab, modLoaded);
						registryEntry(MODID, i + "_horse_fence", horse_fence, tab, modLoaded);
						registryEntry(MODID, i + "_wired_fence", wired_fence, tab, modLoaded);
						registryEntry(MODID, i + "_highley_gate", highley_gate, tab, modLoaded);
						registryEntry(MODID, i + "_pyramid_gate", pyramid_gate, tab, modLoaded);
					}
					else
					{
						registryEntry(MODID, i + "_picket_fence", new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_picket_fence")))), tab, modLoaded);
						registryEntry(MODID, i + "_stockade_fence", new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_stockade_fence")))), tab, modLoaded);
						registryEntry(MODID, i + "_horse_fence", new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_horse_fence")))), tab, modLoaded);
						registryEntry(MODID, i + "_wired_fence", new FenceBlock(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_wired_fence")))), tab, modLoaded);
						registryEntry(MODID, i + "_highley_gate", new FenceGateBlock(WoodType.OAK, WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_highley_gate")))), tab, modLoaded);
						registryEntry(MODID, i + "_pyramid_gate", new FenceGateBlock(WoodType.OAK, WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_pyramid_gate")))), tab, modLoaded);
					}
				} catch (Exception e) {
				    e.printStackTrace();
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
				try {
					if (AddonsLib.isLoaded(modid))
		        	{
						final Block hedge = Registration.getBlocksField("net.kikoz.mcwfences.objects.FenceHitbox", HEDGES.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_hedge"))));
		                registryEntry(MODID, i + "_hedge", hedge, tab, modLoaded);
	
		            }
					else
		            {
		                registryEntry(MODID, i + "_hedge", new FenceBlock(HEDGES.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_hedge")))), tab, modLoaded);
		            }
				} catch (Exception e) {
				    e.printStackTrace();
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
				try {
					if (AddonsLib.isLoaded(modid))
					{
						final Block modern_wall = new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, "modern_" + i + "_wall"))));
						final Block railing_wall = new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, "railing_" + i + "_wall"))));
						final Block railing_gate = new FenceGateBlock(WoodType.OAK, STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_railing_gate"))));
						final Block pillar_wall = new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_pillar_wall"))));
						final Block grass_topped_wall = Registration.getBlocksField(
								"net.kikoz.mcwfences.objects.FenceHitbox",
								STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_grass_topped_wall")))
						);

						registryEntry(MODID, "modern_" + i + "_wall", modern_wall, tab, modLoaded);
						registryEntry(MODID, "railing_" + i + "_wall", railing_wall, tab, modLoaded);
						registryEntry(MODID, i + "_railing_gate", railing_gate, tab, modLoaded);
						registryEntry(MODID, i + "_pillar_wall", pillar_wall, tab, modLoaded);
						registryEntry(MODID, i + "_grass_topped_wall", grass_topped_wall, tab, modLoaded);
					}
					else
					{
						registryEntry(MODID, "modern_" + i + "_wall", new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, "modern_" + i + "_wall")))), tab, modLoaded);
						registryEntry(MODID, "railing_" + i + "_wall", new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, "railing_" + i + "_wall")))), tab, modLoaded);
						registryEntry(MODID, i + "_railing_gate", new FenceGateBlock(WoodType.OAK, STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_railing_gate")))), tab, modLoaded);
						registryEntry(MODID, i + "_pillar_wall", new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_pillar_wall")))), tab, modLoaded);
						registryEntry(MODID, i + "_grass_topped_wall", new FenceBlock(STONE.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i + "_grass_topped_wall")))), tab, modLoaded);
					}
				} catch (Exception ignored) {
				}
			}
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

			FuelRegistryEvents.BUILD.register((builder, context) -> {
				builder.add(picket_fence, 300);
				builder.add(stockade_fence, 300);
				builder.add(horse_fence, 300);
				builder.add(wired_fence, 300);
				builder.add(highley_gate, 300);
				builder.add(pyramid_gate, 300);
			});
        }
	}

	public static void fuelHedge(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
		{
			Block hedge;

			hedge = Finder.findBlock(MODID, i + "_hedge");
			
			FuelRegistryEvents.BUILD.register((builder, context) -> {
				builder.add(hedge, 300);
			});
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

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(picket_fence);
					content.add(stockade_fence);
					content.add(horse_fence);
					content.add(wired_fence);
					content.add(highley_gate);
					content.add(pyramid_gate);
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