package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;

/**
 * Used for easy registries
 */
public class Registration
{	
	public static Block getBlocksFieldFenceBlock(String path, AbstractBlock.Settings WOOD)
	{
        Class<?> classBase;
        Block block = new FenceBlock(WOOD);
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(AbstractBlock.Settings.class);
			block = (Block) constuctorBase.newInstance(WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new FenceBlock(WOOD);
		}
        return block;
	}

	
	public static Block getBlocksField(String path, AbstractBlock.Settings WOOD)
	{
        Class<?> classBase;
        Block block = new Block(WOOD);
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(AbstractBlock.Settings.class);
			block = (Block) constuctorBase.newInstance(WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new Block(WOOD);
		}
        return block;
	}
	
	public static Block getBlocksField(String path, AbstractBlock.Settings WOOD, BlockState state)
	{
        Class<?> classBase;
        Block block = new Block(WOOD);
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(BlockState.class, AbstractBlock.Settings.class);
			block = (Block) constuctorBase.newInstance(state, WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new Block(WOOD);
		}
        return block;
	}
}