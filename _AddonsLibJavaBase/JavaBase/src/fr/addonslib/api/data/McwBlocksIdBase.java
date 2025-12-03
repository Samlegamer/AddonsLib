package fr.addonslib.api.data;

import java.util.Arrays;
import java.util.Collections;

import static fr.addonslib.api.recipes.McwRecipesBase.*;
import static fr.addonslib.api.tags.McwTags.*;

public final class McwBlocksIdBase
{
    private McwBlocksIdBase() {}

    public static final McwBlockIdBase BRIDGES_WOOD_BLOCKS = new McwBlockIdBase(ModType.BRIDGES.getModid(), Arrays.asList(
            new BlockId("%material%_log_bridge_middle", McwReflected.LOG_BRIDGE, LOG_BRIDGES_TAGS, LOG_BRIDGE, LOG_BRIDGE_STAIR_RECYCLE),
            new BlockId("rope_%material%_bridge", McwReflected.BRIDGE_BLOCK_ROPE, ROPE_BRIDGES_TAGS, ROPE_BRIDGE, ROPE_BRIDGE_STAIR_RECYCLE),
            new BlockId("%material%_bridge_pier", McwReflected.BRIDGE_SUPPORT, BRIDGE_PIER_WOOD_TAGS, PIER),
            new BlockId("%material%_log_bridge_stair", McwReflected.BRIDGE_STAIRS, LOG_BRIDGE_STAIR_TAGS, LOG_BRIDGE_STAIR),
            new BlockId("%material%_rope_bridge_stair", McwReflected.BRIDGE_STAIRS, ROPE_BRIDGE_STAIR_TAGS, ROPE_BRIDGE_STAIR),
            new BlockId("%material%_rail_bridge", McwReflected.RAIL_BRIDGE, RAIL_BRIDGE_TAGS, RAIL_BRIDGE)
    ));

    public static final McwBlockIdBase BRIDGES_STONE_BLOCKS = new McwBlockIdBase(ModType.BRIDGES.getModid(), Arrays.asList(
            new BlockId("%material%_bridge", McwReflected.BRIDGE_BLOCK, STONE_BRIDGES_TAGS, STONE_BRIDGE),
            new BlockId("%material%_bridge_pier", McwReflected.BRIDGE_SUPPORT, BRIDGE_PIER_STONE_TAGS, STONE_PIER),
            new BlockId("%material%_bridge_stair", McwReflected.BRIDGE_STAIRS, STONE_BRIDGE_STAIR_TAGS, STONE_BRIDGE_STAIR),
            new BlockId("balustrade_%material%_bridge", McwReflected.BRIDGE_BLOCK, BALUSTRADE_BRIDGES_TAGS, BALUSTRADE_BRIDGE)
    ));

