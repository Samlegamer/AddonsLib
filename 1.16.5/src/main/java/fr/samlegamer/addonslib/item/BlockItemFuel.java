package fr.samlegamer.addonslib.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.common.extensions.IForgeItem;

public class BlockItemFuel extends BlockItem implements IForgeItem
{
	private final int burnTime;

	public BlockItemFuel(Block p_i48527_1_, Properties p_i48527_2_, int burnTime)
	{
		super(p_i48527_1_, p_i48527_2_);
		this.burnTime = burnTime;
	}

	public BlockItemFuel(Block p_i48527_1_, Properties p_i48527_2_)
	{
		this(p_i48527_1_, p_i48527_2_, 300);
    }

	@Override
	public int getBurnTime(ItemStack itemStack, IRecipeType<?> recipeType)
	{
		return this.burnTime;
	}
}
