package fr.samlegamer.addonslib.bridges;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;

public class Bridges
{
	public static final String modid = "mcwbridges";
	public static final String desc = "mcwbridges.bridges.desc";

	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationWoodModLoaded(set, block, item, BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 2.5F).sound(SoundType.WOOD));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
		setRegistrationRockModLoaded(set, block, item, BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 5.0F).sound(SoundType.STONE));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		ModList modList = ModList.get();
		boolean isModMcwLoaded = modList.isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item);
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new Block(STONE), block, item);
				}
			}
		}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		ModList modList = ModList.get();
		boolean isModMcwLoaded = modList.isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item);
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
		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
   	 	{
			for (String i : WOOD)
			{
				log_bridge_middle = Finder.findBlock(MODID, i+"_log_bridge_middle");
				rope_bridge = Finder.findBlock(MODID, "rope_"+i+"_bridge");
				bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
				log_bridge_stair = Finder.findBlock(MODID, i+"_log_bridge_stair");
				rope_bridge_stair = Finder.findBlock(MODID, i+"_rope_bridge_stair");
				rail_bridge = Finder.findBlock(MODID, i+"_rail_bridge");
				
				event.accept(log_bridge_middle);
				event.accept(rope_bridge);
				event.accept(bridge_pier);
	        	event.accept(log_bridge_stair);
	        	event.accept(rope_bridge_stair);
	        	event.accept(rail_bridge);
	        }
   	 	}
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStone(CreativeModeTabEvent.BuildContents event, String MODID, List<String> STONE, CreativeModeTab tab)
	{
		addToTabStoneModLoaded(event, MODID, STONE, tab, "minecraft");
	}

	@Deprecated(forRemoval = true)
	public static void addToTabStoneModLoaded(CreativeModeTabEvent.BuildContents event, String MODID, List<String> STONE, CreativeModeTab tab, String modLoaded)
	{
		Block stone_bridge, stone_bridge_pier, stone_bridge_stair, balustrade_stone_bridge;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
   	 	{
			for (String i : STONE)
			{
				stone_bridge = Finder.findBlock(MODID, i+"_bridge");
				stone_bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
				stone_bridge_stair = Finder.findBlock(MODID, i+"_bridge_stair");
				balustrade_stone_bridge = Finder.findBlock(MODID, "balustrade_"+i+"_bridge");
				
				event.accept(stone_bridge);
				event.accept(stone_bridge_pier);
	        	event.accept(stone_bridge_stair);
	        	event.accept(balustrade_stone_bridge);
	        }
   	 	}
	}
}