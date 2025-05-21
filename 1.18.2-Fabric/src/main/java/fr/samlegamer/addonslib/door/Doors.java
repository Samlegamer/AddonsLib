package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.data.RegistryEntryReferences;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

public class Doors
{
	public static final String modid = "mcwdoors";
	
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded)
	{
		final AbstractBlock.Settings JAPAN = AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1.5F, 1.0F).sounds(BlockSoundGroup.WOOD);
		final AbstractBlock.Settings DOOR_WOOD = AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR);

		var modList = FabricLoader.getInstance();
		final boolean isModMcwLoaded = modList.isModLoaded(modid);
		final boolean isModBaseLoaded = modList.isModLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					RegistryEntryReferences.registryEntry(MODID, id, new DoorBlock(DOOR_WOOD), tab, isModMcwLoaded, isModBaseLoaded);
				} else if(isModMcwLoaded) {
					final Block blockRef = Registration.getBlocksField(blockId.reflectedLocation(), JAPAN);
					RegistryEntryReferences.registryEntry(MODID, id, blockRef, tab, true, isModBaseLoaded);
				}
				else {
					RegistryEntryReferences.registryEntry(MODID, id, new DoorBlock(DOOR_WOOD), tab, false, isModBaseLoaded);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}

	@Deprecated(forRemoval = true)
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door,
				whispering_door;
		
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

			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, japanese_door
			,japanese2_door
			,barn_door
			,barn_glass_door
			,modern_door
			,cottage_door
			,classic_door
			,beach_door
			,paper_door
			,four_panel_door
			,tropical_door
			,glass_door
			,stable_door
			,stable_head_door
			,western_door
			,mystic_door
			,nether_door
			,swamp_door
			,bamboo_door
			,bark_glass_door
			,waffle_door, whispering_door);
        }
	}

	@Deprecated(forRemoval = true)
	public static void fuelWood(String MODID, List<String> WOOD)
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
			
			FuelRegistry.INSTANCE.add(japanese_door, 300);
			FuelRegistry.INSTANCE.add(japanese2_door, 300);
			FuelRegistry.INSTANCE.add(barn_door, 300);
			FuelRegistry.INSTANCE.add(barn_glass_door, 300);
			FuelRegistry.INSTANCE.add(modern_door, 300);
			FuelRegistry.INSTANCE.add(cottage_door, 300);
			FuelRegistry.INSTANCE.add(classic_door, 300);
			FuelRegistry.INSTANCE.add(beach_door, 300);
			FuelRegistry.INSTANCE.add(paper_door, 300);
			FuelRegistry.INSTANCE.add(four_panel_door, 300);
			FuelRegistry.INSTANCE.add(tropical_door, 300);
			FuelRegistry.INSTANCE.add(glass_door, 300);
			FuelRegistry.INSTANCE.add(stable_door, 300);
			FuelRegistry.INSTANCE.add(stable_head_door, 300);
			FuelRegistry.INSTANCE.add(western_door, 300);
			FuelRegistry.INSTANCE.add(mystic_door, 300);
			FuelRegistry.INSTANCE.add(nether_door, 300);
			FuelRegistry.INSTANCE.add(swamp_door, 300);
			FuelRegistry.INSTANCE.add(bamboo_door, 300);
			FuelRegistry.INSTANCE.add(bark_glass_door, 300);
			FuelRegistry.INSTANCE.add(waffle_door, 300);
			FuelRegistry.INSTANCE.add(whispering_door, 300);
		}
	}
}