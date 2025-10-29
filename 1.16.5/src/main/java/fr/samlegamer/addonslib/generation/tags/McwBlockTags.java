package fr.samlegamer.addonslib.generation.tags;

import fr.samlegamer.addonslib.Finder;
import fr.samlegamer.addonslib.bridges.Bridges;
import fr.samlegamer.addonslib.data.BlockId;
import fr.samlegamer.addonslib.data.McwBlockIdBase;
import fr.samlegamer.addonslib.data.McwBlocksIdBase;
import fr.samlegamer.addonslib.door.Doors;
import fr.samlegamer.addonslib.fences.Fences;
import fr.samlegamer.addonslib.furnitures.Furnitures;
import fr.samlegamer.addonslib.path.Paths;
import fr.samlegamer.addonslib.stairs.Stairs;
import fr.samlegamer.addonslib.windows.Windows;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import javax.annotation.Nullable;
import java.util.*;

public abstract class McwBlockTags extends BlockTagsProvider
{
    public McwBlockTags(DataGenerator p_i48256_1_, String modid, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i48256_1_, modid, existingFileHelper);
    }

    public void addAllMcwTags(String modid, List<String> WOOD, List<String> STONE, List<String> LEAVE)
    {
        mcwWindowsTags(modid, WOOD);
        mcwStairsTags(modid, WOOD);
        mcwRoofsTags(modid, WOOD, STONE);
        mcwPathsTags(modid, WOOD);
        mcwFurnituresTags(modid, WOOD);
        mcwFencesTags(modid, WOOD, LEAVE, STONE);
        mcwBridgesTagsWood(modid, WOOD);
        mcwDoorsTagsWood(modid, WOOD);
        mcwTrapdoorsTagsWood(modid, WOOD);

        if(!STONE.isEmpty())
        {
            mcwBridgesTagsStone(modid, STONE);
        }
    }

    public void addAllMcwTags(String modid, List<String> WOOD, List<String> LEAVE)
    {
        addAllMcwTags(modid, WOOD, new ArrayList<>(), LEAVE);
    }

    public void addAllMcwTags(String modid, List<String> WOOD)
    {
        addAllMcwTags(modid, WOOD, new ArrayList<>());
    }

    public void mcwWindowsTags(String modid, List<String> WOOD)
    {
        Set<Block> blocksWood = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.WINDOWS_WOOD_BLOCKS);

        this.tag(BlockTags.WALLS)
                .add((Block[]) getSetWithEndsWith(blocksWood, "_window2").toArray())
                .add((Block[]) getSetWithEndsWith(blocksWood, "_window").toArray());
        this.tag(getTag(Windows.modid, "blinds")).add((Block[]) getSetWithEndsWith(blocksWood, "_blinds").toArray());
        this.tag(getTag(Windows.modid, "curtain_rods")).add((Block[]) getSetWithEndsWith(blocksWood, "_curtain_rod").toArray());
        this.tag(getTag(Windows.modid, "parapets")).add((Block[]) getSetWithEndsWith(blocksWood, "_log_parapet").toArray());
        this.tag(getTag(Windows.modid, "shutters")).add((Block[]) getSetWithEndsWith(blocksWood, "_shutter").toArray());
        this.tag(getTag(Windows.modid, "windows_four")).add((Block[]) getSetWithEndsWith(blocksWood, "_four_window").toArray());
        this.tag(getTag(Windows.modid, "windows_two")).add((Block[]) getSetWithEndsWith(blocksWood, "_window2").toArray());
        this.tag(getTag(Windows.modid, "windows")).add((Block[]) getSetWithEndsWith(blocksWood, "_window").toArray());
    }

    public void mcwStairsTags(String modid, List<String> WOOD)
    {
        Set<Block> blocksWood = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.STAIRS_WOOD_BLOCKS);

        this.tag(getTag(Stairs.modid, "balconies")).add((Block[]) getSetWithEndsWith(blocksWood, "_balcony").toArray());
        this.tag(getTag(Stairs.modid, "bulk_stairs")).add((Block[]) getSetWithEndsWith(blocksWood, "_bulk_stairs").toArray());
        this.tag(getTag(Stairs.modid, "compact_stairs")).add((Block[]) getSetWithEndsWith(blocksWood, "_compact_stairs").toArray());
        this.tag(getTag(Stairs.modid, "loft_stairs")).add((Block[]) getSetWithEndsWith(blocksWood, "_loft_stairs").toArray());
        this.tag(getTag(Stairs.modid, "platforms")).add((Block[]) getSetWithEndsWith(blocksWood, "_platform").toArray());
        this.tag(getTag(Stairs.modid, "railings")).add((Block[]) getSetWithEndsWith(blocksWood, "_railing").toArray());
        this.tag(getTag(Stairs.modid, "skyline_stairs")).add((Block[]) getSetWithEndsWith(blocksWood, "_skyline_stairs").toArray());
        this.tag(getTag(Stairs.modid, "terrace_stairs")).add((Block[]) getSetWithEndsWith(blocksWood, "_terrace_stairs").toArray());
    }

    public void mcwRoofsTags(String modid, List<String> WOOD, List<String> STONE)
    {
        Set<Block> blocksWood = new HashSet<>();
        Set<Block> blocksStone = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.ROOFS_WOOD_BLOCKS);
        addBlocks(modid, STONE, blocksStone, McwBlocksIdBase.ROOFS_STONE_BLOCKS);
    }

    public void mcwPathsTags(String modid, List<String> WOOD)
    {
        Set<Block> blocksWood = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.PATHS_WOOD_BLOCKS);

        this.tag(getTag(Paths.modid, "wooden_paths")).add((Block[]) blocksWood.toArray());
    }

    public void mcwFurnituresTags(String modid, List<String> WOOD)
    {
        Set<Block> blocksWood = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.FURNITURES_WOOD_BLOCKS);

        Map<String, List<String>> map = new HashMap<>();
        map.put("bookshelf_cupboard", Collections.singletonList("_bookshelf_cupboard"));
        map.put("bookshelf_drawer", Collections.singletonList("_bookshelf_drawer"));
        map.put("bookshelf", Collections.singletonList("_bookshelf"));
        map.put("cabinet", Arrays.asList("_kitchen_cabinet", "_double_kitchen_cabinet", "_glass_kitchen_cabinet"));
        map.put("chair", Collections.singletonList("_chair"));
        map.put("coffee_table", Collections.singletonList("_coffee_table"));
        map.put("counter", Collections.singletonList("_counter"));
        map.put("covered_desk", Collections.singletonList("_covered_desk"));
        map.put("cupboard_counter", Collections.singletonList("_cupboard_counter"));
        map.put("desk", Collections.singletonList("_desk"));
        map.put("double_drawer_counter", Collections.singletonList("_double_drawer_counter"));
        map.put("double_drawer", Collections.singletonList("_double_drawer"));
        map.put("double_wardrobe", Collections.singletonList("_double_wardrobe"));
        map.put("drawer", Collections.singletonList("_drawer"));
        map.put("end_table", Collections.singletonList("_end_table"));
        map.put("glass_table", Collections.singletonList("_glass_table"));
        map.put("large_drawer", Collections.singletonList("_large_drawer"));
        map.put("lower_bookshelf_drawer", Collections.singletonList("_lower_bookshelf_drawer"));
        map.put("lower_triple_drawer", Collections.singletonList("_lower_triple_drawer"));
        map.put("modern_chair", Collections.singletonList("_modern_chair"));
        map.put("modern_desk", Collections.singletonList("_modern_desk"));
        map.put("modern_wardrobe", Collections.singletonList("_modern_wardrobe"));
        map.put("stool_chair", Collections.singletonList("_stool_chair"));
        map.put("striped_chair", Collections.singletonList("_striped_chair"));
        map.put("table", Collections.singletonList("_table"));
        map.put("triple_drawer", Collections.singletonList("_triple_drawer"));
        map.put("wadrobe", Collections.singletonList("_wardrobe"));

        for(Map.Entry<String, List<String>> mapEntry : map.entrySet())
        {
            List<String> list = mapEntry.getValue();
            List<Block> blocks = new ArrayList<>();
            for(String mat : WOOD)
            {
                for(String i : list)
                {
                    blocks.add(Finder.findBlock(modid, mat + i));
                    blocks.add(Finder.findBlock(modid, "stripped_" + mat + i));
                }
            }
            this.tag(getTag(Furnitures.modid, mapEntry.getKey())).add((Block[]) blocks.toArray());
        }
