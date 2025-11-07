package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.data.ModType;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SingleItemRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class McwRecipes extends FabricRecipeProvider {
    private final String modid;
    private final String mcwModid;
    private final String originalMod;
    private static FabricDataGenerator dataGen;

    public McwRecipes(FabricDataGenerator output, String modid, String mcwModid, String originalMod) {
        super(output);
        this.modid = modid;
        this.mcwModid = mcwModid;
        this.originalMod = originalMod;
        dataGen = output;
    }

    private static AbstractType getFromModType(ModType modType, String modid, String originalMod)
    {
        return switch (modType) {
            case BRIDGES -> new Bridges(dataGen, modid, originalMod);
            case DOORS -> new Doors(dataGen, modid, originalMod);
            case FENCES -> new Fences(dataGen, modid, originalMod);
            case FURNITURES -> new Furnitures(dataGen, modid, originalMod);
            case PATHS -> new Paths(dataGen, modid, originalMod);
            case ROOFS -> new Roofs(dataGen, modid, originalMod);
            case STAIRS -> new Stairs(dataGen, modid, originalMod);
            case TRAPDOORS -> new Trapdoors(dataGen, modid, originalMod);
            case WINDOWS -> new Windows(dataGen, modid, originalMod);
            default -> null;
        };
    }

    public static void onRegisterMcwWood(ModType modType, Consumer<RecipeJsonProvider> consumer, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildWood(consumer, MAT, woodMats);
        }
    }

    public static void onRegisterMcwStone(ModType modType, Consumer<RecipeJsonProvider> consumer, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildStone(consumer, MAT, stoneMats);
        }
    }

    public static void registerAllMcwWood(Consumer<RecipeJsonProvider> consumer, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        onRegisterMcwWood(ModType.BRIDGES, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.DOORS, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.FENCES, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.FURNITURES, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.PATHS, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.ROOFS, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.STAIRS, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.TRAPDOORS, consumer, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.WINDOWS, consumer, modid, originalMod, MAT, woodMats);
    }

    public static void registerAllMcwStone(Consumer<RecipeJsonProvider> consumer, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        onRegisterMcwStone(ModType.BRIDGES, consumer, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.ROOFS, consumer, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.FENCES, consumer, modid, originalMod, MAT, stoneMats);
    }

    public static void registerMcwHedge(Consumer<RecipeJsonProvider> consumer, String modid, String originalMod, List<String> MAT, List<Block> leave)
    {
        AbstractType abstractType = getFromModType(ModType.FENCES, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildHedge(consumer, MAT, leave);
        }
    }

    protected void mkScW1Item(Consumer<RecipeJsonProvider> exporter, ItemConvertible result, ItemConvertible firstItem)
    {
        String recipeId = this.modid + ":" + Objects.requireNonNull(result.asItem().toString()) + "_stonecutter";
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));

        SingleItemRecipeJsonBuilder builder = SingleItemRecipeJsonBuilder.createStonecutting(
                Ingredient.ofItems(firstItem), result)
                .criterion("has_stone", conditionsFromItem(firstItem));

        builder.offerTo(recipeExporter, new Identifier(recipeId));
    }

    protected void mkRpW3Items(Consumer<RecipeJsonProvider> exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, ItemConvertible thirdItem, String group)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .input('A', firstItem)
                                    .input('B', secondItem)
                                    .input('C', thirdItem)
                                    .group(group)
                                    .criterion("has_item", conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .group(group)
                    .criterion("has_item", conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .group(group)
                    .criterion("has_item", conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter, new Identifier(result.asItem().toString()));
    }

    protected void mkRpW2Items(Consumer<RecipeJsonProvider> exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, String group)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .input('A', firstItem)
                                    .input('B', secondItem)
                                    .group(group)
                                    .criterion("has_item", conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .group(group)
                    .criterion("has_item", conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .group(group)
                    .criterion("has_item", conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter, new Identifier(result.asItem().toString()));
    }

    protected void mkRpW1Item(Consumer<RecipeJsonProvider> exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, String group, String suffix)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(result, count)
                .pattern(pattern[0])
                .input('A', firstItem)
                .group(group)
                .criterion("has_item", conditionsFromItem(planks));

        shapedRecipeJsonBuilder.offerTo(recipeExporter, new Identifier(result.asItem().toString() + suffix));
    }

    protected void mkRpShapelessW1Item(Consumer<RecipeJsonProvider> exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, int required, String group, String suffix)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapelessRecipeJsonBuilder shapelessRecipeJsonBuilder =
                ShapelessRecipeJsonBuilder.create(result, count)
                .input(firstItem, required)
                .group(group)
                .criterion("has_item", conditionsFromItem(planks));

        shapelessRecipeJsonBuilder.offerTo(recipeExporter, new Identifier(result.asItem().toString() + suffix));
    }

    protected void mkRpShapelessW1Item(Consumer<RecipeJsonProvider> exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, String group, String suffix)
    {
        mkRpShapelessW1Item(exporter, planks, result, count, firstItem, 1, group, suffix);
    }

    protected void mkRpW1Item(Consumer<RecipeJsonProvider> exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, String group)
    {
        mkRpW1Item(exporter, planks, pattern, result, count, firstItem, group, "");
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

    }
}
