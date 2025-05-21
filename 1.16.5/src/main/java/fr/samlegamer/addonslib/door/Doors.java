package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
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
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
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

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), JAPAN), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	@Deprecated
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

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, ItemGroup tab)
	{
		final AbstractBlock.Properties JAPAN = AbstractBlock.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);
		final AbstractBlock.Properties DOOR_WOOD = AbstractBlock.Properties.copy(Blocks.ACACIA_DOOR);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : WOODS) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new DoorBlock(DOOR_WOOD), tab, isModLoaded);
				} else if(isModLoaded) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), JAPAN), tab, true);
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new DoorBlock(DOOR_WOOD), tab, false);
				}
			}
		}
	}
}