package fr.samlegamer.addonslib.roofs;

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
import net.minecraft.block.StairsBlock;
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

public class Roofs
{
	public static final String modid = "mcwroofs";
	
	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", AbstractBlock.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", AbstractBlock.Properties.copy(Blocks.COBBLESTONE));
	}

	/**
	 * Init all Wood Variants of Macaw's Roofs
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties WOOD = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(blockId.reflectedLocation().contains("StairsBlock")) {
					createBlock(id, () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, WOOD), block, item, tab, modLoaded);
				}
				else if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						createBlock(id, () ->
								Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, modLoaded);
					} else {
						createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, modLoaded);
					}
				}
				else {
					createBlock(id, () -> new Block(WOOD), block, item, tab, modLoaded);
				}
			}
		}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Roofs
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded, AbstractBlock.Properties prop)
	{
		final AbstractBlock.Properties STONE = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("StairsBlock")) {
					createBlockStone(id, () ->
							new StairsBlock(Blocks.COBBLESTONE::defaultBlockState, STONE), block, item, tab, modLoaded);
				}
				if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						createBlockStone(id, () ->
								Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.COBBLESTONE.defaultBlockState()), block, item, tab, modLoaded);
					} else {
						createBlockStone(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), STONE), block, item, tab, modLoaded);
					}
				}
				else {
					createBlockStone(id, () -> new Block(STONE), block, item, tab, modLoaded);
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
	
	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(blockId.reflectedLocation().contains("StairsBlock")) {
					createBlockWoodOpti(Modid, id, new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, WOOD), tab);
				}
				else if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						createBlockWoodOpti(Modid, id,
								Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab);
					} else {
						createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab);
					}
				}
				else {
					createBlockWoodOpti(Modid, id, new Block(WOOD), tab);
				}
			}
		}
	}
	
	public static void registryStone(final RegistryEvent.Register<Block> event, String Modid, List<String> rock, ItemGroup tab)
	{
		final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.COBBLESTONE);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : rock) {
			for (BlockId blockId : McwBlocksIdBase.ROOFS_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if (blockId.reflectedLocation().contains("StairsBlock")) {
					createBlockStoneOpti(Modid, id,
							new StairsBlock(Blocks.COBBLESTONE::defaultBlockState, STONE), tab);
				}
				if(isModLoaded) {
					if (blockId.reflectedLocation().contains("Lower") || blockId.reflectedLocation().contains("Steep")) {
						createBlockStoneOpti(Modid, id,
								Registration.getBlocksField(blockId.reflectedLocation(), STONE, Blocks.COBBLESTONE.defaultBlockState()), tab);
					} else if (!blockId.reflectedLocation().contains("StairsBlock")) {
						createBlockStoneOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), STONE), tab);
					}
				}
				else {
					createBlockStoneOpti(Modid, id, new Block(STONE), tab);
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
			
        	RenderTypeLookup.setRenderLayer(cherry_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_attic_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_top_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_steep_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_upper_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_upper_steep_roof, renderSet);
        	
        	cherry_planks_roof = Finder.findBlock(MODID, i+"_planks_roof");
			cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
			cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
			cherry_planks_lower_roof = Finder.findBlock(MODID, i+"_planks_lower_roof");
			cherry_planks_steep_roof = Finder.findBlock(MODID, i+"_planks_steep_roof");
			cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
			cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");
			
        	RenderTypeLookup.setRenderLayer(cherry_planks_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_attic_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_top_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_steep_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_upper_lower_roof, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_planks_upper_steep_roof, renderSet);
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

        	RenderTypeLookup.setRenderLayer(ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(ATTIC_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(TOP_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(LOWER_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(STEEP_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(UPPER_LOWER_ROOF, renderSet);
        	RenderTypeLookup.setRenderLayer(UPPER_STEEP_ROOF, renderSet);
        }
	}
}