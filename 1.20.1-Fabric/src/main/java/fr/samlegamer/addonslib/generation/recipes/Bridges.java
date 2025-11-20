package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import java.util.List;
import java.util.function.Consumer;

class Bridges extends AbstractType {
    private static final String id = "mcwbridges";

    public Bridges(FabricDataOutput output, String modid, String originalMod) {
        super(output, modid, originalMod, id);
    }

    private void pier(Consumer<RecipeJsonProvider> exporter, Block pier, Block log, Block fence) {
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"ABA"}, pier, 3, log, fence, "wooden_piers");
    }

    private void log_bridge(Consumer<RecipeJsonProvider> exporter, Block log_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"B B", "AAA"}, log_bridge, 4, slab, fence, "log_bridges");
    }

    private void log_bridge_stair(Consumer<RecipeJsonProvider> exporter, Block log_bridge_stair, Block log, Block log_bridge) {
        mcwRecipes.mkRpW1Item(exporter, log, new String[]{"  A", " AA", "AAA"}, log_bridge_stair, 6, log_bridge, "log_stairs");

        mcwRecipes.mkRpShapelessW1Item(exporter, log, log_bridge, 1, log_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rail_bridge(Consumer<RecipeJsonProvider> exporter, Block rail_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"B B", "BAB"}, rail_bridge, 4, slab, fence, "rail_bridges");
    }

    private void rope_bridge_stair(Consumer<RecipeJsonProvider> exporter, Block rope_bridge_stair, Block log, Block rope_bridge) {
        mcwRecipes.mkRpW1Item(exporter, log, new String[]{"  A", " AA", "AAA"}, rope_bridge_stair, 6, rope_bridge, "rope_stairs");

        mcwRecipes.mkRpShapelessW1Item(exporter, log, rope_bridge, 1, rope_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rope_bridge(Consumer<RecipeJsonProvider> exporter, Block rope_bridge, Block log, Block slab) {
        mcwRecipes.mkRpW2Items(exporter, log, new String[]{"B B", "AAA"}, rope_bridge, 4, slab, Items.STRING, "rope_bridges");
    }

    @Override
    public void buildWood(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<McwWoodMat> woodMat)
    {
        if(MAT.size() == woodMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block log = woodMat.get(i).getLog();
                Block fence = woodMat.get(i).getFence();
                Block slab = woodMat.get(i).getSlab();

                Block log_bridge = Finder.findBlock(modid, MAT.get(i) + "_log_bridge_middle");
                Block rope_bridge = Finder.findBlock(modid, "rope_" + MAT.get(i) + "_bridge");
                Block pier_bridge = Finder.findBlock(modid, MAT.get(i) + "_bridge_pier");
                Block log_bridge_stair = Finder.findBlock(modid, MAT.get(i) + "_log_bridge_stair");
                Block rope_bridge_stair = Finder.findBlock(modid, MAT.get(i) + "_rope_bridge_stair");
                Block rail_bridge = Finder.findBlock(modid, MAT.get(i) + "_rail_bridge");

                pier(exporter, pier_bridge, log, fence);
                log_bridge(exporter, log_bridge, log, slab, fence);
                log_bridge_stair(exporter, log_bridge_stair, log, log_bridge);
                rope_bridge(exporter, rope_bridge, log, slab);
                rope_bridge_stair(exporter, rope_bridge_stair, log, rope_bridge);
                rail_bridge(exporter, rail_bridge, log, slab, fence);
            }
        }
    }

    @Override
    public void buildStone(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<McwStoneMat> stoneMat)
    {
        if(MAT.size() == stoneMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block stoneB = stoneMat.get(i).getStoneBase();
                Block wall = stoneMat.get(i).getWall();
                Block slab = stoneMat.get(i).getSlab();

                Block log_bridge = Finder.findBlock(modid, MAT.get(i) + "_bridge");
                Block pier_bridge = Finder.findBlock(modid, MAT.get(i) + "_bridge_pier");
                Block log_bridge_stair = Finder.findBlock(modid, MAT.get(i) + "_bridge_stair");

                pier(exporter, pier_bridge, stoneB, wall);
                log_bridge(exporter, log_bridge, stoneB, slab, wall);
                log_bridge_stair(exporter, log_bridge_stair, stoneB, log_bridge);
            }
        }
    }

    @Override
    public void buildHedge(Consumer<RecipeJsonProvider> exporter, List<String> MAT, List<Block> leave) {
    }
}
