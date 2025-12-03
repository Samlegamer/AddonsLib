package fr.samlegamer.addonslib.generation.recipes;

import fr.addonslib.api.data.BlockId;
import fr.addonslib.api.data.McwBlockIdBase;
import fr.addonslib.api.data.McwBlocksIdBase;
import fr.addonslib.api.data.ModType;
import fr.addonslib.api.recipes.CraftingIngredient;
import fr.addonslib.api.recipes.McwRecipesBase;
import fr.addonslib.api.recipes.RecipesBase;
import fr.addonslib.api.recipes.material.McwStoneMat;
import fr.addonslib.api.recipes.material.McwWoodMat;
import fr.samlegamer.addonslib.AddonsLib;
import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import java.util.List;
import java.util.function.Consumer;
import static net.minecraft.data.ShapedRecipeBuilder.*;
import static net.minecraft.data.ShapelessRecipeBuilder.*;

public class McwRecipes extends RecipeProvider
{
    public McwRecipes(DataGenerator dataGenerator) {
        super(dataGenerator);
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

                    if(result != null)
                    {
                        switch(recipeBase.getMethod())
                        {
                            case McwRecipesBase.RECIPE_SHAPED_WITH_1_ITEM:
                                recipeShapedWith1Item(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE:
                                recipeShapelessWith1ItemRecycle(output, woodMat.getLog(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM:
                                recipeShapelessWith1Item(output, woodMat.getLog(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_2_ITEMS:
                                recipeShapedWith2Items(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_3_ITEMS:
                                recipeShapedWith3Items(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[2]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_4_ITEMS:
                                recipeShapedWith4Items(output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[2]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[3]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            default:
                                AddonsLib.LOGGER.error("Unknown recipe method: {} for {} item", recipeBase.getMethod(), modid + ":" + McwBlocksIdBase.replacement(blockId.id(), mat));
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

                    if(result != null)
                    {
                        switch(recipeBase.getMethod())
                        {
                            case McwRecipesBase.RECIPE_SHAPED_WITH_1_ITEM:
                                recipeShapedWith1Item(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE:
                                recipeShapelessWith1ItemRecycle(output, stoneMat.getStoneBase(), result, recipeBase.getCount(), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM:
                                recipeShapelessWith1Item(output, stoneMat.getStoneBase(), result, recipeBase.getCount(), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_2_ITEMS:
                                recipeShapedWith2Items(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[0]), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[1]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_3_ITEMS:
                                recipeShapedWith3Items(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[0]), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[1]), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[2]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_4_ITEMS:
                                recipeShapedWith4Items(output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[0]), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[1]), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[2]), replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[3]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_STONECUTTER:
                                recipeStonecutter(output, result, replaceTypeStone(stoneMat, recipeBase.getCraftingItems()[0]), originalMod, mcwBlockIdBase.modid());
                                break;
                            default:
                                AddonsLib.LOGGER.error("Unknown recipe method: {} for {} item", recipeBase.getMethod(), modid + ":" + McwBlocksIdBase.replacement(blockId.id(), mat));
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

    private Item replaceTypeWood(String MODID, String mat, McwWoodMat<Block> woodMat, CraftingIngredient type)
    {
        switch(type.getName())
        {
            case "log_bridge":
                return Finder.findItem(MODID, mat+"_log_bridge_middle");
            case "log_bridge_stair":
                return Finder.findItem(MODID, mat+"_log_bridge_stair");
            case "wardrobe":
                return Finder.findItem(MODID, mat+"_wardrobe");
            case "stripped_wardrobe":
                return Finder.findItem(MODID, "stripped_"+mat+"_wardrobe");
            case "coffee_table":
                return Finder.findItem(MODID, mat+"_coffee_table");
            case "stripped_coffee_table":
                return Finder.findItem(MODID, "stripped_"+mat+"_coffee_table");
            case "stable_door":
                return Finder.findItem(MODID, mat+"_stable_door");
            case "rope_bridge":
                return Finder.findItem(MODID, "rope_"+mat+"_bridge");
            case "balcony":
                return Finder.findItem(MODID, mat+"_balcony");
            case "drawer":
                return Finder.findItem(MODID, mat+"_drawer");
            case "stripped_drawer":
                return Finder.findItem(MODID, "stripped_"+mat+"_drawer");
            case "double_drawer":
                return Finder.findItem(MODID, mat+"_double_drawer");
            case "stripped_double_drawer":
                return Finder.findItem(MODID, "stripped_"+mat+"_double_drawer");
            case "stripped_end_table":
                return Finder.findItem(MODID, "stripped_"+mat+"_end_table");
            case "table":
                return Finder.findItem(MODID, mat+"_table");
            case "end_table":
                return Finder.findItem(MODID, mat+"_end_table");
            case "rope_bridge_stair":
                return Finder.findItem(MODID, mat+"_rope_bridge_stair");
            case "glass_trapdoor":
                return Finder.findItem(MODID, mat+"_glass_trapdoor");
            case McwRecipesBase.CABINET_DOOR:
                return Finder.findItem(McwRecipesBase.CABINET_DOOR);
            case McwRecipesBase.CABINET_DRAWER:
                return Finder.findItem(McwRecipesBase.CABINET_DRAWER);
            case McwRecipesBase.WINDOW_BASE:
                return Finder.findItem(McwRecipesBase.WINDOW_BASE);
            case McwRecipesBase.WINDOW_HALF_BAR_BASE:
                return Finder.findItem(McwRecipesBase.WINDOW_HALF_BAR_BASE);
            case McwRecipesBase.WINDOW_CENTRE_BAR_BASE:
                return Finder.findItem(McwRecipesBase.WINDOW_CENTRE_BAR_BASE);
            case McwRecipesBase.STICK:
                return Items.STICK;
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
                return Finder.findItem(type.getName());
        }
    }

    private Item replaceTypeStone(McwStoneMat<Block> woodMat, CraftingIngredient type)
    {
        switch(type.getName())
        {
            case McwRecipesBase.DIRT:
                return Items.DIRT;
            case McwRecipesBase.IRON_BARS:
                return Items.IRON_BARS;
            case McwRecipesBase.GLASS_PANE:
                return Items.GLASS_PANE;
            case McwRecipesBase.GLASS:
                return Items.GLASS;
            case McwRecipesBase.STONE_BASE:
                return woodMat.getStoneBase().asItem();
            case McwRecipesBase.STONE_SLAB:
                return woodMat.getSlab().asItem();
            case McwRecipesBase.STONE_WALL:
                return woodMat.getWall().asItem();
            case McwRecipesBase.SMOOTH_STONE:
                return woodMat.getSmoothStone().asItem();
            default:
                return Items.AIR;
        }
    }

    protected void registerMcwWood(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats, ModType... modType)
    {
        for(ModType mod : modType)
        {
            McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidWood(mod);
            makeRecipesWood(mcwBlockIdBase, output, modid, originalMod, MAT, woodMats);
        }
    }

    protected void registerMcwStone(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats, ModType... modType)
    {
        for(ModType mod : modType)
        {
            McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidStone(mod);
            makeRecipesStone(mcwBlockIdBase, output, modid, originalMod, MAT, stoneMats);
        }
    }

    protected void registerMcwHedge(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<Block> blockLeave)
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

                    if(result != null)
                    {
                        switch(recipeBase.getMethod())
                        {
                            case McwRecipesBase.RECIPE_SHAPED_WITH_1_ITEM:
                                recipeShapedWith1Item(output, leave, recipeBase.getPattern(), result, recipeBase.getCount(), leave, recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            default:
                                AddonsLib.LOGGER.error("Unknown recipe method: {} for {} item", recipeBase.getMethod(), modid + ":" + McwBlocksIdBase.replacement(blockId.id(), mat));
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

    public void registerAllMcwWood(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats)
    {
        registerMcwWood(output, modid, originalMod, MAT, woodMats, Registration.getAllModTypeWood());
    }

    public void registerAllMcwStone(Consumer<IFinishedRecipe> output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats)
    {
        registerMcwStone(output, modid, originalMod, MAT, stoneMats, Registration.getAllModTypeStone());
    }

    private String getHasName(IItemProvider item)
    {
        return "has_" + Finder.getIdOfItem(item.asItem());
    }

    protected void recipeShapelessWith1Item(Consumer<IFinishedRecipe> output, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String originalMod, String mcwMod)
    {
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwMod)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(shapeless(result, count)
                .requires(firstItem, required)
                .group(group)
                .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                .build(output, Finder.getRLOfItem(result.asItem()));
    }

    protected void recipeShapelessWith1ItemRecycle(Consumer<IFinishedRecipe> output, IItemProvider planks, IItemProvider result, int count, IItemProvider firstItem, int required, String group, String originalMod, String mcwMod)
    {
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwMod)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(shapeless(result, count)
                        .requires(firstItem, required)
                        .group(group)
                        .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                .build(output, new ResourceLocation(Finder.getModidOfItem(result.asItem()), Finder.getIdOfItem(result.asItem()) + "_recycle"));
    }

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

    protected void recipeShapedWith2Items(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, String group, String originalMod, String mcwMod)
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
                            .define('B', secondItem)
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
                            .define('B', secondItem)
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
                            .define('B', secondItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, Finder.getRLOfItem(result.asItem()));
        }
    }

    protected void recipeShapedWith3Items(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, IItemProvider thirdItem, String group, String originalMod, String mcwMod)
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
                            .define('B', secondItem)
                            .define('C', thirdItem)
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
                            .define('B', secondItem)
                            .define('C', thirdItem)
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
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, Finder.getRLOfItem(result.asItem()));
        }
    }

    protected void recipeShapedWith4Items(Consumer<IFinishedRecipe> output, IItemProvider planks, String[] pattern, IItemProvider result, int count, IItemProvider firstItem, IItemProvider secondItem, IItemProvider thirdItem, IItemProvider fourItem, String group, String originalMod, String mcwMod)
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
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .define('D', fourItem)
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
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .define('D', fourItem)
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
                            .define('B', secondItem)
                            .define('C', thirdItem)
                            .define('D', fourItem)
                            .group(group)
                            .unlockedBy(getHasName(planks), has(planks))::save).generateAdvancement()
                    .build(output, Finder.getRLOfItem(result.asItem()));
        }
    }

    protected void recipeStonecutter(Consumer<IFinishedRecipe> output, IItemProvider result, IItemProvider firstItem, String originalMod, String mcwMod)
    {
        String recipeId = Finder.getModidOfItem(result.asItem()) + ":" + Finder.getIdOfItem(result.asItem()) + "_stonecutter";
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(mcwMod)).addCondition(new ModLoadedCondition(originalMod))
                .addRecipe(c -> SingleItemRecipeBuilder.stonecutting(Ingredient.of(firstItem), result)
                        .unlocks(getHasName(firstItem), has(firstItem)).save(c, recipeId)).generateAdvancement()
                .build(output, new ResourceLocation(recipeId));
    }
}
