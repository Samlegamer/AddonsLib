package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import fr.samlegamer.addonslib.item.McwBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Used for easy registries
 */
public final class Registration
{
	private Registration() {}

	public static McwBlockItem createBlockItemWood(String name, Block block, CreativeModeTab tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
	{
		Item.Properties properties = new Item.Properties();
		if(isModMcwLoaded && isModBaseLoaded)
		{
			properties.tab(tab);
			if (name.contains("log_bridge_middle") || name.startsWith("rope_")) {
				return new McwBlockItem(block, properties, "mcwbridges.bridges.desc");
			} else if (name.endsWith("planks_path")) {
				return new McwBlockItem(block, properties, 50);
			} else if (name.contains("railing")) {
				return new McwBlockItem(block, properties, "mcwstairs.railing.desc");
			} else if (name.contains("balcony")) {
				return new McwBlockItem(block, properties, "mcwstairs.balcony.desc");
			} else if (name.contains("platform")) {
				return new McwBlockItem(block, properties, "mcwstairs.platform.desc");
			} else {
				return new McwBlockItem(block, properties, true);
			}
		}
		else {
			return new McwBlockItem(block, properties, true);
		}
	}

	public static McwBlockItem createBlockItemStone(String name, Block block, CreativeModeTab tab, boolean isModMcwLoaded, boolean isModBaseLoaded)
	{
		Item.Properties properties = new Item.Properties();
		if(isModMcwLoaded && isModBaseLoaded)
		{
			properties.tab(tab);
			if(name.contains("railing") && !name.contains("wall")) {
				return new McwBlockItem(block, properties, "mcwstairs.railing.desc", 0);
			}
			else if(name.contains("balcony")) {
				return new McwBlockItem(block, properties, "mcwstairs.balcony.desc", 0);
			}
			else if(name.contains("platform")) {
				return new McwBlockItem(block, properties, "mcwstairs.platform.desc", 0);
			}
			else {
				return new McwBlockItem(block, properties, 0);
			}
		}
		else {
			return new McwBlockItem(block, properties, 0);
		}
	}

	public static Block getField(String path, BlockBehaviour.Properties prop, Class<?>[] params, Object... values)
	{
		Class<?> classBase;
		Block block;
		Constructor<?> constructorBase;

		try {
			classBase = Class.forName(path);
			constructorBase = classBase.getConstructor(params);
			block = (Block) constructorBase.newInstance(values);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			AddonsLib.LOGGER.error(e);
			block = new Block(prop);
		}
		return block;
	}

	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD)
	{
		return getField(path, WOOD, new Class<?>[] {BlockBehaviour.Properties.class}, WOOD);
	}

	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, BlockState state)
	{
		return getField(path, WOOD, new Class<?>[] {BlockState.class, BlockBehaviour.Properties.class}, state, WOOD);
	}
}