package fr.samlegamer.addonslib.item;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack p_77624_1_, World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_)
    {
        if(!this.desc.isEmpty()) {
            p_77624_3_.add(this.getDescription().withStyle(TextFormatting.GRAY));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getDescription()
    {
        return (IFormattableTextComponent)new TranslationTextComponent(this.desc);
    }

    /*
     * Forge
     */
    public int getBurnTime(ItemStack itemStack, IRecipeType<?> recipeType)
    {
        return this.burnTime;
    }
}