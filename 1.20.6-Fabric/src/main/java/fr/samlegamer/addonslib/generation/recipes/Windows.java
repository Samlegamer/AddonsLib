package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

class Windows extends AbstractType {
    private static final String id = "mcwwindows";

    public Windows(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, String modid, String originalMod)
    {
        super(output, registriesFuture, modid, originalMod, id);
    }

    private void wood_variants(RecipeExporter exporter, String mat, Block log, Block planks, Block slab, Block trapdoor, Block stripped_log)
    {
        Item window_base = Finder.findItem(id, "window_base");
        Item window_half_bar_base = Finder.findItem(id, "window_half_bar_base");
        Item window_centre_bar_base = Finder.findItem(id, "window_centre_bar_base");

        Block curtain_rod = Finder.findBlock(modid, mat + "_curtain_rod");
        Block shutter = Finder.findBlock(modid, mat + "_shutter");
        Block louvered_shutter = Finder.findBlock(modid, mat + "_louvered_shutter");
        Block log_parapet = Finder.findBlock(modid, mat + "_log_parapet");
        Block plank_parapet = Finder.findBlock(modid, mat + "_plank_parapet");
        Block blinds = Finder.findBlock(modid, mat + "_blinds");
        Block window = Finder.findBlock(modid, mat + "_window");
        Block plank_window = Finder.findBlock(modid, mat + "_plank_window");
        Block window2 = Finder.findBlock(modid, mat + "_window2");
        Block plank_window2 = Finder.findBlock(modid, mat + "_plank_window2");
        Block pane_window = Finder.findBlock(modid, mat + "_pane_window");
        Block plank_pane_window = Finder.findBlock(modid, mat + "_plank_pane_window");
        Block four_window = Finder.findBlock(modid, mat + "_four_window");
        Block plank_four_window = Finder.findBlock(modid, mat + "_plank_four_window");
        Block stripped_log_window = Finder.findBlock(modid, "stripped_" + mat + "_log_window");
        Block stripped_pane_window = Finder.findBlock(modid, "stripped_" + mat + "_pane_window");
        Block stripped_log_window2 = Finder.findBlock(modid, "stripped_" + mat + "_log_window2");
        Block stripped_log_four_window = Finder.findBlock(modid, "stripped_" + mat + "_log_four_window");

        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"ABA"}, curtain_rod, 5, Items.STICK, log, "curtain_rods");
        mcwRecipes.mkRpShapelessW1Item(exporter, log, shutter, 3, trapdoor, 3, "shutters");
        mcwRecipes.mkRpShapelessW1Item(exporter, log, louvered_shutter, 3, slab, 3, "shutters");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA"}, log_parapet, 5, Items.STICK, log, "parapets");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA"}, plank_parapet, 5, Items.STICK, planks, "parapets");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "BBB", "BBB"}, blinds, 3, slab, Items.STICK, "blinds");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{" A ", "ABA", " A "}, window, 4, window_base, log, "windows");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{" A ", "ABA", " A "}, plank_window, 4, window_base, planks, "windows");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, window2, 8, window_half_bar_base, log, "windows_two");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, plank_window2, 8, window_half_bar_base, planks, "windows_two");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, pane_window, 8, window_base, log, "windows_pane");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, plank_pane_window, 8, window_base, planks, "windows_pane");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, four_window, 8, window_centre_bar_base, log, "windows_four");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, plank_four_window, 8, window_centre_bar_base, planks, "windows_four");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{" A ", "ABA", " A "}, stripped_log_window, 4, window_base, stripped_log, "windows");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, stripped_pane_window, 8, window_base, stripped_log, "windows_pane");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, stripped_log_window2, 8, window_half_bar_base, stripped_log, "windows_two");
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"AAA", "ABA", "AAA"}, stripped_log_four_window, 8, window_centre_bar_base, stripped_log, "windows_four");
    }

    @Override
    public void buildWood(RecipeExporter exporter, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block stripped_log = woodMat.get(i).getStrippedLog();
                Block planks = woodMat.get(i).getPlanks();
                Block trapdoor = woodMat.get(i).getTrapdoor();
                Block slab = woodMat.get(i).getSlab();

                wood_variants(exporter, MAT.get(i), log, planks, slab, trapdoor, stripped_log);
            }
        }
    }

    @Override
    public void buildStone(RecipeExporter exporter, List<String> MAT, List<McwStoneMat> stone) {

    }

    @Override
    public void buildHedge(RecipeExporter exporter, List<String> MAT, List<Block> leave) {

    }
}
