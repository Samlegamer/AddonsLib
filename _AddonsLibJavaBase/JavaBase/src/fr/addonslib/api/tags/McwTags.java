package fr.addonslib.api.tags;

import fr.addonslib.api.data.ModType;

import java.util.Arrays;
import java.util.Collections;

public class McwTags
{
    public static final String MINEABLE_AXE = "mineable/axe";
    public static final String MINEABLE_PICKAXE = "mineable/pickaxe";
    public static final String WOODEN_DOORS = "wooden_doors";
    public static final String FENCES = "fences";
    public static final String FENCE_GATES = "fence_gates";
    public static final String WOODEN_FENCES = "wooden_fences";
    public static final String WALLS = "walls";
    public static final String WOODEN_TRAPDOORS = "wooden_trapdoors";

    //Enchants
    private static final String ENCHANTMENT_POWER_PROVIDER_FURNITURE = Tags.formatTag(ModType.FURNITURES.getModid(), "enchantment_power_provider");
    public static final String ENCHANTMENT_POWER_PROVIDER_VANILLA = Tags.formatTag("minecraft", "enchantment_power_provider");

    // Bridges Wood Tags
    public static final Tags LOG_BRIDGES_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "log_bridges"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags ROPE_BRIDGES_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "rope_bridges"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags BRIDGE_PIER_WOOD_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "wooden_piers"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags LOG_BRIDGE_STAIR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "log_stairs"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags ROPE_BRIDGE_STAIR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "rope_stairs"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags RAIL_BRIDGE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "rail_bridges"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());

    // Bridges Stone Tags
    public static final Tags STONE_BRIDGES_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "stone_bridges"), Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags BRIDGE_PIER_STONE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "stone_piers"), Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags STONE_BRIDGE_STAIR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "stone_stairs"), Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags BALUSTRADE_BRIDGES_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.BRIDGES.getModid(), "stone_bridges"), Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());

    // Doors Wood Tags
    public static final Tags SHOJI_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "shoji_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags SHOJI_WHOLE_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "shoji_whole_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags BARN_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "barn_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags BARN_GLASS_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "barn_glass_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags MODERN_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "modern_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags COTTAGE_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "cottage_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags CLASSIC_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "classic_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags BEACH_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "beach_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags PAPER_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "paper_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags FOUR_PANEL_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "four_panel_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags TROPICAL_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "tropical_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags GLASS_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "glass_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags STABLE_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "stable_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags STABLE_HEAD_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "stable_head_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags WESTERN_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "western_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags MYSTIC_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "mystic_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags NETHER_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "nether_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags SWAMP_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "swamp_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags BAMBOO_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "bamboo_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags WAFFLE_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "waffle_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags WHISPERING_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "whispering_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));
    public static final Tags BARK_GLASS_DOORS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.DOORS.getModid(), "bark_glass_doors"), Tags.formatTag("minecraft", WOODEN_DOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_DOORS)));

    // Fences Wood Tags
        public static final Tags PICKET_FENCE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "picket_fences"), Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Arrays.asList(Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES)));
        public static final Tags STOCKADE_FENCE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "stockade_fences"), Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Arrays.asList(Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES)));
        public static final Tags HORSE_FENCE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "horse_fences"), Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Arrays.asList(Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES)));
        public static final Tags WIRED_FENCE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "wired_fences"), Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Arrays.asList(Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES)));
        public static final Tags HIGHLEY_GATE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "highley_gates"), Tags.formatTag("minecraft", FENCE_GATES), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.emptyList());
        public static final Tags PYRAMID_GATE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "pyramid_gates"), Tags.formatTag("minecraft", FENCE_GATES), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.emptyList());
        public static final Tags CURVED_GATE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "curved_double_gates"), Tags.formatTag("minecraft", FENCE_GATES), Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Arrays.asList(Tags.formatTag("minecraft", WOODEN_FENCES), Tags.formatTag("minecraft", FENCES)));

        // Fences Leaves Tags
        public static final Tags HEDGE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "hedges"), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", WALLS), Tags.formatTag("minecraft", "mineable/hoe")),
            Collections.singletonList(Tags.formatTag("minecraft", WALLS)));

        // Fences Stone Tags
        public static final Tags MODERN_WALL_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "modern_walls"), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_PICKAXE)),
            Collections.singletonList(Tags.formatTag("minecraft", FENCES)));
        public static final Tags RAILING_WALL_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "railing_walls"), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_PICKAXE)),
            Collections.singletonList(Tags.formatTag("minecraft", FENCES)));
        public static final Tags RAILING_GATE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "railing_gates"), Tags.formatTag("minecraft", FENCE_GATES), Tags.formatTag("minecraft", MINEABLE_PICKAXE)),
            Collections.emptyList());
        public static final Tags PILLAR_WALL_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "pillar_walls"), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", MINEABLE_PICKAXE)),
            Collections.singletonList(Tags.formatTag("minecraft", FENCES)));
        public static final Tags GRASS_TOPPED_WALL_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FENCES.getModid(), "grass_topped_walls"), Tags.formatTag("minecraft", FENCES), Tags.formatTag("minecraft", WALLS), Tags.formatTag("minecraft", MINEABLE_PICKAXE), Tags.formatTag("diagonalfences", "non_diagonal_fences")),
            Collections.singletonList(Tags.formatTag("minecraft", WALLS)));

    // Furnitures Wood Tags
    public static final Tags WARDROBE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "wadrobe"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags MODERN_WARDROBE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "modern_wardrobe"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags DOUBLE_WARDROBE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "double_wardrobe"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags BOOKSHELF_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "bookshelf"), Tags.formatTag("minecraft", MINEABLE_AXE), ENCHANTMENT_POWER_PROVIDER_FURNITURE, ENCHANTMENT_POWER_PROVIDER_VANILLA), Collections.emptyList());
    public static final Tags BOOKSHELF_CUPBOARD_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "bookshelf_cupboard"), Tags.formatTag("minecraft", MINEABLE_AXE), ENCHANTMENT_POWER_PROVIDER_FURNITURE, ENCHANTMENT_POWER_PROVIDER_VANILLA), Collections.emptyList());
    public static final Tags DRAWER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "drawer"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags DOUBLE_DRAWER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "double_drawer"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags BOOKSHELF_DRAWER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "bookshelf_drawer"), Tags.formatTag("minecraft", MINEABLE_AXE), ENCHANTMENT_POWER_PROVIDER_FURNITURE, ENCHANTMENT_POWER_PROVIDER_VANILLA), Collections.emptyList());
    public static final Tags LOWER_BOOKSHELF_DRAWER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "lower_bookshelf_drawer"), Tags.formatTag("minecraft", MINEABLE_AXE), ENCHANTMENT_POWER_PROVIDER_FURNITURE, ENCHANTMENT_POWER_PROVIDER_VANILLA), Collections.emptyList());
    public static final Tags LARGE_DRAWER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "large_drawer"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags LOWER_TRIPLE_DRAWER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "lower_triple_drawer"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags TRIPLE_DRAWER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "triple_drawer"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags DESK_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "desk"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags COVERED_DESK_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "covered_desk"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags MODERN_DESK_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "modern_desk"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags TABLE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "table"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags END_TABLE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "end_table"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags COFFEE_TABLE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "coffee_table"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags GLASS_TABLE_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "glass_table"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags CHAIR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "chair"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags MODERN_CHAIR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "modern_chair"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags STRIPED_CHAIR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "striped_chair"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags STOOL_CHAIR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "stool_chair"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags COUNTER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "counter"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags DRAWER_COUNTER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "double_drawer_counter"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags DOUBLE_DRAWER_COUNTER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "double_drawer_counter"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags CUPBOARD_COUNTER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "cupboard_counter"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags KITCHEN_CABINET_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "cabinet"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags DOUBLE_KITCHEN_CABINET_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "cabinet"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags GLASS_KITCHEN_CABINET_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "cabinet"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags KITCHEN_SINK_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.FURNITURES.getModid(), "kitchen_sink"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());

    // Paths Wood Tags
    public static final Tags PLANKS_PATH_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.PATHS.getModid(), "wooden_paths"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());

    // Roofs Wood Tags
    public static final Tags ROOF_WOOD_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags ATTIC_ROOF_WOOD_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags TOP_ROOF_WOOD_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags LOWER_ROOF_WOOD_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags STEEP_ROOF_WOOD_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags UPPER_LOWER_ROOF_WOOD_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags UPPER_STEEP_ROOF_WOOD_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());

    // Roofs Stone Tags
    public static final Tags ROOF_STONE_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags ATTIC_ROOF_STONE_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags TOP_ROOF_STONE_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags LOWER_ROOF_STONE_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags STEEP_ROOF_STONE_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags UPPER_LOWER_ROOF_STONE_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());
    public static final Tags UPPER_STEEP_ROOF_STONE_TAGS = new Tags(
            Collections.singletonList(Tags.formatTag("minecraft", MINEABLE_PICKAXE)), Collections.emptyList());

    // Stairs Wood Tags
    public static final Tags TERRACE_STAIRS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "terrace_stairs"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags SKYLINE_STAIRS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "skyline_stairs"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags COMPACT_STAIRS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "compact_stairs"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags BULK_STAIRS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "bulk_stairs"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags LOFT_STAIRS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "loft_stairs"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags RAILING_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "railings"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags BALCONY_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "balconies"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags PLATFORM_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.STAIRS.getModid(), "platforms"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());

        // Trapdoors Wood Tags
        public static final Tags BARN_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "barn_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags COTTAGE_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "cottage_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags BARRED_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "barred_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags BEACH_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "beach_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags FOUR_PANEL_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "four_panel_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags GLASS_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "glass_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags MYSTIC_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "mystic_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags PAPER_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "paper_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags TROPICAL_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "tropical_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags SWAMP_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "swamp_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags BAMBOO_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "bamboo_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags CLASSIC_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "classic_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags BARK_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "bark_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags RANCH_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "ranch_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags WAFFLE_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "waffle_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags BARREL_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "barrel_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));
        public static final Tags WHISPERING_TRAPDOOR_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.TRAPDOORS.getModid(), "whispering_trapdoors"), Tags.formatTag("minecraft", WOODEN_TRAPDOORS), Tags.formatTag("minecraft", MINEABLE_AXE)),
            Collections.singletonList(Tags.formatTag("minecraft", WOODEN_TRAPDOORS)));

    // Windows Wood Tags
    public static final Tags WINDOW_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "windows"), Tags.formatTag("minecraft", WALLS), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags WINDOW2_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "windows_two"), Tags.formatTag("minecraft", WALLS), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags FOUR_WINDOW_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "windows_four"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags LOG_PARAPET_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "parapets"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags PLANK_PARAPET_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "parapets"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags BLINDS_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "blinds"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags SHUTTER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "shutters"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags LOUVERED_SHUTTER_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "shutters"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags PANE_WINDOW_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "windows"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
    public static final Tags CURTAIN_ROD_TAGS = new Tags(
            Arrays.asList(Tags.formatTag(ModType.WINDOWS.getModid(), "curtain_rods"), Tags.formatTag("minecraft", MINEABLE_AXE)), Collections.emptyList());
}