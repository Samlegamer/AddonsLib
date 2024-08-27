package fr.samlegamer.addonslib.tab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public class TabUtils
{
	public static ItemGroup tab(String MODID, IItemProvider itm)
	{
		return new ItemGroup(MODID + "_tab") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(itm);
            }
        };
	}
}
