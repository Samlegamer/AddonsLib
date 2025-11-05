package fr.samlegamer.addonslib.generation.loot_tables;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

public class ReplaceDropModifierSerializer extends GlobalLootModifierSerializer<McwLootTables> {
    @Override
    public McwLootTables read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
        return new McwLootTables(ailootcondition);
    }

    @Override
    public JsonObject write(McwLootTables instance) {
        return makeConditions(instance.conditions());
    }
}
