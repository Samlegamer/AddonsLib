package fr.samlegamer.addonslib.path;

import java.util.List;
import java.util.function.Function;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Paths
{
	public static final String modid = "mcwpaths";
	
	/**
	 * Init all Wood Variants of Macaw's Paths
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Paths with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		final BlockBehaviour.Properties WOOD = prop;

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.PATHS_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					createBlock(id, registryName -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
				else {
					createBlock(id, registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
				}
			}
		}
//			for(String i : set)
//			{
//				DeferredBlock<Block> planks_path;
//
//				try {
//				    if (ModList.get().isLoaded(modid))
//				    {
//						planks_path = createBlock(i+"_planks_path", registryName -> Registration.getBlocksField("com.mcwpaths.kikoz.objects.FacingPathBlock", WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//					}
//					else
//					{
//						planks_path = createBlock(i+"_planks_path", registryName -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
//				    }
//				} catch (Exception e) {
//					AddonsLib.LOGGER.error(e);
//				}
//			}
	}

	protected static void createBlock(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
	}

	@Deprecated(forRemoval = true)
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : WOOD)
			{					
				Block planks_path;
		    	
				planks_path = Finder.findBlock(MODID, i+"_planks_path");
				
				event.accept(planks_path);
	        }
   	 	}
	}
}