package fr.samlegamer.addonslib.bridges;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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

public class Bridges
{
	public static final String modid = "mcwbridges";
	private static final String desc = "mcwbridges.bridges.desc";

	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", AbstractBlock.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationRockModLoaded(set, block, item, tab, "minecraft", AbstractBlock.Properties.copy(Blocks.COBBLESTONE));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		 final AbstractBlock.Properties STONE = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
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
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties WOOD = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
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
		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
		
		for (String i : WOOD)
		{				    	
			log_bridge_middle = Finder.findBlock(MODID, i+"_log_bridge_middle");
			rope_bridge = Finder.findBlock(MODID, "rope_"+i+"_bridge");
			bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
			log_bridge_stair = Finder.findBlock(MODID, i+"_log_bridge_stair");
			rope_bridge_stair = Finder.findBlock(MODID, i+"_rope_bridge_stair");
			rail_bridge = Finder.findBlock(MODID, i+"_rail_bridge");
			
        	RenderTypeLookup.setRenderLayer(log_bridge_middle, renderSet);
        	RenderTypeLookup.setRenderLayer(rope_bridge, renderSet);
        	RenderTypeLookup.setRenderLayer(bridge_pier, renderSet);
        	RenderTypeLookup.setRenderLayer(log_bridge_stair, renderSet);
        	RenderTypeLookup.setRenderLayer(rope_bridge_stair, renderSet);
        	RenderTypeLookup.setRenderLayer(rail_bridge, renderSet);
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
			
        	RenderTypeLookup.setRenderLayer(stone_bridge, renderSet);
        	RenderTypeLookup.setRenderLayer(stone_bridge_pier, renderSet);
        	RenderTypeLookup.setRenderLayer(stone_bridge_stair, renderSet);
        	RenderTypeLookup.setRenderLayer(balustrade_stone_bridge, renderSet);
        }
	}

	@Deprecated
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}
	
	protected static void createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
		ModList modList = ModList.get();

        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(modList.isLoaded(modid) && modList.isLoaded(modLoaded))
		{
	        if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().tab(tab), desc));
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
		ModList modList = ModList.get();

		RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
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
	
	public static void registryWood(final RegistryEvent.Register<Block> event, List<String> WOODS, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : WOODS) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlockWoodOpti(id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab);
				}
				else {
					createBlockWoodOpti(id, new Block(WOOD), tab);
				}
			}
		}
	}
	
	public static void registryStone(final RegistryEvent.Register<Block> event, List<String> STONES, ItemGroup tab)
	{
		final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.COBBLESTONE);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : STONES) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlockStoneOpti(id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab);
				}
				else {
					createBlockStoneOpti(id,new Block(STONE), tab);
				}
			}
		}
	}

	protected static void createBlockWoodOpti(String name, Block block, ItemGroup tab)
    {
		BlockItem itemBlock;        
        if(ModList.get().isLoaded(modid))
		{
	        if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
	        	itemBlock = new BlockItemFuelInfo(block, new Item.Properties().tab(tab), desc);
	        }
	        else {
	        	itemBlock = new BlockItemFuel(block, new Item.Properties().tab(tab));
	        }
		}
		else
		{
			itemBlock = new BlockItemFuel(block, new Item.Properties());
		}
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
	}

	protected static void createBlockStoneOpti(String name, Block block, ItemGroup tab)
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
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
	}
}
