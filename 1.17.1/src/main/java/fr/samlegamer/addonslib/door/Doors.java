package fr.samlegamer.addonslib.door;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class Doors
{
	private static final List<RegistryObject<Block>> DOOR_BLOCKS = new ArrayList<>();
	
	public static final String modid = "mcwdoors";
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
			final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
			final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);
			
			RegistryObject<Block> japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door, 
			tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door;
			
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
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
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
			final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);

			RegistryObject<Block> japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door, 
			tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door;
			
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
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door;
		
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
			
			ItemBlockRenderTypes.setRenderLayer(japanese_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(japanese2_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(barn_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(barn_glass_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(modern_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(cottage_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(classic_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(beach_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(paper_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(four_panel_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(tropical_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(glass_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(stable_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(stable_head_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(western_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(mystic_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(nether_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(swamp_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(bamboo_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(bark_glass_door, renderSet);
			ItemBlockRenderTypes.setRenderLayer(waffle_door, renderSet);
        }
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