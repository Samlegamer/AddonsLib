package fr.samlegamer.addonslib.bridges;

import java.util.List;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
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
	private static final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of().strength(0.5F, 2.5F).sound(SoundType.WOOD);
	private static final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of().strength(3.0F, 5.0F).sound(SoundType.STONE);
	
	public static final String modid = "mcwbridges";
	private static final String desc = "mcwbridges.bridges.desc";
	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
			setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft", WOOD);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
			setRegistrationRockModLoaded(set, mod, block, item, tab, "minecraft", STONE);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		 final BlockBehaviour.Properties STONE = prop;
		 DeferredBlock<Block> cryptic_stone_bridge, cryptic_stone_bridge_pier, cryptic_stone_bridge_stair, balustrade_cryptic_stone_bridge;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						cryptic_stone_bridge = createBlockStone(mod, i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bridge")))), block, item, tab, modLoaded);
						cryptic_stone_bridge_pier = createBlockStone(mod, i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bridge_pier")))), block, item, tab, modLoaded);
						cryptic_stone_bridge_stair = createBlockStone(mod, i+"_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bridge_stair")))), block, item, tab, modLoaded);
						balustrade_cryptic_stone_bridge = createBlockStone(mod, "balustrade_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "balustrade_"+i+"_bridge")))), block, item, tab, modLoaded);
					}
					else
					{
						cryptic_stone_bridge = createBlockStone(mod, i+"_bridge", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modid, i+"_bridge")))), block, item, tab, modLoaded);
						cryptic_stone_bridge_pier = createBlockStone(mod, i+"_bridge_pier", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modid, i+"_bridge_pier")))), block, item, tab, modLoaded);
						cryptic_stone_bridge_stair = createBlockStone(mod, i+"_bridge_stair", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modid, i+"_bridge_stair")))), block, item, tab, modLoaded);
						balustrade_cryptic_stone_bridge = createBlockStone(mod, "balustrade_"+i+"_bridge", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modid, "balustrade_"+i+"_bridge")))), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
			final BlockBehaviour.Properties RAILS = prop.noOcclusion();
			DeferredBlock<Block> log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						log_bridge_middle = createBlock(mod, i+"_log_bridge_middle", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Log_Bridge", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_log_bridge_middle")))), block, item, tab, modLoaded);
						rope_bridge = createBlock(mod, "rope_"+i+"_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Block_Rope", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "rope_"+i+"_bridge")))), block, item, tab, modLoaded);
						bridge_pier = createBlock(mod, i+"_bridge_pier", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Support", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bridge_pier")))), block, item, tab, modLoaded);
						log_bridge_stair = createBlock(mod, i+"_log_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_log_bridge_stair")))), block, item, tab, modLoaded);
						rope_bridge_stair = createBlock(mod, i+"_rope_bridge_stair", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Bridge_Stairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_rope_bridge_stair")))), block, item, tab, modLoaded);
						rail_bridge = createBlock(mod, i+"_rail_bridge", () -> Registration.getBlocksField("com.mcwbridges.kikoz.objects.Rail_Bridge", RAILS.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_rail_bridge")))), block, item, tab, modLoaded);
					}
					else
					{
						log_bridge_middle = createBlock(mod, i+"_log_bridge_middle", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_log_bridge_middle")))), block, item, tab, modLoaded);
						rope_bridge = createBlock(mod, "rope_"+i+"_bridge", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "rope_"+i+"_bridge")))), block, item, tab, modLoaded);
						bridge_pier = createBlock(mod, i+"_bridge_pier", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bridge_pier")))), block, item, tab, modLoaded);
						log_bridge_stair = createBlock(mod, i+"_log_bridge_stair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_log_bridge_stair")))), block, item, tab, modLoaded);
						rope_bridge_stair = createBlock(mod, i+"_rope_bridge_stair", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_rope_bridge_stair")))), block, item, tab, modLoaded);
						rail_bridge = createBlock(mod, i+"_rail_bridge", () -> new Block(RAILS.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_rail_bridge")))), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
	        if(name.contains("log_bridge_middle") || name.startsWith("rope_")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location())), desc));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
		}
        return block;
    }
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlockStone(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlockStone(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
		}
        return block;
    }

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