package fr.samlegamer.addonslib.client;

import java.util.ArrayList;
import java.util.List;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.FoliageColors;

@Environment(EnvType.CLIENT)
public class ColorRegistry
{
	private final String MODID;
	private final List<String> NoColorLeaves;
	
	public ColorRegistry(String MODID, List<String> LEAVES)
	{
		this.MODID = MODID;
		this.NoColorLeaves = LEAVES;
	}
	
	@Environment(EnvType.CLIENT)
	public void colorsBlock()
	{
		for(String i : NoColorLeaves)
		{
			Block hedges = Finder.findBlock(this.MODID, i+"_hedge");
			ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getDefaultColor(), hedges);
		}
	}
	
	@Environment(EnvType.CLIENT)
	public void colorsItem()
	{
		for(String i : NoColorLeaves)
		{
			Block hedges = Finder.findBlock(this.MODID, i+"_hedge");
			ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getDefaultColor(), hedges);
		}
	}

	public List<String> getNoColorLeaves()
	{
		return this.NoColorLeaves;
	}
}