    public static final McwBlockIdBase DOORS_WOOD_BLOCKS = new McwBlockIdBase(ModType.DOORS.getModid(), Arrays.asList(
            new BlockId("%material%_japanese_door", McwReflected.JAPANESE_DOORS, SHOJI_DOORS_TAGS, JAPANESE_DOOR),
            new BlockId("%material%_japanese2_door", McwReflected.JAPANESE_DOORS, SHOJI_WHOLE_DOORS_TAGS, JAPANESE2_DOOR),
            new BlockId("%material%_barn_door", McwReflected.DOOR_BLOCK, BARN_DOORS_TAGS, BARN_DOOR),
            new BlockId("%material%_barn_glass_door", McwReflected.DOOR_BLOCK, BARN_GLASS_DOORS_TAGS, BARN_GLASS_DOOR),
            new BlockId("%material%_modern_door", McwReflected.DOOR_BLOCK, MODERN_DOORS_TAGS, MODERN_DOOR),
            new BlockId("%material%_cottage_door", McwReflected.DOOR_BLOCK, COTTAGE_DOORS_TAGS, COTTAGE_DOOR),
            new BlockId("%material%_classic_door", McwReflected.DOOR_BLOCK, CLASSIC_DOORS_TAGS, CLASSIC_DOOR),
            new BlockId("%material%_beach_door", McwReflected.DOOR_BLOCK, BEACH_DOORS_TAGS, BEACH_DOOR),
            new BlockId("%material%_paper_door", McwReflected.DOOR_BLOCK, PAPER_DOORS_TAGS, PAPER_DOOR),
            new BlockId("%material%_four_panel_door", McwReflected.DOOR_BLOCK, FOUR_PANEL_DOORS_TAGS, FOUR_PANEL_DOOR),
            new BlockId("%material%_tropical_door", McwReflected.DOOR_BLOCK, TROPICAL_DOORS_TAGS, TROPICAL_DOOR),
            new BlockId("%material%_glass_door", McwReflected.DOOR_BLOCK, GLASS_DOORS_TAGS, GLASS_DOOR),
            new BlockId("%material%_stable_door", McwReflected.STABLE_DOOR, STABLE_DOORS_TAGS, STABLE_DOOR),
            new BlockId("%material%_stable_head_door", McwReflected.STABLE_DOOR, STABLE_HEAD_DOORS_TAGS, STABLE_HEAD_DOOR),
            new BlockId("%material%_western_door", McwReflected.DOOR_BLOCK, WESTERN_DOORS_TAGS, WESTERN_DOOR),
            new BlockId("%material%_mystic_door", McwReflected.DOOR_BLOCK, MYSTIC_DOORS_TAGS, MYSTIC_DOOR),
            new BlockId("%material%_nether_door", McwReflected.DOOR_BLOCK, NETHER_DOORS_TAGS, NETHER_DOOR),
            new BlockId("%material%_swamp_door", McwReflected.DOOR_BLOCK, SWAMP_DOORS_TAGS, SWAMP_DOOR),
            new BlockId("%material%_bamboo_door", McwReflected.DOOR_BLOCK, BAMBOO_DOORS_TAGS, BAMBOO_DOOR),
            new BlockId("%material%_bark_glass_door", McwReflected.DOOR_BLOCK, BARN_GLASS_DOORS_TAGS, BARK_GLASS_DOOR),
            new BlockId("%material%_waffle_door", McwReflected.DOOR_BLOCK, WAFFLE_DOORS_TAGS, WAFFLE_DOOR),
            new BlockId("%material%_whispering_door", McwReflected.DOOR_BLOCK, WHISPERING_DOORS_TAGS, WHISPERING_DOOR)
    ));

    public static final McwBlockIdBase FENCES_WOOD_BLOCKS = new McwBlockIdBase(ModType.FENCES.getModid(), Arrays.asList(
            new BlockId("%material%_picket_fence", McwReflected.FENCE_BLOCK, PICKET_FENCE_TAGS, PICKET_FENCE),
            new BlockId("%material%_stockade_fence", McwReflected.FENCE_BLOCK, STOCKADE_FENCE_TAGS, STOCKADE_FENCE),
            new BlockId("%material%_horse_fence", McwReflected.FENCE_BLOCK, HORSE_FENCE_TAGS, HORSE_FENCE),
            new BlockId("%material%_wired_fence", McwReflected.WIRED_FENCE, WIRED_FENCE_TAGS, WIRED_FENCE),
            new BlockId("%material%_highley_gate", McwReflected.FENCE_GATE_BLOCK, HIGHLEY_GATE_TAGS, HIGHLEY_GATE),
            new BlockId("%material%_pyramid_gate", McwReflected.FENCE_GATE_BLOCK, PYRAMID_GATE_TAGS, PYRAMID_GATE),
            new BlockId("%material%_curved_gate", McwReflected.DOUBLE_GATE, CURVED_GATE_TAGS, CURVED_GATE)
    ));

    public static final McwBlockIdBase FENCES_LEAVE_BLOCKS = new McwBlockIdBase(ModType.FENCES.getModid(), Arrays.asList(
            new BlockId("%material%_hedge", McwReflected.FENCE_HITBOX, HEDGE_TAGS, HEDGE)
    ));

