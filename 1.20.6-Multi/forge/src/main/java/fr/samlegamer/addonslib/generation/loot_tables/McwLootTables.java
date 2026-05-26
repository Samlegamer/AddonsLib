package fr.samlegamer.addonslib.generation.loot_tables;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class McwLootTables extends LootModifier
{
    public static final Supplier<MapCodec<McwLootTables>> CODEC = Suppliers.memoize(() -> MapCodec.assumeMapUnsafe(RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, McwLootTables::new))));
    public static final LootTableUtils LOOT_TABLE_UTILS = new LootTableUtils();

    protected McwLootTables(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    public LootItemCondition[] conditions() {
        return this.conditions;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        return LOOT_TABLE_UTILS.doApply(generatedLoot, context);
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}