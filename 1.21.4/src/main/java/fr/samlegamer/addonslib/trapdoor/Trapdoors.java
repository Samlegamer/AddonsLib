package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Trapdoors
{
	public static final String modid = "mcwtrpdoors";
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		for(String i : set)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				CreateBlockReferences.createBlock(id, () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(block.key(id))), block, item);
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
		tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
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

		    	event.accept(barn_trapdoor);
		    	event.accept(cottage_trapdoor);
		    	event.accept(barred_trapdoor);
		    	event.accept(beach_trapdoor);
		    	event.accept(four_panel_trapdoor);
		    	event.accept(glass_trapdoor);
		    	event.accept(mystic_trapdoor);
		    	event.accept(paper_trapdoor);
		    	event.accept(tropical_trapdoor);
		    	event.accept(swamp_trapdoor);
		    	event.accept(bamboo_trapdoor);
		    	event.accept(classic_trapdoor);
		    	event.accept(bark_trapdoor);
		    	event.accept(ranch_trapdoor);
		    	event.accept(blossom_trapdoor);
		    	event.accept(barrel_trapdoor);
				event.accept(whispering_trapdoor);
			}
   	 	}
	}
}