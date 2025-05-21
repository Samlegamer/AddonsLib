package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import fr.samlegamer.addonslib.data.ModType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Used for easy registries
 */
public final class Registration
{
	private Registration() {}
	/**
	 * Block
	 */
	public static DeferredRegister<Block> blocks(String MODID)
	{
		return DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	}
	
	/**
	 * Item
	 */
	public static DeferredRegister<Item> items(String MODID)
	{
		return DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	}
	
	/**
	 * register
	 */
	public static void init(DeferredRegister<Block> b, DeferredRegister<Item> i)
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		b.register(bus);
		i.register(bus);
	}

	public static ModType[] getAllModTypeWood()
	{
		return new ModType[] {ModType.BRIDGES, ModType.ROOFS, ModType.FENCES, ModType.FURNITURES,
				ModType.STAIRS, ModType.PATHS, ModType.TRAPDOORS, ModType.DOORS, ModType.WINDOWS};
	}

	public static ModType[] getAllModTypeStone()
	{
		return new ModType[] {ModType.ROOFS, ModType.FENCES, ModType.BRIDGES};
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
			//AddonsLib.LOGGER.error("Error while creating block " + path + " using default constructor");
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