package fr.samlegamer.addonslib.path;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Paths
{
	private static final List<RegistryObject<Block>> PATH_BLOCKS = new ArrayList<>();

	/**
	 * Init all Wood Variants of Macaw's Paths
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{
				RegistryObject<Block> planks_path;
				  
				try {
				    if (ModList.get().isLoaded("mcwpaths"))
				    {
				    	planks_path = createBlock(i+"_planks_path", () -> Registration.getBlocksField("com.mcwpaths.kikoz.objects.FacingPathBlock", WOOD), block, item, tab);
				    }
				    else
				    {
				    	planks_path = createBlock(i+"_planks_path", () -> new Block(WOOD), block, item, tab);
				    }
				    PATH_BLOCKS.add(planks_path);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Init all Wood Variants of Macaw's Paths with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{
				RegistryObject<Block> planks_path;
				  
				try {
				    if (ModList.get().isLoaded("mcwpaths"))
				    {
				    	planks_path = createBlock(i+"_planks_path", () -> Registration.getBlocksField("com.mcwpaths.kikoz.objects.FacingPathBlock", WOOD), block, item, tab, modLoaded);
				    }
				    else
				    {
				    	planks_path = createBlock(i+"_planks_path", () -> new Block(WOOD), block, item, tab, modLoaded);
				    }
				    PATH_BLOCKS.add(planks_path);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	/**
	 * Use this to set Render Paths
	 */
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : PATH_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwpaths"))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        }
        return block;

    }
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        if(ModList.get().isLoaded("mcwpaths") && ModList.get().isLoaded(modLoaded))
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties().tab(tab)));
        }
        else
        {
            ITEMS_REGISTRY.register(name, () -> new BlockItemFuel(block.get(), new Item.Properties()));
        }
        return block;

    }
}