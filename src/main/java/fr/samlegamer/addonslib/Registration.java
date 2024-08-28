package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * Used for easy registries
 */
public class Registration
{
	/*
	 * block
	 */
	public static DeferredRegister<Block> blocks(String MODID)
	{
		return DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	}
	
	/*
	 * Item
	 */
	public static DeferredRegister<Item> items(String MODID)
	{
		return DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	}
	
	/*
	 * register
	 */
	public static void init(DeferredRegister<Block> b, DeferredRegister<Item> i)
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		b.register(bus);
		i.register(bus);
	}
	
	public static Block getBlocksField(String path, AbstractBlock.Properties WOOD, Block transform)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(AbstractBlock.Properties.class);
			block = (Block) constuctorBase.newInstance(WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = transform;
		}
        return block;
	}

	
	public static Block getBlocksField(String path, AbstractBlock.Properties WOOD)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(AbstractBlock.Properties.class);
			block = (Block) constuctorBase.newInstance(WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new Block(WOOD);
		}
        return block;
	}
	
	public static Block getBlocksField(String path, AbstractBlock.Properties WOOD, BlockState state)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(BlockState.class, AbstractBlock.Properties.class);
			block = (Block) constuctorBase.newInstance(state, WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new Block(WOOD);
		}
        return block;
	}

}
