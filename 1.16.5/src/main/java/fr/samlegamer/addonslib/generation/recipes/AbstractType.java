package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;

import java.util.List;
import java.util.function.Consumer;

abstract class AbstractType {
    protected final String modid;
    protected final String originalMod;
    protected final McwRecipes mcwRecipes;

    public AbstractType(DataGenerator dataGenerator, String modid, String originalMod, String id)
    {
        this.modid = modid;
        this.originalMod = originalMod;
        this.mcwRecipes = new McwRecipes(dataGenerator, modid, id, originalMod);
    }

    public abstract void buildWood(Consumer<IFinishedRecipe> output, List<String> MAT, List<McwWoodMat> woodMat);
    public abstract void buildStone(Consumer<IFinishedRecipe> output, List<String> MAT, List<McwStoneMat> stoneMat);
    public abstract void buildHedge(Consumer<IFinishedRecipe> output, List<String> MAT, List<Block> leave);
}
