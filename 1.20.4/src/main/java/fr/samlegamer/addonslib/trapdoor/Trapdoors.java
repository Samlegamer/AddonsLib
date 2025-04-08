package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.item.BlockItemFuel;
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
import net.minecraftforge.registries.RegistryObject;

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
			RegistryObject<Block> barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
			tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

			for(String i : set)
			{
				barn_trapdoor = createBlock(i+"_barn_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	cottage_trapdoor = createBlock(i+"_cottage_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	barred_trapdoor = createBlock(i+"_barred_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	beach_trapdoor = createBlock(i+"_beach_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	four_panel_trapdoor = createBlock(i+"_four_panel_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	glass_trapdoor = createBlock(i+"_glass_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	mystic_trapdoor = createBlock(i+"_mystic_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	paper_trapdoor = createBlock(i+"_paper_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	tropical_trapdoor = createBlock(i+"_tropical_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	swamp_trapdoor = createBlock(i+"_swamp_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	bamboo_trapdoor = createBlock(i+"_bamboo_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	classic_trapdoor = createBlock(i+"_classic_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	bark_trapdoor = createBlock(i+"_bark_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	ranch_trapdoor = createBlock(i+"_ranch_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	blossom_trapdoor = createBlock(i+"_blossom_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
		    	barrel_trapdoor = createBlock(i+"_barrel_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
				whispering_trapdoor = createBlock(i+"_whispering_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD), block, item);
			}
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        return block;
    }

	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		addToTabModLoaded(event, MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded)
	{
		Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
		tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
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