//        this.tag(getTag(Furnitures.modid, "curved_double_gates")).add(curved_gates);
    }

    public void mcwFencesTags(String modid, List<String> WOOD, List<String> LEAVE, List<String> STONE)
    {
        Set<Block> blocksWood = new HashSet<>();
        Set<Block> blocksLeave = new HashSet<>();
        Set<Block> blocksStone = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.FENCES_WOOD_BLOCKS);
        addBlocks(modid, LEAVE, blocksLeave, McwBlocksIdBase.FENCES_LEAVE_BLOCKS);
        addBlocks(modid, STONE, blocksStone, McwBlocksIdBase.FENCES_STONE_BLOCKS);

        Block[] picket_fences = (Block[]) getSetWithContain(blocksWood, "picket_fence").toArray();
        Block[] stockade_fences = (Block[]) getSetWithContain(blocksWood, "stockade_fence").toArray();
        Block[] horse_fences = (Block[]) getSetWithContain(blocksWood, "horse_fence").toArray();
        Block[] wired_fences = (Block[]) getSetWithContain(blocksWood, "wired_fence").toArray();
        Block[] highley_gates = (Block[]) getSetWithContain(blocksWood, "highley_gate").toArray();
        Block[] pyramid_gates = (Block[]) getSetWithContain(blocksWood, "pyramid_gate").toArray();
        Block[] curved_gates = (Block[]) getSetWithContain(blocksWood, "curved_gate").toArray();

        Block[] hedges = (Block[]) blocksLeave.toArray();

        Block[] modern_wall = (Block[]) getSetWithStartsWith(blocksStone, "modern_").toArray();
        Block[] railing_wall = (Block[]) getSetWithStartsWith(blocksStone, "railing_").toArray();
        Block[] railing_gate = (Block[]) getSetWithEndsWith(blocksStone, "_railing_gate").toArray();
        Block[] pillar_wall = (Block[]) getSetWithEndsWith(blocksStone, "_pillar_wall").toArray();
        Block[] grass_topped_wall = (Block[]) getSetWithEndsWith(blocksStone, "_grass_topped_wall").toArray();

        this.tag(BlockTags.FENCE_GATES).add(highley_gates).add(pyramid_gates).add(curved_gates).add(railing_gate);
        this.tag(BlockTags.FENCES).add(hedges).add(modern_wall).add(pillar_wall).add(railing_wall).add(grass_topped_wall)
        .add(picket_fences).add(stockade_fences).add(horse_fences).add(wired_fences).add(curved_gates);
        this.tag(BlockTags.WALLS).add(hedges).add(grass_topped_wall);
        this.tag(BlockTags.WOODEN_FENCES).add(picket_fences).add(stockade_fences).add(horse_fences).add(wired_fences).add(curved_gates);

        this.tag(getTag(Fences.modid, "curved_double_gates")).add(curved_gates);
        this.tag(getTag(Fences.modid, "highley_gates")).add(highley_gates);
        this.tag(getTag(Fences.modid, "horse_fences")).add(horse_fences);
        this.tag(getTag(Fences.modid, "picket_fences")).add(picket_fences);
        this.tag(getTag(Fences.modid, "pyramid_gates")).add(pyramid_gates);
        this.tag(getTag(Fences.modid, "pyramid_gates")).add(pyramid_gates);
        this.tag(getTag(Fences.modid, "stockade_fences")).add(stockade_fences);
        this.tag(getTag(Fences.modid, "wired_fences")).add(wired_fences);

        this.tag(getTag(Fences.modid, "hedges")).add(hedges);

        this.tag(getTag(Fences.modid, "grass_topped_walls")).add(grass_topped_wall);
        this.tag(getTag(Fences.modid, "modern_walls")).add(modern_wall);
        this.tag(getTag(Fences.modid, "pillar_walls")).add(pillar_wall);
        this.tag(getTag(Fences.modid, "railing_gates")).add(railing_gate);
        this.tag(getTag(Fences.modid, "railing_walls")).add(railing_wall);
    }

    public void mcwBridgesTagsWood(String modid, List<String> MAT)
    {
        Set<Block> blocks = new HashSet<>();
        addBlocks(modid, MAT, blocks, McwBlocksIdBase.BRIDGES_WOOD_BLOCKS);

        this.tag(getTag(Bridges.modid, "log_bridges")).add((Block[]) getSetWithContain(blocks, "log_bridge_middle").toArray());
        this.tag(getTag(Bridges.modid, "log_stairs")).add((Block[]) getSetWithContain(blocks, "log_bridge_stair").toArray());
        this.tag(getTag(Bridges.modid, "rail_bridges")).add((Block[]) getSetWithContain(blocks, "rail_bridge").toArray());
        this.tag(getTag(Bridges.modid, "rope_bridges")).add((Block[]) getSetWithStartsWith(blocks, "rope_").toArray());
        this.tag(getTag(Bridges.modid, "rope_stairs")).add((Block[]) getSetWithContain(blocks, "rope_bridge_stair").toArray());
        this.tag(getTag(Bridges.modid, "wooden_piers")).add((Block[]) getSetWithContain(blocks, "bridge_pier").toArray());
    }

    public void mcwBridgesTagsStone(String modid, List<String> MAT)
    {
        Set<Block> blocks = new HashSet<>();
        addBlocks(modid, MAT, blocks, McwBlocksIdBase.BRIDGES_STONE_BLOCKS);

        List<Block> listBridgeBase = new ArrayList<>();
        listBridgeBase.addAll(getSetWithEndsWith(blocks, "_bridge"));
        listBridgeBase.addAll(getSetWithStartsWith(blocks, "balustrade_"));

        this.tag(getTag(Bridges.modid, "stone_bridges")).add((Block[]) listBridgeBase.toArray());
        this.tag(getTag(Bridges.modid, "stone_piers")).add((Block[]) getSetWithContain(blocks, "bridge_pier").toArray());
        this.tag(getTag(Bridges.modid, "stone_stairs")).add((Block[]) getSetWithContain(blocks, "bridge_stair").toArray());
    }

    public void mcwDoorsTagsWood(String modid, List<String> MAT)
    {
        Set<Block> blocks = new HashSet<>();
        addBlocks(modid, MAT, blocks, McwBlocksIdBase.DOORS_WOOD_BLOCKS);

        Block[] blockArray = (Block[]) blocks.toArray();
        this.tag(BlockTags.WOODEN_DOORS).add(blockArray);

        Map<String, String> moddedTag = new HashMap<>();
        moddedTag.put("bamboo", "bamboo");
        moddedTag.put("barn", "barn");
        moddedTag.put("barn_glass", "barn_glass");
        moddedTag.put("beach", "beach");
        moddedTag.put("classic", "classic");
        moddedTag.put("cottage", "cottage");
        moddedTag.put("four_panel", "four_panel");
        moddedTag.put("glass", "glass");
        moddedTag.put("modern", "modern");
        moddedTag.put("mystic", "mystic");
        moddedTag.put("nether", "nether");
        moddedTag.put("paper", "paper");
        moddedTag.put("shoji", "japanese");
        moddedTag.put("shoji_whole", "japanese2");
        moddedTag.put("stable", "stable");
        moddedTag.put("stable_head", "stable_head");
        moddedTag.put("swamp", "swamp");
        moddedTag.put("tropical", "tropical");
        moddedTag.put("waffle", "waffle");
        moddedTag.put("western", "western");
        moddedTag.put("whispering", "whispering");

        for(Map.Entry<String, String> map : moddedTag.entrySet())
        {
            Block[] blocks2 = new Block[MAT.size()];
            for(String mat : MAT)
            {
                Block block = Finder.findBlock(modid, mat + "_" + map.getValue() + "_door");
                blocks2[MAT.indexOf(mat)] = block;
            }
            ITag.INamedTag<Block> tag = getTag(Doors.modid, map.getKey() + "_doors");
            this.tag(tag).add(blocks2);
        }
    }

    public void mcwTrapdoorsTagsWood(String modid, List<String> MAT)
    {
        Set<Block> blocks = new HashSet<>();
        addBlocks(modid, MAT, blocks, McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS);

        Block[] blockArray = (Block[]) blocks.toArray();
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(blockArray);

        Map<String, String> moddedTag = new HashMap<>();
        moddedTag.put("bamboo", "bamboo");
        moddedTag.put("bark", "bark");
        moddedTag.put("barn", "barn");
        moddedTag.put("barred", "barred");
        moddedTag.put("barrel", "barrel");
        moddedTag.put("beach", "beach");
        moddedTag.put("cottage", "cottage");
        moddedTag.put("four_panel", "four_panel");
        moddedTag.put("glass", "glass");
        moddedTag.put("mystic", "mystic");
        moddedTag.put("paper", "paper");
        moddedTag.put("ranch", "ranch");
        moddedTag.put("swamp", "swamp");
        moddedTag.put("tropical", "tropical");
        moddedTag.put("waffle", "blossom");
        moddedTag.put("whispering", "whispering");

        for(Map.Entry<String, String> map : moddedTag.entrySet())
        {
            Block[] blocks2 = new Block[MAT.size()];
            for(String mat : MAT)
            {
                Block block = Finder.findBlock(modid, mat + "_" + map.getValue() + "_trapdoor");
                blocks2[MAT.indexOf(mat)] = block;
            }
            ITag.INamedTag<Block> tag = getTag(Doors.modid, map.getKey() + "_trapdoors");
            this.tag(tag).add(blocks2);
        }
    }

    public static ITag.INamedTag<Block> getTag(String id, String tagName)
    {
        return BlockTags.createOptional(new ResourceLocation(id, tagName));
    }

    private List<Block> getSetWithContain(Set<Block> blocks, String contain)
    {
        List<Block> finalBlocks = new ArrayList<>();
        for(Block block : blocks)
        {
            if(Objects.requireNonNull(block.getRegistryName()).getPath().contains(contain))
            {
                finalBlocks.add(block);
            }
        }
        return finalBlocks;
    }

    private List<Block> getSetWithEndsWith(Set<Block> blocks, String endsWith)
    {
        List<Block> finalBlocks = new ArrayList<>();
        for(Block block : blocks)
        {
            if(Objects.requireNonNull(block.getRegistryName()).getPath().endsWith(endsWith))
            {
                finalBlocks.add(block);
            }
        }
        return finalBlocks;
    }

    private List<Block> getSetWithStartsWith(Set<Block> blocks, String startsWith)
    {
        List<Block> finalBlocks = new ArrayList<>();
        for(Block block : blocks)
        {
            if(Objects.requireNonNull(block.getRegistryName()).getPath().startsWith(startsWith))
            {
                finalBlocks.add(block);
            }
        }
        return finalBlocks;
    }

    private void addBlocks(String modid, List<String> MAT, Set<Block> blockSet, McwBlockIdBase blocks)
    {
        for(String mat : MAT)
        {
            for(BlockId blockId : blocks.blocks())
            {
                String id = McwBlocksIdBase.replacement(blockId.id(), mat);
                Block block = Finder.findBlock(modid, id);
                blockSet.add(block);
            }
        }
    }
}