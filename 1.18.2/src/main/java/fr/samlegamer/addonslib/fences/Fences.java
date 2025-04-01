package fr.samlegamer.addonslib.fences;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Fences
{	
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationHedgesModLoaded(leaves, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE));
	}
	
	/**
	 * Init all Wood Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
			RegistryObject<Block> picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

			for(String i : set)
			{				

				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    	stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    	horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    	wired_fence = createBlock(i + "_wired_fence", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.WiredFence", WOOD), block, item, tab, modLoaded);
				    	highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
				    	pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
						curved_gate = createBlock(i + "_curved_gate", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.DoubleGate", WOOD), block, item, tab, modLoaded);
					} else {
				    	picket_fence = createBlock(i + "_picket_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    	stockade_fence = createBlock(i + "_stockade_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    	horse_fence = createBlock(i + "_horse_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    	wired_fence = createBlock(i + "_wired_fence", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    	highley_gate = createBlock(i + "_highley_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
				    	pyramid_gate = createBlock(i + "_pyramid_gate", () -> new FenceGateBlock(WOOD), block, item, tab, modLoaded);
						curved_gate = createBlock(i + "_curved_gate", () -> new FenceBlock(WOOD), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationHedgesModLoaded(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties HEDGES = prop;
			RegistryObject<Block> hedge;
			
			for(String i : leaves)
			{
				if (ModList.get().isLoaded(modid))
	        	{
					hedge = createBlock(i + "_hedge", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES), block, item, tab, modLoaded);

	            } else {
	            	hedge = createBlock(i + "_hedge", () -> new FenceBlock(HEDGES), block, item, tab, modLoaded);
	            }
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties STONE = prop;
			RegistryObject<Block> modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

			for(String i : rock)
			{

				if (ModList.get().isLoaded(modid)) {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab, modLoaded);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
	                grass_topped_wall = createBlock(i + "_grass_topped_wall", () -> Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", STONE), block, item, tab, modLoaded);

	            } else {
					modern_wall = createBlockStone("modern_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_wall = createBlockStone("railing_"+i+"_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					railing_gate = createBlockStone(i+"_railing_gate", () -> new FenceGateBlock(STONE), block, item, tab, modLoaded);
					pillar_wall = createBlockStone(i+"_pillar_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
					grass_topped_wall = createBlockStone(i+"_grass_topped_wall", () -> new FenceBlock(STONE), block, item, tab, modLoaded);
	            }
			}
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        }
        return block;
    }

	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlockStone(name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
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

	public static void registryWood(final RegistryEvent.Register<Block> event, List<String> set, CreativeModeTab tab)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);

			Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				        picket_fence = createBlockWoodOpti(i + "_picket_fence", new FenceBlock(WOOD), tab);
				        stockade_fence = createBlockWoodOpti(i + "_stockade_fence", new FenceBlock(WOOD), tab);
				        horse_fence = createBlockWoodOpti(i + "_horse_fence", new FenceBlock(WOOD), tab);
			            wired_fence = createBlockWoodOpti(i + "_wired_fence", Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.WiredFence", WOOD), tab);
				        highley_gate = createBlockWoodOpti(i + "_highley_gate", new FenceGateBlock(WOOD), tab);
				        pyramid_gate = createBlockWoodOpti(i + "_pyramid_gate", new FenceGateBlock(WOOD), tab);
						curved_gate = createBlockWoodOpti(i + "_curved_gate", Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.DoubleGate", WOOD), tab);
					} else {
				        picket_fence = createBlockWoodOpti(i + "_picket_fence", new FenceBlock(WOOD), tab);
				        stockade_fence = createBlockWoodOpti(i + "_stockade_fence", new FenceBlock(WOOD), tab);
				        horse_fence = createBlockWoodOpti(i + "_horse_fence", new FenceBlock(WOOD), tab);
				        wired_fence = createBlockWoodOpti(i + "_wired_fence", new FenceBlock(WOOD), tab);
				        highley_gate = createBlockWoodOpti(i + "_highley_gate", new FenceGateBlock(WOOD), tab);
				        pyramid_gate = createBlockWoodOpti(i + "_pyramid_gate", new FenceGateBlock(WOOD), tab);
						curved_gate = createBlockWoodOpti(i + "_curved_gate", new FenceBlock(WOOD), tab);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void registryHedges(final RegistryEvent.Register<Block> event, List<String> leaves, CreativeModeTab tab)
	{
			final BlockBehaviour.Properties HEDGES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES);
			Block hedge;

			for(String i : leaves)
			{
				if (ModList.get().isLoaded(modid))
	        	{
	                hedge = createBlockWoodOpti(i + "_hedge", Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", HEDGES), tab);

	            } else {
	                hedge = createBlockWoodOpti(i + "_hedge", new FenceBlock(HEDGES), tab);
	            }
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void registryStone(final RegistryEvent.Register<Block> event, List<String> rock, CreativeModeTab tab)
	{
			final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.copy(Blocks.COBBLESTONE);
			Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

			for(String i : rock)
			{
				if (ModList.get().isLoaded(modid)) {
					modern_wall = createBlockStoneOpti("modern_"+i+"_wall", new FenceBlock(STONE), tab);
					railing_wall = createBlockStoneOpti("railing_"+i+"_wall", new FenceBlock(STONE), tab);
					railing_gate = createBlockStoneOpti(i+"_railing_gate", new FenceGateBlock(STONE), tab);
					pillar_wall = createBlockStoneOpti(i+"_pillar_wall", new FenceBlock(STONE), tab);
	                grass_topped_wall = createBlockStoneOpti(i + "_grass_topped_wall", Registration.getBlocksFieldForFences("com.mcwfences.kikoz.objects.FenceHitbox", STONE), tab);

	            } else {
					modern_wall = createBlockStoneOpti("modern_"+i+"_wall", new FenceBlock(STONE), tab);
					railing_wall = createBlockStoneOpti("railing_"+i+"_wall", new FenceBlock(STONE), tab);
					railing_gate = createBlockStoneOpti(i+"_railing_gate", new FenceGateBlock(STONE), tab);
					pillar_wall = createBlockStoneOpti(i+"_pillar_wall", new FenceBlock(STONE), tab);
					grass_topped_wall = createBlockStoneOpti(i+"_grass_topped_wall", new FenceBlock(STONE), tab);
	            }
			}
	}
	
	protected static Block createBlockWoodOpti(String name, Block block, CreativeModeTab tab)
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
			
        	ItemBlockRenderTypes.setRenderLayer(picket_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(stockade_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(horse_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(wired_fence, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(highley_gate, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(pyramid_gate, renderSet);
			ItemBlockRenderTypes.setRenderLayer(curved_gate, renderSet);
        }
	}

	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block hedge;
		
		for (String i : WOOD)
		{
			hedge = Finder.findBlock(MODID, i + "_hedge");
			
        	ItemBlockRenderTypes.setRenderLayer(hedge, renderSet);
        }
	}
	
	public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientHedge(event, MODID, WOOD, RenderType.cutout());
	}
	
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
			
        	ItemBlockRenderTypes.setRenderLayer(modern_wall, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(railing_wall, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(railing_gate, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(pillar_wall, renderSet);
        	ItemBlockRenderTypes.setRenderLayer(grass_topped_wall, renderSet);
        }
	}
	
	public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
	{
		clientStone(event, MODID, STONE, RenderType.cutout());
	}
}