package fr.samlegamer.addonslib.door;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Doors
{
	public static final String modid = "mcwdoors";
	
	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
    	}
    	else {
            Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
	}
	/**
	 * Init all Wood Variants of Macaw's Doors
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
		setRegistrationWoodModLoaded(MODID, set, tab, "minecraft");
	}
	
	/**
	 * Init all Wood Variants of Macaw's Doors with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded)
	{
			final AbstractBlock.Settings JAPAN = AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1.5F, 1.0F).sounds(BlockSoundGroup.WOOD);
			final AbstractBlock.Settings DOOR_WOOD = AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR);

			for(String i : set)
			{
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	final Block japanese_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.JapaneseDoors", JAPAN);
				    	final Block japanese2_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.JapaneseDoors", JAPAN);
				    	final Block stable_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.StableDoor", JAPAN);
				    	final Block stable_head_door = Registration.getBlocksField("net.kikoz.mcwdoors.objects.StableDoor", JAPAN);
				    	
				    	registryEntry(MODID, i+"_japanese_door", japanese_door, tab, modLoaded);
				    	registryEntry(MODID, i+"_japanese2_door", japanese2_door, tab, modLoaded);
				    	registryEntry(MODID, i+"_barn_door", new DoorBlock(DOOR_WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_barn_glass_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_modern_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_cottage_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_classic_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_beach_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_paper_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_four_panel_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_tropical_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_glass_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_stable_door", stable_door, tab, modLoaded);
				    	registryEntry(MODID, i+"_stable_head_door", stable_head_door, tab, modLoaded);
				    	registryEntry(MODID, i+"_western_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_mystic_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_nether_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_swamp_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_bamboo_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_bark_glass_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_waffle_door", new DoorBlock(JAPAN), tab, modLoaded);
						registryEntry(MODID, i+"_whispering_door", new DoorBlock(JAPAN), tab, modLoaded);
				    }
				    else
				    {
				    	registryEntry(MODID, i+"_japanese_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_japanese2_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_barn_door", new DoorBlock(DOOR_WOOD), tab, modLoaded);
				    	registryEntry(MODID, i+"_barn_glass_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_modern_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_cottage_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_classic_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_beach_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_paper_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_four_panel_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_tropical_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_glass_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_stable_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_stable_head_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_western_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_mystic_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_nether_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_swamp_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_bamboo_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_bark_glass_door", new DoorBlock(JAPAN), tab, modLoaded);
				    	registryEntry(MODID, i+"_waffle_door", new DoorBlock(JAPAN), tab, modLoaded);
						registryEntry(MODID, i+"_whispering_door", new DoorBlock(JAPAN), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
	
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}
	
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
		tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door,
				whispering_door;
		
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

			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, japanese_door
			,japanese2_door
			,barn_door
			,barn_glass_door
			,modern_door
			,cottage_door
			,classic_door
			,beach_door
			,paper_door
			,four_panel_door
			,tropical_door
			,glass_door
			,stable_door
			,stable_head_door
			,western_door
			,mystic_door
			,nether_door
			,swamp_door
			,bamboo_door
			,bark_glass_door
			,waffle_door, whispering_door);
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
}