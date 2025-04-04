package fr.samlegamer.addonslib.fences;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Fences
{
	private static final BlockBehaviour.Properties wood = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
	private static final BlockBehaviour.Properties leaves = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES);
	private static final BlockBehaviour.Properties stone = BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE);
	
	public static final String modid = "mcwfences";
	
	/**
	 * Init all Wood Variants of Macaw's Fences
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Hedges Variants of Macaw's Fences
	 */
	public static void setRegistrationHedges(List<String> leaves, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationHedgesModLoaded(leaves, block, item, tab, "minecraft", Fences.leaves);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Fences
	 */
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationRockModLoaded(rock, block, item, tab, "minecraft", stone);
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
}