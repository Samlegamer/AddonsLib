package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

class Trapdoors extends AbstractType {
    private static final String id = "mcwtrpdoors";

    public Trapdoors(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, String modid, String originalMod)
    {
        super(output, registriesFuture, modid, originalMod, id);
    }

    private void trapdoor_variant(RecipeGenerator generator, RecipeExporter exporter, Block door_var, Block planks, Item print)
    {
        mcwRecipes.mkRpW2Items(generator, exporter, planks, new String[]{"A", "B", "A"}, door_var, 1, planks, print, Objects.requireNonNull(print.toString()).replace("print_", "")+"_trapdoors");
    }

    private void other_traps(RecipeGenerator generator, RecipeExporter exporter, String mat, Block log, Block planks, Block slab)
    {
        Block bark_trapdoor = Finder.findBlock(modid, mat + "_bark_trapdoor");
        Block glass_trapdoor = Finder.findBlock(modid, mat + "_glass_trapdoor");
        Block barn_trapdoor = Finder.findBlock(modid, mat + "_barn_trapdoor");
        Block ranch_trapdoor = Finder.findBlock(modid, mat + "_ranch_trapdoor");
        Block barrel_trapdoor = Finder.findBlock(modid, mat + "_barrel_trapdoor");

        mcwRecipes.mkRpW2Items(generator, exporter, log, new String[]{"ABA", "BBB", "ABA"}, ranch_trapdoor, 2, log, Items.STICK, "ranch_trapdoors");
        mcwRecipes.mkRpW2Items(generator, exporter, log, new String[]{"ABA", "ABA"}, bark_trapdoor, 2, log, Blocks.GLASS_PANE, "bark_trapdoors");
        mcwRecipes.mkRpW2Items(generator, exporter, planks, new String[]{"ABA", "ABA"}, glass_trapdoor, 2, planks, Blocks.GLASS_PANE, "glass_trapdoors");
        mcwRecipes.mkRpW2Items(generator, exporter, planks, new String[]{"A", "B"}, barn_trapdoor, 1, planks, glass_trapdoor, "barn_trapdoors");
        mcwRecipes.mkRpW2Items(generator, exporter, planks, new String[]{" A ", "ABA", " A "}, barrel_trapdoor, 4, planks, Blocks.BARREL, "barrel_trapdoors");
    }

    @Override
    public void buildWood(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<McwWoodMat> woodMat)
    {
        String[] variants = new String[]{"bamboo", "barred", "beach", "blossom",
                "classic", "cottage", "four_panel", "mystic", "paper", "swamp", "tropical", "whispering"};

        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block planks = woodMat.get(i).getPlanks();
                Block slab = woodMat.get(i).getSlab();

                other_traps(generator, exporter, MAT.get(i), log, planks, slab);

                for(String variant : variants)
                {
                    Item print = Finder.findItem(id, "print_" + variant);
                    Block door_var = Finder.findBlock(modid,  MAT.get(i) + "_" + variant + "_trapdoor");

                    trapdoor_variant(generator, exporter, door_var, planks, print);
                }
            }
        }
    }

    @Override
    public void buildStone(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<McwStoneMat> stone) {

    }

    @Override
    public void buildHedge(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<Block> leave) {

    }
}
