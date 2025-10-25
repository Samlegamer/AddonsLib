package fr.samlegamer.addonslib.generation.loot_tables;

import fr.samlegamer.addonslib.AddonsLib;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LootModRegistry {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, AddonsLib.MODID);

    public static final RegistryObject<GlobalLootModifierSerializer<?>> ADD_LOOT_TABLE =
            SERIALIZERS.register("add_loot_table", ReplaceDropModifierSerializer::new);

}
