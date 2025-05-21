package fr.samlegamer.addonslib.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class BlockItemInfo extends BlockItem
{
	private final String desc;
	
	public BlockItemInfo(Block p_40565_, Properties p_40566_, String desc)
	{
		super(p_40565_, p_40566_);
		this.desc = desc;
	}

	@Override
	public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
		pTooltipComponents.add(this.getDescription().withStyle(ChatFormatting.GRAY));
	}

	@OnlyIn(Dist.CLIENT)
	public MutableComponent getDescription()
	{
		return (MutableComponent) Component.translatable(this.desc);
	}
}