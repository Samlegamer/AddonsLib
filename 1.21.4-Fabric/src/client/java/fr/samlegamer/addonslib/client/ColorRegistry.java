package fr.samlegamer.addonslib.client;

import java.util.ArrayList;
import java.util.List;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.biome.FoliageColors;

@Environment(EnvType.CLIENT)
public class ColorRegistry
{
	private final String MODID;
	private List<String> NoColorLeaves = new ArrayList<String>();
	
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
			ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.DEFAULT, hedges);
		}
	}

	public List<String> getNoColorLeaves()
	{
		return this.NoColorLeaves;
	}
}