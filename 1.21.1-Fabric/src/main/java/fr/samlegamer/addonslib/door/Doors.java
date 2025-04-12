package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class Doors
{
	public static final String modid = "mcwdoors";
	
	private static void registryEntry(String MODID, String name, Block b)
	{
    	Registry.register(Registries.BLOCK, Identifier.of(MODID, name), b);
		Registry.register(Registries.ITEM, Identifier.of(MODID, name), new BlockItem(b, new Item.Settings()));
	}

	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(String MODID, List<String> set)
	{
		final AbstractBlock.Settings JAPAN = AbstractBlock.Settings.create().nonOpaque().strength(1.5F, 1.0F).sounds(BlockSoundGroup.WOOD);
		final AbstractBlock.Settings DOOR_WOOD = AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR);
		setRegistrationWoodModLoaded(MODID, set, JAPAN, DOOR_WOOD);
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, AbstractBlock.Settings japan_door, AbstractBlock.Settings wood_door)
	{
			final AbstractBlock.Settings JAPAN = japan_door;
			final AbstractBlock.Settings DOOR_WOOD = wood_door;

			for(String i : set)
			{
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	final Block japanese_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.JapaneseDoors", JAPAN, BlockSetType.OAK);
				    	final Block japanese2_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.JapaneseDoors", JAPAN, BlockSetType.OAK);
				    	final Block stable_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.StableDoor", JAPAN, BlockSetType.OAK);
				    	final Block stable_head_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.StableDoor", JAPAN, BlockSetType.OAK);
				    	
				    	registryEntry(MODID, i+"_japanese_door", japanese_door);
				    	registryEntry(MODID, i+"_japanese2_door", japanese2_door);
				    	registryEntry(MODID, i+"_barn_door", new DoorBlock(BlockSetType.OAK, DOOR_WOOD));
				    	registryEntry(MODID, i+"_barn_glass_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_modern_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_cottage_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_classic_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_beach_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_paper_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_four_panel_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_tropical_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_glass_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_stable_door", stable_door);
				    	registryEntry(MODID, i+"_stable_head_door", stable_head_door);
				    	registryEntry(MODID, i+"_western_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_mystic_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_nether_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_swamp_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_bamboo_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_bark_glass_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_waffle_door", new DoorBlock(BlockSetType.OAK, JAPAN));
						registryEntry(MODID, i+"_whispering_door", new DoorBlock(BlockSetType.OAK, JAPAN));
					}
				    else
				    {
				    	registryEntry(MODID, i+"_japanese_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_japanese2_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_barn_door", new DoorBlock(BlockSetType.OAK, DOOR_WOOD));
				    	registryEntry(MODID, i+"_barn_glass_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_modern_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_cottage_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_classic_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_beach_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_paper_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_four_panel_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_tropical_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_glass_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_stable_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_stable_head_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_western_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_mystic_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_nether_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_swamp_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_bamboo_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_bark_glass_door", new DoorBlock(BlockSetType.OAK, JAPAN));
				    	registryEntry(MODID, i+"_waffle_door", new DoorBlock(BlockSetType.OAK, JAPAN));
						registryEntry(MODID, i+"_whispering_door", new DoorBlock(BlockSetType.OAK, JAPAN));
					}
				} catch (Exception e) {
					AddonsLib.LOGGER.error(e);
				}
			}
	}
		
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;
		
		for (String i : WOOD)
		{
			japanese_door = Finder.findBlock(MODID, i + "_japanese_door");
			japanese2_door = Finder.findBlock(MODID, i + "_japanese2_door");
			barn_door = Finder.findBlock(MODID, i + "_barn_door");
			barn_glass_door = Finder.findBlock(MODID, i + "_barn_glass_door");
			modern_door = Finder.findBlock(MODID, i + "_modern_door");
			cottage_door = Finder.findBlock(MODID, i + "_cottage_door");
			classic_door = Finder.findBlock(MODID, i + "_classic_door");
			beach_door = Finder.findBlock(MODID, i + "_beach_door");
			paper_door = Finder.findBlock(MODID, i + "_paper_door");
			four_panel_door = Finder.findBlock(MODID, i + "_four_panel_door");
			tropical_door = Finder.findBlock(MODID, i + "_tropical_door");
			glass_door = Finder.findBlock(MODID, i + "_glass_door");
			stable_door = Finder.findBlock(MODID, i + "_stable_door");
			stable_head_door = Finder.findBlock(MODID, i + "_stable_head_door");
			western_door = Finder.findBlock(MODID, i + "_western_door");
			mystic_door = Finder.findBlock(MODID, i + "_mystic_door");
			nether_door = Finder.findBlock(MODID, i + "_nether_door");
			swamp_door = Finder.findBlock(MODID, i + "_swamp_door");
			bamboo_door = Finder.findBlock(MODID, i + "_bamboo_door");
			bark_glass_door = Finder.findBlock(MODID, i + "_bark_glass_door");
			waffle_door = Finder.findBlock(MODID, i + "_waffle_door");
			whispering_door = Finder.findBlock(MODID, i + "_whispering_door");

			FuelRegistry.INSTANCE.add(japanese_door, 300);
			FuelRegistry.INSTANCE.add(japanese2_door, 300);
			FuelRegistry.INSTANCE.add(barn_door, 300);
			FuelRegistry.INSTANCE.add(barn_glass_door, 300);
			FuelRegistry.INSTANCE.add(modern_door, 300);
			FuelRegistry.INSTANCE.add(cottage_door, 300);
			FuelRegistry.INSTANCE.add(classic_door, 300);
			FuelRegistry.INSTANCE.add(beach_door, 300);
			FuelRegistry.INSTANCE.add(paper_door, 300);
			FuelRegistry.INSTANCE.add(four_panel_door, 300);
			FuelRegistry.INSTANCE.add(tropical_door, 300);
			FuelRegistry.INSTANCE.add(glass_door, 300);
			FuelRegistry.INSTANCE.add(stable_door, 300);
			FuelRegistry.INSTANCE.add(stable_head_door, 300);
			FuelRegistry.INSTANCE.add(western_door, 300);
			FuelRegistry.INSTANCE.add(mystic_door, 300);
			FuelRegistry.INSTANCE.add(nether_door, 300);
			FuelRegistry.INSTANCE.add(swamp_door, 300);
			FuelRegistry.INSTANCE.add(bamboo_door, 300);
			FuelRegistry.INSTANCE.add(bark_glass_door, 300);
			FuelRegistry.INSTANCE.add(waffle_door, 300);
			FuelRegistry.INSTANCE.add(whispering_door, 300);
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
				final Block japanese_door = Finder.findBlock(MODID, i + "_japanese_door");
				final Block japanese2_door = Finder.findBlock(MODID, i + "_japanese2_door");
				final Block barn_door = Finder.findBlock(MODID, i + "_barn_door");
				final Block barn_glass_door = Finder.findBlock(MODID, i + "_barn_glass_door");
				final Block modern_door = Finder.findBlock(MODID, i + "_modern_door");
				final Block cottage_door = Finder.findBlock(MODID, i + "_cottage_door");
				final Block classic_door = Finder.findBlock(MODID, i + "_classic_door");
				final Block beach_door = Finder.findBlock(MODID, i + "_beach_door");
				final Block paper_door = Finder.findBlock(MODID, i + "_paper_door");
				final Block four_panel_door = Finder.findBlock(MODID, i + "_four_panel_door");
				final Block tropical_door = Finder.findBlock(MODID, i + "_tropical_door");
				final Block glass_door = Finder.findBlock(MODID, i + "_glass_door");
				final Block stable_door = Finder.findBlock(MODID, i + "_stable_door");
				final Block stable_head_door = Finder.findBlock(MODID, i + "_stable_head_door");
				final Block western_door = Finder.findBlock(MODID, i + "_western_door");
				final Block mystic_door = Finder.findBlock(MODID, i + "_mystic_door");
				final Block nether_door = Finder.findBlock(MODID, i + "_nether_door");
				final Block swamp_door = Finder.findBlock(MODID, i + "_swamp_door");
				final Block bamboo_door = Finder.findBlock(MODID, i + "_bamboo_door");
				final Block bark_glass_door = Finder.findBlock(MODID, i + "_bark_glass_door");
				final Block waffle_door = Finder.findBlock(MODID, i + "_waffle_door");
				final Block whispering_door = Finder.findBlock(MODID, i + "_whispering_door");

				ItemGroupEvents.modifyEntriesEvent(tab).register(content -> {
					content.add(japanese_door);
					content.add(japanese2_door);
					content.add(barn_door);
					content.add(barn_glass_door);
					content.add(modern_door);
					content.add(cottage_door);
					content.add(classic_door);
					content.add(beach_door);
					content.add(paper_door);
					content.add(four_panel_door);
					content.add(tropical_door);
					content.add(glass_door);
					content.add(stable_door);
					content.add(stable_head_door);
					content.add(western_door);
					content.add(mystic_door);
					content.add(nether_door);
					content.add(swamp_door);
					content.add(bamboo_door);
					content.add(bark_glass_door);
					content.add(waffle_door);
					content.add(whispering_door);
				});
	
			}
		}
	}
}