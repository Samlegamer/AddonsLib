package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

class Doors extends AbstractType {
    private static final String id = "mcwdoors";

    public Doors(String modid, String originalMod)
    {
        super(modid, originalMod, id);
    }

    private void door_variant(Consumer<IFinishedRecipe> consumer, Block door_var, Block planks, Item print)
    {
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"A", "B", "A"}, door_var, 1, planks, print, Objects.requireNonNull(print.getRegistryName()).getPath().replace("print_", ""));
    }

    private void other_door(Consumer<IFinishedRecipe> consumer, String mat, Block log, Block planks, Block slab)
    {
        Block bark_glass_door = Finder.findBlock(modid, mat + "_bark_glass_door");
        Block barn_door = Finder.findBlock(modid, mat + "_barn_door");
        Block barn_glass_door = Finder.findBlock(modid, mat + "_barn_glass_door");
        Block glass_door = Finder.findBlock(modid, mat + "_glass_door");
        Block japanese_door = Finder.findBlock(modid, mat + "_japanese_door");
        Block japanese2_door = Finder.findBlock(modid, mat + "_japanese2_door");
        Block modern_door = Finder.findBlock(modid, mat + "_modern_door");
        Block stable_door = Finder.findBlock(modid, mat + "_stable_door");
        Block stable_head_door = Finder.findBlock(modid, mat + "_stable_head_door");
        Block western_door = Finder.findBlock(modid, mat + "_western_door");

        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"  A", "ABA", "AAA"}, western_door, 3, planks, slab, "western");
        mcwRecipes.mkRpShapelessW1Item(consumer, planks, stable_head_door, 1, stable_door, "stable_head", "");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "AA", "AA"}, stable_door, 3, planks, Blocks.IRON_BARS, "stable");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"AB", "AA", "AB"}, modern_door, 3, planks, Blocks.GLASS_PANE, "modern");
        mcwRecipes.mkRpW2Items(consumer, slab, new String[]{"BB", "BB", "AA"}, japanese2_door, 3, slab, Items.PAPER, "shoji_two");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "BB", "AA"}, japanese_door, 3, planks, Items.PAPER, "shoji");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AB", "BB", "AB"}, bark_glass_door, 3, log, Blocks.GLASS, "bark");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"AB", "BB", "AB"}, glass_door, 3, planks, Blocks.GLASS_PANE, "glassed");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "AA", "AA"}, barn_door, 2, planks, Items.STICK, "barn");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "AA", "AA"}, barn_glass_door, 3, planks, Blocks.GLASS_PANE, "barn_glass");
    }

    @Override
    public void buildWood(Consumer<IFinishedRecipe> consumer, List<String> MAT, List<McwWoodMat> woodMat)
    {
        Map<String, String> variants = getStringStringMap();

        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block planks = woodMat.get(i).getPlanks();
                Block slab = woodMat.get(i).getSlab();

                other_door(consumer, MAT.get(i), log, planks, slab);

                for(Map.Entry<String, String> variant : variants.entrySet())
                {
                    Item print = Finder.findItem(id, "print_" + variant.getValue());
                    Block door_var = Finder.findBlock(modid,  MAT.get(i) + "_" + variant.getKey() + "_door");

                    door_variant(consumer, door_var, planks, print);
                }

            }
        }
    }

    @Override
    public void buildStone(Consumer<IFinishedRecipe> consumer, List<String> MAT, List<McwStoneMat> stoneMat) {

    }

    @Override
    public void buildHedge(Consumer<IFinishedRecipe> consumer, List<String> MAT, List<Block> leave) {

    }

    private Map<String, String> getStringStringMap() {
        Map<String, String> variants = new HashMap<>();

        variants.put("bamboo", "bamboo");
        variants.put("beach", "jungle");
        variants.put("classic", "oak");
        variants.put("cottage", "spruce");
        variants.put("four_panel", "dark_oak");
        variants.put("mystic", "mystic");
        variants.put("nether", "nether");
        variants.put("paper", "birch");
        variants.put("swamp", "swamp");
        variants.put("tropical", "acacia");
        variants.put("waffle", "waffle");
        variants.put("whispering", "whispering");
        return variants;
    }
}
