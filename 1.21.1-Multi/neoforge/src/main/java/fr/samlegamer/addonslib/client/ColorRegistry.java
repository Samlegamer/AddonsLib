package fr.samlegamer.addonslib.client;

import fr.addonslib.api.client.ObjectColor;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import java.util.List;

@OnlyIn(value = Dist.CLIENT)
public class ColorRegistry
{
	private final List<ObjectColor> objectColors;

	public ColorRegistry(List<ObjectColor> objectColors)
	{
		this.objectColors = objectColors;
	}

	public void registryBlockColors(RegisterColorHandlersEvent.Block event) {
		for(ObjectColor objectColor : objectColors) {
			String MODID = objectColor.getMODID();
			String name = objectColor.getName();
			int color = objectColor.getColor();
			Block block = Finder.findBlock(MODID, name + "_hedge");

			if(ColorUtils.isValidBlock(block)) {
				if (color == ObjectColor.DEFAULT_COLOR) {
					event.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getAverageFoliageColor(view, pos) : FoliageColor.get(0.5D, 1.0D), block);
				} else {
					event.register((state, view, pos, tintIndex) -> color, block);
				}
			}
		}
	}

	public void registryItemColors(RegisterColorHandlersEvent.Item event) {
		for(ObjectColor objectColor : objectColors) {
			String MODID = objectColor.getMODID();
			String name = objectColor.getName();
			Block hedges = Finder.findBlock(MODID, name + "_hedge");

			if(ColorUtils.isValidBlock(hedges)) {
				event.register((stack, tintIndex) -> {
					Block block = ((BlockItem) stack.getItem()).getBlock();
					return event.getBlockColors().getColor(block.defaultBlockState(), null, null, tintIndex);
				}, hedges);
			}
		}
	}
}