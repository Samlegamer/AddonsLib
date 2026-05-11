package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import java.util.function.Consumer;

public abstract class McwRecipes extends RecipeProvider implements IRecipes
{
    protected final RecipesUtils recipesUtils;

    public McwRecipes(DataGenerator dataGenerator) {
        super(dataGenerator);
        this.recipesUtils = new RecipesUtils(dataGenerator, this) {
        };
    }

    @Override
    public void recipeStonecutter(Consumer<FinishedRecipe> exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, String> doubleObject = recipesUtils.doubleObjectStonecutter(result, firstItem);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(c -> doubleObject.getFirst().save(c, doubleObject.getSecond())).generateAdvancement()
                .build(exporter, ResourceLocation.parse(doubleObject.getSecond()));
    }

    @Override
    public void recipeShapedWithItems(Consumer<FinishedRecipe> exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(doubleObject.getFirst()::save).generateAdvancement()
                .build(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapelessRecycle(Consumer<FinishedRecipe> exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(doubleObject.getFirst()::save).generateAdvancement()
                .build(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapeless(Consumer<FinishedRecipe> exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(doubleObject.getFirst()::save).generateAdvancement()
                .build(exporter, doubleObject.getSecond());
    }
}
