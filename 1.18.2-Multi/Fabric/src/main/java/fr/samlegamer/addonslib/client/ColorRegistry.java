package fr.samlegamer.addonslib.client;

import java.util.List;
import java.util.Objects;
import fr.addonslib.api.client.ObjectColor;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;

@Environment(EnvType.CLIENT)
public class ColorRegistry
{
	private final List<ObjectColor> objectColors;

	public ColorRegistry(List<ObjectColor> objectColors)
	{
		this.objectColors = objectColors;
	}

	public void registryBlockColors() {
		for(ObjectColor objectColor : objectColors) {
			String MODID = objectColor.getMODID();
			String name = objectColor.getName();
			int color = objectColor.getColor();
			Block block = Finder.findBlock(MODID, name + "_hedge");

			if(ColorUtils.isValidBlock(block)) {
				if (color == ObjectColor.DEFAULT_COLOR) {
					ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getAverageFoliageColor(view, pos) : FoliageColor.get(0.5D, 1.0D), block);
				} else {
					ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> color, block);
				}
			}
		}
	}

	public void registryItemColors() {
		for(ObjectColor objectColor : objectColors) {
			String MODID = objectColor.getMODID();
			String name = objectColor.getName();
			Block hedges = Finder.findBlock(MODID, name + "_hedge");

			if(ColorUtils.isValidBlock(hedges)) {
				ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
					Block block = ((BlockItem) stack.getItem()).getBlock();
					return Objects.requireNonNull(ColorProviderRegistry.BLOCK.get(block)).getColor(block.defaultBlockState(), null, null, tintIndex);
				}, hedges);
			}
		}
	}
}