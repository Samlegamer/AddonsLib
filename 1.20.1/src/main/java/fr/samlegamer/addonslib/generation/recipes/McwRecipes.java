package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.data.ModType;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import static net.minecraft.data.recipes.ShapedRecipeBuilder.shaped;
import static net.minecraft.data.recipes.ShapelessRecipeBuilder.shapeless;

public class McwRecipes extends RecipeProvider
{
    private final String modid;
    private final String mcwModid;
    private final String originalMod;
    private final PackOutput packOutput;

    public McwRecipes(PackOutput packOutput, String modid, String mcwModid, String originalMod)
    {
        super(packOutput);
        this.modid = modid;
        this.mcwModid = mcwModid;
        this.originalMod = originalMod;
        this.packOutput = packOutput;
    }

    private AbstractType getFromModType(ModType modType, String modid, String originalMod)
    {
        return switch (modType) {
            case BRIDGES -> new Bridges(packOutput, modid, originalMod);
            case DOORS -> new Doors(packOutput, modid, originalMod);
            case FENCES -> new Fences(packOutput, modid, originalMod);
            case FURNITURES -> new Furnitures(packOutput, modid, originalMod);
            case PATHS -> new Paths(packOutput, modid, originalMod);
            case ROOFS -> new Roofs(packOutput, modid, originalMod);
            case STAIRS -> new Stairs(packOutput, modid, originalMod);
            case TRAPDOORS -> new Trapdoors(packOutput, modid, originalMod);
            case WINDOWS -> new Windows(packOutput, modid, originalMod);
            default -> null;
        };
    }

    public void onRegisterMcwWood(ModType modType, Consumer<FinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildWood(output, MAT, woodMats);
        }
    }

    public void onRegisterMcwStone(ModType modType, Consumer<FinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        AbstractType abstractType = getFromModType(modType, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildStone(output, MAT, stoneMats);
        }
    }

    public void registerAllMcwWood(Consumer<FinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
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

    public void registerAllMcwStone(Consumer<FinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
    {
        onRegisterMcwStone(ModType.BRIDGES, output, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.ROOFS, output, modid, originalMod, MAT, stoneMats);
        onRegisterMcwStone(ModType.FENCES, output, modid, originalMod, MAT, stoneMats);
    }

    public void registerMcwHedge(Consumer<FinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<Block> leave)
    {
        AbstractType abstractType = getFromModType(ModType.FENCES, modid, originalMod);
        if(abstractType != null)
        {
            abstractType.buildHedge(output, MAT, leave);
        }
    }

    protected void mkScW1Item(Consumer<FinishedRecipe> output, ItemLike result, ItemLike firstItem)
    {
        String recipeId = this.modid + ":" + Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()) + "_stonecutter";
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                .addRecipe(SingleItemRecipeBuilder.stonecutting(Ingredient.of(firstItem), RecipeCategory.BUILDING_BLOCKS, result)
                        .unlockedBy(getHasName(firstItem), has(firstItem))::save).generateAdvancement()
                .build(output, ResourceLocation.parse(recipeId));
    }

    protected void mkRpW4Items(Consumer<FinishedRecipe> output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, ItemLike secondItem, ItemLike thirdItem, ItemLike fourItem, String group)
    {
        if(pattern.length == 3)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .pattern(pattern[2])
                            .define('A', firstItem)
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .define('D', fourItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else if(pattern.length == 2)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .define('A', firstItem)
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .define('D', fourItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .define('A', firstItem)
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .define('D', fourItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
    }

    protected void mkRpW3Items(Consumer<FinishedRecipe> output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, ItemLike secondItem, ItemLike thirdItem, String group)
    {
        if(pattern.length == 3)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .define('A', firstItem)
                    .define('B', secondItem)
                    .define('C', thirdItem)
                    .group(group)
                    .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else if(pattern.length == 2)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .define('A', firstItem)
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .define('A', firstItem)
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
    }

    protected void mkRpW2Items(Consumer<FinishedRecipe> output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, ItemLike secondItem, String group)
    {
        if(pattern.length == 3)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .define('A', firstItem)
                                    .define('B', secondItem)
                                    .group(group)
                                    .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else if(pattern.length == 2)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .define('A', firstItem)
                            .define('B', secondItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .define('A', firstItem)
                            .define('B', secondItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
    }

    protected void mkRpW1Item(Consumer<FinishedRecipe> output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, String group, String suffix)
    {
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                .pattern(pattern[0])
                .define('A', firstItem)
                .group(group)
                .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath() + suffix));
    }

    protected void mkRpShapelessW1Item(Consumer<FinishedRecipe> output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group, String suffix)
    {
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                .addRecipe(shapeless(RecipeCategory.BUILDING_BLOCKS, result, count)
                .requires(firstItem, required)
                .group(group)
                .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath() + suffix));
    }

    protected void mkRpShapelessW1Item(Consumer<FinishedRecipe> output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, int required, String group)
    {
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                .addRecipe(shapeless(RecipeCategory.BUILDING_BLOCKS, result, count)
                .requires(firstItem, required)
                .group(group)
                .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
    }

    protected void mkRpShapelessW1Item(Consumer<FinishedRecipe> output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, String group)
    {
        mkRpShapelessW1Item(output, planks, result, count, firstItem, 1, group);
    }

    protected void mkRpShapelessW1Item(Consumer<FinishedRecipe> output, ItemLike planks, ItemLike result, int count, ItemLike firstItem, String group, String suffix)
    {
        mkRpShapelessW1Item(output, planks, result, count, firstItem, 1, group, suffix);
    }

    protected void mkRpW1Item(Consumer<FinishedRecipe> output, ItemLike planks, String[] pattern, ItemLike result, int count, ItemLike firstItem, String group)
    {
        if(pattern.length == 3)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .pattern(pattern[2])
                            .define('A', firstItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else if(pattern.length == 2)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .define('A', firstItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
        else {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
                    .addRecipe(shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                            .pattern(pattern[0])
                            .define('A', firstItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, ResourceLocation.fromNamespaceAndPath(this.modid, BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()));
        }
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

    }
}
