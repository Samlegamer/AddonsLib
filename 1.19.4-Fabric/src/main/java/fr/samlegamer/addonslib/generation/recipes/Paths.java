package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.List;
import java.util.function.Consumer;

class Paths extends AbstractType {
    private static final String id = "mcwpaths";

    public Paths(FabricDataOutput output, String modid, String originalMod)
    {
        super(output, modid, originalMod, id);
    }

    private void wood_variants(Consumer<RecipeJsonProvider> exporter, String mat, Block planks, Block slab)
    {
        Block planks_path = Finder.findBlock(modid, mat + "_planks_path");

        mcwRecipes.mkRpShapelessW1Item(exporter, planks, planks_path, 3, slab, "planks_paths");
    }

    @Override
    public void buildWood(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block planks = woodMat.get(i).getPlanks();
                Block slab = woodMat.get(i).getSlab();

                wood_variants(exporter, MAT.get(i), planks, slab);
            }
        }
    }

    @Override
    public void buildStone(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<McwStoneMat> stone) {

    }

    @Override
    public void buildHedge(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<Block> leave) {

    }
}
