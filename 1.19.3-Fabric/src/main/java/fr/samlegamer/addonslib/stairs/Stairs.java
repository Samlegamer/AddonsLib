package fr.samlegamer.addonslib.stairs;

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

public class Stairs {
	public static final String modid = "mcwstairs";

	public static void setRegistrationWood(String MODID, List<String> set) {
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 2.3F).sounds(BlockSoundGroup.WOOD);
		setRegistrationWoodModLoaded(MODID, set, WOOD);
	}

	public static void setRegistrationRock(String MODID, List<String> set) {
		final AbstractBlock.Settings STONE = AbstractBlock.Settings.of(Material.STONE).strength(2.0F, 2.3F).sounds(BlockSoundGroup.STONE).requiresTool();
		setRegistrationRockModLoaded(MODID, set, STONE);
	}

	public static void setRegistrationRockModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings STONE = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), STONE);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new Block(STONE));
				}
			}
		}
	}

	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop) {
		final AbstractBlock.Settings WOOD = prop;

		var modList = FabricLoader.getInstance();
		boolean isModMcwLoaded = modList.isModLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
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
		for (String i : WOOD) {
			Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;
			_terrace_stairs = Finder.findBlock(MODID, i + "_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i + "_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i + "_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i + "_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i + "_loft_stairs");
			_railing = Finder.findBlock(MODID, i + "_railing");
			_balcony = Finder.findBlock(MODID, i + "_balcony");
			_platform = Finder.findBlock(MODID, i + "_platform");

			FuelRegistry.INSTANCE.add(_terrace_stairs, 300);
			FuelRegistry.INSTANCE.add(_skyline_stairs, 300);
			FuelRegistry.INSTANCE.add(_compact_stairs, 300);
			FuelRegistry.INSTANCE.add(_bulk_stairs, 300);
			FuelRegistry.INSTANCE.add(_loft_stairs, 300);
			FuelRegistry.INSTANCE.add(_railing, 300);
			FuelRegistry.INSTANCE.add(_balcony, 300);
			FuelRegistry.INSTANCE.add(_platform, 300);
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWood(String MODID, List<String> WOOD, ItemGroup tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, ItemGroup tab, String modLoaded)
	{
		var modList = FabricLoader.getInstance();

		if(modList.isModLoaded(modid) && modList.isModLoaded(modLoaded))
		{
			for (String i : WOOD)
			{
				final Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;
				_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
				_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
				_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
				_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
				_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
				_railing = Finder.findBlock(MODID, i+"_railing");
				_balcony = Finder.findBlock(MODID, i+"_balcony");
				_platform = Finder.findBlock(MODID, i+"_platform");
				
				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(_terrace_stairs);
					content.add(_skyline_stairs);
					content.add(_compact_stairs);
					content.add(_bulk_stairs);
					content.add(_loft_stairs);
					content.add(_railing);
					content.add(_balcony);
					content.add(_platform);
				});
			}
		}
	}
}