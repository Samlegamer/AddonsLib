package fr.samlegamer.addonslib.data;

import fr.samlegamer.addonslib.bridges.Bridges;
import fr.samlegamer.addonslib.door.Doors;
import fr.samlegamer.addonslib.fences.Fences;
import fr.samlegamer.addonslib.furnitures.Furnitures;
import fr.samlegamer.addonslib.path.Paths;
import fr.samlegamer.addonslib.roofs.Roofs;
import fr.samlegamer.addonslib.stairs.Stairs;
import fr.samlegamer.addonslib.trapdoor.Trapdoors;
import fr.samlegamer.addonslib.windows.Windows;

import java.util.List;

public class McwBlocksIdBase
{
    public static final McwBlockIdBase BRIDGES_WOOD_BLOCKS = new McwBlockIdBase(Bridges.modid, List.of(
            new BlockId("%material%_log_bridge_middle", "com.mcwbridges.kikoz.objects.Log_Bridge"),
            new BlockId("rope_%material%_bridge", "com.mcwbridges.kikoz.objects.Bridge_Block_Rope"),
            new BlockId("%material%_bridge_pier", "com.mcwbridges.kikoz.objects.Bridge_Support"),
            new BlockId("%material%_log_bridge_stair", "com.mcwbridges.kikoz.objects.Bridge_Stairs"),
            new BlockId("%material%_rope_bridge_stair", "com.mcwbridges.kikoz.objects.Bridge_Stairs"),
            new BlockId("%material%_rail_bridge", "com.mcwbridges.kikoz.objects.Rail_Bridge")
    ));

    public static final McwBlockIdBase BRIDGES_STONE_BLOCKS = new McwBlockIdBase(Bridges.modid, List.of(
            new BlockId("%material%_bridge", "com.mcwbridges.kikoz.objects.Bridge_Block"),
            new BlockId("%material%_bridge_pier", "com.mcwbridges.kikoz.objects.Bridge_Support"),
            new BlockId("%material%_bridge_stair", "com.mcwbridges.kikoz.objects.Bridge_Stairs"),
            new BlockId("balustrade_%material%_bridge", "com.mcwbridges.kikoz.objects.Bridge_Block")
    ));

    public static final McwBlockIdBase DOORS_WOOD_BLOCKS = new McwBlockIdBase(Doors.modid, List.of(
            new BlockId("%material%_japanese_door", "com.mcwdoors.kikoz.objects.JapaneseDoors"),
            new BlockId("%material%_japanese2_door", "com.mcwdoors.kikoz.objects.JapaneseDoors"),
            new BlockId("%material%_barn_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_barn_glass_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_modern_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_cottage_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_classic_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_beach_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_paper_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_four_panel_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_tropical_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_glass_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_stable_door", "com.mcwdoors.kikoz.objects.StableDoor"),
            new BlockId("%material%_stable_head_door", "com.mcwdoors.kikoz.objects.StableDoor"),
            new BlockId("%material%_western_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_mystic_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_nether_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_swamp_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_bamboo_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_bark_glass_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_waffle_door", "net.minecraft.world.level.block.DoorBlock"),
            new BlockId("%material%_whispering_door", "net.minecraft.world.level.block.DoorBlock")
    ));

