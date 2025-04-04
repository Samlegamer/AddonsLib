package fr.samlegamer.addonslib.door;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Doors
{
	public static final String modid = "mcwdoors";
	
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of().noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
			final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_DOOR);

			DeferredBlock<Block> japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door, 
			tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;
			
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						japanese_door = createBlock(mod, i+"_japanese_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_japanese_door"))), BlockSetType.OAK), block, item, tab, modLoaded);
						japanese2_door = createBlock(mod, i+"_japanese2_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.JapaneseDoors", JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_japanese2_door"))), BlockSetType.OAK), block, item, tab, modLoaded);
						barn_door = createBlock(mod, i+"_barn_door", () -> new DoorBlock(BlockSetType.OAK, DOOR_WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_barn_door")))), block, item, tab, modLoaded);
						barn_glass_door = createBlock(mod, i+"_barn_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_barn_glass_door")))), block, item, tab, modLoaded);
						modern_door = createBlock(mod, i+"_modern_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_door")))), block, item, tab, modLoaded);
						cottage_door = createBlock(mod, i+"_cottage_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_cottage_door")))), block, item, tab, modLoaded);
						classic_door = createBlock(mod, i+"_classic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_classic_door")))), block, item, tab, modLoaded);
						beach_door = createBlock(mod, i+"_beach_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_beach_door")))), block, item, tab, modLoaded);
						paper_door = createBlock(mod, i+"_paper_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_paper_door")))), block, item, tab, modLoaded);
						four_panel_door = createBlock(mod, i+"_four_panel_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_four_panel_door")))), block, item, tab, modLoaded);
						tropical_door = createBlock(mod, i+"_tropical_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_tropical_door")))), block, item, tab, modLoaded);
						glass_door = createBlock(mod, i+"_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_glass_door")))), block, item, tab, modLoaded);
						stable_door = createBlock(mod, i+"_stable_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.StableDoor", JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stable_door"))), BlockSetType.OAK), block, item, tab, modLoaded);
						stable_head_door = createBlock(mod, i+"_stable_head_door", () -> Registration.getBlocksFieldDoors("com.mcwdoors.kikoz.objects.StableDoor", JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stable_head_door"))), BlockSetType.OAK), block, item, tab, modLoaded);
						western_door = createBlock(mod, i+"_western_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_western_door")))), block, item, tab, modLoaded);
						mystic_door = createBlock(mod, i+"_mystic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_mystic_door")))), block, item, tab, modLoaded);
						nether_door = createBlock(mod, i+"_nether_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_nether_door")))), block, item, tab, modLoaded);
						swamp_door = createBlock(mod, i+"_swamp_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_swamp_door")))), block, item, tab, modLoaded);
						bamboo_door = createBlock(mod, i+"_bamboo_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bamboo_door")))), block, item, tab, modLoaded);
						bark_glass_door = createBlock(mod, i+"_bark_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bark_glass_door")))), block, item, tab, modLoaded);
						waffle_door = createBlock(mod, i+"_waffle_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_waffle_door")))), block, item, tab, modLoaded);
						whispering_door = createBlock(mod, i+"_whispering_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_whispering_door")))), block, item, tab, modLoaded);
					}
					else
					{
						japanese_door = createBlock(mod, i+"_japanese_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_japanese_door")))), block, item, tab, modLoaded);
						japanese2_door = createBlock(mod, i+"_japanese2_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_japanese2_door")))), block, item, tab, modLoaded);
						barn_door = createBlock(mod, i+"_barn_door", () -> new DoorBlock(BlockSetType.OAK, DOOR_WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_barn_door")))), block, item, tab, modLoaded);
						barn_glass_door = createBlock(mod, i+"_barn_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_barn_glass_door")))), block, item, tab, modLoaded);
						modern_door = createBlock(mod, i+"_modern_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_modern_door")))), block, item, tab, modLoaded);
						cottage_door = createBlock(mod, i+"_cottage_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_cottage_door")))), block, item, tab, modLoaded);
						classic_door = createBlock(mod, i+"_classic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_classic_door")))), block, item, tab, modLoaded);
						beach_door = createBlock(mod, i+"_beach_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_beach_door")))), block, item, tab, modLoaded);
						paper_door = createBlock(mod, i+"_paper_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_paper_door")))), block, item, tab, modLoaded);
						four_panel_door = createBlock(mod, i+"_four_panel_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_four_panel_door")))), block, item, tab, modLoaded);
						tropical_door = createBlock(mod, i+"_tropical_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_tropical_door")))), block, item, tab, modLoaded);
						glass_door = createBlock(mod, i+"_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_glass_door")))), block, item, tab, modLoaded);
						stable_door = createBlock(mod, i+"_stable_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stable_door")))), block, item, tab, modLoaded);
						stable_head_door = createBlock(mod, i+"_stable_head_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_stable_head_door")))), block, item, tab, modLoaded);
						western_door = createBlock(mod, i+"_western_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_western_door")))), block, item, tab, modLoaded);
						mystic_door = createBlock(mod, i+"_mystic_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_mystic_door")))), block, item, tab, modLoaded);
						nether_door = createBlock(mod, i+"_nether_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_nether_door")))), block, item, tab, modLoaded);
						swamp_door = createBlock(mod, i+"_swamp_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_swamp_door")))), block, item, tab, modLoaded);
						bamboo_door = createBlock(mod, i+"_bamboo_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bamboo_door")))), block, item, tab, modLoaded);
						bark_glass_door = createBlock(mod, i+"_bark_glass_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bark_glass_door")))), block, item, tab, modLoaded);
						waffle_door = createBlock(mod, i+"_waffle_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_waffle_door")))), block, item, tab, modLoaded);
						whispering_door = createBlock(mod, i+"_whispering_door", () -> new DoorBlock(BlockSetType.OAK, JAPAN.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_whispering_door")))), block, item, tab, modLoaded);
					}
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
        return block;
    }
	
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
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