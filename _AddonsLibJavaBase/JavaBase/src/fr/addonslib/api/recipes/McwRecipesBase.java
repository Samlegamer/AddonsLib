package fr.addonslib.api.recipes;

import fr.addonslib.api.data.ModType;

public final class McwRecipesBase
{
    private McwRecipesBase() {}

    // ================ COMMON INGREDIENTS ================
    // Wood elements
    public static final String LOG = "log";
    public static final String PLANKS = "planks";
    public static final String SLAB = "slab";
    public static final String FENCE = "fence";
    public static final String STRIPPED_LOG = "strippedLog";
    public static final String TRAPDOOR = "trapdoor";

    // Stone elements
    public static final String STONE_BASE = "stoneBase";
    public static final String STONE_SLAB = "stoneSlab";
    public static final String STONE_WALL = "stoneWall";
    public static final String SMOOTH_STONE = "smoothStone";

    // Other elements
    public static final String LEAVE = "leave";

    // Vanilla elements
    public static final String STICK = "minecraft:stick";
    public static final String STRING = "minecraft:string";
    public static final String GLASS = "minecraft:glass";
    public static final String GLASS_PANE = "minecraft:glass_pane";
    public static final String PAPER = "minecraft:paper";
    public static final String BOOK = "minecraft:book";
    public static final String BARREL = "minecraft:barrel";
    public static final String WATER_BUCKET = "minecraft:water_bucket";
    public static final String CAULDRON = "minecraft:cauldron";
    public static final String IRON_BARS = "minecraft:iron_bars";

    public static final String DIRT = "minecraft:dirt";

    // MCW custom elements
    public static final String CABINET_DOOR = "mcwfurnitures:cabinet_door";
    public static final String CABINET_DRAWER = "mcwfurnitures:cabinet_drawer";
    public static final String WINDOW_BASE = "mcwwindows:window_base";
    public static final String WINDOW_HALF_BAR_BASE = "mcwwindows:window_half_bar_base";
    public static final String WINDOW_CENTRE_BAR_BASE = "mcwwindows:window_centre_bar_base";

    public static final String RECIPE_SHAPED_WITH_1_ITEM = "recipeShapedWith1Item";
    public static final String RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE = "recipeShapelessWith1ItemRecycle";
    public static final String RECIPE_SHAPELESS_WITH_1_ITEM = "recipeShapelessWith1Item";
    public static final String RECIPE_SHAPED_WITH_2_ITEMS = "recipeShapedWith2Items";
    public static final String RECIPE_SHAPED_WITH_3_ITEMS = "recipeShapedWith3Items";
    public static final String RECIPE_SHAPED_WITH_4_ITEMS = "recipeShapedWith4Items";
    public static final String RECIPE_STONECUTTER = "recipeStonecutter";