    public static final McwBlockIdBase FENCES_WOOD_BLOCKS = new McwBlockIdBase(Fences.modid, List.of(
            new BlockId("%material%_picket_fence", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("%material%_stockade_fence", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("%material%_horse_fence", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("%material%_wired_fence", "com.mcwfences.kikoz.objects.WiredFence"),
            new BlockId("%material%_highley_gate", "net.minecraft.world.level.block.FenceGateBlock"),
            new BlockId("%material%_pyramid_gate", "net.minecraft.world.level.block.FenceGateBlock"),
            new BlockId("%material%_curved_gate", "com.mcwfences.kikoz.objects.DoubleGate")
    ));

    public static final McwBlockIdBase FENCES_LEAVE_BLOCKS = new McwBlockIdBase(Fences.modid, List.of(
            new BlockId("%material%_hedge", "com.mcwfences.kikoz.objects.FenceHitbox")
    ));

    public static final McwBlockIdBase FENCES_STONE_BLOCKS = new McwBlockIdBase(Fences.modid, List.of(
            new BlockId("modern_%material%_wall", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("railing_%material%_wall", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("%material%_railing_gate", "net.minecraft.world.level.block.FenceGateBlock"),
            new BlockId("%material%_pillar_wall", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("%material%_grass_topped_wall", "com.mcwfences.kikoz.objects.FenceHitbox")
    ));

    public static final McwBlockIdBase FURNITURES_WOOD_BLOCKS = new McwBlockIdBase(Furnitures.modid, List.of(
            new BlockId("%material%_wardrobe", "com.mcwfurnitures.kikoz.objects.TallFurnitureHinge"),
            new BlockId("%material%_modern_wardrobe", "com.mcwfurnitures.kikoz.objects.TallFurnitureHinge"),
            new BlockId("%material%_double_wardrobe", "com.mcwfurnitures.kikoz.objects.TallFurniture"),
            new BlockId("%material%_bookshelf", "com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet"),
            new BlockId("%material%_bookshelf_cupboard", "com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge"),
            new BlockId("%material%_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("%material%_double_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("%material%_bookshelf_drawer", "com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer"),
            new BlockId("%material%_lower_bookshelf_drawer", "com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer"),
            new BlockId("%material%_large_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("%material%_lower_triple_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("%material%_triple_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("%material%_desk", "com.mcwfurnitures.kikoz.objects.Desk"),
            new BlockId("%material%_covered_desk", "com.mcwfurnitures.kikoz.objects.Desk"),
            new BlockId("%material%_modern_desk", "com.mcwfurnitures.kikoz.objects.Desk"),
            new BlockId("%material%_table", "com.mcwfurnitures.kikoz.objects.TableHitbox"),
            new BlockId("%material%_end_table", "com.mcwfurnitures.kikoz.objects.TableHitbox"),
            new BlockId("%material%_coffee_table", "com.mcwfurnitures.kikoz.objects.Table"),
            new BlockId("%material%_glass_table", "com.mcwfurnitures.kikoz.objects.TableHitbox"),
            new BlockId("%material%_chair", "com.mcwfurnitures.kikoz.objects.chairs.ClassicChair"),
            new BlockId("%material%_modern_chair", "com.mcwfurnitures.kikoz.objects.chairs.ModernChair"),
            new BlockId("%material%_striped_chair", "com.mcwfurnitures.kikoz.objects.chairs.StripedChair"),
            new BlockId("%material%_stool_chair", "com.mcwfurnitures.kikoz.objects.Chair"),
            new BlockId("%material%_counter", "com.mcwfurnitures.kikoz.objects.counters.Counter"),
            new BlockId("%material%_drawer_counter", "com.mcwfurnitures.kikoz.objects.counters.StorageCounter"),
            new BlockId("%material%_double_drawer_counter", "com.mcwfurnitures.kikoz.objects.counters.StorageCounter"),
            new BlockId("%material%_cupboard_counter", "com.mcwfurnitures.kikoz.objects.counters.CupboardCounter"),
            new BlockId("%material%_kitchen_cabinet", "com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge"),
            new BlockId("%material%_double_kitchen_cabinet", "com.mcwfurnitures.kikoz.objects.cabinets.Cabinet"),
            new BlockId("%material%_glass_kitchen_cabinet", "com.mcwfurnitures.kikoz.objects.cabinets.Cabinet"),
            new BlockId("stripped_%material%_wardrobe", "com.mcwfurnitures.kikoz.objects.TallFurnitureHinge"),
            new BlockId("stripped_%material%_modern_wardrobe", "com.mcwfurnitures.kikoz.objects.TallFurnitureHinge"),
            new BlockId("stripped_%material%_double_wardrobe", "com.mcwfurnitures.kikoz.objects.TallFurniture"),
            new BlockId("stripped_%material%_bookshelf", "com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinet"),
            new BlockId("stripped_%material%_bookshelf_cupboard", "com.mcwfurnitures.kikoz.objects.bookshelves.BookCabinetHinge"),
            new BlockId("stripped_%material%_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("stripped_%material%_double_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("stripped_%material%_bookshelf_drawer", "com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer"),
            new BlockId("stripped_%material%_lower_bookshelf_drawer", "com.mcwfurnitures.kikoz.objects.bookshelves.BookDrawer"),
            new BlockId("stripped_%material%_large_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("stripped_%material%_lower_triple_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("stripped_%material%_triple_drawer", "com.mcwfurnitures.kikoz.objects.WideFurniture"),
            new BlockId("stripped_%material%_desk", "com.mcwfurnitures.kikoz.objects.Desk"),
            new BlockId("stripped_%material%_covered_desk", "com.mcwfurnitures.kikoz.objects.Desk"),
            new BlockId("stripped_%material%_modern_desk", "com.mcwfurnitures.kikoz.objects.Desk"),
            new BlockId("stripped_%material%_table", "com.mcwfurnitures.kikoz.objects.TableHitbox"),
            new BlockId("stripped_%material%_end_table", "com.mcwfurnitures.kikoz.objects.TableHitbox"),
            new BlockId("stripped_%material%_coffee_table", "com.mcwfurnitures.kikoz.objects.Table"),
            new BlockId("stripped_%material%_glass_table", "com.mcwfurnitures.kikoz.objects.TableHitbox"),
            new BlockId("stripped_%material%_chair", "com.mcwfurnitures.kikoz.objects.chairs.ClassicChair"),
            new BlockId("stripped_%material%_modern_chair", "com.mcwfurnitures.kikoz.objects.chairs.ModernChair"),
            new BlockId("stripped_%material%_striped_chair", "com.mcwfurnitures.kikoz.objects.chairs.StripedChair"),
            new BlockId("stripped_%material%_stool_chair", "com.mcwfurnitures.kikoz.objects.Chair"),
            new BlockId("stripped_%material%_counter", "com.mcwfurnitures.kikoz.objects.counters.Counter"),
            new BlockId("stripped_%material%_drawer_counter", "com.mcwfurnitures.kikoz.objects.counters.StorageCounter"),
            new BlockId("stripped_%material%_double_drawer_counter", "com.mcwfurnitures.kikoz.objects.counters.StorageCounter"),
            new BlockId("stripped_%material%_cupboard_counter", "com.mcwfurnitures.kikoz.objects.counters.CupboardCounter"),
            new BlockId("stripped_%material%_kitchen_cabinet", "com.mcwfurnitures.kikoz.objects.cabinets.CabinetHinge"),
            new BlockId("stripped_%material%_double_kitchen_cabinet", "com.mcwfurnitures.kikoz.objects.cabinets.Cabinet"),
            new BlockId("stripped_%material%_glass_kitchen_cabinet", "com.mcwfurnitures.kikoz.objects.cabinets.Cabinet")
    ));

    public static final McwBlockIdBase PATHS_WOOD_BLOCKS = new McwBlockIdBase(Paths.modid, List.of(
            new BlockId("%material%_planks_path", "com.mcwpaths.kikoz.objects.FacingPathBlock")
    ));

    public static final McwBlockIdBase ROOFS_WOOD_BLOCKS = new McwBlockIdBase(Roofs.modid, List.of(
            new BlockId("%material%_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_attic_roof", "com.mcwroofs.kikoz.objects.roofs.RoofGlass"),
            new BlockId("%material%_top_roof", "com.mcwroofs.kikoz.objects.roofs.RoofTopNew"),
            new BlockId("%material%_lower_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_steep_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_upper_lower_roof", "com.mcwroofs.kikoz.objects.roofs.Lower"),
            new BlockId("%material%_upper_steep_roof", "com.mcwroofs.kikoz.objects.roofs.Steep"),
            new BlockId("%material%_planks_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_planks_attic_roof", "com.mcwroofs.kikoz.objects.roofs.RoofGlass"),
            new BlockId("%material%_planks_top_roof", "com.mcwroofs.kikoz.objects.roofs.RoofTopNew"),
            new BlockId("%material%_planks_lower_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_planks_steep_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_planks_upper_lower_roof", "com.mcwroofs.kikoz.objects.roofs.Lower"),
            new BlockId("%material%_planks_upper_steep_roof", "com.mcwroofs.kikoz.objects.roofs.Steep")
    ));

    public static final McwBlockIdBase ROOFS_STONE_BLOCKS = new McwBlockIdBase(Roofs.modid, List.of(
            new BlockId("%material%_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_attic_roof", "com.mcwroofs.kikoz.objects.roofs.RoofGlass"),
            new BlockId("%material%_top_roof", "com.mcwroofs.kikoz.objects.roofs.RoofTopNew"),
            new BlockId("%material%_lower_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_steep_roof", "net.minecraft.world.level.block.StairBlock"),
            new BlockId("%material%_upper_lower_roof", "com.mcwroofs.kikoz.objects.roofs.Lower"),
            new BlockId("%material%_upper_steep_roof", "com.mcwroofs.kikoz.objects.roofs.Steep")
    ));

    public static final McwBlockIdBase STAIRS_WOOD_BLOCKS = new McwBlockIdBase(Stairs.modid, List.of(
            new BlockId("%material%_terrace_stairs", "com.mcwstairs.kikoz.objects.stair_types.TerraceStairs"),
            new BlockId("%material%_skyline_stairs", "com.mcwstairs.kikoz.objects.stair_types.SkylineStairs"),
            new BlockId("%material%_compact_stairs", "com.mcwstairs.kikoz.objects.stair_types.CompactStairs"),
            new BlockId("%material%_bulk_stairs", "com.mcwstairs.kikoz.objects.stair_types.BulkStairs"),
            new BlockId("%material%_loft_stairs", "com.mcwstairs.kikoz.objects.stair_types.LoftStairs"),
            new BlockId("%material%_railing", "com.mcwstairs.kikoz.objects.StairRailing"),
            new BlockId("%material%_balcony", "com.mcwstairs.kikoz.objects.BalconyRailing"),
            new BlockId("%material%_platform", "com.mcwstairs.kikoz.objects.StairPlatform")
    ));

    public static final McwBlockIdBase TRAPDOORS_WOOD_BLOCKS = new McwBlockIdBase(Trapdoors.modid, List.of(
            new BlockId("%material%_barn_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_cottage_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_barred_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_beach_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_four_panel_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_glass_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_mystic_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_paper_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_tropical_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_swamp_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_bamboo_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_classic_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_bark_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_ranch_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_blossom_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_barrel_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock"),
            new BlockId("%material%_whispering_trapdoor", "net.minecraft.world.level.block.TrapDoorBlock")
    ));

    public static final McwBlockIdBase WINDOWS_WOOD_BLOCKS = new McwBlockIdBase(Windows.modid, List.of(
            new BlockId("%material%_window", "com.mcwwindows.kikoz.objects.ConnectedWindow"),
            new BlockId("%material%_window2", "com.mcwwindows.kikoz.objects.WindowBarred"),
            new BlockId("%material%_four_window", "com.mcwwindows.kikoz.objects.WindowBarred"),
            new BlockId("stripped_%material%_log_window", "com.mcwwindows.kikoz.objects.ConnectedWindow"),
            new BlockId("stripped_%material%_log_window2", "com.mcwwindows.kikoz.objects.WindowBarred"),
            new BlockId("stripped_%material%_log_four_window", "com.mcwwindows.kikoz.objects.WindowBarred"),
            new BlockId("%material%_plank_window", "com.mcwwindows.kikoz.objects.ConnectedWindow"),
            new BlockId("%material%_plank_window2", "com.mcwwindows.kikoz.objects.WindowBarred"),
            new BlockId("%material%_plank_four_window", "com.mcwwindows.kikoz.objects.WindowBarred"),
            new BlockId("%material%_log_parapet", "com.mcwwindows.kikoz.objects.Parapet"),
            new BlockId("%material%_plank_parapet", "com.mcwwindows.kikoz.objects.Parapet"),
            new BlockId("%material%_blinds", "com.mcwwindows.kikoz.objects.Blinds"),
            new BlockId("%material%_shutter", "com.mcwwindows.kikoz.objects.Shutter"),
            new BlockId("%material%_louvered_shutter", "com.mcwwindows.kikoz.objects.Shutter"),
            new BlockId("%material%_pane_window", "com.mcwwindows.kikoz.objects.Window"),
            new BlockId("stripped_%material%_pane_window", "com.mcwwindows.kikoz.objects.Window"),
            new BlockId("%material%_plank_pane_window", "com.mcwwindows.kikoz.objects.Window"),
            new BlockId("%material%_curtain_rod", "com.mcwwindows.kikoz.objects.CurtainRod")
    ));

    public static String replacement(String id, String realMat)
    {
        return id.replace("%material%", realMat);
    }

    public static McwBlockIdBase getBlocksWithModidWood(ModType modType)
    {
        return switch (modType) {
            case BRIDGES -> BRIDGES_WOOD_BLOCKS;
            case DOORS -> DOORS_WOOD_BLOCKS;
            case FENCES -> FENCES_WOOD_BLOCKS;
            case FURNITURES -> FURNITURES_WOOD_BLOCKS;
            case PATHS -> PATHS_WOOD_BLOCKS;
            case ROOFS -> ROOFS_WOOD_BLOCKS;
            case STAIRS -> STAIRS_WOOD_BLOCKS;
            case TRAPDOORS -> TRAPDOORS_WOOD_BLOCKS;
            case WINDOWS -> WINDOWS_WOOD_BLOCKS;
        };
    }

    public static McwBlockIdBase getBlocksWithModidLeave(ModType modType)
    {
        return switch (modType) {
            case FENCES -> FENCES_LEAVE_BLOCKS;
            default -> null;
        };
    }

    public static McwBlockIdBase getBlocksWithModidStone(ModType modType)
    {
        return switch (modType) {
            case BRIDGES -> BRIDGES_STONE_BLOCKS;
            case FENCES -> FENCES_STONE_BLOCKS;
            case ROOFS -> ROOFS_STONE_BLOCKS;
            default -> null;
        };
    }
}