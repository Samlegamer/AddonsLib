package fr.samlegamer.addonslib;

import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nonnull;

/**
 * Used for easy registries
 */
public final class RegistrationNeoForge
{
	private RegistrationNeoForge() {}

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
}