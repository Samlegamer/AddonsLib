package fr.samlegamer.addonslib.generation.loot_tables;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.LootModifier;
import javax.annotation.Nonnull;
import java.util.*;

public class McwLootTables extends LootModifier
{
    public static final LootTableUtils LOOT_TABLE_UTILS = new LootTableUtils();

    protected McwLootTables(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    public ILootCondition[] conditions() {
        return this.conditions;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext lootContext) {
        return LOOT_TABLE_UTILS.doApply(generatedLoot, lootContext);
    }
}
