package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
	
	public static DeferredRegister<CreativeModeTab> creativeModeTab(String MODID)
	{
		return DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
	}
	
	/**
	 * Tab
	 */
	public static RegistryObject<CreativeModeTab> tabs(DeferredRegister<CreativeModeTab> event, String MODID, String id, ItemLike icon)
	{
		RegistryObject<CreativeModeTab> tab = event.register(id, () -> CreativeModeTab.builder()
		        .icon(() -> new ItemStack(icon))
		        .title(Component.translatable(MODID+"."+id)).build());
		return tab;
	}
	/**
	 * register
	 */
	public static void init(DeferredRegister<Block> b, DeferredRegister<Item> i, DeferredRegister<CreativeModeTab> t)
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
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