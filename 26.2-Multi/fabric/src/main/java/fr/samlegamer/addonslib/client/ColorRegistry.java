package fr.samlegamer.addonslib.client;

import fr.addonslib.api.client.ObjectColor;
import fr.samlegamer.addonslib.Finder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.level.block.Block;
import java.util.List;

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
					BlockColorRegistry.register(List.of(BlockTintSources.foliage()), block);
				} else {
					BlockColorRegistry.register(List.of(BlockTintSources.constant(color)), block);
				}
			}
		}
	}
}