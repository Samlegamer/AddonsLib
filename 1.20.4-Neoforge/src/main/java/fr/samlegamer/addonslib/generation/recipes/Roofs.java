package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import java.util.List;

class Roofs extends AbstractType {
    private static final String id = "mcwroofs";

    public Roofs(PackOutput pOutput, String modid, String originalMod) {
        super(pOutput, modid, originalMod, id);
    }

    private void wood_variants(RecipeOutput consumer, String mat, Block log, Block planks)
    {
        Block roof = Finder.findBlock(modid, mat + "_roof");
        Block attic_roof = Finder.findBlock(modid, mat + "_attic_roof");
        Block top_roof = Finder.findBlock(modid, mat + "_top_roof");
        Block lower_roof = Finder.findBlock(modid, mat + "_lower_roof");
        Block steep_roof = Finder.findBlock(modid, mat + "_steep_roof");
        Block upper_lower_roof = Finder.findBlock(modid, mat + "_upper_lower_roof");
        Block upper_steep_roof = Finder.findBlock(modid, mat + "_upper_steep_roof");

        Block planks_roof = Finder.findBlock(modid, mat + "_planks_roof");
        Block planks_attic_roof = Finder.findBlock(modid, mat + "_planks_attic_roof");
        Block planks_top_roof = Finder.findBlock(modid, mat + "_planks_top_roof");
        Block planks_lower_roof = Finder.findBlock(modid, mat + "_planks_lower_roof");
        Block planks_steep_roof = Finder.findBlock(modid, mat + "_planks_steep_roof");
        Block planks_upper_lower_roof = Finder.findBlock(modid, mat + "_planks_upper_lower_roof");
        Block planks_upper_steep_roof = Finder.findBlock(modid, mat + "_planks_upper_steep_roof");

        mcwRecipes.mkRpW2Items(consumer, log, new String[]{" A", "AB"}, roof, 2, log, Items.STICK, "roof");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{" A", "AB"}, attic_roof, 2, log, Items.GLASS, "attic_roof");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"ABA"}, top_roof, 2, log, Items.STICK, "top_roof");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{" AA", "AAB"}, lower_roof, 4, log, Items.STICK, "lower_roof");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{" A", "AA", "AB"}, steep_roof, 4, log, Items.STICK, "steep_roof");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"  A", "AAB"}, upper_lower_roof, 3, log, Items.STICK, "upper_lower_roof");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{" A", " A", "AB"}, upper_steep_roof, 3, log, Items.STICK, "upper_steep_roof");

        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{" A", "AB"}, planks_roof, 2, planks, Items.STICK, "planks_roof");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{" A", "AB"}, planks_attic_roof, 2, planks, Items.GLASS, "planks_attic_roof");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"ABA"}, planks_top_roof, 2, planks, Items.STICK, "planks_top_roof");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{" AA", "AAB"}, planks_lower_roof, 4, planks, Items.STICK, "planks_lower_roof");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{" A", "AA", "AB"}, planks_steep_roof, 4, planks, Items.STICK, "planks_steep_roof");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"  A", "AAB"}, planks_upper_lower_roof, 3, planks, Items.STICK, "planks_upper_lower_roof");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{" A", " A", "AB"}, planks_upper_steep_roof, 3, planks, Items.STICK, "planks_upper_steep_roof");

    }

    private void stone_variants(RecipeOutput consumer, String mat, Block stone)
    {
        Block roof = Finder.findBlock(modid, mat + "_roof");
        Block attic_roof = Finder.findBlock(modid, mat + "_attic_roof");
        Block top_roof = Finder.findBlock(modid, mat + "_top_roof");
        Block lower_roof = Finder.findBlock(modid, mat + "_lower_roof");
        Block steep_roof = Finder.findBlock(modid, mat + "_steep_roof");
        Block upper_lower_roof = Finder.findBlock(modid, mat + "_upper_lower_roof");
        Block upper_steep_roof = Finder.findBlock(modid, mat + "_upper_steep_roof");

        mcwRecipes.mkScW1Item(consumer, roof, stone);
        mcwRecipes.mkScW1Item(consumer, attic_roof, stone);
        mcwRecipes.mkScW1Item(consumer, top_roof, stone);
        mcwRecipes.mkScW1Item(consumer, lower_roof, stone);
        mcwRecipes.mkScW1Item(consumer, steep_roof, stone);
        mcwRecipes.mkScW1Item(consumer, upper_lower_roof, stone);
        mcwRecipes.mkScW1Item(consumer, upper_steep_roof, stone);
    }

    @Override
    public void buildWood(RecipeOutput consumer, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block planks = woodMat.get(i).getPlanks();

                wood_variants(consumer, MAT.get(i), log, planks);
            }
        }
    }

    @Override
    public void buildStone(RecipeOutput consumer, List<String> MAT, List<McwStoneMat> stone)
    {
        if(MAT.size() == stone.size())
        {
            for (int i = 0; i < MAT.size(); i++)
            {
                stone_variants(consumer, MAT.get(i), stone.get(i).getStoneBase());
            }
        }
    }

    @Override
    public void buildHedge(RecipeOutput consumer, List<String> MAT, List<Block> leave) {

    }
}
