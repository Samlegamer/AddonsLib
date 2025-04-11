package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Used for easy registries
 */
public class Registration
{
	/**
	 * Block
	 */
	public static DeferredRegister.Blocks blocks(String MODID)
	{
		return DeferredRegister.createBlocks(MODID);
	}
	
	/**
	 * Item
	 */
	public static DeferredRegister.Items items(String MODID)
	{
		return DeferredRegister.createItems(MODID);
	}
	
	public static DeferredRegister<CreativeModeTab> creativeModeTab(String MODID)
	{
		return DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
	}
	
	/**
	 * Tab
	 */
	public static DeferredHolder<CreativeModeTab, CreativeModeTab> tabs(DeferredRegister<CreativeModeTab> Item_Group, String MODID, String id, ItemLike icon)
	{
		return Item_Group.register(id, () -> CreativeModeTab.builder().title(Component.translatable(MODID+"."+id)).icon(()-> new ItemStack(icon)).build());
	}
	/**
	 * register
	 */
	public static void init(@Nonnull IEventBus bus, DeferredRegister.Blocks b, DeferredRegister.Items i, DeferredRegister<CreativeModeTab> t)
	{
		b.register(bus);
		i.register(bus);
		t.register(bus);
	}
	
	public static Block getBlocksFieldForFences(String path, BlockBehaviour.Properties WOOD)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constructorBase;
        
		try {
			classBase = Class.forName(path);
			constructorBase = classBase.getConstructor(BlockBehaviour.Properties.class);
			block = (Block) constructorBase.newInstance(WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new FenceBlock(WOOD);
		}
        return block;
	}

	
	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(BlockBehaviour.Properties.class);
			block = (Block) constuctorBase.newInstance(WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new Block(WOOD);
		}
        return block;
	}
	
	public static Block getBlocksFieldDoors(String path, BlockBehaviour.Properties WOOD, BlockSetType set)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(BlockBehaviour.Properties.class, BlockSetType.class);
			block = (Block) constuctorBase.newInstance(WOOD, set);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new Block(WOOD);
		}
        return block;
	}

	
	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, BlockState state)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(BlockState.class, BlockBehaviour.Properties.class);
			block = (Block) constuctorBase.newInstance(state, WOOD);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			block = new Block(WOOD);
		}
        return block;
	}
}