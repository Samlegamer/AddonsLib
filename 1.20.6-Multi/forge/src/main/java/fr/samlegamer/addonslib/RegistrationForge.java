package fr.samlegamer.addonslib;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Used for easy registries
 */
public final class RegistrationForge
{
	private RegistrationForge() {}

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
	public static void init(FMLJavaModLoadingContext javaModLoadingContext, DeferredRegister<Block> b, DeferredRegister<Item> i, DeferredRegister<CreativeModeTab> t)
	{
		IEventBus bus = javaModLoadingContext.getModEventBus();
		b.register(bus);
		i.register(bus);
		t.register(bus);
	}
}