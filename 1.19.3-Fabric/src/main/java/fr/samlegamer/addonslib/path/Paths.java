package fr.samlegamer.addonslib.path;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Paths {
	public static final String modid = "mcwpaths";

	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded) {
		Registry.register(Registries.BLOCK, new Identifier(MODID, name), b);
		if (AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded)) {
			Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
		} else {
			Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
		}
	}

	/**
	 * Init all Wood Variants of Macaw's Paths
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab) {
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft");
	}

	/**
	 * Init all Wood Variants of Macaw's Paths with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded) {
		final AbstractBlock.Settings WOOD = AbstractBlock.Settings.copy(Blocks.OAK_PLANKS);

		for (String i : set) {
			try {
				if (AddonsLib.isLoaded(modid)) {
					final Block planks_path = Registration.getBlocksField("com.mcwpaths.kikoz.objects.FacingPathBlock", WOOD);
					registryEntry(MODID, i + "_planks_path", planks_path, tab, modLoaded);
				} else {
					registryEntry(MODID, i + "_planks_path", new Block(WOOD), tab, modLoaded);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void fuelWood(String MODID, List<String> WOOD) {
		Block planks_path;

		for (String i : WOOD) {
			planks_path = Finder.findBlock(MODID, i + "_planks_path");

			FuelRegistry.INSTANCE.add(planks_path, 300);
		}
	}

	public static void addToTabWood(String MODID, List<String> WOOD, ItemGroup tab)
	{
		addToTabWoodModLoaded(MODID, WOOD, tab, "minecraft");
	}

	public static void addToTabWoodModLoaded(String MODID, List<String> WOOD, ItemGroup tab, String modLoaded)
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