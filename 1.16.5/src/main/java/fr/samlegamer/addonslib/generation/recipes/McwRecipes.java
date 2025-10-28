package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.data.ModType;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import static net.minecraft.data.RecipeProvider.has;

public class McwRecipes
{
    private final String modid;
    private final String mcwModid;
    private final String originalMod;

    public McwRecipes(String modid, String mcwModid, String originalMod) {
        this.modid = modid;
        this.mcwModid = mcwModid;
        this.originalMod = originalMod;
    }

    private static AbstractType getFromModType(ModType modType, String modid, String originalMod)
    {
        switch (modType)
        {
            case BRIDGES:
                return new Bridges(modid, originalMod);
            case DOORS:
                return new Doors(modid, originalMod);
            case FENCES:
                return new Fences(modid, originalMod);
            case FURNITURES:
                return new Furnitures(modid, originalMod);
            case PATHS:
                return new Paths(modid, originalMod);
            case ROOFS:
                return new Roofs(modid, originalMod);
            case STAIRS:
                return new Stairs(modid, originalMod);
            case TRAPDOORS:
                return new Trapdoors(modid, originalMod);
            case WINDOWS:
                return new Windows(modid, originalMod);
            default:
                return null;
        }
    }

    public static void onRegisterMcwWood(ModType modType, Consumer<IFinishedRecipe> consumer, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildWood(consumer, MAT, woodMats);
        }
    }

    public static void onRegisterMcwStone(ModType modType, Consumer<IFinishedRecipe> consumer, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildStone(consumer, MAT, stoneMats);
        }
    }

    public static void registerAllMcwWood(Consumer<IFinishedRecipe> consumer, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
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

    public static void registerAllMcwStone(Consumer<IFinishedRecipe> consumer, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        onRegisterMcwStone(ModType.BRIDGES, consumer, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.ROOFS, consumer, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.FENCES, consumer, modid, originalMod, MAT, stoneMats);
    }

    public static void registerMcwHedge(Consumer<IFinishedRecipe> consumer, String modid, String originalMod, List<String> MAT, List<Block> leave)
    {
        AbstractType abstractType = getFromModType(ModType.FENCES, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildHedge(consumer, MAT, leave);
        }
    }

    protected void mkScW1Item(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider firstItem)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                        c -> SingleItemRecipeBuilder.stonecutting(Ingredient.of(result), firstItem)).generateAdvancement()
                .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath() + "_stonecutter"));
    }

    protected void mkRpW3Items(Consumer<IFinishedRecipe> consumer, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, IItemProvider thirdItem, String group)
    {
        if(pattern.length == 3)
        {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .define('C', thirdItem)
                                    .group(group)
                                    .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                    .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath()));
        }
        else if(pattern.length == 2)
        {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .define('C', thirdItem)
                                    .group(group)
                                    .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                    .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath()));
        }
        else
        {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(result, count)
                                    .pattern(pattern[0])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .define('C', thirdItem)
                                    .group(group)
                                    .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                    .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath()));
        }
    }

    protected void mkRpW2Items(Consumer<IFinishedRecipe> consumer, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, String group)
    {
        if(pattern.length == 3)
        {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .group(group)
                                    .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                    .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath()));
        }
        else if(pattern.length == 2)
        {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .group(group)
                                    .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                    .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath()));
        }
        else
        {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(result, count)
                                    .pattern(pattern[0])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .group(group)
                                    .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                    .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath()));
        }
    }

    protected void mkRpW1Item(Consumer<IFinishedRecipe> consumer, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, String group, String suffix)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                        ShapedRecipeBuilder.shaped(result, count)
                                .pattern(pattern[0])
                                .define('A', firstItem)
                                .group(group)
                                .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath() + suffix));
    }

    protected void mkRpShapelessW1Item(Consumer<IFinishedRecipe> consumer, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String suffix)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod)).addRecipe(
                        ShapelessRecipeBuilder.shapeless(result, count)
                                .requires(firstItem, required)
                                .group(group)
                                .unlockedBy("has_item", has(planks))::save).generateAdvancement()
                .build(consumer, new ResourceLocation(this.modid, Objects.requireNonNull(result.asItem().getRegistryName()).getPath() + suffix));
    }

    protected void mkRpShapelessW1Item(Consumer<IFinishedRecipe> consumer, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, String group, String suffix)
    {
        mkRpShapelessW1Item(consumer, planks, result, count, firstItem, 1, group, suffix);
    }

    protected void mkRpW1Item(Consumer<IFinishedRecipe> consumer, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, String group)
    {
        mkRpW1Item(consumer, planks, pattern, result, count, firstItem, group, "");
    }
}
