package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Trapdoors
{
	public static final String modid = "mcwtrpdoors";
	
	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
    	}
    	else {
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
	}

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

			for(String i : set)
			{
				registryEntry(MODID, i+"_barn_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_cottage_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_barred_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_beach_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_four_panel_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_glass_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_mystic_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_paper_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_tropical_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_swamp_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_bamboo_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_classic_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_bark_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_ranch_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_blossom_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
		    	registryEntry(MODID, i+"_barrel_trapdoor", new TrapdoorBlock(WOOD), tab, modLoaded);
			}
	}
	
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
		tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor;

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
	    	
			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, 
			mystic_trapdoor, paper_trapdoor, tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor);
        }
	}
	
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}
	
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
		tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor;

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
        }
	}
}