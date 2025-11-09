package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.block.Block;
import java.util.List;

abstract class AbstractType {
    protected final String modid;
    protected final String originalMod;
    protected final McwRecipes mcwRecipes;

    public AbstractType(HolderLookup.Provider registries, RecipeOutput output, String modid, String originalMod, String id)
    {
        this.modid = modid;
        this.originalMod = originalMod;
        this.mcwRecipes = new McwRecipes(registries, output, modid, id, originalMod);
    }

    public abstract void buildWood(RecipeOutput output, List<String> MAT, List<McwWoodMat> woodMat);
    public abstract void buildStone(RecipeOutput output, List<String> MAT, List<McwStoneMat> stoneMat);
    public abstract void buildHedge(RecipeOutput output, List<String> MAT, List<Block> leave);
}
