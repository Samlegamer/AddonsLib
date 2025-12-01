package fr.addonslib.api.recipes;

public final class McwRecipesBase
{
    private McwRecipesBase() {}

    // ================ COMMON INGREDIENTS ================
    // Wood elements
    private static final String LOG = "log";
    private static final String PLANKS = "planks";
    private static final String SLAB = "slab";
    private static final String FENCE = "fence";
    private static final String STRIPPED_LOG = "strippedLog";

    // Stone elements
    private static final String STONE_BASE = "stoneBase";
    private static final String STONE_SLAB = "stoneSlab";
    private static final String STONE_WALL = "stoneWall";
    private static final String SMOOTH_STONE = "smoothStone";

    // Other elements
    private static final String LEAVE = "leave";

    // Vanilla elements
    private static final String STICK = "minecraft:stick";
    private static final String STRING = "minecraft:string";
    private static final String GLASS = "minecraft:glass";
    private static final String GLASS_PANE = "minecraft:glass_pane";
    private static final String PAPER = "minecraft:paper";
    private static final String BOOK = "minecraft:book";
    private static final String IRON_BARS = "minecraft:iron_bars";
    private static final String DIRT = "minecraft:dirt";
    private static final String BARREL = "minecraft:barrel";
    private static final String WATER_BUCKET = "minecraft:water_bucket";
    private static final String CAULDRON = "minecraft:cauldron";

    // MCW custom elements
    private static final String CABINET_DOOR = "cabinetDoor";
    private static final String CABINET_DRAWER = "cabinetDrawer";
    private static final String WINDOW_BASE = "windowBase";
    private static final String WINDOW_HALF_BAR_BASE = "windowHalfBarBase";
    private static final String WINDOW_CENTRE_BAR_BASE = "windowCentreBarBase";

