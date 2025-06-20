package fr.samlegamer.addonslib.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jetbrains.annotations.Nullable;

public class BlockItemFuelInfo extends BlockItemInfo implements IItemExtension
{
	public BlockItemFuelInfo(Block p_40565_, Properties p_40566_, String desc)
	{
		super(p_40565_, p_40566_, desc);
	}

	@Override
	public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues)
	{
		return 300;
	}
}