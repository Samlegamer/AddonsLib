package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Objects;

class Trapdoors extends AbstractType {
    private static final String id = "mcwtrpdoors";

    public Trapdoors(HolderLookup.Provider registries, RecipeOutput output, String modid, String originalMod) {
        super(registries, output, modid, originalMod, id);
    }

    private void trapdoor_variant(RecipeOutput consumer, Block door_var, Block planks, Item print)
    {
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"A", "B", "A"}, door_var, 1, planks, print, Objects.requireNonNull(print.toString()).replace("print_", "")+"_trapdoors");
    }

    private void other_traps(RecipeOutput consumer, String mat, Block log, Block planks, Block slab)
    {
        Block bark_trapdoor = Finder.findBlock(modid, mat + "_bark_trapdoor");
        Block glass_trapdoor = Finder.findBlock(modid, mat + "_glass_trapdoor");
        Block barn_trapdoor = Finder.findBlock(modid, mat + "_barn_trapdoor");
        Block ranch_trapdoor = Finder.findBlock(modid, mat + "_ranch_trapdoor");
        Block barrel_trapdoor = Finder.findBlock(modid, mat + "_barrel_trapdoor");

        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"ABA", "BBB", "ABA"}, ranch_trapdoor, 2, log, Items.STICK, "ranch_trapdoors");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"ABA", "ABA"}, bark_trapdoor, 2, log, Blocks.GLASS_PANE, "bark_trapdoors");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"ABA", "ABA"}, glass_trapdoor, 2, planks, Blocks.GLASS_PANE, "glass_trapdoors");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"A", "B"}, barn_trapdoor, 1, planks, glass_trapdoor, "barn_trapdoors");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{" A ", "ABA", " A "}, barrel_trapdoor, 4, planks, Blocks.BARREL, "barrel_trapdoors");
    }

    @Override
    public void buildWood(RecipeOutput consumer, List<String> MAT, List<McwWoodMat> woodMat)
    {
        String[] variants = new String[]{"bamboo", "barred", "beach", "blossom",
                "classic", "cottage", "four_panel", "mystic", "paper", "swamp", "tropical", "whispering"};

        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block planks = woodMat.get(i).getPlanks();
                Block slab = woodMat.get(i).getSlab();

                other_traps(consumer, MAT.get(i), log, planks, slab);

                for(String variant : variants)
                {
                    Item print = Finder.findItem(id, "print_" + variant);
                    Block door_var = Finder.findBlock(modid,  MAT.get(i) + "_" + variant + "_trapdoor");

                    trapdoor_variant(consumer, door_var, planks, print);
                }
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
