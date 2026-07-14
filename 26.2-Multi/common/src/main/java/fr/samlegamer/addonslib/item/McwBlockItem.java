package fr.samlegamer.addonslib.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.NotNull;
import java.util.function.Consumer;

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
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_392123_, TooltipFlag p_41424_) {
        if(!this.desc.isEmpty()) {
            p_392123_.accept(this.getDescription().withStyle(ChatFormatting.GRAY));
        }
    }

    public @NotNull MutableComponent getDescription()
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

    /*
     * Neoforge
     */
    public int getBurnTime(@NotNull ItemStack itemStack, RecipeType<?> recipeType, @NotNull FuelValues fuelValues) {
        return this.burnTime;
    }
}