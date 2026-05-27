package fr.samlegamer.addonslib.generation.loot_tables;

import com.mojang.serialization.Codec;
import fr.samlegamer.addonslib.AddonsLib;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class LootModRegistry {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, AddonsLib.MODID);

    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE =
            SERIALIZERS.register("add_loot_table", McwLootTables.CODEC);

}
