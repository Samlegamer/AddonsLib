package fr.samlegamer.addonslib.fences;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Fences
{
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		final AbstractBlock.Properties wood = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		final AbstractBlock.Properties leave = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);
		setRegistrationHedgesModLoaded(leaves, block, item, tab, "minecraft", leave);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		final AbstractBlock.Properties stone = AbstractBlock.Properties.copy(Blocks.COBBLESTONE);
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", stone);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties WOOD = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					createBlock(id, () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					createBlock(id, () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
				} else if(isModLoaded) {
					createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, modLoaded);
				}
				else {
					createBlock(id, () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties HEDGES = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), HEDGES), block, item, tab, modLoaded);
				}
				else {
					createBlock(id, () -> new FenceBlock(HEDGES), block, item, tab, modLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties STONE = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					createBlockStone(id, () -> new FenceBlock(STONE), block, item, tab, modLoaded);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					createBlockStone(id, () -> new FenceGateBlock(STONE), block, item, tab, modLoaded);
				} else if(isModLoaded) {
					createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, modLoaded);
				}
				else {
					createBlockStone(id, () -> new FenceBlock(STONE), block, item, tab, modLoaded);
				}
			}
		}
	}
	
	protected static void createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ModList modList = ModList.get();
		if(modList.isLoaded(modid) && modList.isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
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
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
	}
	
	//Start of new registration system

	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					createBlockWoodOpti(Modid, id, new FenceBlock(WOOD), tab);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					createBlockWoodOpti(Modid, id, new FenceGateBlock(WOOD), tab);
				} else if(isModLoaded) {
					createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab);
				}
				else {
					createBlockWoodOpti(Modid, id, new FenceBlock(WOOD), tab);
				}
			}
		}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void registryHedges(final RegistryEvent.Register<Block> event, String Modid, List<String> leaves, ItemGroup tab)
	{
		final AbstractBlock.Properties HEDGES = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : leaves) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_LEAVE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), HEDGES), tab);
				}
				else {
					createBlockWoodOpti(Modid, id, new FenceBlock(HEDGES), tab);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void registryStone(final RegistryEvent.Register<Block> event, String Modid, List<String> rock, ItemGroup tab)
	{
		final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.COBBLESTONE);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.FENCES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("FenceBlock")) {
					createBlockStoneOpti(Modid, id, new FenceBlock(STONE), tab);
				} else if (blockId.reflectedLocation().contains("FenceGateBlock")) {
					createBlockStoneOpti(Modid, id, new FenceGateBlock(STONE), tab);
				} else if(isModLoaded) {
					createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab);
				}
				else {
					createBlockStoneOpti(Modid, id, new FenceBlock(STONE), tab);
				}
			}
		}
	}
	
	protected static void createBlockWoodOpti(String Modid, String name, Block block, ItemGroup tab)
    {
		BlockItem itemBlock;
        if(ModList.get().isLoaded(modid))
		{
        	itemBlock = new BlockItemFuel(block, new Item.Properties().tab(tab));
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
        	itemBlock = new BlockItem(block, new Item.Properties().tab(tab));
        }
		else
		{
			itemBlock = new BlockItem(block, new Item.Properties());
		}
        block.setRegistryName(Modid, name);
        itemBlock.setRegistryName(Modid, name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;
		
		for (String i : WOOD)
		{
			picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
			stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
			horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
			wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
			highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
			pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
			curved_gate = Finder.findBlock(MODID, i + "_curved_gate");
			
        	RenderTypeLookup.setRenderLayer(picket_fence, renderSet);
        	RenderTypeLookup.setRenderLayer(stockade_fence, renderSet);
        	RenderTypeLookup.setRenderLayer(horse_fence, renderSet);
        	RenderTypeLookup.setRenderLayer(wired_fence, renderSet);
        	RenderTypeLookup.setRenderLayer(highley_gate, renderSet);
        	RenderTypeLookup.setRenderLayer(pyramid_gate, renderSet);
			RenderTypeLookup.setRenderLayer(curved_gate, renderSet);
        }
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	@Deprecated
	public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block hedge;
		
		for (String i : WOOD)
		{
			hedge = Finder.findBlock(MODID, i + "_hedge");
			
        	RenderTypeLookup.setRenderLayer(hedge, renderSet);
        }
	}

	@Deprecated
	public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientHedge(event, MODID, WOOD, RenderType.cutout());
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
	{
		Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;
		
		for (String i : STONE)
		{
			modern_wall = Finder.findBlock(MODID, "modern_"+i+"_wall");
			railing_wall = Finder.findBlock(MODID, "railing_"+i+"_wall");
			railing_gate = Finder.findBlock(MODID, i+"_railing_gate");
			pillar_wall = Finder.findBlock(MODID, i+"_pillar_wall");
			grass_topped_wall = Finder.findBlock(MODID, i + "_grass_topped_wall");
			
        	RenderTypeLookup.setRenderLayer(modern_wall, renderSet);
        	RenderTypeLookup.setRenderLayer(railing_wall, renderSet);
        	RenderTypeLookup.setRenderLayer(railing_gate, renderSet);
        	RenderTypeLookup.setRenderLayer(pillar_wall, renderSet);
        	RenderTypeLookup.setRenderLayer(grass_topped_wall, renderSet);
        }
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}
}