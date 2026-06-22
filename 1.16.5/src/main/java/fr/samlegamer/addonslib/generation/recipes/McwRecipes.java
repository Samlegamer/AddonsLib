package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.minecraft.data.*;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
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
    public void recipeStonecutter(Consumer<IFinishedRecipe> exporter, IItemProvider result, IItemProvider firstItem, String originalMod, String mcwModid) {
        DoubleObject<SingleItemRecipeBuilder, String> doubleObject = recipesUtils.doubleObjectStonecutter(result, firstItem);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(c -> doubleObject.getFirst().save(c, doubleObject.getSecond())).generateAdvancement()
                .build(exporter, new ResourceLocation(doubleObject.getSecond()));
    }

    @Override
    public void recipeShapedWithItems(Consumer<IFinishedRecipe> exporter, IItemProvider planks, String[] pattern, IItemProvider result, int count, String group, String originalMod, String mcwModid, IItemProvider... items) {
        DoubleObject<ShapedRecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(doubleObject.getFirst()::save).generateAdvancement()
                .build(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapelessRecycle(Consumer<IFinishedRecipe> exporter, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<ShapelessRecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(doubleObject.getFirst()::save).generateAdvancement()
                .build(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapeless(Consumer<IFinishedRecipe> exporter, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<ShapelessRecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwModid)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(doubleObject.getFirst()::save).generateAdvancement()
                .build(exporter, doubleObject.getSecond());
    }
}
