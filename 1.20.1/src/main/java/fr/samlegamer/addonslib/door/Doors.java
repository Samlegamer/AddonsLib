package fr.samlegamer.addonslib.door;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Doors
{
	public static final String modid = "mcwdoors";
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of().noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
			final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);

			RegistryObject<Block> japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door, 
			tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door;
			
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(DOOR_WOOD, BlockSetType.OAK), block, item, tab, modLoaded);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	stable_door = createBlock(i+"_stable_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.StableDoor", JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.StableDoor", JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);

				    }
				    else
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(DOOR_WOOD, BlockSetType.OAK), block, item, tab, modLoaded);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	stable_door = createBlock(i+"_stable_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(JAPAN, BlockSetType.OAK), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
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
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        }
        return block;
    }
	
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door;
		
		if (event.getTab() == tab)
   	 	{
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
				
				event.accept(japanese_door);
				event.accept(japanese2_door);
				event.accept(barn_door);
				event.accept(barn_glass_door);
				event.accept(modern_door);
				event.accept(cottage_door);
				event.accept(classic_door);
				event.accept(beach_door);
				event.accept(paper_door);
				event.accept(four_panel_door);
				event.accept(tropical_door);
				event.accept(glass_door);
				event.accept(stable_door);
				event.accept(stable_head_door);
				event.accept(western_door);
				event.accept(mystic_door);
				event.accept(nether_door);
				event.accept(swamp_door);
				event.accept(bamboo_door);
				event.accept(bark_glass_door);
				event.accept(waffle_door);
	        }
   	 	}
	}
}