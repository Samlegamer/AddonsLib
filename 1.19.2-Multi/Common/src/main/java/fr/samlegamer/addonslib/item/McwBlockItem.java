package fr.samlegamer.addonslib.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import javax.annotation.Nullable;
import java.util.List;

public class McwBlockItem extends BlockItem
{
    private final String desc;
    private final int burnTime;

    public McwBlockItem(Block block, Properties properties, String desc, int burnTime) {
        super(block, properties);
        this.desc = desc;
        this.burnTime = burnTime;
    }

    public McwBlockItem(Block block, Properties properties, boolean isWoodenItem)
    {
        this(block, properties, "", isWoodenItem ? 300 : 0);
    }

    public McwBlockItem(Block block, Properties properties, int burnTime)
    {
        this(block, properties, "", burnTime);
    }

    public McwBlockItem(Block block, Properties properties, String desc)
    {
        this(block, properties, desc, 300);
    }

    public int getBurnTime() {
        return burnTime;
    }

    public String getDesc() {
        return desc;
    }

    public void appendHoverText(ItemStack p_43043_, @Nullable Level p_43044_, List<Component> p_43045_, TooltipFlag p_43046_)
    {
        p_43045_.add(this.getDescription().withStyle(ChatFormatting.GRAY));
    }

    public MutableComponent getDescription()
    {
        return Component.translatable(this.desc);
    }

    /*
     * Forge
     */
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
    {
        return this.burnTime;
    }
}