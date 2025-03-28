package fr.samlegamer.addonslib.windows;

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
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Windows
{
	private static final String modid = "mcwwindows";
	/**
	 * Init all Wood Variants of Macaw's Windows
	 */
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Windows with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded)
	{
			final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.6F, 1.2F);
			final BlockBehaviour.Properties PARAPET = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.2F, 1.0F);
			final BlockBehaviour.Properties BLINDS = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.3F, 1.0F);
			final BlockBehaviour.Properties SHUTTER = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.5F, 2.0F);
			final BlockBehaviour.Properties ROD = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.3F, 0.7F);
			RegistryObject<Block> window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2, plank_four_window, 
			log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window, curtain_rod;
			  
			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
				    	window = createBlock(mod, i+"_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_window")))), block, item, tab, modLoaded);
				    	window2 = createBlock(mod, i+"_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_window2")))), block, item, tab, modLoaded);
				    	four_window = createBlock(mod, i+"_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_four_window")))), block, item, tab, modLoaded);
				    	strippedlog_window = createBlock(mod, "stripped_"+i+"_log_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_log_window")))), block, item, tab, modLoaded);
				    	strippedlog_window2 = createBlock(mod, "stripped_"+i+"_log_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_log_window2")))), block, item, tab, modLoaded);
				    	strippedlog_four_window = createBlock(mod, "stripped_"+i+"_log_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_log_four_window")))), block, item, tab, modLoaded);
				    	plank_window = createBlock(mod, i+"_plank_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.ConnectedWindow", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_window")))), block, item, tab, modLoaded);
				    	plank_window2 = createBlock(mod, i+"_plank_window2", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_window2")))), block, item, tab, modLoaded);
				    	plank_four_window = createBlock(mod, i+"_plank_four_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.WindowBarred", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_four_window")))), block, item, tab, modLoaded);
				    	log_parapet = createBlock(mod, i+"_log_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_log_parapet")))), block, item, tab, modLoaded);
				    	plank_parapet = createBlock(mod, i+"_plank_parapet", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Parapet", PARAPET.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_parapet")))), block, item, tab, modLoaded);
				    	blinds = createBlock(mod, i+"_blinds", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Blinds", BLINDS.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_blinds")))), block, item, tab, modLoaded);
				    	shutter = createBlock(mod, i+"_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_shutter")))), block, item, tab, modLoaded);
				    	louvered_shutter = createBlock(mod, i+"_louvered_shutter", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Shutter", SHUTTER.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_louvered_shutter")))), block, item, tab, modLoaded);
				    	pane_window = createBlock(mod, i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_pane_window")))), block, item, tab, modLoaded);
				    	strippedpane_window = createBlock(mod, "stripped_"+i+"_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_pane_window")))), block, item, tab, modLoaded);
				    	plank_pane_window = createBlock(mod, i+"_plank_pane_window", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.Window", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_pane_window")))), block, item, tab, modLoaded);
				    	curtain_rod = createBlock(mod, i+"_curtain_rod", () -> Registration.getBlocksField("com.mcwwindows.kikoz.objects.CurtainRod", ROD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_curtain_rod")))), block, item, tab, modLoaded);
				    }
				    else
				    {
				    	window = createBlock(mod, i+"_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_window")))), block, item, tab, modLoaded);
				    	window2 = createBlock(mod, i+"_window2", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_window2")))), block, item, tab, modLoaded);
				    	four_window = createBlock(mod, i+"_four_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_four_window")))), block, item, tab, modLoaded);
				    	strippedlog_window = createBlock(mod, "stripped_"+i+"_log_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_log_window")))), block, item, tab, modLoaded);
				    	strippedlog_window2 = createBlock(mod, "stripped_"+i+"_log_window2", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_log_window2")))), block, item, tab, modLoaded);
				    	strippedlog_four_window = createBlock(mod, "stripped_"+i+"_log_four_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_log_four_window")))), block, item, tab, modLoaded);
				    	plank_window = createBlock(mod, i+"_plank_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_window")))), block, item, tab, modLoaded);
				    	plank_window2 = createBlock(mod, i+"_plank_window2", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_window2")))), block, item, tab, modLoaded);
				    	plank_four_window = createBlock(mod, i+"_plank_four_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_four_window")))), block, item, tab, modLoaded);
				    	log_parapet = createBlock(mod, i+"_log_parapet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_log_parapet")))), block, item, tab, modLoaded);
				    	plank_parapet = createBlock(mod, i+"_plank_parapet", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_parapet")))), block, item, tab, modLoaded);
				    	blinds = createBlock(mod, i+"_blinds", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_blinds")))), block, item, tab, modLoaded);
				    	shutter = createBlock(mod, i+"_shutter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_shutter")))), block, item, tab, modLoaded);
				    	louvered_shutter = createBlock(mod, i+"_louvered_shutter", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_louvered_shutter")))), block, item, tab, modLoaded);
				    	pane_window = createBlock(mod, i+"_pane_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_pane_window")))), block, item, tab, modLoaded);
				    	strippedpane_window = createBlock(mod, "stripped_"+i+"_pane_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, "stripped_"+i+"_pane_window")))), block, item, tab, modLoaded);
				    	plank_pane_window = createBlock(mod, i+"_plank_pane_window", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_plank_pane_window")))), block, item, tab, modLoaded);
				    	curtain_rod = createBlock(mod, i+"_curtain_rod", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_curtain_rod")))), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}

	protected static RegistryObject<Block> createBlock(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
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
		Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2,
		plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window,
		curtain_rod;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : WOOD)
			{
		    	window = Finder.findBlock(MODID, i+"_window");
		    	window2 = Finder.findBlock(MODID, i+"_window2");
		    	four_window = Finder.findBlock(MODID, i+"_four_window");
		    	strippedlog_window = Finder.findBlock(MODID, "stripped_"+i+"_log_window");
		    	strippedlog_window2 = Finder.findBlock(MODID, "stripped_"+i+"_log_window2");
		    	strippedlog_four_window = Finder.findBlock(MODID, "stripped_"+i+"_log_four_window");
		    	plank_window = Finder.findBlock(MODID, i+"_plank_window");
		    	plank_window2 = Finder.findBlock(MODID, i+"_plank_window2");
		    	plank_four_window = Finder.findBlock(MODID, i+"_plank_four_window");
		    	log_parapet = Finder.findBlock(MODID, i+"_log_parapet");
		    	plank_parapet = Finder.findBlock(MODID, i+"_plank_parapet");
		    	blinds = Finder.findBlock(MODID, i+"_blinds");
		    	shutter = Finder.findBlock(MODID, i+"_shutter");
		    	louvered_shutter = Finder.findBlock(MODID, i+"_louvered_shutter");
		    	pane_window = Finder.findBlock(MODID, i+"_pane_window");
		    	strippedpane_window = Finder.findBlock(MODID, "stripped_"+i+"_pane_window");
		    	plank_pane_window = Finder.findBlock(MODID, i+"_plank_pane_window");
		    	curtain_rod = Finder.findBlock(MODID, i+"_curtain_rod");
		    	
		    	event.accept(window);
		    	event.accept(window2);
		    	event.accept(four_window);
		    	event.accept(strippedlog_window);
		    	event.accept(strippedlog_window2);
		    	event.accept(strippedlog_four_window);
		    	event.accept(plank_window);
		    	event.accept(plank_window2);
		    	event.accept(plank_four_window);
		    	event.accept(log_parapet);
		    	event.accept(plank_parapet);
		    	event.accept(blinds);
		    	event.accept(shutter);
		    	event.accept(louvered_shutter);
		    	event.accept(pane_window);
		    	event.accept(strippedpane_window);
		    	event.accept(plank_pane_window);
		    	event.accept(curtain_rod);
			}
		}
	}
}