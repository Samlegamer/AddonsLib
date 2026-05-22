package fr.samlegamer.addonslib.generation.loot_tables;

import com.mojang.serialization.Codec;
import fr.samlegamer.addonslib.AddonsLib;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModRegistry {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, AddonsLib.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE =
            SERIALIZERS.register("add_loot_table", McwLootTables.CODEC);

}
