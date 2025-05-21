package fr.samlegamer.addonslib.bridges;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Bridges
{
	public static final String modid = "mcwbridges";
	public static final String desc = "mcwbridges.bridges.desc";

	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.WOOD);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of().strength(3.0F, 5.0F).sound(SoundType.STONE);
		setRegistrationRockModLoaded(set, block, item, STONE);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlockStone(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item);
				}
				else {
					CreateBlockReferences.createBlockStone(id, registryName -> new Block(STONE), block, item);
				}
			}
		}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item);
				}
				else {
					CreateBlockReferences.createBlock(id, registryName -> new Block(WOOD), block, item);
				}
			}
		}
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{

		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
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
	public static void addToTabStone(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab)
	{
		Block stone_bridge, stone_bridge_pier, stone_bridge_stair, balustrade_stone_bridge;
		
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
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