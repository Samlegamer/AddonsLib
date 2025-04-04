package fr.samlegamer.addonslib.item;

import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class BlockItemInfo extends BlockItem
{
	private String desc;
	
	public BlockItemInfo(Block p_40565_, Settings p_40566_, String desc)
	{
		super(p_40565_, p_40566_);
		this.desc = desc;
	}

	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
	{
		tooltip.add(new TranslatableText(this.desc));
	}
}
