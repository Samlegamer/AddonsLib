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
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public abstract class McwBlockTags extends BlockTagsProvider
{
    public McwBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
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

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocksWood.stream().toList()));

        this.tag(BlockTags.WALLS)
                .add(getSetWithEndsWith(blocksWood, "_window2"))
                .add( getSetWithEndsWith(blocksWood, "_window"));
        this.tag(getTag(Windows.modid, "blinds")).add(getSetWithEndsWith(blocksWood, "_blinds"));
        this.tag(getTag(Windows.modid, "curtain_rods")).add(getSetWithEndsWith(blocksWood, "_curtain_rod"));
        this.tag(getTag(Windows.modid, "parapets")).add(getSetWithEndsWith(blocksWood, "_log_parapet"));
        this.tag(getTag(Windows.modid, "shutters")).add(getSetWithEndsWith(blocksWood, "_shutter"));
        this.tag(getTag(Windows.modid, "windows_four")).add(getSetWithEndsWith(blocksWood, "_four_window"));
        this.tag(getTag(Windows.modid, "windows_two")).add(getSetWithEndsWith(blocksWood, "_window2"));
        this.tag(getTag(Windows.modid, "windows")).add(getSetWithEndsWith(blocksWood, "_window"));
    }

    public void mcwStairsTags(String modid, List<String> WOOD)
    {
        Set<Block> blocksWood = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.STAIRS_WOOD_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocksWood.stream().toList()));

        this.tag(getTag(Stairs.modid, "balconies")).add(getSetWithEndsWith(blocksWood, "_balcony"));
        this.tag(getTag(Stairs.modid, "bulk_stairs")).add(getSetWithEndsWith(blocksWood, "_bulk_stairs"));
        this.tag(getTag(Stairs.modid, "compact_stairs")).add(getSetWithEndsWith(blocksWood, "_compact_stairs"));
        this.tag(getTag(Stairs.modid, "loft_stairs")).add(getSetWithEndsWith(blocksWood, "_loft_stairs"));
        this.tag(getTag(Stairs.modid, "platforms")).add(getSetWithEndsWith(blocksWood, "_platform"));
        this.tag(getTag(Stairs.modid, "railings")).add(getSetWithEndsWith(blocksWood, "_railing"));
        this.tag(getTag(Stairs.modid, "skyline_stairs")).add(getSetWithEndsWith(blocksWood, "_skyline_stairs"));
        this.tag(getTag(Stairs.modid, "terrace_stairs")).add(getSetWithEndsWith(blocksWood, "_terrace_stairs"));
    }

    public void mcwRoofsTags(String modid, List<String> WOOD, List<String> STONE)
    {
        Set<Block> blocksWood = new HashSet<>();
        Set<Block> blocksStone = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.ROOFS_WOOD_BLOCKS);
        addBlocks(modid, STONE, blocksStone, McwBlocksIdBase.ROOFS_STONE_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocksWood.stream().toList()));

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(listToArray(blocksStone.stream().toList()));
    }

    public void mcwPathsTags(String modid, List<String> WOOD)
    {
        List<Block> blocksWood = new ArrayList<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.PATHS_WOOD_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocksWood.stream().toList()));

        this.tag(getTag(Paths.modid, "wooden_paths")).add(listToArray(blocksWood));
    }

    public void mcwFurnituresTags(String modid, List<String> WOOD)
    {
        Set<Block> blocksWood = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.FURNITURES_WOOD_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocksWood.stream().toList()));

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
        map.put("kitchen_sink", Collections.singletonList("_kitchen_sink"));

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
            this.tag(getTag(Furnitures.modid, mapEntry.getKey())).add(listToArray(blocks));
        }
    }

    public void mcwFencesTags(String modid, List<String> WOOD, List<String> LEAVE, List<String> STONE)
    {
        Set<Block> blocksWood = new HashSet<>();
        List<Block> blocksLeave = new ArrayList<>();
        Set<Block> blocksStone = new HashSet<>();

        addBlocks(modid, WOOD, blocksWood, McwBlocksIdBase.FENCES_WOOD_BLOCKS);
        addBlocks(modid, LEAVE, blocksLeave, McwBlocksIdBase.FENCES_LEAVE_BLOCKS);
        addBlocks(modid, STONE, blocksStone, McwBlocksIdBase.FENCES_STONE_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocksWood.stream().toList()));

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(listToArray(blocksStone.stream().toList()));

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(listToArray(blocksLeave.stream().toList()));

        Block[] picket_fences = getSetWithContain(blocksWood, "picket_fence");
        Block[] stockade_fences = getSetWithContain(blocksWood, "stockade_fence");
        Block[] horse_fences = getSetWithContain(blocksWood, "horse_fence");
        Block[] wired_fences = getSetWithContain(blocksWood, "wired_fence");
        Block[] highley_gates = getSetWithContain(blocksWood, "highley_gate");
        Block[] pyramid_gates = getSetWithContain(blocksWood, "pyramid_gate");
        Block[] curved_gates = getSetWithContain(blocksWood, "curved_gate");

        Block[] hedges = listToArray(blocksLeave);

        Block[] modern_wall = getSetWithStartsWith(blocksStone, "modern_");
        Block[] railing_wall = getSetWithStartsWith(blocksStone, "railing_");
        Block[] railing_gate = getSetWithEndsWith(blocksStone, "_railing_gate");
        Block[] pillar_wall = getSetWithEndsWith(blocksStone, "_pillar_wall");
        Block[] grass_topped_wall = getSetWithEndsWith(blocksStone, "_grass_topped_wall");

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
        Set<Block> blocksWood = new HashSet<>();
        addBlocks(modid, MAT, blocksWood, McwBlocksIdBase.BRIDGES_WOOD_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocksWood.stream().toList()));

        this.tag(getTag(Bridges.modid, "log_bridges")).add(getSetWithContain(blocksWood, "log_bridge_middle"));
        this.tag(getTag(Bridges.modid, "log_stairs")).add(getSetWithContain(blocksWood, "log_bridge_stair"));
        this.tag(getTag(Bridges.modid, "rail_bridges")).add(getSetWithContain(blocksWood, "rail_bridge"));
        this.tag(getTag(Bridges.modid, "rope_bridges")).add(getSetWithStartsWith(blocksWood, "rope_"));
        this.tag(getTag(Bridges.modid, "rope_stairs")).add(getSetWithContain(blocksWood, "rope_bridge_stair"));
        this.tag(getTag(Bridges.modid, "wooden_piers")).add(getSetWithContain(blocksWood, "bridge_pier"));
    }

    public void mcwBridgesTagsStone(String modid, List<String> MAT)
    {
        Set<Block> blocks = new HashSet<>();
        addBlocks(modid, MAT, blocks, McwBlocksIdBase.BRIDGES_STONE_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(listToArray(blocks.stream().toList()));

        this.tag(getTag(Bridges.modid, "stone_bridges")).add(getSetWithEndsWith(blocks, "_bridge"));
        this.tag(getTag(Bridges.modid, "stone_piers")).add(getSetWithContain(blocks, "bridge_pier"));
        this.tag(getTag(Bridges.modid, "stone_stairs")).add(getSetWithContain(blocks, "bridge_stair"));
    }

    public void mcwDoorsTagsWood(String modid, List<String> MAT)
    {
        List<Block> blocks = new ArrayList<>();
        addBlocks(modid, MAT, blocks, McwBlocksIdBase.DOORS_WOOD_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocks.stream().toList()));

        Block[] blockArray = listToArray(blocks);
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
            TagKey<Block> tag = getTag(Doors.modid, map.getKey() + "_doors");
            this.tag(tag).add(blocks2);
        }
    }

    public void mcwTrapdoorsTagsWood(String modid, List<String> MAT)
    {
        List<Block> blocks = new ArrayList<>();
        addBlocks(modid, MAT, blocks, McwBlocksIdBase.TRAPDOORS_WOOD_BLOCKS);

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(listToArray(blocks.stream().toList()));

        Block[] blockArray = listToArray(blocks);
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
            TagKey<Block> tag = getTag(Doors.modid, map.getKey() + "_trapdoors");
            this.tag(tag).add(blocks2);
        }
    }

    public static TagKey<Block> getTag(String id, String tagName)
    {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(id, tagName));
    }

    private Block[] getSetWithContain(Set<Block> blocks, String contain)
    {
        List<Block> finalBlocks = new ArrayList<>();
        for(Block block : blocks)
        {
            if(Objects.requireNonNull(block.asItem().toString()).contains(contain))
            {
                finalBlocks.add(block);
            }
        }
        return listToArray(finalBlocks);
    }

    private Block[] getSetWithEndsWith(Set<Block> blocks, String endsWith)
    {
        List<Block> finalBlocks = new ArrayList<>();
        for(Block block : blocks)
        {
            if(Objects.requireNonNull(block.asItem().toString()).endsWith(endsWith))
            {
                finalBlocks.add(block);
            }
        }
        return listToArray(finalBlocks);
    }

    private Block[] getSetWithStartsWith(Set<Block> blocks, String startsWith)
    {
        List<Block> finalBlocks = new ArrayList<>();
        for(Block block : blocks)
        {
            if(Objects.requireNonNull(block.asItem().toString()).startsWith(startsWith))
            {
                finalBlocks.add(block);
            }
        }
        return listToArray(finalBlocks);
    }

    private Block[] listToArray(List<Block> finalBlocks)
    {
        Block[] blockArray = new Block[finalBlocks.size()];

        for(int i = 0; i < finalBlocks.size(); i++)
        {
            blockArray[i] = finalBlocks.get(i);
        }
        return blockArray;
    }
    
    private void addBlocks(String modid, List<String> MAT, Collection<Block> blockSet, McwBlockIdBase blocks)
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