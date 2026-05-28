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
import org.jetbrains.annotations.NotNull;

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

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(!this.desc.isEmpty()) {
            tooltipComponents.add(this.getDescription().withStyle(ChatFormatting.GRAY));
        }
    }

    public @NotNull MutableComponent getDescription()
    {
        return Component.translatable(this.desc);
    }

    /*
     * Forge & Neoforge
     */
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
    {
        return this.burnTime;
    }
}