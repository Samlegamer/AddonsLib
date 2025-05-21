package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Trapdoors
{
	public static final String modid = "mcwtrpdoors";

	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(String MODID, List<String> set)
	{
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR);
		setRegistrationWoodModLoaded(MODID, set, WOOD);
	}

	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop)
	{
		final AbstractBlock.Settings WOOD = prop;

		for(String i : set)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				RegistryEntryReferences.registryEntry(MODID, id, new TrapdoorBlock(BlockSetType.OAK, WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, id)))));
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
		{
			Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor,
					tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

			barn_trapdoor = Finder.findBlock(MODID, i + "_barn_trapdoor");
			cottage_trapdoor = Finder.findBlock(MODID, i + "_cottage_trapdoor");
			barred_trapdoor = Finder.findBlock(MODID, i + "_barred_trapdoor");
			beach_trapdoor = Finder.findBlock(MODID, i + "_beach_trapdoor");
			four_panel_trapdoor = Finder.findBlock(MODID, i + "_four_panel_trapdoor");
			glass_trapdoor = Finder.findBlock(MODID, i + "_glass_trapdoor");
			mystic_trapdoor = Finder.findBlock(MODID, i + "_mystic_trapdoor");
			paper_trapdoor = Finder.findBlock(MODID, i + "_paper_trapdoor");
			tropical_trapdoor = Finder.findBlock(MODID, i + "_tropical_trapdoor");
			swamp_trapdoor = Finder.findBlock(MODID, i + "_swamp_trapdoor");
			bamboo_trapdoor = Finder.findBlock(MODID, i + "_bamboo_trapdoor");
			classic_trapdoor = Finder.findBlock(MODID, i + "_classic_trapdoor");
			bark_trapdoor = Finder.findBlock(MODID, i + "_bark_trapdoor");
			ranch_trapdoor = Finder.findBlock(MODID, i + "_ranch_trapdoor");
			blossom_trapdoor = Finder.findBlock(MODID, i + "_blossom_trapdoor");
			barrel_trapdoor = Finder.findBlock(MODID, i + "_barrel_trapdoor");
			whispering_trapdoor = Finder.findBlock(MODID, i + "_whispering_trapdoor");

			FuelRegistryEvents.BUILD.register((builder, context) -> {
				builder.add(barn_trapdoor, 300);
				builder.add(cottage_trapdoor, 300);
				builder.add(barred_trapdoor, 300);
				builder.add(beach_trapdoor, 300);
				builder.add(four_panel_trapdoor, 300);
				builder.add(glass_trapdoor, 300);
				builder.add(mystic_trapdoor, 300);
				builder.add(paper_trapdoor, 300);
				builder.add(tropical_trapdoor, 300);
				builder.add(swamp_trapdoor, 300);
				builder.add(bamboo_trapdoor, 300);
				builder.add(classic_trapdoor, 300);
				builder.add(bark_trapdoor, 300);
				builder.add(ranch_trapdoor, 300);
				builder.add(blossom_trapdoor, 300);
				builder.add(barrel_trapdoor, 300);
				builder.add(whispering_trapdoor, 300);
			});
        }
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWood(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab, String modLoaded)
	{
		var modList = FabricLoader.getInstance();
		if(modList.isModLoaded(modid) && modList.isModLoaded(modLoaded))
		{
			for (String i : WOOD)
			{
				final Block barn_trapdoor = Finder.findBlock(MODID, i+"_barn_trapdoor");
				final Block cottage_trapdoor = Finder.findBlock(MODID, i+"_cottage_trapdoor");
				final Block barred_trapdoor = Finder.findBlock(MODID, i+"_barred_trapdoor");
				final Block beach_trapdoor = Finder.findBlock(MODID, i+"_beach_trapdoor");
				final Block four_panel_trapdoor = Finder.findBlock(MODID, i+"_four_panel_trapdoor");
				final Block glass_trapdoor = Finder.findBlock(MODID, i+"_glass_trapdoor");
				final Block mystic_trapdoor = Finder.findBlock(MODID, i+"_mystic_trapdoor");
				final Block paper_trapdoor = Finder.findBlock(MODID, i+"_paper_trapdoor");
				final Block tropical_trapdoor = Finder.findBlock(MODID, i+"_tropical_trapdoor");
				final Block swamp_trapdoor = Finder.findBlock(MODID, i+"_swamp_trapdoor");
				final Block bamboo_trapdoor = Finder.findBlock(MODID, i+"_bamboo_trapdoor");
				final Block classic_trapdoor = Finder.findBlock(MODID, i+"_classic_trapdoor");
				final Block bark_trapdoor = Finder.findBlock(MODID, i+"_bark_trapdoor");
				final Block ranch_trapdoor = Finder.findBlock(MODID, i+"_ranch_trapdoor");
				final Block blossom_trapdoor = Finder.findBlock(MODID, i+"_blossom_trapdoor");
				final Block barrel_trapdoor = Finder.findBlock(MODID, i+"_barrel_trapdoor");
				final Block whispering_trapdoor = Finder.findBlock(MODID, i+"_whispering_trapdoor");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(barn_trapdoor);
					content.add(cottage_trapdoor);
					content.add(barred_trapdoor);
					content.add(beach_trapdoor);
					content.add(four_panel_trapdoor);
					content.add(glass_trapdoor);
					content.add(mystic_trapdoor);
					content.add(paper_trapdoor);
					content.add(tropical_trapdoor);
					content.add(swamp_trapdoor);
					content.add(bamboo_trapdoor);
					content.add(classic_trapdoor);
					content.add(bark_trapdoor);
					content.add(ranch_trapdoor);
					content.add(blossom_trapdoor);
					content.add(barrel_trapdoor);
					content.add(whispering_trapdoor);
				});
			}
		}
	}
}