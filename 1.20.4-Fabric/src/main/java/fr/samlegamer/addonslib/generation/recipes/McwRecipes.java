package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.data.ModType;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import java.util.List;
import java.util.Objects;

public class McwRecipes extends FabricRecipeProvider {
    private final String modid;
    private final String mcwModid;
    private final String originalMod;

    public McwRecipes(FabricDataOutput output, String modid, String mcwModid, String originalMod) {
        super(output);
        this.modid = modid;
        this.mcwModid = mcwModid;
        this.originalMod = originalMod;
    }

    private AbstractType getFromModType(ModType modType, String modid, String originalMod)
    {
        return switch (modType) {
            case BRIDGES -> new Bridges(output, modid, originalMod);
            case DOORS -> new Doors(output, modid, originalMod);
            case FENCES -> new Fences(output, modid, originalMod);
            case FURNITURES -> new Furnitures(output, modid, originalMod);
            case PATHS -> new Paths(output, modid, originalMod);
            case ROOFS -> new Roofs(output, modid, originalMod);
            case STAIRS -> new Stairs(output, modid, originalMod);
            case TRAPDOORS -> new Trapdoors(output, modid, originalMod);
            case WINDOWS -> new Windows(output, modid, originalMod);
            default -> null;
        };
    }

    public void onRegisterMcwWood(ModType modType, RecipeExporter exporter, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildWood(exporter, MAT, woodMats);
        }
    }

    public void onRegisterMcwStone(ModType modType, RecipeExporter exporter, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildStone(exporter, MAT, stoneMats);
        }
    }

    public void registerAllMcwWood(RecipeExporter exporter, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        onRegisterMcwWood(ModType.BRIDGES, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.DOORS, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.FENCES, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.FURNITURES, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.PATHS, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.ROOFS, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.STAIRS, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.TRAPDOORS, exporter, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.WINDOWS, exporter, modid, originalMod, MAT, woodMats);
    }

    public void registerAllMcwStone(RecipeExporter exporter, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        onRegisterMcwStone(ModType.BRIDGES, exporter, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.ROOFS, exporter, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.FENCES, exporter, modid, originalMod, MAT, stoneMats);
    }

    public void registerMcwHedge(RecipeExporter exporter, String modid, String originalMod, List<String> MAT, List<Block> leave)
    {
        AbstractType abstractType = getFromModType(ModType.FENCES, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildHedge(exporter, MAT, leave);
        }
    }

    protected void mkScW1Item(RecipeExporter exporter, ItemConvertible result, ItemConvertible firstItem)
    {
        String recipeId = Objects.requireNonNull(result.asItem().toString()) + "_stonecutter";
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));

        SingleItemRecipeJsonBuilder builder = SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(firstItem), RecipeCategory.BUILDING_BLOCKS, result)
                .criterion(hasItem(firstItem), conditionsFromItem(firstItem));

        builder.offerTo(recipeExporter, recipeId);
    }

    protected void mkRpW4Items(RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, ItemConvertible thirdItem, ItemConvertible fourItem, String group)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .input('D', fourItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .input('D', fourItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .input('D', fourItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void mkRpW3Items(RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, ItemConvertible thirdItem, String group)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .input('A', firstItem)
                                    .input('B', secondItem)
                                    .input('C', thirdItem)
                                    .group(group)
                                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void mkRpW2Items(RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, String group)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .input('A', firstItem)
                                    .input('B', secondItem)
                                    .group(group)
                                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void mkRpW1Item(RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, String group)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;
        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .input('A', firstItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .group(group)
                    .criterion(hasItem(planks), conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void mkRpShapelessW1Item(RecipeExporter exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, int required, String group, String suffix)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapelessRecipeJsonBuilder shapelessRecipeJsonBuilder =
                ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                .input(firstItem, required)
                .group(group).criterion(hasItem(planks), conditionsFromItem(planks));

        shapelessRecipeJsonBuilder.offerTo(recipeExporter, result.asItem().toString() + suffix);
    }

    protected void mkRpShapelessW1Item(RecipeExporter exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, int require, String group)
    {
        var recipeExporter = withConditions(exporter, DefaultResourceConditions.allModsLoaded(this.mcwModid, this.originalMod));
        ShapelessRecipeJsonBuilder shapelessRecipeJsonBuilder =
                ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, result, count)
                        .input(firstItem, require)
                        .group(group).criterion(hasItem(planks), conditionsFromItem(planks));

        shapelessRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void mkRpShapelessW1Item(RecipeExporter exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, String group)
    {
        mkRpShapelessW1Item(exporter, planks, result, count, firstItem, 1, group);
    }


    protected void mkRpShapelessW1Item(RecipeExporter exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, String group, String suffix)
    {
        mkRpShapelessW1Item(exporter, planks, result, count, firstItem, 1, group, suffix);
    }

    @Override
    public String getName() {
        return this.modid + " Recipe Generator";
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

    }
}
