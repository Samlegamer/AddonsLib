package fr.samlegamer.addonslib.client;

import java.util.Map;
import fr.addonslib.api.client.McwColors;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.world.biome.FoliageColors;

@Environment(EnvType.CLIENT)
public class ColorRegistry
{
	private final McwColors mcwColors;

	public ColorRegistry(McwColors mcwColors)
	{
		this.mcwColors = mcwColors;
	}

	public void registryBlockColors() {
		for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
			String value = entry.getKey();
			Block block = Finder.findBlock(value);
			ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> entry.getValue(), block);
		}
	}

	public void registryBlockColorsAverage() {
		for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
			String value = entry.getKey();
			Block block = Finder.findBlock(value);
			ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.DEFAULT, block);
		}
	}
}