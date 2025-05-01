package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Trapdoors {
	public static final String modid = "mcwtrpdoors";

	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab) {
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded) {
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR);

		for(String i : set)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				createBlock(id, () -> new TrapDoorBlock(WOOD), block, item, tab, modLoaded);
			}
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet) {
		Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor,
				tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

		for (String i : WOOD) {
			barn_trapdoor = Finder.findBlock(MODID, i + "_barn_trapdoor");
			cottage_trapdoor = Finder.findBlock(MODID, i + "_cottage_trapdoor");
			barred_trapdoor = Finder.findBlock(MODID, i + "_barred_trapdoor");
			beach_trapdoor = Finder.findBlock(MODID, i + "_beach_trapdoor");
			four_panel_trapdoor = Finder.findBlock(MODID, i + "_four_panel_trapdoor");
			glass_trapdoor = Finder.findBlock(MODID, i + "_glass_trapdoor");
			mystic_trapdoor = Finder.findBlock(MODID, i + "_mystic_trapdoor");
			paper_trapdoor = Finder.findBlock(MODID, i + "_paper_trapdoor");
			tropical_trapdoor = Finder.findBlock(MODID, i + "_tropical_trapdoor");
			swamp_trapdoor = Finder.findBlock(MODID, i + "_swamp_trapdoor");
			bamboo_trapdoor = Finder.findBlock(MODID, i + "_bamboo_trapdoor");
			classic_trapdoor = Finder.findBlock(MODID, i + "_classic_trapdoor");
			bark_trapdoor = Finder.findBlock(MODID, i + "_bark_trapdoor");
			ranch_trapdoor = Finder.findBlock(MODID, i + "_ranch_trapdoor");
			blossom_trapdoor = Finder.findBlock(MODID, i + "_blossom_trapdoor");
			barrel_trapdoor = Finder.findBlock(MODID, i + "_barrel_trapdoor");
			whispering_trapdoor = Finder.findBlock(MODID, i + "_whispering_trapdoor");

			RenderTypeLookup.setRenderLayer(barn_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(cottage_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(barred_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(beach_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(four_panel_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(glass_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(mystic_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(paper_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(tropical_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(swamp_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(bamboo_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(classic_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(bark_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(ranch_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(blossom_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(barrel_trapdoor, renderSet);
			RenderTypeLookup.setRenderLayer(whispering_trapdoor, renderSet);
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD) {
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	protected static void createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded) {
		RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ModList modList = ModList.get();
		if (modList.isLoaded(modid) && modList.isLoaded(modLoaded)) {
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
		} else {
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
		}
	}

	protected static void createBlockWoodOpti(String Modid, String name, Block block, ItemGroup tab) {
		BlockItem itemBlock;
		if (ModList.get().isLoaded(modid)) {
			itemBlock = new BlockItemFuel(block, new Item.Properties().tab(tab));
		} else {
			itemBlock = new BlockItemFuel(block, new Item.Properties());
		}
		block.setRegistryName(Modid, name);
		itemBlock.setRegistryName(Modid, name);
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(itemBlock);
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR);

		for(String i : WOODS)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				createBlockWoodOpti(Modid, id, new TrapDoorBlock(WOOD), tab);
			}
		}
	}
}