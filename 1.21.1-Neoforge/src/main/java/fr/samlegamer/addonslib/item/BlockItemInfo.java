package fr.samlegamer.addonslib.item;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class BlockItemInfo extends BlockItem
{
	private String desc;
	
	public BlockItemInfo(Block p_40565_, Properties p_40566_, String desc)
	{
		super(p_40565_, p_40566_);
		this.desc = desc;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack p_43043_, @Nullable Level p_43044_, List<Component> p_43045_, TooltipFlag p_43046_)
	{
		p_43045_.add(this.getDescription().withStyle(ChatFormatting.GRAY));
	}

	@OnlyIn(Dist.CLIENT)
	public MutableComponent getDescription()
	{
		return (MutableComponent) Component.translatable(this.desc);
	}
}