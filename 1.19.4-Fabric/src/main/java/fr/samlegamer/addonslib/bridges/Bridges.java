package fr.samlegamer.addonslib.bridges;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

public class Bridges {
	public static final String modid = "mcwbridges";
	public static final String desc = "mcwbridges.bridges.desc";

	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(String MODID, List<String> set) {
		final AbstractBlock.Settings wood = AbstractBlock.Settings.of(Material.WOOD).strength(0.5F, 2.5F).sounds(BlockSoundGroup.WOOD);
		setRegistrationWoodModLoaded(MODID, set, wood);
	}

	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(String MODID, List<String> set) {
		final AbstractBlock.Settings stone = AbstractBlock.Settings.of(Material.STONE).strength(3.0F, 5.0F).sounds(BlockSoundGroup.STONE);
		setRegistrationRockModLoaded(MODID, set, stone);
	}

	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings STONE = prop;

		var modList = FabricLoader.getInstance();
		final boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block cryptic_stone_bridge = Registration.getBlocksField(blockId.reflectedLocation(), STONE);
					RegistryEntryReferences.registryEntry(MODID, id, cryptic_stone_bridge);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(STONE));
				}
			}
		}
	}

	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings WOOD = prop;

		var modList = FabricLoader.getInstance();
		final boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), WOOD);

					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(WOOD));
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD) {
		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;

		for (String i : WOOD) {
			log_bridge_middle = Finder.findBlock(MODID, i + "_log_bridge_middle");
			rope_bridge = Finder.findBlock(MODID, "rope_" + i + "_bridge");
			bridge_pier = Finder.findBlock(MODID, i + "_bridge_pier");
			log_bridge_stair = Finder.findBlock(MODID, i + "_log_bridge_stair");
			rope_bridge_stair = Finder.findBlock(MODID, i + "_rope_bridge_stair");
			rail_bridge = Finder.findBlock(MODID, i + "_rail_bridge");

			FuelRegistry.INSTANCE.add(log_bridge_middle, 300);
			FuelRegistry.INSTANCE.add(rope_bridge, 300);
			FuelRegistry.INSTANCE.add(bridge_pier, 300);
			FuelRegistry.INSTANCE.add(log_bridge_stair, 300);
			FuelRegistry.INSTANCE.add(rope_bridge_stair, 300);
			FuelRegistry.INSTANCE.add(rail_bridge, 300);
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, ItemGroup tab, String modLoaded) {
		FabricLoader modList = FabricLoader.getInstance();

		if (modList.isModLoaded(modid) && modList.isModLoaded(modLoaded)) {
			for (String i : WOOD) {
				final Block log_bridge_middle = Finder.findBlock(MODID, i + "_log_bridge_middle");
				final Block rope_bridge = Finder.findBlock(MODID, "rope_" + i + "_bridge");
				final Block bridge_pier = Finder.findBlock(MODID, i + "_bridge_pier");
				final Block log_bridge_stair = Finder.findBlock(MODID, i + "_log_bridge_stair");
				final Block rope_bridge_stair = Finder.findBlock(MODID, i + "_rope_bridge_stair");
				final Block rail_bridge = Finder.findBlock(MODID, i + "_rail_bridge");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(log_bridge_middle);
					content.add(rope_bridge);
					content.add(bridge_pier);
					content.add(log_bridge_stair);
					content.add(rope_bridge_stair);
					content.add(rail_bridge);
				});
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWood(String MODID, List<String> WOOD, ItemGroup tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStone(String MODID, List<String> ROCK, ItemGroup tab)
	{
		addToTabStoneModLoaded(MODID, ROCK, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStoneModLoaded(String MODID, List<String> ROCK, ItemGroup tab, String modLoaded)
	{
		FabricLoader modList = FabricLoader.getInstance();

		if(modList.isModLoaded(modid) && modList.isModLoaded(modLoaded))
		{
			for (String i : ROCK)
			{
				final Block stone_bridge = Finder.findBlock(MODID, i+"_bridge");
				final Block stone_bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
				final Block stone_bridge_stair = Finder.findBlock(MODID, i+"_bridge_stair");
				final Block balustrade_stone_bridge = Finder.findBlock(MODID, "balustrade_"+i+"_bridge");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(stone_bridge);
					content.add(stone_bridge_pier);
					content.add(stone_bridge_stair);
					content.add(balustrade_stone_bridge);
				});
			}
		}
	}
}