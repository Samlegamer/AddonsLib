package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.obj.DoubleObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import java.util.concurrent.CompletableFuture;

public abstract class McwRecipes extends FabricRecipeProvider implements IRecipes {

    public final RecipesUtils recipesUtils;
    protected final CompletableFuture<HolderLookup.Provider> registriesFuture;
    protected final BootstrapContext<Recipe<?>> recipes;
    protected final BootstrapContext<Advancement> advancements;

    public McwRecipes(FabricPackOutput fabricDataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture,
    HolderLookup.Provider provider, RecipeOutput recipeOutput, BootstrapContext<Recipe<?>> recipes,
    BootstrapContext<Advancement> advancements) {
        super(fabricDataOutput, registriesFuture);
        this.registriesFuture = registriesFuture;
        this.recipes = recipes;
        this.advancements = advancements;
        this.recipesUtils = new RecipesUtils(recipes, advancements, this) {
            @Override
            public void buildRecipes() {
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
        DoubleObject<RecipeBuilder, Identifier> doubleObject = recipesUtils.doubleObjectShapedWithItems(planks, pattern, result, count, group, items);
        doubleObject.getFirst().save(recipeExporter);
    }

    @Override
    public void recipeShapelessRecycle(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, Identifier> doubleObject = recipesUtils.doubleObjectShapelessRecycle(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(recipeExporter, doubleObject.getSecond().toString());
    }

    @Override
    public void recipeShapeless(RecipeOutput exporter, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String originalMod, String mcwModid) {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        DoubleObject<RecipeBuilder, Identifier> doubleObject = recipesUtils.doubleObjectShapeless(planks, result, count, firstItem, required, group);
        doubleObject.getFirst().save(recipeExporter);
    }
}
