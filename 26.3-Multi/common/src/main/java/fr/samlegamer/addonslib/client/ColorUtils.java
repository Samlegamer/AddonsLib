package fr.samlegamer.addonslib.client;

import fr.samlegamer.addonslib.Finder;
import net.minecraft.world.level.block.Block;

public class ColorUtils
{
	public static boolean isValidBlock(Block block) {
		return Finder.getIdOfBlock(block).endsWith("_hedge");
	}
}