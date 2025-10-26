package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
        mcwRecipes.mkRpW1Item(consumer, planks, new String[]{"A"}, stable_head_door, 1, stable_door, "stable_head");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "AA", "AA"}, stable_door, 3, planks, Blocks.IRON_BARS, "stable");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"AB", "AA", "AB"}, modern_door, 3, planks, Blocks.GLASS_PANE, "modern");
        mcwRecipes.mkRpW2Items(consumer, slab, new String[]{"BB", "BB", "AA"}, japanese2_door, 3, slab, Items.PAPER, "shoji_two");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "BB", "AA"}, japanese_door, 3, planks, Items.PAPER, "shoji");
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"AB", "BB", "AB"}, bark_glass_door, 3, log, Blocks.GLASS, "bark");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"AB", "BB", "AB"}, glass_door, 3, planks, Blocks.GLASS_PANE, "glassed");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "AA", "AA"}, barn_door, 2, planks, Items.STICK, "barn");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"BB", "AA", "AA"}, barn_glass_door, 3, planks, Blocks.GLASS_PANE, "barn_glass");
    }

    public void buildWood(Consumer<IFinishedRecipe> consumer, Map<String, Boolean> MAT)
    {
        for(Map.Entry<String, Boolean> idAndIsStem : MAT.entrySet())
        {
            Block log = Finder.findBlock(originalMod, idAndIsStem.getKey() + (idAndIsStem.getValue() ? "_stem" : "_log"));
            Block planks = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_planks");
            Block slab = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_slab");

            other_door(consumer, idAndIsStem.getKey(), log, planks, slab);

            String[] variants = new String[]{"bamboo", "jungle", "oak", "spruce",
            "dark_oak", "mystic", "nether", "birch", "swamp", "acacia",
            "waffle", "whispering"};

            for(String variant : variants)
            {
                Item print = Finder.findItem(id, "print_" + variant);
                Block door_var = Finder.findBlock(modid,  idAndIsStem.getKey() + "_" + variant + "_door");

                door_variant(consumer, door_var, planks, print);
            }
        }
    }
}
