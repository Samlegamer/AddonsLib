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
            new BlockId("%material%_log_bridge_middle", "net.kikoz.mcwbridges.objects.Log_Bridge"),
            new BlockId("rope_%material%_bridge", "net.kikoz.mcwbridges.objects.Bridge_Block_Rope"),
            new BlockId("%material%_bridge_pier", "net.kikoz.mcwbridges.objects.Bridge_Support"),
            new BlockId("%material%_log_bridge_stair", "net.kikoz.mcwbridges.objects.Bridge_Stairs"),
            new BlockId("%material%_rope_bridge_stair", "net.kikoz.mcwbridges.objects.Bridge_Stairs"),
            new BlockId("%material%_rail_bridge", "net.kikoz.mcwbridges.objects.Rail_Bridge")
    ));

    public static final McwBlockIdBase BRIDGES_STONE_BLOCKS = new McwBlockIdBase(Bridges.modid, List.of(
            new BlockId("%material%_bridge", "net.kikoz.mcwbridges.objects.Bridge_Block"),
            new BlockId("%material%_bridge_pier", "net.kikoz.mcwbridges.objects.Bridge_Support"),
            new BlockId("%material%_bridge_stair", "net.kikoz.mcwbridges.objects.Bridge_Stairs"),
            new BlockId("balustrade_%material%_bridge", "net.kikoz.mcwbridges.objects.Bridge_Block")
    ));

    public static final McwBlockIdBase DOORS_WOOD_BLOCKS = new McwBlockIdBase(Doors.modid, List.of(
            new BlockId("%material%_japanese_door", "net.kikoz.mcwdoors.objects.JapaneseDoors"),
            new BlockId("%material%_japanese2_door", "net.kikoz.mcwdoors.objects.JapaneseDoors"),
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
            new BlockId("%material%_stable_door", "net.kikoz.mcwdoors.objects.StableDoor"),
            new BlockId("%material%_stable_head_door", "net.kikoz.mcwdoors.objects.StableDoor"),
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
            new BlockId("%material%_wired_fence", "net.kikoz.mcwfences.objects.WiredFence"),
            new BlockId("%material%_highley_gate", "net.minecraft.world.level.block.FenceGateBlock"),
            new BlockId("%material%_pyramid_gate", "net.minecraft.world.level.block.FenceGateBlock"),
            new BlockId("%material%_curved_gate", "net.kikoz.mcwfences.objects.DoubleGate")
    ));

    public static final McwBlockIdBase FENCES_LEAVE_BLOCKS = new McwBlockIdBase(Fences.modid, List.of(
            new BlockId("%material%_hedge", "net.kikoz.mcwfences.objects.FenceHitbox")
    ));

    public static final McwBlockIdBase FENCES_STONE_BLOCKS = new McwBlockIdBase(Fences.modid, List.of(
            new BlockId("modern_%material%_wall", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("railing_%material%_wall", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("%material%_railing_gate", "net.minecraft.world.level.block.FenceGateBlock"),
            new BlockId("%material%_pillar_wall", "net.minecraft.world.level.block.FenceBlock"),
            new BlockId("%material%_grass_topped_wall", "net.kikoz.mcwfences.objects.FenceHitbox")
    ));

    public static final McwBlockIdBase FURNITURES_WOOD_BLOCKS = new McwBlockIdBase(Furnitures.modid, List.of(
            new BlockId("%material%_wardrobe", "net.kikoz.mcwfurnitures.objects.TallFurnitureHinge"),
            new BlockId("%material%_modern_wardrobe", "net.kikoz.mcwfurnitures.objects.TallFurnitureHinge"),
            new BlockId("%material%_double_wardrobe", "net.kikoz.mcwfurnitures.objects.TallFurniture"),
            new BlockId("%material%_bookshelf", "net.kikoz.mcwfurnitures.objects.TallFurniture"),
            new BlockId("%material%_bookshelf_cupboard", "net.kikoz.mcwfurnitures.objects.TallFurnitureHinge"),
            new BlockId("%material%_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("%material%_double_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("%material%_bookshelf_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("%material%_lower_bookshelf_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("%material%_large_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("%material%_lower_triple_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("%material%_triple_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("%material%_desk", "net.kikoz.mcwfurnitures.objects.Desk"),
            new BlockId("%material%_covered_desk", "net.kikoz.mcwfurnitures.objects.Desk"),
            new BlockId("%material%_modern_desk", "net.kikoz.mcwfurnitures.objects.Desk"),
            new BlockId("%material%_table", "net.kikoz.mcwfurnitures.objects.TableHitbox"),
            new BlockId("%material%_end_table", "net.kikoz.mcwfurnitures.objects.TableHitbox"),
            new BlockId("%material%_coffee_table", "net.kikoz.mcwfurnitures.objects.Table"),
            new BlockId("%material%_glass_table", "net.kikoz.mcwfurnitures.objects.TableHitbox"),
            new BlockId("%material%_chair", "net.kikoz.mcwfurnitures.objects.chairs.StripedChair"),
            new BlockId("%material%_modern_chair", "net.kikoz.mcwfurnitures.objects.chairs.ModernChair"),
            new BlockId("%material%_striped_chair", "net.kikoz.mcwfurnitures.objects.chairs.StripedChair"),
            new BlockId("%material%_stool_chair", "net.kikoz.mcwfurnitures.objects.Chair"),
            new BlockId("%material%_counter", "net.kikoz.mcwfurnitures.objects.counters.Counter"),
            new BlockId("%material%_drawer_counter", "net.kikoz.mcwfurnitures.objects.counters.StorageCounter"),
            new BlockId("%material%_double_drawer_counter", "net.kikoz.mcwfurnitures.objects.counters.StorageCounter"),
            new BlockId("%material%_cupboard_counter", "net.kikoz.mcwfurnitures.objects.counters.CupboardCounter"),
            new BlockId("stripped_%material%_wardrobe", "net.kikoz.mcwfurnitures.objects.TallFurnitureHinge"),
            new BlockId("stripped_%material%_modern_wardrobe", "net.kikoz.mcwfurnitures.objects.TallFurnitureHinge"),
            new BlockId("stripped_%material%_double_wardrobe", "net.kikoz.mcwfurnitures.objects.TallFurniture"),
            new BlockId("stripped_%material%_bookshelf", "net.kikoz.mcwfurnitures.objects.TallFurniture"),
            new BlockId("stripped_%material%_bookshelf_cupboard", "net.kikoz.mcwfurnitures.objects.TallFurnitureHinge"),
            new BlockId("stripped_%material%_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("stripped_%material%_double_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("stripped_%material%_bookshelf_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("stripped_%material%_lower_bookshelf_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("stripped_%material%_large_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("stripped_%material%_lower_triple_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("stripped_%material%_triple_drawer", "net.kikoz.mcwfurnitures.objects.WideFurniture"),
            new BlockId("stripped_%material%_desk", "net.kikoz.mcwfurnitures.objects.Desk"),
            new BlockId("stripped_%material%_covered_desk", "net.kikoz.mcwfurnitures.objects.Desk"),
            new BlockId("stripped_%material%_modern_desk", "net.kikoz.mcwfurnitures.objects.Desk"),
            new BlockId("stripped_%material%_table", "net.kikoz.mcwfurnitures.objects.TableHitbox"),
            new BlockId("stripped_%material%_end_table", "net.kikoz.mcwfurnitures.objects.TableHitbox"),
            new BlockId("stripped_%material%_coffee_table", "net.kikoz.mcwfurnitures.objects.Table"),
            new BlockId("stripped_%material%_glass_table", "net.kikoz.mcwfurnitures.objects.TableHitbox"),
            new BlockId("stripped_%material%_chair", "net.kikoz.mcwfurnitures.objects.chairs.StripedChair"),
            new BlockId("stripped_%material%_modern_chair", "net.kikoz.mcwfurnitures.objects.chairs.ModernChair"),
            new BlockId("stripped_%material%_striped_chair", "net.kikoz.mcwfurnitures.objects.chairs.StripedChair"),
            new BlockId("stripped_%material%_stool_chair", "net.kikoz.mcwfurnitures.objects.Chair"),
            new BlockId("stripped_%material%_counter", "net.kikoz.mcwfurnitures.objects.counters.Counter"),
            new BlockId("stripped_%material%_drawer_counter", "net.kikoz.mcwfurnitures.objects.counters.StorageCounter"),
            new BlockId("stripped_%material%_double_drawer_counter", "net.kikoz.mcwfurnitures.objects.counters.StorageCounter"),
            new BlockId("stripped_%material%_cupboard_counter", "net.kikoz.mcwfurnitures.objects.counters.CupboardCounter"),
            new BlockId("%material%_kitchen_cabinet", "net.kikoz.mcwfurnitures.objects.cabinets.CabinetHinge"),
            new BlockId("%material%_double_kitchen_cabinet", "net.kikoz.mcwfurnitures.objects.cabinets.Cabinet"),
            new BlockId("%material%_glass_kitchen_cabinet", "net.kikoz.mcwfurnitures.objects.cabinets.Cabinet"),
            new BlockId("stripped_%material%_kitchen_cabinet", "net.kikoz.mcwfurnitures.objects.cabinets.CabinetHinge"),
            new BlockId("stripped_%material%_double_kitchen_cabinet", "net.kikoz.mcwfurnitures.objects.cabinets.Cabinet"),
            new BlockId("stripped_%material%_glass_kitchen_cabinet", "net.kikoz.mcwfurnitures.objects.cabinets.Cabinet"),
            new BlockId("%material%_kitchen_sink", "net.kikoz.mcwfurnitures.objects.counters.SinkCounter"),
            new BlockId("stripped_%material%_kitchen_sink", "net.kikoz.mcwfurnitures.objects.counters.SinkCounter")
    ));

    public static final McwBlockIdBase PATHS_WOOD_BLOCKS = new McwBlockIdBase(Paths.modid, List.of(
            new BlockId("%material%_planks_path", "com.mcwpaths.kikoz.objects.FacingPathBlock")
    ));

    public static final McwBlockIdBase ROOFS_WOOD_BLOCKS = new McwBlockIdBase(Roofs.modid, List.of(
            new BlockId("%material%_roof", "net.kikoz.mcwroofs.objects.roofs.BaseRoof"),
            new BlockId("%material%_attic_roof", "net.kikoz.mcwroofs.objects.roofs.RoofGlass"),
            new BlockId("%material%_top_roof", "net.kikoz.mcwroofs.objects.roofs.RoofTopNew"),
            new BlockId("%material%_lower_roof", "net.kikoz.mcwroofs.objects.roofs.BaseRoof"),
            new BlockId("%material%_steep_roof", "net.kikoz.mcwroofs.objects.roofs.SteepRoof"),
            new BlockId("%material%_upper_lower_roof", "net.kikoz.mcwroofs.objects.roofs.Lower"),
            new BlockId("%material%_upper_steep_roof", "net.kikoz.mcwroofs.objects.roofs.Steep"),

            new BlockId("%material%_planks_roof", "net.kikoz.mcwroofs.objects.roofs.BaseRoof"),
            new BlockId("%material%_planks_attic_roof", "net.kikoz.mcwroofs.objects.roofs.RoofGlass"),
            new BlockId("%material%_planks_top_roof", "net.kikoz.mcwroofs.objects.roofs.RoofTopNew"),
            new BlockId("%material%_planks_lower_roof", "net.kikoz.mcwroofs.objects.roofs.BaseRoof"),
            new BlockId("%material%_planks_steep_roof", "net.kikoz.mcwroofs.objects.roofs.SteepRoof"),
            new BlockId("%material%_planks_upper_lower_roof", "net.kikoz.mcwroofs.objects.roofs.Lower"),
            new BlockId("%material%_planks_upper_steep_roof", "net.kikoz.mcwroofs.objects.roofs.Steep")
    ));

    public static final McwBlockIdBase ROOFS_STONE_BLOCKS = new McwBlockIdBase(Roofs.modid, List.of(
            new BlockId("%material%_roof", "net.kikoz.mcwroofs.objects.roofs.BaseRoof"),
            new BlockId("%material%_attic_roof", "net.kikoz.mcwroofs.objects.roofs.RoofGlass"),
            new BlockId("%material%_top_roof", "net.kikoz.mcwroofs.objects.roofs.RoofTopNew"),
            new BlockId("%material%_lower_roof", "net.kikoz.mcwroofs.objects.roofs.BaseRoof"),
            new BlockId("%material%_steep_roof", "net.kikoz.mcwroofs.objects.roofs.SteepRoof"),
            new BlockId("%material%_upper_lower_roof", "net.kikoz.mcwroofs.objects.roofs.Lower"),
            new BlockId("%material%_upper_steep_roof", "net.kikoz.mcwroofs.objects.roofs.Steep")
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
            new BlockId("%material%_window", "net.kikoz.mcwwindows.objects.ConnectedWindow"),
            new BlockId("%material%_window2", "net.kikoz.mcwwindows.objects.WindowBarred"),
            new BlockId("%material%_four_window", "net.kikoz.mcwwindows.objects.WindowBarred"),
            new BlockId("stripped_%material%_log_window", "net.kikoz.mcwwindows.objects.ConnectedWindow"),
            new BlockId("stripped_%material%_log_window2", "net.kikoz.mcwwindows.objects.WindowBarred"),
            new BlockId("stripped_%material%_log_four_window", "net.kikoz.mcwwindows.objects.WindowBarred"),
            new BlockId("%material%_plank_window", "net.kikoz.mcwwindows.objects.ConnectedWindow"),
            new BlockId("%material%_plank_window2", "net.kikoz.mcwwindows.objects.WindowBarred"),
            new BlockId("%material%_plank_four_window", "net.kikoz.mcwwindows.objects.WindowBarred"),
            new BlockId("%material%_log_parapet", "net.kikoz.mcwwindows.objects.Parapet"),
            new BlockId("%material%_plank_parapet", "net.kikoz.mcwwindows.objects.Parapet"),
            new BlockId("%material%_blinds", "net.kikoz.mcwwindows.objects.Blinds"),
            new BlockId("%material%_shutter", "net.kikoz.mcwwindows.objects.Shutter"),
            new BlockId("%material%_louvered_shutter", "net.kikoz.mcwwindows.objects.Shutter"),
            new BlockId("%material%_pane_window", "net.kikoz.mcwwindows.objects.Window"),
            new BlockId("stripped_%material%_pane_window", "net.kikoz.mcwwindows.objects.Window"),
            new BlockId("%material%_plank_pane_window", "net.kikoz.mcwwindows.objects.Window"),
            new BlockId("%material%_curtain_rod", "net.kikoz.mcwwindows.objects.CurtainRod")
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