package fr.samlegamer.addonslib.path;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Paths
{
	public static final String modid = "mcwpaths";
	
	private static void registryEntry(String MODID, String name, Block b)
	{
		final Identifier ID = Identifier.of(MODID, name);
		final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, ID);
		Registry.register(Registries.BLOCK, ID, b);
		Registry.register(Registries.ITEM, ID, new BlockItem(b, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue()))));
	}
	/**
	 * Init all Wood Variants of Macaw's Paths
	 */
	public static void setRegistrationWood(String MODID, List<String> set)
	{
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);
		setRegistrationWoodModLoaded(MODID, set, WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Paths with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings WOOD = prop;

			for(String i : set)
			{
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
						final Block planks_path = Registration.getBlocksField("com.mcwpaths.kikoz.objects.FacingPathBlock", WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_planks_path"))));
				    	registryEntry(MODID, i+"_planks_path", planks_path);
				    }
				    else
				    {
				    	registryEntry(MODID, i+"_planks_path", new Block(WOOD.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MODID, i+"_planks_path")))));
				    }
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
	
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		for (String i : WOOD)
		{
			Block planks_path;

			planks_path = Finder.findBlock(MODID, i+"_planks_path");
			FuelRegistryEvents.BUILD.register((builder, context) -> {
				builder.add(planks_path, 50);
			});
        }
	}

	public static void addToTabWood(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, RegistryKey<ItemGroup> tab, String modLoaded)
	{
		if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
		{
			for (String i : WOOD)
			{
				final Block planks_path = Finder.findBlock(MODID, i+"_planks_path");
	
				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(planks_path);
				});
			}
		}
	}
}