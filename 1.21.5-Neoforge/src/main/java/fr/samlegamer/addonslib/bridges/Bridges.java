package fr.samlegamer.addonslib.bridges;

import java.util.List;
import java.util.function.Function;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Bridges
{
	public static final String modid = "mcwbridges";
	private static final String desc = "mcwbridges.bridges.desc";

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
		 //DeferredBlock<Block> cryptic_stone_bridge, cryptic_stone_bridge_pier, cryptic_stone_bridge_stair, balustrade_cryptic_stone_bridge;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_STONE_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlockStone(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					createBlockStone(id, registryName -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}

//		for(String i : set)
//			{
//				try {
//				    if (ModList.get().isLoaded(modid))
//				    {
//						cryptic_stone_bridge = createBlockStone(i+"_bridge", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					}
//					else
//					{
//						cryptic_stone_bridge = createBlockStone(i+"_bridge", registryName -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", registryName -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", registryName -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", registryName -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//				    }
//				} catch (Exception e) {
//					AddonsLib.LOGGER.error(e);
//				}
//			}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;
//		final BlockBehaviour.Properties RAILS = prop.noOcclusion();

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.BRIDGES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					createBlock(id, registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}

//			DeferredBlock<Block> log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
//
//			for(String i : set)
//			{
//				try {
//				    if (ModList.get().isLoaded(modid))
//				    {
//						log_bridge_middle = createBlock(i+"_log_bridge_middle", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Log_Bridge", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						rope_bridge = createBlock("rope_"+i+"_bridge", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block_Rope", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						bridge_pier = createBlock(i+"_bridge_pier", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						log_bridge_stair = createBlock(i+"_log_bridge_stair", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						rail_bridge = createBlock(i+"_rail_bridge", registryName -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Rail_Bridge", RAILS.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					}
//					else
//					{
//						log_bridge_middle = createBlock(i+"_log_bridge_middle", registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						rope_bridge = createBlock("rope_"+i+"_bridge", registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						bridge_pier = createBlock(i+"_bridge_pier", registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						log_bridge_stair = createBlock(i+"_log_bridge_stair", registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//						rail_bridge = createBlock(i+"_rail_bridge", registryName -> new Block(RAILS.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//				    }
//				} catch (Exception e) {
//					AddonsLib.LOGGER.error(e);
//				}
//			}
	}
	
	protected static void createBlock(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName)), desc));
		}
		else {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
		}
	}

	protected static void createBlockStone(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		ITEMS_REGISTRY.register(name, registryName -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
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