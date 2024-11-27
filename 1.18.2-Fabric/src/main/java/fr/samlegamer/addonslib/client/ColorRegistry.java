package fr.samlegamer.addonslib.client;

import java.util.ArrayList;
import java.util.List;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;

@Environment(EnvType.CLIENT)
public class ColorRegistry
{
	private String MODID;
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
			//event.getBlockColors().register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getAverageFoliageColor(view, pos) : FoliageColor.get(0.5D, 1.0D), hedges);
		}
	}
	
	@Environment(EnvType.CLIENT)
	public void colorsItem()
	{
		for(String i : NoColorLeaves)
		{
			Block hedges = Finder.findBlock(this.MODID, i+"_hedge");
			/*event.getItemColors().register((stack, tintIndex) -> {
	            Block block = ((BlockItem) stack.getItem()).getBlock();
	            return event.getBlockColors().getColor(block.defaultBlockState(), null, null, tintIndex);
	        }, hedges);*/
		}
	}

	public List<String> getNoColorLeaves()
	{
		return this.NoColorLeaves;
	}
}