    public static final McwBlockIdBase FENCES_STONE_BLOCKS = new McwBlockIdBase(ModType.FENCES.getModid(), Arrays.asList(
            new BlockId("modern_%material%_wall", McwReflected.FENCE_BLOCK, MODERN_WALL_TAGS, MODERN_WALL, MODERN_WALL_STONECUTTER),
            new BlockId("railing_%material%_wall", McwReflected.FENCE_BLOCK, RAILING_WALL_TAGS, RAILING_WALL, RAILING_WALL_STONECUTTER),
            new BlockId("%material%_railing_gate", McwReflected.FENCE_GATE_BLOCK, RAILING_GATE_TAGS, RAILING_GATE, RAILING_GATE_STONECUTTER),
            new BlockId("%material%_pillar_wall", McwReflected.FENCE_BLOCK, PILLAR_WALL_TAGS, PILLAR_WALL),
            new BlockId("%material%_grass_topped_wall", McwReflected.FENCE_HITBOX, GRASS_TOPPED_WALL_TAGS, GRASS_TOPPED_WALL)
    ));

    public static final McwBlockIdBase FURNITURES_WOOD_BLOCKS = new McwBlockIdBase(ModType.FURNITURES.getModid(), Arrays.asList(
            new BlockId("%material%_wardrobe", McwReflected.TALL_FURNITURE_HINGE, WARDROBE_TAGS, WARDROBE),
            new BlockId("%material%_modern_wardrobe", McwReflected.TALL_FURNITURE_HINGE, MODERN_WARDROBE_TAGS, MODERN_WARDROBE),
            new BlockId("%material%_double_wardrobe", McwReflected.TALL_FURNITURE, DOUBLE_WARDROBE_TAGS, DOUBLE_WARDROBE),
            new BlockId("%material%_bookshelf", McwReflected.BOOK_CABINET, BOOKSHELF_TAGS, BOOKSHELF),
            new BlockId("%material%_bookshelf_cupboard", McwReflected.BOOK_CABINET_HINGE, BOOKSHELF_CUPBOARD_TAGS, BOOKSHELF_CUPBOARD),
            new BlockId("%material%_drawer", McwReflected.WIDE_FURNITURE, DRAWER_TAGS, DRAWER),
            new BlockId("%material%_double_drawer", McwReflected.WIDE_FURNITURE, DOUBLE_DRAWER_TAGS, DOUBLE_DRAWER),
            new BlockId("%material%_bookshelf_drawer", McwReflected.BOOK_DRAWER, BOOKSHELF_DRAWER_TAGS, BOOKSHELF_DRAWER),
            new BlockId("%material%_lower_bookshelf_drawer", McwReflected.BOOK_DRAWER, LOWER_BOOKSHELF_DRAWER_TAGS, LOWER_BOOKSHELF_DRAWER),
            new BlockId("%material%_large_drawer", McwReflected.WIDE_FURNITURE, LARGE_DRAWER_TAGS, LARGE_DRAWER),
            new BlockId("%material%_lower_triple_drawer", McwReflected.WIDE_FURNITURE, LOWER_TRIPLE_DRAWER_TAGS, LOWER_TRIPLE_DRAWER),
            new BlockId("%material%_triple_drawer", McwReflected.WIDE_FURNITURE, TRIPLE_DRAWER_TAGS, TRIPLE_DRAWER),
            new BlockId("%material%_desk", McwReflected.DESK, DESK_TAGS, DESK),
            new BlockId("%material%_covered_desk", McwReflected.DESK, COVERED_DESK_TAGS, COVERED_DESK),
            new BlockId("%material%_modern_desk", McwReflected.DESK, MODERN_DESK_TAGS, MODERN_DESK),
            new BlockId("%material%_table", McwReflected.TABLE_HITBOX, TABLE_TAGS, TABLE),
            new BlockId("%material%_end_table", McwReflected.TABLE_HITBOX, END_TABLE_TAGS, END_TABLE),
            new BlockId("%material%_coffee_table", McwReflected.TABLE, COFFEE_TABLE_TAGS, COFFEE_TABLE),
            new BlockId("%material%_glass_table", McwReflected.TABLE_HITBOX, GLASS_TABLE_TAGS, GLASS_TABLE),
            new BlockId("%material%_chair", McwReflected.CLASSIC_CHAIR, CHAIR_TAGS, CHAIR),
            new BlockId("%material%_modern_chair", McwReflected.MODERN_CHAIR, MODERN_CHAIR_TAGS, MODERN_CHAIR),
            new BlockId("%material%_striped_chair", McwReflected.STRIPED_CHAIR, STRIPED_CHAIR_TAGS, STRIPED_CHAIR),
            new BlockId("%material%_stool_chair", McwReflected.CHAIR, STOOL_CHAIR_TAGS, STOOL_CHAIR),
            new BlockId("%material%_counter", McwReflected.COUNTER, COUNTER_TAGS, COUNTER),
            new BlockId("%material%_drawer_counter", McwReflected.STORAGE_COUNTER, DRAWER_COUNTER_TAGS, DRAWER_COUNTER),
            new BlockId("%material%_double_drawer_counter", McwReflected.STORAGE_COUNTER, DOUBLE_DRAWER_COUNTER_TAGS, DOUBLE_DRAWER_COUNTER),
            new BlockId("%material%_cupboard_counter", McwReflected.CUPBOARD_COUNTER, CUPBOARD_COUNTER_TAGS, CUPBOARD_COUNTER),
            new BlockId("%material%_kitchen_cabinet", McwReflected.CABINET_HINGE, KITCHEN_CABINET_TAGS, KITCHEN_CABINET),
            new BlockId("%material%_double_kitchen_cabinet", McwReflected.CABINET, DOUBLE_KITCHEN_CABINET_TAGS, DOUBLE_KITCHEN_CABINET),
            new BlockId("%material%_glass_kitchen_cabinet", McwReflected.CABINET, GLASS_KITCHEN_CABINET_TAGS, GLASS_KITCHEN_CABINET),
            new BlockId("stripped_%material%_wardrobe", McwReflected.TALL_FURNITURE_HINGE, WARDROBE_TAGS, STRIPPED_WARDROBE),
            new BlockId("stripped_%material%_modern_wardrobe", McwReflected.TALL_FURNITURE_HINGE, MODERN_WARDROBE_TAGS, STRIPPED_MODERN_WARDROBE),
            new BlockId("stripped_%material%_double_wardrobe", McwReflected.TALL_FURNITURE, DOUBLE_WARDROBE_TAGS, STRIPPED_DOUBLE_WARDROBE),
            new BlockId("stripped_%material%_bookshelf", McwReflected.BOOK_CABINET, BOOKSHELF_TAGS, STRIPPED_BOOKSHELF),
            new BlockId("stripped_%material%_bookshelf_cupboard", McwReflected.BOOK_CABINET_HINGE, BOOKSHELF_CUPBOARD_TAGS, STRIPPED_BOOKSHELF_CUPBOARD),
            new BlockId("stripped_%material%_drawer", McwReflected.WIDE_FURNITURE, DRAWER_TAGS, STRIPPED_DRAWER),
            new BlockId("stripped_%material%_double_drawer", McwReflected.WIDE_FURNITURE, DOUBLE_DRAWER_TAGS, STRIPPED_DOUBLE_DRAWER),
            new BlockId("stripped_%material%_bookshelf_drawer", McwReflected.BOOK_DRAWER, BOOKSHELF_DRAWER_TAGS, STRIPPED_BOOKSHELF_DRAWER),
            new BlockId("stripped_%material%_lower_bookshelf_drawer", McwReflected.BOOK_DRAWER, LOWER_BOOKSHELF_DRAWER_TAGS, STRIPPED_LOWER_BOOKSHELF_DRAWER),
            new BlockId("stripped_%material%_large_drawer", McwReflected.WIDE_FURNITURE, LARGE_DRAWER_TAGS, STRIPPED_LARGE_DRAWER),
            new BlockId("stripped_%material%_lower_triple_drawer", McwReflected.WIDE_FURNITURE, LOWER_TRIPLE_DRAWER_TAGS, STRIPPED_LOWER_TRIPLE_DRAWER),
            new BlockId("stripped_%material%_triple_drawer", McwReflected.WIDE_FURNITURE, TRIPLE_DRAWER_TAGS, STRIPPED_TRIPLE_DRAWER),
            new BlockId("stripped_%material%_desk", McwReflected.DESK, DESK_TAGS, STRIPPED_DESK),
            new BlockId("stripped_%material%_covered_desk", McwReflected.DESK, COVERED_DESK_TAGS, STRIPPED_COVERED_DESK),
            new BlockId("stripped_%material%_modern_desk", McwReflected.DESK, MODERN_DESK_TAGS, STRIPPED_MODERN_DESK),
            new BlockId("stripped_%material%_table", McwReflected.TABLE_HITBOX, TABLE_TAGS, STRIPPED_TABLE),
            new BlockId("stripped_%material%_end_table", McwReflected.TABLE_HITBOX, END_TABLE_TAGS, STRIPPED_END_TABLE),
            new BlockId("stripped_%material%_coffee_table", McwReflected.TABLE, COFFEE_TABLE_TAGS, STRIPPED_COFFEE_TABLE),
            new BlockId("stripped_%material%_glass_table", McwReflected.TABLE_HITBOX, GLASS_TABLE_TAGS, STRIPPED_GLASS_TABLE),
            new BlockId("stripped_%material%_chair", McwReflected.CLASSIC_CHAIR, CHAIR_TAGS, STRIPPED_CHAIR),
            new BlockId("stripped_%material%_modern_chair", McwReflected.MODERN_CHAIR, MODERN_CHAIR_TAGS, STRIPPED_MODERN_CHAIR),
            new BlockId("stripped_%material%_striped_chair", McwReflected.STRIPED_CHAIR, STRIPED_CHAIR_TAGS, STRIPPED_STRIPED_CHAIR),
            new BlockId("stripped_%material%_stool_chair", McwReflected.CHAIR, STOOL_CHAIR_TAGS, STRIPPED_STOOL_CHAIR),
            new BlockId("stripped_%material%_counter", McwReflected.COUNTER, COUNTER_TAGS, STRIPPED_COUNTER),
            new BlockId("stripped_%material%_drawer_counter", McwReflected.STORAGE_COUNTER, DRAWER_COUNTER_TAGS, STRIPPED_DRAWER_COUNTER),
            new BlockId("stripped_%material%_double_drawer_counter", McwReflected.STORAGE_COUNTER, DOUBLE_DRAWER_COUNTER_TAGS, STRIPPED_DOUBLE_DRAWER_COUNTER),
            new BlockId("stripped_%material%_cupboard_counter", McwReflected.CUPBOARD_COUNTER, CUPBOARD_COUNTER_TAGS, STRIPPED_CUPBOARD_COUNTER),
            new BlockId("stripped_%material%_kitchen_cabinet", McwReflected.CABINET_HINGE, KITCHEN_CABINET_TAGS, STRIPPED_KITCHEN_CABINET),
            new BlockId("stripped_%material%_double_kitchen_cabinet", McwReflected.CABINET, DOUBLE_KITCHEN_CABINET_TAGS, STRIPPED_DOUBLE_KITCHEN_CABINET),
            new BlockId("stripped_%material%_glass_kitchen_cabinet", McwReflected.CABINET, GLASS_KITCHEN_CABINET_TAGS, STRIPPED_GLASS_KITCHEN_CABINET),
            new BlockId("%material%_kitchen_sink", McwReflected.SINK_COUNTER, KITCHEN_SINK_TAGS, KITCHEN_SINK),
            new BlockId("stripped_%material%_kitchen_sink", McwReflected.SINK_COUNTER, KITCHEN_SINK_TAGS, STRIPPED_KITCHEN_SINK)
    ));

