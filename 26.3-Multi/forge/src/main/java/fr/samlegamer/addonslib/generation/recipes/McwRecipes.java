package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import java.util.List;

public abstract class McwRecipes extends RecipeProvider implements IRecipes
{
    protected final RecipesUtils recipesUtils;

    protected McwRecipes(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
        this.recipesUtils = new RecipesUtils(recipeOutput, advancementOutput, this) {
            @Override
            protected void buildRecipes() {
            }
        };
    }

    @Override
    public void recipeStonecutter(RecipeOutput exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, String> doubleObject = recipesUtils.doubleObjectStonecutter(result, firstItem);
        ConditionalRecipe.builder(exporter)
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(c -> doubleObject.getFirst().save(c, doubleObject.getSecond()))
                .save(exporter, Identifier.parse(doubleObject.getSecond()));
    }

    @Override
    public void recipeShapedWithItems(RecipeOutput exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items) {
        DoubleObject<RecipeBuilder, Identifier> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        ConditionalRecipe.builder(exporter)
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(doubleObject.getFirst()::save)
                .save(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapelessRecycle(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, Identifier> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder(exporter)
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(doubleObject.getFirst()::save)
                .save(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapeless(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, Identifier> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder(exporter)
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(doubleObject.getFirst()::save)
                .save(exporter, doubleObject.getSecond());
    }
}