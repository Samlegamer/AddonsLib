package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import java.util.function.Function;

import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Trapdoors
{
	public static final String modid = "mcwtrpdoors";
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
//		DeferredBlock<Block> barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor,
//		tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

		//DeferredBlock<Block> aTrapdoor;

		final BlockSetType blockSetType;

		if(WOOD.equals(Blocks.CHERRY_TRAPDOOR.properties()))
		{
			blockSetType = BlockSetType.CHERRY;
		}
		else if(WOOD.equals(Blocks.CRIMSON_TRAPDOOR.properties()))
		{
			blockSetType = BlockSetType.CRIMSON;
		}
		else
		{
			blockSetType = BlockSetType.OAK;
		}

		for(String i : set)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

                createBlock(id, registryName -> new TrapDoorBlock(
                        blockSetType, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
            }
//			barn_trapdoor = createBlock(i + "_barn_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			cottage_trapdoor = createBlock(i + "_cottage_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			barred_trapdoor = createBlock(i + "_barred_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			beach_trapdoor = createBlock(i + "_beach_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			four_panel_trapdoor = createBlock(i + "_four_panel_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			glass_trapdoor = createBlock(i + "_glass_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			mystic_trapdoor = createBlock(i + "_mystic_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			paper_trapdoor = createBlock(i + "_paper_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			tropical_trapdoor = createBlock(i + "_tropical_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			swamp_trapdoor = createBlock(i + "_swamp_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			bamboo_trapdoor = createBlock(i + "_bamboo_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			classic_trapdoor = createBlock(i + "_classic_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			bark_trapdoor = createBlock(i + "_bark_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			ranch_trapdoor = createBlock(i + "_ranch_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			blossom_trapdoor = createBlock(i + "_blossom_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			barrel_trapdoor = createBlock(i + "_barrel_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//			whispering_trapdoor = createBlock(i + "_whispering_trapdoor", registryName ->
//					new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
		}
	}
	
	protected static DeferredBlock<Block> createBlock(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
        return block;
    }
	
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