    // ================ BRIDGES ================
    public static final RecipesBase LOG_BRIDGE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"B B", "AAA"},
        LOG, 4, "log_bridges",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase ROPE_BRIDGE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"B B", "AAA"},
        LOG, 4, "rope_bridges",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', STRING)
    );

    public static final RecipesBase RAIL_BRIDGE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"B B", "BAB"},
        LOG, 4, "rail_bridges",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase PIER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA"},
        LOG, 3, "wooden_piers",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase LOG_BRIDGE_STAIR = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
        new String[]{"  A", " AA", "AAA"},
        LOG, 6, "log_stairs",
        new CraftingIngredient('A', "log_bridge")
    );

    public static final RecipesBase LOG_BRIDGE_STAIR_RECYCLE = new RecipesBase(RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE,
        new String[]{},
        LOG, 1, "recyclable_bridges_recycle",
        new CraftingIngredient('A', "log_bridge_stair")
    );

    public static final RecipesBase ROPE_BRIDGE_STAIR = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
        new String[]{"  A", " AA", "AAA"},
        LOG, 6, "rope_stairs",
        new CraftingIngredient('A', "rope_bridge")
    );

    public static final RecipesBase ROPE_BRIDGE_STAIR_RECYCLE = new RecipesBase(RECIPE_SHAPELESS_WITH_1_ITEM_RECYCLE,
        new String[]{},
        LOG, 1, "recyclable_bridges_recycle",
        new CraftingIngredient('A', "rope_bridge_stair")
    );

    public static final RecipesBase STONE_BRIDGE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"B B", "AAA"},
        STONE_BASE, 4, "stone_bridges",
        new CraftingIngredient('A', STONE_SLAB),
        new CraftingIngredient('B', STONE_WALL)
    );

    public static final RecipesBase STONE_PIER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA"},
        STONE_BASE, 3, "stone_piers",
        new CraftingIngredient('A', STONE_BASE),
        new CraftingIngredient('B', STONE_WALL)
    );

    public static final RecipesBase STONE_BRIDGE_STAIR = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
        new String[]{"  A", " AA", "AAA"},
        STONE_BASE, 6, "stone_stairs",
        new CraftingIngredient('A', "stone_bridge")
    );

    public static final RecipesBase BALUSTRADE_BRIDGE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"BBB", "AAA"},
        STONE_BASE, 5, "balustrade_bridges",
        new CraftingIngredient('A', STONE_SLAB),
        new CraftingIngredient('B', STONE_WALL)
    );

    // ================ DOORS ================
    public static final RecipesBase WESTERN_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"  A", "ABA", "AAA"},
        PLANKS, 3, "western",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', SLAB)
    );

    public static final RecipesBase STABLE_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"BB", "AA", "AA"},
        PLANKS, 3, "stable",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', IRON_BARS)
    );

    public static final RecipesBase STABLE_HEAD_DOOR = new RecipesBase(RECIPE_SHAPELESS_WITH_1_ITEM,
        new String[]{},
        PLANKS, 1, "stable_head",
        new CraftingIngredient('A', "stable_door")
    );

    public static final RecipesBase MODERN_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AB", "AA", "AB"},
        PLANKS, 3, "modern",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase JAPANESE_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"BB", "BB", "AA"},
        PLANKS, 3, "shoji",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', PAPER)
    );

    public static final RecipesBase JAPANESE2_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"BB", "BB", "AA"},
        SLAB, 3, "shoji_two",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', PAPER)
    );

    public static final RecipesBase BARK_GLASS_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AB", "BB", "AB"},
        LOG, 3, "bark",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', GLASS)
    );

    public static final RecipesBase GLASS_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AB", "BB", "AB"},
        PLANKS, 3, "glassed",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase BARN_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"BB", "AA", "AA"},
        PLANKS, 2, "barn",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase BARN_GLASS_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"BB", "AA", "AA"},
        PLANKS, 3, "barn_glass",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    // Door Variants (using print items)
    public static final RecipesBase BAMBOO_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "bamboo",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_bamboo")
    );

    public static final RecipesBase BEACH_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "beach",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_jungle")
    );

    public static final RecipesBase CLASSIC_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "classic",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_oak")
    );

    public static final RecipesBase COTTAGE_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "cottage",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_spruce")
    );

    public static final RecipesBase FOUR_PANEL_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "four_panel",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_dark_oak")
    );

    public static final RecipesBase MYSTIC_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "mystic",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_mystic")
    );

    public static final RecipesBase NETHER_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "nether",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_nether")
    );

    public static final RecipesBase PAPER_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "paper",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_birch")
    );

    public static final RecipesBase SWAMP_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "swamp",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_swamp")
    );

    public static final RecipesBase TROPICAL_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "tropical",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_acacia")
    );

    public static final RecipesBase WAFFLE_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "waffle",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_waffle")
    );

    public static final RecipesBase WHISPERING_DOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "whispering",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.DOORS.getModid() + ":print_whispering")
    );

    // ================ FENCES ================
    public static final RecipesBase CURVED_GATE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"B A", "BAA"},
        PLANKS, 4, "curved_gate",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase HIGHLEY_GATE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "ABA"},
        PLANKS, 1, "highley",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase HORSE_FENCE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "BAB"},
        PLANKS, 3, "horse",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PICKET_FENCE = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
        new String[]{"CBC", "CAC"},
        PLANKS, 3, "picket",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', PLANKS),
        new CraftingIngredient('C', LOG)
    );

    public static final RecipesBase PYRAMID_GATE = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
        new String[]{"ABA", "ACA"},
        PLANKS, 1, "pyramid",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG),
        new CraftingIngredient('C', PLANKS)
    );

    public static final RecipesBase STOCKADE_FENCE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "BAB"},
        PLANKS, 3, "stockade",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase WIRED_FENCE = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
        new String[]{"ACA", "ABA"},
        PLANKS, 3, "wired",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG),
        new CraftingIngredient('C', IRON_BARS)
    );

    public static final RecipesBase HEDGE = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
        new String[]{"AA", "AA"},
        LEAVE, 4, "hedge",
        new CraftingIngredient('A', LEAVE)
    );

    public static final RecipesBase MODERN_WALL = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "AAA"},
        STONE_BASE, 6, "modern",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', STONE_BASE)
    );

    public static final RecipesBase MODERN_WALL_STONECUTTER = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "modern_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase RAILING_WALL = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "AAA"},
        STONE_BASE, 6, "railing_wall",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', IRON_BARS)
    );

    public static final RecipesBase RAILING_WALL_STONECUTTER = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "railing_wall_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase GRASS_TOPPED_WALL = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
        new String[]{"BCB", "AAA"},
        STONE_BASE, 6, "grass_topped",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', STONE_BASE),
        new CraftingIngredient('C', DIRT)
    );

    public static final RecipesBase PILLAR_WALL = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "B B"},
        STONE_BASE, 5, "pillarwall",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', STONE_BASE)
    );

    public static final RecipesBase RAILING_GATE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "ABA"},
        STONE_BASE, 1, "railing_gate",
        new CraftingIngredient('A', IRON_BARS),
        new CraftingIngredient('B', STONE_BASE)
    );

    public static final RecipesBase RAILING_GATE_STONECUTTER = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "railing_gate_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    // ================ ROOFS ================
    public static final RecipesBase ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", "AB"},
        LOG, 2, "roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase ATTIC_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", "AB"},
        LOG, 2, "attic_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', GLASS)
    );

    public static final RecipesBase TOP_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA"},
        LOG, 2, "top_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase LOWER_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" AA", "AAB"},
        LOG, 4, "lower_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase STEEP_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", "AA", "AB"},
        LOG, 4, "steep_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase UPPER_LOWER_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"  A", "AAB"},
        LOG, 3, "upper_lower_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase UPPER_STEEP_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", " A", "AB"},
        LOG, 3, "upper_steep_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", "AB"},
        PLANKS, 2, "planks_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_ATTIC_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", "AB"},
        PLANKS, 2, "planks_attic_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS)
    );

    public static final RecipesBase PLANKS_TOP_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA"},
        PLANKS, 2, "planks_top_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_LOWER_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" AA", "AAB"},
        PLANKS, 4, "planks_lower_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_STEEP_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", "AA", "AB"},
        PLANKS, 4, "planks_steep_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_UPPER_LOWER_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"  A", "AAB"},
        PLANKS, 3, "planks_upper_lower_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_UPPER_STEEP_ROOF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A", " A", "AB"},
        PLANKS, 3, "planks_upper_steep_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase STONE_ROOF = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "stone_roof_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase STONE_ATTIC_ROOF = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "stone_attic_roof_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase STONE_TOP_ROOF = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "stone_top_roof_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase STONE_LOWER_ROOF = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "stone_lower_roof_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase STONE_STEEP_ROOF = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "stone_steep_roof_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase STONE_UPPER_LOWER_ROOF = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "stone_upper_lower_roof_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    public static final RecipesBase STONE_UPPER_STEEP_ROOF = new RecipesBase(RECIPE_STONECUTTER,
        new String[]{},
        STONE_BASE, 1, "stone_upper_steep_roof_stonecutter",
        new CraftingIngredient('A', STONE_BASE)
    );

    // ================ STAIRS ================
    public static final RecipesBase BALCONY = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "B B", "AAA"},
        LOG, 6, "mcwstairs_balcony",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase PLATFORM = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" BB", " AA", "   "},
        LOG, 12, "mcwstairs_platform",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', SLAB)
    );

    public static final RecipesBase COMPACT_STAIRS = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
        new String[]{"A  ", "AA ", "AAA"},
        LOG, 6, "compact_stairs",
        new CraftingIngredient('A', STRIPPED_LOG)
    );

    public static final RecipesBase BULK_STAIRS = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A  ", "BA ", "BBA"},
        LOG, 6, "bulk_stairs",
        new CraftingIngredient('A', STRIPPED_LOG),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase LOFT_STAIRS = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
        new String[]{"A  ", " A ", "  A"},
        LOG, 3, "loft_stairs",
        new CraftingIngredient('A', STRIPPED_LOG)
    );

    public static final RecipesBase SKYLINE_STAIRS = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A  ", "BA "},
        LOG, 4, "skyline_stairs",
        new CraftingIngredient('A', STRIPPED_LOG),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase TERRACE_STAIRS = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A  ", "BA ", " BA"},
        LOG, 5, "terrace_stairs",
        new CraftingIngredient('A', STRIPPED_LOG),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase RAILING = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
        new String[]{"A  ", "AA ", "AAA"},
        LOG, 6, "mcwstairs_railing",
        new CraftingIngredient('A', "balcony")
    );

    // ================ TRAPDOORS ================
    public static final RecipesBase RANCH_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "BBB", "ABA"},
        LOG, 2, "ranch_trapdoors",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase BARK_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "ABA"},
        LOG, 2, "bark_trapdoors",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase GLASS_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA", "ABA"},
        PLANKS, 2, "glass_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase BARN_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B"},
        PLANKS, 1, "barn_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', "glass_trapdoor")
    );

    public static final RecipesBase BARREL_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A ", "ABA", " A "},
        PLANKS, 4, "barrel_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', BARREL)
    );

    // Trapdoor Variants (using print items)
    public static final RecipesBase BAMBOO_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "bamboo_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_bamboo")
    );

    public static final RecipesBase BARRED_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "barred_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_barred")
    );

    public static final RecipesBase BEACH_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "beach_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_beach")
    );

    public static final RecipesBase BLOSSOM_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "blossom_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_blossom")
    );

    public static final RecipesBase CLASSIC_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "classic_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_classic")
    );

    public static final RecipesBase COTTAGE_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "cottage_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_cottage")
    );

    public static final RecipesBase FOUR_PANEL_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "four_panel_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_four_panel")
    );

    public static final RecipesBase MYSTIC_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "mystic_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_mystic")
    );

    public static final RecipesBase PAPER_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "paper_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_paper")
    );

    public static final RecipesBase SWAMP_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "swamp_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_swamp")
    );

    public static final RecipesBase TROPICAL_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "tropical_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_tropical")
    );

    public static final RecipesBase WHISPERING_TRAPDOOR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"A", "B", "A"},
        PLANKS, 1, "whispering_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', ModType.TRAPDOORS.getModid() + ":print_whispering")
    );

    // ================ WINDOWS ================
    public static final RecipesBase CURTAIN_ROD = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"ABA"},
        LOG, 5, "curtain_rods",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase SHUTTER = new RecipesBase(RECIPE_SHAPELESS_WITH_1_ITEM,
        new String[]{},
        LOG, 3, "shutters",
        new CraftingIngredient('A', TRAPDOOR, 3)
    );

    public static final RecipesBase LOUVERED_SHUTTER = new RecipesBase(RECIPE_SHAPELESS_WITH_1_ITEM,
        new String[]{},
        LOG, 3, "shutters",
        new CraftingIngredient('A', SLAB, 3)
    );

    public static final RecipesBase LOG_PARAPET = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA"},
        LOG, 5, "parapets",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_PARAPET = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA"},
        LOG, 5, "parapets",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase BLINDS = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "BBB", "BBB"},
        LOG, 3, "blinds",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A ", "ABA", " A "},
        LOG, 4, "windows",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A ", "ABA", " A "},
        LOG, 4, "windows",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase WINDOW2 = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_two",
        new CraftingIngredient('A', WINDOW_HALF_BAR_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_WINDOW2 = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_two",
        new CraftingIngredient('A', WINDOW_HALF_BAR_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase PANE_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_pane",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_PANE_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_pane",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase FOUR_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_four",
        new CraftingIngredient('A', WINDOW_CENTRE_BAR_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_FOUR_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_four",
        new CraftingIngredient('A', WINDOW_CENTRE_BAR_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase STRIPPED_LOG_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{" A ", "ABA", " A "},
        LOG, 4, "windows",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase STRIPPED_PANE_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_pane",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase STRIPPED_LOG_WINDOW2 = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_two",
        new CraftingIngredient('A', WINDOW_HALF_BAR_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase STRIPPED_LOG_FOUR_WINDOW = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_four",
        new CraftingIngredient('A', WINDOW_CENTRE_BAR_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    // ================ PATHS ================
    public static final RecipesBase PLANKS_PATH = new RecipesBase(RECIPE_SHAPELESS_WITH_1_ITEM,
        new String[]{},
        PLANKS, 3, "planks_paths",
        new CraftingIngredient('A', SLAB)
    );

    // ================ FURNITURES ================
    // Chairs
    public static final RecipesBase CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{" A", "BA", "CC"},
            LOG, 1, "chairs",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', SLAB),
            new CraftingIngredient('C', FENCE)
    );

    public static final RecipesBase STRIPPED_CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{" A", "BA", "CC"},
            STRIPPED_LOG, 1, "stripped_chairs",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', SLAB),
            new CraftingIngredient('C', FENCE)
    );

    public static final RecipesBase MODERN_CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"BA", "CC"},
            LOG, 1, "modern_chairs",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', SLAB),
            new CraftingIngredient('C', FENCE)
    );

    public static final RecipesBase STRIPPED_MODERN_CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"BA", "CC"},
            STRIPPED_LOG, 1, "stripped_modern_chairs",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', SLAB),
            new CraftingIngredient('C', FENCE)
    );

    public static final RecipesBase STRIPED_CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{" A", "BC", "CC"},
            LOG, 1, "striped_chairs",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', SLAB),
            new CraftingIngredient('C', FENCE)
    );

    public static final RecipesBase STRIPPED_STRIPED_CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{" A", "BC", "CC"},
            STRIPPED_LOG, 1, "stripped_striped_chairs",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', SLAB),
            new CraftingIngredient('C', FENCE)
    );

    public static final RecipesBase STOOL_CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "A", "B"},
            LOG, 1, "stool_chairs",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase STRIPPED_STOOL_CHAIR = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "A", "B"},
            STRIPPED_LOG, 1, "stripped_stool_chairs",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', FENCE)
    );

    // Tables
    public static final RecipesBase COFFEE_TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "coffee_tables",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase STRIPPED_COFFEE_TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_coffee_tables",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "tables",
            new CraftingIngredient('A', "coffee_table"),
            new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase STRIPPED_TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_tables",
            new CraftingIngredient('A', "stripped_coffee_table"),
            new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase END_TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "end_tables",
            new CraftingIngredient('A', "table"),
            new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase STRIPPED_END_TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_end_tables",
            new CraftingIngredient('A', "stripped_table"),
            new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase GLASS_TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "glass_tables",
            new CraftingIngredient('A', "end_table"),
            new CraftingIngredient('B', GLASS)
    );

    public static final RecipesBase STRIPPED_GLASS_TABLE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_glass_tables",
            new CraftingIngredient('A', "stripped_end_table"),
            new CraftingIngredient('B', GLASS)
    );

    // Desks
    public static final RecipesBase COVERED_DESK = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
            new String[]{"AAA", "A A"},
            LOG, 2, "covered_desks",
            new CraftingIngredient('A', LOG)
    );

    public static final RecipesBase STRIPPED_COVERED_DESK = new RecipesBase(RECIPE_SHAPED_WITH_1_ITEM,
            new String[]{"AAA", "A A"},
            STRIPPED_LOG, 2, "stripped_covered_desks",
            new CraftingIngredient('A', STRIPPED_LOG)
    );

    public static final RecipesBase MODERN_DESK = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "BCB"},
            LOG, 2, "modern_desks",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', FENCE),
            new CraftingIngredient('C', STICK)
    );

    public static final RecipesBase STRIPPED_MODERN_DESK = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "BCB"},
            STRIPPED_LOG, 2, "stripped_modern_desks",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', FENCE),
            new CraftingIngredient('C', STICK)
    );

    public static final RecipesBase DESK = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "B B"},
            LOG, 2, "desks",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase STRIPPED_DESK = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "B B"},
            STRIPPED_LOG, 2, "stripped_desks",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', FENCE)
    );

    // Bookshelves
    public static final RecipesBase BOOKSHELF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "BBB", "AAA"},
            LOG, 4, "bookshelves",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', BOOK)
    );

    public static final RecipesBase STRIPPED_BOOKSHELF = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "BBB", "AAA"},
            STRIPPED_LOG, 4, "stripped_bookshelves",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', BOOK)
    );

    // Drawer
    public static final RecipesBase DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "AAA"},
            LOG, 4, "drawers",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    public static final RecipesBase STRIPPED_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "AAA"},
            STRIPPED_LOG, 4, "stripped_drawers",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    // Double Drawer
    public static final RecipesBase DOUBLE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "ABA"},
            LOG, 4, "double_drawers",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    public static final RecipesBase STRIPPED_DOUBLE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "ABA"},
            STRIPPED_LOG, 4, "stripped_double_drawers",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    // Bookshelf Drawer
    public static final RecipesBase BOOKSHELF_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "ABA", "ACA"},
            LOG, 4, "bookshelf_drawers",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DRAWER),
            new CraftingIngredient('C', BOOK)
    );

    public static final RecipesBase STRIPPED_BOOKSHELF_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "ABA", "ACA"},
            STRIPPED_LOG, 4, "stripped_bookshelf_drawers",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DRAWER),
            new CraftingIngredient('C', BOOK)
    );

    // Lower Bookshelf Drawer
    public static final RecipesBase LOWER_BOOKSHELF_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "ACA", "ABA"},
            LOG, 4, "lower_bookshelf_drawers",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DRAWER),
            new CraftingIngredient('C', BOOK)
    );

    public static final RecipesBase STRIPPED_LOWER_BOOKSHELF_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "ACA", "ABA"},
            STRIPPED_LOG, 4, "stripped_lower_bookshelf_drawers",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DRAWER),
            new CraftingIngredient('C', BOOK)
    );

    // Triple Drawer
    public static final RecipesBase TRIPLE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "BAB"},
            LOG, 4, "triple_drawers",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    public static final RecipesBase STRIPPED_TRIPLE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "BAB"},
            STRIPPED_LOG, 4, "stripped_triple_drawers",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    // Large Drawer
    public static final RecipesBase LARGE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"ABA", "AAA", "AAA"},
            LOG, 4, "large_drawers",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    public static final RecipesBase STRIPPED_LARGE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"ABA", "AAA", "AAA"},
            STRIPPED_LOG, 4, "stripped_large_drawers",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    // Lower Triple Drawer
    public static final RecipesBase LOWER_TRIPLE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "BAB", "ABA"},
            LOG, 4, "lower_triple_drawers",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    public static final RecipesBase STRIPPED_LOWER_TRIPLE_DRAWER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "BAB", "ABA"},
            STRIPPED_LOG, 4, "stripped_lower_triple_drawers",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DRAWER)
    );

    // Wardrobe
    public static final RecipesBase WARDROBE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "AAA"},
            LOG, 4, "wardrobes",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    public static final RecipesBase STRIPPED_WARDROBE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "ABA", "AAA"},
            STRIPPED_LOG, 4, "stripped_wardrobes",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    // Modern Wardrobe
    public static final RecipesBase MODERN_WARDROBE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "AAB", "AAA"},
            LOG, 4, "modern_wardrobes",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    public static final RecipesBase STRIPPED_MODERN_WARDROBE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "AAB", "AAA"},
            STRIPPED_LOG, 4, "stripped_modern_wardrobes",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    // Double Wardrobe
    public static final RecipesBase DOUBLE_WARDROBE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "BAB", "AAA"},
            LOG, 4, "double_wardrobes",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    public static final RecipesBase STRIPPED_DOUBLE_WARDROBE = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AAA", "BAB", "AAA"},
            STRIPPED_LOG, 4, "stripped_double_wardrobes",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    // Bookshelf Cupboard
    public static final RecipesBase BOOKSHELF_CUPBOARD = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "BAC", "AAA"},
            LOG, 4, "bookshelf_cupboards",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DOOR),
            new CraftingIngredient('C', BOOK)
    );

    public static final RecipesBase STRIPPED_BOOKSHELF_CUPBOARD = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AAA", "BAC", "AAA"},
            STRIPPED_LOG, 4, "stripped_bookshelf_cupboards",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DOOR),
            new CraftingIngredient('C', BOOK)
    );

    // Kitchen Cabinets
    public static final RecipesBase KITCHEN_CABINET = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AA", "AB", "AA"},
            LOG, 4, "kitchen_cabinets",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    public static final RecipesBase STRIPPED_KITCHEN_CABINET = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AA", "AB", "AA"},
            STRIPPED_LOG, 4, "stripped_kitchen_cabinets",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    public static final RecipesBase DOUBLE_KITCHEN_CABINET = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AA", "BB", "AA"},
            LOG, 4, "double_kitchen_cabinets",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    public static final RecipesBase STRIPPED_DOUBLE_KITCHEN_CABINET = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"AA", "BB", "AA"},
            STRIPPED_LOG, 4, "stripped_double_kitchen_cabinets",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', CABINET_DOOR)
    );

    public static final RecipesBase GLASS_KITCHEN_CABINET = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AA", "BC", "AA"},
            LOG, 4, "glass_kitchen_cabinets",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', GLASS),
            new CraftingIngredient('C', CABINET_DOOR)
    );

    public static final RecipesBase STRIPPED_GLASS_KITCHEN_CABINET = new RecipesBase(RECIPE_SHAPED_WITH_3_ITEMS,
            new String[]{"AA", "BC", "AA"},
            STRIPPED_LOG, 4, "stripped_glass_kitchen_cabinets",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', GLASS),
            new CraftingIngredient('C', CABINET_DOOR)
    );

    // Counters
    public static final RecipesBase COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase STRIPPED_COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase DRAWER_COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "drawer_counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', "drawer")
    );

    public static final RecipesBase STRIPPED_DRAWER_COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_drawer_counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', "stripped_drawer")
    );

    public static final RecipesBase DOUBLE_DRAWER_COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "double_drawer_counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', "double_drawer")
    );

    public static final RecipesBase STRIPPED_DOUBLE_DRAWER_COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_double_drawer_counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', "stripped_double_drawer")
    );

    public static final RecipesBase CUPBOARD_COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            LOG, 1, "cupboard_counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', "wardrobe")
    );

    public static final RecipesBase STRIPPED_CUPBOARD_COUNTER = new RecipesBase(RECIPE_SHAPED_WITH_2_ITEMS,
            new String[]{"A", "B"},
            STRIPPED_LOG, 1, "stripped_cupboard_counters",
            new CraftingIngredient('A', SLAB),
            new CraftingIngredient('B', "stripped_wardrobe")
    );

    // Kitchen Sink (Furniture 3.4.0)
    public static final RecipesBase KITCHEN_SINK = new RecipesBase(RECIPE_SHAPED_WITH_4_ITEMS,
            new String[]{"CDC", "ABA", "ABA"},
            LOG, 1, "kitchen_sinks",
            new CraftingIngredient('A', LOG),
            new CraftingIngredient('B', WATER_BUCKET),
            new CraftingIngredient('C', SLAB),
            new CraftingIngredient('D', CAULDRON)
    );

    public static final RecipesBase STRIPPED_KITCHEN_SINK = new RecipesBase(RECIPE_SHAPED_WITH_4_ITEMS,
            new String[]{"CDC", "ABA", "ABA"},
            STRIPPED_LOG, 1, "stripped_kitchen_sinks",
            new CraftingIngredient('A', STRIPPED_LOG),
            new CraftingIngredient('B', WATER_BUCKET),
            new CraftingIngredient('C', SLAB),
            new CraftingIngredient('D', CAULDRON)
    );
}

