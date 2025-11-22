package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import java.util.List;
import java.util.concurrent.CompletableFuture;

class Bridges extends AbstractType {
    private static final String id = "mcwbridges";

    public Bridges(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, String modid, String originalMod) {
        super(output, registriesFuture, modid, originalMod, id);
    }

    private void pier(RecipeGenerator generator, RecipeExporter exporter, Block pier, Block log, Block fence) {
        mcwRecipes.mkRpW2Items(generator, exporter, log, new String[]{"ABA"}, pier, 3, log, fence, "wooden_piers");
    }

    private void log_bridge(RecipeGenerator generator, RecipeExporter exporter, Block log_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(generator, exporter, log, new String[]{"B B", "AAA"}, log_bridge, 4, slab, fence, "log_bridges");
    }

    private void log_bridge_stair(RecipeGenerator generator, RecipeExporter exporter, Block log_bridge_stair, Block log, Block log_bridge) {
        mcwRecipes.mkRpW1Item(generator, exporter, log, new String[]{"  A", " AA", "AAA"}, log_bridge_stair, 6, log_bridge, "log_stairs");

        mcwRecipes.mkRpShapelessW1Item(generator, exporter, log, log_bridge, 1, log_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rail_bridge(RecipeGenerator generator, RecipeExporter exporter, Block rail_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(generator, exporter, log, new String[]{"B B", "BAB"}, rail_bridge, 4, slab, fence, "rail_bridges");
    }

    private void rope_bridge_stair(RecipeGenerator generator, RecipeExporter exporter, Block rope_bridge_stair, Block log, Block rope_bridge) {
        mcwRecipes.mkRpW1Item(generator, exporter, log, new String[]{"  A", " AA", "AAA"}, rope_bridge_stair, 6, rope_bridge, "rope_stairs");

        mcwRecipes.mkRpShapelessW1Item(generator, exporter, log, rope_bridge, 1, rope_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rope_bridge(RecipeGenerator generator, RecipeExporter exporter, Block rope_bridge, Block log, Block slab) {
        mcwRecipes.mkRpW2Items(generator, exporter, log, new String[]{"B B", "AAA"}, rope_bridge, 4, slab, Items.STRING, "rope_bridges");
    }

    @Override
    public void buildWood(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<McwWoodMat> woodMat)
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

                pier(generator, exporter, pier_bridge, log, fence);
                log_bridge(generator, exporter, log_bridge, log, slab, fence);
                log_bridge_stair(generator, exporter, log_bridge_stair, log, log_bridge);
                rope_bridge(generator, exporter, rope_bridge, log, slab);
                rope_bridge_stair(generator, exporter, rope_bridge_stair, log, rope_bridge);
                rail_bridge(generator, exporter, rail_bridge, log, slab, fence);
            }
        }
    }

    @Override
    public void buildStone(RecipeGenerator consumer, RecipeExporter exporter, List<String> MAT, List<McwStoneMat> stoneMat)
    {
        if(MAT.size() == stoneMat.size()) {
            for (int i = 0; i < MAT.size(); i++) {
                Block stoneB = stoneMat.get(i).getStoneBase();
                Block wall = stoneMat.get(i).getWall();
                Block slab = stoneMat.get(i).getSlab();

                Block stone_bridge = Finder.findBlock(modid, MAT.get(i) + "_bridge");
                Block stone_pier_bridge = Finder.findBlock(modid, MAT.get(i) + "_bridge_pier");
                Block stone_bridge_stair = Finder.findBlock(modid, MAT.get(i) + "_bridge_stair");
                Block balustrade_stone_bridge = Finder.findBlock(modid, "balustrade_" + MAT.get(i) + "_bridge");

                pier(consumer, exporter, stone_pier_bridge, stoneB, wall);
                log_bridge(consumer, exporter, stone_bridge, stoneB, slab, wall);
                log_bridge_stair(consumer, exporter, stone_bridge_stair, stoneB, stone_bridge);
                mcwRecipes.mkRpW2Items(consumer, exporter, stoneB, new String[]{"BBB", "AAA"}, balustrade_stone_bridge, 5, slab, wall, "balustrade_bridges");
            }
        }
    }

    @Override
    public void buildHedge(RecipeGenerator generator, RecipeExporter exporter, List<String> MAT, List<Block> leave) {
    }
}
