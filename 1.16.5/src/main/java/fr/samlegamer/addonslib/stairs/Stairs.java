package fr.samlegamer.addonslib.stairs;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
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

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, modLoaded);
				}
				else {
					createBlockStone(id, () -> new Block(STONE), block, item, tab, modLoaded);
				}
			}
		}
	}
	
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties WOOD = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, modLoaded);
				}
				else {
					createBlock(id, () -> new Block(WOOD), block, item, tab, modLoaded);
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

	protected static void createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ModList modList = ModList.get();
        if(modList.isLoaded(modid) && modList.isLoaded(modLoaded))
		{
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.balcony.desc"));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.platform.desc"));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
		}
	}

	protected static void createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
		RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ModList modList = ModList.get();
		if(modList.isLoaded(modid) && modList.isLoaded(modLoaded))
		{
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.balcony.desc"));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties().tab(tab), "mcwstairs.platform.desc"));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		}
	}
	
	//Start of new registration system
	
	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> WOODS, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 2.3F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : WOODS) {
			for (BlockId blockId : McwBlocksIdBase.STAIRS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab);
				}
				else {
					createBlockWoodOpti(Modid, id, new Block(WOOD), tab);
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
					createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab);
				}
				else {
					createBlockStoneOpti(Modid, id, new Block(STONE), tab);
				}
			}
		}
	}

	protected static void createBlockWoodOpti(String Modid, String name, Block block, ItemGroup tab)
    {
		BlockItem itemBlock;
		if(ModList.get().isLoaded(modid))
		{
			if(name.contains("railing")) {
				itemBlock = new BlockItemFuelInfo(block, new Item.Properties().tab(tab), "mcwstairs.railing.desc");
			}
			else if(name.contains("balcony")) {
				itemBlock = new BlockItemFuelInfo(block, new Item.Properties().tab(tab), "mcwstairs.balcony.desc");
			}
			else if(name.contains("platform")) {
				itemBlock = new BlockItemFuelInfo(block, new Item.Properties().tab(tab), "mcwstairs.platform.desc");
			}
			else {
				itemBlock = new BlockItemFuel(block, new Item.Properties().tab(tab));
			}
		}
		else
		{
			itemBlock = new BlockItemFuel(block, new Item.Properties());
		}
        block.setRegistryName(Modid, name);
        itemBlock.setRegistryName(Modid, name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
	}

	protected static void createBlockStoneOpti(String Modid, String name, Block block, ItemGroup tab)
    {
		BlockItem itemBlock;
		if(ModList.get().isLoaded(modid))
		{
	        if(name.contains("railing")) {
	        	itemBlock = new BlockItemInfo(block, new Item.Properties().tab(tab), "mcwstairs.railing.desc");
	        }
	        else if(name.contains("balcony")) {
	        	itemBlock = new BlockItemInfo(block, new Item.Properties().tab(tab), "mcwstairs.balcony.desc");
	        }
	        else if(name.contains("platform")) {
	        	itemBlock = new BlockItemInfo(block, new Item.Properties().tab(tab), "mcwstairs.platform.desc");
	        }
	        else {
	        	itemBlock = new BlockItem(block, new Item.Properties().tab(tab));
	        }
		}
		else
		{
			itemBlock = new BlockItemFuel(block, new Item.Properties());
		}
        block.setRegistryName(Modid, name);
        itemBlock.setRegistryName(Modid, name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
	}
}