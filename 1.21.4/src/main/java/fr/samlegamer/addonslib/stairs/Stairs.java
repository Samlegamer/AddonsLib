package fr.samlegamer.addonslib.stairs;

import java.util.List;
import java.util.function.Supplier;

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
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryObject;

public class Stairs
{
	public static final String modid = "mcwstairs";
	
	public static void setRegistrationWood(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of().strength(2.0F, 2.3F).sound(SoundType.WOOD);
		setRegistrationWoodModLoaded(set, mod, block, item, tab, "minecraft", WOOD);
	}

	public static void setRegistrationRock(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab)
	{
		final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of().strength(2.0F, 2.3F).sound(SoundType.STONE).requiresCorrectToolForDrops();
		setRegistrationRockModLoaded(set, mod, block, item, tab, "minecraft", STONE);
	}
	
	public static void setRegistrationRockModLoaded(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
		 final BlockBehaviour.Properties STONE = prop;
			RegistryObject<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = createBlockStone(mod, i+"_terrace_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_terrace_stairs")))), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlockStone(mod, i+"_skyline_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_skyline_stairs")))), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlockStone(mod, i+"_compact_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_compact_stairs")))), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlockStone(mod, i+"_bulk_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bulk_stairs")))), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlockStone(mod, i+"_loft_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_loft_stairs")))), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlockStone(mod, i+"_railing", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_railing")))), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlockStone(mod, i+"_balcony", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_balcony")))), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlockStone(mod, i+"_platform", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_platform")))), block, item, tab, modLoaded);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = createBlockStone(mod, i+"_terrace_stairs", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_terrace_stairs")))), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlockStone(mod, i+"_skyline_stairs", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_skyline_stairs")))), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlockStone(mod, i+"_compact_stairs", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_compact_stairs")))), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlockStone(mod, i+"_bulk_stairs", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bulk_stairs")))), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlockStone(mod, i+"_loft_stairs", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_loft_stairs")))), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlockStone(mod, i+"_railing", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_railing")))), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlockStone(mod, i+"_balcony", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_balcony")))), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlockStone(mod, i+"_platform", () -> new Block(STONE.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_platform")))), block, item, tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static void setRegistrationWoodModLoaded(List<String> set, String mod, DeferredRegister<Block> block, DeferredRegister<Item> item, CreativeModeTab tab, String modLoaded, BlockBehaviour.Properties prop)
	{
			final BlockBehaviour.Properties WOOD = prop;
			RegistryObject<Block> ACACIA_TERRACE_STAIRS, ACACIA_SKYLINE_STAIRS, ACACIA_COMPACT_STAIRS, ACACIA_BULK_STAIRS, ACACIA_LOFT_STAIRS, ACACIA_RAILING, ACACIA_BALCONY, ACACIA_PLATFORM;

			for(String i : set)
			{
				try {
				    if (ModList.get().isLoaded(modid))
				    {
						ACACIA_TERRACE_STAIRS = createBlock(mod, i+"_terrace_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.TerraceStairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_terrace_stairs")))), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlock(mod, i+"_skyline_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.SkylineStairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_skyline_stairs")))), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlock(mod, i+"_compact_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.CompactStairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_compact_stairs")))), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlock(mod, i+"_bulk_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.BulkStairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bulk_stairs")))), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlock(mod, i+"_loft_stairs", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.stair_types.LoftStairs", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_loft_stairs")))), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlock(mod, i+"_railing", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairRailing", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_railing")))), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlock(mod, i+"_balcony", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.BalconyRailing", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_balcony")))), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlock(mod, i+"_platform", () -> Registration.getBlocksField("com.mcwstairs.kikoz.objects.StairPlatform", WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_platform")))), block, item, tab, modLoaded);
				    }
				    else
				    {
						ACACIA_TERRACE_STAIRS = createBlock(mod, i+"_terrace_stairs", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_terrace_stairs")))), block, item, tab, modLoaded);
						ACACIA_SKYLINE_STAIRS = createBlock(mod, i+"_skyline_stairs", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_skyline_stairs")))), block, item, tab, modLoaded);
						ACACIA_COMPACT_STAIRS = createBlock(mod, i+"_compact_stairs", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_compact_stairs")))), block, item, tab, modLoaded);
						ACACIA_BULK_STAIRS = createBlock(mod, i+"_bulk_stairs", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_bulk_stairs")))), block, item, tab, modLoaded);
						ACACIA_LOFT_STAIRS = createBlock(mod, i+"_loft_stairs", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_loft_stairs")))), block, item, tab, modLoaded);
						ACACIA_RAILING = createBlock(mod, i+"_railing", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_railing")))), block, item, tab, modLoaded);
						ACACIA_BALCONY = createBlock(mod, i+"_balcony", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_balcony")))), block, item, tab, modLoaded);
						ACACIA_PLATFORM = createBlock(mod, i+"_platform", () -> new Block(WOOD.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod, i+"_platform")))), block, item, tab, modLoaded);
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
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location())), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location())), "mcwstairs.balcony.desc"));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemFuelInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location())), "mcwstairs.platform.desc"));
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

	protected static RegistryObject<Block> createBlockStone(String mod, String name, Supplier<? extends Block> supplier, DeferredRegister<Block> BLOCKS_REGISTRY, DeferredRegister<Item> ITEMS_REGISTRY, CreativeModeTab tab, String modLoaded)
    {
		RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
		if(ModList.get().isLoaded(modid) && ModList.get().isLoaded(modLoaded))
		{
	        if(name.contains("railing")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location())), "mcwstairs.railing.desc"));
	        }
	        else if(name.contains("balcony")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location())), "mcwstairs.balcony.desc"));
	        }
	        else if(name.contains("platform")) {
	            ITEMS_REGISTRY.register(name, () -> new BlockItemInfo(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location())), "mcwstairs.platform.desc"));
	        }
	        else {
	            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
	        }
		}
		else
		{
            ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, block.get().builtInRegistryHolder().key().location()))));
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