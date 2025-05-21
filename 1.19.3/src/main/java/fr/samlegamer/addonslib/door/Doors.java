package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Doors
{
	public static final String modid = "mcwdoors";
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		final BlockBehaviour.Properties JAPAN = BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(1.5F, 1.0F).sound(SoundType.WOOD);
		final BlockBehaviour.Properties DOOR_WOOD = BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR);
		setRegistrationWoodModLoaded(set, block, item, JAPAN, DOOR_WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties JAPAN_PROP, BlockBehaviour.Properties DOOR_PROP)
	{
		final BlockBehaviour.Properties JAPAN = JAPAN_PROP;
		final BlockBehaviour.Properties DOOR_WOOD = DOOR_PROP;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.DOORS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("DoorBlock")) {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN), block, item);
				} else if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), JAPAN, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new DoorBlock(DOOR_WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN), block, item);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		addToTabModLoaded(event, MODID, WOOD, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabModLoaded(CreativeModeTabEvent.BuildContents event, String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded)
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