package fr.samlegamer.addonslib.trapdoor;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Trapdoors {
	public static final String modid = "mcwtrpdoors";

	/**
	 * Init all Wood Variants of Macaw's Trapdoors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab) {
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Trapdoors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded) {
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR);

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for(String i : set)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				CreateBlockReferences.createBlock(id, () -> new TrapDoorBlock(WOOD), block, item, tab, isModMcwLoaded, isModBaseLoaded);
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
			ItemBlockRenderTypes.setRenderLayer(whispering_trapdoor, renderSet);
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD) {
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR);

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for(String i : WOODS)
		{
			for(BlockId blockId : McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS.blocks())
			{
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				CreateBlockReferences.createBlockWoodOpti(Modid, id, new TrapDoorBlock(WOOD), tab, isModMcwLoaded);
			}
		}
	}
}