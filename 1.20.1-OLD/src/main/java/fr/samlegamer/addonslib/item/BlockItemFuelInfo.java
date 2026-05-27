package fr.samlegamer.addonslib.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.extensions.IForgeItem;

public class BlockItemFuelInfo extends BlockItemInfo implements IForgeItem
{
	public BlockItemFuelInfo(Block p_40565_, Properties p_40566_, String desc)
	{
		super(p_40565_, p_40566_, desc);
	}

	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
	{
		return 300;
	}
}