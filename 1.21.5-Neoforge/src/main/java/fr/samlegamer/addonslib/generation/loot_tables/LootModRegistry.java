package fr.samlegamer.addonslib.generation.loot_tables;

import com.mojang.serialization.MapCodec;
import fr.samlegamer.addonslib.AddonsLib;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class LootModRegistry {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, AddonsLib.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE =
            SERIALIZERS.register("add_loot_table", McwLootTables.CODEC);

}
