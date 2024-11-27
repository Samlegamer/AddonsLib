package fr.samlegamer.addonslib.bridges;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Bridges
{
	private static BlockBehaviour.Properties wood = BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F, 2.5F).sound(SoundType.WOOD);
	private static BlockBehaviour.Properties stone = BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 5.0F).sound(SoundType.STONE);
	
	public static final String modid = "mcwbridges";
	private static final String desc = "mcwbridges.bridges.desc";
	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
			setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
			setRegistrationRockModLoaded(set, block, item, tab, "minecraft", stone);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		 final BlockBehaviour.Properties STONE = prop;

			for(String i : set)
			{
				 RegistryObject<Block> cryptic_stone_bridge, cryptic_stone_bridge_pier, cryptic_stone_bridge_stair, balustrade_cryptic_stone_bridge;

				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	cryptic_stone_bridge = createBlockStone(i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), block, item, tab, modLoaded);
						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", STONE), block, item, tab, modLoaded);
						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", STONE), block, item, tab, modLoaded);
						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), block, item, tab, modLoaded);
				    }
				    else
				    {
						cryptic_stone_bridge = createBlockStone(i+"_bridge", () -> new Block(STONE), block, item, tab, modLoaded);
						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", () -> new Block(STONE), block, item, tab, modLoaded);
						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", () -> new Block(STONE), block, item, tab, modLoaded);
						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", () -> new Block(STONE), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
			final BlockBehaviour.Properties RAILS = prop.noOcclusion();

			for(String i : set)
			{
				RegistryObject<Block> log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;

				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	log_bridge_middle = createBlock(i+"_log_bridge_middle", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Log_Bridge", WOOD), block, item, tab, modLoaded);
						rope_bridge = createBlock("rope_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block_Rope", WOOD), block, item, tab, modLoaded);
						bridge_pier = createBlock(i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", WOOD), block, item, tab, modLoaded);
						log_bridge_stair = createBlock(i+"_log_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), block, item, tab, modLoaded);
						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), block, item, tab, modLoaded);
						rail_bridge = createBlock(i+"_rail_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Rail_Bridge", WOOD), block, item, tab, modLoaded);
				    }
				    else
				    {
						log_bridge_middle = createBlock(i+"_log_bridge_middle", () -> new Block(WOOD), block, item, tab, modLoaded);
						rope_bridge = createBlock("rope_"+i+"_bridge", () -> new Block(WOOD), block, item, tab, modLoaded);
						bridge_pier = createBlock(i+"_bridge_pier", () -> new Block(WOOD), block, item, tab, modLoaded);
						log_bridge_stair = createBlock(i+"_log_bridge_stair", () -> new Block(WOOD), block, item, tab, modLoaded);
						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", () -> new Block(WOOD), block, item, tab, modLoaded);
						rail_bridge = createBlock(i+"_rail_bridge", () -> new Block(RAILS), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
		
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
	
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}
	
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

	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
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
        return block;
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        }
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	//Start of new registration system
	
	public static void registryWood(final RegistryEvent.Register<Block> event, List<String> WOODS, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = wood;
		final BlockBehaviour.Properties RAILS = wood.noOcclusion();

		for(String i : WOODS)
		{
			Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
			
			try {
			    if (ModList.get().isLoaded(modid))
			    {
			    	log_bridge_middle = createBlockWoodOpti(i+"_log_bridge_middle", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Log_Bridge", WOOD), tab);
					rope_bridge = createBlockWoodOpti("rope_"+i+"_bridge", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block_Rope", WOOD), tab);
					bridge_pier = createBlockWoodOpti(i+"_bridge_pier", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", WOOD), tab);
					log_bridge_stair = createBlockWoodOpti(i+"_log_bridge_stair", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), tab);
					rope_bridge_stair = createBlockWoodOpti(i+"_rope_bridge_stair", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), tab);
					rail_bridge = createBlockWoodOpti(i+"_rail_bridge", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Rail_Bridge", WOOD), tab);
			    }
			    else
			    {
					log_bridge_middle = createBlockWoodOpti(i+"_log_bridge_middle", new Block(WOOD), tab);
					rope_bridge = createBlockWoodOpti("rope_"+i+"_bridge", new Block(WOOD), tab);
					bridge_pier = createBlockWoodOpti(i+"_bridge_pier", new Block(WOOD), tab);
					log_bridge_stair = createBlockWoodOpti(i+"_log_bridge_stair", new Block(WOOD), tab);
					rope_bridge_stair = createBlockWoodOpti(i+"_rope_bridge_stair", new Block(WOOD), tab);
					rail_bridge = createBlockWoodOpti(i+"_rail_bridge", new Block(RAILS), tab);
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	}
	
	public static void registryStone(final RegistryEvent.Register<Block> event, List<String> STONES, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = stone;

		for(String i : STONES)
		{
			Block cryptic_stone_bridge, cryptic_stone_bridge_pier, cryptic_stone_bridge_stair, balustrade_cryptic_stone_bridge;
			try {
			    if (ModList.get().isLoaded(modid))
			    {
			    	cryptic_stone_bridge = createBlockStoneOpti(i+"_bridge", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), tab);
					cryptic_stone_bridge_pier = createBlockStoneOpti(i+"_bridge_pier", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", STONE), tab);
					cryptic_stone_bridge_stair = createBlockStoneOpti(i+"_bridge_stair", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", STONE), tab);
					balustrade_cryptic_stone_bridge = createBlockStoneOpti("balustrade_"+i+"_bridge", Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), tab);
			    }
			    else
			    {
					cryptic_stone_bridge = createBlockStoneOpti(i+"_bridge", new Block(STONE), tab);
					cryptic_stone_bridge_pier = createBlockStoneOpti(i+"_bridge_pier", new Block(STONE), tab);
					cryptic_stone_bridge_stair = createBlockStoneOpti(i+"_bridge_stair", new Block(STONE), tab);
					balustrade_cryptic_stone_bridge = createBlockStoneOpti("balustrade_"+i+"_bridge", new Block(STONE), tab);
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	}

	protected static Block createBlockWoodOpti(String name, Block block, CreativeModeTab tab)
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
        return block;
    }

	protected static Block createBlockStoneOpti(String name, Block block, CreativeModeTab tab)
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
        return block;
    }
}
