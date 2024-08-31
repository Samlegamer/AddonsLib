package fr.samlegamer.addonslib.trapdoor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Trapdoors
{
	private static final List<RegistryObject<Block>> TRAPDOOR_BLOCKS = new ArrayList<>();

	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR);

			for(String i : set)
			{
				RegistryObject<Block> barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
				tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor;
				  
				barn_trapdoor = createBlock(i+"_barn_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	cottage_trapdoor = createBlock(i+"_cottage_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	barred_trapdoor = createBlock(i+"_barred_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	beach_trapdoor = createBlock(i+"_beach_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	four_panel_trapdoor = createBlock(i+"_four_panel_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	glass_trapdoor = createBlock(i+"_glass_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	mystic_trapdoor = createBlock(i+"_mystic_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	paper_trapdoor = createBlock(i+"_paper_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	tropical_trapdoor = createBlock(i+"_tropical_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	swamp_trapdoor = createBlock(i+"_swamp_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	bamboo_trapdoor = createBlock(i+"_bamboo_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	classic_trapdoor = createBlock(i+"_classic_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	bark_trapdoor = createBlock(i+"_bark_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	ranch_trapdoor = createBlock(i+"_ranch_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	blossom_trapdoor = createBlock(i+"_blossom_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	barrel_trapdoor = createBlock(i+"_barrel_trapdoor", () -> new TrapDoorBlock(WOOD), block, item, tab);
		    	
		    	TRAPDOOR_BLOCKS.add(barn_trapdoor);
		    	TRAPDOOR_BLOCKS.add(cottage_trapdoor);
		    	TRAPDOOR_BLOCKS.add(barred_trapdoor);
		    	TRAPDOOR_BLOCKS.add(beach_trapdoor);
		    	TRAPDOOR_BLOCKS.add(four_panel_trapdoor);
		    	TRAPDOOR_BLOCKS.add(glass_trapdoor);
		    	TRAPDOOR_BLOCKS.add(mystic_trapdoor);
		    	TRAPDOOR_BLOCKS.add(paper_trapdoor);
		    	TRAPDOOR_BLOCKS.add(tropical_trapdoor);
		    	TRAPDOOR_BLOCKS.add(swamp_trapdoor);
		    	TRAPDOOR_BLOCKS.add(bamboo_trapdoor);
		    	TRAPDOOR_BLOCKS.add(classic_trapdoor);
		    	TRAPDOOR_BLOCKS.add(bark_trapdoor);
		    	TRAPDOOR_BLOCKS.add(ranch_trapdoor);
		    	TRAPDOOR_BLOCKS.add(blossom_trapdoor);
		    	TRAPDOOR_BLOCKS.add(barrel_trapdoor);
			}
	}
	
	/**
	 * Use this to set Render Bridges
	 */
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : TRAPDOOR_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwtrpdoors"))
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