package fr.samlegamer.addonslib.bridges;

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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Bridges
{
	public static final String modid = "mcwbridges";
	public static final String desc = "mcwbridges.bridges.desc";

	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationRockModLoaded(set, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		ModList modList = ModList.get();
		boolean isModMcwLoaded = modList.isLoaded(modid);
		boolean isModBaseLoaded = modList.isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new Block(STONE), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		ModList modList = ModList.get();
		boolean isModMcwLoaded = modList.isLoaded(modid);
		boolean isModBaseLoaded = modList.isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;

		for (String i : WOOD)
		{				    	
			log_bridge_middle = Finder.findBlock(MODID, i+"_log_bridge_middle");
			rope_bridge = Finder.findBlock(MODID, "rope_"+i+"_bridge");
			bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
			log_bridge_stair = Finder.findBlock(MODID, i+"_log_bridge_stair");
			rope_bridge_stair = Finder.findBlock(MODID, i+"_rope_bridge_stair");
			rail_bridge = Finder.findBlock(MODID, i+"_rail_bridge");
			
        	ItemBlockRenderTypes.setRenderLayer(log_bridge_middle, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(rope_bridge, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(bridge_pier, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(log_bridge_stair, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(rope_bridge_stair, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(rail_bridge, renderSet);
        }
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
	{
		Block stone_bridge, stone_bridge_pier, stone_bridge_stair, balustrade_stone_bridge;
		
		for (String i : STONE)
		{
			stone_bridge = Finder.findBlock(MODID, i+"_bridge");
			stone_bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
			stone_bridge_stair = Finder.findBlock(MODID, i+"_bridge_stair");
			balustrade_stone_bridge = Finder.findBlock(MODID, "balustrade_"+i+"_bridge");
			
        	ItemBlockRenderTypes.setRenderLayer(stone_bridge, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(stone_bridge_pier, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(stone_bridge_stair, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(balustrade_stone_bridge, renderSet);
        }
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : WOODS) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab, true);
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new Block(WOOD), tab, false);
				}
			}
		}
	}
	
	public static void registryStone(final RegistryEvent.Register<Block> event, String Modid, List<String> STONES, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.copy(Blocks.COBBLESTONE);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : STONES) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab, true);
				}
				else {
					CreateBlockReferences.createBlockStoneOpti(Modid, id,new Block(STONE), tab, false);
				}
			}
		}
	}
}
