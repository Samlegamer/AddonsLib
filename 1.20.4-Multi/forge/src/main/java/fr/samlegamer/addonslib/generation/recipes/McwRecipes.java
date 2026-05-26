package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import java.util.List;

public abstract class McwRecipes extends RecipeProvider implements IRecipes
{
    protected final RecipesUtils recipesUtils;

    public McwRecipes(PackOutput packOutput) {
        super(packOutput);
        this.recipesUtils = new RecipesUtils(packOutput, this) {
            @Override
            protected void buildRecipes(RecipeOutput p_297267_) {
                
            }
        };
    }

    @Override
    public void recipeStonecutter(RecipeOutput exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, String> doubleObject = recipesUtils.doubleObjectStonecutter(result, firstItem);
        ConditionalRecipe.builder()
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(c -> doubleObject.getFirst().save(c, doubleObject.getSecond()))
                .save(exporter, new ResourceLocation(doubleObject.getSecond()));
    }

    @Override
    public void recipeShapedWithItems(RecipeOutput exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        ConditionalRecipe.builder()
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(doubleObject.getFirst()::save)
                .save(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapelessRecycle(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder()
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(doubleObject.getFirst()::save)
                .save(exporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapeless(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        ConditionalRecipe.builder()
                .condition(new AndCondition(List.of(new ModLoadedCondition(mcwModid), new ModLoadedCondition(originalMod))))
                .recipe(doubleObject.getFirst()::save)
                .save(exporter, doubleObject.getSecond());
    }
}