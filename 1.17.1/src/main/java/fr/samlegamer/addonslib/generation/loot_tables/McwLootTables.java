package fr.samlegamer.addonslib.generation.loot_tables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import javax.annotation.Nonnull;
import java.util.*;

public class McwLootTables extends LootModifier
{
    public static final LootTableUtils LOOT_TABLE_UTILS = new LootTableUtils();

    protected McwLootTables(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    public LootItemCondition[] conditions() {
        return this.conditions;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext lootContext) {
        return LOOT_TABLE_UTILS.doApply(generatedLoot, lootContext);
    }
}
