package fr.samlegamer.addonslib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import fr.samlegamer.addonslib.data.ModType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
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
public final class Registration
{
	private Registration() {}

    public static ModType[] getAllModTypeWood()
    {
        return new ModType[]{ModType.ROOFS, ModType.FENCES, ModType.BRIDGES, ModType.FURNITURES,
                ModType.WINDOWS, ModType.DOORS, ModType.TRAPDOORS, ModType.PATHS, ModType.STAIRS};
    }

    public static ModType[] getAllModTypeStone()
    {
        return new ModType[]{ModType.ROOFS, ModType.FENCES, ModType.BRIDGES};
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
	
	public static DeferredRegister<CreativeModeTab> creativeModeTab(String MODID)
	{
		return DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
	}
	
	/**
	 * Tab
	 */
	public static RegistryObject<CreativeModeTab> tabs(DeferredRegister<CreativeModeTab> event, String MODID, String id, ItemLike icon)
	{
        return event.register(id, () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(MODID+"."+id)).build());
	}

	/**
	 * register
	 */
	public static void init(FMLJavaModLoadingContext fmlJavaModLoadingContext, DeferredRegister<Block> b, DeferredRegister<Item> i, DeferredRegister<CreativeModeTab> t)
	{
		IEventBus bus = fmlJavaModLoadingContext.getModEventBus();
		b.register(bus);
		i.register(bus);
		t.register(bus);
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
	
	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, BlockSetType set)
	{
		return getField(path, WOOD, new Class<?>[] {BlockBehaviour.Properties.class, BlockSetType.class}, WOOD, set);
	}

	public static Block getBlocksField(String path, BlockBehaviour.Properties WOOD, BlockState state)
	{
		return getField(path, WOOD, new Class<?>[] {BlockState.class, BlockBehaviour.Properties.class}, state, WOOD);
	}
}