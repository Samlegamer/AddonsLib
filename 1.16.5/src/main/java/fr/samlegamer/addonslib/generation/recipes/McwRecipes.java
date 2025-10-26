package fr.samlegamer.addonslib.generation.recipes;

import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
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

    protected void mkRpW1Item(Consumer<IFinishedRecipe> consumer, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, String group)
    {
        mkRpW1Item(consumer, planks, pattern, result, count, firstItem, group, "");
    }
}
