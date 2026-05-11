package fr.samlegamer.addonslib.client;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;

public class ColorUtils
{
	public static boolean isValidBlock(Block block) {
		return block instanceof LeavesBlock;
	}
}