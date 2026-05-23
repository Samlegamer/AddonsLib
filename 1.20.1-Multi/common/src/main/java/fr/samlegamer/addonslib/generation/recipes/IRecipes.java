package fr.samlegamer.addonslib.generation.recipes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public interface IRecipes {
    void recipeStonecutter(Consumer<FinishedRecipe> exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid);
    void recipeShapedWithItems(Consumer<FinishedRecipe> exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items);
    void recipeShapelessRecycle(Consumer<FinishedRecipe> exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid);
    void recipeShapeless(Consumer<FinishedRecipe> exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid);
}
