package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.obj.DoubleObject;
import fr.addonslib.api.recipes.CraftingIngredient;
import fr.addonslib.api.recipes.McwRecipesBase;
import fr.addonslib.api.recipes.RecipesBase;
import fr.addonslib.api.recipes.material.McwStoneMat;
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

import java.util.List;
import java.util.function.Consumer;

public abstract class RecipesUtils extends RecipeProvider
{
    private final IRecipes iRecipes;

    public RecipesUtils(DataGenerator dataGenerator, IRecipes iRecipes) {
        super(dataGenerator);
        this.iRecipes = iRecipes;
    }

    private void makeRecipesWood(McwBlockIdBase mcwBlockIdBase, Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats)
    {
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(RecipesBase recipeBase : blockId.recipes())
            {
                for(int i = 0; i < MAT.size() && i < woodMats.size(); i++)
                {
                    String mat = MAT.get(i);
                    McwWoodMat<Block> woodMat = woodMats.get(i);

                    Block result = Finder.findBlock(modid, McwBlocksIdBase.replacement(blockId.id(), mat));

                    switch(recipeBase.getMethod())
                    {
                        case McwRecipesBase.RECIPE_SHAPED_WITH_1_ITEM:
                            iRecipes.recipeShapedWithItems(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]));
                            break;
                        case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE:
                            iRecipes.recipeShapelessRecycle(output, woodMat.getLog(), result, recipeBase.getCount(), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                            break;
                        case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM:
                            iRecipes.recipeShapeless(output, woodMat.getLog(), result, recipeBase.getCount(), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                            break;
                        case McwRecipesBase.RECIPE_SHAPED_WITH_2_ITEMS:
                            iRecipes.recipeShapedWithItems(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]));
                            break;
                        case McwRecipesBase.RECIPE_SHAPED_WITH_3_ITEMS:
                            iRecipes.recipeShapedWithItems(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[2]));
                            break;
                        case McwRecipesBase.RECIPE_SHAPED_WITH_4_ITEMS:
                            iRecipes.recipeShapedWithItems(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[2]), RecipesUtils.replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[3]));
                            break;
                        default:
                            AddonsLib.LOGGER.error("Unknown recipe method: {} for {} item", recipeBase.getMethod(), modid + ":" + McwBlocksIdBase.replacement(blockId.id(), mat));
                            break;
                    }
                }
            }
        }
    }

    private void makeRecipesStone(McwBlockIdBase mcwBlockIdBase, Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats)
    {
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(RecipesBase recipeBase : blockId.recipes())
            {
                for(int i = 0; i < MAT.size() && i < stoneMats.size(); i++)
                {
                    String mat = MAT.get(i);
                    McwStoneMat<Block> stoneMat = stoneMats.get(i);

                    Block result = Finder.findBlock(modid, McwBlocksIdBase.replacement(blockId.id(), mat));

                    switch(recipeBase.getMethod())
                    {
                        case McwRecipesBase.RECIPE_SHAPED_WITH_1_ITEM:
                            iRecipes.recipeShapedWithItems(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]));
                            break;
                        case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE:
                            iRecipes.recipeShapelessRecycle(output, stoneMat.getStoneBase(), result, recipeBase.getCount(), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                            break;
                        case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM:
                            iRecipes.recipeShapeless(output, stoneMat.getStoneBase(), result, recipeBase.getCount(), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                            break;
                        case McwRecipesBase.RECIPE_SHAPED_WITH_2_ITEMS:
                            iRecipes.recipeShapedWithItems(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[1]));
                            break;
                        case McwRecipesBase.RECIPE_SHAPED_WITH_3_ITEMS:
                            iRecipes.recipeShapedWithItems(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[1]), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[2]));
                            break;
                        case McwRecipesBase.RECIPE_SHAPED_WITH_4_ITEMS:
                            iRecipes.recipeShapedWithItems(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[1]), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[2]), RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[3]));
                            break;
                        case McwRecipesBase.RECIPE_STONECUTTER:
                            iRecipes.recipeStonecutter(output, result, RecipesUtils.replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), originalMod, mcwBlockIdBase.modid());
                            break;
                        default:
                            AddonsLib.LOGGER.error("Unknown recipe method: {} for {} item", recipeBase.getMethod(), modid + ":" + McwBlocksIdBase.replacement(blockId.id(), mat));
                            break;
                    }
                }
            }
        }
    }

    public void registerMcwWood(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats, ModType... modType)
    {
        for(ModType mod : modType)
        {
            McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidWood(mod);
            makeRecipesWood(mcwBlockIdBase, output, modid, originalMod, MAT, woodMats);
        }
    }

    public void registerMcwStone(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats, ModType... modType)
    {
        for(ModType mod : modType)
        {
            McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidStone(mod);
            makeRecipesStone(mcwBlockIdBase, output, modid, originalMod, MAT, stoneMats);
        }
    }

    public void registerMcwHedge(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<Block> blockLeave)
    {
        McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.FENCES_LEAVE_BLOCKS;
        for(BlockId blockId : mcwBlockIdBase.blocks())
        {
            for(RecipesBase recipeBase : blockId.recipes())
            {
                for(int i = 0; i < MAT.size() && i < blockLeave.size(); i++)
                {
                    String mat = MAT.get(i);
                    Block leave = blockLeave.get(i);

                    Block result = Finder.findBlock(modid, McwBlocksIdBase.replacement(blockId.id(), mat));

                    switch(recipeBase.getMethod())
                    {
                        case McwRecipesBase.RECIPE_SHAPED_WITH_1_ITEM:
                            iRecipes.recipeShapedWithItems(output, leave, recipeBase.getPattern(), result, recipeBase.getCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid(), leave);
                            break;
                        default:
                            AddonsLib.LOGGER.error("Unknown recipe method: {} for {} item", recipeBase.getMethod(), modid + ":" + McwBlocksIdBase.replacement(blockId.id(), mat));
                            break;
                    }
                }
            }
        }
    }

    public void registerAllMcwWood(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats)
    {
        registerMcwWood(output, modid, originalMod, MAT, woodMats, ModType.getAllModTypeWood());
    }

    public void registerAllMcwStone(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats)
    {
        registerMcwStone(output, modid, originalMod, MAT, stoneMats, ModType.getAllModTypeStone());
    }

    public static Item replaceTypeWood(String MODID, String mat, McwWoodMat<Block> woodMat, CraftingIngredient type)
    {
        switch (type.getName()) {
            case "stripped_table": return Finder.findItem(MODID, "stripped_" + mat + "_table");
            case "table": return Finder.findItem(MODID, mat + "_table");
            case "log_bridge": return Finder.findItem(MODID, mat + "_log_bridge_middle");
            case "log_bridge_stair": return Finder.findItem(MODID, mat + "_log_bridge_stair");
            case "wardrobe": return Finder.findItem(MODID, mat + "_wardrobe");
            case "stripped_wardrobe": return Finder.findItem(MODID, "stripped_" + mat + "_wardrobe");
            case "coffee_table": return Finder.findItem(MODID, mat + "_coffee_table");
            case "stripped_coffee_table": return Finder.findItem(MODID, "stripped_" + mat + "_coffee_table");
            case "stable_door": return Finder.findItem(MODID, mat + "_stable_door");
            case "rope_bridge": return Finder.findItem(MODID, "rope_" + mat + "_bridge");
            case "balcony": return Finder.findItem(MODID, mat + "_balcony");
            case "drawer": return Finder.findItem(MODID, mat + "_drawer");
            case "stripped_drawer": return Finder.findItem(MODID, "stripped_" + mat + "_drawer");
            case "double_drawer": return Finder.findItem(MODID, mat + "_double_drawer");
            case "stripped_double_drawer": return Finder.findItem(MODID, "stripped_" + mat + "_double_drawer");
            case "stripped_end_table": return Finder.findItem(MODID, "stripped_" + mat + "_end_table");
            case "end_table": return Finder.findItem(MODID, mat + "_end_table");
            case "rope_bridge_stair": return Finder.findItem(MODID, mat + "_rope_bridge_stair");
            case "glass_trapdoor": return Finder.findItem(MODID, mat + "_glass_trapdoor");
            case McwRecipesBase.CABINET_DOOR: return Finder.findItem(McwRecipesBase.CABINET_DOOR);
            case McwRecipesBase.CABINET_DRAWER: return Finder.findItem(McwRecipesBase.CABINET_DRAWER);
            case McwRecipesBase.WINDOW_BASE: return Finder.findItem(McwRecipesBase.WINDOW_BASE);
            case McwRecipesBase.WINDOW_HALF_BAR_BASE: return Finder.findItem(McwRecipesBase.WINDOW_HALF_BAR_BASE);
            case McwRecipesBase.WINDOW_CENTRE_BAR_BASE: return Finder.findItem(McwRecipesBase.WINDOW_CENTRE_BAR_BASE);
            case McwRecipesBase.STICK: return Items.STICK;
            case McwRecipesBase.IRON_BARS: return Items.IRON_BARS;
            case McwRecipesBase.CAULDRON: return Items.CAULDRON;
            case McwRecipesBase.WATER_BUCKET: return Items.WATER_BUCKET;
            case McwRecipesBase.BARREL: return Items.BARREL;
            case McwRecipesBase.PAPER: return Items.PAPER;
            case McwRecipesBase.GLASS_PANE: return Items.GLASS_PANE;
            case McwRecipesBase.GLASS: return Items.GLASS;
            case McwRecipesBase.STRING: return Items.STRING;
            case McwRecipesBase.BOOK: return Items.BOOK;
            case McwRecipesBase.LOG: return woodMat.getLog().asItem();
            case McwRecipesBase.PLANKS: return woodMat.getPlanks().asItem();
            case McwRecipesBase.STRIPPED_LOG: return woodMat.getStrippedLog().asItem();
            case McwRecipesBase.SLAB: return woodMat.getSlab().asItem();
            case McwRecipesBase.FENCE: return woodMat.getFence().asItem();
            case McwRecipesBase.TRAPDOOR: return woodMat.getTrapdoor().asItem();
            default: return Finder.findItem(type.getName());
        }
    }

    public static Item replaceTypeStone(String MODID, String mat, McwStoneMat<Block> woodMat, CraftingIngredient type)
    {
        switch (type.getName()) {
            case "stone_bridge": return Finder.findItem(MODID, mat + "_bridge");
            case "stone_bridge_stair": return Finder.findItem(MODID, mat + "_bridge_stair");
            case McwRecipesBase.DIRT: return Items.DIRT;
            case McwRecipesBase.IRON_BARS: return Items.IRON_BARS;
            case McwRecipesBase.GLASS_PANE: return Items.GLASS_PANE;
            case McwRecipesBase.GLASS: return Items.GLASS;
            case McwRecipesBase.STONE_BASE: return woodMat.getStoneBase().asItem();
            case McwRecipesBase.STONE_SLAB: return woodMat.getSlab().asItem();
            case McwRecipesBase.STONE_WALL: return woodMat.getWall().asItem();
            case McwRecipesBase.SMOOTH_STONE: return woodMat.getSmoothStone().asItem();
            default: return Items.AIR;
        }
    }

    public DoubleObject<ShapelessRecipeBuilder, ResourceLocation> doubleObjectShapeless(IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group)
    {
        ResourceLocation recipeId = Finder.getRLOfItem(result.asItem());
        ShapelessRecipeBuilder shapelessRecipeBuilder = ShapelessRecipeBuilder.shapeless(result, count)
                        .requires(firstItem, required)
                        .group(group)
                        .unlockedBy(getHasName(planks), has(planks));
        return new DoubleObject<>(shapelessRecipeBuilder, recipeId);
    }

    public DoubleObject<ShapelessRecipeBuilder, ResourceLocation> doubleObjectShapelessRecycle(IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group)
    {
        ResourceLocation recipeId = new ResourceLocation(Finder.getModidOfItem(result.asItem()), Finder.getIdOfItem(result.asItem()) + "_recycle");
        ShapelessRecipeBuilder shapelessRecipeBuilder = ShapelessRecipeBuilder.shapeless(result, count)
                        .requires(firstItem, required)
                        .group(group)
                        .unlockedBy(getHasName(planks), has(planks));
        return new DoubleObject<>(shapelessRecipeBuilder, recipeId);
    }

    public DoubleObject<ShapedRecipeBuilder, ResourceLocation> doubleObjectShapedWithItems(IItemProvider planks, String[] pattern, IItemProvider result, int count, String group, IItemProvider... items)
    {
        ResourceLocation recipeId = Finder.getRLOfItem(result.asItem());
        ShapedRecipeBuilder shapedRecipeJsonBuilder = ShapedRecipeBuilder.shaped(result, count);

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2]);
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder
                    .pattern(pattern[0])
                    .pattern(pattern[1]);
        }
        else
        {
            shapedRecipeJsonBuilder.pattern(pattern[0]);
        }

        int i = 0;
        char[] symbols = {'A', 'B', 'C', 'D'};

        for(IItemProvider item : items)
        {
            shapedRecipeJsonBuilder.define(symbols[i], item);
            i++;
        }

        shapedRecipeJsonBuilder.group(group).unlockedBy(getHasName(planks), has(planks));
        return new DoubleObject<>(shapedRecipeJsonBuilder, recipeId);
    }

    public DoubleObject<SingleItemRecipeBuilder, String> doubleObjectStonecutter(IItemProvider result, IItemProvider firstItem)
    {
        String recipeId = Finder.getModidOfItem(result.asItem()) + ":" + Finder.getIdOfItem(result.asItem()) + "_stonecutter";
        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(firstItem), result)
                .unlocks(getHasName(firstItem), has(firstItem));
        return new DoubleObject<>(builder, recipeId);
    }

    private String getHasName(IItemProvider item)
    {
        return "has_" + Finder.getIdOfItem(item.asItem());
    }
}
