package fr.samlegamer.addonslib.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import org.jetbrains.annotations.NotNull;
import java.util.function.Consumer;

public class McwBlockItem extends BlockItem
{
    private final String desc;

    public McwBlockItem(Block block, Properties properties, String desc, int burnTime, boolean isWoodenItem) {
        super(block, isWoodenItem ? properties.cookingFuel(burnTime == 50 ? ContextIntProviders.COOKING_TIME_WOOL_SLABS :
        ContextIntProviders.COOKING_TIME_WOOD_BLOCKS) : properties);
        this.desc = desc;
    }

    public McwBlockItem(Block block, Properties properties, boolean isWoodenItem)
    {
        this(block, properties, "", 0, isWoodenItem);
    }

    public McwBlockItem(Block block, Properties properties, String desc, boolean isWoodenItem)
    {
        this(block, properties, desc, 0, isWoodenItem);
    }


    public McwBlockItem(Block block, Properties properties, int burnTime)
    {
        this(block, properties, "", burnTime, true);
    }

    public McwBlockItem(Block block, Properties properties, String desc)
    {
        this(block, properties, desc, 300, true);
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

//    /*
//     * Forge
//     */
//    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
//    {
//        return this.burnTime;
//    }
//
//    /*
//     * Neoforge
//     */
//    public int getBurnTime(@NotNull ItemStack itemStack, RecipeType<?> recipeType, @NotNull FuelValues fuelValues) {
//        return this.burnTime;
//    }
}