    public static final McwBlockIdBase PATHS_WOOD_BLOCKS = new McwBlockIdBase(ModType.PATHS.getModid(), Arrays.asList(
            new BlockId("%material%_planks_path", McwReflected.FACING_PATH_BLOCK, PLANKS_PATH_TAGS, PLANKS_PATH)
    ));

    public static final McwBlockIdBase ROOFS_WOOD_BLOCKS = new McwBlockIdBase(ModType.ROOFS.getModid(), Arrays.asList(
            new BlockId("%material%_roof", McwReflected.BASE_ROOF, ROOF_WOOD_TAGS, ROOF),
            new BlockId("%material%_attic_roof", McwReflected.ROOF_GLASS, ATTIC_ROOF_WOOD_TAGS, ATTIC_ROOF),
            new BlockId("%material%_top_roof", McwReflected.ROOF_TOP_NEW, TOP_ROOF_WOOD_TAGS, TOP_ROOF),
            new BlockId("%material%_lower_roof", McwReflected.BASE_ROOF, LOWER_ROOF_WOOD_TAGS, LOWER_ROOF),
            new BlockId("%material%_steep_roof", McwReflected.STEEP_ROOF, STEEP_ROOF_WOOD_TAGS, STEEP_ROOF),
            new BlockId("%material%_upper_lower_roof", McwReflected.LOWER_ROOF, UPPER_LOWER_ROOF_WOOD_TAGS, UPPER_LOWER_ROOF),
            new BlockId("%material%_upper_steep_roof", McwReflected.STEEP, UPPER_STEEP_ROOF_WOOD_TAGS, UPPER_STEEP_ROOF),
            new BlockId("%material%_planks_roof", McwReflected.BASE_ROOF, ROOF_WOOD_TAGS, ROOF),
            new BlockId("%material%_planks_attic_roof", McwReflected.ROOF_GLASS, ATTIC_ROOF_WOOD_TAGS, ATTIC_ROOF),
            new BlockId("%material%_planks_top_roof", McwReflected.ROOF_TOP_NEW, TOP_ROOF_WOOD_TAGS, TOP_ROOF),
            new BlockId("%material%_planks_lower_roof", McwReflected.BASE_ROOF, LOWER_ROOF_WOOD_TAGS, LOWER_ROOF),
            new BlockId("%material%_planks_steep_roof", McwReflected.STEEP_ROOF, STEEP_ROOF_WOOD_TAGS, STEEP_ROOF),
            new BlockId("%material%_planks_upper_lower_roof", McwReflected.LOWER_ROOF, UPPER_LOWER_ROOF_WOOD_TAGS, UPPER_LOWER_ROOF),
            new BlockId("%material%_planks_upper_steep_roof", McwReflected.STEEP, UPPER_STEEP_ROOF_WOOD_TAGS, UPPER_STEEP_ROOF)
    ));

