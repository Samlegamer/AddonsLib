package fr.samlegamer.addonslib.roofs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import com.mcwroofs.kikoz.objects.roofs.*;
import com.mcwroofs.kikoz.util.FuelItemBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;

public class Roofs
{
	private static final List<RegistryObject<Block>> ROOF_BLOCKS = new ArrayList<>();

	public static void setRegistrationWood(List<String> set, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties WOOD = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);

			for(String i : set)
			{
			    RegistryObject<Block> cherry_roof,
				cherry_attic_roof,
				cherry_top_roof,
				cherry_lower_roof,
				cherry_steep_roof,
				cherry_upper_lower_roof,
				cherry_upper_steep_roof,
				cherry_planks_roof,
				cherry_planks_attic_roof,
				cherry_planks_top_roof,
				cherry_planks_lower_roof,
				cherry_planks_steep_roof,
				cherry_planks_upper_lower_roof,
				cherry_planks_upper_steep_roof;
			    
				if(ModList.get().isLoaded("mcwroofs"))
				{
				    cherry_roof = createBlock(i+"_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_attic_roof = createBlock(i+"_attic_roof", () -> new RoofGlass(WOOD), block, item, tab);
				    cherry_top_roof = createBlock(i+"_top_roof", () -> new RoofTopNew(WOOD), block, item, tab);
				    cherry_lower_roof = createBlock(i+"_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_steep_roof = createBlock(i+"_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_upper_lower_roof = createBlock(i+"_upper_lower_roof", () -> new Lower(Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_upper_steep_roof = createBlock(i+"_upper_steep_roof", () -> new Steep(Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);

				    cherry_planks_roof = createBlock(i+"_planks_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_planks_attic_roof = createBlock(i+"_planks_attic_roof", () -> new RoofGlass(WOOD), block, item, tab);
				    cherry_planks_top_roof = createBlock(i+"_planks_top_roof", () -> new RoofTopNew(WOOD), block, item, tab);
				    cherry_planks_lower_roof = createBlock(i+"_planks_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_planks_steep_roof = createBlock(i+"_planks_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_planks_upper_lower_roof = createBlock(i+"_planks_upper_lower_roof", () -> new Lower(Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item, tab);
				    cherry_planks_upper_steep_roof = createBlock(i+"_planks_upper_steep_roof", () -> new Steep(Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item, tab);

				}
				else
				{
				    cherry_roof = createBlock(i+"_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_attic_roof = createBlock(i+"_attic_roof", () -> new Block(WOOD), block, item, tab);
				    cherry_top_roof = createBlock(i+"_top_roof", () -> new Block(WOOD), block, item, tab);
				    cherry_lower_roof = createBlock(i+"_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_steep_roof = createBlock(i+"_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_upper_lower_roof = createBlock(i+"_upper_lower_roof", () -> new StairsBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_upper_steep_roof = createBlock(i+"_upper_steep_roof", () -> new StairsBlock(Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);

				    cherry_planks_roof = createBlock(i+"_planks_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_planks_attic_roof = createBlock(i+"_planks_attic_roof", () -> new Block(WOOD), block, item, tab);
				    cherry_planks_top_roof = createBlock(i+"_planks_top_roof", () -> new Block(WOOD), block, item, tab);
				    cherry_planks_lower_roof = createBlock(i+"_planks_lower_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_planks_steep_roof = createBlock(i+"_planks_steep_roof", () -> new StairsBlock(()->Blocks.OAK_PLANKS.defaultBlockState(), WOOD), block, item, tab);
				    cherry_planks_upper_lower_roof = createBlock(i+"_planks_upper_lower_roof", () -> new StairsBlock(Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item, tab);
				    cherry_planks_upper_steep_roof = createBlock(i+"_planks_upper_steep_roof", () -> new StairsBlock(Blocks.OAK_PLANKS.defaultBlockState() ,WOOD), block, item, tab);
				}

				ROOF_BLOCKS.add(cherry_roof);
				ROOF_BLOCKS.add(cherry_attic_roof);
				ROOF_BLOCKS.add(cherry_top_roof);
				ROOF_BLOCKS.add(cherry_lower_roof);
				ROOF_BLOCKS.add(cherry_steep_roof);
				ROOF_BLOCKS.add(cherry_upper_lower_roof);
				ROOF_BLOCKS.add(cherry_upper_steep_roof);
				ROOF_BLOCKS.add(cherry_planks_roof);
				ROOF_BLOCKS.add(cherry_planks_attic_roof);
				ROOF_BLOCKS.add(cherry_planks_top_roof);
				ROOF_BLOCKS.add(cherry_planks_lower_roof);
				ROOF_BLOCKS.add(cherry_planks_steep_roof);
				ROOF_BLOCKS.add(cherry_planks_upper_lower_roof);
				ROOF_BLOCKS.add(cherry_planks_upper_steep_roof);
			}
	}
	
	public static void setRegistrationRock(List<String> rock, DeferredRegister<Block> block, DeferredRegister<Item> item, ItemGroup tab)
	{
			final AbstractBlock.Properties STONE = AbstractBlock.Properties.copy(Blocks.CUT_SANDSTONE);

			for(String i : rock)
			{
				RegistryObject<Block> ROOF,
				ATTIC_ROOF,
				TOP_ROOF,
				LOWER_ROOF,
				STEEP_ROOF,
				UPPER_LOWER_ROOF,
				UPPER_STEEP_ROOF;

				if(ModList.get().isLoaded("mcwroofs"))
				{
					ROOF = createBlockStone(i+"_roof", () -> new BaseRoof(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					ATTIC_ROOF = createBlockStone(i+"_attic_roof", () -> new RoofGlass(STONE), block, item, tab);
					TOP_ROOF = createBlockStone(i+"_top_roof", () -> new RoofTopNew(STONE), block, item, tab);
					LOWER_ROOF = createBlockStone(i+"_lower_roof", () -> new BaseRoof(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					STEEP_ROOF = createBlockStone(i+"_steep_roof", () -> new SteepRoof(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					UPPER_LOWER_ROOF = createBlockStone(i+"_upper_lower_roof", () -> new Lower(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					UPPER_STEEP_ROOF = createBlockStone(i+"_upper_steep_roof", () -> new Steep(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
				}
				else
				{
					ROOF = createBlockStone(i+"_roof", () -> new StairsBlock(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					ATTIC_ROOF = createBlockStone(i+"_attic_roof", () -> new Block(STONE), block, item, tab);
					TOP_ROOF = createBlockStone(i+"_top_roof", () -> new Block(STONE), block, item, tab);
					LOWER_ROOF = createBlockStone(i+"_lower_roof", () -> new StairsBlock(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					STEEP_ROOF = createBlockStone(i+"_steep_roof", () -> new StairsBlock(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					UPPER_LOWER_ROOF = createBlockStone(i+"_upper_lower_roof", () -> new StairsBlock(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
					UPPER_STEEP_ROOF = createBlockStone(i+"_upper_steep_roof", () -> new StairsBlock(Blocks.TERRACOTTA.defaultBlockState(), STONE), block, item, tab);
				}
				ROOF_BLOCKS.add(ROOF);
				ROOF_BLOCKS.add(ATTIC_ROOF);
				ROOF_BLOCKS.add(TOP_ROOF);
				ROOF_BLOCKS.add(LOWER_ROOF);
				ROOF_BLOCKS.add(STEEP_ROOF);
				ROOF_BLOCKS.add(UPPER_LOWER_ROOF);
				ROOF_BLOCKS.add(UPPER_STEEP_ROOF);
			}
	}

	public static List<RegistryObject<Block>> getRoofBlocks() {
		return ROOF_BLOCKS;
	}
	
	public static void setupClient(final FMLClientSetupEvent event) {
	    event.enqueueWork(() -> {
	        for (RegistryObject<Block> block : ROOF_BLOCKS) {
	        	RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
	        }
	    });
	}
	
	protected static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded("mcwroofs"))
		{
			ITEMS_REGISTRY.register(name, () -> new FuelItemBlock(block.get(), new Item.Properties().tab(tab)));
		}
        return block;
    }
	
	protected static RegistryObject<Block> createBlockStone(String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, ItemGroup tab)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded("mcwroofs"))
		{
			ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
		}
        return block;
    }
}