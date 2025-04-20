package fr.samlegamer.addonslib.client;

import fr.samlegamer.addonslib.Finder;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.List;

@Deprecated(forRemoval = true)
@OnlyIn(value = Dist.CLIENT)
public class RendererMcw
{
    public static class Bridges
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block log_bridge_middle, rope_bridge, bridge_pier, log_bridge_stair, rope_bridge_stair, rail_bridge;

            for (String i : WOOD)
            {
                log_bridge_middle = Finder.findBlock(MODID, i+"_log_bridge_middle");
                rope_bridge = Finder.findBlock(MODID, "rope_"+i+"_bridge");
                bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
                log_bridge_stair = Finder.findBlock(MODID, i+"_log_bridge_stair");
                rope_bridge_stair = Finder.findBlock(MODID, i+"_rope_bridge_stair");
                rail_bridge = Finder.findBlock(MODID, i+"_rail_bridge");

                ItemBlockRenderTypes.setRenderLayer(log_bridge_middle, renderSet);
                ItemBlockRenderTypes.setRenderLayer(rope_bridge, renderSet);
                ItemBlockRenderTypes.setRenderLayer(bridge_pier, renderSet);
                ItemBlockRenderTypes.setRenderLayer(log_bridge_stair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(rope_bridge_stair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(rail_bridge, renderSet);
            }
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
        {
            Block stone_bridge, stone_bridge_pier, stone_bridge_stair, balustrade_stone_bridge;

            for (String i : STONE)
            {
                stone_bridge = Finder.findBlock(MODID, i+"_bridge");
                stone_bridge_pier = Finder.findBlock(MODID, i+"_bridge_pier");
                stone_bridge_stair = Finder.findBlock(MODID, i+"_bridge_stair");
                balustrade_stone_bridge = Finder.findBlock(MODID, "balustrade_"+i+"_bridge");

                ItemBlockRenderTypes.setRenderLayer(stone_bridge, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stone_bridge_pier, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stone_bridge_stair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(balustrade_stone_bridge, renderSet);
            }
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
        {
            clientStone(event, MODID, STONE, RenderType.cutout());
        }
    }

    public static class Roofs
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block cherry_roof,
                    cherry_attic_roof,
                    cherry_top_roof,
                    cherry_lower_roof,
                    cherry_steep_roof,
                    cherry_upper_lower_roof,
                    cherry_upper_steep_roof,
                    cherry_planks_roof,
                    cherry_planks_attic_roof,
                    cherry_planks_top_roof,
                    cherry_planks_lower_roof,
                    cherry_planks_steep_roof,
                    cherry_planks_upper_lower_roof,
                    cherry_planks_upper_steep_roof;

            for (String i : WOOD)
            {
                cherry_roof = Finder.findBlock(MODID, i+"_roof");
                cherry_attic_roof = Finder.findBlock(MODID, i + "_attic_roof");
                cherry_top_roof = Finder.findBlock(MODID, i + "_top_roof");
                cherry_lower_roof = Finder.findBlock(MODID, i+"_lower_roof");
                cherry_steep_roof = Finder.findBlock(MODID, i+"_steep_roof");
                cherry_upper_lower_roof = Finder.findBlock(MODID, i + "_upper_lower_roof");
                cherry_upper_steep_roof = Finder.findBlock(MODID, i + "_upper_steep_roof");

                ItemBlockRenderTypes.setRenderLayer(cherry_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_attic_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_top_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_lower_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_steep_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_upper_lower_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_upper_steep_roof, renderSet);

                cherry_planks_roof = Finder.findBlock(MODID, i+"_planks_roof");
                cherry_planks_attic_roof = Finder.findBlock(MODID, i + "_planks_attic_roof");
                cherry_planks_top_roof = Finder.findBlock(MODID, i + "_planks_top_roof");
                cherry_planks_lower_roof = Finder.findBlock(MODID, i+"_planks_lower_roof");
                cherry_planks_steep_roof = Finder.findBlock(MODID, i+"_planks_steep_roof");
                cherry_planks_upper_lower_roof = Finder.findBlock(MODID, i + "_planks_upper_lower_roof");
                cherry_planks_upper_steep_roof = Finder.findBlock(MODID, i + "_planks_upper_steep_roof");

                ItemBlockRenderTypes.setRenderLayer(cherry_planks_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_planks_attic_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_planks_top_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_planks_lower_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_planks_steep_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_planks_upper_lower_roof, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_planks_upper_steep_roof, renderSet);
            }
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
        {
            clientStone(event, MODID, STONE, RenderType.cutout());
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
        {
            Block ROOF,
                    ATTIC_ROOF,
                    TOP_ROOF,
                    LOWER_ROOF,
                    STEEP_ROOF,
                    UPPER_LOWER_ROOF,
                    UPPER_STEEP_ROOF;

            for (String i : STONE)
            {
                ROOF = Finder.findBlock(MODID, i + "_roof");
                ATTIC_ROOF = Finder.findBlock(MODID, i + "_attic_roof");
                TOP_ROOF = Finder.findBlock(MODID, i + "_top_roof");
                LOWER_ROOF = Finder.findBlock(MODID, i + "_lower_roof");
                STEEP_ROOF = Finder.findBlock(MODID, i + "_steep_roof");
                UPPER_LOWER_ROOF = Finder.findBlock(MODID, i + "_upper_lower_roof");
                UPPER_STEEP_ROOF = Finder.findBlock(MODID, i + "_upper_steep_roof");

                ItemBlockRenderTypes.setRenderLayer(ROOF, renderSet);
                ItemBlockRenderTypes.setRenderLayer(ATTIC_ROOF, renderSet);
                ItemBlockRenderTypes.setRenderLayer(TOP_ROOF, renderSet);
                ItemBlockRenderTypes.setRenderLayer(LOWER_ROOF, renderSet);
                ItemBlockRenderTypes.setRenderLayer(STEEP_ROOF, renderSet);
                ItemBlockRenderTypes.setRenderLayer(UPPER_LOWER_ROOF, renderSet);
                ItemBlockRenderTypes.setRenderLayer(UPPER_STEEP_ROOF, renderSet);
            }
        }
    }

    public static class Fences
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block picket_fence, stockade_fence, horse_fence, wired_fence, highley_gate, pyramid_gate, curved_gate;

            for (String i : WOOD)
            {
                picket_fence = Finder.findBlock(MODID, i + "_picket_fence");
                stockade_fence = Finder.findBlock(MODID, i + "_stockade_fence");
                horse_fence = Finder.findBlock(MODID, i + "_horse_fence");
                wired_fence = Finder.findBlock(MODID, i + "_wired_fence");
                highley_gate = Finder.findBlock(MODID, i + "_highley_gate");
                pyramid_gate = Finder.findBlock(MODID, i + "_pyramid_gate");
                curved_gate = Finder.findBlock(MODID, i + "_curved_gate");

                ItemBlockRenderTypes.setRenderLayer(picket_fence, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stockade_fence, renderSet);
                ItemBlockRenderTypes.setRenderLayer(horse_fence, renderSet);
                ItemBlockRenderTypes.setRenderLayer(wired_fence, renderSet);
                ItemBlockRenderTypes.setRenderLayer(highley_gate, renderSet);
                ItemBlockRenderTypes.setRenderLayer(pyramid_gate, renderSet);
                ItemBlockRenderTypes.setRenderLayer(curved_gate, renderSet);
            }
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block hedge;

            for (String i : WOOD)
            {
                hedge = Finder.findBlock(MODID, i + "_hedge");

                ItemBlockRenderTypes.setRenderLayer(hedge, renderSet);
            }
        }

        public static void clientHedge(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientHedge(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
        {
            Block modern_wall, railing_wall, railing_gate, pillar_wall, grass_topped_wall;

            for (String i : STONE)
            {
                modern_wall = Finder.findBlock(MODID, "modern_"+i+"_wall");
                railing_wall = Finder.findBlock(MODID, "railing_"+i+"_wall");
                railing_gate = Finder.findBlock(MODID, i+"_railing_gate");
                pillar_wall = Finder.findBlock(MODID, i+"_pillar_wall");
                grass_topped_wall = Finder.findBlock(MODID, i + "_grass_topped_wall");

                ItemBlockRenderTypes.setRenderLayer(modern_wall, renderSet);
                ItemBlockRenderTypes.setRenderLayer(railing_wall, renderSet);
                ItemBlockRenderTypes.setRenderLayer(railing_gate, renderSet);
                ItemBlockRenderTypes.setRenderLayer(pillar_wall, renderSet);
                ItemBlockRenderTypes.setRenderLayer(grass_topped_wall, renderSet);
            }
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
        {
            clientStone(event, MODID, STONE, RenderType.cutout());
        }
    }

    public static class Furnitures
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block cherry_wardrobe,
                    cherry_modern_wardrobe,
                    cherry_double_wardrobe,
                    cherry_bookshelf,
                    cherry_bookshelf_cupboard,
                    cherry_drawer,
                    cherry_double_drawer,
                    cherry_bookshelf_drawer,
                    cherry_lower_bookshelf_drawer,
                    cherry_large_drawer,
                    cherry_lower_triple_drawer,
                    cherry_triple_drawer,
                    cherry_desk,
                    cherry_covered_desk,
                    cherry_modern_desk,
                    cherry_table,
                    cherry_end_table,
                    cherry_coffee_table,
                    cherry_glass_table,
                    cherry_chair,
                    cherry_modern_chair,
                    cherry_striped_chair,
                    cherry_stool_chair,
                    cherry_counter,
                    cherry_drawer_counter,
                    cherry_double_drawer_counter,
                    cherry_cupboard_counter,
                    stripped_cherry_wardrobe,
                    stripped_cherry_modern_wardrobe,
                    stripped_cherry_double_wardrobe,
                    stripped_cherry_bookshelf,
                    stripped_cherry_bookshelf_cupboard,
                    stripped_cherry_drawer,
                    stripped_cherry_double_drawer,
                    stripped_cherry_bookshelf_drawer,
                    stripped_cherry_lower_bookshelf_drawer,
                    stripped_cherry_large_drawer,
                    stripped_cherry_lower_triple_drawer,
                    stripped_cherry_triple_drawer,
                    stripped_cherry_desk,
                    stripped_cherry_covered_desk,
                    stripped_cherry_modern_desk,
                    stripped_cherry_table,
                    stripped_cherry_end_table,
                    stripped_cherry_coffee_table,
                    stripped_cherry_glass_table,
                    stripped_cherry_chair,
                    stripped_cherry_modern_chair,
                    stripped_cherry_striped_chair,
                    stripped_cherry_stool_chair,
                    stripped_cherry_counter,
                    stripped_cherry_drawer_counter,
                    stripped_cherry_double_drawer_counter,
                    stripped_cherry_cupboard_counter,
                    cherry_kitchen_cabinet,
                    cherry_double_kitchen_cabinet,
                    cherry_glass_kitchen_cabinet,
                    stripped_cherry_kitchen_cabinet,
                    stripped_cherry_double_kitchen_cabinet,
                    stripped_cherry_glass_kitchen_cabinet;

            for (String i : WOOD)
            {
                cherry_wardrobe = Finder.findBlock(MODID, i+"_wardrobe");
                cherry_modern_wardrobe = Finder.findBlock(MODID, i+"_modern_wardrobe");
                cherry_double_wardrobe = Finder.findBlock(MODID, i+"_double_wardrobe");
                cherry_bookshelf = Finder.findBlock(MODID, i+"_bookshelf");
                cherry_bookshelf_cupboard = Finder.findBlock(MODID, i+"_bookshelf_cupboard");
                cherry_drawer = Finder.findBlock(MODID, i+"_drawer");
                cherry_double_drawer = Finder.findBlock(MODID, i+"_double_drawer");
                cherry_bookshelf_drawer = Finder.findBlock(MODID, i+"_bookshelf_drawer");
                cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, i+"_lower_bookshelf_drawer");
                cherry_large_drawer = Finder.findBlock(MODID, i+"_large_drawer");
                cherry_lower_triple_drawer = Finder.findBlock(MODID, i+"_lower_triple_drawer");
                cherry_triple_drawer = Finder.findBlock(MODID, i+"_triple_drawer");
                cherry_desk = Finder.findBlock(MODID, i+"_desk");
                cherry_covered_desk = Finder.findBlock(MODID, i+"_covered_desk");
                cherry_modern_desk = Finder.findBlock(MODID, i+"_modern_desk");
                cherry_table = Finder.findBlock(MODID, i+"_table");
                cherry_end_table = Finder.findBlock(MODID, i+"_end_table");
                cherry_coffee_table = Finder.findBlock(MODID, i+"_coffee_table");
                cherry_glass_table = Finder.findBlock(MODID, i+"_glass_table");
                cherry_chair = Finder.findBlock(MODID, i+"_chair");
                cherry_modern_chair = Finder.findBlock(MODID, i+"_modern_chair");
                cherry_striped_chair = Finder.findBlock(MODID, i+"_striped_chair");
                cherry_stool_chair = Finder.findBlock(MODID, i+"_stool_chair");
                cherry_counter = Finder.findBlock(MODID, i+"_counter");
                cherry_drawer_counter = Finder.findBlock(MODID, i+"_drawer_counter");
                cherry_double_drawer_counter = Finder.findBlock(MODID, i+"_double_drawer_counter");
                cherry_cupboard_counter = Finder.findBlock(MODID, i+"_cupboard_counter");
                cherry_kitchen_cabinet = Finder.findBlock(MODID, i+"_kitchen_cabinet");
                cherry_double_kitchen_cabinet = Finder.findBlock(MODID, i+"_double_kitchen_cabinet");
                cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, i+"_glass_kitchen_cabinet");

                ItemBlockRenderTypes.setRenderLayer(cherry_wardrobe, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_modern_wardrobe, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_double_wardrobe, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_bookshelf, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_bookshelf_cupboard, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_double_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_bookshelf_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_lower_bookshelf_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_large_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_lower_triple_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_triple_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_desk, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_covered_desk, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_modern_desk, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_end_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_coffee_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_glass_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_modern_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_striped_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_stool_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_drawer_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_double_drawer_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_cupboard_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_kitchen_cabinet, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_double_kitchen_cabinet, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cherry_glass_kitchen_cabinet, renderSet);

                stripped_cherry_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_wardrobe");
                stripped_cherry_modern_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_modern_wardrobe");
                stripped_cherry_double_wardrobe = Finder.findBlock(MODID, "stripped_"+i+"_double_wardrobe");
                stripped_cherry_bookshelf = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf");
                stripped_cherry_bookshelf_cupboard = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_cupboard");
                stripped_cherry_drawer = Finder.findBlock(MODID, "stripped_"+i+"_drawer");
                stripped_cherry_double_drawer = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer");
                stripped_cherry_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_bookshelf_drawer");
                stripped_cherry_lower_bookshelf_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_bookshelf_drawer");
                stripped_cherry_large_drawer = Finder.findBlock(MODID, "stripped_"+i+"_large_drawer");
                stripped_cherry_lower_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_lower_triple_drawer");
                stripped_cherry_triple_drawer = Finder.findBlock(MODID, "stripped_"+i+"_triple_drawer");
                stripped_cherry_desk = Finder.findBlock(MODID, "stripped_"+i+"_desk");
                stripped_cherry_covered_desk = Finder.findBlock(MODID, "stripped_"+i+"_covered_desk");
                stripped_cherry_modern_desk = Finder.findBlock(MODID, "stripped_"+i+"_modern_desk");
                stripped_cherry_table = Finder.findBlock(MODID, "stripped_"+i+"_table");
                stripped_cherry_end_table = Finder.findBlock(MODID, "stripped_"+i+"_end_table");
                stripped_cherry_coffee_table = Finder.findBlock(MODID, "stripped_"+i+"_coffee_table");
                stripped_cherry_glass_table = Finder.findBlock(MODID, "stripped_"+i+"_glass_table");
                stripped_cherry_chair = Finder.findBlock(MODID, "stripped_"+i+"_chair");
                stripped_cherry_modern_chair = Finder.findBlock(MODID, "stripped_"+i+"_modern_chair");
                stripped_cherry_striped_chair = Finder.findBlock(MODID, "stripped_"+i+"_striped_chair");
                stripped_cherry_stool_chair = Finder.findBlock(MODID, "stripped_"+i+"_stool_chair");
                stripped_cherry_counter = Finder.findBlock(MODID, "stripped_"+i+"_counter");
                stripped_cherry_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_drawer_counter");
                stripped_cherry_double_drawer_counter = Finder.findBlock(MODID, "stripped_"+i+"_double_drawer_counter");
                stripped_cherry_cupboard_counter = Finder.findBlock(MODID, "stripped_"+i+"_cupboard_counter");
                stripped_cherry_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_kitchen_cabinet");
                stripped_cherry_double_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_double_kitchen_cabinet");
                stripped_cherry_glass_kitchen_cabinet = Finder.findBlock(MODID, "stripped_"+i+"_glass_kitchen_cabinet");

                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_wardrobe, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_modern_wardrobe, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_double_wardrobe, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_bookshelf, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_bookshelf_cupboard, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_double_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_bookshelf_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_lower_bookshelf_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_large_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_lower_triple_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_triple_drawer, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_desk, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_covered_desk, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_modern_desk, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_end_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_coffee_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_glass_table, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_modern_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_striped_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_stool_chair, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_drawer_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_double_drawer_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_cupboard_counter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_kitchen_cabinet, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_double_kitchen_cabinet, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stripped_cherry_glass_kitchen_cabinet, renderSet);
            }
        }
    }

    public static class Stairs
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

            for (String i : WOOD)
            {
                _terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
                _skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
                _compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
                _bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
                _loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
                _railing = Finder.findBlock(MODID, i+"_railing");
                _balcony = Finder.findBlock(MODID, i+"_balcony");
                _platform = Finder.findBlock(MODID, i+"_platform");

                ItemBlockRenderTypes.setRenderLayer(_terrace_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_skyline_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_compact_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_bulk_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_loft_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_railing, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_balcony, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_platform, renderSet);
            }
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE, RenderType renderSet)
        {
            Block _terrace_stairs, _skyline_stairs, _compact_stairs, _bulk_stairs, _loft_stairs, _railing, _balcony, _platform;

            for (String i : STONE)
            {
                _terrace_stairs = Finder.findBlock(MODID, i+"_terrace_stairs");
                _skyline_stairs = Finder.findBlock(MODID, i+"_skyline_stairs");
                _compact_stairs = Finder.findBlock(MODID, i+"_compact_stairs");
                _bulk_stairs = Finder.findBlock(MODID, i+"_bulk_stairs");
                _loft_stairs = Finder.findBlock(MODID, i+"_loft_stairs");
                _railing = Finder.findBlock(MODID, i+"_railing");
                _balcony = Finder.findBlock(MODID, i+"_balcony");
                _platform = Finder.findBlock(MODID, i+"_platform");

                ItemBlockRenderTypes.setRenderLayer(_terrace_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_skyline_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_compact_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_bulk_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_loft_stairs, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_railing, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_balcony, renderSet);
                ItemBlockRenderTypes.setRenderLayer(_platform, renderSet);
            }
        }

        public static void clientStone(final FMLClientSetupEvent event, String MODID, List<String> STONE)
        {
            clientStone(event, MODID, STONE, RenderType.cutout());
        }
    }

    public static class Paths
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            for (String i : WOOD)
            {
                Block planks_path;

                planks_path = Finder.findBlock(MODID, i+"_planks_path");

                ItemBlockRenderTypes.setRenderLayer(planks_path, renderSet);
            }
        }
    }

    public static class Doors
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block japanese_door, japanese2_door, barn_door, barn_glass_door, modern_door, cottage_door, classic_door, beach_door, paper_door, four_panel_door,
                    tropical_door, glass_door, stable_door, stable_head_door, western_door, mystic_door, nether_door, swamp_door, bamboo_door, bark_glass_door, waffle_door, whispering_door;

            for (String i : WOOD)
            {
                japanese_door = Finder.findBlock(MODID, i + "_japanese_door");
                japanese2_door = Finder.findBlock(MODID, i + "_japanese2_door");
                barn_door = Finder.findBlock(MODID, i + "_barn_door");
                barn_glass_door = Finder.findBlock(MODID, i + "_barn_glass_door");
                modern_door = Finder.findBlock(MODID, i + "_modern_door");
                cottage_door = Finder.findBlock(MODID, i + "_cottage_door");
                classic_door = Finder.findBlock(MODID, i + "_classic_door");
                beach_door = Finder.findBlock(MODID, i + "_beach_door");
                paper_door = Finder.findBlock(MODID, i + "_paper_door");
                four_panel_door = Finder.findBlock(MODID, i + "_four_panel_door");
                tropical_door = Finder.findBlock(MODID, i + "_tropical_door");
                glass_door = Finder.findBlock(MODID, i + "_glass_door");
                stable_door = Finder.findBlock(MODID, i + "_stable_door");
                stable_head_door = Finder.findBlock(MODID, i + "_stable_head_door");
                western_door = Finder.findBlock(MODID, i + "_western_door");
                mystic_door = Finder.findBlock(MODID, i + "_mystic_door");
                nether_door = Finder.findBlock(MODID, i + "_nether_door");
                swamp_door = Finder.findBlock(MODID, i + "_swamp_door");
                bamboo_door = Finder.findBlock(MODID, i + "_bamboo_door");
                bark_glass_door = Finder.findBlock(MODID, i + "_bark_glass_door");
                waffle_door = Finder.findBlock(MODID, i + "_waffle_door");
                whispering_door = Finder.findBlock(MODID, i + "_whispering_door");

                ItemBlockRenderTypes.setRenderLayer(japanese_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(japanese2_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(barn_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(barn_glass_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(modern_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cottage_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(classic_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(beach_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(paper_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(four_panel_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(tropical_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(glass_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stable_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(stable_head_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(western_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(mystic_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(nether_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(swamp_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(bamboo_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(bark_glass_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(waffle_door, renderSet);
                ItemBlockRenderTypes.setRenderLayer(whispering_door, renderSet);
            }
        }
    }

    public static class Trapdoors
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block barn_trapdoor, cottage_trapdoor, barred_trapdoor, beach_trapdoor, four_panel_trapdoor, glass_trapdoor, mystic_trapdoor, paper_trapdoor,
                    tropical_trapdoor, swamp_trapdoor, bamboo_trapdoor, classic_trapdoor, bark_trapdoor, ranch_trapdoor, blossom_trapdoor, barrel_trapdoor, whispering_trapdoor;

            for (String i : WOOD)
            {
                barn_trapdoor = Finder.findBlock(MODID, i+"_barn_trapdoor");
                cottage_trapdoor = Finder.findBlock(MODID, i+"_cottage_trapdoor");
                barred_trapdoor = Finder.findBlock(MODID, i+"_barred_trapdoor");
                beach_trapdoor = Finder.findBlock(MODID, i+"_beach_trapdoor");
                four_panel_trapdoor = Finder.findBlock(MODID, i+"_four_panel_trapdoor");
                glass_trapdoor = Finder.findBlock(MODID, i+"_glass_trapdoor");
                mystic_trapdoor = Finder.findBlock(MODID, i+"_mystic_trapdoor");
                paper_trapdoor = Finder.findBlock(MODID, i+"_paper_trapdoor");
                tropical_trapdoor = Finder.findBlock(MODID, i+"_tropical_trapdoor");
                swamp_trapdoor = Finder.findBlock(MODID, i+"_swamp_trapdoor");
                bamboo_trapdoor = Finder.findBlock(MODID, i+"_bamboo_trapdoor");
                classic_trapdoor = Finder.findBlock(MODID, i+"_classic_trapdoor");
                bark_trapdoor = Finder.findBlock(MODID, i+"_bark_trapdoor");
                ranch_trapdoor = Finder.findBlock(MODID, i+"_ranch_trapdoor");
                blossom_trapdoor = Finder.findBlock(MODID, i+"_blossom_trapdoor");
                barrel_trapdoor = Finder.findBlock(MODID, i+"_barrel_trapdoor");
                whispering_trapdoor = Finder.findBlock(MODID, i+"_whispering_trapdoor");

                ItemBlockRenderTypes.setRenderLayer(barn_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(cottage_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(barred_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(beach_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(four_panel_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(glass_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(mystic_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(paper_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(tropical_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(swamp_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(bamboo_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(classic_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(bark_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(ranch_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(blossom_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(barrel_trapdoor, renderSet);
                ItemBlockRenderTypes.setRenderLayer(whispering_trapdoor, renderSet);
            }
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }
    }

    public static class Windows
    {
        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD, RenderType renderSet)
        {
            Block window, window2, four_window, strippedlog_window, strippedlog_window2, strippedlog_four_window, plank_window, plank_window2,
                    plank_four_window, log_parapet, plank_parapet, blinds, shutter, louvered_shutter, pane_window, strippedpane_window, plank_pane_window,
                    curtain_rod;

            for (String i : WOOD)
            {
                window = Finder.findBlock(MODID, i+"_window");
                window2 = Finder.findBlock(MODID, i+"_window2");
                four_window = Finder.findBlock(MODID, i+"_four_window");
                strippedlog_window = Finder.findBlock(MODID, "stripped_"+i+"_log_window");
                strippedlog_window2 = Finder.findBlock(MODID, "stripped_"+i+"_log_window2");
                strippedlog_four_window = Finder.findBlock(MODID, "stripped_"+i+"_log_four_window");
                plank_window = Finder.findBlock(MODID, i+"_plank_window");
                plank_window2 = Finder.findBlock(MODID, i+"_plank_window2");
                plank_four_window = Finder.findBlock(MODID, i+"_plank_four_window");
                log_parapet = Finder.findBlock(MODID, i+"_log_parapet");
                plank_parapet = Finder.findBlock(MODID, i+"_plank_parapet");
                blinds = Finder.findBlock(MODID, i+"_blinds");
                shutter = Finder.findBlock(MODID, i+"_shutter");
                louvered_shutter = Finder.findBlock(MODID, i+"_louvered_shutter");
                pane_window = Finder.findBlock(MODID, i+"_pane_window");
                strippedpane_window = Finder.findBlock(MODID, "stripped_"+i+"_pane_window");
                plank_pane_window = Finder.findBlock(MODID, i+"_plank_pane_window");
                curtain_rod = Finder.findBlock(MODID, i+"_curtain_rod");

                ItemBlockRenderTypes.setRenderLayer(window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(window2, renderSet);
                ItemBlockRenderTypes.setRenderLayer(four_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(strippedlog_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(strippedlog_window2, renderSet);
                ItemBlockRenderTypes.setRenderLayer(strippedlog_four_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(plank_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(plank_window2, renderSet);
                ItemBlockRenderTypes.setRenderLayer(plank_four_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(log_parapet, renderSet);
                ItemBlockRenderTypes.setRenderLayer(plank_parapet, renderSet);
                ItemBlockRenderTypes.setRenderLayer(blinds, renderSet);
                ItemBlockRenderTypes.setRenderLayer(shutter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(louvered_shutter, renderSet);
                ItemBlockRenderTypes.setRenderLayer(pane_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(strippedpane_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(plank_pane_window, renderSet);
                ItemBlockRenderTypes.setRenderLayer(curtain_rod, renderSet);
            }
        }

        public static void clientWood(final FMLClientSetupEvent event, String MODID, List<String> WOOD)
        {
            clientWood(event, MODID, WOOD, RenderType.cutout());
        }
    }
}