    public static final McwBlockIdBase ROOFS_STONE_BLOCKS = new McwBlockIdBase(ModType.ROOFS.getModid(), Arrays.asList(
            new BlockId("%material%_roof", McwReflected.BASE_ROOF, ROOF_STONE_TAGS, STONE_ROOF),
            new BlockId("%material%_attic_roof", McwReflected.ROOF_GLASS, ATTIC_ROOF_STONE_TAGS, STONE_ATTIC_ROOF),
            new BlockId("%material%_top_roof", McwReflected.ROOF_TOP_NEW, TOP_ROOF_STONE_TAGS, STONE_TOP_ROOF),
            new BlockId("%material%_lower_roof", McwReflected.BASE_ROOF, LOWER_ROOF_STONE_TAGS, STONE_LOWER_ROOF),
            new BlockId("%material%_steep_roof", McwReflected.STEEP_ROOF, STEEP_ROOF_STONE_TAGS, STONE_STEEP_ROOF),
            new BlockId("%material%_upper_lower_roof", McwReflected.LOWER_ROOF, UPPER_LOWER_ROOF_STONE_TAGS, STONE_UPPER_LOWER_ROOF),
            new BlockId("%material%_upper_steep_roof", McwReflected.STEEP, UPPER_STEEP_ROOF_STONE_TAGS, STONE_UPPER_STEEP_ROOF)
    ));

