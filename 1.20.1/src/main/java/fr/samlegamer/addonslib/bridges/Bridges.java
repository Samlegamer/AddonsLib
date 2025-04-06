package fr.samlegamer.addonslib.bridges;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Bridges
{
	private static final BlockBehaviour.Properties wood = BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.WOOD);
	private static final BlockBehaviour.Properties stone = BlockBehaviour.Properties.of().strength(3.0F, 5.0F).sound(SoundType.STONE);
	
	public static final String modid = "mcwbridges";
	private static final String desc = "mcwbridges.bridges.desc";
	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
			setRegistrationWoodModLoaded(set, block, item, wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item)
	{
			setRegistrationRockModLoaded(set, block, item, stone);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
		 final BlockBehaviour.Properties STONE = prop;
		 RegistryObject<Block> cryptic_stone_bridge, cryptic_stone_bridge_pier, cryptic_stone_bridge_stair, balustrade_cryptic_stone_bridge;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	cryptic_stone_bridge = createBlockStone(i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), block, item);
						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", STONE), block, item);
						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", STONE), block, item);
						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), block, item);
				    }
				    else
				    {
						cryptic_stone_bridge = createBlockStone(i+"_bridge", () -> new Block(STONE), block, item);
						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", () -> new Block(STONE), block, item);
						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", () -> new Block(STONE), block, item);
						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", () -> new Block(STONE), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
			final BlockBehaviour.Properties RAILS = prop.noOcclusion();
			RegistryObject<Block> log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	log_bridge_middle = createBlock(i+"_log_bridge_middle", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Log_Bridge", WOOD), block, item);
						rope_bridge = createBlock("rope_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block_Rope", WOOD), block, item);
						bridge_pier = createBlock(i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", WOOD), block, item);
						log_bridge_stair = createBlock(i+"_log_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), block, item);
						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), block, item);
						rail_bridge = createBlock(i+"_rail_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Rail_Bridge", WOOD), block, item);
				    }
				    else
				    {
						log_bridge_middle = createBlock(i+"_log_bridge_middle", () -> new Block(WOOD), block, item);
						rope_bridge = createBlock("rope_"+i+"_bridge", () -> new Block(WOOD), block, item);
						bridge_pier = createBlock(i+"_bridge_pier", () -> new Block(WOOD), block, item);
						log_bridge_stair = createBlock(i+"_log_bridge_stair", () -> new Block(WOOD), block, item);
						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", () -> new Block(WOOD), block, item);
						rail_bridge = createBlock(i+"_rail_bridge", () -> new Block(RAILS), block, item);
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties(), desc));
		}
		else {
			ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		addToTabModLoaded(event, MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab, String modLoaded)
	{
		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
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

	public static void addToTabStone(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab)
	{
		addToTabStoneModLoaded(event, MODID, STONE, tab, "minecraft");
	}

	public static void addToTabStoneModLoaded(BuildCreativeModeTabContentsEvent event, String MODID, List<String> STONE, CreativeModeTab tab, String modLoaded)
	{
		Block stone_bridge, stone_bridge_pier, stone_bridge_stair, balustrade_stone_bridge;

		if (event.getTab() == tab && ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
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