package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

abstract class AbstractType {
    protected final String modid;
    protected final String originalMod;
    protected final McwRecipes mcwRecipes;

    public AbstractType(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, String modid, String originalMod, String id)
    {
        this.modid = modid;
        this.originalMod = originalMod;
        this.mcwRecipes = new McwRecipes(output, registriesFuture, modid, id, originalMod);
    }

    public abstract void buildWood(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<McwWoodMat> woodMat);
    public abstract void buildStone(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<McwStoneMat> stoneMat);
    public abstract void buildHedge(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<Block> leave);
}
