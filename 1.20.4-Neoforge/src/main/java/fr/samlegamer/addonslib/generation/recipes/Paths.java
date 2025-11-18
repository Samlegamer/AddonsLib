package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.block.Block;
import java.util.List;

class Paths extends AbstractType {
    private static final String id = "mcwpaths";

    public Paths(PackOutput pOutput, String modid, String originalMod) {
        super(pOutput, modid, originalMod, id);
    }

    private void wood_variants(RecipeOutput consumer, String mat, Block planks, Block slab)
    {
        Block planks_path = Finder.findBlock(modid, mat + "_planks_path");

        mcwRecipes.mkRpShapelessW1Item(consumer, planks, planks_path, 3, slab, "planks_paths");
    }

    @Override
    public void buildWood(RecipeOutput consumer, List<String> MAT, List<McwWoodMat> woodMat)
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
    public void buildStone(RecipeOutput consumer, List<String> MAT, List<McwStoneMat> stone) {

    }

    @Override
    public void buildHedge(RecipeOutput consumer, List<String> MAT, List<Block> leave) {

    }
}
