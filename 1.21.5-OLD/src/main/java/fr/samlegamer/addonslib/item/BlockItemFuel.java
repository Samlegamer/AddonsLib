package fr.samlegamer.addonslib.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
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
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
	{
		return this.burnTime;
	}
}