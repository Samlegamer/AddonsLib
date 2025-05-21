package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;

public class Trapdoors
{
	public static final String modid = "mcwtrpdoors";

	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded)
	{
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR);

		var modList = FabricLoader.getInstance();
		final boolean isModMcwLoaded = modList.isModLoaded(modid);
		final boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for(String i : set)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				RegistryEntryReferences.registryEntry(MODID, id, new TrapdoorBlock(WOOD), tab, isModMcwLoaded, isModBaseLoaded);
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
		tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

		for (String i : WOOD)
		{		
			barn_trapdoor = Finder.findBlock(MODID, i+"_barn_trapdoor");
			cottage_trapdoor = Finder.findBlock(MODID, i+"_cottage_trapdoor");
			barred_trapdoor = Finder.findBlock(MODID, i+"_barred_trapdoor");
			beach_trapdoor = Finder.findBlock(MODID, i+"_beach_trapdoor");
			four_panel_trapdoor = Finder.findBlock(MODID, i+"_four_panel_trapdoor");
			glass_trapdoor = Finder.findBlock(MODID, i+"_glass_trapdoor");
			mystic_trapdoor = Finder.findBlock(MODID, i+"_mystic_trapdoor");
			paper_trapdoor = Finder.findBlock(MODID, i+"_paper_trapdoor");
			tropical_trapdoor = Finder.findBlock(MODID, i+"_tropical_trapdoor");
			swamp_trapdoor = Finder.findBlock(MODID, i+"_swamp_trapdoor");
			bamboo_trapdoor = Finder.findBlock(MODID, i+"_bamboo_trapdoor");
			classic_trapdoor = Finder.findBlock(MODID, i+"_classic_trapdoor");
			bark_trapdoor = Finder.findBlock(MODID, i+"_bark_trapdoor");
			ranch_trapdoor = Finder.findBlock(MODID, i+"_ranch_trapdoor");
			blossom_trapdoor = Finder.findBlock(MODID, i+"_blossom_trapdoor");
			barrel_trapdoor = Finder.findBlock(MODID, i+"_barrel_trapdoor");
	    	whispering_trapdoor = Finder.findBlock(MODID, i+"_whispering_trapdoor");

			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, 
			mystic_trapdoor, paper_trapdoor, tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor);
        }
	}

	@Deprecated(forRemoval = true)
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
		tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

		for (String i : WOOD)
		{		
			barn_trapdoor = Finder.findBlock(MODID, i+"_barn_trapdoor");
			cottage_trapdoor = Finder.findBlock(MODID, i+"_cottage_trapdoor");
			barred_trapdoor = Finder.findBlock(MODID, i+"_barred_trapdoor");
			beach_trapdoor = Finder.findBlock(MODID, i+"_beach_trapdoor");
			four_panel_trapdoor = Finder.findBlock(MODID, i+"_four_panel_trapdoor");
			glass_trapdoor = Finder.findBlock(MODID, i+"_glass_trapdoor");
			mystic_trapdoor = Finder.findBlock(MODID, i+"_mystic_trapdoor");
			paper_trapdoor = Finder.findBlock(MODID, i+"_paper_trapdoor");
			tropical_trapdoor = Finder.findBlock(MODID, i+"_tropical_trapdoor");
			swamp_trapdoor = Finder.findBlock(MODID, i+"_swamp_trapdoor");
			bamboo_trapdoor = Finder.findBlock(MODID, i+"_bamboo_trapdoor");
			classic_trapdoor = Finder.findBlock(MODID, i+"_classic_trapdoor");
			bark_trapdoor = Finder.findBlock(MODID, i+"_bark_trapdoor");
			ranch_trapdoor = Finder.findBlock(MODID, i+"_ranch_trapdoor");
			blossom_trapdoor = Finder.findBlock(MODID, i+"_blossom_trapdoor");
			barrel_trapdoor = Finder.findBlock(MODID, i+"_barrel_trapdoor");
			whispering_trapdoor = Finder.findBlock(MODID, i+"_whispering_trapdoor");

			FuelRegistry.INSTANCE.add(barn_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(cottage_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(barred_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(beach_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(four_panel_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(glass_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(mystic_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(paper_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(tropical_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(swamp_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(bamboo_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(classic_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(bark_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(ranch_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(blossom_trapdoor, 300);
        	FuelRegistry.INSTANCE.add(barrel_trapdoor, 300);
			FuelRegistry.INSTANCE.add(whispering_trapdoor, 300);
        }
	}
}