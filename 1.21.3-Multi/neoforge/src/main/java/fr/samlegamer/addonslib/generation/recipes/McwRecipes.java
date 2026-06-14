package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.AndCondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import java.util.List;

public abstract class McwRecipes extends RecipeProvider implements IRecipes
{
    protected final RecipesUtils recipesUtils;

    protected McwRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
        this.recipesUtils = new RecipesUtils(provider, recipeOutput, this) {
            @Override
            protected void buildRecipes() {
            }
        };
    }

    @Override
    public void recipeStonecutter(RecipeOutput exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, String> doubleObject = recipesUtils.doubleObjectStonecutter(result, firstItem);
        doubleObject.getFirst().save(exporter.withConditions(new AndCondition(List.of(
                new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod)))),
                doubleObject.getSecond());
    }

    @Override
    public void recipeShapedWithItems(RecipeOutput exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        doubleObject.getFirst().save(exporter.withConditions(new AndCondition(List.of(
                new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod)))),
                doubleObject.getSecond().toString());
    }

    @Override
    public void recipeShapelessRecycle(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(exporter.withConditions(new AndCondition(List.of(
                new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod)))),
                doubleObject.getSecond().toString());
    }

    @Override
    public void recipeShapeless(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(exporter.withConditions(new AndCondition(List.of(
                        new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod)))),
                doubleObject.getSecond().toString());
    }
}