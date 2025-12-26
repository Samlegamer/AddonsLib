package fr.samlegamer.addonslib.client;

import java.util.Map;
import fr.addonslib.api.client.McwColors;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@OnlyIn(value = Dist.CLIENT)
public class ColorRegistry
{
	private final McwColors mcwColors;

	public ColorRegistry(McwColors mcwColors)
	{
		this.mcwColors = mcwColors;
	}

	public void registryBlockColors(RegisterColorHandlersEvent.Block event) {
		for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
			String value = entry.getKey();
			Block block = Finder.findBlock(value);
			event.register((state, view, pos, tintIndex) -> entry.getValue(), block);
		}
	}

	public void registryBlockColorsAverage(RegisterColorHandlersEvent.Block event) {
		for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
			String value = entry.getKey();
			Block block = Finder.findBlock(value);
			event.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getAverageFoliageColor(view, pos) : FoliageColor.get(0.5D, 1.0D), block);
		}
	}
}