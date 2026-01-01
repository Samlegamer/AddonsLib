package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import fr.addonslib.api.data.ModType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
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
public final class Registration
{
	private Registration() {}

	@Deprecated(forRemoval = true)
	public static ModType[] getAllModTypeWood()
	{
		return ModType.getAllModTypeWood();

	}

	@Deprecated(forRemoval = true)
	public static ModType[] getAllModTypeStone()
	{
		return ModType.getAllModTypeStone();
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
	 * Tab
	 */
	public static CreativeModeTab tabs(CreativeModeTabEvent.Register event, String MODID, String id, ItemLike icon)
	{
        return event.registerCreativeModeTab(new ResourceLocation(MODID, id), builder -> builder
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(MODID+"."+id)));
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
	
	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, SoundEvent close, SoundEvent open)
	{
		return getField(path, WOOD, new Class<?>[] {BlockBehaviour.Properties.class, SoundEvent.class, SoundEvent.class}, WOOD, close, open);
	}

	
	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, BlockState state)
	{
		return getField(path, WOOD, new Class<?>[] {BlockState.class, BlockBehaviour.Properties.class}, state, WOOD);
	}
}