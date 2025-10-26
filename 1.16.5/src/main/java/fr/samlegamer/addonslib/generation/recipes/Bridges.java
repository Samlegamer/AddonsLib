package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;
import java.util.Map;
import java.util.function.Consumer;

class Bridges extends AbstractType {
    private static final String id = "mcwbridges";

    public Bridges(String modid, String originalMod) {
        super(modid, originalMod, id);
    }

    private void pier(Consumer<IFinishedRecipe> consumer, Block pier, Block log, Block fence) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"ABA"}, pier, 3, log, fence, "wooden_piers");
    }

    private void log_bridge(Consumer<IFinishedRecipe> consumer, Block log_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"B B", "AAA"}, log_bridge, 4, slab, fence, "log_bridges");
    }

    private void log_bridge_stair(Consumer<IFinishedRecipe> consumer, Block log_bridge_stair, Block log, Block log_bridge) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"  A", " AA", "AAA"}, log_bridge_stair, 6, log_bridge, Items.AIR, "log_stairs");

        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"A"}, log_bridge, 1, log_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rail_bridge(Consumer<IFinishedRecipe> consumer, Block rail_bridge, Block log, Block slab, Block fence) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"B B", "BAB"}, rail_bridge, 4, slab, fence, "rail_bridges");
    }

    private void rope_bridge_stair(Consumer<IFinishedRecipe> consumer, Block rope_bridge_stair, Block log, Block rope_bridge) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"  A", " AA", "AAA"}, rope_bridge_stair, 6, rope_bridge, Items.AIR, "rope_stairs");

        mcwRecipes.mkRpW1Item(consumer, log, new String[]{"A"}, rope_bridge, 1, rope_bridge_stair, "recyclable_bridges", "_recycle");
    }

    private void rope_bridge(Consumer<IFinishedRecipe> consumer, Block rope_bridge, Block log, Block slab) {
        mcwRecipes.mkRpW2Items(consumer, log, new String[]{"B B", "AAA"}, rope_bridge, 4, slab, Items.STRING, "rope_bridges");
    }

    public void buildWood(Consumer<IFinishedRecipe> consumer, Map<String, Boolean> MAT)
    {
        for(Map.Entry<String, Boolean> idAndIsStem : MAT.entrySet())
        {
            Block log = Finder.findBlock(originalMod, idAndIsStem.getKey() + (idAndIsStem.getValue() ? "_stem" : "_log"));
            Block fence = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_fence");
            Block slab = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_slab");

            Block log_bridge = Finder.findBlock(modid, idAndIsStem.getKey() + "_log_bridge");
            Block rope_bridge = Finder.findBlock(modid, "rope_" + idAndIsStem.getKey() + "_bridge");
            Block pier_bridge = Finder.findBlock(modid, idAndIsStem.getKey() + "_bridge_pier");
            Block log_bridge_stair = Finder.findBlock(modid, idAndIsStem.getKey() + "_log_bridge_stair");
            Block rope_bridge_stair = Finder.findBlock(modid, "rope_" + idAndIsStem.getKey() + "_bridge_stair");
            Block rail_bridge = Finder.findBlock(modid, idAndIsStem.getKey() + "_rail_bridge");

            pier(consumer, pier_bridge, log, fence);
            log_bridge(consumer, log_bridge, log, slab, fence);
            log_bridge_stair(consumer, log_bridge_stair, log, log_bridge);
            rope_bridge(consumer, rope_bridge, log, slab);
            rope_bridge_stair(consumer, rope_bridge_stair, log, rope_bridge);
            rail_bridge(consumer, rail_bridge, log, slab, fence);
        }
    }

    public void buildStone(Consumer<IFinishedRecipe> consumer, Map<String, Boolean> MAT)
    {
        for(Map.Entry<String, Boolean> idAndIsStem : MAT.entrySet())
        {
            Block stone = Finder.findBlock(originalMod, idAndIsStem.getKey());
            Block wall = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_wall");
            Block slab = Finder.findBlock(originalMod, idAndIsStem.getKey() + "_slab");

            Block log_bridge = Finder.findBlock(modid, idAndIsStem.getKey() + "_bridge");
            Block pier_bridge = Finder.findBlock(modid, idAndIsStem.getKey() + "_bridge_pier");
            Block log_bridge_stair = Finder.findBlock(modid, idAndIsStem.getKey() + "_bridge_stair");

            pier(consumer, pier_bridge, stone, wall);
            log_bridge(consumer, log_bridge, stone, slab, wall);
            log_bridge_stair(consumer, log_bridge_stair, stone, log_bridge);
        }
    }
}
