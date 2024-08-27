package fr.samlegamer.addonslib.tab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

/*
 * For Reduce extends with ItemGroup use this simplified method
 */
public class AddonsTab extends ItemGroup
{
	protected final IItemProvider itm;
	
	public AddonsTab(String label, IItemProvider icon)
	{
		super(label);
		this.itm=icon;
	}

	@Override
	public ItemStack makeIcon()
	{
		return new ItemStack(itm);
	}
}
