package fr.samlegamer.addonslib.generation.recipes;

import net.minecraft.data.IFinishedRecipe;
import net.minecraft.util.IItemProvider;

import java.util.function.Consumer;

public interface IRecipes {
    void recipeStonecutter(Consumer<IFinishedRecipe> exporter, IItemProvider result, IItemProvider firstItem, String originalMod, String mcwModid);
    void recipeShapedWithItems(Consumer<IFinishedRecipe> exporter, IItemProvider planks, String[] pattern, IItemProvider result, int count, String group, String originalMod, String mcwModid, IItemProvider... items);
    void recipeShapelessRecycle(Consumer<IFinishedRecipe> exporter, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String originalMod, String mcwModid);
    void recipeShapeless(Consumer<IFinishedRecipe> exporter, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String originalMod, String mcwModid);
}
