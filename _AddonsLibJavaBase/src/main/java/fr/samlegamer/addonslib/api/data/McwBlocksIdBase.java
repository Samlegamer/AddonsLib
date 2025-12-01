package fr.addonslib.api.data;

import fr.addonslib.api.recipes.McwRecipesBase;

import java.util.Arrays;

public final class McwBlocksIdBase
{
    private McwBlocksIdBase() {}

    public static final McwBlockIdBase BRIDGES_WOOD_BLOCKS = new McwBlockIdBase(ModType.BRIDGES.getModid(), Arrays.asList(
            new BlockId("%material%_log_bridge_middle", McwReflected.LOG_BRIDGE, McwRecipesBase.LOG_BRIDGE),
            new BlockId("rope_%material%_bridge", McwReflected.BRIDGE_BLOCK_ROPE),
            new BlockId("%material%_bridge_pier", McwReflected.BRIDGE_SUPPORT),
            new BlockId("%material%_log_bridge_stair", McwReflected.BRIDGE_STAIRS),
            new BlockId("%material%_rope_bridge_stair", McwReflected.BRIDGE_STAIRS),
            new BlockId("%material%_rail_bridge", McwReflected.RAIL_BRIDGE)
    ));

    public static final McwBlockIdBase BRIDGES_STONE_BLOCKS = new McwBlockIdBase(ModType.BRIDGES.getModid(), Arrays.asList(
            new BlockId("%material%_bridge", McwReflected.BRIDGE_BLOCK),
            new BlockId("%material%_bridge_pier", McwReflected.BRIDGE_SUPPORT),
            new BlockId("%material%_bridge_stair", McwReflected.BRIDGE_STAIRS),
            new BlockId("balustrade_%material%_bridge", McwReflected.BRIDGE_BLOCK)
    ));

    public static final McwBlockIdBase DOORS_WOOD_BLOCKS = new McwBlockIdBase(ModType.DOORS.getModid(), Arrays.asList(
            new BlockId("%material%_japanese_door", McwReflected.JAPANESE_DOORS),
            new BlockId("%material%_japanese2_door", McwReflected.JAPANESE_DOORS),
            new BlockId("%material%_barn_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_barn_glass_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_modern_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_cottage_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_classic_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_beach_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_paper_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_four_panel_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_tropical_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_glass_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_stable_door", McwReflected.STABLE_DOOR),
            new BlockId("%material%_stable_head_door", McwReflected.STABLE_DOOR),
            new BlockId("%material%_western_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_mystic_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_nether_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_swamp_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_bamboo_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_bark_glass_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_waffle_door", McwReflected.DOOR_BLOCK),
            new BlockId("%material%_whispering_door", McwReflected.DOOR_BLOCK)
    ));

    public static final McwBlockIdBase FENCES_WOOD_BLOCKS = new McwBlockIdBase(ModType.FENCES.getModid(), Arrays.asList(
            new BlockId("%material%_picket_fence", McwReflected.FENCE_BLOCK),
            new BlockId("%material%_stockade_fence", McwReflected.FENCE_BLOCK),
            new BlockId("%material%_horse_fence", McwReflected.FENCE_BLOCK),
            new BlockId("%material%_wired_fence", McwReflected.WIRED_FENCE),
            new BlockId("%material%_highley_gate", McwReflected.FENCE_GATE_BLOCK),
            new BlockId("%material%_pyramid_gate", McwReflected.FENCE_GATE_BLOCK),
            new BlockId("%material%_curved_gate", McwReflected.DOUBLE_GATE)
    ));

    public static final McwBlockIdBase FENCES_LEAVE_BLOCKS = new McwBlockIdBase(ModType.FENCES.getModid(), Arrays.asList(
            new BlockId("%material%_hedge", McwReflected.FENCE_HITBOX)
    ));