    public static final McwBlockIdBase STAIRS_WOOD_BLOCKS = new McwBlockIdBase(ModType.STAIRS.getModid(), Arrays.asList(
            new BlockId("%material%_terrace_stairs", McwReflected.TERRACE_STAIRS, TERRACE_STAIRS_TAGS, TERRACE_STAIRS),
            new BlockId("%material%_skyline_stairs", McwReflected.SKYLINE_STAIRS, SKYLINE_STAIRS_TAGS, SKYLINE_STAIRS),
            new BlockId("%material%_compact_stairs", McwReflected.COMPACT_STAIRS, COMPACT_STAIRS_TAGS, COMPACT_STAIRS),
            new BlockId("%material%_bulk_stairs", McwReflected.BULK_STAIRS, BULK_STAIRS_TAGS, BULK_STAIRS),
            new BlockId("%material%_loft_stairs", McwReflected.LOFT_STAIRS, LOFT_STAIRS_TAGS, LOFT_STAIRS),
            new BlockId("%material%_railing", McwReflected.STAIR_RAILING, RAILING_TAGS, RAILING),
            new BlockId("%material%_balcony", McwReflected.BALCONY_RAILING, BALCONY_TAGS, BALCONY),
            new BlockId("%material%_platform", McwReflected.STAIR_PLATFORM, PLATFORM_TAGS, PLATFORM)
    ));

