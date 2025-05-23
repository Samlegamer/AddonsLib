package fr.samlegamer.addonslib.windows;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Windows {
	public static final String modid = "mcwwindows";

	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab) {
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded) {
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.6F, 1.2F);
		final AbstractBlock.Properties PARAPET = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.2F, 1.0F);
		final AbstractBlock.Properties BLINDS = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 1.0F);
		final AbstractBlock.Properties SHUTTER = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.5F, 2.0F);
		final AbstractBlock.Properties ROD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 0.7F);

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.WINDOWS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);
				String relectedLocation = blockId.reflectedLocation();

				if(isModMcwLoaded) {
					switch (relectedLocation)
					{
						case "Parapet":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, PARAPET),
									block, item, tab, true, isModBaseLoaded);
							break;
						case "Blinds":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, BLINDS),
									block, item, tab, true, isModBaseLoaded);
							break;
						case "Shutter":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, SHUTTER),
									block, item, tab, true, isModBaseLoaded);
							break;
						case "CurtainRod":
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, ROD),
									block, item, tab, true, isModBaseLoaded);
							break;
						default:
							CreateBlockReferences.createBlock(id, () ->
											Registration.getBlocksField(relectedLocation, WOOD),
									block, item, tab, true, isModBaseLoaded);
							break;
					}
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet) {
		Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2,
				plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window,
				curtain_rod;

		for (String i : WOOD) {
			window = Finder.findBlock(MODID, i + "_window");
			window2 = Finder.findBlock(MODID, i + "_window2");
			four_window = Finder.findBlock(MODID, i + "_four_window");
			strippedlog_window = Finder.findBlock(MODID, "stripped_" + i + "_log_window");
			strippedlog_window2 = Finder.findBlock(MODID, "stripped_" + i + "_log_window2");
			strippedlog_four_window = Finder.findBlock(MODID, "stripped_" + i + "_log_four_window");
			plank_window = Finder.findBlock(MODID, i + "_plank_window");
			plank_window2 = Finder.findBlock(MODID, i + "_plank_window2");
			plank_four_window = Finder.findBlock(MODID, i + "_plank_four_window");
			log_parapet = Finder.findBlock(MODID, i + "_log_parapet");
			plank_parapet = Finder.findBlock(MODID, i + "_plank_parapet");
			blinds = Finder.findBlock(MODID, i + "_blinds");
			shutter = Finder.findBlock(MODID, i + "_shutter");
			louvered_shutter = Finder.findBlock(MODID, i + "_louvered_shutter");
			pane_window = Finder.findBlock(MODID, i + "_pane_window");
			strippedpane_window = Finder.findBlock(MODID, "stripped_" + i + "_pane_window");
			plank_pane_window = Finder.findBlock(MODID, i + "_plank_pane_window");
			curtain_rod = Finder.findBlock(MODID, i + "_curtain_rod");

			RenderTypeLookup.setRenderLayer(window, renderSet);
			RenderTypeLookup.setRenderLayer(window2, renderSet);
			RenderTypeLookup.setRenderLayer(four_window, renderSet);
			RenderTypeLookup.setRenderLayer(strippedlog_window, renderSet);
			RenderTypeLookup.setRenderLayer(strippedlog_window2, renderSet);
			RenderTypeLookup.setRenderLayer(strippedlog_four_window, renderSet);
			RenderTypeLookup.setRenderLayer(plank_window, renderSet);
			RenderTypeLookup.setRenderLayer(plank_window2, renderSet);
			RenderTypeLookup.setRenderLayer(plank_four_window, renderSet);
			RenderTypeLookup.setRenderLayer(log_parapet, renderSet);
			RenderTypeLookup.setRenderLayer(plank_parapet, renderSet);
			RenderTypeLookup.setRenderLayer(blinds, renderSet);
			RenderTypeLookup.setRenderLayer(shutter, renderSet);
			RenderTypeLookup.setRenderLayer(louvered_shutter, renderSet);
			RenderTypeLookup.setRenderLayer(pane_window, renderSet);
			RenderTypeLookup.setRenderLayer(strippedpane_window, renderSet);
			RenderTypeLookup.setRenderLayer(plank_pane_window, renderSet);
			RenderTypeLookup.setRenderLayer(curtain_rod, renderSet);
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD) {
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.6F, 1.2F);
		final AbstractBlock.Properties PARAPET = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.2F, 1.0F);
		final AbstractBlock.Properties BLINDS = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 1.0F);
		final AbstractBlock.Properties SHUTTER = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.5F, 2.0F);
		final AbstractBlock.Properties ROD = AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 0.7F);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : WOODS) {
			for (BlockId blockId : McwBlocksIdBase.WINDOWS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);
				String relectedLocation = blockId.reflectedLocation();

				if(isModLoaded) {
					switch (relectedLocation)
					{
						case "Parapet":
							CreateBlockReferences.createBlockWoodOpti(Modid, id,
											Registration.getBlocksField(relectedLocation, PARAPET),
									tab, true);
							break;
						case "Blinds":
							CreateBlockReferences.createBlockWoodOpti(Modid, id,
											Registration.getBlocksField(relectedLocation, BLINDS),
									tab, true);
							break;
						case "Shutter":
							CreateBlockReferences.createBlockWoodOpti(Modid, id,
											Registration.getBlocksField(relectedLocation, SHUTTER),
									tab, true);
							break;
						case "CurtainRod":
							CreateBlockReferences.createBlockWoodOpti(Modid, id,
											Registration.getBlocksField(relectedLocation, ROD),
									tab, true);
							break;
						default:
							CreateBlockReferences.createBlockWoodOpti(Modid, id,
											Registration.getBlocksField(relectedLocation, WOOD),
									tab, true);
							break;
					}
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new Block(WOOD), tab, false);
				}
			}
		}
	}
}