package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import java.util.function.Consumer;

public abstract class McwRecipes extends FabricRecipeProvider implements IRecipes {

    protected final RecipesUtils recipesUtils;

    public McwRecipes(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
        this.recipesUtils = new RecipesUtils(dataGenerator, this) {
        };
    }

    @Override
    public void recipeStonecutter(Consumer<FinishedRecipe> exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, String> doubleObject = recipesUtils.doubleObjectStonecutter(result, firstItem);
        doubleObject.getFirst().save(recipeExporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapedWithItems(Consumer<FinishedRecipe> exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items) {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        doubleObject.getFirst().save(recipeExporter);
    }

    @Override
    public void recipeShapelessRecycle(Consumer<FinishedRecipe> exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(recipeExporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapeless(Consumer<FinishedRecipe> exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(recipeExporter, doubleObject.getSecond());
    }
}
