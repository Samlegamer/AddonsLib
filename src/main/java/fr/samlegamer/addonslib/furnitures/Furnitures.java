package fr.samlegamer.addonslib.furnitures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import com.mcwfurnitures.kikoz.objects.Chair;
import com.mcwfurnitures.kikoz.objects.ItemBlock;
import com.mcwfurnitures.kikoz.objects.bookshelves.*;
import com.mcwfurnitures.kikoz.objects.*;
import com.mcwfurnitures.kikoz.objects.cabinets.*;
import com.mcwfurnitures.kikoz.objects.chairs.*;
import com.mcwfurnitures.kikoz.objects.counters.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Furnitures
{
	private static final List<RegistryObject<Block>> FURNITURE_BLOCKS = new ArrayList<>();

	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{				
				RegistryObject<Block> cherry_wardrobe,
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
				
				if(ModList.get().isLoaded("mcwfurnitures"))
				{
					cherry_wardrobe = createBlock(i+"_wardrobe", () -> new TallFurnitureHinge(WOOD), block, item, tab);
					cherry_modern_wardrobe = createBlock(i+"_modern_wardrobe", () -> new TallFurnitureHinge(WOOD), block, item, tab);
					cherry_double_wardrobe = createBlock(i+"_double_wardrobe", () -> new TallFurniture(WOOD), block, item, tab);
					cherry_bookshelf = createBlock(i+"_bookshelf", () -> new BookCabinet(WOOD), block, item, tab);
					cherry_bookshelf_cupboard = createBlock(i+"_bookshelf_cupboard", () -> new BookCabinetHinge(WOOD), block, item, tab);
					cherry_drawer = createBlock(i+"_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					cherry_double_drawer = createBlock(i+"_double_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					cherry_bookshelf_drawer = createBlock(i+"_bookshelf_drawer", () -> new BookDrawer(WOOD), block, item, tab);
					cherry_lower_bookshelf_drawer = createBlock(i+"_lower_bookshelf_drawer", () -> new BookDrawer(WOOD), block, item, tab);
					cherry_large_drawer = createBlock(i+"_large_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					cherry_lower_triple_drawer = createBlock(i+"_lower_triple_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					cherry_triple_drawer = createBlock(i+"_triple_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					cherry_desk = createBlock(i+"_desk", () -> new Desk(WOOD), block, item, tab);
					cherry_covered_desk = createBlock(i+"_covered_desk", () -> new Desk(WOOD), block, item, tab);
					cherry_modern_desk = createBlock(i+"_modern_desk", () -> new Desk(WOOD), block, item, tab);
					cherry_table = createBlock(i+"_table", () -> new TableHitbox(WOOD), block, item, tab);
					cherry_end_table = createBlock(i+"_end_table", () -> new TableHitbox(WOOD), block, item, tab);
					cherry_coffee_table = createBlock(i+"_coffee_table", () -> new Table(WOOD), block, item, tab);
					cherry_glass_table = createBlock(i+"_glass_table", () -> new TableHitbox(WOOD), block, item, tab);
					cherry_chair = createBlock(i+"_chair", () -> new ClassicChair(WOOD), block, item, tab);
					cherry_modern_chair = createBlock(i+"_modern_chair", () -> new ModernChair(WOOD), block, item, tab);
					cherry_striped_chair = createBlock(i+"_striped_chair", () -> new StripedChair(WOOD), block, item, tab);
					cherry_stool_chair = createBlock(i+"_stool_chair", () -> new Chair(WOOD), block, item, tab);
					cherry_counter = createBlock(i+"_counter", () -> new Counter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_drawer_counter = createBlock(i+"_drawer_counter", () -> new StorageCounter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_double_drawer_counter = createBlock(i+"_double_drawer_counter", () -> new StorageCounter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_cupboard_counter = createBlock(i+"_cupboard_counter", () -> new CupboardCounter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_wardrobe = createBlock("stripped_"+i+"__wardrobe", () -> new TallFurnitureHinge(WOOD), block, item, tab);
					stripped_cherry_modern_wardrobe = createBlock("stripped_"+i+"__modern_wardrobe", () -> new TallFurnitureHinge(WOOD), block, item, tab);
					stripped_cherry_double_wardrobe = createBlock("stripped_"+i+"__double_wardrobe", () -> new TallFurniture(WOOD), block, item, tab);
					stripped_cherry_bookshelf = createBlock("stripped_"+i+"__bookshelf", () -> new BookCabinet(WOOD), block, item, tab);
					stripped_cherry_bookshelf_cupboard = createBlock("stripped_"+i+"__bookshelf_cupboard", () -> new BookCabinetHinge(WOOD), block, item, tab);
					stripped_cherry_drawer = createBlock("stripped_"+i+"__drawer", () -> new WideFurniture(WOOD), block, item, tab);
					stripped_cherry_double_drawer = createBlock("stripped_"+i+"__double_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					stripped_cherry_bookshelf_drawer = createBlock("stripped_"+i+"__bookshelf_drawer", () -> new BookDrawer(WOOD), block, item, tab);
					stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_"+i+"__lower_bookshelf_drawer", () -> new BookDrawer(WOOD), block, item, tab);
					stripped_cherry_large_drawer = createBlock("stripped_"+i+"__large_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					stripped_cherry_lower_triple_drawer = createBlock("stripped_"+i+"__lower_triple_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					stripped_cherry_triple_drawer = createBlock("stripped_"+i+"__triple_drawer", () -> new WideFurniture(WOOD), block, item, tab);
					stripped_cherry_desk = createBlock("stripped_"+i+"__desk", () -> new Desk(WOOD), block, item, tab);
					stripped_cherry_covered_desk = createBlock("stripped_"+i+"__covered_desk", () -> new Desk(WOOD), block, item, tab);
					stripped_cherry_modern_desk = createBlock("stripped_"+i+"__modern_desk", () -> new Desk(WOOD), block, item, tab);
					stripped_cherry_table = createBlock("stripped_"+i+"__table", () -> new TableHitbox(WOOD), block, item, tab);
					stripped_cherry_end_table = createBlock("stripped_"+i+"__end_table", () -> new TableHitbox(WOOD), block, item, tab);
					stripped_cherry_coffee_table = createBlock("stripped_"+i+"__coffee_table", () -> new Table(WOOD), block, item, tab);
					stripped_cherry_glass_table = createBlock("stripped_"+i+"__glass_table", () -> new TableHitbox(WOOD), block, item, tab);
					stripped_cherry_chair = createBlock("stripped_"+i+"__chair", () -> new ClassicChair(WOOD), block, item, tab);
					stripped_cherry_modern_chair = createBlock("stripped_"+i+"__modern_chair", () -> new ModernChair(WOOD), block, item, tab);
					stripped_cherry_striped_chair = createBlock("stripped_"+i+"__striped_chair", () -> new StripedChair(WOOD), block, item, tab);
					stripped_cherry_stool_chair = createBlock("stripped_"+i+"__stool_chair", () -> new Chair(WOOD), block, item, tab);
					stripped_cherry_counter = createBlock("stripped_"+i+"__counter", () -> new Counter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_drawer_counter = createBlock("stripped_"+i+"__drawer_counter", () -> new StorageCounter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_double_drawer_counter = createBlock("stripped_"+i+"__double_drawer_counter", () -> new StorageCounter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_cupboard_counter = createBlock("stripped_"+i+"__cupboard_counter", () -> new CupboardCounter(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_kitchen_cabinet = createBlock(i+"_kitchen_cabinet", () -> new CabinetHinge(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_double_kitchen_cabinet = createBlock(i+"_double_kitchen_cabinet", () -> new Cabinet(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_glass_kitchen_cabinet = createBlock(i+"_glass_kitchen_cabinet", () -> new Cabinet(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_kitchen_cabinet = createBlock("stripped_"+i+"__kitchen_cabinet", () -> new CabinetHinge(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_double_kitchen_cabinet = createBlock("stripped_"+i+"__double_kitchen_cabinet", () -> new Cabinet(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_"+i+"__glass_kitchen_cabinet", () -> new Cabinet(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
				}
				else
				{
					cherry_wardrobe = createBlock(i+"_wardrobe", () -> new Block(WOOD), block, item, tab);
					cherry_modern_wardrobe = createBlock(i+"_modern_wardrobe", () -> new Block(WOOD), block, item, tab);
					cherry_double_wardrobe = createBlock(i+"_double_wardrobe", () -> new Block(WOOD), block, item, tab);
					cherry_bookshelf = createBlock(i+"_bookshelf", () -> new Block(WOOD), block, item, tab);
					cherry_bookshelf_cupboard = createBlock(i+"_bookshelf_cupboard", () -> new Block(WOOD), block, item, tab);
					cherry_drawer = createBlock(i+"_drawer", () -> new Block(WOOD), block, item, tab);
					cherry_double_drawer = createBlock(i+"_double_drawer", () -> new Block(WOOD), block, item, tab);
					cherry_bookshelf_drawer = createBlock(i+"_bookshelf_drawer", () -> new Block(WOOD), block, item, tab);
					cherry_lower_bookshelf_drawer = createBlock(i+"_lower_bookshelf_drawer", () -> new Block(WOOD), block, item, tab);
					cherry_large_drawer = createBlock(i+"_large_drawer", () -> new Block(WOOD), block, item, tab);
					cherry_lower_triple_drawer = createBlock(i+"_lower_triple_drawer", () -> new Block(WOOD), block, item, tab);
					cherry_triple_drawer = createBlock(i+"_triple_drawer", () -> new Block(WOOD), block, item, tab);
					cherry_desk = createBlock(i+"_desk", () -> new Block(WOOD), block, item, tab);
					cherry_covered_desk = createBlock(i+"_covered_desk", () -> new Block(WOOD), block, item, tab);
					cherry_modern_desk = createBlock(i+"_modern_desk", () -> new Block(WOOD), block, item, tab);
					cherry_table = createBlock(i+"_table", () -> new Block(WOOD), block, item, tab);
					cherry_end_table = createBlock(i+"_end_table", () -> new Block(WOOD), block, item, tab);
					cherry_coffee_table = createBlock(i+"_coffee_table", () -> new Block(WOOD), block, item, tab);
					cherry_glass_table = createBlock(i+"_glass_table", () -> new Block(WOOD), block, item, tab);
					cherry_chair = createBlock(i+"_chair", () -> new Block(WOOD), block, item, tab);
					cherry_modern_chair = createBlock(i+"_modern_chair", () -> new Block(WOOD), block, item, tab);
					cherry_striped_chair = createBlock(i+"_striped_chair", () -> new Block(WOOD), block, item, tab);
					cherry_stool_chair = createBlock(i+"_stool_chair", () -> new Block(WOOD), block, item, tab);
					cherry_counter = createBlock(i+"_counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_drawer_counter = createBlock(i+"_drawer_counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_double_drawer_counter = createBlock(i+"_double_drawer_counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_cupboard_counter = createBlock(i+"_cupboard_counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_wardrobe = createBlock("stripped_"+i+"__wardrobe", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_modern_wardrobe = createBlock("stripped_"+i+"__modern_wardrobe", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_double_wardrobe = createBlock("stripped_"+i+"__double_wardrobe", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_bookshelf = createBlock("stripped_"+i+"__bookshelf", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_bookshelf_cupboard = createBlock("stripped_"+i+"__bookshelf_cupboard", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_drawer = createBlock("stripped_"+i+"__drawer", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_double_drawer = createBlock("stripped_"+i+"__double_drawer", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_bookshelf_drawer = createBlock("stripped_"+i+"__bookshelf_drawer", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_lower_bookshelf_drawer = createBlock("stripped_"+i+"__lower_bookshelf_drawer", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_large_drawer = createBlock("stripped_"+i+"__large_drawer", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_lower_triple_drawer = createBlock("stripped_"+i+"__lower_triple_drawer", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_triple_drawer = createBlock("stripped_"+i+"__triple_drawer", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_desk = createBlock("stripped_"+i+"__desk", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_covered_desk = createBlock("stripped_"+i+"__covered_desk", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_modern_desk = createBlock("stripped_"+i+"__modern_desk", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_table = createBlock("stripped_"+i+"__table", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_end_table = createBlock("stripped_"+i+"__end_table", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_coffee_table = createBlock("stripped_"+i+"__coffee_table", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_glass_table = createBlock("stripped_"+i+"__glass_table", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_chair = createBlock("stripped_"+i+"__chair", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_modern_chair = createBlock("stripped_"+i+"__modern_chair", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_striped_chair = createBlock("stripped_"+i+"__striped_chair", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_stool_chair = createBlock("stripped_"+i+"__stool_chair", () -> new Block(WOOD), block, item, tab);
					stripped_cherry_counter = createBlock("stripped_"+i+"__counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_drawer_counter = createBlock("stripped_"+i+"__drawer_counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_double_drawer_counter = createBlock("stripped_"+i+"__double_drawer_counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_cupboard_counter = createBlock("stripped_"+i+"__cupboard_counter", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_kitchen_cabinet = createBlock(i+"_kitchen_cabinet", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_double_kitchen_cabinet = createBlock(i+"_double_kitchen_cabinet", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					cherry_glass_kitchen_cabinet = createBlock(i+"_glass_kitchen_cabinet", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_kitchen_cabinet = createBlock("stripped_"+i+"__kitchen_cabinet", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_double_kitchen_cabinet = createBlock("stripped_"+i+"__double_kitchen_cabinet", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
					stripped_cherry_glass_kitchen_cabinet = createBlock("stripped_"+i+"__glass_kitchen_cabinet", () -> new StairsBlock(Blocks.OAK_LOG.defaultBlockState(), WOOD), block, item, tab);
				}
				
				FURNITURE_BLOCKS.add(cherry_wardrobe);
				FURNITURE_BLOCKS.add(cherry_modern_wardrobe);
				FURNITURE_BLOCKS.add(cherry_double_wardrobe);
				FURNITURE_BLOCKS.add(cherry_bookshelf);
				FURNITURE_BLOCKS.add(cherry_bookshelf_cupboard);
				FURNITURE_BLOCKS.add(cherry_drawer);
				FURNITURE_BLOCKS.add(cherry_double_drawer);
				FURNITURE_BLOCKS.add(cherry_bookshelf_drawer);
				FURNITURE_BLOCKS.add(cherry_lower_bookshelf_drawer);
				FURNITURE_BLOCKS.add(cherry_large_drawer);
				FURNITURE_BLOCKS.add(cherry_lower_triple_drawer);
				FURNITURE_BLOCKS.add(cherry_triple_drawer);
				FURNITURE_BLOCKS.add(cherry_desk);
				FURNITURE_BLOCKS.add(cherry_covered_desk);
				FURNITURE_BLOCKS.add(cherry_modern_desk);
				FURNITURE_BLOCKS.add(cherry_table);
				FURNITURE_BLOCKS.add(cherry_end_table);
				FURNITURE_BLOCKS.add(cherry_coffee_table);
				FURNITURE_BLOCKS.add(cherry_glass_table);
				FURNITURE_BLOCKS.add(cherry_chair);
				FURNITURE_BLOCKS.add(cherry_modern_chair);
				FURNITURE_BLOCKS.add(cherry_striped_chair);
				FURNITURE_BLOCKS.add(cherry_stool_chair);
				FURNITURE_BLOCKS.add(cherry_counter);
				FURNITURE_BLOCKS.add(cherry_drawer_counter);
				FURNITURE_BLOCKS.add(cherry_double_drawer_counter);
				FURNITURE_BLOCKS.add(cherry_cupboard_counter);
				FURNITURE_BLOCKS.add(stripped_cherry_wardrobe);
				FURNITURE_BLOCKS.add(stripped_cherry_modern_wardrobe);
				FURNITURE_BLOCKS.add(stripped_cherry_double_wardrobe);
				FURNITURE_BLOCKS.add(stripped_cherry_bookshelf);
				FURNITURE_BLOCKS.add(stripped_cherry_bookshelf_cupboard);
				FURNITURE_BLOCKS.add(stripped_cherry_drawer);
				FURNITURE_BLOCKS.add(stripped_cherry_double_drawer);
				FURNITURE_BLOCKS.add(stripped_cherry_bookshelf_drawer);
				FURNITURE_BLOCKS.add(stripped_cherry_lower_bookshelf_drawer);
				FURNITURE_BLOCKS.add(stripped_cherry_large_drawer);
				FURNITURE_BLOCKS.add(stripped_cherry_lower_triple_drawer);
				FURNITURE_BLOCKS.add(stripped_cherry_triple_drawer);
				FURNITURE_BLOCKS.add(stripped_cherry_desk);
				FURNITURE_BLOCKS.add(stripped_cherry_covered_desk);
				FURNITURE_BLOCKS.add(stripped_cherry_modern_desk);
				FURNITURE_BLOCKS.add(stripped_cherry_table);
				FURNITURE_BLOCKS.add(stripped_cherry_end_table);
				FURNITURE_BLOCKS.add(stripped_cherry_coffee_table);
				FURNITURE_BLOCKS.add(stripped_cherry_glass_table);
				FURNITURE_BLOCKS.add(stripped_cherry_chair);
				FURNITURE_BLOCKS.add(stripped_cherry_modern_chair);
				FURNITURE_BLOCKS.add(stripped_cherry_striped_chair);
				FURNITURE_BLOCKS.add(stripped_cherry_stool_chair);
				FURNITURE_BLOCKS.add(stripped_cherry_counter);
				FURNITURE_BLOCKS.add(stripped_cherry_drawer_counter);
				FURNITURE_BLOCKS.add(stripped_cherry_double_drawer_counter);
				FURNITURE_BLOCKS.add(stripped_cherry_cupboard_counter);
				FURNITURE_BLOCKS.add(cherry_kitchen_cabinet);
				FURNITURE_BLOCKS.add(cherry_double_kitchen_cabinet);
				FURNITURE_BLOCKS.add(cherry_glass_kitchen_cabinet);
				FURNITURE_BLOCKS.add(stripped_cherry_kitchen_cabinet);
				FURNITURE_BLOCKS.add(stripped_cherry_double_kitchen_cabinet);
				FURNITURE_BLOCKS.add(stripped_cherry_glass_kitchen_cabinet);
			}
	}
	
	public static List<RegistryObject<Block>> getFurnitureBlocks() {
		return FURNITURE_BLOCKS;
	}
	
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : FURNITURE_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded("mcwfurnitures"))
		{
			ITEMS_REGISTRY.register(name, () -> new ItemBlock(block.get(), new Item.Properties().tab(tab)));
		}
        return block;
    }
}