    public static final McwBlockIdBase TRAPDOORS_WOOD_BLOCKS = new McwBlockIdBase(ModType.TRAPDOORS.getModid(), Arrays.asList(
            new BlockId("%material%_barn_trapdoor", McwReflected.TRAP_DOOR_BLOCK, BARN_TRAPDOOR_TAGS, BARN_TRAPDOOR),
            new BlockId("%material%_cottage_trapdoor", McwReflected.TRAP_DOOR_BLOCK, COTTAGE_TRAPDOOR_TAGS, COTTAGE_TRAPDOOR),
            new BlockId("%material%_barred_trapdoor", McwReflected.TRAP_DOOR_BLOCK, BARRED_TRAPDOOR_TAGS, BARRED_TRAPDOOR),
            new BlockId("%material%_beach_trapdoor", McwReflected.TRAP_DOOR_BLOCK, BEACH_TRAPDOOR_TAGS, BEACH_TRAPDOOR),
            new BlockId("%material%_four_panel_trapdoor", McwReflected.TRAP_DOOR_BLOCK, FOUR_PANEL_TRAPDOOR_TAGS, FOUR_PANEL_TRAPDOOR),
            new BlockId("%material%_glass_trapdoor", McwReflected.TRAP_DOOR_BLOCK, GLASS_TRAPDOOR_TAGS, GLASS_TRAPDOOR),
            new BlockId("%material%_mystic_trapdoor", McwReflected.TRAP_DOOR_BLOCK, MYSTIC_TRAPDOOR_TAGS, MYSTIC_TRAPDOOR),
            new BlockId("%material%_paper_trapdoor", McwReflected.TRAP_DOOR_BLOCK, PAPER_TRAPDOOR_TAGS, PAPER_TRAPDOOR),
            new BlockId("%material%_tropical_trapdoor", McwReflected.TRAP_DOOR_BLOCK, TROPICAL_TRAPDOOR_TAGS, TROPICAL_TRAPDOOR),
            new BlockId("%material%_swamp_trapdoor", McwReflected.TRAP_DOOR_BLOCK, SWAMP_TRAPDOOR_TAGS, SWAMP_TRAPDOOR),
            new BlockId("%material%_bamboo_trapdoor", McwReflected.TRAP_DOOR_BLOCK, BAMBOO_TRAPDOOR_TAGS, BAMBOO_TRAPDOOR),
            new BlockId("%material%_classic_trapdoor", McwReflected.TRAP_DOOR_BLOCK, CLASSIC_TRAPDOOR_TAGS, CLASSIC_TRAPDOOR),
            new BlockId("%material%_bark_trapdoor", McwReflected.TRAP_DOOR_BLOCK, BARK_TRAPDOOR_TAGS, BARK_TRAPDOOR),
            new BlockId("%material%_ranch_trapdoor", McwReflected.TRAP_DOOR_BLOCK, RANCH_TRAPDOOR_TAGS, RANCH_TRAPDOOR),
            new BlockId("%material%_blossom_trapdoor", McwReflected.TRAP_DOOR_BLOCK, WAFFLE_TRAPDOOR_TAGS, BLOSSOM_TRAPDOOR),
            new BlockId("%material%_barrel_trapdoor", McwReflected.TRAP_DOOR_BLOCK, BARREL_TRAPDOOR_TAGS, BARREL_TRAPDOOR),
            new BlockId("%material%_whispering_trapdoor", McwReflected.TRAP_DOOR_BLOCK, WHISPERING_TRAPDOOR_TAGS, WHISPERING_TRAPDOOR)
    ));

