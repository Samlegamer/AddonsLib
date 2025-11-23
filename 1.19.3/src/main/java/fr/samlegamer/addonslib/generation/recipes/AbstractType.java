package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.block.Block;
import java.util.List;
import java.util.function.Consumer;

abstract class AbstractType {
    protected final String modid;
    protected final String originalMod;
    protected final McwRecipes mcwRecipes;

    public AbstractType(PackOutput packOutput, String modid, String originalMod, String id)
    {
        this.modid = modid;
        this.originalMod = originalMod;
        this.mcwRecipes = new McwRecipes(packOutput, modid, id, originalMod);
    }

    public abstract void buildWood(Consumer<FinishedRecipe> output, List<String> MAT, List<McwWoodMat> woodMat);
    public abstract void buildStone(Consumer<FinishedRecipe> output, List<String> MAT, List<McwStoneMat> stoneMat);
    public abstract void buildHedge(Consumer<FinishedRecipe> output, List<String> MAT, List<Block> leave);
}
