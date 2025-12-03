package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import fr.addonslib.api.data.ModType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
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

    public static ModType[] getAllModTypeWood()
    {
        return new ModType[] {ModType.BRIDGES, ModType.ROOFS, ModType.FENCES, ModType.FURNITURES,
                ModType.STAIRS, ModType.PATHS, ModType.TRAPDOORS, ModType.DOORS, ModType.WINDOWS};
    }

    public static ModType[] getAllModTypeStone()
    {
        return new ModType[] {ModType.ROOFS, ModType.FENCES, ModType.BRIDGES};
    }

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

	public static Block getField(String path, AbstractBlock.Properties prop, Class<?>[] params, Object... values)
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
	
	public static Block getBlocksField(String path, AbstractBlock.Properties WOOD)
	{
		return getField(path, WOOD, new Class<?>[] {AbstractBlock.Properties.class}, WOOD);
	}
	
	public static Block getBlocksField(String path, AbstractBlock.Properties WOOD, BlockState state)
	{
		return getField(path, WOOD, new Class<?>[] {BlockState.class, AbstractBlock.Properties.class}, state, WOOD);
	}
}