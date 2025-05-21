package fr.samlegamer.addonslib.stairs;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		final AbstractBlock.Properties STONE = AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops();
		setRegistrationRockModLoaded(set, block, item, tab, "minecraft", STONE);
	}
	
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		 final AbstractBlock.Properties STONE = prop;

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
	
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties WOOD = prop;

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

        	RenderTypeLookup.setRenderLayer(_terrace_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_skyline_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_compact_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_bulk_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_loft_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_railing, renderSet);
        	RenderTypeLookup.setRenderLayer(_balcony, renderSet);
        	RenderTypeLookup.setRenderLayer(_platform, renderSet);
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

        	RenderTypeLookup.setRenderLayer(_terrace_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_skyline_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_compact_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_bulk_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_loft_stairs, renderSet);
        	RenderTypeLookup.setRenderLayer(_railing, renderSet);
        	RenderTypeLookup.setRenderLayer(_balcony, renderSet);
        	RenderTypeLookup.setRenderLayer(_platform, renderSet);
        }
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);

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
	
	public static void registryStone(final RegistryEvent.Register<Block> event, String Modid, List<String> STONES, ItemGroup tab)
	{
	 	final AbstractBlock.Properties STONE = AbstractBlock.Properties.of(Material.STONE).strength(2.0F, 2.3F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops();

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