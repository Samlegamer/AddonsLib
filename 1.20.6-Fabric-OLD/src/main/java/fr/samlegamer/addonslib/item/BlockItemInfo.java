package fr.samlegamer.addonslib.item;

import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class BlockItemInfo extends BlockItem
{
	private final String desc;
	
	public BlockItemInfo(Block p_40565_, Settings p_40566_, String desc)
	{
		super(p_40565_, p_40566_);
		this.desc = desc;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable(this.desc));
	}
}
