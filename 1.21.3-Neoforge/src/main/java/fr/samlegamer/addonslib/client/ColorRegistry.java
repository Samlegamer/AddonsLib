package fr.samlegamer.addonslib.client;

import java.util.List;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@OnlyIn(value = Dist.CLIENT)
public class ColorRegistry
{
	private final String MODID;
	private final List<String> NoColorLeaves;
	
	public ColorRegistry(String MODID, List<String> LEAVES)
	{
		this.MODID = MODID;
		this.NoColorLeaves = LEAVES;
	}
	
	@OnlyIn(value = Dist.CLIENT)
	public void colorsBlock(RegisterColorHandlersEvent.Block event)
	{
		for(String i : NoColorLeaves)
		{
			Block hedges = Finder.findBlock(this.MODID, i+"_hedge");
			event.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getAverageFoliageColor(view, pos) : FoliageColor.get(0.5D, 1.0D), hedges);
		}
	}
	
	@OnlyIn(value = Dist.CLIENT)
	public void colorsItem(RegisterColorHandlersEvent.Item event)
	{
		for(String i : NoColorLeaves)
		{
			Block hedges = Finder.findBlock(this.MODID, i+"_hedge");
			event.register((stack, tintIndex) -> {
	            Block block = ((BlockItem) stack.getItem()).getBlock();
	            return event.getBlockColors().getColor(block.defaultBlockState(), null, null, tintIndex);
	        }, hedges);
		}
	}

	public List<String> getNoColorLeaves()
	{
		return this.NoColorLeaves;
	}
}