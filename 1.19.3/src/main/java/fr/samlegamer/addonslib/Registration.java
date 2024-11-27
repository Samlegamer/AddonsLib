package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Used for easy registries
 */
public class Registration
{
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
	 * Tab
	 */
	public static CreativeModeTab tabs(CreativeModeTabEvent.Register event, String MODID, String id, ItemLike icon)
	{
		CreativeModeTab tab = event.registerCreativeModeTab(new ResourceLocation(MODID, id), builder -> builder
		        .icon(() -> new ItemStack(icon))
		        .title(Component.translatable(MODID+"."+id)));
		return tab;
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
	
	public static Block getBlocksFieldDoors(String path, BlockBehaviour.Properties WOOD, SoundEvent close, SoundEvent open)
	{
        Class<?> classBase;
        Block block;
        Constructor<?> constuctorBase;

		try {
			classBase = Class.forName(path);
			constuctorBase = classBase.getConstructor(BlockBehaviour.Properties.class, SoundEvent.class, SoundEvent.class);
			block = (Block) constuctorBase.newInstance(WOOD, close, open);
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