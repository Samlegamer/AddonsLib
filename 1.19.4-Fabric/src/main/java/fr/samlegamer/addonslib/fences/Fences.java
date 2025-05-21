package fr.samlegamer.addonslib.fences;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroup;

public class Fences {
	public static final String modid = "mcwfences";

	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(String MODID, List<String> set) {
		setRegistrationWoodModLoaded(MODID, set, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
	}

	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(String MODID, List<String> leaves) {
		setRegistrationHedgesModLoaded(MODID, leaves, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES));
	}

	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(String MODID, List<String> rock) {
		setRegistrationRockModLoaded(MODID, rock, AbstractBlock.Settings.copy(Blocks.COBBLESTONE));
	}

	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings WOOD = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(WOOD));
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(WOOD, WoodType.OAK));
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), WOOD);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(WOOD));
				}
			}
		}
	}

	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(String MODID, List<String> leaves, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings HEDGES = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), HEDGES);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(HEDGES));
				}
			}
		}
	}

	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> rock, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings STONE = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(STONE));
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceGateBlock(STONE, WoodType.OAK));
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), STONE);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new FenceBlock(STONE));
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD) {
		Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

		for (String i : WOOD) {
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

	@Deprecated(forRemoval = true)
	public static void fuelHedge(String MODID, List<String> WOOD) {
		Block hedge;

		for (String i : WOOD) {
			hedge = Finder.findBlock(MODID, i + "_hedge");

			FuelRegistry.INSTANCE.add(hedge, 300);
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWood(String MODID, List<String> WOOD, ItemGroup tab) {
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, ItemGroup tab, String modLoaded) {
		var modList = FabricLoader.getInstance();

		if (modList.isModLoaded(modid) && modList.isModLoaded(modLoaded)) {
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

	@Deprecated(forRemoval = true)
	public static void addToTabLeave(String MODID, List<String> LEAVE, ItemGroup tab) {
		addToTabLeaveModLoaded(MODID, LEAVE, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabLeaveModLoaded(String MODID, List<String> LEAVE, ItemGroup tab, String modLoaded) {
		var modList = FabricLoader.getInstance();

		if (modList.isModLoaded(modid) && modList.isModLoaded(modLoaded)) {
			for (String i : LEAVE) {
				final Block hedge = Finder.findBlock(MODID, i + "_hedge");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(hedge);
				});
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStone(String MODID, List<String> ROCK, ItemGroup tab)
	{
		addToTabStoneModLoaded(MODID, ROCK, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStoneModLoaded(String MODID, List<String> ROCK, ItemGroup tab, String modLoaded)
	{
		var modList = FabricLoader.getInstance();

		if(modList.isModLoaded(modid) && modList.isModLoaded(modLoaded))
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