package fr.samlegamer.addonslib.client;

import java.util.Map;
import fr.addonslib.api.client.McwColors;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

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
			if(block != Blocks.AIR) {
				ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> entry.getValue(), block);
			}
		}
	}

	public void registryBlockColorsAverage() {
		for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
			String value = entry.getKey();
			Block block = Finder.findBlock(value);
			if(block != Blocks.AIR) {
				ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getDefaultColor(), block);
			}
		}
	}

	public void registryItemColors() {
		for(Map.Entry<String, Integer> entry : mcwColors.getNoColorLeaves().entrySet()) {
			String value = entry.getKey();
			Block hedges = Finder.findBlock(value);
			if(hedges != Blocks.AIR) {
				ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
					if (stack == null) return -1;
					Item item = stack.getItem();
					if (!(item instanceof BlockItem)) return -1;
					Block block = ((BlockItem) item).getBlock();
					if (block == null) return -1;
					var colorProvider = ColorProviderRegistry.BLOCK.get(block);
					if (colorProvider == null) return -1;
					try {
						return colorProvider.getColor(block.getDefaultState(), null, null, tintIndex);
					} catch (Throwable t) {
						return -1;
					}
				}, hedges);
			}
		}
	}
}