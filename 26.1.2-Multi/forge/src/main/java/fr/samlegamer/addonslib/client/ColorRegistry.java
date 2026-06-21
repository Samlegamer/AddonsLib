package fr.samlegamer.addonslib.client;

import fr.addonslib.api.client.ObjectColor;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
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
					event.register(List.of(BlockTintSources.foliage()), block);
				} else {
					event.register(List.of(BlockTintSources.constant(color)), block);
				}
			}
		}
	}
}