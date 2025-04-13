package fr.samlegamer.addonslib.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class BlockItemInfo extends BlockItem
{
	private final String desc;
	
	public BlockItemInfo(Block p_40565_, Properties p_40566_, String desc)
	{
		super(p_40565_, p_40566_);
		this.desc = desc;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(@NotNull ItemStack p_40572_, @NotNull TooltipContext p_327780_, List<Component> p_40574_, @NotNull TooltipFlag p_40575_)
	{
		p_40574_.add(this.getDescription().withStyle(ChatFormatting.GRAY));
	}

	@OnlyIn(Dist.CLIENT)
	public MutableComponent getDescription()
	{
		return (MutableComponent) Component.translatable(this.desc);
	}
}