    // ================ BRIDGES ================
    public static final RecipesBase LOG_BRIDGE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"B B", "AAA"},
        LOG, 4, "log_bridges",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase ROPE_BRIDGE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"B B", "AAA"},
        LOG, 4, "rope_bridges",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', STRING)
    );

    public static final RecipesBase RAIL_BRIDGE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"B B", "BAB"},
        LOG, 4, "rail_bridges",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase PIER = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA"},
        LOG, 3, "wooden_piers",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase LOG_BRIDGE_STAIR = new RecipesBase("recipeShapedWith1Item",
        new String[]{"  A", " AA", "AAA"},
        LOG, 6, "log_stairs",
        new CraftingIngredient('A', "log_bridge")
    );

    public static final RecipesBase LOG_BRIDGE_STAIR_RECYCLE = new RecipesBase("recipeShapelessWith1ItemRecycle",
        new String[]{},
        LOG, 1, "recyclable_bridges_recycle",
        new CraftingIngredient('A', "log_bridge")
    );

    public static final RecipesBase ROPE_BRIDGE_STAIR = new RecipesBase("recipeShapedWith1Item",
        new String[]{"  A", " AA", "AAA"},
        LOG, 6, "rope_stairs",
        new CraftingIngredient('A', "rope_bridge")
    );

    public static final RecipesBase ROPE_BRIDGE_STAIR_RECYCLE = new RecipesBase("recipeShapelessWith1ItemRecycle",
        new String[]{},
        LOG, 1, "recyclable_bridges_recycle",
        new CraftingIngredient('A', "rope_bridge")
    );

    public static final RecipesBase STONE_BRIDGE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"B B", "AAA"},
        STONE_BASE, 4, "stone_bridges",
        new CraftingIngredient('A', STONE_SLAB),
        new CraftingIngredient('B', STONE_WALL)
    );

    public static final RecipesBase STONE_PIER = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA"},
        STONE_BASE, 3, "stone_piers",
        new CraftingIngredient('A', STONE_BASE),
        new CraftingIngredient('B', STONE_WALL)
    );

    public static final RecipesBase STONE_BRIDGE_STAIR = new RecipesBase("recipeShapedWith1Item",
        new String[]{"  A", " AA", "AAA"},
        STONE_BASE, 6, "stone_stairs",
        new CraftingIngredient('A', "stone_bridge")
    );

    public static final RecipesBase BALUSTRADE_BRIDGE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"BBB", "AAA"},
        STONE_BASE, 5, "balustrade_bridges",
        new CraftingIngredient('A', STONE_SLAB),
        new CraftingIngredient('B', STONE_WALL)
    );

    // ================ DOORS ================
    public static final RecipesBase WESTERN_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"  A", "ABA", "AAA"},
        PLANKS, 3, "western",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', SLAB)
    );

    public static final RecipesBase STABLE_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"BB", "AA", "AA"},
        PLANKS, 3, "stable",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', IRON_BARS)
    );

    public static final RecipesBase STABLE_HEAD_DOOR = new RecipesBase("recipeShapelessWith1Item",
        new String[]{},
        PLANKS, 1, "stable_head",
        new CraftingIngredient('A', "stable_door")
    );

    public static final RecipesBase MODERN_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AB", "AA", "AB"},
        PLANKS, 3, "modern",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase JAPANESE_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"BB", "BB", "AA"},
        PLANKS, 3, "shoji",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', PAPER)
    );

    public static final RecipesBase JAPANESE2_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"BB", "BB", "AA"},
        SLAB, 3, "shoji_two",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', PAPER)
    );

    public static final RecipesBase BARK_GLASS_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AB", "BB", "AB"},
        LOG, 3, "bark",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', GLASS)
    );

    public static final RecipesBase GLASS_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AB", "BB", "AB"},
        PLANKS, 3, "glassed",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase BARN_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"BB", "AA", "AA"},
        PLANKS, 2, "barn",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase BARN_GLASS_DOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"BB", "AA", "AA"},
        PLANKS, 3, "barn_glass",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    // ================ FENCES ================
    public static final RecipesBase CURVED_GATE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"B A", "BAA"},
        PLANKS, 4, "curved_gate",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase HIGHLEY_GATE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "ABA"},
        PLANKS, 1, "highley",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase HORSE_FENCE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "BAB"},
        PLANKS, 3, "horse",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PICKET_FENCE = new RecipesBase("recipeShapedWith3Items",
        new String[]{"CBC", "CAC"},
        PLANKS, 3, "picket",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', PLANKS),
        new CraftingIngredient('C', LOG)
    );

    public static final RecipesBase PYRAMID_GATE = new RecipesBase("recipeShapedWith3Items",
        new String[]{"ABA", "ACA"},
        PLANKS, 1, "pyramid",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG),
        new CraftingIngredient('C', PLANKS)
    );

    public static final RecipesBase STOCKADE_FENCE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "BAB"},
        PLANKS, 3, "stockade",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase WIRED_FENCE = new RecipesBase("recipeShapedWith3Items",
        new String[]{"ACA", "ABA"},
        PLANKS, 3, "wired",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG),
        new CraftingIngredient('C', IRON_BARS)
    );

    public static final RecipesBase HEDGE = new RecipesBase("recipeShapedWith1Item",
        new String[]{"AA", "AA"},
        LEAVE, 4, "hedge",
        new CraftingIngredient('A', LEAVE)
    );

    public static final RecipesBase MODERN_WALL = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "AAA"},
        STONE_BASE, 6, "modern",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', STONE_BASE)
    );

    public static final RecipesBase MODERN_WALL_STONECUTTER = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "modern_stonecutter",
        new CraftingIngredient('A', "modern_wall")
    );

    public static final RecipesBase RAILING_WALL = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "AAA"},
        STONE_BASE, 6, "railing_wall",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', IRON_BARS)
    );

    public static final RecipesBase RAILING_WALL_STONECUTTER = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "railing_wall_stonecutter",
        new CraftingIngredient('A', "railing_wall")
    );

    public static final RecipesBase GRASS_TOPPED_WALL = new RecipesBase("recipeShapedWith3Items",
        new String[]{"BCB", "AAA"},
        STONE_BASE, 6, "grass_topped",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', STONE_BASE),
        new CraftingIngredient('C', DIRT)
    );

    public static final RecipesBase PILLAR_WALL = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "B B"},
        STONE_BASE, 5, "pillarwall",
        new CraftingIngredient('A', SMOOTH_STONE),
        new CraftingIngredient('B', STONE_BASE)
    );

    public static final RecipesBase RAILING_GATE = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "ABA"},
        STONE_BASE, 1, "railing_gate",
        new CraftingIngredient('A', IRON_BARS),
        new CraftingIngredient('B', STONE_BASE)
    );

    public static final RecipesBase RAILING_GATE_STONECUTTER = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "railing_gate_stonecutter",
        new CraftingIngredient('A', "railing_gate")
    );

    // ================ ROOFS ================
    public static final RecipesBase ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", "AB"},
        LOG, 2, "roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase ATTIC_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", "AB"},
        LOG, 2, "attic_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', GLASS)
    );

    public static final RecipesBase TOP_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA"},
        LOG, 2, "top_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase LOWER_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" AA", "AAB"},
        LOG, 4, "lower_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase STEEP_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", "AA", "AB"},
        LOG, 4, "steep_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase UPPER_LOWER_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{"  A", "AAB"},
        LOG, 3, "upper_lower_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase UPPER_STEEP_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", " A", "AB"},
        LOG, 3, "upper_steep_roof",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", "AB"},
        PLANKS, 2, "planks_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_ATTIC_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", "AB"},
        PLANKS, 2, "planks_attic_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS)
    );

    public static final RecipesBase PLANKS_TOP_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA"},
        PLANKS, 2, "planks_top_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_LOWER_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" AA", "AAB"},
        PLANKS, 4, "planks_lower_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_STEEP_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", "AA", "AB"},
        PLANKS, 4, "planks_steep_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_UPPER_LOWER_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{"  A", "AAB"},
        PLANKS, 3, "planks_upper_lower_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase PLANKS_UPPER_STEEP_ROOF = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A", " A", "AB"},
        PLANKS, 3, "planks_upper_steep_roof",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase STONE_ROOF = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "stone_roof_stonecutter",
        new CraftingIngredient('A', "stone_roof")
    );

    public static final RecipesBase STONE_ATTIC_ROOF = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "stone_attic_roof_stonecutter",
        new CraftingIngredient('A', "stone_attic_roof")
    );

    public static final RecipesBase STONE_TOP_ROOF = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "stone_top_roof_stonecutter",
        new CraftingIngredient('A', "stone_top_roof")
    );

    public static final RecipesBase STONE_LOWER_ROOF = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "stone_lower_roof_stonecutter",
        new CraftingIngredient('A', "stone_lower_roof")
    );

    public static final RecipesBase STONE_STEEP_ROOF = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "stone_steep_roof_stonecutter",
        new CraftingIngredient('A', "stone_steep_roof")
    );

    public static final RecipesBase STONE_UPPER_LOWER_ROOF = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "stone_upper_lower_roof_stonecutter",
        new CraftingIngredient('A', "stone_upper_lower_roof")
    );

    public static final RecipesBase STONE_UPPER_STEEP_ROOF = new RecipesBase("recipeStonecut",
        new String[]{},
        STONE_BASE, 1, "stone_upper_steep_roof_stonecutter",
        new CraftingIngredient('A', "stone_upper_steep_roof")
    );

    // ================ STAIRS ================
    public static final RecipesBase BALCONY = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "B B", "AAA"},
        LOG, 6, "mcwstairs_balcony",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', FENCE)
    );

    public static final RecipesBase PLATFORM = new RecipesBase("recipeShapedWith2Items",
        new String[]{" BB", " AA", "   "},
        LOG, 12, "mcwstairs_platform",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', SLAB)
    );

    public static final RecipesBase COMPACT_STAIRS = new RecipesBase("recipeShapedWith1Item",
        new String[]{"A  ", "AA ", "AAA"},
        LOG, 6, "compact_stairs",
        new CraftingIngredient('A', STRIPPED_LOG)
    );

    public static final RecipesBase BULK_STAIRS = new RecipesBase("recipeShapedWith2Items",
        new String[]{"A  ", "BA ", "BBA"},
        LOG, 6, "bulk_stairs",
        new CraftingIngredient('A', STRIPPED_LOG),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase LOFT_STAIRS = new RecipesBase("recipeShapedWith1Item",
        new String[]{"A  ", " A ", "  A"},
        LOG, 3, "loft_stairs",
        new CraftingIngredient('A', STRIPPED_LOG)
    );

    public static final RecipesBase SKYLINE_STAIRS = new RecipesBase("recipeShapedWith2Items",
        new String[]{"A  ", "BA "},
        LOG, 4, "skyline_stairs",
        new CraftingIngredient('A', STRIPPED_LOG),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase TERRACE_STAIRS = new RecipesBase("recipeShapedWith2Items",
        new String[]{"A  ", "BA ", " BA"},
        LOG, 5, "terrace_stairs",
        new CraftingIngredient('A', STRIPPED_LOG),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase RAILING = new RecipesBase("recipeShapedWith1Item",
        new String[]{"A  ", "AA ", "AAA"},
        LOG, 6, "mcwstairs_railing",
        new CraftingIngredient('A', "balcony")
    );

    // ================ TRAPDOORS ================
    public static final RecipesBase RANCH_TRAPDOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "ABA"},
        LOG, 2, "ranch_trapdoors",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase BARK_TRAPDOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "ABA"},
        LOG, 2, "bark_trapdoors",
        new CraftingIngredient('A', LOG),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase GLASS_TRAPDOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA", "ABA"},
        PLANKS, 2, "glass_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', GLASS_PANE)
    );

    public static final RecipesBase BARN_TRAPDOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{"A", "B"},
        PLANKS, 1, "barn_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', "glass_trapdoor")
    );

    public static final RecipesBase BARREL_TRAPDOOR = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A ", "ABA", " A "},
        PLANKS, 4, "barrel_trapdoors",
        new CraftingIngredient('A', PLANKS),
        new CraftingIngredient('B', BARREL)
    );

    // ================ WINDOWS ================
    public static final RecipesBase CURTAIN_ROD = new RecipesBase("recipeShapedWith2Items",
        new String[]{"ABA"},
        LOG, 5, "curtain_rods",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase SHUTTER = new RecipesBase("recipeShapelessWith1Item",
        new String[]{},
        LOG, 3, "shutters",
        new CraftingIngredient('A', "trapdoor")
    );

    public static final RecipesBase LOUVERED_SHUTTER = new RecipesBase("recipeShapelessWith1Item",
        new String[]{},
        LOG, 3, "shutters",
        new CraftingIngredient('A', SLAB)
    );

    public static final RecipesBase LOG_PARAPET = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA"},
        LOG, 5, "parapets",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_PARAPET = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA"},
        LOG, 5, "parapets",
        new CraftingIngredient('A', STICK),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase BLINDS = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "BBB", "BBB"},
        LOG, 3, "blinds",
        new CraftingIngredient('A', SLAB),
        new CraftingIngredient('B', STICK)
    );

    public static final RecipesBase WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A ", "ABA", " A "},
        LOG, 4, "windows",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A ", "ABA", " A "},
        LOG, 4, "windows",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase WINDOW2 = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_two",
        new CraftingIngredient('A', WINDOW_HALF_BAR_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_WINDOW2 = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_two",
        new CraftingIngredient('A', WINDOW_HALF_BAR_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase PANE_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_pane",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_PANE_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_pane",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase FOUR_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_four",
        new CraftingIngredient('A', WINDOW_CENTRE_BAR_BASE),
        new CraftingIngredient('B', LOG)
    );

    public static final RecipesBase PLANK_FOUR_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_four",
        new CraftingIngredient('A', WINDOW_CENTRE_BAR_BASE),
        new CraftingIngredient('B', PLANKS)
    );

    public static final RecipesBase STRIPPED_LOG_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{" A ", "ABA", " A "},
        LOG, 4, "windows",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase STRIPPED_PANE_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_pane",
        new CraftingIngredient('A', WINDOW_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase STRIPPED_LOG_WINDOW2 = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_two",
        new CraftingIngredient('A', WINDOW_HALF_BAR_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    public static final RecipesBase STRIPPED_LOG_FOUR_WINDOW = new RecipesBase("recipeShapedWith2Items",
        new String[]{"AAA", "ABA", "AAA"},
        LOG, 8, "windows_four",
        new CraftingIngredient('A', WINDOW_CENTRE_BAR_BASE),
        new CraftingIngredient('B', STRIPPED_LOG)
    );

    // ================ PATHS ================
    public static final RecipesBase PLANKS_PATH = new RecipesBase("recipeShapelessWith1Item",
        new String[]{},
        PLANKS, 3, "planks_paths",
        new CraftingIngredient('A', SLAB)
    );
}

