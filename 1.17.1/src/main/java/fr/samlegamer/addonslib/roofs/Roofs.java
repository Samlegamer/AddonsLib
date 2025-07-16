package fr.samlegamer.addonslib.roofs;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Roofs
{
	public static final String modid = "mcwroofs";
	
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE));
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(blockId.reflectedLocation().contains("StairsBlock")) {
					CreateBlockReferences.createBlock(id, () -> new StairBlock(Blocks.OAK_PLANKS::defaultBlockState, WOOD), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				}
				else if(isModMcwLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlock(id, () ->
								Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
					} else {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
					}
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties STONE = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("StairsBlock")) {
					CreateBlockReferences.createBlockStone(id, () ->
							new StairBlock(Blocks.COBBLESTONE::defaultBlockState, STONE), block, item, tab, isModMcwLoaded, isModBaseLoaded);
				}
				else if(isModMcwLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlockStone(id, () ->
								Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.COBBLESTONE.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
					} else {
						CreateBlockReferences.createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, true, isModBaseLoaded);
					}
				}
				else {
					CreateBlockReferences.createBlockStone(id, () -> new Block(STONE), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> set, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(blockId.reflectedLocation().contains("StairsBlock")) {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new StairBlock(Blocks.OAK_PLANKS::defaultBlockState, WOOD), tab, isModLoaded);
				}
				else if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlockWoodOpti(Modid, id,
								Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab, true);
					} else {
						CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab, true);
					}
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new Block(WOOD), tab, false);
				}
			}
		}
	}
	
	public static void registryStone(final RegistryEvent.Register<Block> event, String Modid, List<String> rock, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.copy(Blocks.COBBLESTONE);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("StairsBlock")) {
					CreateBlockReferences.createBlockStoneOpti(Modid, id,
							new StairBlock(Blocks.COBBLESTONE::defaultBlockState, STONE), tab, isModLoaded);
				}
				else if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						CreateBlockReferences.createBlockStoneOpti(Modid, id,
								Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.COBBLESTONE.defaultBlockState()), tab, true);
					} else if (!blockId.reflectedLocation().contains("StairsBlock")) {
						CreateBlockReferences.createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab, true);
					}
				}
				else {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, new Block(STONE), tab, false);
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
	    Block cherry_roof,
		cherry_attic_roof,
		cherry_top_roof,
		cherry_lower_roof,
		cherry_steep_roof,
		cherry_upper_lower_roof,
		cherry_upper_steep_roof,
		cherry_planks_roof,
		cherry_planks_attic_roof,
		cherry_planks_top_roof,
		cherry_planks_lower_roof,
		cherry_planks_steep_roof,
		cherry_planks_upper_lower_roof,
		cherry_planks_upper_steep_roof;

		for (String i : WOOD)
		{
			cherry_roof = Finder.findBlock(MODID, i+"_roof");
			cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
			cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
			cherry_lower_roof = Finder.findBlock(MODID, i+"_lower_roof");
			cherry_steep_roof = Finder.findBlock(MODID, i+"_steep_roof");
			cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
			cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");
			
        	ItemBlockRenderTypes.setRenderLayer(cherry_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_attic_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_top_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_lower_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_steep_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_upper_lower_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_upper_steep_roof, renderSet);
        	
        	cherry_planks_roof = Finder.findBlock(MODID, i+"_planks_roof");
			cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
			cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
			cherry_planks_lower_roof = Finder.findBlock(MODID, i+"_planks_lower_roof");
			cherry_planks_steep_roof = Finder.findBlock(MODID, i+"_planks_steep_roof");
			cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
			cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");
			
        	ItemBlockRenderTypes.setRenderLayer(cherry_planks_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_planks_attic_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_planks_top_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_planks_lower_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_planks_steep_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_planks_upper_lower_roof, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(cherry_planks_upper_steep_roof, renderSet);
        }
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
	{
		Block ROOF,
		ATTIC_ROOF,
		TOP_ROOF,
		LOWER_ROOF,
		STEEP_ROOF,
		UPPER_LOWER_ROOF,
		UPPER_STEEP_ROOF;

		for (String i : STONE)
		{
			ROOF = Finder.findBlock(MODID, i + "_roof");
			ATTIC_ROOF = Finder.findBlock(MODID, i + "_attic_roof");
			TOP_ROOF = Finder.findBlock(MODID, i + "_top_roof");
			LOWER_ROOF = Finder.findBlock(MODID, i + "_lower_roof");
			STEEP_ROOF = Finder.findBlock(MODID, i + "_steep_roof");
			UPPER_LOWER_ROOF = Finder.findBlock(MODID, i + "_upper_lower_roof");
			UPPER_STEEP_ROOF = Finder.findBlock(MODID, i + "_upper_steep_roof");

        	ItemBlockRenderTypes.setRenderLayer(ROOF, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(ATTIC_ROOF, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(TOP_ROOF, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(LOWER_ROOF, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(STEEP_ROOF, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(UPPER_LOWER_ROOF, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(UPPER_STEEP_ROOF, renderSet);
        }
	}
}