package fr.samlegamer.addonslib.path;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
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
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Paths with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister.Blocks block, DeferredRegister.Items item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);

			for(String i : set)
			{
				DeferredBlock<Block> planks_path;
				  
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						planks_path = createBlock(mod, i+"_planks_path", () -> Registration.getBlocksField("com.mcwpaths.kikoz.objects.FacingPathBlock", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_path")))), block, item, tab, modLoaded);
					}
					else
					{
						planks_path = createBlock(mod, i+"_planks_path", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_planks_path")))), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab)
    {
        return createBlock(mod, name, supplier, BLOCKS_REGISTRY, ITEMS_REGISTRY, tab, "minecraft");
    }
	
	protected static DeferredBlock<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
        }
        return block;
    }
	
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