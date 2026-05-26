package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import java.util.concurrent.CompletableFuture;

public abstract class McwRecipes extends FabricRecipeProvider implements IRecipes {

    protected final RecipesUtils recipesUtils;

    public McwRecipes(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
        this.recipesUtils = new RecipesUtils(output, registriesFuture, this) {
            @Override
            public void buildRecipes(RecipeOutput recipeOutput) {

            }
        };
    }

    @Override
    public void recipeStonecutter(RecipeOutput exporter, ItemLike result, ItemLike firstItem, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, String> doubleObject = recipesUtils.doubleObjectStonecutter(result, firstItem);
        doubleObject.getFirst().save(recipeExporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapedWithItems(RecipeOutput exporter, ItemLike planks, String[] pattern, ItemLike result, int count, String group, String originalMod, String mcwModid, ItemLike... items) {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        doubleObject.getFirst().save(recipeExporter);
    }

    @Override
    public void recipeShapelessRecycle(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(recipeExporter, doubleObject.getSecond());
    }

    @Override
    public void recipeShapeless(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, ResourceLocation> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(recipeExporter, doubleObject.getSecond());
    }
}
