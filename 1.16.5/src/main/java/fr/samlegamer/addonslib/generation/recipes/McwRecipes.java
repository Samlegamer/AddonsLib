package fr.samlegamer.addonslib.generation.recipes;

import fr.samlegamer.addonslib.Finder;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import static net.minecraft.data.RecipeProvider.has;

public class McwRecipes
{
    public static class Bridges {
        private static final String id = "mcwbridges";

        private final String modid;
        private final String originalMod;

        public Bridges(String modid, String originalMod) {
            this.modid = modid;
            this.originalMod = originalMod;
        }

        private void pier(Consumer<IFinishedRecipe> consumer, Block pier, Block log, Block fence) {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(pier, 3)
                                    .pattern("WFW")
                                    .define('W', log)
                                    .define('F', fence)
                                    .group("wooden_piers")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(pier.asItem().getRegistryName()).getPath()));
        }

        private void log_bridge(Consumer<IFinishedRecipe> consumer, Block log_bridge, Block log, Block slab, Block fence) {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(log_bridge, 4)
                                    .pattern("F F")
                                    .pattern("WWW")
                                    .define('W', slab)
                                    .define('F', fence)
                                    .group("log_bridges")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(log_bridge.asItem().getRegistryName()).getPath()));
        }

        private void log_bridge_stair(Consumer<IFinishedRecipe> consumer, Block log_bridge_stair, Block log, Block log_bridge) {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(log_bridge_stair, 6)
                                    .pattern("  F")
                                    .pattern(" FF")
                                    .pattern("FFF")
                                    .define('F', log_bridge)
                                    .group("log_stairs")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(log_bridge_stair.asItem().getRegistryName()).getPath()));

            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapelessRecipeBuilder.shapeless(log_bridge, 1)
                                    .requires(log_bridge_stair)
                                    .group("recyclable_bridges")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(log_bridge_stair.asItem().getRegistryName()).getPath() + "_recycle"));
            ;
        }

        private void rail_bridge(Consumer<IFinishedRecipe> consumer, Block rail_bridge, Block log, Block slab, Block fence) {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(rail_bridge, 4)
                                    .pattern("F F")
                                    .pattern("FWF")
                                    .define('W', slab)
                                    .define('F', fence)
                                    .group("rail_bridges")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(rail_bridge.asItem().getRegistryName()).getPath()));
        }

        private void rope_bridge_stair(Consumer<IFinishedRecipe> consumer, Block rope_bridge_stair, Block log, Block rope_bridge) {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(rope_bridge_stair, 6)
                                    .pattern("  F")
                                    .pattern(" FF")
                                    .pattern("FFF")
                                    .define('F', rope_bridge)
                                    .group("rope_stairs")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(rope_bridge_stair.asItem().getRegistryName()).getPath()));

            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapelessRecipeBuilder.shapeless(rope_bridge, 1)
                                    .requires(rope_bridge_stair)
                                    .group("recyclable_bridges")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(rope_bridge_stair.asItem().getRegistryName()).getPath() + "_recycle"));
            ;
        }

        private void rope_bridge(Consumer<IFinishedRecipe> consumer, Block rope_bridge, Block log, Block slab) {
            ConditionalRecipe.builder().addCondition(new ModLoadedCondition(id)).addCondition(new ModLoadedCondition(originalMod)).addRecipe(
                            ShapedRecipeBuilder.shaped(rope_bridge, 4)
                                    .pattern("F F")
                                    .pattern("WWW")
                                    .define('W', slab)
                                    .define('F', Items.STRING)
                                    .group("rope_bridges")
                                    .unlockedBy("has_log", has(log))::save)
                    .build(consumer, new ResourceLocation(modid, Objects.requireNonNull(rope_bridge.asItem().getRegistryName()).getPath()));
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
}