    public static final McwBlockIdBase FENCES_STONE_BLOCKS = new McwBlockIdBase(ModType.FENCES.getModid(), Arrays.asList(
            new BlockId("modern_%material%_wall", McwReflected.FENCE_BLOCK),
            new BlockId("railing_%material%_wall", McwReflected.FENCE_BLOCK),
            new BlockId("%material%_railing_gate", McwReflected.FENCE_GATE_BLOCK),
            new BlockId("%material%_pillar_wall", McwReflected.FENCE_BLOCK),
            new BlockId("%material%_grass_topped_wall", McwReflected.FENCE_HITBOX)
    ));

    public static final McwBlockIdBase FURNITURES_WOOD_BLOCKS = new McwBlockIdBase(ModType.FURNITURES.getModid(), Arrays.asList(
            new BlockId("%material%_wardrobe", McwReflected.TALL_FURNITURE_HINGE),
            new BlockId("%material%_modern_wardrobe", McwReflected.TALL_FURNITURE_HINGE),
            new BlockId("%material%_double_wardrobe", McwReflected.TALL_FURNITURE),
            new BlockId("%material%_bookshelf", McwReflected.BOOK_CABINET),
            new BlockId("%material%_bookshelf_cupboard", McwReflected.BOOK_CABINET_HINGE),
            new BlockId("%material%_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("%material%_double_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("%material%_bookshelf_drawer", McwReflected.BOOK_DRAWER),
            new BlockId("%material%_lower_bookshelf_drawer", McwReflected.BOOK_DRAWER),
            new BlockId("%material%_large_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("%material%_lower_triple_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("%material%_triple_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("%material%_desk", McwReflected.DESK),
            new BlockId("%material%_covered_desk", McwReflected.DESK),
            new BlockId("%material%_modern_desk", McwReflected.DESK),
            new BlockId("%material%_table", McwReflected.TABLE_HITBOX),
            new BlockId("%material%_end_table", McwReflected.TABLE_HITBOX),
            new BlockId("%material%_coffee_table", McwReflected.TABLE),
            new BlockId("%material%_glass_table", McwReflected.TABLE_HITBOX),
            new BlockId("%material%_chair", McwReflected.CLASSIC_CHAIR),
            new BlockId("%material%_modern_chair", McwReflected.MODERN_CHAIR),
            new BlockId("%material%_striped_chair", McwReflected.STRIPED_CHAIR),
            new BlockId("%material%_stool_chair", McwReflected.CHAIR),
            new BlockId("%material%_counter", McwReflected.COUNTER),
            new BlockId("%material%_drawer_counter", McwReflected.STORAGE_COUNTER),
            new BlockId("%material%_double_drawer_counter", McwReflected.STORAGE_COUNTER),
            new BlockId("%material%_cupboard_counter", McwReflected.CUPBOARD_COUNTER),
            new BlockId("%material%_kitchen_cabinet", McwReflected.CABINET_HINGE),
            new BlockId("%material%_double_kitchen_cabinet", McwReflected.CABINET),
            new BlockId("%material%_glass_kitchen_cabinet", McwReflected.CABINET),
            new BlockId("stripped_%material%_wardrobe", McwReflected.TALL_FURNITURE_HINGE),
            new BlockId("stripped_%material%_modern_wardrobe", McwReflected.TALL_FURNITURE_HINGE),
            new BlockId("stripped_%material%_double_wardrobe", McwReflected.TALL_FURNITURE),
            new BlockId("stripped_%material%_bookshelf", McwReflected.BOOK_CABINET),
            new BlockId("stripped_%material%_bookshelf_cupboard", McwReflected.BOOK_CABINET_HINGE),
            new BlockId("stripped_%material%_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("stripped_%material%_double_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("stripped_%material%_bookshelf_drawer", McwReflected.BOOK_DRAWER),
            new BlockId("stripped_%material%_lower_bookshelf_drawer", McwReflected.BOOK_DRAWER),
            new BlockId("stripped_%material%_large_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("stripped_%material%_lower_triple_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("stripped_%material%_triple_drawer", McwReflected.WIDE_FURNITURE),
            new BlockId("stripped_%material%_desk", McwReflected.DESK),
            new BlockId("stripped_%material%_covered_desk", McwReflected.DESK),
            new BlockId("stripped_%material%_modern_desk", McwReflected.DESK),
            new BlockId("stripped_%material%_table", McwReflected.TABLE_HITBOX),
            new BlockId("stripped_%material%_end_table", McwReflected.TABLE_HITBOX),
            new BlockId("stripped_%material%_coffee_table", McwReflected.TABLE),
            new BlockId("stripped_%material%_glass_table", McwReflected.TABLE_HITBOX),
            new BlockId("stripped_%material%_chair", McwReflected.CLASSIC_CHAIR),
            new BlockId("stripped_%material%_modern_chair", McwReflected.MODERN_CHAIR),
            new BlockId("stripped_%material%_striped_chair", McwReflected.STRIPED_CHAIR),
            new BlockId("stripped_%material%_stool_chair", McwReflected.CHAIR),
            new BlockId("stripped_%material%_counter", McwReflected.COUNTER),
            new BlockId("stripped_%material%_drawer_counter", McwReflected.STORAGE_COUNTER),
            new BlockId("stripped_%material%_double_drawer_counter", McwReflected.STORAGE_COUNTER),
            new BlockId("stripped_%material%_cupboard_counter", McwReflected.CUPBOARD_COUNTER),
            new BlockId("stripped_%material%_kitchen_cabinet", McwReflected.CABINET_HINGE),
            new BlockId("stripped_%material%_double_kitchen_cabinet", McwReflected.CABINET),
            new BlockId("stripped_%material%_glass_kitchen_cabinet", McwReflected.CABINET),
            new BlockId("%material%_kitchen_sink", McwReflected.SINK_COUNTER),
            new BlockId("stripped_%material%_kitchen_sink", McwReflected.SINK_COUNTER)
    ));

    public static final McwBlockIdBase PATHS_WOOD_BLOCKS = new McwBlockIdBase(ModType.PATHS.getModid(), Arrays.asList(
            new BlockId("%material%_planks_path", McwReflected.FACING_PATH_BLOCK)
    ));

    public static final McwBlockIdBase ROOFS_WOOD_BLOCKS = new McwBlockIdBase(ModType.ROOFS.getModid(), Arrays.asList(
            new BlockId("%material%_roof", McwReflected.BASE_ROOF),
            new BlockId("%material%_attic_roof", McwReflected.ROOF_GLASS),
            new BlockId("%material%_top_roof", McwReflected.ROOF_TOP_NEW),
            new BlockId("%material%_lower_roof", McwReflected.BASE_ROOF),
            new BlockId("%material%_steep_roof", McwReflected.STEEP_ROOF),
            new BlockId("%material%_upper_lower_roof", McwReflected.LOWER_ROOF),
            new BlockId("%material%_upper_steep_roof", McwReflected.STEEP),
            new BlockId("%material%_planks_roof", McwReflected.BASE_ROOF),
            new BlockId("%material%_planks_attic_roof", McwReflected.ROOF_GLASS),
            new BlockId("%material%_planks_top_roof", McwReflected.ROOF_TOP_NEW),
            new BlockId("%material%_planks_lower_roof", McwReflected.BASE_ROOF),
            new BlockId("%material%_planks_steep_roof", McwReflected.STEEP_ROOF),
            new BlockId("%material%_planks_upper_lower_roof", McwReflected.LOWER_ROOF),
            new BlockId("%material%_planks_upper_steep_roof", McwReflected.STEEP)
    ));

    public static final McwBlockIdBase ROOFS_STONE_BLOCKS = new McwBlockIdBase(ModType.ROOFS.getModid(), Arrays.asList(
            new BlockId("%material%_roof", McwReflected.BASE_ROOF),
            new BlockId("%material%_attic_roof", McwReflected.ROOF_GLASS),
            new BlockId("%material%_top_roof", McwReflected.ROOF_TOP_NEW),
            new BlockId("%material%_lower_roof", McwReflected.BASE_ROOF),
            new BlockId("%material%_steep_roof", McwReflected.STEEP_ROOF),
            new BlockId("%material%_upper_lower_roof", McwReflected.LOWER_ROOF),
            new BlockId("%material%_upper_steep_roof", McwReflected.STEEP)
    ));

    public static final McwBlockIdBase STAIRS_WOOD_BLOCKS = new McwBlockIdBase(ModType.STAIRS.getModid(), Arrays.asList(
            new BlockId("%material%_terrace_stairs", McwReflected.TERRACE_STAIRS),
            new BlockId("%material%_skyline_stairs", McwReflected.SKYLINE_STAIRS),
            new BlockId("%material%_compact_stairs", McwReflected.COMPACT_STAIRS),
            new BlockId("%material%_bulk_stairs", McwReflected.BULK_STAIRS),
            new BlockId("%material%_loft_stairs", McwReflected.LOFT_STAIRS),
            new BlockId("%material%_railing", McwReflected.STAIR_RAILING),
            new BlockId("%material%_balcony", McwReflected.BALCONY_RAILING),
            new BlockId("%material%_platform", McwReflected.STAIR_PLATFORM)
    ));

    public static final McwBlockIdBase TRAPDOORS_WOOD_BLOCKS = new McwBlockIdBase(ModType.TRAPDOORS.getModid(), Arrays.asList(
            new BlockId("%material%_barn_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_cottage_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_barred_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_beach_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_four_panel_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_glass_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_mystic_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_paper_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_tropical_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_swamp_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_bamboo_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_classic_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_bark_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_ranch_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_blossom_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_barrel_trapdoor", McwReflected.TRAP_DOOR_BLOCK),
            new BlockId("%material%_whispering_trapdoor", McwReflected.TRAP_DOOR_BLOCK)
    ));

    public static final McwBlockIdBase WINDOWS_WOOD_BLOCKS = new McwBlockIdBase(ModType.WINDOWS.getModid(), Arrays.asList(
            new BlockId("%material%_window", McwReflected.CONNECTED_WINDOW),
            new BlockId("%material%_window2", McwReflected.WINDOW_BARRED),
            new BlockId("%material%_four_window", McwReflected.WINDOW_BARRED),
            new BlockId("stripped_%material%_log_window", McwReflected.CONNECTED_WINDOW),
            new BlockId("stripped_%material%_log_window2", McwReflected.WINDOW_BARRED),
            new BlockId("stripped_%material%_log_four_window", McwReflected.WINDOW_BARRED),
            new BlockId("%material%_plank_window", McwReflected.CONNECTED_WINDOW),
            new BlockId("%material%_plank_window2", McwReflected.WINDOW_BARRED),
            new BlockId("%material%_plank_four_window", McwReflected.WINDOW_BARRED),
            new BlockId("%material%_log_parapet", McwReflected.PARAPET),
            new BlockId("%material%_plank_parapet", McwReflected.PARAPET),
            new BlockId("%material%_blinds", McwReflected.BLINDS),
            new BlockId("%material%_shutter", McwReflected.SHUTTER),
            new BlockId("%material%_louvered_shutter", McwReflected.SHUTTER),
            new BlockId("%material%_pane_window", McwReflected.WINDOW),
            new BlockId("stripped_%material%_pane_window", McwReflected.WINDOW),
            new BlockId("%material%_plank_pane_window", McwReflected.WINDOW),
            new BlockId("%material%_curtain_rod", McwReflected.CURTAIN_ROD)
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
        return null;
    }

    public static McwBlockIdBase getBlocksWithModidLeave(ModType modType)
    {
        switch (modType) {
            case FENCES:
                return FENCES_LEAVE_BLOCKS;
            default:
                return null;
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
                return null;
        }
    }
}