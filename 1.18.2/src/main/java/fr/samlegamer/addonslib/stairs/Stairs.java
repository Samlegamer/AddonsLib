package fr.samlegamer.addonslib.stairs;

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
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD);
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).requiresCorrectToolForDrops();
		setRegistrationRockModLoaded(set, block, item, tab, "minecraft", STONE);
	}
	
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		 final BlockBehaviour.Properties STONE = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
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
	
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
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
		Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

		for (String i : WOOD)
		{		
			_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
			_railing = Finder.findBlock(MODID, i+"_railing");
			_balcony = Finder.findBlock(MODID, i+"_balcony");
			_platform = Finder.findBlock(MODID, i+"_platform");

        	ItemBlockRenderTypes.setRenderLayer(_terrace_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_skyline_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_compact_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_bulk_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_loft_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_railing, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_balcony, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_platform, renderSet);
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
		Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

		for (String i : STONE)
		{
			_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
			_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
			_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
			_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
			_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
			_railing = Finder.findBlock(MODID, i+"_railing");
			_balcony = Finder.findBlock(MODID, i+"_balcony");
			_platform = Finder.findBlock(MODID, i+"_platform");

        	ItemBlockRenderTypes.setRenderLayer(_terrace_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_skyline_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_compact_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_bulk_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_loft_stairs, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_railing, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_balcony, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(_platform, renderSet);
        }
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : WOODS) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
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
	 	final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).requiresCorrectToolForDrops();

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : STONES) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab, true);
				}
				else {
					CreateBlockReferences.createBlockStoneOpti(Modid, id, new Block(STONE), tab, false);
				}
			}
		}
	}
}