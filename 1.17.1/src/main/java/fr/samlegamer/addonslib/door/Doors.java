package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
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
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
		final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
		final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);

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
			ItemBlockRenderTypes.setRenderLayer(whispering_door, renderSet);
        }
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
		final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);

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