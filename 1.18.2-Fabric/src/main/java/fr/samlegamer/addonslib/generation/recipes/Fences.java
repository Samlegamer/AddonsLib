package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import java.util.List;
import java.util.function.Consumer;

class Fences extends AbstractType {
    private static final String id = "mcwfences";

    public Fences(FabricDataGenerator dataGenerator, String modid, String originalMod)
    {
        super(dataGenerator, modid, originalMod, id);
    }

    private void wood_variants(Consumer<RecipeJsonProvider> exporter, String mat, Block log, Block planks)
    {
        Block curved_gate = Finder.findBlock(modid, mat + "_curved_gate");
        Block highley_gate = Finder.findBlock(modid, mat + "_highley_gate");
        Block horse_fence = Finder.findBlock(modid, mat + "_horse_fence");
        Block picket_fence = Finder.findBlock(modid, mat + "_picket_fence");
        Block pyramid_gate = Finder.findBlock(modid, mat + "_pyramid_gate");
        Block stockade_fence = Finder.findBlock(modid, mat + "_stockade_fence");
        Block wired_fence = Finder.findBlock(modid, mat + "_wired_fence");

        mcwRecipes.mkRpW2Items(exporter, planks, new String[]{"B A", "BAA"}, curved_gate, 4, planks, log, "curved_gate");
        mcwRecipes.mkRpW2Items(exporter, planks, new String[]{"ABA", "ABA"}, highley_gate, 1, Items.STICK, log, "highley");
        mcwRecipes.mkRpW2Items(exporter, planks, new String[]{"ABA", "BAB"}, horse_fence, 3, log, Items.STICK, "horse");
        mcwRecipes.mkRpW3Items(exporter, planks, new String[]{"CBC", "CAC"}, picket_fence, 3, Items.STICK, planks, log, "picket");
        mcwRecipes.mkRpW3Items(exporter, planks, new String[]{"ABA", "ACA"}, pyramid_gate, 1, Items.STICK, log, planks, "pyramid");
        mcwRecipes.mkRpW2Items(exporter, planks, new String[]{"ABA", "BAB"}, stockade_fence, 3, log, planks, "stockade");
        mcwRecipes.mkRpW3Items(exporter, planks, new String[]{"ACA", "ABA"}, wired_fence, 3, Items.STICK, log, Blocks.IRON_BARS, "wired");
    }

    private void hedge(Consumer<RecipeJsonProvider> exporter, Block hedge, Block leave)
    {
        mcwRecipes.mkRpW1Item(exporter, leave, new String[]{"AA", "AA"}, hedge, 4, leave, "hedge");
    }

    private void stone_variants(Consumer<RecipeJsonProvider> exporter, String mat, Block stone, Block smoothStone)
    {
        Block modern_wall = Finder.findBlock(modid, "modern_" + mat + "_wall");
        Block railing_wall = Finder.findBlock(modid, "railing_" + mat + "_wall");
        Block grass_topped_wall = Finder.findBlock(modid, mat + "_grass_topped_wall");
        Block pillar_wall = Finder.findBlock(modid, mat + "_pillar_wall");
        Block railing_gate = Finder.findBlock(modid, mat + "_railing_gate");

        mcwRecipes.mkRpW2Items(exporter, stone, new String[]{"ABA", "AAA"}, modern_wall, 6, smoothStone, stone, "modern");
        mcwRecipes.mkScW1Item(exporter, modern_wall, stone);
        mcwRecipes.mkRpW2Items(exporter, stone, new String[]{"ABA", "AAA"}, railing_wall, 6, smoothStone, Blocks.IRON_BARS, "railing_wall");
        mcwRecipes.mkScW1Item(exporter, railing_wall, stone);
        mcwRecipes.mkRpW3Items(exporter, stone, new String[]{"BCB", "AAA"}, grass_topped_wall, 6, smoothStone, stone, Blocks.DIRT, "grass_topped");
        mcwRecipes.mkRpW2Items(exporter, stone, new String[]{"AAA", "B B"}, pillar_wall, 5, smoothStone, stone, "pillarwall");
        mcwRecipes.mkRpW2Items(exporter, stone, new String[]{"ABA", "ABA"}, railing_gate, 1, Blocks.IRON_BARS, stone, "railing_gate");
        mcwRecipes.mkScW1Item(exporter, railing_gate, stone);
    }

    @Override
    public void buildWood(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block planks = woodMat.get(i).getPlanks();

                wood_variants(exporter, MAT.get(i), log, planks);
            }
        }
    }

    @Override
    public void buildStone(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<McwStoneMat> stoneMat)
    {
        if(MAT.size() == stoneMat.size())
        {
            for (int i = 0; i < MAT.size(); i++)
            {
                stone_variants(exporter, MAT.get(i), stoneMat.get(i).getStoneBase(), stoneMat.get(i).getSmoothStone());
            }
        }
    }

    @Override
    public void buildHedge(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<Block> leave)
    {
        if(MAT.size() == leave.size())
        {
            for (int i = 0; i < MAT.size(); i++)
            {
                Block hedge = Finder.findBlock(modid, MAT.get(i) + "_hedge");

                hedge(exporter, hedge, leave.get(i));
            }
        }
    }
}
