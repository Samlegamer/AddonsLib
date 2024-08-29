package fr.samlegamer.addonslib.bridges;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.Registration;
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
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Bridges
{
	private static final List<RegistryObject<Block>> BRIDGE_BLOCKS = new ArrayList<>();

	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(0.5F, 2.5F).sound(SoundType.WOOD);
			final AbstractBlock.Properties RAILS = AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(0.5F, 2.5F).noOcclusion().sound(SoundType.WOOD);

			for(String i : set)
			{
				RegistryObject<Block> log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
				
				try {
				    if (ModList.get().isLoaded("mcwbridges"))
				    {
				    	log_bridge_middle = createBlock(i+"_log_bridge_middle", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Log_Bridge", WOOD), block, item, tab);
						rope_bridge = createBlock("rope_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block_Rope", WOOD), block, item, tab);
						bridge_pier = createBlock(i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", WOOD), block, item, tab);
						log_bridge_stair = createBlock(i+"_log_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), block, item, tab);
						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD), block, item, tab);
						rail_bridge = createBlock(i+"_rail_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Rail_Bridge", WOOD), block, item, tab);
				    }
				    else
				    {
						log_bridge_middle = createBlock(i+"_log_bridge_middle", () -> new Block(WOOD), block, item, tab);
						rope_bridge = createBlock("rope_"+i+"_bridge", () -> new Block(WOOD), block, item, tab);
						bridge_pier = createBlock(i+"_bridge_pier", () -> new Block(WOOD), block, item, tab);
						log_bridge_stair = createBlock(i+"_log_bridge_stair", () -> new Block(WOOD), block, item, tab);
						rope_bridge_stair = createBlock(i+"_rope_bridge_stair", () -> new Block(WOOD), block, item, tab);
						rail_bridge = createBlock(i+"_rail_bridge", () -> new Block(RAILS), block, item, tab);
				    }
			        BRIDGE_BLOCKS.add(log_bridge_middle);
			        BRIDGE_BLOCKS.add(rope_bridge);
			        BRIDGE_BLOCKS.add(bridge_pier);
			        BRIDGE_BLOCKS.add(log_bridge_stair);
			        BRIDGE_BLOCKS.add(rope_bridge_stair);
			        BRIDGE_BLOCKS.add(rail_bridge);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		 final AbstractBlock.Properties STONE = AbstractBlock.Properties.of(Material.STONE).harvestTool(ToolType.PICKAXE).strength(3.0F, 5.0F).sound(SoundType.STONE);

			for(String i : set)
			{
				RegistryObject<Block> cryptic_stone_bridge, cryptic_stone_bridge_pier, cryptic_stone_bridge_stair, balustrade_cryptic_stone_bridge;
				
				try {
				    if (ModList.get().isLoaded("mcwbridges"))
				    {
				    	cryptic_stone_bridge = createBlockStone(i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), block, item, tab);
						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", STONE), block, item, tab);
						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", STONE), block, item, tab);
						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE), block, item, tab);
				    }
				    else
				    {
						cryptic_stone_bridge = createBlockStone(i+"_bridge", () -> new Block(STONE), block, item, tab);
						cryptic_stone_bridge_pier = createBlockStone(i+"_bridge_pier", () -> new Block(STONE), block, item, tab);
						cryptic_stone_bridge_stair = createBlockStone(i+"_bridge_stair", () -> new Block(STONE), block, item, tab);
						balustrade_cryptic_stone_bridge = createBlockStone("balustrade_"+i+"_bridge", () -> new Block(STONE), block, item, tab);
				    }
			        BRIDGE_BLOCKS.add(cryptic_stone_bridge);
			        BRIDGE_BLOCKS.add(cryptic_stone_bridge_pier);
			        BRIDGE_BLOCKS.add(cryptic_stone_bridge_stair);
			        BRIDGE_BLOCKS.add(balustrade_cryptic_stone_bridge);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static List<RegistryObject<Block>> getBridgeBlocks() {
		return BRIDGE_BLOCKS;
	}
	
	/**
	 * Use this to set Render Bridges
	 */
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : BRIDGE_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	/*Add Logo Item for Used*/
	@Deprecated
	public static Block getTabIcon()
	{
		return BRIDGE_BLOCKS.get(0).get();
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded("mcwbridges"))
		{
	        if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwbridges.kikoz.util.FuelBlockItemWithInfo(block.get(), new Item.Properties().tab(tab)));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new com.mcwbridges.kikoz.util.FuelItemBlock(block.get(), new Item.Properties().tab(tab)));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		}
        return block;
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwbridges"))
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
