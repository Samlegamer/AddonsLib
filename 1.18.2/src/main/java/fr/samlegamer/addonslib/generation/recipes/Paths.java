package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.block.Block;
import java.util.List;
import java.util.function.Consumer;

class Paths extends AbstractType {
    private static final String id = "mcwpaths";

    public Paths(DataGenerator dataGenerator, String modid, String originalMod) {
        super(dataGenerator, modid, originalMod, id);
    }

    private void wood_variants(Consumer<FinishedRecipe> consumer, String mat, Block planks, Block slab)
    {
        Block planks_path = Finder.findBlock(modid, mat + "_planks_path");

        mcwRecipes.mkRpShapelessW1Item(consumer, planks, planks_path, 3, slab, "planks_paths");
    }

    @Override
    public void buildWood(Consumer<FinishedRecipe> consumer, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block planks = woodMat.get(i).getPlanks();
                Block slab = woodMat.get(i).getSlab();

                wood_variants(consumer, MAT.get(i), planks, slab);
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
