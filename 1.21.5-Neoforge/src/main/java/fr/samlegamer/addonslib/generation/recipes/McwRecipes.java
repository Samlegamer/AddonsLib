package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.data.ModType;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.List;
import java.util.Objects;

public class McwRecipes extends RecipeProvider
{
    private final String modid;
    private final String mcwModid;
    private final String originalMod;

    public McwRecipes(HolderLookup.Provider registries, RecipeOutput output, String modid, String mcwModid, String originalMod) {
        super(registries, output);
        this.modid = modid;
        this.mcwModid = mcwModid;
        this.originalMod = originalMod;
    }

    private AbstractType getFromModType(ModType modType, String modid, String originalMod)
    {
        return switch (modType) {
            case BRIDGES -> new Bridges(registries, output, modid, originalMod);
            case DOORS -> new Doors(registries, output, modid, originalMod);
            case FENCES -> new Fences(registries, output, modid, originalMod);
            case FURNITURES -> new Furnitures(registries, output, modid, originalMod);
            case PATHS -> new Paths(registries, output, modid, originalMod);
            case ROOFS -> new Roofs(registries, output, modid, originalMod);
            case STAIRS -> new Stairs(registries, output, modid, originalMod);
            case TRAPDOORS -> new Trapdoors(registries, output, modid, originalMod);
            case WINDOWS -> new Windows(registries, output, modid, originalMod);
            default -> null;
        };
    }

    public void onRegisterMcwWood(ModType modType, RecipeOutput output, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildWood(output, MAT, woodMats);
        }
    }

    public void onRegisterMcwStone(ModType modType, RecipeOutput output, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildStone(output, MAT, stoneMats);
        }
    }

    public void registerAllMcwWood(RecipeOutput output, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        onRegisterMcwWood(ModType.BRIDGES, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.DOORS, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.FENCES, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.FURNITURES, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.PATHS, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.ROOFS, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.STAIRS, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.TRAPDOORS, output, modid, originalMod, MAT, woodMats);
        onRegisterMcwWood(ModType.WINDOWS, output, modid, originalMod, MAT, woodMats);
    }

    public void registerAllMcwStone(RecipeOutput output, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        onRegisterMcwStone(ModType.BRIDGES, output, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.ROOFS, output, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.FENCES, output, modid, originalMod, MAT, stoneMats);
    }

    public void registerMcwHedge(RecipeOutput output, String modid, String originalMod, List<String> MAT, List<Block> leave)
    {
        AbstractType abstractType = getFromModType(ModType.FENCES, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildHedge(output, MAT, leave);
        }
    }

    protected void mkScW1Item(RecipeOutput output, ItemLike result, ItemLike firstItem)
    {
        String recipeId = this.modid + ":" + Objects.requireNonNull(result.asItem().toString()) + "_stonecutter";

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(firstItem), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy(getHasName(firstItem), has(firstItem)).save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)), recipeId);
    }

    protected void mkRpW4Items(RecipeOutput output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, ItemLike secondItem, ItemLike thirdItem, ItemLike fourItem, String group)
    {
        ShapedRecipeBuilder shapedRecipeBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .define('C', thirdItem)
                    .define('D', fourItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .define('C', thirdItem)
                    .define('D', fourItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }
        else
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .define('C', thirdItem)
                    .define('D', fourItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }

        shapedRecipeBuilder.save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)));
    }

    protected void mkRpW3Items(RecipeOutput output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, ItemLike secondItem, ItemLike thirdItem, String group)
    {
        ShapedRecipeBuilder shapedRecipeBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .define('C', thirdItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .define('C', thirdItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }
        else
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .define('C', thirdItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }

        shapedRecipeBuilder.save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)));
    }

    protected void mkRpW2Items(RecipeOutput output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, ItemLike secondItem, String group)
    {
        ShapedRecipeBuilder shapedRecipeBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .group(group)
                                    .unlockedBy(getHasName(planks), has(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }
        else
        {
            shapedRecipeBuilder = shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks));
        }

        shapedRecipeBuilder.save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)));
    }

    protected void mkRpW1Item(RecipeOutput output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, String group, String suffix)
    {
        shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                .pattern(pattern[0])
                .define('A', firstItem)
                .group(group)
                .unlockedBy(getHasName(planks), has(planks))
                .save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)),
                        Objects.requireNonNull(result.asItem().toString()) + suffix);
    }

    protected void mkRpShapelessW1Item(RecipeOutput output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String suffix)
    {
        shapeless(RecipeCategory.BUILDING_BLOCKS, result, count)
                .requires(firstItem, required)
                .group(group)
                .unlockedBy(getHasName(planks), has(planks)).save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)),
                        Objects.requireNonNull(result.asItem().toString()) + suffix);
    }

    protected void mkRpShapelessW1Item(RecipeOutput output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group)
    {
        shapeless(RecipeCategory.BUILDING_BLOCKS, result, count)
                .requires(firstItem, required)
                .group(group)
                .unlockedBy(getHasName(planks), has(planks)).save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)));
    }

    protected void mkRpShapelessW1Item(RecipeOutput output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, String group)
    {
        mkRpShapelessW1Item(output, planks, result, count, firstItem, 1, group);
    }

    protected void mkRpShapelessW1Item(RecipeOutput output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, String group, String suffix)
    {
        mkRpShapelessW1Item(output, planks, result, count, firstItem, 1, group, suffix);
    }

    protected void mkRpW1Item(RecipeOutput output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, String group)
    {
        if(pattern.length == 3)
        {
            shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .define('A', firstItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks))
                    .save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)));
        }
        else if(pattern.length == 2)
        {
            shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .define('A', firstItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks))
                    .save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)));
        }
        else {
            shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .define('A', firstItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks))
                    .save(output.withConditions(new ModLoadedCondition(this.mcwModid), new ModLoadedCondition(this.originalMod)));
        }
    }

    @Override
    protected void buildRecipes() {

    }
}
