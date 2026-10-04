package fr.samlegamer.addonslib.generation.recipes;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.ItemLike;

public interface IRecipes {
    void recipeStonecutter(RecipeOutput exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid);
    void recipeShapedWithItems(RecipeOutput exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items);
    void recipeShapelessRecycle(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid);
    void recipeShapeless(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid);
}
