package fr.samlegamer.addonslib.windows;

import java.util.List;
import java.util.function.Supplier;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Windows
{
	private static final String modid = "mcwwindows";
	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.6F, 1.2F);
			final BlockBehaviour.Properties PARAPET = BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.2F, 1.0F);
			final BlockBehaviour.Properties BLINDS = BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 1.0F);
			final BlockBehaviour.Properties SHUTTER = BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.5F, 2.0F);
			final BlockBehaviour.Properties ROD = BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.3F, 0.7F);
			RegistryObject<Block> window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2, plank_four_window, 
			log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window, curtain_rod;
			  
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	window = createBlock(i+"_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab, modLoaded);
				    	window2 = createBlock(i+"_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	four_window = createBlock(i+"_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab, modLoaded);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	plank_window = createBlock(i+"_plank_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD), block, item, tab, modLoaded);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD), block, item, tab, modLoaded);
				    	log_parapet = createBlock(i+"_log_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), block, item, tab, modLoaded);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET), block, item, tab, modLoaded);
				    	blinds = createBlock(i+"_blinds", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Blinds", BLINDS), block, item, tab, modLoaded);
				    	shutter = createBlock(i+"_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), block, item, tab, modLoaded);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER), block, item, tab, modLoaded);
				    	pane_window = createBlock(i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab, modLoaded);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab, modLoaded);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD), block, item, tab, modLoaded);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.CurtainRod", ROD), block, item, tab, modLoaded);
				    }
				    else
				    {
				    	window = createBlock(i+"_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	window2 = createBlock(i+"_window2", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	four_window = createBlock(i+"_four_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedlog_window = createBlock("stripped_"+i+"_log_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedlog_window2 = createBlock("stripped_"+i+"_log_window2", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedlog_four_window = createBlock("stripped_"+i+"_log_four_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_window = createBlock(i+"_plank_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_window2 = createBlock(i+"_plank_window2", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_four_window = createBlock(i+"_plank_four_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	log_parapet = createBlock(i+"_log_parapet", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_parapet = createBlock(i+"_plank_parapet", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	blinds = createBlock(i+"_blinds", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	shutter = createBlock(i+"_shutter", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	louvered_shutter = createBlock(i+"_louvered_shutter", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	pane_window = createBlock(i+"_pane_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	strippedpane_window = createBlock("stripped_"+i+"_pane_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	plank_pane_window = createBlock(i+"_plank_pane_window", () -> new Block(WOOD), block, item, tab, modLoaded);
				    	curtain_rod = createBlock(i+"_curtain_rod", () -> new Block(WOOD), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
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
}