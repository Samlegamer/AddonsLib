package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.recipes.CraftingIngredient;
import fr.addonslib.api.recipes.McwRecipesBase;
import fr.addonslib.api.recipes.RecipesBase;
import fr.addonslib.api.recipes.material.McwWoodMat;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import static net.minecraft.data.ShapedRecipeBuilder.*;
import static net.minecraft.data.ShapelessRecipeBuilder.*;

public class McwRecipes extends RecipeProvider
{
    public McwRecipes(DataGenerator dataGenerator, String modid) {
        super(dataGenerator);
    }

    private void makeRecipesWood(McwBlockIdBase mcwBlockIdBase, Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats)
    {
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(RecipesBase recipeBase : blockId.recipes())
            {
                for(String mat : MAT)
                {
                    for(McwWoodMat<Block> woodMat : woodMats)
                    {
                        Block result = Finder.findBlock(modid, McwBlocksIdBase.replacement(blockId.id(), mat));

                        if(result != null)
                        {
                            switch(recipeBase.getMethod())
                            {
                                case McwRecipesBase.RECIPE_SHAPED_WITH_1_ITEM:
                                    recipeShapedWith1Item(output, woodMat.getPlanks(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                    break;
                                case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE:
                                    //recipeShapedWith1Item(output, woodMat.getPlanks(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                    break;
                            }
                        }
                        else {
                            AddonsLib.LOGGER.error("Could not find block with id: {}", modid + ":" + McwBlocksIdBase.replacement(blockId.id(), mat));
                        }
                    }
                }
            }
        }
    }

    private Item replaceTypeWood(McwWoodMat<Block> woodMat, CraftingIngredient type)
    {
        switch(type.getName())
        {
            case McwRecipesBase.IRON_BARS:
                return Items.IRON_BARS;
            case McwRecipesBase.CAULDRON:
                return Items.CAULDRON;
            case McwRecipesBase.WATER_BUCKET:
                return Items.WATER_BUCKET;
            case McwRecipesBase.BARREL:
                return Items.BARREL;
            case McwRecipesBase.PAPER:
                return Items.PAPER;
            case McwRecipesBase.GLASS_PANE:
                return Items.GLASS_PANE;
            case McwRecipesBase.GLASS:
                return Items.GLASS;
            case McwRecipesBase.STRING:
                return Items.STRING;
            case McwRecipesBase.BOOK:
                return Items.BOOK;
            case McwRecipesBase.LOG:
                return woodMat.getLog().asItem();
            case McwRecipesBase.PLANKS:
                return woodMat.getPlanks().asItem();
            case McwRecipesBase.STRIPPED_LOG:
                return woodMat.getStrippedLog().asItem();
            case McwRecipesBase.SLAB:
                return woodMat.getSlab().asItem();
            case McwRecipesBase.FENCE:
                return woodMat.getFence().asItem();
            case McwRecipesBase.TRAPDOOR:
                return woodMat.getTrapdoor().asItem();
            default:
                return Items.AIR;
        }
    }

//    private AbstractType getFromModType(ModType modType, String modid, String originalMod)
//    {
//        switch (modType) {
//            case BRIDGES: return new Bridges(dataGenerator, modid, originalMod);
//            case DOORS: return new Doors(dataGenerator, modid, originalMod);
//            case FENCES: return new Fences(dataGenerator, modid, originalMod);
//            case FURNITURES: return new Furnitures(dataGenerator, modid, originalMod);
//            case PATHS: return new Paths(dataGenerator, modid, originalMod);
//            case ROOFS: return new Roofs(dataGenerator, modid, originalMod);
//            case STAIRS: return new Stairs(dataGenerator, modid, originalMod);
//            case TRAPDOORS: return new Trapdoors(dataGenerator, modid, originalMod);
//            case WINDOWS: return new Windows(dataGenerator, modid, originalMod);
//            default: return null;
//        }
//    }
//
//    public void onRegisterMcwWood(ModType modType, Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
//    {
//        AbstractType abstractType = getFromModType(modType, modid, originalMod);
//        if(abstractType != null)
//        {
//            abstractType.buildWood(output, MAT, woodMats);
//        }
//    }
//
//    public void onRegisterMcwStone(ModType modType, Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
//    {
//        AbstractType abstractType = getFromModType(modType, modid, originalMod);
//        if(abstractType != null)
//        {
//            abstractType.buildStone(output, MAT, stoneMats);
//        }
//    }
//
//    public void registerAllMcwWood(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat> woodMats)
//    {
//        onRegisterMcwWood(ModType.BRIDGES, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.DOORS, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.FENCES, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.FURNITURES, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.PATHS, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.ROOFS, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.STAIRS, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.TRAPDOORS, output, modid, originalMod, MAT, woodMats);
//        onRegisterMcwWood(ModType.WINDOWS, output, modid, originalMod, MAT, woodMats);
//    }
//
//    public void registerAllMcwStone(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat> stoneMats)
//    {
//        onRegisterMcwStone(ModType.BRIDGES, output, modid, originalMod, MAT, stoneMats);
//        onRegisterMcwStone(ModType.ROOFS, output, modid, originalMod, MAT, stoneMats);
//        onRegisterMcwStone(ModType.FENCES, output, modid, originalMod, MAT, stoneMats);
//    }
//
//    public void registerMcwHedge(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<Block> leave)
//    {
//        AbstractType abstractType = getFromModType(ModType.FENCES, modid, originalMod);
//        if(abstractType != null)
//        {
//            abstractType.buildHedge(output, MAT, leave);
//        }
//    }

    private String getHasName(IItemProvider item)
    {
        return "has_" + Finder.getIdOfItem(item.asItem());
    }

//    protected void mkScW1Item(Consumer<IFinishedRecipe> output, IItemProvider result, IItemProvider firstItem)
//    {
//        String recipeId = this.modid + ":" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()) + "_stonecutter";
//        ConditionalRecipe.builder()
//                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                .addRecipe(c -> SingleItemRecipeBuilder.stonecutting(Ingredient.of(firstItem), result)
//                        .unlocks(getHasName(firstItem), has(firstItem)).save(c, recipeId)).generateAdvancement()
//                .build(output, new ResourceLocation(recipeId));
//    }
//
//    protected void mkRpW4Items(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, IItemProvider thirdItem, IItemProvider fourItem, String group)
//    {
//        if(pattern.length == 3)
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                            .pattern(pattern[0])
//                            .pattern(pattern[1])
//                            .pattern(pattern[2])
//                            .define('A', firstItem)
//                            .define('B', secondItem)
//                            .define('C', thirdItem)
//                            .define('D', fourItem)
//                            .group(group)
//                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//        else if(pattern.length == 2)
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                            .pattern(pattern[0])
//                            .pattern(pattern[1])
//                            .define('A', firstItem)
//                            .define('B', secondItem)
//                            .define('C', thirdItem)
//                            .define('D', fourItem)
//                            .group(group)
//                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//        else
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                            .pattern(pattern[0])
//                            .define('A', firstItem)
//                            .define('B', secondItem)
//                            .define('C', thirdItem)
//                            .define('D', fourItem)
//                            .group(group)
//                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//    }
//
//    protected void mkRpW3Items(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, IItemProvider thirdItem, String group)
//    {
//        if(pattern.length == 3)
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                    .pattern(pattern[0])
//                    .pattern(pattern[1])
//                    .pattern(pattern[2])
//                    .define('A', firstItem)
//                    .define('B', secondItem)
//                    .define('C', thirdItem)
//                    .group(group)
//                    .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//        else if(pattern.length == 2)
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                            .pattern(pattern[0])
//                            .pattern(pattern[1])
//                            .define('A', firstItem)
//                            .define('B', secondItem)
//                            .define('C', thirdItem)
//                            .group(group)
//                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//        else
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                            .pattern(pattern[0])
//                            .define('A', firstItem)
//                            .define('B', secondItem)
//                            .define('C', thirdItem)
//                            .group(group)
//                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//    }
//
//    protected void mkRpW2Items(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, String group)
//    {
//        if(pattern.length == 3)
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                                    .pattern(pattern[0])
//                                    .pattern(pattern[1])
//                                    .pattern(pattern[2])
//                                    .define('A', firstItem)
//                                    .define('B', secondItem)
//                                    .group(group)
//                                    .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//        else if(pattern.length == 2)
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                            .pattern(pattern[0])
//                            .pattern(pattern[1])
//                            .define('A', firstItem)
//                            .define('B', secondItem)
//                            .group(group)
//                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//        else
//        {
//            ConditionalRecipe.builder()
//                    .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                    .addRecipe(shaped(result, count)
//                            .pattern(pattern[0])
//                            .define('A', firstItem)
//                            .define('B', secondItem)
//                            .group(group)
//                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                    .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//        }
//    }
//
//    protected void mkRpW1Item(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, String group, String suffix)
//    {
//        ConditionalRecipe.builder()
//                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                .addRecipe(shaped(result, count)
//                .pattern(pattern[0])
//                .define('A', firstItem)
//                .group(group)
//                .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath() + suffix));
//    }
//
//    protected void mkRpShapelessW1Item(Consumer<IFinishedRecipe> output, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String suffix)
//    {
//        ConditionalRecipe.builder()
//                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                .addRecipe(shapeless(result, count)
//                .requires(firstItem, required)
//                .group(group)
//                .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath() + suffix));
//    }
//
//    protected void mkRpShapelessW1Item(Consumer<IFinishedRecipe> output, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group)
//    {
//        ConditionalRecipe.builder()
//                .addCondition(new ModLoadedCondition(this.mcwModid)).addCondition(new ModLoadedCondition(this.originalMod))
//                .addRecipe(shapeless(result, count)
//                .requires(firstItem, required)
//                .group(group)
//                .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
//                .build(output, new ResourceLocation(this.modid, ForgeRegistries.ITEMS.getKey(result.asItem()).getPath()));
//    }
//
//    protected void mkRpShapelessW1Item(Consumer<IFinishedRecipe> output, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, String group)
//    {
//        mkRpShapelessW1Item(output, planks, result, count, firstItem, 1, group);
//    }
//
//    protected void mkRpShapelessW1Item(Consumer<IFinishedRecipe> output, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, String group, String suffix)
//    {
//        mkRpShapelessW1Item(output, planks, result, count, firstItem, 1, group, suffix);
//    }

    protected void recipeShapedWith1Item(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, String group, String originalMod, String mcwMod)
    {
        if(pattern.length == 3)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(mcwMod)).addCondition(new ModLoadedCondition(originalMod))
                    .addRecipe(shaped(result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .pattern(pattern[2])
                            .define('A', firstItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, Finder.getRLOfItem(result.asItem()));
        }
        else if(pattern.length == 2)
        {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(mcwMod)).addCondition(new ModLoadedCondition(originalMod))
                    .addRecipe(shaped(result, count)
                            .pattern(pattern[0])
                            .pattern(pattern[1])
                            .define('A', firstItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, Finder.getRLOfItem(result.asItem()));
        }
        else {
            ConditionalRecipe.builder()
                    .addCondition(new ModLoadedCondition(mcwMod)).addCondition(new ModLoadedCondition(originalMod))
                    .addRecipe(shaped(result, count)
                            .pattern(pattern[0])
                            .define('A', firstItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, Finder.getRLOfItem(result.asItem()));
        }
    }
}
