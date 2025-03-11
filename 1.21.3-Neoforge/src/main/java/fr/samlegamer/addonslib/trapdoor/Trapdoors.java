package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
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
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR);
			DeferredBlock<Block> barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor, 
			tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

			for(String i : set)
			{
				barn_trapdoor = createBlock(mod, i+"_barn_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_barn_trapdoor")))), block, item, tab, modLoaded);
				cottage_trapdoor = createBlock(mod, i+"_cottage_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_cottage_trapdoor")))), block, item, tab, modLoaded);
				barred_trapdoor = createBlock(mod, i+"_barred_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_barred_trapdoor")))), block, item, tab, modLoaded);
				beach_trapdoor = createBlock(mod, i+"_beach_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_beach_trapdoor")))), block, item, tab, modLoaded);
				four_panel_trapdoor = createBlock(mod, i+"_four_panel_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_four_panel_trapdoor")))), block, item, tab, modLoaded);
				glass_trapdoor = createBlock(mod, i+"_glass_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_glass_trapdoor")))), block, item, tab, modLoaded);
				mystic_trapdoor = createBlock(mod, i+"_mystic_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_mystic_trapdoor")))), block, item, tab, modLoaded);
				paper_trapdoor = createBlock(mod, i+"_paper_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_paper_trapdoor")))), block, item, tab, modLoaded);
				tropical_trapdoor = createBlock(mod, i+"_tropical_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_tropical_trapdoor")))), block, item, tab, modLoaded);
				swamp_trapdoor = createBlock(mod, i+"_swamp_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_swamp_trapdoor")))), block, item, tab, modLoaded);
				bamboo_trapdoor = createBlock(mod, i+"_bamboo_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bamboo_trapdoor")))), block, item, tab, modLoaded);
				classic_trapdoor = createBlock(mod, i+"_classic_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_classic_trapdoor")))), block, item, tab, modLoaded);
				bark_trapdoor = createBlock(mod, i+"_bark_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bark_trapdoor")))), block, item, tab, modLoaded);
				ranch_trapdoor = createBlock(mod, i+"_ranch_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_ranch_trapdoor")))), block, item, tab, modLoaded);
				blossom_trapdoor = createBlock(mod, i+"_blossom_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_blossom_trapdoor")))), block, item, tab, modLoaded);
				barrel_trapdoor = createBlock(mod, i+"_barrel_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_barrel_trapdoor")))), block, item, tab, modLoaded);
				whispering_trapdoor = createBlock(mod, i+"_whispering_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_whispering_trapdoor")))), block, item, tab, modLoaded);
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