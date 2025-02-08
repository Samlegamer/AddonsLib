package fr.samlegamer.addonslib.door;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
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
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Doors
{
	public static final String modid = "mcwdoors";
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Properties JAPAN = AbstractBlock.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);
			final AbstractBlock.Properties DOOR_WOOD = AbstractBlock.Properties.copy(Blocks.ACACIA_DOOR);

			RegistryObject<Block> japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door, 
			tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;
			
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN), block, item, tab, modLoaded);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN), block, item, tab, modLoaded);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(DOOR_WOOD), block, item, tab, modLoaded);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	stable_door = createBlock(i+"_stable_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.StableDoor", JAPAN), block, item, tab, modLoaded);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> Registration.getBlocksField("com.mcwdoors.kikoz.objects.StableDoor", JAPAN), block, item, tab, modLoaded);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
						whispering_door = createBlock(i+"_whispering_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    }
				    else
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(DOOR_WOOD), block, item, tab, modLoaded);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	stable_door = createBlock(i+"_stable_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
						whispering_door = createBlock(i+"_whispering_door", () -> new DoorBlock(JAPAN), block, item, tab, modLoaded);
					}
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}

	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;
		
		for (String i : WOOD)
		{
			japanese_door = Finder.findBlock(MODID, i + "_japanese_door");
			japanese2_door = Finder.findBlock(MODID, i + "_japanese2_door");
			barn_door = Finder.findBlock(MODID, i + "_barn_door");
			barn_glass_door = Finder.findBlock(MODID, i + "_barn_glass_door");
			modern_door = Finder.findBlock(MODID, i + "_modern_door");
			cottage_door = Finder.findBlock(MODID, i + "_cottage_door");
			classic_door = Finder.findBlock(MODID, i + "_classic_door");
			beach_door = Finder.findBlock(MODID, i + "_beach_door");
			paper_door = Finder.findBlock(MODID, i + "_paper_door");
			four_panel_door = Finder.findBlock(MODID, i + "_four_panel_door");
			tropical_door = Finder.findBlock(MODID, i + "_tropical_door");
			glass_door = Finder.findBlock(MODID, i + "_glass_door");
			stable_door = Finder.findBlock(MODID, i + "_stable_door");
			stable_head_door = Finder.findBlock(MODID, i + "_stable_head_door");
			western_door = Finder.findBlock(MODID, i + "_western_door");
			mystic_door = Finder.findBlock(MODID, i + "_mystic_door");
			nether_door = Finder.findBlock(MODID, i + "_nether_door");
			swamp_door = Finder.findBlock(MODID, i + "_swamp_door");
			bamboo_door = Finder.findBlock(MODID, i + "_bamboo_door");
			bark_glass_door = Finder.findBlock(MODID, i + "_bark_glass_door");
			waffle_door = Finder.findBlock(MODID, i + "_waffle_door");
			whispering_door = Finder.findBlock(MODID, i + "_whispering_door");

			RenderTypeLookup.setRenderLayer(japanese_door, renderSet);
			RenderTypeLookup.setRenderLayer(japanese2_door, renderSet);
			RenderTypeLookup.setRenderLayer(barn_door, renderSet);
			RenderTypeLookup.setRenderLayer(barn_glass_door, renderSet);
			RenderTypeLookup.setRenderLayer(modern_door, renderSet);
			RenderTypeLookup.setRenderLayer(cottage_door, renderSet);
			RenderTypeLookup.setRenderLayer(classic_door, renderSet);
			RenderTypeLookup.setRenderLayer(beach_door, renderSet);
			RenderTypeLookup.setRenderLayer(paper_door, renderSet);
			RenderTypeLookup.setRenderLayer(four_panel_door, renderSet);
			RenderTypeLookup.setRenderLayer(tropical_door, renderSet);
			RenderTypeLookup.setRenderLayer(glass_door, renderSet);
			RenderTypeLookup.setRenderLayer(stable_door, renderSet);
			RenderTypeLookup.setRenderLayer(stable_head_door, renderSet);
			RenderTypeLookup.setRenderLayer(western_door, renderSet);
			RenderTypeLookup.setRenderLayer(mystic_door, renderSet);
			RenderTypeLookup.setRenderLayer(nether_door, renderSet);
			RenderTypeLookup.setRenderLayer(swamp_door, renderSet);
			RenderTypeLookup.setRenderLayer(bamboo_door, renderSet);
			RenderTypeLookup.setRenderLayer(bark_glass_door, renderSet);
			RenderTypeLookup.setRenderLayer(waffle_door, renderSet);
			RenderTypeLookup.setRenderLayer(whispering_door, renderSet);
        }
	}

	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
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