package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.List;
import java.util.function.Consumer;

class Furnitures extends AbstractType {
    private static final String id = "mcwfurnitures";

    public Furnitures(DataGenerator dataGenerator, String modid, String originalMod) {
        super(dataGenerator, modid, originalMod, id);
    }

    private void wood_variants(Consumer<IFinishedRecipe> consumer, String mat, Block log, Block slab, Block fence, boolean isStripped)
    {
        String strippedMat = isStripped ? "stripped_" : "";
        Item cabinet_door = Finder.findItem(id, "cabinet_door");
        Item cabinet_drawer = Finder.findItem(id, "cabinet_drawer");

        Block bookshelf = Finder.findBlock(modid, strippedMat + mat + "_bookshelf");
        Block bookshelf_cupboard = Finder.findBlock(modid, strippedMat + mat + "_bookshelf_cupboard");
        Block bookshelf_drawer = Finder.findBlock(modid, strippedMat + mat + "_bookshelf_drawer");
        Block lower_bookshelf_drawer = Finder.findBlock(modid, strippedMat + mat + "_lower_bookshelf_drawer");
        Block chair = Finder.findBlock(modid, strippedMat + mat + "_chair");
        Block modern_chair = Finder.findBlock(modid, strippedMat + mat + "_modern_chair");
        Block striped_chair = Finder.findBlock(modid, strippedMat + mat + "_striped_chair");
        Block stool_chair = Finder.findBlock(modid, strippedMat + mat + "_stool_chair");
        Block coffee_table = Finder.findBlock(modid, strippedMat + mat + "_coffee_table");
        Block table = Finder.findBlock(modid, strippedMat + mat + "_table");
        Block end_table = Finder.findBlock(modid, strippedMat + mat + "_end_table");
        Block glass_table = Finder.findBlock(modid, strippedMat + mat + "_glass_table");
        Block covered_desk = Finder.findBlock(modid, strippedMat + mat + "_covered_desk");
        Block modern_desk = Finder.findBlock(modid, strippedMat + mat + "_modern_desk");
        Block desk = Finder.findBlock(modid, strippedMat + mat + "_desk");
        Block drawer = Finder.findBlock(modid, strippedMat + mat + "_drawer");
        Block double_drawer = Finder.findBlock(modid, strippedMat + mat + "_double_drawer");
        Block triple_drawer = Finder.findBlock(modid, strippedMat + mat + "_triple_drawer");
        Block large_drawer = Finder.findBlock(modid, strippedMat + mat + "_large_drawer");
        Block lower_triple_drawer = Finder.findBlock(modid, strippedMat + mat + "_lower_triple_drawer");
        Block wardrobe = Finder.findBlock(modid, strippedMat + mat + "_wardrobe");
        Block modern_wardrobe = Finder.findBlock(modid, strippedMat + mat + "_modern_wardrobe");
        Block double_wardrobe = Finder.findBlock(modid, strippedMat + mat + "_double_wardrobe");
        Block kitchen_cabinet = Finder.findBlock(modid, strippedMat + mat + "_kitchen_cabinet");
        Block double_kitchen_cabinet = Finder.findBlock(modid, strippedMat + mat + "_double_kitchen_cabinet");
        Block glass_kitchen_cabinet = Finder.findBlock(modid, strippedMat + mat + "_glass_kitchen_cabinet");
        Block counter = Finder.findBlock(modid, strippedMat + mat + "_counter");
        Block drawer_counter = Finder.findBlock(modid, strippedMat + mat + "_drawer_counter");
        Block double_drawer_counter = Finder.findBlock(modid, strippedMat + mat + "_double_drawer_counter");
        Block cupboard_counter = Finder.findBlock(modid, strippedMat + mat + "_cupboard_counter");
        Block kitchen_sink = Finder.findBlock(modid, strippedMat + mat + "_kitchen_sink");

        // Bibliothèques (Bookshelves)
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "BBB", "AAA"}, bookshelf, 4, log, Items.BOOK, "bookshelf");
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{"AAA", "BAC", "AAA"}, bookshelf_cupboard, 4, log, cabinet_door, Items.BOOK, "bookshelf_cupboard");
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{"AAA", "ABA", "ACA"}, bookshelf_drawer, 4, log, cabinet_drawer, Items.BOOK, "bookshelf_drawer");
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{"AAA", "ACA", "ABA"}, lower_bookshelf_drawer, 4, log, cabinet_drawer, Items.BOOK, "lower_bookshelf_drawer");

        // Chaises (Chairs)
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{" A", "BA", "CC"}, chair, 1, log, slab, fence, "chair");
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{"BA", "CC"}, modern_chair, 1, log, slab, fence, "modern_chair");
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{" A", "BC", "CC"}, striped_chair, 1, log, slab, fence, "striped_chair");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "A", "B"}, stool_chair, 1, log, fence, "stool_chair");

        // Tables
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, coffee_table, 1, log, fence, "coffee_table");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, table, 1, coffee_table, fence, "table");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, end_table, 1, table, log, "end_table");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, glass_table, 1, end_table, Items.GLASS, "glass_table");

        // Bureaux (Desks)
        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"AAA", "A A"}, covered_desk, 2, log, "covered_desk");
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{"AAA", "BCB"}, modern_desk, 2, log, fence, Items.STICK, "modern_desk");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "B B"}, desk, 2, log, fence, "desk");

        // Tiroirs (Drawers)
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "ABA", "AAA"}, drawer, 4, log, cabinet_drawer, "drawer");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "ABA", "ABA"}, double_drawer, 4, log, cabinet_drawer, "double_drawer");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "ABA", "BAB"}, triple_drawer, 4, log, cabinet_drawer, "triple_drawer");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"ABA", "AAA", "AAA"}, large_drawer, 4, log, cabinet_drawer, "large_drawer");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "BAB", "ABA"}, lower_triple_drawer, 4, log, cabinet_drawer, "lower_triple_drawer");

        // Armoires (Wardrobes)
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "ABA", "AAA"}, wardrobe, 4, log, cabinet_door, "wardrobe");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "AAB", "AAA"}, modern_wardrobe, 4, log, cabinet_door, "modern_wardrobe");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "BAB", "AAA"}, double_wardrobe, 4, log, cabinet_door, "double_wardrobe");

        // Armoires de cuisine (Kitchen Cabinets)
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AA", "AB", "AA"}, kitchen_cabinet, 4, log, cabinet_door, "kitchen_cabinet");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AA", "BB", "AA"}, double_kitchen_cabinet, 4, log, cabinet_door, "double_kitchen_cabinet");
        mcwRecipes.mkRpW3Items(consumer, log, new String[]{"AA", "BC", "AA"}, glass_kitchen_cabinet, 4, log, Items.GLASS, cabinet_door, "glass_kitchen_cabinet");

        // Comptoirs (Counters)
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, counter, 1, slab, log, "counter");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, drawer_counter, 1, slab, drawer, "drawer_counter");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, double_drawer_counter, 1, slab, double_drawer, "double_drawer_counter");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A", "B"}, cupboard_counter, 1, slab, wardrobe, "cupboard_counter");

        // Furniture 3.4.0
        mcwRecipes.mkRpW4Items(consumer, log, new String[]{"CDC", "ABA", "ABA"}, kitchen_sink, 1, log, Items.WATER_BUCKET, slab, Blocks.CAULDRON, "kitchen_sink");
    }

    @Override
    public void buildWood(Consumer<IFinishedRecipe> consumer, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block slab = woodMat.get(i).getSlab();
                Block fence = woodMat.get(i).getFence();
                Block stripped_log = woodMat.get(i).getStrippedLog();

                wood_variants(consumer, MAT.get(i), log, slab, fence, false);
                wood_variants(consumer, MAT.get(i), stripped_log, slab, fence, true);
            }
        }
    }

    @Override
    public void buildStone(Consumer<IFinishedRecipe> consumer, List<String> MAT, List<McwStoneMat> stone) {

    }

    @Override
    public void buildHedge(Consumer<IFinishedRecipe> consumer, List<String> MAT, List<Block> leave) {

    }
}
