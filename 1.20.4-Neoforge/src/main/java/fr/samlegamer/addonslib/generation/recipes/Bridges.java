package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.generation.recipes.mat.McwStoneMat;
import fr.samlegamer.addonslib.generation.recipes.mat.McwWoodMat;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import java.util.List;

class Bridges extends AbstractType {
    private static final String id = "mcwbridges";

    public Bridges(PackOutput pOutput, String modid, String originalMod) {
        super(pOutput, modid, originalMod, id);
    }

    private void pier(RecipeOutput consumer, Block pier, Block log, Block fence) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"ABA"}, pier, 3, log, fence, "wooden_piers");
    }

    private void log_bridge(RecipeOutput consumer, Block log_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"B B", "AAA"}, log_bridge, 4, slab, fence, "log_bridges");
    }

    private void log_bridge_stair(RecipeOutput consumer, Block log_bridge_stair, Block log, Block log_bridge) {
        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"  A", " AA", "AAA"}, log_bridge_stair, 6, log_bridge, "log_stairs");

        mcwRecipes.mkRpShapelessW1Item(consumer, log, log_bridge, 1, log_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rail_bridge(RecipeOutput consumer, Block rail_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"B B", "BAB"}, rail_bridge, 4, slab, fence, "rail_bridges");
    }

    private void rope_bridge_stair(RecipeOutput consumer, Block rope_bridge_stair, Block log, Block rope_bridge) {
        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"  A", " AA", "AAA"}, rope_bridge_stair, 6, rope_bridge, "rope_stairs");

        mcwRecipes.mkRpShapelessW1Item(consumer, log, rope_bridge, 1, rope_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rope_bridge(RecipeOutput consumer, Block rope_bridge, Block log, Block slab) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"B B", "AAA"}, rope_bridge, 4, slab, Items.STRING, "rope_bridges");
    }

    @Override
    public void buildWood(RecipeOutput consumer, List<String> MAT, List<McwWoodMat> woodMat)
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

                pier(consumer, pier_bridge, log, fence);
                log_bridge(consumer, log_bridge, log, slab, fence);
                log_bridge_stair(consumer, log_bridge_stair, log, log_bridge);
                rope_bridge(consumer, rope_bridge, log, slab);
                rope_bridge_stair(consumer, rope_bridge_stair, log, rope_bridge);
                rail_bridge(consumer, rail_bridge, log, slab, fence);
            }
        }
    }

    @Override
    public void buildStone(RecipeOutput consumer, List<String> MAT, List<McwStoneMat> stoneMat)
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

                pier(consumer, stone_pier_bridge, stoneB, wall);
                log_bridge(consumer, stone_bridge, stoneB, slab, wall);
                log_bridge_stair(consumer, stone_bridge_stair, stoneB, stone_bridge);
                mcwRecipes.mkRpW2Items(consumer, stoneB, new String[]{"BBB", "AAA"}, balustrade_stone_bridge, 5, slab, wall, "balustrade_bridges");
            }
        }
    }

    @Override
    public void buildHedge(RecipeOutput consumer, List<String> MAT, List<Block> leave) {
    }
}
