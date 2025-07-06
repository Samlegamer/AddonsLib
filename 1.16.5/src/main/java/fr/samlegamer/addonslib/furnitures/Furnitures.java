package fr.samlegamer.addonslib.furnitures;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.CreateBlockReferences;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Furnitures
{
	public static final String modid = "mcwfurnitures";
	/**
	 * Init all Wood Variants of Macaw's Furnitures
	 */
	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(set, block, item, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Furnitures with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab, String modLoaded)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModMcwLoaded = ModList.get().isLoaded(modid);
		boolean isModBaseLoaded = ModList.get().isLoaded(modLoaded);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FURNITURES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModMcwLoaded) {
					if(blockId.reflectedLocation().contains("StorageCounter") ||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet")||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.counters.Counter")||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.counters.CupboardCounter")||
							blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge")) {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), block, item, tab, true, isModBaseLoaded);
					}
					else {
						CreateBlockReferences.createBlock(id, () -> Registration.getBlocksField(blockId.reflectedLocation(), WOOD), block, item, tab, true, isModBaseLoaded);
					}
				}
				else {
					CreateBlockReferences.createBlock(id, () -> new Block(WOOD), block, item, tab, false, isModBaseLoaded);
				}
			}
		}
	}
	
	public static void registryWood(final RegistryEvent.Register<Block> event, String Modid, List<String> set, ItemGroup tab)
	{
		final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

		boolean isModLoaded = ModList.get().isLoaded(modid);

		for (String i : set) {
			for (BlockId blockId : McwBlocksIdBase.FURNITURES_WOOD_BLOCKS.blocks()) {
				String id = McwBlocksIdBase.replacement(blockId.id(), i);

				if(isModLoaded) {
					if(blockId.reflectedLocation().contains("StorageCounter") || blockId.reflectedLocation().equals("com.mcwfurnitures.kikoz.objects.cabinets.Cabinet")) {
						CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD, Blocks.OAK_PLANKS.defaultBlockState()), tab, true);
					}
					else {
						CreateBlockReferences.createBlockWoodOpti(Modid, id, Registration.getBlocksField(blockId.reflectedLocation(), WOOD), tab, true);
					}
				}
				else {
					CreateBlockReferences.createBlockWoodOpti(Modid, id, new Block(WOOD), tab, false);
				}
			}
		}
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
	{
		clientWood(event, MODID, WOOD, RenderType.cutout());
	}

	@Deprecated
	public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
	{
		Block cherry_wardrobe,
		cherry_modern_wardrobe,
		cherry_double_wardrobe,
		cherry_bookshelf,
		cherry_bookshelf_cupboard,
		cherry_drawer,
		cherry_double_drawer,
		cherry_bookshelf_drawer,
		cherry_lower_bookshelf_drawer,
		cherry_large_drawer,
		cherry_lower_triple_drawer,
		cherry_triple_drawer,
		cherry_desk,
		cherry_covered_desk,
		cherry_modern_desk,
		cherry_table,
		cherry_end_table,
		cherry_coffee_table,
		cherry_glass_table,
		cherry_chair,
		cherry_modern_chair,
		cherry_striped_chair,
		cherry_stool_chair,
		cherry_counter,
		cherry_drawer_counter,
		cherry_double_drawer_counter,
		cherry_cupboard_counter,
		stripped_cherry_wardrobe,
		stripped_cherry_modern_wardrobe,
		stripped_cherry_double_wardrobe,
		stripped_cherry_bookshelf,
		stripped_cherry_bookshelf_cupboard,
		stripped_cherry_drawer,
		stripped_cherry_double_drawer,
		stripped_cherry_bookshelf_drawer,
		stripped_cherry_lower_bookshelf_drawer,
		stripped_cherry_large_drawer,
		stripped_cherry_lower_triple_drawer,
		stripped_cherry_triple_drawer,
		stripped_cherry_desk,
		stripped_cherry_covered_desk,
		stripped_cherry_modern_desk,
		stripped_cherry_table,
		stripped_cherry_end_table,
		stripped_cherry_coffee_table,
		stripped_cherry_glass_table,
		stripped_cherry_chair,
		stripped_cherry_modern_chair,
		stripped_cherry_striped_chair,
		stripped_cherry_stool_chair,
		stripped_cherry_counter,
		stripped_cherry_drawer_counter,
		stripped_cherry_double_drawer_counter,
		stripped_cherry_cupboard_counter,
		cherry_kitchen_cabinet,
		cherry_double_kitchen_cabinet,
		cherry_glass_kitchen_cabinet,
		stripped_cherry_kitchen_cabinet,
		stripped_cherry_double_kitchen_cabinet,
		stripped_cherry_glass_kitchen_cabinet;
		
		for (String i : WOOD)
		{
			cherry_wardrobe = Finder.findBlock(MODID, i+"_wardrobe");
			cherry_modern_wardrobe = Finder.findBlock(MODID, i+"_modern_wardrobe");
			cherry_double_wardrobe = Finder.findBlock(MODID, i+"_double_wardrobe");
			cherry_bookshelf = Finder.findBlock(MODID, i+"_bookshelf");
			cherry_bookshelf_cupboard = Finder.findBlock(MODID, i+"_bookshelf_cupboard");
			cherry_drawer = Finder.findBlock(MODID, i+"_drawer");
			cherry_double_drawer = Finder.findBlock(MODID, i+"_double_drawer");
			cherry_bookshelf_drawer = Finder.findBlock(MODID, i+"_bookshelf_drawer");
			cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, i+"_lower_bookshelf_drawer");
			cherry_large_drawer = Finder.findBlock(MODID, i+"_large_drawer");
			cherry_lower_triple_drawer = Finder.findBlock(MODID, i+"_lower_triple_drawer");
			cherry_triple_drawer = Finder.findBlock(MODID, i+"_triple_drawer");
			cherry_desk = Finder.findBlock(MODID, i+"_desk");
			cherry_covered_desk = Finder.findBlock(MODID, i+"_covered_desk");
			cherry_modern_desk = Finder.findBlock(MODID, i+"_modern_desk");
			cherry_table = Finder.findBlock(MODID, i+"_table");
			cherry_end_table = Finder.findBlock(MODID, i+"_end_table");
			cherry_coffee_table = Finder.findBlock(MODID, i+"_coffee_table");
			cherry_glass_table = Finder.findBlock(MODID, i+"_glass_table");
			cherry_chair = Finder.findBlock(MODID, i+"_chair");
			cherry_modern_chair = Finder.findBlock(MODID, i+"_modern_chair");
			cherry_striped_chair = Finder.findBlock(MODID, i+"_striped_chair");
			cherry_stool_chair = Finder.findBlock(MODID, i+"_stool_chair");
			cherry_counter = Finder.findBlock(MODID, i+"_counter");
			cherry_drawer_counter = Finder.findBlock(MODID, i+"_drawer_counter");
			cherry_double_drawer_counter = Finder.findBlock(MODID, i+"_double_drawer_counter");
			cherry_cupboard_counter = Finder.findBlock(MODID, i+"_cupboard_counter");
			cherry_kitchen_cabinet = Finder.findBlock(MODID, i+"_kitchen_cabinet");
			cherry_double_kitchen_cabinet = Finder.findBlock(MODID, i+"_double_kitchen_cabinet");
			cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, i+"_glass_kitchen_cabinet");

        	RenderTypeLookup.setRenderLayer(cherry_wardrobe, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_modern_wardrobe, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_double_wardrobe, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_bookshelf, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_bookshelf_cupboard, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_double_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_bookshelf_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_lower_bookshelf_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_large_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_lower_triple_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_triple_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_desk, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_covered_desk, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_modern_desk, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_table, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_end_table, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_coffee_table, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_glass_table, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_modern_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_striped_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_stool_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_drawer_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_double_drawer_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_cupboard_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_kitchen_cabinet, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_double_kitchen_cabinet, renderSet);
        	RenderTypeLookup.setRenderLayer(cherry_glass_kitchen_cabinet, renderSet);
        	
        	stripped_cherry_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_wardrobe");
			stripped_cherry_modern_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_modern_wardrobe");
			stripped_cherry_double_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_double_wardrobe");
			stripped_cherry_bookshelf = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf");
			stripped_cherry_bookshelf_cupboard = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_cupboard");
			stripped_cherry_drawer = Finder.findBlock(MODID, "stripped_"+i+"_drawer");
			stripped_cherry_double_drawer = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer");
			stripped_cherry_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_drawer");
			stripped_cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_bookshelf_drawer");
			stripped_cherry_large_drawer = Finder.findBlock(MODID, "stripped_"+i+"_large_drawer");
			stripped_cherry_lower_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_triple_drawer");
			stripped_cherry_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_triple_drawer");
			stripped_cherry_desk = Finder.findBlock(MODID, "stripped_"+i+"_desk");
			stripped_cherry_covered_desk = Finder.findBlock(MODID, "stripped_"+i+"_covered_desk");
			stripped_cherry_modern_desk = Finder.findBlock(MODID, "stripped_"+i+"_modern_desk");
			stripped_cherry_table = Finder.findBlock(MODID, "stripped_"+i+"_table");
			stripped_cherry_end_table = Finder.findBlock(MODID, "stripped_"+i+"_end_table");
			stripped_cherry_coffee_table = Finder.findBlock(MODID, "stripped_"+i+"_coffee_table");
			stripped_cherry_glass_table = Finder.findBlock(MODID, "stripped_"+i+"_glass_table");
			stripped_cherry_chair = Finder.findBlock(MODID, "stripped_"+i+"_chair");
			stripped_cherry_modern_chair = Finder.findBlock(MODID, "stripped_"+i+"_modern_chair");
			stripped_cherry_striped_chair = Finder.findBlock(MODID, "stripped_"+i+"_striped_chair");
			stripped_cherry_stool_chair = Finder.findBlock(MODID, "stripped_"+i+"_stool_chair");
			stripped_cherry_counter = Finder.findBlock(MODID, "stripped_"+i+"_counter");
			stripped_cherry_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_drawer_counter");
			stripped_cherry_double_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer_counter");
			stripped_cherry_cupboard_counter = Finder.findBlock(MODID, "stripped_"+i+"_cupboard_counter");
			stripped_cherry_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_kitchen_cabinet");
			stripped_cherry_double_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_double_kitchen_cabinet");
			stripped_cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_glass_kitchen_cabinet");
        	
			RenderTypeLookup.setRenderLayer(stripped_cherry_wardrobe, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_modern_wardrobe, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_double_wardrobe, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_bookshelf, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_bookshelf_cupboard, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_double_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_bookshelf_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_lower_bookshelf_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_large_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_lower_triple_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_triple_drawer, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_desk, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_covered_desk, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_modern_desk, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_table, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_end_table, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_coffee_table, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_glass_table, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_modern_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_striped_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_stool_chair, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_drawer_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_double_drawer_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_cupboard_counter, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_kitchen_cabinet, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_double_kitchen_cabinet, renderSet);
        	RenderTypeLookup.setRenderLayer(stripped_cherry_glass_kitchen_cabinet, renderSet);
        }
	}
}