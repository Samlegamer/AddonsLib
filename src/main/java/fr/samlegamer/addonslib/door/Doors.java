package fr.samlegamer.addonslib.door;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Doors
{
	private static final List<RegistryObject<Block>> DOOR_BLOCKS = new ArrayList<>();

	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties JAPAN = AbstractBlock.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
			final AbstractBlock.Properties DOOR_WOOD = AbstractBlock.Properties.copy(Blocks.ACACIA_DOOR);

			for(String i : set)
			{
				RegistryObject<Block> japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door, 
				tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door;
				
				try {
				    if (ModList.get().isLoaded("mcwdoors"))
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN), block, item, tab);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN), block, item, tab);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(DOOR_WOOD), block, item, tab);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	stable_door = createBlock(i+"_stable_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.StableDoor", JAPAN), block, item, tab);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.StableDoor", JAPAN), block, item, tab);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(JAPAN), block, item, tab);

				    }
				    else
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(DOOR_WOOD), block, item, tab);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	stable_door = createBlock(i+"_stable_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(JAPAN), block, item, tab);
				    }
				    DOOR_BLOCKS.add(japanese_door);
				    DOOR_BLOCKS.add(japanese2_door);
				    DOOR_BLOCKS.add(barn_door);
				    DOOR_BLOCKS.add(barn_glass_door);
				    DOOR_BLOCKS.add(modern_door);
				    DOOR_BLOCKS.add(cottage_door);
				    DOOR_BLOCKS.add(classic_door);
				    DOOR_BLOCKS.add(beach_door);
				    DOOR_BLOCKS.add(paper_door);
				    DOOR_BLOCKS.add(four_panel_door);
				    DOOR_BLOCKS.add(tropical_door);
				    DOOR_BLOCKS.add(glass_door);
				    DOOR_BLOCKS.add(stable_door);
				    DOOR_BLOCKS.add(stable_head_door);
				    DOOR_BLOCKS.add(western_door);
				    DOOR_BLOCKS.add(mystic_door);
				    DOOR_BLOCKS.add(nether_door);
				    DOOR_BLOCKS.add(swamp_door);
				    DOOR_BLOCKS.add(bamboo_door);
				    DOOR_BLOCKS.add(bark_glass_door);
				    DOOR_BLOCKS.add(waffle_door);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Use this to set Render Bridges
	 */
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : DOOR_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwdoors"))
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