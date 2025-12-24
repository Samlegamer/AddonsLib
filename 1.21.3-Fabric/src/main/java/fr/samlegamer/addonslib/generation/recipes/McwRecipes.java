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
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.server.recipe.RecipeGenerator.hasItem;
import static net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder.createStonecutting;

public abstract class McwRecipes extends FabricRecipeProvider
{
    public McwRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private void makeRecipesWood(McwBlockIdBase mcwBlockIdBase, RecipeGenerator generator, RecipeExporter output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats)
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
                                recipeShapedWith1Item(generator, output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE:
                                recipeShapelessWith1ItemRecycle(generator, output, woodMat.getLog(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM:
                                recipeShapelessWith1Item(generator, output, woodMat.getLog(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_2_ITEMS:
                                recipeShapedWith2Items(generator, output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_3_ITEMS:
                                recipeShapedWith3Items(generator, output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[2]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_4_ITEMS:
                                recipeShapedWith4Items(generator, output, woodMat.getLog(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[0]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[1]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[2]), replaceTypeWood(modid, mat, woodMat, recipeBase.getCraftingItems()[3]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
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

    private void makeRecipesStone(McwBlockIdBase mcwBlockIdBase, RecipeGenerator generator, RecipeExporter output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats)
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
                                recipeShapedWith1Item(generator, output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE:
                                recipeShapelessWith1ItemRecycle(generator, output, stoneMat.getStoneBase(), result, recipeBase.getCount(), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPELESS_WITH_1_ITEM:
                                recipeShapelessWith1Item(generator, output, stoneMat.getStoneBase(), result, recipeBase.getCount(), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), recipeBase.getCraftingItems()[0].getRequiredCount(), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_2_ITEMS:
                                recipeShapedWith2Items(generator, output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[1]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_3_ITEMS:
                                recipeShapedWith3Items(generator, output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[1]), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[2]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_SHAPED_WITH_4_ITEMS:
                                recipeShapedWith4Items(generator, output, stoneMat.getStoneBase(), recipeBase.getPattern(), result, recipeBase.getCount(), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[1]), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[2]), replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[3]), recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
                                break;
                            case McwRecipesBase.RECIPE_STONECUTTER:
                                recipeStonecutter(generator, output, result, replaceTypeStone(modid, mat, stoneMat, recipeBase.getCraftingItems()[0]), originalMod, mcwBlockIdBase.modid());
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
            case "stripped_table":
                return Finder.findItem(MODID, "stripped_"+mat+"_table");
            case "table":
                return Finder.findItem(MODID, mat+"_table");
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

    private Item replaceTypeStone(String MODID, String mat, McwStoneMat<Block> woodMat, CraftingIngredient type)
    {
        switch(type.getName())
        {
            case "stone_bridge":
                return Finder.findItem(MODID, mat+"_bridge");
            case "stone_bridge_stair":
                return Finder.findItem(MODID, mat+"_bridge_stair");
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

    protected void registerMcwWood(RecipeGenerator generator, RecipeExporter output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats, ModType... modType)
    {
        for(ModType mod : modType)
        {
            McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidWood(mod);
            makeRecipesWood(mcwBlockIdBase, generator, output, modid, originalMod, MAT, woodMats);
        }
    }

    protected void registerMcwStone(RecipeGenerator generator, RecipeExporter output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats, ModType... modType)
    {
        for(ModType mod : modType)
        {
            McwBlockIdBase mcwBlockIdBase = McwBlocksIdBase.getBlocksWithModidStone(mod);
            makeRecipesStone(mcwBlockIdBase, generator, output, modid, originalMod, MAT, stoneMats);
        }
    }

    protected void registerMcwHedge(RecipeGenerator generator, RecipeExporter output, String modid, String originalMod, List<String> MAT, List<Block> blockLeave)
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
                                recipeShapedWith1Item(generator, output, leave, recipeBase.getPattern(), result, recipeBase.getCount(), leave, recipeBase.getGroup(), originalMod, mcwBlockIdBase.modid());
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

    public void registerAllMcwWood(RecipeGenerator generator, RecipeExporter output, String modid, String originalMod, List<String> MAT, List<McwWoodMat<Block>> woodMats)
    {
        registerMcwWood(generator, output, modid, originalMod, MAT, woodMats, Registration.getAllModTypeWood());
    }

    public void registerAllMcwStone(RecipeGenerator generator, RecipeExporter output, String modid, String originalMod, List<String> MAT, List<McwStoneMat<Block>> stoneMats)
    {
        registerMcwStone(generator, output, modid, originalMod, MAT, stoneMats, Registration.getAllModTypeStone());
    }


    protected void recipeStonecutter(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible result, ItemConvertible firstItem, String originalMod, String mcwModid)
    {
        String recipeId = Objects.requireNonNull(result.asItem().toString()) + "_stonecutter";
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));

        var builder = createStonecutting(Ingredient.ofItems(firstItem), RecipeCategory.BUILDING_BLOCKS, result)
                .criterion(hasItem(firstItem), generator.conditionsFromItem(firstItem));

        builder.offerTo(recipeExporter, recipeId);
    }

    protected void recipeShapedWith4Items(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, ItemConvertible thirdItem, ItemConvertible fourItem, String group, String originalMod, String mcwModid)
    {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .input('D', fourItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .input('D', fourItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .input('D', fourItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void recipeShapedWith3Items(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, ItemConvertible thirdItem, String group, String originalMod, String mcwModid)
    {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .input('A', firstItem)
                                    .input('B', secondItem)
                                    .input('C', thirdItem)
                                    .group(group)
                                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .input('C', thirdItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void recipeShapedWith2Items(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, ItemConvertible secondItem, String group, String originalMod, String mcwModid)
    {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                                    .pattern(pattern[0])
                                    .pattern(pattern[1])
                                    .pattern(pattern[2])
                                    .input('A', firstItem)
                                    .input('B', secondItem)
                                    .group(group)
                                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .input('B', secondItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void recipeShapedWith1Item(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible planks, String[] pattern, ItemConvertible result, int count, ItemConvertible firstItem, String group, String originalMod, String mcwModid)
    {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;
        if(pattern.length == 3)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .pattern(pattern[2])
                    .input('A', firstItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else if(pattern.length == 2)
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .pattern(pattern[1])
                    .input('A', firstItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }
        else
        {
            shapedRecipeJsonBuilder = ShapedRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                    .pattern(pattern[0])
                    .input('A', firstItem)
                    .group(group)
                    .criterion(hasItem(planks), generator.conditionsFromItem(planks));
        }

        shapedRecipeJsonBuilder.offerTo(recipeExporter);
    }

    protected void recipeShapelessWith1ItemRecycle(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, int required, String group, String originalMod, String mcwModid)
    {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        ShapelessRecipeJsonBuilder shapelessRecipeJsonBuilder =
                ShapelessRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                .input(firstItem, required)
                .group(group).criterion(hasItem(planks), generator.conditionsFromItem(planks));

        shapelessRecipeJsonBuilder.offerTo(recipeExporter, result.asItem().toString() + "_recycle");
    }

    protected void recipeShapelessWith1Item(RecipeGenerator generator, RecipeExporter exporter, ItemConvertible planks, ItemConvertible result, int count, ItemConvertible firstItem, int required, String group, String originalMod, String mcwModid)
    {
        var recipeExporter = withConditions(exporter, ResourceConditions.allModsLoaded(originalMod, mcwModid));
        ShapelessRecipeJsonBuilder shapelessRecipeJsonBuilder =
                ShapelessRecipeJsonBuilder.create(generator.itemLookup, RecipeCategory.BUILDING_BLOCKS, result, count)
                        .input(firstItem, required)
                        .group(group).criterion(hasItem(planks), generator.conditionsFromItem(planks));

        shapelessRecipeJsonBuilder.offerTo(recipeExporter);
    }
}
