package fr.samlegamer.addonslib.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.common.extensions.IForgeItem;

public class BlockItemFuelInfo extends BlockItemInfo implements IForgeItem
{
	public BlockItemFuelInfo(Block p_40565_, Item.Properties p_40566_, String desc)
	{
		super(p_40565_, p_40566_, desc);
	}

	@Override
	public int getBurnTime(ItemStack itemStack, IRecipeType<?> recipeType)
	{
		return 300;
	}
}