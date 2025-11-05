package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Consumer;

class Stairs extends AbstractType {
    private static final String id = "mcwstairs";

    public Stairs(String modid, String originalMod)
    {
        super(modid, originalMod, id);
    }

    private void wood_variants(Consumer<FinishedRecipe> consumer, String mat, Block log, Block fence, Block slab, Block stripped_log)
    {
        Block balcony = Finder.findBlock(modid, mat + "_balcony");
        Block platform = Finder.findBlock(modid, mat + "_platform");
        Block compact_stairs = Finder.findBlock(modid, mat + "_compact_stairs");
        Block bulk_stairs = Finder.findBlock(modid, mat + "_bulk_stairs");
        Block loft_stairs = Finder.findBlock(modid, mat + "_loft_stairs");
        Block skyline_stairs = Finder.findBlock(modid, mat + "_skyline_stairs");
        Block terrace_stairs = Finder.findBlock(modid, mat + "_terrace_stairs");
        Block railing = Finder.findBlock(modid, mat + "_railing");

        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AAA", "B B", "AAA"}, balcony, 6, Items.STICK, fence, "mcwstairs_balcony");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{" BB", " AA", "   "}, platform, 12, log, slab, "mcwstairs_platform");
        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"A  ", "AA ", "AAA"}, compact_stairs, 6, stripped_log, "compact_stairs");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A  ", "BA ", "BBA"}, bulk_stairs, 6, stripped_log, log, "bulk_stairs");
        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"A  ", " A ", "  A"}, loft_stairs, 3, stripped_log, "loft_stairs");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A  ", "BA "}, skyline_stairs, 4, stripped_log, log, "skyline_stairs");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"A  ", "BA ", " BA"}, terrace_stairs, 5, stripped_log, log, "terrace_stairs");
        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"A  ", "AA ", "AAA"}, railing, 6, balcony, "mcwstairs_railing");
    }

    @Override
    public void buildWood(Consumer<FinishedRecipe> consumer, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block stripped_log = woodMat.get(i).getStrippedLog();
                Block slab = woodMat.get(i).getSlab();
                Block fence = woodMat.get(i).getFence();

                wood_variants(consumer, MAT.get(i), log, fence, slab, stripped_log);
            }
        }
    }

    @Override
    public void buildStone(Consumer<FinishedRecipe> consumer, List<String> MAT, List<McwStoneMat> stone) {

    }

    @Override
    public void buildHedge(Consumer<FinishedRecipe> consumer, List<String> MAT, List<Block> leave) {

    }
}
