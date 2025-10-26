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

class Fences extends AbstractType {
    private static final String id = "mcwfences";

    public Fences(String modid, String originalMod)
    {
        super(modid, originalMod, id);
    }

    private void wood_variants(Consumer<IFinishedRecipe> consumer, String mat, Block log, Block planks, Block slab)
    {
        Block curved_gate = Finder.findBlock(modid, mat + "_curved_gate");
        Block highley_gate = Finder.findBlock(modid, mat + "_highley_gate");
        Block horse_fence = Finder.findBlock(modid, mat + "_horse_fence");
        Block picket_fence = Finder.findBlock(modid, mat + "_picket_fence");
        Block pyramid_gate = Finder.findBlock(modid, mat + "_pyramid_gate");
        Block stockade_fence = Finder.findBlock(modid, mat + "_stockade_fence");
        Block wired_fence = Finder.findBlock(modid, mat + "_wired_fence");

        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"B A", "BAA"}, curved_gate, 4, planks, log, "curved_gate");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"ABA", "ABA"}, highley_gate, 1, Items.STICK, log, "highley");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"ABA", "BAB"}, horse_fence, 3, log, Items.STICK, "horse");
        mcwRecipes.mkRpW3Items(consumer, planks, new String[]{"CBC", "CAC"}, picket_fence, 3, Items.STICK, planks, log, "picket");
        mcwRecipes.mkRpW3Items(consumer, planks, new String[]{"ABA", "ACA"}, pyramid_gate, 1, Items.STICK, log, planks, "pyramid");
        mcwRecipes.mkRpW2Items(consumer, planks, new String[]{"ABA", "BAB"}, stockade_fence, 3, log, planks, "stockade");
        mcwRecipes.mkRpW3Items(consumer, planks, new String[]{"ACA", "ABA"}, wired_fence, 3, Items.STICK, log, Blocks.IRON_BARS, "wired");
    }

    private void hedge(Consumer<IFinishedRecipe> consumer, Block hedge, Block leave)
    {
        mcwRecipes.mkRpW1Item(consumer, leave, new String[]{"AA", "AA"}, hedge, 4, leave, "hedge");
    }

    private void stone_variants(Consumer<IFinishedRecipe> consumer, String mat, Block stone)
    {
        Block modern_wall = Finder.findBlock(modid, "modern_" + mat + "_wall");
        Block railing_wall = Finder.findBlock(modid, "railing_" + mat + "_wall");
        Block grass_topped_wall = Finder.findBlock(modid, mat + "_grass_topped_wall");
        Block pillar_wall = Finder.findBlock(modid, mat + "_pillar_wall");
        Block railing_gate = Finder.findBlock(modid, mat + "_railing_gate");

//        mcwRecipes.mkRpW2Items(consumer, stone, new String[]{"B A", "BAA"}, curved_gate, 4, planks, log, "curved_gate");

    }

    public void buildWood(Consumer<IFinishedRecipe> consumer, Map<String, Boolean> MAT)
    {
        for(Map.Entry<String, Boolean> idAndIsStem : MAT.entrySet())
        {
            Block log = Finder.findBlock(originalMod, idAndIsStem.getKey() + (idAndIsStem.getValue() ? "_stem" : "_log"));
            Block planks = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_planks");
            Block slab = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_slab");

//            other_door(consumer, idAndIsStem.getKey(), log, planks, slab);

            String[] variants = new String[]{"bamboo", "jungle", "oak", "spruce",
            "dark_oak", "mystic", "nether", "birch", "swamp", "acacia",
            "waffle", "whispering"};

            for(String variant : variants)
            {
                Item print = Finder.findItem(id, "print_" + variant);
                Block door_var = Finder.findBlock(modid,  idAndIsStem.getKey() + "_" + variant + "_door");

                //door_variant(consumer, door_var, planks, print);
            }
        }
    }
}