    public static final McwBlockIdBase WINDOWS_WOOD_BLOCKS = new McwBlockIdBase(ModType.WINDOWS.getModid(), Arrays.asList(
            new BlockId("%material%_window", McwReflected.CONNECTED_WINDOW, WINDOW_TAGS, WINDOW),
            new BlockId("%material%_window2", McwReflected.WINDOW_BARRED, WINDOW2_TAGS, WINDOW2),
            new BlockId("%material%_four_window", McwReflected.WINDOW_BARRED, FOUR_WINDOW_TAGS, FOUR_WINDOW),
            new BlockId("stripped_%material%_log_window", McwReflected.CONNECTED_WINDOW, WINDOW_TAGS, STRIPPED_LOG_WINDOW),
            new BlockId("stripped_%material%_log_window2", McwReflected.WINDOW_BARRED, WINDOW2_TAGS, STRIPPED_LOG_WINDOW2),
            new BlockId("stripped_%material%_log_four_window", McwReflected.WINDOW_BARRED, FOUR_WINDOW_TAGS, STRIPPED_LOG_FOUR_WINDOW),
            new BlockId("%material%_plank_window", McwReflected.CONNECTED_WINDOW, WINDOW_TAGS, PLANK_WINDOW),
            new BlockId("%material%_plank_window2", McwReflected.WINDOW_BARRED, WINDOW2_TAGS, PLANK_WINDOW2),
            new BlockId("%material%_plank_four_window", McwReflected.WINDOW_BARRED, FOUR_WINDOW_TAGS, PLANK_FOUR_WINDOW),
            new BlockId("%material%_log_parapet", McwReflected.PARAPET, LOG_PARAPET_TAGS, LOG_PARAPET),
            new BlockId("%material%_plank_parapet", McwReflected.PARAPET, PLANK_PARAPET_TAGS, PLANK_PARAPET),
            new BlockId("%material%_blinds", McwReflected.BLINDS, BLINDS_TAGS, BLINDS),
            new BlockId("%material%_shutter", McwReflected.SHUTTER, SHUTTER_TAGS, SHUTTER),
            new BlockId("%material%_louvered_shutter", McwReflected.SHUTTER, LOUVERED_SHUTTER_TAGS, LOUVERED_SHUTTER),
            new BlockId("%material%_pane_window", McwReflected.WINDOW, PANE_WINDOW_TAGS, PANE_WINDOW),
            new BlockId("stripped_%material%_pane_window", McwReflected.WINDOW, PANE_WINDOW_TAGS, STRIPPED_PANE_WINDOW),
            new BlockId("%material%_plank_pane_window", McwReflected.WINDOW, PANE_WINDOW_TAGS, PLANK_PANE_WINDOW),
            new BlockId("%material%_curtain_rod", McwReflected.CURTAIN_ROD, CURTAIN_ROD_TAGS, CURTAIN_ROD)
    ));

    public static String replacement(String id, String realMat)
    {
        return id.replace("%material%", realMat);
    }

    public static McwBlockIdBase getBlocksWithModidWood(ModType modType)
    {
        switch (modType) {
            case BRIDGES:
                return BRIDGES_WOOD_BLOCKS;
            case DOORS:
                return DOORS_WOOD_BLOCKS;
            case FENCES:
                return FENCES_WOOD_BLOCKS;
            case FURNITURES:
                return FURNITURES_WOOD_BLOCKS;
            case PATHS:
                return PATHS_WOOD_BLOCKS;
            case ROOFS:
                return ROOFS_WOOD_BLOCKS;
            case STAIRS:
                return STAIRS_WOOD_BLOCKS;
            case TRAPDOORS:
                return TRAPDOORS_WOOD_BLOCKS;
            case WINDOWS:
                return WINDOWS_WOOD_BLOCKS;
        }
        return new McwBlockIdBase("none", Collections.emptyList());
    }

    public static McwBlockIdBase getBlocksWithModidLeave(ModType modType)
    {
        switch (modType) {
            case FENCES:
                return FENCES_LEAVE_BLOCKS;
            default:
                return new McwBlockIdBase("none", Collections.emptyList());
        }
    }

    public static McwBlockIdBase getBlocksWithModidStone(ModType modType)
    {
        switch (modType) {
            case BRIDGES:
                return BRIDGES_STONE_BLOCKS;
            case FENCES:
                return FENCES_STONE_BLOCKS;
            case ROOFS:
                return ROOFS_STONE_BLOCKS;
            default:
                return new McwBlockIdBase("none", Collections.emptyList());
        }
    }
}
