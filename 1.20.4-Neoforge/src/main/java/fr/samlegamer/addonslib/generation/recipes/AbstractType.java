package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.block.Block;
import java.util.List;

abstract class AbstractType {
    protected final String modid;
    protected final String originalMod;
    protected final McwRecipes mcwRecipes;

    public AbstractType(PackOutput pOutput, String modid, String originalMod, String id)
    {
        this.modid = modid;
        this.originalMod = originalMod;
        this.mcwRecipes = new McwRecipes(pOutput, modid, id, originalMod);
    }

    public abstract void buildWood(RecipeOutput output, List<String> MAT, List<McwWoodMat> woodMat);
    public abstract void buildStone(RecipeOutput output, List<String> MAT, List<McwStoneMat> stoneMat);
    public abstract void buildHedge(RecipeOutput output, List<String> MAT, List<Block> leave);
}
