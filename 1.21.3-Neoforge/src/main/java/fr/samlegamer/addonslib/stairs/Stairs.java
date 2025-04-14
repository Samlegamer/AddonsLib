package fr.samlegamer.addonslib.stairs;

import java.util.List;
import java.util.function.Function;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemFuel;
import fr.samlegamer.addonslib.item.BlockItemFuelInfo;
import fr.samlegamer.addonslib.item.BlockItemInfo;
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

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	public static void setRegistrationWood(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of().strength(2.0F, 2.3F).sound(SoundType.WOOD);
		setRegistrationWoodModLoaded(set, block, item, WOOD);
	}

	public static void setRegistrationRock(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of().strength(2.0F, 2.3F).sound(SoundType.STONE).requiresCorrectToolForDrops();
		setRegistrationRockModLoaded(set, block, item, STONE);
	}
	
	public static void setRegistrationRockModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
		 final BlockBehaviour.Properties STONE = prop;
			DeferredBlock<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
					if (ModList.get().isLoaded(modid)) {
						ACACIA_TERRACE_STAIRS = createBlockStone(i + "_terrace_stairs", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_SKYLINE_STAIRS = createBlockStone(i + "_skyline_stairs", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_COMPACT_STAIRS = createBlockStone(i + "_compact_stairs", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_BULK_STAIRS = createBlockStone(i + "_bulk_stairs", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_LOFT_STAIRS = createBlockStone(i + "_loft_stairs", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_RAILING = createBlockStone(i + "_railing", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_BALCONY = createBlockStone(i + "_balcony", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_PLATFORM = createBlockStone(i + "_platform", registryName ->
										Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform",
												STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
					} else {
						ACACIA_TERRACE_STAIRS = createBlockStone(i + "_terrace_stairs", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_SKYLINE_STAIRS = createBlockStone(i + "_skyline_stairs", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_COMPACT_STAIRS = createBlockStone(i + "_compact_stairs", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_BULK_STAIRS = createBlockStone(i + "_bulk_stairs", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_LOFT_STAIRS = createBlockStone(i + "_loft_stairs", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_RAILING = createBlockStone(i + "_railing", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_BALCONY = createBlockStone(i + "_balcony", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
						ACACIA_PLATFORM = createBlockStone(i + "_platform", registryName ->
										new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, registryName))),
								block, item);
					}
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	public static void setRegistrationWoodModLoaded(List<String> set, DeferredRegister.Blocks block, DeferredRegister.Items item, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
			DeferredBlock<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
					if (ModList.get().isLoaded(modid)) {
						ACACIA_TERRACE_STAIRS = createBlock(i + "_terrace_stairs", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_SKYLINE_STAIRS = createBlock(i + "_skyline_stairs", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_COMPACT_STAIRS = createBlock(i + "_compact_stairs", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_BULK_STAIRS = createBlock(i + "_bulk_stairs", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_LOFT_STAIRS = createBlock(i + "_loft_stairs", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_RAILING = createBlock(i + "_railing", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_BALCONY = createBlock(i + "_balcony", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_PLATFORM = createBlock(i + "_platform", registryName ->
								Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform",
										WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
					} else {
						ACACIA_TERRACE_STAIRS = createBlock(i + "_terrace_stairs", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_SKYLINE_STAIRS = createBlock(i + "_skyline_stairs", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_COMPACT_STAIRS = createBlock(i + "_compact_stairs", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_BULK_STAIRS = createBlock(i + "_bulk_stairs", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_LOFT_STAIRS = createBlock(i + "_loft_stairs", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_RAILING = createBlock(i + "_railing", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_BALCONY = createBlock(i + "_balcony", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
						ACACIA_PLATFORM = createBlock(i + "_platform", registryName ->
								new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, registryName))), block, item);
					}
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	protected static DeferredBlock<Block> createBlock(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
        DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		if(name.contains("railing")) {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.railing.desc"));
		}
		else if(name.contains("balcony")) {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.balcony.desc"));
		}
		else if(name.contains("platform")) {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.platform.desc"));
		}
		else {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemFuel(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
		}
        return block;
    }
	
	protected static DeferredBlock<Block> createBlockStone(String name, Function<ResourceLocation, ? extends Block> func, DeferredRegister.Blocks BLOCKS_REGISTRY, DeferredRegister.Items ITEMS_REGISTRY)
    {
		DeferredBlock<Block> block = BLOCKS_REGISTRY.register(name, func);
		if(name.contains("railing")) {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.railing.desc"));
		}
		else if(name.contains("balcony")) {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.balcony.desc"));
		}
		else if(name.contains("platform")) {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItemInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName)), "mcwstairs.platform.desc"));
		}
		else {
			ITEMS_REGISTRY.register(name, registryName -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, registryName))));
		}
        return block;
    }
	
	public static void addToTab(BuildCreativeModeTabContentsEvent event, String MODID, List<String> WOOD, CreativeModeTab tab)
	{
		Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

		if (event.getTab() == tab && ModList.get().isLoaded(modid))
   	 	{
			for (String i : WOOD)
			{
				_terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
				_skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
				_compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
				_bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
				_loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
				_railing = Finder.findBlock(MODID, i+"_railing");
				_balcony = Finder.findBlock(MODID, i+"_balcony");
				_platform = Finder.findBlock(MODID, i+"_platform");
				
				event.accept(_terrace_stairs);
				event.accept(_skyline_stairs);
				event.accept(_compact_stairs);
				event.accept(_bulk_stairs);
				event.accept(_loft_stairs);
				event.accept(_railing);
				event.accept(_balcony);
				event.accept(_platform);
			}
   	 	}
	}
}