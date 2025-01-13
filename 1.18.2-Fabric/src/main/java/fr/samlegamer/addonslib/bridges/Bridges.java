package fr.samlegamer.addonslib.bridges;

import java.util.List;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import fr.samlegamer.addonslib.item.BlockItemInfo;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Bridges
{
	private static final AbstractBlock.Settings wood = AbstractBlock.Settings.of(Material.WOOD).strength(0.5F, 2.5F).sounds(BlockSoundGroup.WOOD);
	private static final AbstractBlock.Settings stone = AbstractBlock.Settings.of(Material.STONE).strength(3.0F, 5.0F).sounds(BlockSoundGroup.STONE);
	
	public static final String modid = "mcwbridges";
	private static final String desc = "mcwbridges.bridges.desc";

	private static void registryEntry(String MODID, String name, Block b, ItemGroup tab, String modLoaded)
	{
    	Registry.register(Registry.BLOCK, new Identifier(MODID, name), b);
    	if(AddonsLib.isLoaded(modid) && AddonsLib.isLoaded(modLoaded))
    	{
            if(name.contains("log_bridge_middle") || name.startsWith("rope_") || name.endsWith("_bridge"))
            {
            	Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItemInfo(b, new Item.Settings().group(tab), desc));
            }
            else {
            	Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings().group(tab)));
            }
    	}
    	else {
    		Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(b, new Item.Settings()));
        }
	}
	
	/**
	 * Init all Wood Variants of Macaw's Bridges
	 */
	public static void setRegistrationWood(String MODID, List<String> set, ItemGroup tab)
	{
			setRegistrationWoodModLoaded(MODID, set, tab, "minecraft", wood);
	}
	
	/**
	 * Init all Stone Variants of Macaw's Bridges
	 */
	public static void setRegistrationRock(String MODID, List<String> set, ItemGroup tab)
	{
			setRegistrationRockModLoaded(MODID, set, tab, "minecraft", stone);
	}
		
	/**
	 * Init all Stone Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationRockModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
		 final AbstractBlock.Settings STONE = prop;

			for(String i : set)
			{		 
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	final Block cryptic_stone_bridge = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Block", STONE);
				    	final Block cryptic_stone_bridge_pier = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Support", STONE);
				    	final Block cryptic_stone_bridge_stair = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Stairs", STONE);
				    	final Block balustrade_cryptic_stone_bridge = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Block", STONE);
				    	
				    	registryEntry(MODID, i+"_bridge", cryptic_stone_bridge, tab, modLoaded);
						registryEntry(MODID, i+"_bridge_pier", cryptic_stone_bridge_pier, tab, modLoaded);
						registryEntry(MODID, i+"_bridge_stair", cryptic_stone_bridge_stair, tab, modLoaded);
						registryEntry(MODID, "balustrade_"+i+"_bridge", balustrade_cryptic_stone_bridge, tab, modLoaded);
				    }
				    else
				    {
						registryEntry(MODID, i+"_bridge", new Block(STONE), tab, modLoaded);
						registryEntry(MODID, i+"_bridge_pier", new Block(STONE), tab, modLoaded);
						registryEntry(MODID, i+"_bridge_stair", new Block(STONE), tab, modLoaded);
						registryEntry(MODID, "balustrade_"+i+"_bridge", new Block(STONE), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}

	/**
	 * Init all Wood Variants of Macaw's Bridges with if Mod Loaded
	 */
	public static void setRegistrationWoodModLoaded(String MODID, List<String> set, ItemGroup tab, String modLoaded, AbstractBlock.Settings prop)
	{
			final AbstractBlock.Settings WOOD = prop;
			final AbstractBlock.Settings RAILS = prop.nonOpaque();

			for(String i : set)
			{
				try {
				    if (AddonsLib.isLoaded(modid))
				    {
				    	final Block log_bridge_middle = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Log_Bridge", wood);
				    	final Block rope_bridge = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Block_Rope", wood);
				    	final Block bridge_pier = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Support", wood);
				    	final Block log_bridge_stair = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Stairs", wood);
				    	final Block rope_bridge_stair = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Bridge_Stairs", wood);
				    	final Block rail_bridge = Registration.getBlocksField("net.kikoz.mcwbridges.objects.Rail_Bridge", wood);

				    	registryEntry(MODID, i+"_log_bridge_middle", log_bridge_middle, tab, modLoaded);
						registryEntry(MODID, "rope_"+i+"_bridge", rope_bridge, tab, modLoaded);
						registryEntry(MODID, i+"_bridge_pier", bridge_pier, tab, modLoaded);
						registryEntry(MODID, i+"_log_bridge_stair", log_bridge_stair, tab, modLoaded);
						registryEntry(MODID, i+"_rope_bridge_stair", rope_bridge_stair, tab, modLoaded);
						registryEntry(MODID, i+"_rail_bridge", rail_bridge, tab, modLoaded);
				    }
				    else
				    {
						registryEntry(MODID, i+"_log_bridge_middle", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, "rope_"+i+"_bridge", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_bridge_pier", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_log_bridge_stair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_rope_bridge_stair", new Block(WOOD), tab, modLoaded);
						registryEntry(MODID, i+"_rail_bridge", new Block(RAILS), tab, modLoaded);
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
	}
		
	public static void clientWood(String MODID, List<String> WOOD, RenderLayer renderSet)
	{
		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
		
		for (String i : WOOD)
		{				    	
			log_bridge_middle = Finder.findBlock(MODID, i+"_log_bridge_middle");
			rope_bridge = Finder.findBlock(MODID, "rope_"+i+"_bridge");
			bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
			log_bridge_stair = Finder.findBlock(MODID, i+"_log_bridge_stair");
			rope_bridge_stair = Finder.findBlock(MODID, i+"_rope_bridge_stair");
			rail_bridge = Finder.findBlock(MODID, i+"_rail_bridge");
			
			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge);
        }
	}
	
	public static void clientWood(String MODID, List<String> WOOD)
	{
		clientWood(MODID, WOOD, RenderLayer.getCutout());
	}
	
	public static void clientStone(String MODID, List<String> STONE, RenderLayer renderSet)
	{
		Block stone_bridge, stone_bridge_pier, stone_bridge_stair, balustrade_stone_bridge;
		
		for (String i : STONE)
		{
			stone_bridge = Finder.findBlock(MODID, i+"_bridge");
			stone_bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
			stone_bridge_stair = Finder.findBlock(MODID, i+"_bridge_stair");
			balustrade_stone_bridge = Finder.findBlock(MODID, "balustrade_"+i+"_bridge");
			
			BlockRenderLayerMap.INSTANCE.putBlocks(renderSet, stone_bridge, stone_bridge_pier, stone_bridge_stair, balustrade_stone_bridge);
        }
	}

	public static void clientStone(String MODID, List<String> STONE)
	{
		clientStone(MODID, STONE, RenderLayer.getCutout());
	}
	
	public static void fuelWood(String MODID, List<String> WOOD)
	{
		Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;
		
		for (String i : WOOD)
		{				    	
			log_bridge_middle = Finder.findBlock(MODID, i+"_log_bridge_middle");
			rope_bridge = Finder.findBlock(MODID, "rope_"+i+"_bridge");
			bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
			log_bridge_stair = Finder.findBlock(MODID, i+"_log_bridge_stair");
			rope_bridge_stair = Finder.findBlock(MODID, i+"_rope_bridge_stair");
			rail_bridge = Finder.findBlock(MODID, i+"_rail_bridge");
			
			FuelRegistry.INSTANCE.add(log_bridge_middle, 300);
			FuelRegistry.INSTANCE.add(rope_bridge, 300);
			FuelRegistry.INSTANCE.add(bridge_pier, 300);
			FuelRegistry.INSTANCE.add(log_bridge_stair, 300);
			FuelRegistry.INSTANCE.add(rope_bridge_stair, 300);
			FuelRegistry.INSTANCE.add(rail_bridge, 300);
		}
	}
}