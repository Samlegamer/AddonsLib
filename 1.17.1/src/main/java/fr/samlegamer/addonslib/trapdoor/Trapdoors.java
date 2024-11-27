package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class Trapdoors
{
	public static final String modid = "mcwtrpdoors";
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR);
			RegistryObject<Block> barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
			tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor;

			for(String i : set)
			{
				barn_trapdoor = createBlock(i+"_barn_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	cottage_trapdoor = createBlock(i+"_cottage_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	barred_trapdoor = createBlock(i+"_barred_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	beach_trapdoor = createBlock(i+"_beach_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	four_panel_trapdoor = createBlock(i+"_four_panel_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	glass_trapdoor = createBlock(i+"_glass_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	mystic_trapdoor = createBlock(i+"_mystic_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	paper_trapdoor = createBlock(i+"_paper_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	tropical_trapdoor = createBlock(i+"_tropical_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	swamp_trapdoor = createBlock(i+"_swamp_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	bamboo_trapdoor = createBlock(i+"_bamboo_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	classic_trapdoor = createBlock(i+"_classic_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	bark_trapdoor = createBlock(i+"_bark_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	ranch_trapdoor = createBlock(i+"_ranch_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	blossom_trapdoor = createBlock(i+"_blossom_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
		    	barrel_trapdoor = createBlock(i+"_barrel_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
			}
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
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
	    	
        	ItemBlockRenderTypes.setRenderLayer(barn_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cottage_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(barred_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(beach_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(four_panel_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(glass_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(mystic_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(paper_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(tropical_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(swamp_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(bamboo_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(classic_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(bark_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(ranch_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(blossom_trapdoor, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(barrel_trapdoor, renderSet);
        }
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        }
        return block;
    }
}