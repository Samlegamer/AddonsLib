package fr.samlegamer.addonslib.door;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.AddonsLib;
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
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of().noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
		final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_DOOR);
		setRegistrationWoodModLoaded(set, block, item, JAPAN, DOOR_WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties japan_door, BlockBehaviour.Properties wood_door)
	{
			final BlockBehaviour.Properties JAPAN = japan_door;
			final BlockBehaviour.Properties DOOR_WOOD = wood_door;

			RegistryObject<Block> japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door, 
			tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;
			
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN, BlockSetType.OAK), block, item);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN, BlockSetType.OAK), block, item);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(BlockSetType.OAK, DOOR_WOOD), block, item);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	stable_door = createBlock(i+"_stable_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.StableDoor", JAPAN, BlockSetType.OAK), block, item);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.StableDoor", JAPAN, BlockSetType.OAK), block, item);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
						whispering_door = createBlock(i+"_whispering_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    }
				    else
				    {
				    	japanese_door = createBlock(i+"_japanese_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	japanese2_door = createBlock(i+"_japanese2_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	barn_door = createBlock(i+"_barn_door", () -> new DoorBlock(BlockSetType.OAK, DOOR_WOOD), block, item);
				    	barn_glass_door = createBlock(i+"_barn_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	modern_door = createBlock(i+"_modern_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	cottage_door = createBlock(i+"_cottage_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	classic_door = createBlock(i+"_classic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	beach_door = createBlock(i+"_beach_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	paper_door = createBlock(i+"_paper_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	four_panel_door = createBlock(i+"_four_panel_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	tropical_door = createBlock(i+"_tropical_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	glass_door = createBlock(i+"_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	stable_door = createBlock(i+"_stable_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	stable_head_door = createBlock(i+"_stable_head_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	western_door = createBlock(i+"_western_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	mystic_door = createBlock(i+"_mystic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	nether_door = createBlock(i+"_nether_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	swamp_door = createBlock(i+"_swamp_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	bamboo_door = createBlock(i+"_bamboo_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	bark_glass_door = createBlock(i+"_bark_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
				    	waffle_door = createBlock(i+"_waffle_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
						whispering_door = createBlock(i+"_whispering_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN), block, item);
					}
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
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
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
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
				whispering_door = Finder.findBlock(MODID, i + "_whispering_door");

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
				event.accept(whispering_door);
	        }
   	 	}
	}
}